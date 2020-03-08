package com.contrat.service;

import java.text.ParseException;
import java.util.List;

import javax.ejb.Local;

import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;

@Local
public interface ServiceContratLocal {
	 public List<Echeance> CalculeMensualite(Contrat contrat) throws ParseException;
	 public void CreationContrat(Contrat contrat) throws ParseException;

}
