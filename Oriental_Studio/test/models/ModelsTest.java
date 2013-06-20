package models;
import java.util.Calendar;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import play.test.WithApplication;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {

	@Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }
	
	@Test
	public void findCours(){
		Calendar plageHoraire  = Calendar.getInstance();
		int dureeEnMinutes = 90;
		Discipline discipline = new Discipline("Danse Orientale", "Danse orientale tribale");
		discipline.save();
		Professeur prof = new Professeur("Amana", "Professeur de danse orientale depuis 15 ans", "");
		prof.save();
		plageHoraire.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		plageHoraire.set(Calendar.HOUR_OF_DAY, 18);
		plageHoraire.set(Calendar.MINUTE, 30);
		Cours cours = Cours.create(plageHoraire, dureeEnMinutes, discipline, prof);
		
		//find by plage horaire
		Cours coursParPlageHoraire = Cours.find.byId(plageHoraire);
		Assertions.assertThat(coursParPlageHoraire).isEqualTo(cours);
		
		//find by Professeur
		List<Cours> coursParProfesseur = Cours.findCoursParProfesseur(prof.nom);
		Assertions.assertThat(coursParProfesseur).contains(cours);
		
		//find by Discipline
		List<Cours> coursParDiscipline = Cours.findCoursParDiscipline(discipline.nom);
		Assertions.assertThat(coursParDiscipline).contains(cours);
	}
	
	@Test
	public void findActualiteActive(){
		Actualite actualite1 = new Actualite(Calendar.getInstance().getTime(), "Le spectacle de fin d'année aura lieu le 23 juin", true);
		Actualite actualite2 = new Actualite(Calendar.getInstance().getTime(), "Prochain stage de danse orientale le 9 juin", false);
		actualite1.save();
		actualite2.save();
		List<Actualite> listActualiteActive = Actualite.findActualiteActive(true);
		Assertions.assertThat(listActualiteActive).contains(actualite1);
		Assertions.assertThat(actualite2).isNotIn(listActualiteActive);
		
	}
	
}
