package com.noveo.tulupov.trainings.booklibrary.listener;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ContextListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(ContextListener.class);

    public static final String CONNECTION_POOL = "connection_pool";
    public static final String DAO_FACTORY = "dao_factory";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();

        try {

            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");

            String databaseType = (String) envContext.lookup("database-type");
            DataSource dataSource = (DataSource) envContext.lookup(String.format("jdbc/%s-database", databaseType));
            Class<?> daoFactoryClass = Class.forName((String) envContext.lookup(String.format("dao/%s-factory", databaseType)));

            context.setAttribute(CONNECTION_POOL, dataSource);
            context.setAttribute(DAO_FACTORY, daoFactoryClass.newInstance());
        } catch (Exception e) {
            LOGGER.error("Error", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
