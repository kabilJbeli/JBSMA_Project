package com.contrat.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import com.contrat.dao.ContratManagementLocal;
import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;
import com.contrat.entities.Produit;
import com.tier.entities.Tier;

/**
 * Session Bean implementation class ServiceContrat
 */
@Stateful
@LocalBean
public class ServiceContrat implements ServiceContratLocal {
	@EJB
	ContratManagementLocal daoContrat;
	@EJB
	ServiceEcheanceLocal daoEcheance;


    public ServiceContrat() {
    }
    
    @Override
    public List<Echeance> CalculeMensualite(Contrat contrat) {
    	double montantfinancement = contrat.getMTFINANCEMENT();
    	Produit produit = contrat.getProduit();
    	double tauxinteret = Double.valueOf(produit.getTAUXCOMM()/100);
    	List<Echeance> echances = new LinkedList<Echeance>();
    	int duree = contrat.getDUREE();
    	LocalDate dateechance = contrat.getDATEDEBUT().plusMonths(1);
    	LocalDate dateexigibilite = dateechance.plusDays(15);
    	double mensualitebrute = montantfinancement/duree;
    	double montanttot = 0;
    	for (int i = 0;i<duree;i++) {
    		Echeance echeance = new Echeance();
    		double mensualite = (montantfinancement * (tauxinteret/12))/ (1-( Math.pow((1+tauxinteret/12), - duree)));
    		montanttot = montanttot + mensualite;
    		echeance.setMTTTC(round(mensualite));
    		echeance.setIDCONTRAT(contrat);
    		echeance.setMTTCOMM(round(mensualite-mensualitebrute));
    		echeance.setDATEECHEANCE(dateechance);
    		echeance.setDATEEXIGIBILITE(dateexigibilite);
    		dateechance = dateechance.plusMonths(1);
    		dateexigibilite = dateexigibilite.plusMonths(1);
    		echances.add(echeance);
    	}
		return echances;
    	
    }
    
    public double round(double montant) {
    	DecimalFormat df = new DecimalFormat () ;
    	df.setMaximumIntegerDigits(3);
    	df.setMinimumIntegerDigits(3);
    	df.setDecimalSeparatorAlwaysShown (true);
    	NumberFormat parsedouble = NumberFormat.getInstance();
    	try {
			return parsedouble.parse(df.format(montant)).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return 0;
    }
    
    public double CalculeMontantTotale (List<Echeance> echeances) {
    	double MontantTotale = 0;
    	for (Echeance echeance: echeances) {
    		MontantTotale = MontantTotale + echeance.getMTTTC();
    	}
    	return MontantTotale;
    }
    
    public double calculeMontantInterets(List<Echeance> echeances) {
    	double MontantTotale = 0;
    	for (Echeance echeance: echeances) {
    		MontantTotale = MontantTotale + echeance.getMTTCOMM();
    	}
    	return MontantTotale;
    }
    
    @Override
    public void CreationContrat (Contrat contrat) throws ParseException {
    	contrat.setEcheances(CalculeMensualite(contrat));
    	contrat.setMTTCOM(round(calculeMontantInterets(contrat.getEcheances())));
    	contrat.setMTTTC(round(CalculeMontantTotale(contrat.getEcheances())));
    	contrat.setDATEDEBUT(contrat.getDATEDEBUT().plusMonths(1));
    	daoContrat.creation(contrat);


    }

}
