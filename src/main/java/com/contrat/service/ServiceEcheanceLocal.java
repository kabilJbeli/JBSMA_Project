package com.contrat.service;

import javax.ejb.Local;

import com.contrat.entities.Echeance;

@Local
public interface ServiceEcheanceLocal {
	public void creation (Echeance c);
	public Echeance RechercheEcheance(int idEch);

}
