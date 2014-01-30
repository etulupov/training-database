package com.noveo.tulupov.trainings.booklibrary.dao.impl;

import com.noveo.tulupov.trainings.booklibrary.dao.PublisherDao;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.QueryExecutor;
import com.noveo.tulupov.trainings.booklibrary.dao.impl.util.ResultHandler;
import com.noveo.tulupov.trainings.booklibrary.model.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDaoImpl implements PublisherDao {

    private final Connection connection;

    public PublisherDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Publisher> getPublishers() throws SQLException {
        final List<Publisher> publishers = new ArrayList<Publisher>();
        PreparedStatement selectQuery = connection.prepareStatement("SELECT * FROM Publisher");
        QueryExecutor.executeQuery(selectQuery, new ResultHandler() {
            @Override
            public void onNextRow(ResultSet result) throws SQLException {
                final Publisher publisher = new Publisher();
                publisher.setId(result.getInt("id"));
                publisher.setName(result.getString("name"));
                publisher.setBookCount(result.getInt("book_count"));
                publishers.add(publisher);
            }
        });

        return publishers;
    }

    @Override
    public void addPublisher(Publisher publisher) throws SQLException {
        PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO Publisher (name) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        insertQuery.setString(1, publisher.getName());
        QueryExecutor.executeQuery(insertQuery);
    }

    @Override
    public void deletePublisher(int id) throws SQLException {
        PreparedStatement deleteQuery = connection.prepareStatement("DELETE FROM Publisher WHERE id = ?");
        deleteQuery.setInt(1, id);
        QueryExecutor.executeQuery(deleteQuery);
    }
}
