package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lg")
public class Second extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String user = req.getParameter("username");

		if (user.equals("Pritom")) {
			session.invalidate();
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		} 

		// ------------------------------------------------------------
//		Cookie[] cks = req.getCookies();
//		if (cks != null) {
//			for (Cookie cookie : cks) {
//				if (cookie.getName().equals("username")) {
//					cookie.setMaxAge(0);
//					PrintWriter prt = resp.getWriter();
//					prt.print("<h1>Cookies are Deleted</h1>");
//				}
//				resp.addCookie(cookie);
//			}
//		}
		// -------------------------------------------------------
//		ServletContext con=req.getServletContext();
//		String pi=(String) con.getAttribute("pi");
//		System.out.println(pi);
		// ---------------------------------------------------------
//		HttpSession session = req.getSession();
//
//		Student st=(Student) session.getAttribute("MyStudent");
//		
//		System.out.println(st.getId()+" "+st.getName()+" "+st.getAge());
		// -------------------------------------------------------------
//		PrintWriter get=resp.getWriter();
//		get.print("<h1>"+id+"<h1>");
//		get.print("<h1>"+name+"<h1>");
//		get.print("<h1>"+age+"<h1>");
		// System.out.println(password);
		// ----------------------------------------------------------
//		Cookie cks[] = req.getCookies();
//		for (Cookie cookie : cks) {
//			System.out.println(cookie.getName() + " " + cookie.getValue());
//		}
	}
}
