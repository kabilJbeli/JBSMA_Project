package com.tier.dao;

import com.contrat.entities.Tier;

public interface TierManagementLocal {
	public void delete(Tier T);
	public int update(Tier T);
	public Tier findByName(String name);
	public void creation (Tier T);
}
