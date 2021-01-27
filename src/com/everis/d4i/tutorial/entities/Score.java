package com.everis.d4i.tutorial.entities;

import java.util.*;
import com.everis.d4i.tutorial.*;
import com.everis.d4i.tutorial.abstracts.Entity;

public class Score extends Entity<UUID> {

    //region Fields

    public static final int MAX_VALUE = 5;
    public static final int MIN_VALUE = 1;

    private User user;
    private int value;

    //endregion

    //region Constructors

    public Score(UUID id, User user, int value) {   
        super(id);

        setUser(user); 
        setValue(value);
    }

    //endregion

    //region Getters and setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = Check.notNull(user, "user");
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = Check.notValid(value, "value");
    }

    //endregion

    //region Behavior 
    
    public boolean isValid() {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }

    //endregion

}