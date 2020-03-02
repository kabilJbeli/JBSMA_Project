package com.contrat.entities;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-03-01T15:10:31.719+0100")
@StaticMetamodel(Contrat.class)
public class Contrat_ {
	public static volatile SingularAttribute<Contrat, Integer> IDCONTRAT;
	public static volatile SingularAttribute<Contrat, String> NUMEROCONTRAT;
	public static volatile SingularAttribute<Contrat, String> DESCRIPTION;
	public static volatile SingularAttribute<Contrat, LocalDate> DATEDEBUT;
	public static volatile SingularAttribute<Contrat, LocalDate> DATEFIN;
	public static volatile SingularAttribute<Contrat, Integer> PERIODICITE;
	public static volatile SingularAttribute<Contrat, Integer> DUREE;
	public static volatile SingularAttribute<Contrat, Double> MTTTC;
	public static volatile SingularAttribute<Contrat, Double> MTTVA;
	public static volatile SingularAttribute<Contrat, Double> MTTCOMM;
	public static volatile SingularAttribute<Contrat, Double> MTFINANCEMENT;
	public static volatile ListAttribute<Contrat, Echeance> echeances;
	public static volatile SingularAttribute<Contrat, Produit> produit;
}
