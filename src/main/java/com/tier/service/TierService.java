package com.tier.service;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.tier.dao.TierManagementLocal;
import com.tier.entities.Tier;

/**
 * Session Bean implementation class TierService
 */
@Stateless
@LocalBean
public class TierService implements TierServiceLocal {
	@EJB
	TierManagementLocal daoTier;

    /**
     * Default constructor. 
     */
    public TierService() {
        // TODO Auto-generated constructor stub
    }
    
    public void CreatioTiers (Tier tier) {
    	daoTier.creation(tier);
    }

}
