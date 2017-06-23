package com.abugrov.servlets;

import com.abugrov.store.ShowStorage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDeleteServlet extends HttpServlet {

	private static final ShowStorage SHOW_STORAGE = ShowStorage.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SHOW_STORAGE.delete(Integer.valueOf(req.getParameter("id")));
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/view"));
	}
}