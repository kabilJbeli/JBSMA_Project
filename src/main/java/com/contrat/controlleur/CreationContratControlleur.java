package com.contrat.controlleur;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;

import com.contrat.dao.ConfProduitLocal;
import com.contrat.dao.ContratManagementLocal;
import com.contrat.entities.Contrat;
import com.contrat.entities.Produit;
import com.contrat.service.ServiceContratLocal;
import com.tier.entities.Tier;
import com.tier.dao.TierManagement;
import com.tier.dao.TierManagementLocal;


 
@ManagedBean(name = "CreationContrat")
@RequestScoped
@Stateless
public class CreationContratControlleur {
	@EJB
	ConfProduitLocal daoproduit;
	@EJB
	ServiceContratLocal daocontrat;
	@EJB
	TierManagementLocal daotier;
	public List<Tier> serachedTiers;
    private Produit produit;
    private double Mtfinancement;
    private LocalDate DateEffet;
    private LocalDate DateEcheance;
    private LocalDate DateFin;
    private Tier tiers =  new Tier();
    private String tierInputValue;
    private Integer selectedTierId;
    public Integer getSelectedTierId() {
		return selectedTierId;
	}
	public void setSelectedTierId(Integer selectedTierId) {
		this.selectedTierId = selectedTierId;
	}
	public Boolean getUpdateFindTier() {
		return updateFindTier;
	}
	public void setUpdateFindTier(Boolean updateFindTier) {
		this.updateFindTier = updateFindTier;
	}
	private String tierName;
    private Boolean updateFindTier=true;
    public Integer getTierCIN() {
		return tierCIN;
	}
	public void setTierCIN(Integer tierCIN) {
		this.tierCIN = tierCIN;
	}
	private Integer tierCIN;
    

	public String getTierName() {
		return tierName;
	}
	public void setTierName(String tierName) {
		this.tierName = tierName;
	}
	public ConfProduitLocal getDaoproduit() {
		return daoproduit;
	}
	public void setDaoproduit(ConfProduitLocal daoproduit) {
		this.daoproduit = daoproduit;
	}
    public TierManagementLocal getDaotier() {
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
	public List<Produit> getProduits() throws ParseException {
//		Contrat contrat = new Contrat();
//		contrat.setProduit(daoproduit.rechercheProduits().get(0));
//		contrat.setDATEDEBUT(LocalDate.now());
//		contrat.setTier(daotier.getAll().get(0));
//		contrat.setMTFINANCEMENT(100000);
//		contrat.setDUREE(240);
//		contrat.setDATEDEBUT(LocalDate.now());
//		daocontrat.CreationContrat(contrat);
		return daoproduit.rechercheProduits();
	}
	
	public void getListTiersByName() {
		if(!tierName.isEmpty()) {
			this.updateFindTier = false;
	this.serachedTiers = daotier.findByName(String.valueOf(tierName));
		}
	}
	
	
	public void getListTiersByCIN() {
		if(tierCIN != null) {
			this.updateFindTier = false;
	this.serachedTiers = daotier.findByCIN(tierCIN);
		}
	}
	
	public List<Tier> getSearchedTier(){
		return serachedTiers;
	}
	
	public List<Tier> getListTiers() {
		return daotier.getAll();
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
	public void CreationNouveauxContrat() throws ParseException {
		Contrat contrat = new Contrat();
		contrat.setDATEDEBUT(DateEffet);
		contrat.setDATEFIN(DateFin);
		contrat.setDATEECHEANCE(DateEcheance);
		contrat.setMTFINANCEMENT(Mtfinancement);
		try {
			daocontrat.CreationContrat(contrat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getTierInputValue() {
		return tierInputValue;
	}
	public void setTierInputValue(String tierInputValue) {
		this.tierInputValue =  tierInputValue;
	}
	public void updateSeletedTier() {
		if(selectedTierId != null) {
	this.tiers = (Tier) daotier.findByCIN(selectedTierId);
		}
		
	}
   
}