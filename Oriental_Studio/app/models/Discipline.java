package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Discipline extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	public String nom;
	public String description;
	
	public Discipline(String nom, String description){
		this.nom=nom;
		this.description=description;
	}
	
	public static Finder<String, Discipline> find = new Finder<String, Discipline>(String.class,Discipline.class);

}
