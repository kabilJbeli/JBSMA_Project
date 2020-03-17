package com.comptabilite.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.comptabilite.dao.EncaissementManagementLocal;
import com.comptabilite.entities.Encaissement;
import com.comptabilite.entities.Facture;
import com.comptabilite.service.ServiceFactureLocal;
import com.contrat.dao.ConfProduitLocal;
import com.contrat.dao.ContratManagementLocal;
import com.contrat.dao.EchanceManagementLocal;
import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;
import com.contrat.entities.Produit;
import com.contrat.service.ServiceContratLocal;
import com.tier.entities.Tier;
import com.tier.dao.TierManagement;
import com.tier.dao.TierManagementLocal;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;


 
@ManagedBean(name = "FactureBean")
@RequestScoped
@Stateless
public class CreationFactureControlleur {
	@EJB
	ConfProduitLocal serviceProduit;
	@EJB
	ServiceContratLocal serviceContrat;
	@EJB
	TierManagementLocal daotier;
	@EJB
	ContratManagementLocal daoContrat;
	@EJB
	EchanceManagementLocal daoEcheance;
	@EJB 
	ServiceFactureLocal daoFacture;
	public List<Tier> searchedTiers;
    private String numeroContrat;


	private double Mtfinancement;


	private List<Echeance> echeanceLists;
	


	public ConfProduitLocal getDaoproduit() {
		return serviceProduit;
	}

	public ServiceContratLocal getDaocontrat() {
		return serviceContrat;
	}
	public void setDaocontrat(ServiceContratLocal daocontrat) {
		this.serviceContrat = daocontrat;
	}


	public double getMtfinancement() {
		return Mtfinancement;
	}
	public void setMtfinancement(double mtfinancement) {
		Mtfinancement = mtfinancement;
	}


	

	public void findEcheances(){
	Contrat C =	serviceContrat.RechercheContratParNumero(this.numeroContrat);
	if(C != null) {
	this.echeanceLists = daoEcheance.RechercheEcheanceparDateContrat(C);
	}else {
	this.echeanceLists = null;
	}
	} 
	public List<Echeance> getEcheanceLists() {
		return echeanceLists;
	}
	public void setEcheanceLists(List<Echeance> echeanceLists) {
		this.echeanceLists = echeanceLists;
	}
	public String getNumeroContrat() {
		return numeroContrat;
	}
	public void setNumeroContrat(String numeroContrat) {
		this.numeroContrat = numeroContrat;
	}
	public void createFacture(int idech) {
		Echeance E = daoEcheance.RechercheEcheance(Integer.valueOf(idech));
		if(E != null) {
		Facture facture = new Facture();
		facture.setDATEEFFET(E.getDATEECHEANCE());
		facture.setECHEANCE(E);
		facture.setMTCOM(E.getMTTCOMM());
		facture.setMTTTC(E.getMTTTC());
		facture.setStatus(0);
		E.setStatus(1);
		daoEcheance.Modify(E);
		daoFacture.CreationFacture(facture);}
	
	}

}