package com.contrat.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.contrat.dao.ConfProduitLocal;
import com.contrat.entities.Echeance;
import com.contrat.entities.Produit;

/**
 * Session Bean implementation class ServiceProduit
 */
@Stateless
@LocalBean
public class ServiceProduit implements ServiceProduitLocal {
	@EJB
	ConfProduitLocal daoproduit;

    /**
     * Default constructor. 
     */
    public ServiceProduit() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void Creation(Produit produit) {
		daoproduit.Creation(produit);
	}
	
	@Override
	public void Delete(Produit produit) {
		daoproduit.delete(produit);
	}
	
	@Override
	public void RechercheProduit(int IdProduit) {
		daoproduit.rechercheProduit(IdProduit);
	}
	
	@Override
	public List<Produit> rechercheProduits() {
		return daoproduit.rechercheProduits();
	}
	
	@Override
	public void Modifier(Produit produit) {
		daoproduit.modifier(produit);
		
	}

}
