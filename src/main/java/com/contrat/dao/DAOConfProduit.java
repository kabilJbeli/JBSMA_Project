package com.contrat.dao;

import javax.ejb.Local;

import com.contrat.entities.Produit;

@Local
public interface DAOConfProduit {
	public Produit rechercheProduit(String nomProduit);

}
