package com.noveo.tulupov.trainings.booklibrary.dao.impl;

import com.noveo.tulupov.trainings.booklibrary.dao.AuthorDao;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.QueryExecutor;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.ResultHandler;
import com.noveo.tulupov.trainings.booklibrary.model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private final Connection connection;

    public AuthorDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Author> getAuthors() throws SQLException {
        final List<Author> authors = new ArrayList<Author>();
        PreparedStatement selectQuery = connection.prepareStatement("SELECT * FROM Author");
        QueryExecutor.executeQuery(selectQuery, new ResultHandler() {
            @Override
            public void onNextRow(ResultSet result) throws SQLException {
                final Author author = new Author();
                author.setId(result.getInt("id"));
                author.setName(result.getString("name"));
                authors.add(author);
            }
        });

        return authors;
    }

    @Override
    public void addAuthor(Author author) throws SQLException {
        PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO Author (name) VALUES(?)");
        insertQuery.setString(1, author.getName());
        QueryExecutor.executeQuery(insertQuery);
    }

    @Override
    public void deleteAuthor(int id) throws SQLException {
        PreparedStatement deleteQuery = connection.prepareStatement("DELETE FROM Author WHERE id = ?");
        deleteQuery.setInt(1, id);
        QueryExecutor.executeQuery(deleteQuery);
    }


}
