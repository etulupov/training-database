package com.noveo.tulupov.trainings.booklibrary.servlet.add;

import com.noveo.tulupov.trainings.booklibrary.dao.AuthorDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;
import com.noveo.tulupov.trainings.booklibrary.model.Author;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "AuthorAddServlet", urlPatterns = "/addAuthor")
public class AuthorAddServlet extends AddServlet {
    @Override
    protected String getFormPage() {
        return "author.jsp";
    }

    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        Author author = new Author();
        AuthorDao dao = (AuthorDao) request.getAttribute(ServletFilter.AUTHOR_DAO);
        author.setName(getParam(request, "name"));
        dao.addAuthor(author);
    }

    @Override
    protected void saveParameters(HttpServletRequest request) {
        request.setAttribute("name", request.getParameter("name"));
    }

    @Override
    protected String getRedirectUrl() {
        return "authors";
    }

    @Override
    protected String getFormTitle() {
        return "New author";
    }
}
