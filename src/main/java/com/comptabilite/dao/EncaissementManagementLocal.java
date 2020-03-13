package com.comptabilite.dao;

import java.util.List;

import javax.ejb.Local;

import com.comptabilite.entities.Encaissement;
import com.comptabilite.entities.Facture;
import com.contrat.entities.Contrat;

@Local
public interface EncaissementManagementLocal {
	public void modification(Encaissement facture);
	public List<Encaissement> FindbyContract(Contrat contrat);
	public Encaissement FindbyFacture(Facture facture);
	public void creation (Encaissement encaissement);
	public Encaissement findbyID (int encaissement);

}
