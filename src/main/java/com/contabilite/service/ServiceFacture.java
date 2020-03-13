package com.contabilite.service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.comptabilite.dao.EncaissementManagementLocal;
import com.comptabilite.dao.FactureManagementLocal;
import com.comptabilite.entities.Encaissement;
import com.comptabilite.entities.Facture;
import com.contrat.entities.Contrat;

/**
 * Session Bean implementation class ServiceFacture
 */
@Stateless
@LocalBean
public class ServiceFacture implements ServiceFactureLocal {
	@EJB
	FactureManagementLocal FactureManagementdao;
	@EJB
	EncaissementManagementLocal encaissementManagemendao;

    public ServiceFacture() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void modificationFacture(Facture facture) {
		FactureManagementdao.modification(facture);
		
	}

	@Override
	public List<Facture> RechercheFactureparContract(Contrat contrat) {
		return FactureManagementdao.FindbyContract(contrat);
	}

	@Override
	public void CreationFacture(Facture facture) {
		FactureManagementdao.creation(facture);
	}

	@Override
	public Facture RechercheparID(int idfacture) {
		return FactureManagementdao.findbyID(idfacture);
	}

	@Override
	public void AnnulationFacture(Facture facture) {
		Encaissement encaissement = new Encaissement();
		encaissement.setDATEENCAISSEMENT(LocalDate.now());
		encaissement.setDESCRIPTION("Avoir pour la facture"+facture.getIDFACTURE());
		encaissement.setFacture(facture);
		encaissement.setSIGNE(-1);
		encaissement.setSTATUS(2);
		encaissement.setMTCOM(facture.getMTCOM());
		encaissement.setMTTTC(facture.getMTTTC());
		facture.setStatus(2);
		modificationFacture(facture);
		encaissementManagemendao.creation(encaissement);
	}

}
