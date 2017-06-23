package com.abugrov.servlets;

import com.abugrov.models.enums.*;
import com.abugrov.store.ShowStorage;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSearchServlet extends HttpServlet {
    
    private static final ShowStorage SHOW_STORAGE = ShowStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("types", new Gson().toJson(ShowType.valuesAsStrings()));
	req.setAttribute("places", new Gson().toJson(ShowPlace.valuesAsStrings()));
	RequestDispatcher dispatcher = req.getRequestDispatcher("/views/show/ShowSearch.jsp");
	dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("shows", this.SHOW_STORAGE.find(String.valueOf(req.getParameter("by")),String.valueOf(req.getParameter("value"))));
	RequestDispatcher dispatcher = req.getRequestDispatcher("/views/show/ShowView.jsp");
	dispatcher.forward(req, resp);
    }
}
