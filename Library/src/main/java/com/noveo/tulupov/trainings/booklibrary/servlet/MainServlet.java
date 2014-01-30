package com.noveo.tulupov.trainings.booklibrary.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet")
public abstract class MainServlet extends HttpServlet {
    public static final String CONTENT_PAGE = "contentPage";
    public static final String ERROR_MESSAGE = "errorMessage";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    public abstract String getContentPage();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(MainServlet.CONTENT_PAGE, getContentPage());
        request.getRequestDispatcher("templates/main.jsp").forward(request, response);
    }
}
