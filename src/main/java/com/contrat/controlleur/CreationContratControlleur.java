package com.contrat.controlleur;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.contrat.dao.ConfProduitLocal;
import com.contrat.dao.ContratManagementLocal;
import com.contrat.entities.Contrat;
import com.contrat.entities.Produit;
import com.contrat.service.ServiceContratLocal;
import com.tier.entities.Tier;
import com.tier.dao.TierManagement;


 
@ManagedBean(name = "CreationContrat")
@RequestScoped
@Stateless
public class CreationContratControlleur {
	@EJB
	ConfProduitLocal daoproduit;
	@EJB
	ServiceContratLocal daocontrat;
	@EJB
	TierManagement daotier;
	private List<Produit> produits;
    private Produit produit;
    private double Mtfinancement;
    private LocalDate DateEffet;
    private LocalDate DateEcheance;
    private LocalDate DateFin;
    private Tier tiers;
   
	public ConfProduitLocal getDaoproduit() {
		return daoproduit;
	}
	public void setDaoproduit(ConfProduitLocal daoproduit) {
		this.daoproduit = daoproduit;
	}
    public TierManagement getDaotier() {
		return daotier;
	}
	public void setDaotier(TierManagement daotier) {
		this.daotier = daotier;
	}
	public ServiceContratLocal getDaocontrat() {
		return daocontrat;
	}
	public void setDaocontrat(ServiceContratLocal daocontrat) {
		this.daocontrat = daocontrat;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Tier getTiers() {
		return tiers;
	}
	public void setTiers(Tier tiers) {
		this.tiers = tiers;
	}
	public List<Produit> getProduits() {
		return daoproduit.rechercheProduits();
	}
	public double getMtfinancement() {
		return Mtfinancement;
	}
	public void setMtfinancement(double mtfinancement) {
		Mtfinancement = mtfinancement;
	}
	
	public LocalDate getDateEffet() {
		return DateEffet;
	}
	public void setDateEffet(LocalDate dateEffet) {
		DateEffet = dateEffet;
	}
	public LocalDate getDateEcheance() {
		return DateEcheance;
	}
	public void setDateEcheance(LocalDate dateEcheance) {
		DateEcheance = dateEcheance;
	}
	public LocalDate getDateFin() {
		return DateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		DateFin = dateFin;
	}
	public void CreationNouveauxContrat() {
		Contrat contrat = new Contrat();
		contrat.setDATEDEBUT(DateEffet);
		contrat.setDATEFIN(DateFin);
		contrat.setMTFINANCEMENT(Mtfinancement);
		daocontrat.CreationContrat(contrat);
	}
   
}