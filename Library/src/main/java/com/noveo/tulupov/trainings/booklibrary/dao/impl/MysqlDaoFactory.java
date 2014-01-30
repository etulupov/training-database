package com.noveo.tulupov.trainings.booklibrary.dao.impl;

import com.noveo.tulupov.trainings.booklibrary.dao.*;

import java.sql.Connection;

public class MysqlDaoFactory extends CommonDaoFactory {

    @Override
    public BookInstanceDao createBookInstanceDao(Connection connection) {
        return new BookInstanceDaoImpl(connection);
    }

}
