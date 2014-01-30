package com.noveo.tulupov.trainings.booklibrary.servlet.add;

import com.noveo.tulupov.trainings.booklibrary.dao.PublisherDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;
import com.noveo.tulupov.trainings.booklibrary.model.Publisher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "PublisherAddServlet", urlPatterns = "/addPublisher")
public class PublisherAddServlet extends AddServlet {
    @Override
    protected String getFormPage() {
        return "author.jsp";
    }

    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        Publisher publisher = new Publisher();
        PublisherDao dao = (PublisherDao) request.getAttribute(ServletFilter.PUBLISHER_DAO);


        publisher.setName(getParam(request, "name"));


        dao.addPublisher(publisher);


    }

    @Override
    protected void saveParameters(HttpServletRequest request) {
        request.setAttribute("name", request.getParameter("name"));
    }

    @Override
    protected String getRedirectUrl() {
        return "publishers";
    }

    @Override
    protected String getFormTitle() {
        return "New publisher";
    }
}
