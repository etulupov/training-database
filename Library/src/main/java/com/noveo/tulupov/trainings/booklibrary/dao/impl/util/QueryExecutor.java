package com.noveo.tulupov.trainings.booklibrary.dao.impl.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutor {

    public static void executeQuery(PreparedStatement statement, ResultHandler handler) throws SQLException {
        try {
            final ResultSet result = statement.executeQuery();

            while (result.next()) {
                if (handler != null) {
                    handler.onNextRow(result);
                }
            }
        } finally {
            statement.close();
        }
    }

    public static void executeQuery(PreparedStatement statement) throws SQLException {
        try {
            statement.execute();
        } finally {
            statement.close();
        }
    }

    public static int execute(PreparedStatement statement) throws SQLException {
        try {
            statement.execute();
            ResultSet result = statement.getGeneratedKeys();
            return result.getInt(1);
        } finally {
            statement.close();
        }
    }

    public static void executeBatch(PreparedStatement statement) throws SQLException {
        try {
            statement.executeBatch();
        } finally {
            statement.close();
        }
    }
}
