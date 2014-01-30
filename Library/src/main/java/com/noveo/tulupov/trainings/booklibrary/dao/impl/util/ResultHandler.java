package com.noveo.tulupov.trainings.booklibrary.dao.impl.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultHandler {
    void onNextRow(ResultSet result) throws SQLException;
}
