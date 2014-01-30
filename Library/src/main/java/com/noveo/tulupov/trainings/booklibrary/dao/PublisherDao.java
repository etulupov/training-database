package com.noveo.tulupov.trainings.booklibrary.dao;

import com.noveo.tulupov.trainings.booklibrary.model.Publisher;

import java.sql.SQLException;
import java.util.List;

public interface PublisherDao {
    List<Publisher> getPublishers() throws SQLException;

    void addPublisher(Publisher publisher) throws SQLException;

    void deletePublisher(int id) throws SQLException;
}
