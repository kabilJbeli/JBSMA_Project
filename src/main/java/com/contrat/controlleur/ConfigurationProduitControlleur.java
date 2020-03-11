package com.contrat.controlleur;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.contrat.entities.Produit;
import com.contrat.service.ServiceProduitLocal;
import java.io.Serializable;

@ManagedBean(name="ConfigurationProduit")
@javax.faces.bean.SessionScoped
public class ConfigurationProduitControlleur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ServiceProduitLocal serviceProduit;
	private Produit produit;
	private List<Produit> produits;
	private boolean Modified = false;
	
	public ConfigurationProduitControlleur() {
		//produit = new Produit();
	}


	public ServiceProduitLocal getDaoproduit() {
		return serviceProduit;
	}


	public void setDaoproduit(ServiceProduitLocal daoproduit) {
		this.serviceProduit = daoproduit;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public List<Produit> getProduits() {
		return serviceProduit.rechercheProduits();
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
	
	public void tobeModified (Produit produit) {
		this.produit = produit;
		setModified(true);
	}


	public boolean isModified() {
		return Modified;
	}


	public void setModified(boolean tobeModified) {
		this.Modified = tobeModified;
	}
	
	public void modifierProduit (Produit produit) {
		serviceProduit.Modifier(produit);
		setModified(true);
	}
	

}
