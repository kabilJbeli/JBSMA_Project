package com.contrat.dao;

import javax.ejb.Local;

import com.contrat.entities.Echeance;


@Local
public interface EchanceManagementLocal {
	public void creation (Echeance c);

}
