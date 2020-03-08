package com.contrat.entities;

import com.contrat.entities.Contrat;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: echeance
 *
 */
@Entity

public class Echeance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IDECHEANCE;
	private double MTTTC;
	private LocalDate DATEECHEANCE;
	private LocalDate DATEEXIGIBILITE;

	private double MTTCOMM;
	@ManyToOne
	private Contrat contrat;

	private static final long serialVersionUID = 1L;

	public double getMTTCOMM() {
		return MTTCOMM;
	}

	public void setMTTCOMM(double mTTCOMM) {
		MTTCOMM = mTTCOMM;
	}

	public Echeance() {
		super();
	}

	public LocalDate getDATEECHEANCE() {
		return DATEECHEANCE;
	}

	public void setDATEECHEANCE(LocalDate dATEECHEANCE) {
		DATEECHEANCE = dATEECHEANCE;
	}

	public LocalDate getDATEEXIGIBILITE() {
		return DATEEXIGIBILITE;
	}

	public void setDATEEXIGIBILITE(LocalDate dATEEXIGIBILITE) {
		DATEEXIGIBILITE = dATEEXIGIBILITE;
	}

	public int getIDECHEANCE() {
		return this.IDECHEANCE;
	}

	public void setIDECHEANCE(int IDECHEANCE) {
		this.IDECHEANCE = IDECHEANCE;
	}

	public double getMTTTC() {
		return this.MTTTC;
	}

	public void setMTTTC(double MTTTC) {
		this.MTTTC = MTTTC;
	}

	public Contrat getIDCONTRAT() {
		return this.contrat;
	}

	public void setIDCONTRAT(Contrat IDCONTRAT) {
		this.contrat = IDCONTRAT;
	}

}
