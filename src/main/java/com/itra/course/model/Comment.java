package com.itra.course.model;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.search.annotations.*;

import javax.persistence.*;

/**
 * User: Greenjerk
 * Date: 26.01.14
 * Time: 22:03
 */

@Entity
@Indexed
public class Comment {

    @Id
    @Column(name = "id")
    @DocumentId
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column
    @Field(index=Index.YES, analyze= Analyze.YES, store=Store.NO,
            analyzer = @Analyzer(impl = StandardAnalyzer.class))
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creative_id", nullable = false)
    Creative creative;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Creative getCreative() {
        return creative;
    }

    public void setCreative(Creative creative) {
        this.creative = creative;
    }
}
