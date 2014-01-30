package com.noveo.tulupov.trainings.booklibrary.servlet.view;

import com.noveo.tulupov.trainings.booklibrary.dao.AuthorDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "AuthorViewServlet", urlPatterns = "/authors")
public class AuthorViewServlet extends ViewServlet {
    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        AuthorDao dao = (AuthorDao) request.getAttribute(ServletFilter.AUTHOR_DAO);
        String deleteParam = request.getParameter("delete");
        if (deleteParam != null) {
            dao.deleteAuthor(Integer.parseInt(deleteParam));
        }
    }

    @Override
    protected Object getContent(HttpServletRequest request) throws Exception {
        AuthorDao dao = (AuthorDao) request.getAttribute(ServletFilter.AUTHOR_DAO);
        return dao.getAuthors();
    }

    @Override
    protected String getTablePage() {
        return "author.jsp";
    }

    @Override
    public String getAddPage() {
        return "addAuthor";
    }
}
