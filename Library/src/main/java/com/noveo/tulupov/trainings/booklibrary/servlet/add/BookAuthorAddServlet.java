package com.noveo.tulupov.trainings.booklibrary.servlet.add;

import com.noveo.tulupov.trainings.booklibrary.dao.BookAuthorDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;
import com.noveo.tulupov.trainings.booklibrary.model.BookAuthor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "BookAuthorAddServlet", urlPatterns = "/addBookAuthor")
public class BookAuthorAddServlet extends AddServlet {
    @Override
    protected String getFormPage() {
        return "bookauthor.jsp";
    }

    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        BookAuthor bookAuthor = new BookAuthor();
        BookAuthorDao dao = (BookAuthorDao) request.getAttribute(ServletFilter.BOOKAUTHOR_DAO);
        bookAuthor.setBookId(Integer.parseInt(getParam(request, "book_id")));
        bookAuthor.setAuthorId(Integer.parseInt(getParam(request, "author_id")));
        dao.addBookAuthor(bookAuthor);
    }

    @Override
    protected void saveParameters(HttpServletRequest request) {

        final String[] params = {"book_id", "author_id"};
        for (String param : params) {
            request.setAttribute(param, request.getParameter(param));
        }
    }

    @Override
    protected String getRedirectUrl() {
        return "bookauthors";
    }

    @Override
    protected String getFormTitle() {
        return "New book author";
    }
}
