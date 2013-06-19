package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Actualite extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	public Integer id;
	public Date date;
	public String description;
	public Boolean active;

	public Actualite(Date date, String description, Boolean active){
		this.date = date;
		this.description = description;
		this.active = active;
	}
	
	public static Finder<Integer, Actualite> find = new Finder<Integer, Actualite>(Integer.class, Actualite.class);
	
	public static List<Actualite> findActualiteActive(Boolean active) {
	       return find.where().eq("active", active).findList();
	    }
}
