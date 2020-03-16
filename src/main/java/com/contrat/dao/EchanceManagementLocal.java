package com.contrat.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import com.contrat.entities.Contrat;
import com.contrat.entities.Echeance;

@Local
public interface EchanceManagementLocal {
	public void creation(Echeance c);
	public List<Echeance> RechercheEcheanceparDateContrat(Contrat contrat);
	public void Modify(Echeance c);
	public Echeance RechercheEcheance(int idEch);
}
