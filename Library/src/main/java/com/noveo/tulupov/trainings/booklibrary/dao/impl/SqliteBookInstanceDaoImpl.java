package com.noveo.tulupov.trainings.booklibrary.dao.impl;

import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.QueryExecutor;
import com.noveo.tulupov.trainings.booklibrary.model.Author;
import com.noveo.tulupov.trainings.booklibrary.model.Book;
import com.noveo.tulupov.trainings.booklibrary.model.BookInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SqliteBookInstanceDaoImpl extends BookInstanceDaoImpl {
    public SqliteBookInstanceDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public void addBookInstances(List<BookInstance> bookInstances) throws SQLException {
        if (bookInstances.isEmpty()) {
            return;
        }
        connection.setAutoCommit(false);
        try {
            Book book = bookInstances.get(0).getBook();
            PreparedStatement bookInsertQuery = connection.prepareStatement("INSERT INTO Book (title) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            bookInsertQuery.setString(1, book.getTitle());

            int bookId = QueryExecutor.execute(bookInsertQuery);

            PreparedStatement bookAuthorInsertQuery = connection.prepareStatement("INSERT INTO BookAuthor (book_id, author_id) VALUES (?, ?)");
            for (Author author : book.getAuthors()) {
                PreparedStatement authorInsertQuery = connection.prepareStatement("INSERT INTO Author (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                authorInsertQuery.setString(1, author.getName());

                bookAuthorInsertQuery.setInt(1, bookId);
                bookAuthorInsertQuery.setInt(2, QueryExecutor.execute(authorInsertQuery));
                bookAuthorInsertQuery.addBatch();
            }
            QueryExecutor.executeBatch(bookAuthorInsertQuery);


            PreparedStatement bookInstanceInsertQuery = connection.prepareStatement("INSERT INTO BookInstance (book_id, publisher_id, year, isbn) VALUES (?, ?, ?, ?)");

            for (BookInstance bookInstance : bookInstances) {
                PreparedStatement publisherInsertQuery = connection.prepareStatement("INSERT INTO Publisher (name) VALUES (?)");
                publisherInsertQuery.setString(1, bookInstance.getPublisher().getName());

                bookInstanceInsertQuery.setInt(1, bookId);
                bookInstanceInsertQuery.setInt(2, QueryExecutor.execute(publisherInsertQuery));
                bookInstanceInsertQuery.setInt(3, bookInstance.getYear());
                bookInstanceInsertQuery.setString(4, bookInstance.getIsbn());
                bookInstanceInsertQuery.addBatch();
            }
            QueryExecutor.executeBatch(bookInstanceInsertQuery);

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
