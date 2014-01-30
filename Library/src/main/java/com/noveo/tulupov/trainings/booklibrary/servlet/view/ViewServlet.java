package com.noveo.tulupov.trainings.booklibrary.servlet.view;

import com.noveo.tulupov.trainings.booklibrary.servlet.MainServlet;
import com.noveo.tulupov.trainings.booklibrary.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewServlet")
public abstract class ViewServlet extends MainServlet {

    protected abstract void parseParameters(HttpServletRequest request) throws Exception;


    protected abstract Object getContent(HttpServletRequest request) throws Exception;

    protected abstract String getTablePage();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getContentPage() {
        return "view/template.jsp";
    }

    public abstract String getAddPage();

    protected void doGet(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            parseParameters(request);
        } catch (Exception e) {
            request.setAttribute(MainServlet.ERROR_MESSAGE, e.getMessage());
        }

        try {
            request.setAttribute("tableData", getContent(request));
        } catch (Exception e) {
            request.setAttribute(MainServlet.ERROR_MESSAGE, e.getMessage());
        }

        request.setAttribute("addPage", getAddPage());


        //  Pair<String,String>[] viewerPaths = {new Pair<String, String>("/books", "/authors")};  //"/books", "/authors", "/publishers"
        List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
        list.add(new Pair<String, String>("books", "Book"));
        list.add(new Pair<String, String>("authors", "Author"));
        list.add(new Pair<String, String>("publishers", "Publisher"));
        list.add(new Pair<String, String>("bookinstances", "BookInstance"));
        list.add(new Pair<String, String>("bookauthors", "BookAuthor"));
        request.setAttribute("viewerPaths", list);
        request.setAttribute("servletPath", request.getServletPath());

        request.setAttribute("menuPage", "menu.jsp");
        request.setAttribute("tablePage", getTablePage());


        super.doGet(request, response);
    }

}
