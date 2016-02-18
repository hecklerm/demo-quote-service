package org.thehecklers.entity;

import javax.persistence.*;

/**
 * Created by markheckler on 11/24/15.
 */
@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String quoteText;
    private String context;

    @ManyToOne
    @JoinColumn(name = "sourceId")
    private QuoteSource quoteSource;

    public Quote() {
    }

    public Quote(String quoteText, String context, QuoteSource quoteSource) {
        this.quoteText = quoteText;
        this.context = context;
        this.quoteSource = quoteSource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public QuoteSource getQuoteSource() {
        return quoteSource;
    }

    public void setQuoteSource(QuoteSource quoteSource) {
        this.quoteSource = quoteSource;
    }
}
