package com.contrat.service;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.contrat.dao.ContratManagementLocal;
import com.contrat.dao.DAOConfProduit;
import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;
import com.contrat.entities.Produit;

/**
 * Session Bean implementation class ServiceContrat
 */
@Stateless
@LocalBean
public class ServiceContrat implements ServiceContratLocal {
	@EJB
	ContratManagementLocal daoContrat;
	DAOConfProduit daoConfProduit;


    public ServiceContrat() {
    }
    
    @Override
    public List<Echeance> CalculeMensualite(Contrat contrat) {
    	double montantfinancement = contrat.getMTFINANCEMENT();
//    	Produit produit = contrat.getProduit();
//    	double tauxinteret = Math.IEEEremainder(produit.getTAUXCOMM(),100);
    	double tauxinteret = Math.IEEEremainder(10,100);
    	List<Echeance> echances = new LinkedList<Echeance>();
    	int duree = contrat.getDUREE();
    	
    	for (int i = 0;i<duree;i++) {
    		Echeance echeance = new Echeance();
    		double mensualite = (montantfinancement * (tauxinteret/12))/ (1 - (1 + Math.pow((tauxinteret/12), - duree)));
    		echeance.setMTTTC(mensualite);
    		echances.add(echeance);
    	}
		return echances;
    	
    }
    
    @Override
    public void CreationContrat (Contrat contrat/*,String codeProduit,String cinTiers*/) {
    	//Produit config = daoConfProduit.rechercheProduit(codeProduit);
    	//TODO get tiers information
    	contrat.setEcheances(CalculeMensualite(contrat));
    	daoContrat.creation(contrat);


    }
    
    public static void main (String[]args) {
    	Contrat contrat = new Contrat();
    	contrat.setMTFINANCEMENT(300000);
    	contrat.setDUREE(10);
    	ServiceContrat serviceContrat = new ServiceContrat();
    	serviceContrat.CreationContrat(contrat);
    }

}
