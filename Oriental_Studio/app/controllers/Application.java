package controllers;

import models.Actualite;
import models.Discipline;
import models.Professeur;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render(Actualite.findActualiteActive(true), Discipline.find.all(), Professeur.find.all()));
    }
  
}
