package com.comptabilite.entities;

import com.contrat.entities.Echeance;
import java.io.Serializable;
import java.lang.String;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Facture
 *
 */
@Entity

public class Facture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDFACTURE;
	private LocalDate DATEEFFET;
	@OneToOne(cascade = { CascadeType.MERGE })
	private Echeance ECHEANCE;
	private int Status;
	private int signe;
	private String DESCRIPTION;
	private double MTTTC;
	private double MTCOM;

	private static final long serialVersionUID = 1L;

	public Facture() {
		super();
	}

	public int getIDFACTURE() {
		return this.IDFACTURE;
	}

	public double getMTTTC() {
		return MTTTC;
	}

	public void setMTTTC(double mTTTC) {
		MTTTC = mTTTC;
	}

	public double getMTCOM() {
		return MTCOM;
	}

	public void setMTCOM(double mTCOM) {
		MTCOM = mTCOM;
	}

	public int getSigne() {
		return signe;
	}

	public void setSigne(int signe) {
		this.signe = signe;
	}

	public void setIDFACTURE(int IDFACTURE) {
		this.IDFACTURE = IDFACTURE;
	}

	public LocalDate getDATEEFFET() {
		return this.DATEEFFET;
	}

	public void setDATEEFFET(LocalDate DATEEFFET) {
		this.DATEEFFET = DATEEFFET;
	}

	public Echeance getECHEANCE() {
		return this.ECHEANCE;
	}

	public void setECHEANCE(Echeance ECHEANCE) {
		this.ECHEANCE = ECHEANCE;
	}

	public int getStatus() {
		return this.Status;
	}

	public void setStatus(int Status) {
		this.Status = Status;
	}

	public String getDESCRIPTION() {
		return this.DESCRIPTION;
	}

	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}

}
