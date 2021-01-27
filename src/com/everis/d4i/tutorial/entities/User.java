package com.everis.d4i.tutorial.entities;

import java.util.*;
import com.everis.d4i.tutorial.*;
import com.everis.d4i.tutorial.abstracts.*;

public class User extends Entity<UUID> {
    
    //region Fields

    private String name;

    //endregion

    //region Constructors

    public User(UUID id, String name) {
        super(id);

        setName(name);
    }

    //endregion

    //region Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Check.notNullOrEmpty(name, "name");
    }

    //endregion
    
}