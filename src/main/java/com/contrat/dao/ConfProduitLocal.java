package com.contrat.dao;

import java.util.List;

import javax.ejb.Local;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import com.contrat.entities.Produit;

@Local
public interface ConfProduitLocal {
	public Produit rechercheProduit(int IdProduit);
	public List<Produit> rechercheProduits();
	public void Creation (Produit produit);
	public void delete (Produit produit);
	public void modifier(Produit produit);
}
