package com.noveo.tulupov.trainings.booklibrary.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private List<Author> authors;

    public Book() {
        authors = new ArrayList<Author>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
