package com.noveo.tulupov.trainings.booklibrary.dao;

import com.noveo.tulupov.trainings.booklibrary.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> getBooks() throws SQLException;

    void deleteBook(int id) throws SQLException;

    void addBook(Book book) throws SQLException;

}
