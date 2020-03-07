package com.contrat.service;

import java.util.List;

import javax.ejb.Local;

import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;
import com.contrat.entities.Produit;
import com.contrat.entities.Tier;

@Local
public interface ServiceContratLocal {
	 public List<Echeance> CalculeMensualite(Contrat contrat);
	 public void CreationContrat(Contrat contrat, Produit produit, Tier tier);

}
