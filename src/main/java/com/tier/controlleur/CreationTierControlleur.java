package com.tier.controlleur;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.tier.dao.TierManagementLocal;
import com.tier.entities.Tier;

@ManagedBean(name = "CreationTier")
@RequestScoped
@Stateless
public class CreationTierControlleur {
	@EJB
	TierManagementLocal daotier;
    private Tier tiers;
	private String ADRESSETIER;
	private Integer CINTIER;
	private String NAMETIER;
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
		PRENOMTIER = pRENOMTIER;
	}
	private String PRENOMTIER;
	
	public void createTier() {	
		Tier tier = new Tier();
				tier.setADRESSETIER(ADRESSETIER);
		tier.setCINTIER(CINTIER);
		tier.setNAMETIER(NAMETIER);
		tier.setPRENOMTIER(PRENOMTIER);	
		daotier.creation(tier);
	}
    
    public Tier getTiers() {
		return tiers;
	}
	public void setTiers(Tier tiers) {
		this.tiers = tiers;
	}
    
}
