package com.contrat.controlleur;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.contrat.dao.ConfProduitLocal;
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
    private String description;
    private double tauxcomm;
   private Boolean iseditable=false;

	public Boolean getIseditable() {
	return iseditable;
}
public void setIseditable(Boolean iseditable) {
	this.iseditable = iseditable;
}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTauxcomm() {
		return tauxcomm;
	}
	public void setTauxcomm(double tauxcomm) {
		this.tauxcomm = tauxcomm;
	}
	public ConfigurationProduitControlleur() {

	}

public void createProduct() {	
	Produit newProduct = new Produit();
	newProduct.setDESCRIPTION(description);
	newProduct.setTAUXCOMM(tauxcomm);
	newProduct.setIseditable(iseditable);
	serviceProduit.Creation(newProduct);
	this.description="";
	this.tauxcomm=0.0;	
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
	
	public void setProductEditable(Produit produit) {
		produit.setIseditable(true);
		serviceProduit.Modifier(produit);		
	}
	public void modifierProduit (Produit produit) {
		produit.setDESCRIPTION(description);
		produit.setTAUXCOMM(tauxcomm);
		produit.setIseditable(false);
		serviceProduit.Modifier(produit);	
	}
	
	public void delete(Produit produit) {
			serviceProduit.Delete(produit);	
	}

}
