package com.noveo.tulupov.trainings.booklibrary.servlet.add;

import com.noveo.tulupov.trainings.booklibrary.dao.BookDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;
import com.noveo.tulupov.trainings.booklibrary.model.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "BookAddServlet", urlPatterns = "/addBook")
public class BookAddServlet extends AddServlet {
    @Override
    protected String getFormPage() {
        return "book.jsp";
    }

    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        Book book = new Book();
        BookDao dao = (BookDao) request.getAttribute(ServletFilter.BOOK_DAO);
        book.setTitle(getParam(request, "title"));
        dao.addBook(book);
    }

    @Override
    protected void saveParameters(HttpServletRequest request) {
        request.setAttribute("title", request.getParameter("title"));
    }

    @Override
    protected String getRedirectUrl() {
        return "books";
    }

    @Override
    protected String getFormTitle() {
        return "New book";
    }

}
