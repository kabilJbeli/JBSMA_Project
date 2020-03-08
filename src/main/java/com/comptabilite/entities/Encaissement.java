package com.comptabilite.entities;

import com.comptabilite.entities.Facture;
import java.io.Serializable;
import java.lang.String;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encaissement
 *
 */
@Entity

public class Encaissement implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDENCAISSEMENT;
	@OneToOne(cascade = { CascadeType.MERGE })
	private Facture Facture;
	private String DESCRIPTION;
	private int SIGNE;
	private LocalDate DATEENCAISSEMENT;
	private double MTTTC;
	private double MTCOM;
	private int STATUS;
	private static final long serialVersionUID = 1L;

	public Encaissement() {
		super();
	}   
	public int getIDENCAISSEMENT() {
		return this.IDENCAISSEMENT;
	}

	public void setIDENCAISSEMENT(int IDENCAISSEMENT) {
		this.IDENCAISSEMENT = IDENCAISSEMENT;
	}   
	public Facture getFacture() {
		return this.Facture;
	}

	public void setFacture(Facture Facture) {
		this.Facture = Facture;
	}   
	public String getDESCRIPTION() {
		return this.DESCRIPTION;
	}

	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}   
	public int getSIGNE() {
		return this.SIGNE;
	}

	public void setSIGNE(int SIGNE) {
		this.SIGNE = SIGNE;
	}   
	public LocalDate getDATEENCAISSEMENT() {
		return this.DATEENCAISSEMENT;
	}

	public void setDATEENCAISSEMENT(LocalDate DATEENCAISSEMENT) {
		this.DATEENCAISSEMENT = DATEENCAISSEMENT;
	}   
	public double getMTTTC() {
		return this.MTTTC;
	}

	public void setMTTTC(double MTTTC) {
		this.MTTTC = MTTTC;
	}   
	public double getMTCOM() {
		return this.MTCOM;
	}

	public void setMTCOM(double MTCOM) {
		this.MTCOM = MTCOM;
	}   
	public int getSTATUS() {
		return this.STATUS;
	}

	public void setSTATUS(int STATUS) {
		this.STATUS = STATUS;
	}
   
}
