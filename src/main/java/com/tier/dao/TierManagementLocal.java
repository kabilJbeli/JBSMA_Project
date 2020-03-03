package com.tier.dao;

import com.contrat.entities.Tier;

public interface TierManagementLocal {
	public void delete(Tier T);
	public Tier update(Tier T);
	public void creation (Tier T);
	public Tier findByCIN(Integer CIN);
}
