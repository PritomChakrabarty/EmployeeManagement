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

@WebServlet("/hi")
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student myStudent=new Student(101, "Pritom", 20);
		req.setAttribute("myStudent",myStudent);
		
		
		RequestDispatcher dis=req.getRequestDispatcher("demo1.jsp");
		dis.forward(req, resp);
	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Student myStudent=new Student(101, "Pritom", 20);
//		req.setAttribute("myStudent",myStudent);
//		
//		RequestDispatcher dis=req.getRequestDispatcher("demo1.jsp");
//		dis.forward(req, resp);
//	}
	
	//---------------------------------------------------------------
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//resp.sendRedirect("login.html");
//		String user = req.getParameter("username");
//		String password = req.getParameter("username");
//		HttpSession hs=req.getSession();
//		hs.setAttribute("username", user);
//		hs.setAttribute("password", password);
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.html");
//		dispatcher.forward(req, resp);
//		
//	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		Cookie c1 = new Cookie("username", "Pritom");
//		Cookie c2 = new Cookie("password", "Pritom@123");
//
//		resp.addCookie(c1);
//		resp.addCookie(c2);
//
//		PrintWriter get = resp.getWriter();
//		get.print("<h1>Cookies are Created</h1>");
//
//	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		ServletContext con=req.getServletContext();
//		con.setAttribute("pi", "3.142");
//		System.out.println("Context Created");
//		
//	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		resp.sendRedirect("hello.html");
//		HttpSession session=req.getSession();
//		Student stu=new Student(101, "Pritom", 25);
//		session.setAttribute("MyStudent", stu);
//		//session.setAttribute("password", "pritom@123");
//		
//		System.out.println("Session created");
//	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// String user = req.getParameter("username");
//		// String password = req.getParameter("password");
//
//		Cookie c1 = new Cookie("user", "Pritom");
//		Cookie c2 = new Cookie("password", "java@123");
//
//		resp.addCookie(c1);
//		resp.addCookie(c2);
//
//		PrintWriter print = resp.getWriter();
//		print.print("<h1>Cookies are Created</h1>");
//
//	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String user = req.getParameter("username");
//		
//		if (user.equals("Pritom")) {
//			RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.html");
//			dispatcher.forward(req, resp);
//			//System.out.println(user);
//		} else {
//			PrintWriter print=resp.getWriter();
//			print.print("<h1>Invalid Username</h1>");
//			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
//			dispatcher.include(req, resp);
//		}
//		RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.html");
//		
//		dispatcher.forward(req, resp);
//		System.out.println(user);
//	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name=req.getParameter("name");
//		String email=req.getParameter("email");
//		String age=req.getParameter("age");
//		
//		PrintWriter get=resp.getWriter();
//		get.print("<h1>"+name+"<h1>");
//		get.print("<h1>"+email+"<h1>");
//		get.print("<h1>"+age+"<h1>");
//		//get.println(name+" "+email+" "+age);
//	}

//	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	int i = Integer.parseInt(req.getParameter("num1"));
//	int j = Integer.parseInt(req.getParameter("num2"));
//	
//	int k = i + j;
//	PrintWriter out = resp.getWriter();
//
//	out.println("Result is : " + k);
//}
}
