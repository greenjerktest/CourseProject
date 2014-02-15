package com.itra.course.model;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Greenjerk
 * Date: 25.01.14
 * Time: 16:44
 */
@Entity
@Table(name = "creative")
@Indexed
public class Creative {

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO,
            analyzer = @Analyzer(impl = StandardAnalyzer.class))
    private String title;

    @Column(length = 1000, nullable = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO,
            analyzer = @Analyzer(impl = StandardAnalyzer.class))
    private String description;

    @Column
    private String logoRef;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "creative_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Head> heads = new ArrayList<Head>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "creative_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Comment> comments = new ArrayList<Comment>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    User author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "creative_tag",
            joinColumns = {@JoinColumn(name = "creative_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<Tag>();


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Head> getHeads() {
        return heads;
    }

    public void setHeads(Collection<Head> heads) {
        this.heads = heads;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogoRef() {
        return logoRef;
    }

    public void setLogoRef(String logoRef) {
        this.logoRef = logoRef;
    }
}
