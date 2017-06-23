//package com.abugrov.servlets;
//
//import com.abugrov.models.Show;
//import com.abugrov.models.enums.*;
//import com.abugrov.store.ShowStorage;
//import java.io.IOException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.junit.After;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//
//public class ShowCreateServletTest extends Mockito {
//    final ShowStorage cache = ShowStorage.getInstance();
//    HttpServletRequest req;
//    HttpServletResponse resp;
//    RequestDispatcher dispatcher;
//    
//    @Before
//    public void setUp() throws Exception {
//        req = mock(HttpServletRequest.class);
//        resp = mock(HttpServletResponse.class);
//        dispatcher = mock(RequestDispatcher.class);
//    }
//    
//    @After
//    public void tearDown() throws Exception {
//        req = null;
//        resp = null;
//        dispatcher = null;
//    }
//    
//    @Test
//    public void testDoPost() throws ServletException, IOException {
//	
//	when(req.getParameter("name")).thenReturn("test");
//	when(req.getParameter("datetime")).thenReturn("1997-11-21'T'00:00"); 
//	when(req.getParameter("type")).thenReturn(ShowType.Concert.toString());
//	when(req.getParameter("place")).thenReturn(ShowPlace.Atlas.toString());
//	when(req.getParameter("description")).thenReturn("test");
//	
//	assertTrue(cache.values().isEmpty());
//	
//	new ShowCreateServlet().doPost(req, resp);
//	
//	verify(req, atLeast(1)).getParameter("name");
//	verify(req, atLeast(1)).getParameter("datetime");
//	verify(req, atLeast(1)).getParameter("type");
//	verify(req, atLeast(1)).getParameter("place");
//	verify(req, atLeast(1)).getParameter("description");
//	
//	assertFalse(cache.values().isEmpty());
//	
//	for(Show show : cache.find("name", "test")) {
//	    cache.delete(show.getId());
//	}
//    }
//    
//    @Test
//    public void testDoGet() throws ServletException, IOException { 
//	when(req.getRequestDispatcher("/views/show/ShowCreate.jsp")).thenReturn(dispatcher);
//	
//	new ShowCreateServlet().doGet(req, resp);
//	
//	verify(req, atLeast(1)).getRequestDispatcher("/views/show/ShowCreate.jsp");
//    }
//    
//    @Test
//    public void badArguments() throws ServletException, IOException {
//	
//	when(req.getParameter("name")).thenReturn(null);
//	when(req.getParameter("datetime")).thenReturn("123"); 
//	when(req.getParameter("type")).thenReturn(null);
//	when(req.getParameter("place")).thenReturn(null);
//	when(req.getParameter("description")).thenReturn(null);
//	
//	assertTrue(cache.values().isEmpty());
//	
//	new ShowCreateServlet().doPost(req, resp);
//	
//	verify(req, atLeast(1)).getParameter("name");
//	verify(req, atLeast(1)).getParameter("datetime");
//	verify(req, atLeast(1)).getParameter("type");
//	verify(req, atLeast(1)).getParameter("place");
//	verify(req, atLeast(1)).getParameter("description");
//	
//	assertFalse(cache.values().isEmpty());
//    }
//}
