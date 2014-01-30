package com.noveo.tulupov.trainings.booklibrary.dao.impl;

import com.noveo.tulupov.trainings.booklibrary.dao.BookAuthorDao;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.QueryExecutor;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.ResultHandler;
import com.noveo.tulupov.trainings.booklibrary.model.BookAuthor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookAuthorDaoImpl implements BookAuthorDao {

    private final Connection connection;

    public BookAuthorDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<BookAuthor> getBookAuthors() throws SQLException {
        final List<BookAuthor> authors = new ArrayList<BookAuthor>();


        PreparedStatement selectQuery = connection.prepareStatement("SELECT * FROM BookAuthor");
        QueryExecutor.executeQuery(selectQuery, new ResultHandler() {
            @Override
            public void onNextRow(ResultSet result) throws SQLException {
                final BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setBookId(result.getInt("book_id"));
                bookAuthor.setAuthorId(result.getInt("author_id"));
                authors.add(bookAuthor);
            }
        });

        return authors;
    }

    @Override
    public void addBookAuthor(BookAuthor bookAuthor) throws SQLException {
        PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO BookAuthor (book_id, author_id) VALUES(?, ?)");
        insertQuery.setInt(1, bookAuthor.getBookId());
        insertQuery.setInt(2, bookAuthor.getAuthorId());

        QueryExecutor.executeQuery(insertQuery);
    }

    @Override
    public void deleteBookAuthor(BookAuthor bookAuthor) throws SQLException {
        PreparedStatement deleteQuery = connection.prepareStatement("DELETE FROM BookAuthor WHERE author_id = ? AND book_id = ?");
        deleteQuery.setInt(1, bookAuthor.getAuthorId());
        deleteQuery.setInt(2, bookAuthor.getBookId());
        QueryExecutor.executeQuery(deleteQuery);
    }
}
