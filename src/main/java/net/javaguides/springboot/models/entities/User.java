package net.javaguides.springboot.models.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "users")
public class User implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length=100)
    private String firstname;

    @Column(name = "last_name", length=100)
    private String lastname;

    @Column(name = "email", length=100, unique = true)
    private String email;

    @Column(name = "password", length=100)
    private String password;

    public User() {
    }

    public User(Long id, String firstname, String last_name, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLast_name(String lastName) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
