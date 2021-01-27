package com.everis.d4i.tutorial.abstracts;

import java.util.*;
import com.everis.d4i.tutorial.*;

/**
 * Entity<T>
 */
public abstract class Entity<T> {

    private T id;
    
    protected Entity(T id) {
        setId(id);
    }

    public T getId(){
        return id;
    }

    public void setId(T id) {
        this.id = Check.notNull(id, "id");
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}