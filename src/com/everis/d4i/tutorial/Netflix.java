package com.everis.d4i.tutorial;

import java.time.*;
import java.util.*;
import com.everis.d4i.tutorial.entities.*;
import com.everis.d4i.tutorial.services.*;

public class Netflix {

    public static void main(String[] args) {

        var user = new User(UUID.randomUUID(), "@keymerketing");
        var store = new ContentStore();
        var manager = new ContentManager(store);
        var printer = new ContentPrinter();

        try {

            /**
             * #1. Recientemente he visto la peli The clockwork orange de Cubrick, el
             * documental the Blue Planet y Stranger Things. No las he valorado por el
             * momento. (incialización)
             */
            var theClockworkOrangeFilm = new Film(UUID.randomUUID(), "The Clockwork Orange", LocalDate.now(), "Stanley Cubrick", 1971);
            var bluePlanetDocumentaryFilm = new DocumentaryFilm(UUID.randomUUID(), "Blue Planet", LocalDate.now(), "Alastair Fothergill", 2001);
            var strangerThingsTvSeries = new TvSeries(UUID.randomUUID(), "Stranger Things", LocalDate.now(), "Netflix", 8, 2016);

            manager.add(theClockworkOrangeFilm, bluePlanetDocumentaryFilm, strangerThingsTvSeries);

            /**
             * #2. Revisionando Stranger things, decido que la serie me gusta, pero la segunda
             * temporada no. Lo vuelvo a registrar.
             */
            var strangerThingsTvSeriesGeneralScore = new Score(UUID.randomUUID(), user, Score.MAX_VALUE);
            strangerThingsTvSeries.toggle(strangerThingsTvSeriesGeneralScore);

            var strangerThingsTvSeriesSeason2Score = new Score(UUID.randomUUID(), user, Score.MIN_VALUE);
            strangerThingsTvSeries.getSeason(2).toggle(strangerThingsTvSeriesSeason2Score);
            
            manager.update(strangerThingsTvSeries);
            
            /**
             * #3. oops, la naranja mecánica es de Kubrick. Lo corrijo
             */
            theClockworkOrangeFilm = (Film)manager.find(theClockworkOrangeFilm.getId());
            theClockworkOrangeFilm.setDirectorName("Stanley Kubrick");

            manager.update(theClockworkOrangeFilm);

            /**
             * #4. Mi hermana me roba la cuenta de Netflix y mira the Notebook (Y lo registra)
             */
            var theNotebookFilm = new Film(UUID.randomUUID(), "The Notebook", LocalDate.now(), "Nick Cassavetes", 2004);        
            manager.add(theNotebookFilm);

            /**
             * #5. Revisando el registro, me doy cuenta de ello y lo borro inmediatamente. 
             * Doy valoraciones a las películas que no tienen
             */
            manager.remove(theNotebookFilm);
            
            var filmDefaultScore = new Score(UUID.randomUUID(), user, Score.MAX_VALUE);
            manager.setScoreToUnratedFilms(filmDefaultScore);

            /**
             * #6. Ayer hice maratón de Stephen King y vi the Shining y Pet Sematary. Ambas me 
             * gustaron mucho, aunque la primera más que la segunda.
             */
            var theShiningFilm = new Film(UUID.randomUUID(), "The Shining", LocalDate.now(), "Stephen King", 1980);
            var theShiningFilmScore = new Score(UUID.randomUUID(), user, Score.MAX_VALUE);
            theShiningFilm.toggle(theShiningFilmScore);

            var petSemataryFilm = new Film(UUID.randomUUID(), "Pet Sematary", LocalDate.now(), "Stephen King", 2019);
            var petSemataryFilmScore = new Score(UUID.randomUUID(), user, 4);
            theShiningFilm.toggle(petSemataryFilmScore);

            manager.add(theShiningFilm, petSemataryFilm);

            /**
             * #7. Filtro las peliculas por valoración: solo busco las que me han gustado más.
             */

            var films = manager.getBestFilms(user);
            printer.print(films);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

