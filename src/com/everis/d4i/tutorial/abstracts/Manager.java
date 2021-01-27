package com.everis.d4i.tutorial.abstracts;

import com.everis.d4i.tutorial.*;

/**
 * entityManager
 */
public class Manager<T extends Entity<K>, K> {

    protected Store<T, K> store;

    public  Manager(Store<T, K> store) {

        Check.notNull(store, "store");
        
        this.store = store;
    }

    @SuppressWarnings("unchecked")
    public void add(T... entities) {

        Check.notNullOrEmpty(entities, "entities");

        for(T entity: entities)
        {
            store.insert(entity);
        }
    }

    public void update(T entity) {

        Check.notNull(entity, "entity");

        store.update(entity);
    }

    public void remove(T entity) {

        Check.notNull(entity, "entity");

        store.delete(entity);
    }

    public T find(K id) {

        Check.notNull(id, "id");

        return store.get(id);
    }
}