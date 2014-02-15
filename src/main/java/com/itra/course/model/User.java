package com.itra.course.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private boolean enabled;

    @Column
    private String authority;

    @Lob
    private byte[] avatar;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Creative> creatives = new ArrayList<Creative>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Comment> comments = new ArrayList<Comment>();

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

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
