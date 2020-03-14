package com.comptabilite.service;

import java.util.List;

import javax.ejb.Local;

import com.comptabilite.entities.Facture;
import com.contrat.entities.Contrat;

@Local
public interface ServiceFactureLocal {
	public void modificationFacture(Facture facture);
	public List<Facture> RechercheFactureparContract(Contrat contrat);
	public void CreationFacture (Facture facture);
	public Facture RechercheparID (int idfacture);
	public void AnnulationFacture(Facture facture);
}
