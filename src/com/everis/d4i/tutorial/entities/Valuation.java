package com.everis.d4i.tutorial.entities;

import java.util.*;
import com.everis.d4i.tutorial.Check;


public final class Valuation {

    private final Set<Score> score;
    private final Valuable valuable;

    public Valuation(Valuable valuable) {

        Check.notNull(valuable, "valuable");

        this.score = new HashSet<>();
        this.valuable = valuable;
    }

    // region Getters and setters

    public Valuable getValuable() {
        return valuable;
    }

    public Set<Score> getScore() {
        return score;
    }

    // endregion

    // region Behavior

    private void add(Score score) throws ValuationException {

        Check.notNull(score, "score");

        if(!score.isValid()){
            throw new ValuationException("Score value out of range!");
        }

        this.score.add(score);
    }

    private void remove(Score score) {

        Check.notNull(score, "score");

        this.score.remove(score);
    }

    private boolean exists(Score score) {

        Check.notNull(score, "score");

        return this.score.contains(score);
    }
    
    public void toggle(Score score) throws ValuationException {

        Check.notNull(score, "score");

        if(!exists(score)) {
            this.add(score);
        } else {
            this.remove(score);
        }
    }

    //endregion

}