package com.contrat.entities;

import java.io.Serializable;
import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.tier.entities.Tier;

/**
 * Entity implementation class for Entity: contrat
 *
 */
@Entity

public class Contrat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDCONTRAT;
	private String NUMEROCONTRAT;
	private String DESCRIPTION;
	private LocalDate DATEDEBUT;
	private LocalDate DATEFIN;
	private LocalDate DATEECHEANCE;
	private int DUREE;
	private double MTTTC;
	private double MTTCOMM;
	private double MTFINANCEMENT;
	@OneToOne(cascade = { CascadeType.MERGE })
	private Produit produit;
	
	@OneToOne
	private Tier tier;
	
	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	@OneToMany(cascade = { CascadeType.PERSIST },mappedBy="contrat")
	private List<Echeance> echeances;

	private static final long serialVersionUID = 1L;

	public Contrat() {
	}
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public double getMTFINANCEMENT() {
		return MTFINANCEMENT;
	}

	public void setMTFINANCEMENT(double mTFINANCEMENT) {
		MTFINANCEMENT = mTFINANCEMENT;
	}

	public List<Echeance> getEcheances() {
		return echeances;
	}

	public void setEcheances(List<Echeance> echeances) {
		this.echeances = echeances;
	}

	public double getMTTTC() {
		return MTTTC;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public void setMTTTC(double mTTTC) {
		MTTTC = mTTTC;
	}

	public double getMTTCOM() {
		return MTTCOMM;
	}

	public void setMTTCOM(double mTTCOM) {
		MTTCOMM = mTTCOM;
	}

	public int getIDCONTRAT() {
		return this.IDCONTRAT;
	}

	public void setIDCONTRAT(int IDCONTRAT) {
		this.IDCONTRAT = IDCONTRAT;
	}

	public String getNUMEROCONTRAT() {
		return this.NUMEROCONTRAT;
	}

	public void setNUMEROCONTRAT(String NUMEROCONTRAT) {
		this.NUMEROCONTRAT = NUMEROCONTRAT;
	}

	public LocalDate getDATEDEBUT() {
		return this.DATEDEBUT;
	}

	public void setDATEDEBUT(LocalDate DATEDEBUT) {
		this.DATEDEBUT = DATEDEBUT;
	}
	
	public LocalDate getDATEECHEANCE() {
		return DATEECHEANCE;
	}

	public void setDATEECHEANCE(LocalDate dATEECHEANCE) {
		DATEECHEANCE = dATEECHEANCE;
	}

	public LocalDate getDATEFIN() {
		return this.DATEFIN;
	}

	public void setDATEFIN(LocalDate DATEFIN) {
		this.DATEFIN = DATEFIN;
	}

	public int getDUREE() {
		return this.DUREE;
	}

	public void setDUREE(int DUREE) {
		this.DUREE = DUREE;
	}

}
