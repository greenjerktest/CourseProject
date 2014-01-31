package com.itra.course.model;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES,
            analyzer = @Analyzer(impl = StandardAnalyzer.class))
    private String tagName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags")
    private Set<Creative> creatives = new HashSet<>();

    public Set<Creative> getCreatives() {
        return creatives;
    }

    public void setCreatives(Set<Creative> creatives) {
        this.creatives = creatives;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
