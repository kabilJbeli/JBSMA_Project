package com.contrat.dao;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;

import com.contrat.entities.Contrat;

@Local
public interface ContratManagementLocal {
	public void delete(Contrat c);
	public void update(Contrat c);
	public Contrat findByName(String name);
	public void creation (Contrat c);
	public List<Contrat> contractList();
	public BigInteger getNext();
}
