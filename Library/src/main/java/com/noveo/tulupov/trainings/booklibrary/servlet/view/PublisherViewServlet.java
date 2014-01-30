package com.noveo.tulupov.trainings.booklibrary.servlet.view;

import com.noveo.tulupov.trainings.booklibrary.dao.PublisherDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "PublisherViewServlet", urlPatterns = "/publishers")
public class PublisherViewServlet extends ViewServlet {
    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        PublisherDao dao = (PublisherDao) request.getAttribute(ServletFilter.PUBLISHER_DAO);
        String deleteParam = request.getParameter("delete");
        if (deleteParam != null) {
            dao.deletePublisher(Integer.parseInt(deleteParam));
        }
    }

    @Override
    protected Object getContent(HttpServletRequest request) throws Exception {
        PublisherDao dao = (PublisherDao) request.getAttribute(ServletFilter.PUBLISHER_DAO);
        return dao.getPublishers();
    }

    @Override
    protected String getTablePage() {
        return "publisher.jsp";
    }

    @Override
    public String getAddPage() {
        return "addPublisher";
    }
}
