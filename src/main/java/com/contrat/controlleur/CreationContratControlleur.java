package com.contrat.controlleur;

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
	@EJB
	EchanceManagementLocal daoEcheance;
	public List<Tier> searchedTiers;
    private Produit produit;
    private int idProduit;
    public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	private double Mtfinancement;
    private LocalDate DateEffet;
    private LocalDate DateEcheance;
    private LocalDate DateFin;
    private Tier tiers =  new Tier();
    private String tierInputValue;
    private String selectedTierId;
    private String TierName;
    private Boolean updateFindTier=true;
	private Integer tierCIN;
	private String description;
	private int DUREE;
	public int getDUREE() {
		return DUREE;
	}
	public void setDUREE(int dUREE) {
		DUREE = dUREE;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	private int updateSelectedContract;   
	public Date getDateEffetd() {
		return dateEffetd;
	}

	private Date dateEffetd;
	private Date dateFind;
	private boolean showEcheancePanel=false;
	private List<Echeance> echeanceListForSelectContract;
	
	public boolean getShowEcheancePanel() {
		return showEcheancePanel;
	}
	public void setShowEcheancePanel(boolean showEcheancePanel) {
		this.showEcheancePanel = showEcheancePanel;
	}
	public String getSelectedTierId() {
		return selectedTierId;
	}
	public Date getDateFind() {
		return dateFind;
	}
	public void setSelectedTierId(String selectedTierId) {
		this.selectedTierId = selectedTierId;
	}
	public Boolean getUpdateFindTier() {
		return updateFindTier;
	}
	public void setUpdateFindTier(Boolean updateFindTier) {
		this.updateFindTier = updateFindTier;
	}
	
    public Integer getTierCIN() {
		return tierCIN;
	}
	public void setTierCIN(Integer tierCIN) {
		this.tierCIN = tierCIN;
	}

	public String getTierName() {
		return TierName;
	}
	public void setTierName(String tierName) {
		this.TierName = tierName;
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
	

	public List<Tier> getsearchedTiers(){
		return searchedTiers;
	}
	
	public void setsearchedTiers(List<Tier> searchedTiers){
		this.searchedTiers = searchedTiers;
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
	public void setDateEffetd(Date dateEffetd) {
		this.dateEffetd =dateEffetd;
		LocalDateTime localDateTime = dateEffetd.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		this.DateEffet = localDateTime.toLocalDate();
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
	public void setDateFind(Date dateFind) {
		this.dateFind =dateFind;
		LocalDateTime localDateTime = dateFind.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		this.DateFin = localDateTime.toLocalDate();
		
	}
	public void setNouveauxContrat() throws ParseException {
		Tier T = new Tier();
		T = daotier.findByCIN(selectedTierId);
		Produit p = new Produit();
		p = serviceProduit.rechercheProduit(idProduit);		
		Period addedPeriod = Period.ofMonths(DUREE);
		DateFin = DateEffet.plus(addedPeriod);		    
		Contrat contrat = new Contrat();
		contrat.setTierByCin(T);
		contrat.setDATEDEBUT(DateEffet);
		contrat.setDATEECHEANCE(DateEcheance);
		contrat.setMTFINANCEMENT(Mtfinancement);
		contrat.setDESCRIPTION(description);
		contrat.setProduit(p);
		contrat.setDATEFIN(DateFin);
		contrat.setDUREE(DUREE);
		String numeroContrat = String.valueOf(p.getIDCONF()) + String.valueOf(T.getIDTIER()) + serviceContrat.getNext();
		contrat.setNUMEROCONTRAT(numeroContrat);
		try {
			serviceContrat.CreationContrat(contrat);
			FacesContext.getCurrentInstance().addMessage("CreationContrat", new FacesMessage("A new contract entity has been created with  the following number:"+contrat.getNUMEROCONTRAT()));

		}catch(ParseException e) {			
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("CreationContrat", new FacesMessage("An error occured while creating the contract"));

		}
	}
	public String getTierInputValue() {
		return tierInputValue;
	}
	public void setTierInputValue(String tierInputValue) {
		this.tierInputValue =  tierInputValue;
	}
	public void updateSeletedTier() {
	this.tiers = daotier.findByCIN(selectedTierId);
		
	}
	
	public int getUpdateSelectedContract() {
		return updateSelectedContract;
	}
	public void setUpdateSelectedContract(int updateSelectedContract) {
		this.updateSelectedContract = updateSelectedContract;
	}
	public List<Contrat> getAllContratList() {
		return daoContrat.contractList();		
	}
	public void updateSelectedContractId(Contrat con) {
		if(con != null) {
		this.updateSelectedContract = con.getIDCONTRAT();	
		this.setShowEcheancePanel(true);
		setEcheanceListForSelectContract(daoEcheance.RechercheEcheanceparDateContrat(con));
		}
	}
	public List<Echeance> getEcheanceListForSelectContract() {
		return echeanceListForSelectContract;
	}
	public void setEcheanceListForSelectContract(List<Echeance> echeanceListForSelectContract) {
		this.echeanceListForSelectContract = echeanceListForSelectContract;
	}

}