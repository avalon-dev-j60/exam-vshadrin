
package edu.mysite.services;

import edu.mysite.core.AbstractService;
import edu.mysite.models.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService extends AbstractService<User> implements UserServiceLocal {

    @PersistenceContext(unitName = "MySitePU")
    EntityManager em;

    public UserService() {
        super(User.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public User find(String login) {
        try {return em.createNamedQuery("find-user-by-login", User.class).setParameter("login", login).getSingleResult();}
        catch (NoResultException e) {
            return null;
        }
     }
    
}
