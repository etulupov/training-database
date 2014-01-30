package com.noveo.tulupov.trainings.booklibrary.dao.impl;
import com.noveo.tulupov.trainings.booklibrary.dao.*;

import java.sql.Connection;

public abstract class CommonDaoFactory implements DaoFactory {
    @Override
    public AuthorDao createAuthorDao(Connection connection) {
        return new AuthorDaoImpl(connection);
    }

    @Override
    public BookAuthorDao createBookAuthorDao(Connection connection) {
        return new BookAuthorDaoImpl(connection);
    }

    @Override
    public BookDao createBookDao(Connection connection) {
        return new BookDaoImpl(connection);
    }



    @Override
    public PublisherDao createPublisherDao(Connection connection) {
        return new PublisherDaoImpl(connection);
    }
}
