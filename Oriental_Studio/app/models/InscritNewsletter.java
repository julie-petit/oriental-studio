package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class InscritNewsletter extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	public String email;
	
	public InscritNewsletter(String email){
		this.email = email;
	}
	
	public static Finder<String, InscritNewsletter> find = new Finder<String, InscritNewsletter>(String.class, InscritNewsletter.class);

}
