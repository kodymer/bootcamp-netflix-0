package com.everis.d4i.tutorial.services;

import java.util.*;
import com.everis.d4i.tutorial.abstracts.*;
import com.everis.d4i.tutorial.entities.*;
import com.everis.d4i.tutorial.data.*;

public class ContentStore extends Store<Content, UUID> {

    //region Constructors

    public ContentStore() {
        super();
    }

    //endregion

    @Override
    protected Set<Content> GetSet() {    
        return Database.contents;
    }

}