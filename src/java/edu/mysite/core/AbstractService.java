
package edu.mysite.core;

import javax.persistence.EntityManager;


public abstract class AbstractService<E> implements CRUD<E>{

    private final Class<E> cls;

    public AbstractService(Class<E> cls) {
        this.cls = cls;
    }
    
    protected abstract EntityManager getEntityManager();
    
    @Override
    public void create(E entity) {
        getEntityManager().detach(entity);
    }

    @Override
    public void update(E entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void delete(E entity) {
        getEntityManager().persist(entity);
    }
    
}
