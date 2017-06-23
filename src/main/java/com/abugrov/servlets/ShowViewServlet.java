package com.abugrov.servlets;

import com.abugrov.models.enums.*;
import com.abugrov.store.ShowStorage;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowViewServlet extends HttpServlet {

	private final ShowStorage SHOW_STORAGE = ShowStorage.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("shows", this.SHOW_STORAGE.values());
		req.setAttribute("types", ShowType.valuesAsStrings());
		req.setAttribute("places", ShowPlace.valuesAsStrings());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/show/ShowView.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	public void destroy() {
	    super.destroy();
	    SHOW_STORAGE.close();
	}
}