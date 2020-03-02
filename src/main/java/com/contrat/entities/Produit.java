package com.contrat.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CONFPRODUIT
 *
 */
@Entity

public class Produit implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDCONF;
	private String DESCRIPTION;
	private double TAUXTVA;
	private double TAUXCOMM;
	private static final long serialVersionUID = 1L;

	public Produit() {
		super();
	}   
	public int getIDCONF() {
		return this.IDCONF;
	}

	public void setIDCONF(int IDCONF) {
		this.IDCONF = IDCONF;
	}   
	public String getDESCRIPTION() {
		return this.DESCRIPTION;
	}

	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}   
	public double getTAUXTVA() {
		return this.TAUXTVA;
	}

	public void setTAUXTVA(double TAUXTVA) {
		this.TAUXTVA = TAUXTVA;
	}   
	public double getTAUXCOMM() {
		return this.TAUXCOMM;
	}

	public void setTAUXCOMM(double TAUXCOMM) {
		this.TAUXCOMM = TAUXCOMM;
	}
   
}
