package com.noveo.tulupov.trainings.booklibrary.dao;

import com.noveo.tulupov.trainings.booklibrary.model.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {
    List<Author> getAuthors() throws SQLException;

    void addAuthor(Author author) throws SQLException;

    void deleteAuthor(int id) throws SQLException;


}
