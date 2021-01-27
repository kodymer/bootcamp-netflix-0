package com.everis.d4i.tutorial.entities;

import java.time.*;
import java.util.*;
import com.everis.d4i.tutorial.*;
import com.everis.d4i.tutorial.abstracts.*;

/**
 * Base class
 */
public abstract class Content extends Entity<UUID> implements Valuable {

    //region Fields

    private LocalDate reproductionDate;
    private String name;
    private final Valuation valuation;

    //endregion

    //region Constructors

    public Content(UUID id) {
        super(id);

        valuation = new Valuation(this);
    }

    public Content(UUID id, String name, LocalDate reproductionDate) {
        this(id);

        setName(name);
        setReproductionDate(reproductionDate);
    }

    //endregion

    //region Getters and setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = Check.notNullOrEmpty(name, "name");
    }

    public LocalDate getReproductionDate() {
        return this.reproductionDate;
    }
    
    public void setReproductionDate(LocalDate reproductionDate) {
        this.reproductionDate = reproductionDate;
    }

    //endregion

    //region Behaviors

    @Override
    public void toggle(Score score) throws Exception {
        this.valuation.toggle(score);
    }

    @Override
    public String toString() {
        return String.format("%s - %s, %s", this.getId(), this.getName(), this.getReproductionDate());
    }
   
    public boolean hasBeenRated(User user) {
        return this.valuation.getScore().stream().anyMatch(e -> e.getUser().getId() == user.getId());
    }

    public boolean hasGoodScore(User user) {
        return this.valuation.getScore().stream().anyMatch(e -> e.getUser().getId() == user.getId() && e.getValue() == Score.MAX_VALUE );
    }


    //endregion
}

               