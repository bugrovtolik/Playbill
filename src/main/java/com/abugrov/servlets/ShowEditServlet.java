package com.abugrov.servlets;

import com.abugrov.models.Show;
import com.abugrov.models.enums.*;
import com.abugrov.store.ShowStorage;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowEditServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();

    private static final ShowStorage SHOW_STORAGE = ShowStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("show", this.SHOW_STORAGE.get(Integer.valueOf(req.getParameter("id"))));
	    req.setAttribute("types", ShowType.valuesAsStrings());
	    req.setAttribute("places", ShowPlace.valuesAsStrings());
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/show/ShowEdit.jsp");
	    dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    this.SHOW_STORAGE.edit(new Show(this.ids.incrementAndGet(), req.getParameter("name"), req.getParameter("datetime"), req.getParameter("type"), req.getParameter("place"), req.getParameter("description")));
	    resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/view"));
    }
}