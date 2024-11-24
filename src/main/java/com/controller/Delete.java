package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpService;
@WebServlet("/delete")
public class Delete extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		EmpService es=new EmpService();
		int no=es.deleteEmp(id);
		if (no > 0) {
			RequestDispatcher rd= req.getRequestDispatcher("welcome.html");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd= req.getRequestDispatcher("delete.html");
			rd.forward(req, resp);
		}
	}
}
