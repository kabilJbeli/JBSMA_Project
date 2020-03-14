package com.comptabilite.controller;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.comptabilite.entities.Encaissement;
import com.comptabilite.entities.Facture;
import com.comptabilite.service.ServiceEncaissementLocal;
import com.comptabilite.service.ServiceFactureLocal;
import com.contrat.service.ServiceContratLocal;

@ManagedBean(name = "Facturation")
@SessionScoped
@Stateful
public class EncaissementFactureController {
	@EJB
	ServiceFactureLocal ServiceFacture;
	@EJB
	ServiceContratLocal serviceContrat;
	@EJB
	ServiceEncaissementLocal ServiceEncaissement;
	List<Facture> factures;
	Facture facture;
	String numeroContrat;

	public ServiceFactureLocal getServiceFacture() {
		return ServiceFacture;
	}

	public void setServiceFacture(ServiceFactureLocal serviceFacture) {
		ServiceFacture = serviceFacture;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public String getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(String numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public List<Facture> getListFactureByContrat() {
		if (!numeroContrat.equals("")) {
			ServiceFacture.RechercheFactureparContract(serviceContrat.RechercheContratParNumero(numeroContrat));
		return factures;
		}
		return null;
	}
	
	public void encaisseFacture(Facture facture) {
		Encaissement encaissement = new Encaissement();
		encaissement.setDATEENCAISSEMENT(LocalDate.now());
		encaissement.setDESCRIPTION("Encaissement pour la facture"+facture.getIDFACTURE());
		encaissement.setFacture(facture);
		encaissement.setSIGNE(1);
		encaissement.setSTATUS(2);
		encaissement.setMTCOM(facture.getMTCOM());
		encaissement.setMTTTC(facture.getMTTTC());
		facture.setStatus(1);
		ServiceFacture.modificationFacture(facture);
		ServiceEncaissement.creationEncaissement(encaissement);
	}

}
