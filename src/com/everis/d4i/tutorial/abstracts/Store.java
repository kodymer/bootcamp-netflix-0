package com.everis.d4i.tutorial.abstracts;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import com.everis.d4i.tutorial.*;

public abstract class Store<T extends Entity<K>, K>  {
    
    public Set<T> getAll() {
        return GetSet();
    }

    public Set<T> get(Predicate<T> predicate) {

        Check.notValid(predicate, "predicate");

        var result = GetSet().stream()
            .filter(e -> predicate.test(e)).sequential();

        return result.collect(Collectors.toSet());
    }

    public T get(K id) {

        Check.notValid(id, "id");

        var result = GetSet().stream()
            .filter(e -> e.getId() == id);

        return result.findFirst().orElseThrow();
    }

    public void insert(T entity) {

        Check.notNull(entity, "entity");

        GetSet().add(entity);
    }

    public void replace(T oldEntity, T newEntity) {

        Check.notNull(oldEntity, "oldEntity");
        Check.notNull(newEntity, "newEntity");

        GetSet().remove(oldEntity);
        GetSet().add(newEntity);      
    }

    public void update(T entity) {

        Check.notNull(entity, "entity");

        Predicate<T> predicate = e -> e.getId() == entity.getId();
        var oldEntity = get(predicate).stream().findFirst().orElseThrow();

        replace(oldEntity, entity);
    }

    public void delete(T entity) {

        Check.notNull(entity, "entity");

        GetSet().remove(entity);
    }

    protected abstract Set<T> GetSet();
}