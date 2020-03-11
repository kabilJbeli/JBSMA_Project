package com.contrat.service;

import java.util.List;

import javax.ejb.Local;

import com.contrat.entities.Produit;

@Local
public interface ServiceProduitLocal {

	public void Creation(Produit produit);
	public void Delete(Produit produit);
	public void RechercheProduit(int IdProduit);
	public List<Produit> rechercheProduits();
	public void Modifier (Produit produit);
	


}
