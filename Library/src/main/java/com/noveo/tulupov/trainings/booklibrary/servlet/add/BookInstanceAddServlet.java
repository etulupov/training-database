package com.noveo.tulupov.trainings.booklibrary.servlet.add;

import com.noveo.tulupov.trainings.booklibrary.dao.BookInstanceDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;
import com.noveo.tulupov.trainings.booklibrary.model.BookInstance;
import com.noveo.tulupov.trainings.booklibrary.util.validator.ValidatorFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "BookInstanceAddServlet", urlPatterns = "/addBookInstance")
public class BookInstanceAddServlet extends AddServlet {
    @Override
    protected String getFormPage() {
        return "bookinstance.jsp";
    }

    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        BookInstance bookInstance = new BookInstance();
        BookInstanceDao dao = (BookInstanceDao) request.getAttribute(ServletFilter.BOOKINSTANCE_DAO);
        bookInstance.setBookId(Integer.parseInt(getParam(request, "book_id")));
        bookInstance.setPublisherId(Integer.parseInt(getParam(request, "publisher_id")));

        ValidatorFactory.getDateValidator().validate(getParam(request, "year"));
        bookInstance.setYear(Integer.parseInt(getParam(request, "year")));

        ValidatorFactory.getIsbnValidator().validate(getParam(request, "isbn"));
        bookInstance.setIsbn(getParam(request, "isbn"));

        dao.addBookInstance(bookInstance);
    }

    @Override
    protected void saveParameters(HttpServletRequest request) {
        final String[] params = {"book_id", "publisher_id", "year", "isbn"};
        for (String param : params) {
            request.setAttribute(param, request.getParameter(param));
        }

    }

    @Override
    protected String getRedirectUrl() {
        return "bookinstances";
    }

    @Override
    protected String getFormTitle() {
        return "New book instance";
    }
}
