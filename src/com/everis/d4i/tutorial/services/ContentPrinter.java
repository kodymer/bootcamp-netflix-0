package com.everis.d4i.tutorial.services;

import java.util.*;
import com.everis.d4i.tutorial.*;
import com.everis.d4i.tutorial.entities.*;

public class ContentPrinter {

    //region Behavior

    public void print(List<Film> films)
    {
        Check.notNull(films, "films");

        for(var film : films){
            System.out.println(film.toString());
        }
    }
    
    //endregion
}