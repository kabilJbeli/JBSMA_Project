package com.contrat.dao;

import java.util.List;

import javax.ejb.Local;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;

import com.contrat.entities.Produit;

@Local
public interface ConfProduitLocal {
	public Produit rechercheProduit(String nomProduit) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;
	public List<Produit> rechercheProduits();

}