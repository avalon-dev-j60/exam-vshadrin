
package edu.mysite.core;


public interface CRUD<E> {
    
    void create(E entity);
    
    void update(E entity);
    
    void delete(E entity);
}
