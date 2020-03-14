package com.contrat.controlleur;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;

import com.comptabilite.controller.EncaissementFactureController;
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
	ConfProduitLocal serviceProduit;
	@EJB
	ServiceContratLocal serviceContrat;
	@EJB
	TierManagementLocal daotier;
	@EJB
	ContratManagementLocal daoContrat;
	public List<Tier> searchedTiers;
    private Produit produit;
    private double Mtfinancement;
    private LocalDate DateEffet;
    private LocalDate DateEcheance;
    private LocalDate DateFin;
    private Tier tiers =  new Tier();
    private String tierInputValue;
    private Tier selectedTierId;
    private EncaissementFactureController Facture = new EncaissementFactureController();
	public Tier getSelectedTierId() {
		return selectedTierId;
	}
	public void setSelectedTierId(Tier selectedTierId) {
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
		return serviceProduit;
	}
	public void setDaoproduit(ConfProduitLocal daoproduit) {
		this.serviceProduit = daoproduit;
	}
    public TierManagementLocal getDaotier() {
		return daotier;
	}
	public void setDaotier(TierManagement daotier) {
		this.daotier = daotier;
	}
	public ServiceContratLocal getDaocontrat() {
		return serviceContrat;
	}
	public void setDaocontrat(ServiceContratLocal daocontrat) {
		this.serviceContrat = daocontrat;
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
		return serviceProduit.rechercheProduits();
	}
	
	public void getListTiersByName() {
		if(!tierName.isEmpty()) {
			this.updateFindTier = false;
	this.searchedTiers = daotier.findByName(String.valueOf(tierName));
		}
	}
	
	
	public void getListTiersByCIN() {
		if(tierCIN != null) {
			this.updateFindTier = false;
	this.searchedTiers = daotier.findByCIN(tierCIN);
		}
	}
	
	public List<Tier> getSearchedTier(){
		return searchedTiers;
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
		this.DateFin = dateFin;
	}
	public void setNouveauxContrat() throws ParseException {
		Contrat contrat = new Contrat();
		contrat.setTier(selectedTierId);
		contrat.setDATEDEBUT(DateEffet);
		contrat.setDATEFIN(DateFin);
		contrat.setDATEECHEANCE(DateEcheance);
		contrat.setMTFINANCEMENT(Mtfinancement);
		contrat.setProduit(produit);
		try {
			serviceContrat.CreationContrat(contrat);

		}catch(ParseException e) {			
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
	this.tiers = (Tier) daotier.findByCIN(selectedTierId.getCINTIER());
		}		
	}
	
	public List<Contrat> getAllContratList() {
		return daoContrat.contractList();		
	}
	public void updateFactureContractNumber(Contrat con) {
		Facture.setNumeroContrat(con.getNUMEROCONTRAT());		
	}
	
   
}