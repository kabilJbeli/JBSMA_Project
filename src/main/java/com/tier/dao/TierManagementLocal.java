package com.tier.dao;

import javax.ejb.Local;

import com.tier.entities.Tier;
@Local
public interface TierManagementLocal {
	public void delete(Tier T);
	public void update(Tier T);
	public Tier findByName(String name);
	public void creation (Tier T);
}
