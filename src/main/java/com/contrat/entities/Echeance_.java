package com.contrat.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-03-01T15:34:29.098+0100")
@StaticMetamodel(Echeance.class)
public class Echeance_ {
	public static volatile SingularAttribute<Echeance, Integer> IDECHEANCE;
	public static volatile SingularAttribute<Echeance, Double> MTTTC;
	public static volatile SingularAttribute<Echeance, Double> MTTVA;
	public static volatile SingularAttribute<Echeance, Double> MTTCOMM;
	public static volatile SingularAttribute<Echeance, Contrat> IDCONTRAT;
}
