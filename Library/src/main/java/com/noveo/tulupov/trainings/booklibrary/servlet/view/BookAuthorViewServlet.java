package com.noveo.tulupov.trainings.booklibrary.servlet.view;

import com.noveo.tulupov.trainings.booklibrary.dao.BookAuthorDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;
import com.noveo.tulupov.trainings.booklibrary.model.BookAuthor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "BookAuthorViewServlet", urlPatterns = "/bookauthors")
public class BookAuthorViewServlet extends ViewServlet {
    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        BookAuthorDao dao = (BookAuthorDao) request.getAttribute(ServletFilter.BOOKAUTHOR_DAO);
        String authorIdParam = request.getParameter("authorId");
        String bookIdParam = request.getParameter("bookId");
        if (authorIdParam != null && bookIdParam != null) {
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setAuthorId(Integer.parseInt(authorIdParam));
            bookAuthor.setBookId(Integer.parseInt(bookIdParam));
            dao.deleteBookAuthor(bookAuthor);
        }
    }

    @Override
    protected Object getContent(HttpServletRequest request) throws Exception {
        BookAuthorDao dao = (BookAuthorDao) request.getAttribute(ServletFilter.BOOKAUTHOR_DAO);
        return dao.getBookAuthors();
    }

    @Override
    protected String getTablePage() {
        return "bookauthor.jsp";
    }

    @Override
    public String getAddPage() {
        return "addBookAuthor";
    }
}
