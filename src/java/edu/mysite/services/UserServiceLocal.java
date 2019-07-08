
package edu.mysite.services;

import edu.mysite.core.CRUD;
import edu.mysite.models.User;
import javax.ejb.Local;

@Local
public interface UserServiceLocal extends CRUD<User>{
   
     User find(String email);
    
}
