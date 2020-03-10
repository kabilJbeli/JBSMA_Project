package com.tier.controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tier.dao.TierManagementLocal;
import com.tier.entities.Tier;



@ManagedBean(name = "CreationTier")
@RequestScoped
@Stateless
public class CreationTierControlleur {
	@EJB
	TierManagementLocal daotier;
    private Tier tiers = new Tier();
	private String ADRESSETIER;
	private Integer CINTIER;
	private String NAMETIER;
	private String PRENOMTIER;	
	private Boolean iseditable=false;
	
	
	public Boolean getIseditable() {
		return iseditable;
	}

	public void setIseditable(Boolean iseditable) {
		this.iseditable = iseditable;
	}
	public String getADRESSETIER() {
		return ADRESSETIER;
	}

	public void setADRESSETIER(String aDRESSETIER) {
		ADRESSETIER = aDRESSETIER;
	}

	public Integer getCINTIER() {
		return CINTIER;
	}

	public void setCINTIER(Integer cINTIER) {
		CINTIER = cINTIER;
	}

	public String getNAMETIER() {
		return NAMETIER;
	}

	public void setNAMETIER(String nAMETIER) {
		NAMETIER = nAMETIER;
	}

	public String getPRENOMTIER() {
		return PRENOMTIER;
	}

	public void setPRENOMTIER(String pRENOMTIER) {
		this.PRENOMTIER = pRENOMTIER;
	}
	
	public void createTier() {	
		Tier tier = new Tier();
		tier.setADRESSETIER(ADRESSETIER);
		tier.setCINTIER(CINTIER);
		tier.setNAMETIER(NAMETIER);
		tier.setPRENOMTIER(PRENOMTIER);	
		daotier.creation(tier);
	}
    
	public void updateTier() {
		this.iseditable = true;
		
	}
	

	public void deleteTier(Tier tier) {

			daotier.delete(tier);
	
			
		
	}
    public Tier getTiers() {
		return tiers;
	}

    public List<Tier> getAllTiers(){
    	
    	return daotier.getAll();
    }
	public void setTiers(Tier tiers) {
		this.tiers = tiers;
	}
    
}
