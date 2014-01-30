package com.noveo.tulupov.trainings.booklibrary.servlet.add;

import com.noveo.tulupov.trainings.booklibrary.dao.BookInstanceDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;
import com.noveo.tulupov.trainings.booklibrary.model.Author;
import com.noveo.tulupov.trainings.booklibrary.model.Book;
import com.noveo.tulupov.trainings.booklibrary.model.BookInstance;
import com.noveo.tulupov.trainings.booklibrary.model.Publisher;
import com.noveo.tulupov.trainings.booklibrary.util.validator.ValidatorFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CreateBookServlet", urlPatterns = "/createBook")
public class CreateBookServlet extends AddServlet {
    @Override
    protected String getFormPage() {
        return "createbook.jsp";
    }

    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        List<BookInstance> bookInstances = new ArrayList<BookInstance>();
        BookInstanceDao dao = (BookInstanceDao) request.getAttribute(ServletFilter.BOOKINSTANCE_DAO);

        Book book = new Book();
        book.setTitle(getParam(request, "title"));
        for (String authorName : request.getParameterValues("author[]")) {
            Author author = new Author();
            author.setName(authorName);
            book.getAuthors().add(author);
        }

        String[] publishers = getParams(request, "publisher[]");
        String[] years = getParams(request, "year[]");
        String[] isbns = getParams(request, "isbn[]");

        for (String value : years) {
            ValidatorFactory.getDateValidator().validate(value);
        }

        for (String value : isbns) {
            ValidatorFactory.getIsbnValidator().validate(value);
        }

        for (int i = 0; i < publishers.length; i++) {
            BookInstance bookInstance = new BookInstance();
            bookInstance.setBook(book);
            Publisher publisher = new Publisher();
            publisher.setName(publishers[i]);
            bookInstance.setPublisher(publisher);
            bookInstance.setYear(Integer.parseInt(years[i]));
            bookInstance.setIsbn(isbns[i]);
            bookInstances.add(bookInstance);
        }

        dao.addBookInstances(bookInstances);
    }

    @Override
    protected void saveParameters(HttpServletRequest request) {
        request.setAttribute("name", request.getParameter("name"));
    }

    @Override
    protected String getRedirectUrl() {
        return "/createBook";
    }

    @Override
    protected String getFormTitle() {
        return "Create book";
    }
}
