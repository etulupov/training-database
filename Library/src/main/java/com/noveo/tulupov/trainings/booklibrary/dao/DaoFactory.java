package com.noveo.tulupov.trainings.booklibrary.dao;

import java.sql.Connection;

public interface DaoFactory {
    AuthorDao createAuthorDao(Connection connection);

    BookAuthorDao createBookAuthorDao(Connection connection);

    BookDao createBookDao(Connection connection);

    BookInstanceDao createBookInstanceDao(Connection connection);

    PublisherDao createPublisherDao(Connection connection);
}
