package org.pract.demo.two.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR", length = 100)
    private String title;

    @NotNull
    @Column(columnDefinition = "VARCHAR", length = 100)
    private String author;

    @Column(columnDefinition = "VARCHAR", length = 1000)
    private String blurb;

    private int pages;

    public Book(long id, @NotNull String title, @NotNull String author, String blurb, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.blurb = blurb;
        this.pages = pages;
    }
}
