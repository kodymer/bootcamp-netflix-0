package com.everis.d4i.tutorial.services;

import java.util.*;
import java.util.stream.*;
import com.everis.d4i.tutorial.abstracts.*;
import com.everis.d4i.tutorial.entities.*;

public class ContentManager extends Manager<Content, UUID> {

    //region Constructors

    public ContentManager(ContentStore store) {
        super(store);
    }

    //endregion

    //region Behaviors

    public List<Film> getUnratedFilms(User user) {
        return this.store.getAll()
            .stream()
            .filter(c -> c instanceof Film && !c.hasBeenRated(user))
            .map(c -> (Film)c)
            .collect(Collectors.toList());
    }

    public List<Film> getBestFilms(User user) {
        return this.store.getAll()
            .stream()
            .filter(c ->  c instanceof Film && c.hasGoodScore(user))
            .map(c -> (Film)c)
            .collect(Collectors.toList());
    }

    public void setScoreToUnratedFilms(Score score) throws Exception {

        var unratedFilms = getUnratedFilms(score.getUser());
        for(var film : unratedFilms){
            film.toggle(score);
            update(film);
        }
    }

    //endregion



}