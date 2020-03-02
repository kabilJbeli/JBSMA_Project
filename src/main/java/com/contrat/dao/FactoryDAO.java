package com.contrat.dao;



public class FactoryDAO {

	
	public ContratManagement buildContrat(){
		return new ContratManagement();
	}

}
