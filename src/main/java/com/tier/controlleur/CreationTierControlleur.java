package com.tier.controlleur;

import javax.ejb.EJB;

import com.tier.dao.TierManagementLocal;
import com.tier.entities.Tier;

public class CreationTierControlleur {
	@EJB
	TierManagementLocal daotier;
    private Tier tiers;
    private TierManagementLocal tierM;
}
