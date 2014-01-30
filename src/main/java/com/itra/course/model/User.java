package com.itra.course.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "authority")
    private String authority;
    @Column(name = "avatarRef")
    private String avatarRef;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="author_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Creative> creatives = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Comment> comments = new ArrayList<>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
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

    public String getAvatarRef() {
        return avatarRef;
    }

    public void setAvatarRef(String avatarRef) {
        this.avatarRef = avatarRef;
    }

    public Collection<Creative> getCreatives() {
        return creatives;
    }

    public void setCreatives(Collection<Creative> creatives) {
        this.creatives = creatives;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
