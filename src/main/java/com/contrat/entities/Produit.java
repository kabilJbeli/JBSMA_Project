package com.contrat.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CONFPRODUIT
 *
 */
@Entity
@Table(name="produit")
public class Produit implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDCONF;
	private String DESCRIPTION;
	private double TAUXCOMM;
	private double TAUXTVA;
	private Boolean iseditable;
	public Boolean getIseditable() {
		return iseditable;
	}

	public void setIseditable(Boolean iseditable) {
		this.iseditable = iseditable;
	}

	private static final long serialVersionUID = 1L;

	public Produit() {
		super();
	}   
	
	public double TAUXTVA() {
		return TAUXTVA;
	}
	public double getTAUXTVA() {
		return TAUXTVA;
	}
	public void setTAUXTVA(double tAUXTVA) {
		TAUXTVA = tAUXTVA;
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
	
	public double getTAUXCOMM() {
		return this.TAUXCOMM;
	}

	public void setTAUXCOMM(double TAUXCOMM) {
		this.TAUXCOMM = TAUXCOMM;
	}
   
}
