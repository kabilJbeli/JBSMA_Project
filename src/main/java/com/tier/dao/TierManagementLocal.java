package com.tier.dao;

import java.util.List;
import javax.ejb.Local;
import com.tier.entities.Tier;

@Local
public interface TierManagementLocal {
	public void delete(Tier T);
	public void update(Tier T);
	public List<Tier> findByName(String name);
	public List<Tier> getAll();
	public void creation (Tier T);
}