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
	private List<Facture> factures;
	private List<Facture> facture;
	private String numeroContrat;

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

	public List<Facture> getFacture() {
		return facture;
	}

	public void setFacture(List<Facture> facture) {
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
		this.factures =	ServiceFacture.RechercheFactureparContract(serviceContrat.RechercheContratParNumero(numeroContrat));
		return this.factures;
		}
		return null;
	}

}
