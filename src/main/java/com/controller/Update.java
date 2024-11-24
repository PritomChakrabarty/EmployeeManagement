package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Employee;
import com.service.EmpService;
@WebServlet("/update")
public class Update extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		String name=req.getParameter("name");
		String age1=req.getParameter("age");
		int age=Integer.parseInt(age1);
		String email=req.getParameter("email");
		String sal1=req.getParameter("salary");
		int salary=Integer.parseInt(sal1);
		Employee e1=new Employee(id, name, age, email, salary);
		
		int no2=EmpService.updateEmp(e1);
		if (no2 > 0) {
			RequestDispatcher rd= req.getRequestDispatcher("welcome.html");
			rd.forward(req, resp);
		} else {
			PrintWriter print = resp.getWriter();
			print.write("<h1>Invalid</h1>");
		}
	}
}
