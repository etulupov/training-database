package com.noveo.tulupov.trainings.booklibrary.filter;

import com.noveo.tulupov.trainings.booklibrary.dao.DaoFactory;
import com.noveo.tulupov.trainings.booklibrary.listener.ContextListener;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(filterName = "ServletFilter", urlPatterns = "*")
public class ServletFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(ServletFilter.class);

    public static final String BOOK_DAO = "book_dao";
    public static final String AUTHOR_DAO = "author_dao";
    public static final String PUBLISHER_DAO = "publisher_dao";
    public static final String BOOKINSTANCE_DAO = "bookinstance_dao";
    public static final String BOOKAUTHOR_DAO = "bookauthor_dao";

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        ServletContext context = req.getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute(ContextListener.CONNECTION_POOL);
        Connection connection = null;






        try {
            connection = dataSource.getConnection();

            DaoFactory factory = (DaoFactory) context.getAttribute(ContextListener.DAO_FACTORY);

            req.setAttribute(BOOK_DAO, factory.createBookDao(connection));
            req.setAttribute(AUTHOR_DAO, factory.createAuthorDao(connection));
            req.setAttribute(PUBLISHER_DAO, factory.createPublisherDao(connection));
            req.setAttribute(BOOKINSTANCE_DAO, factory.createBookInstanceDao(connection));
            req.setAttribute(BOOKAUTHOR_DAO, factory.createBookAuthorDao(connection));
        } catch (SQLException e) {
            LOGGER.error("Error", e);
        }
        chain.doFilter(req, resp);
        try {

            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Error", e);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
