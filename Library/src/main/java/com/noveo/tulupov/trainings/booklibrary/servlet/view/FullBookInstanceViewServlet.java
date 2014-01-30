package com.noveo.tulupov.trainings.booklibrary.servlet.view;

import com.noveo.tulupov.trainings.booklibrary.dao.BookInstanceDao;
import com.noveo.tulupov.trainings.booklibrary.filter.ServletFilter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "FullBookInstanceViewServlet", urlPatterns = {"/show","/"})
public class FullBookInstanceViewServlet extends ViewServlet {
    @Override
    protected void parseParameters(HttpServletRequest request) throws Exception {
        BookInstanceDao dao = (BookInstanceDao) request.getAttribute(ServletFilter.BOOKINSTANCE_DAO);
        String deleteParam = request.getParameter("delete");
        if (deleteParam != null) {
            dao.deleteBookInstance(Integer.parseInt(deleteParam));
        }
    }


    @Override
    protected Object getContent(HttpServletRequest request) throws Exception {
        BookInstanceDao dao = (BookInstanceDao) request.getAttribute(ServletFilter.BOOKINSTANCE_DAO);
        return dao.getFullBookInstances();
    }

    @Override
    protected String getTablePage() {
        return "fullbookinstance.jsp";
    }

    @Override
    public String getAddPage() {
        return "createBook";
    }
}
