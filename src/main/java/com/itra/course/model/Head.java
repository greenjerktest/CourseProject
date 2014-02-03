package com.itra.course.model;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.search.annotations.*;
import javax.persistence.*;

/**
 * User: Greenjerk
 * Date: 25.01.14
 * Time: 16:45
 */

@Entity
@Table(name = "head")
@Indexed
public class Head {

    @Id
    @DocumentId
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Field(index=Index.YES, analyze= Analyze.YES, store=Store.NO,
            analyzer = @Analyzer(impl = StandardAnalyzer.class))
    private String title;

    @Column(length=7000, nullable = false)
    @Field(index=Index.YES, analyze= Analyze.YES, store=Store.NO,
            analyzer = @Analyzer(impl = StandardAnalyzer.class))
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creative_id")
    Creative creative;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Creative getCreative() {
        return creative;
    }

    public void setCreative(Creative creative) {
        this.creative = creative;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
