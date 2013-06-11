package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Professeur extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	public String nom;
	public String parcoursPro;
	public String urlAvatar;
	
	public Professeur(String nom, String parcoursPro, String urlAvatar){
		this.nom = nom;
		this.parcoursPro = parcoursPro;
		this.urlAvatar = urlAvatar;
	}
	
	public static Finder<String,Professeur> find = new Finder<String, Professeur>(String.class, Professeur.class);
}
