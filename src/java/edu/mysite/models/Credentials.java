
package edu.mysite.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credentials implements Serializable{
   
    @Id
    @Column(nullable = false)
    private String login;
    
    @Column(nullable = false)
    private String password;

    public Credentials() {
    }

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
    
    private boolean equals(Credentials credentials) {
        return  credentials.login.equals(login) &&
                credentials.password.equals(password);
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof Credentials) {
            return equals((Credentials)object);
        }
        return false;
    }
    
}
