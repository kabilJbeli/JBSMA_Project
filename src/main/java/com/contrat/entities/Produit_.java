package com.contrat.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-03-01T14:29:51.416+0100")
@StaticMetamodel(Produit.class)
public class Produit_ {
	public static volatile SingularAttribute<Produit, Integer> IDCONF;
	public static volatile SingularAttribute<Produit, String> DESCRIPTION;
	public static volatile SingularAttribute<Produit, Double> TAUXTVA;
	public static volatile SingularAttribute<Produit, Double> TAUXCOMM;
}
