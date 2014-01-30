package com.noveo.tulupov.trainings.booklibrary.servlet.view;

import com.noveo.tulupov.trainings.booklibrary.dao.BookDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "BookViewServlet", urlPatterns = {"/books"})
public class BookViewServlet extends ViewServlet {
    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        BookDao dao = (BookDao) request.getAttribute(ServletFilter.BOOK_DAO);
        String deleteParam = request.getParameter("delete");
        if (deleteParam != null) {
            dao.deleteBook(Integer.parseInt(deleteParam));
        }
    }

    @Override
    protected Object getContent(HttpServletRequest request) throws Exception {
        BookDao dao = (BookDao) request.getAttribute(ServletFilter.BOOK_DAO);
        return dao.getBooks();
    }

    @Override
    protected String getTablePage() {
        return "book.jsp";
    }

    @Override
    public String getAddPage() {
        return "addBook";
    }
}
