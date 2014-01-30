package com.noveo.tulupov.trainings.booklibrary.servlet.add;

import com.noveo.tulupov.trainings.booklibrary.servlet.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet")
public abstract class AddServlet extends MainServlet {
    public static final String FORM_PAGE = "formPage";
    public static final String FORM_TITLE = "formTitle";

    protected abstract void parseParameters(HttpServletRequest request) throws Exception;

    protected abstract void saveParameters(HttpServletRequest request);

    protected String getParam(HttpServletRequest request, String paramName) throws Exception {
        String param = request.getParameter(paramName);
        if ("".equals(param)) {
            throw new Exception(String.format("Parameter '%s' is empty!", paramName));
        }
        return param;
    }

    protected String[] getParams(HttpServletRequest request, String paramName) throws Exception {
        String params[] = request.getParameterValues(paramName);
        for (String param : params) {
            if ("".equals(param)) {
                throw new Exception(String.format("Parameter '%s' is empty!", paramName));
            }
        }
        return params;
    }

    protected abstract String getRedirectUrl();

    @Override
    public String getContentPage() {
        return "add-form/template.jsp";
    }

    protected abstract String getFormPage();

    protected abstract String getFormTitle();

    protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            parseParameters(request);
            response.sendRedirect(getRedirectUrl());
        } catch (Exception e) {
            request.setAttribute(MainServlet.ERROR_MESSAGE, e.getMessage());
            saveParameters(request);
            doGet(request, response);
            e.printStackTrace();
        }
    }

    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(FORM_PAGE, getFormPage());
        request.setAttribute(FORM_TITLE, getFormTitle());
        super.doGet(request, response);
    }
}
