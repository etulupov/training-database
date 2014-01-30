package com.noveo.tulupov.trainings.booklibrary.dao;

import com.noveo.tulupov.trainings.booklibrary.model.BookAuthor;

import java.sql.SQLException;
import java.util.List;

public interface BookAuthorDao {
    List<BookAuthor> getBookAuthors() throws SQLException;

    void addBookAuthor(BookAuthor bookAuthor) throws SQLException;

    void deleteBookAuthor(BookAuthor bookAuthor) throws SQLException;

}
