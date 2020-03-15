package com.tier.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tier
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Tier implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer IDTIER;
	@Column(unique = true)
	private Integer CINTIER;
	private String NAMETIER;
	private String PRENOMTIER;
	private String ADRESSETIER;
	private Boolean iseditable;
	
	public Boolean getIseditable() {
		return iseditable;
	}
	public void setIseditable(Boolean iseditable) {
		this.iseditable = iseditable;
	}

	private static final long serialVersionUID = 1L;

	public Tier() {
		super();
	}   
	public Integer getIDTIER() {
		return this.IDTIER;
	}

	public void setIDTIER(Integer IDTIER) {
		this.IDTIER = IDTIER;
	}   
	public Integer getCINTIER() {
		return this.CINTIER;
	}

	public void setCINTIER(Integer CINTIER) {
		this.CINTIER = CINTIER;
	}   
	public String getNAMETIER() {
		return this.NAMETIER;
	}

	public void setNAMETIER(String NAMETIER) {
		this.NAMETIER = NAMETIER;
	}   
	public String ADRESSETIER() {
		return this.PRENOMTIER;
	}

	public void setPRENOMTIER(String PRENOMTIER) {
		this.PRENOMTIER = PRENOMTIER;
	}   

	public String getPRENOMTIER() {
		return PRENOMTIER;
	}   
	public String getADRESSETIER() {
		return this.ADRESSETIER;
	}

	public void setADRESSETIER(String ADRESSETIER) {
		this.ADRESSETIER = ADRESSETIER;
	}
   
}
