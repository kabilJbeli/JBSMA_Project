package com.comptabilite.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.comptabilite.entities.Facture;
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

}
