package com.noveo.tulupov.trainings.booklibrary.dao;

import com.noveo.tulupov.trainings.booklibrary.model.BookInstance;

import java.sql.SQLException;
import java.util.List;

public interface BookInstanceDao {
    List<BookInstance> getBookInstances() throws SQLException;

    void addBookInstance(BookInstance bookInstance) throws SQLException;

    void deleteBookInstance(int id) throws SQLException;

    void addBookInstances(List<BookInstance> bookInstances) throws SQLException;

    List<List<BookInstance>> getFullBookInstances() throws SQLException;
}
