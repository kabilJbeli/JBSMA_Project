package com.comptabilite.dao;

import java.util.List;

import javax.ejb.Local;

import com.comptabilite.entities.Encaissement;
import com.comptabilite.entities.Facture;
import com.contrat.entities.Contrat;

@Local
public interface FactureManagementLocal {
	public void modification(Facture facture);
	public List<Facture> FindbyContract(Contrat contrat);
	public void creation (Facture facture);
	public Facture findbyID (int idfacture);

}
