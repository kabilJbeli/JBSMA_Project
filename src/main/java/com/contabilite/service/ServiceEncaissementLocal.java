package com.contabilite.service;

import java.util.List;

import javax.ejb.Local;

import com.comptabilite.entities.Encaissement;
import com.comptabilite.entities.Facture;
import com.contrat.entities.Contrat;

@Local
public interface ServiceEncaissementLocal {
	public void modificationEncaissement(Encaissement facture);
	public List<Encaissement> RechercheEncaissementparContract(Contrat contrat);
	public Encaissement RechercheEncaissementparFacture(Facture facture);
	public void creationEncaissement (Encaissement encaissement);
	public Encaissement RechercheEncaissementparID (int encaissement);

}
