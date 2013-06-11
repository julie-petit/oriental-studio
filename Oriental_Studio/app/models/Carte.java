package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Carte extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	public String nom;
	public Float forfaitCours;
	public Float reduction;
	

	public Carte(Float forfaitCours, Float reduction, String nom){
		this.forfaitCours = forfaitCours;
		this.nom = nom;
		this.reduction = reduction;
	}
	
	public static Finder<String, Carte> find = new Finder<String, Carte>(String.class, Carte.class);

}
