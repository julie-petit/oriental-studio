package models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import play.db.ebean.Model;

@Entity
public class Cours extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Calendar plageHoraire;
	public Integer dureeEnMinutes;
	@ManyToOne
	public Discipline discipline;
	@ManyToOne
	public Professeur professeur;
	
	public Cours(Calendar plageHoraire, Integer dureeEnMinutes, Discipline discipline, Professeur professeur){
		this.plageHoraire = plageHoraire;
		this.dureeEnMinutes = dureeEnMinutes;
		this.discipline = discipline;
		this.professeur = professeur;
	}
	
	public static Finder<Calendar, Cours> find = new Finder<Calendar, Cours>(Calendar.class, Cours.class);
	
	public static Cours create(Calendar plageHoraire, Integer dureeEnMinutes, Discipline discipline, Professeur professeur) {
		Cours cours = new Cours(plageHoraire, dureeEnMinutes, discipline, professeur);
		cours.save();
        return cours;
    }

	public static List<Cours> findCoursParDiscipline(String discipline) {
	       return find.where().eq("discipline.nom", discipline).findList();
	    }
	public static List<Cours> findCoursParProfesseur(String professeur) {
	       return find.where().eq("professeur.nom", professeur).findList();
	    }
	
}
