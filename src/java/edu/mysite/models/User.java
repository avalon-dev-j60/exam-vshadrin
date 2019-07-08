
package edu.mysite.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
    @NamedQuery(
        name = "find-user-by-login",
        query = "SELECT user "
              + "FROM USERS user "
              + "WHERE user.credentials.login = :login"
    )
})

@Entity (name = "USERS")
public class User implements Serializable{
   
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Credentials credentials;
    
    public User( ) { }

    public User(long id, String name, String surname, Credentials credentials) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.credentials = credentials;
    }

    public User(String name, Credentials credentials) {
        this.name = name;
        this.credentials = credentials;
    }

    public User(Credentials credentials) {
        this.credentials = credentials;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    
}
