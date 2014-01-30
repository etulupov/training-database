package com.noveo.tulupov.trainings.booklibrary.dao.impl;

import com.noveo.tulupov.trainings.booklibrary.dao.BookDao;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.QueryExecutor;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.ResultHandler;
import com.noveo.tulupov.trainings.booklibrary.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private Connection connection;

    public BookDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> getBooks() throws SQLException {
        final List<Book> books = new ArrayList<Book>();
        PreparedStatement selectQuery = connection.prepareStatement("SELECT * FROM Book");
        QueryExecutor.executeQuery(selectQuery, new ResultHandler() {
            @Override
            public void onNextRow(ResultSet result) throws SQLException {
                final Book book = new Book();
                book.setId(result.getInt("id"));
                book.setTitle(result.getString("title"));
                books.add(book);
            }
        });

        return books;
    }

    @Override
    public void deleteBook(int id) throws SQLException {
        PreparedStatement deleteQuery = connection.prepareStatement("DELETE FROM Book WHERE id = ?");
        deleteQuery.setInt(1, id);
        QueryExecutor.executeQuery(deleteQuery);
    }

    @Override
    public void addBook(Book book) throws SQLException {
        PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO Book (title) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        insertQuery.setString(1, book.getTitle());
        QueryExecutor.executeQuery(insertQuery);
    }
}
