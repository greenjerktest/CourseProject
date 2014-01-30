package com.itra.course.model;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * User: Greenjerk
 * Date: 25.01.14
 * Time: 17:24
 */

@Entity
@Table(name = "tag")
@Indexed
public class Tag {

    @Column
    @Id
    @DocumentId
    private long id;

    @Column
    @Field(index=Index.YES, analyze= Analyze.YES, store=Store.YES,
            analyzer = @Analyzer(impl = StandardAnalyzer.class))
    private String tag;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags")
    private Collection<Creative> creatives = new ArrayList<>();

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
