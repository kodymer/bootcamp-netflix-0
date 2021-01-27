package com.everis.d4i.tutorial.entities;

import com.everis.d4i.tutorial.abstracts.*;

public class Season extends Entity<Integer> implements Valuable {

    //region Fields

    private final Valuation valuation;

    //endregion
    
    //region Constructors

    public Season(int id) { 
        super(id);

        valuation = new Valuation(this);
    }

    //endregion

    //region Behavior

    @Override
    public void toggle(Score score) throws Exception {
        this.valuation.toggle(score);
    }

    public static Season create(int id) {

        // TO DO: create chapters

        return new Season(id);
    }

    //endregion

}
