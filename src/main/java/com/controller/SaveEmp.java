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

@WebServlet("/register")
public class SaveEmp extends HttpServlet {
	private RequestDispatcher dispatcher;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		int salary = Integer.parseInt(req.getParameter("salary"));

		Employee e1 = new Employee(id, name, age, email, salary);

		EmpService service = new EmpService();

		int no = service.saveEmp(e1);
		if (no != 0) {
			dispatcher = req.getRequestDispatcher("welcome.html");
			dispatcher.forward(req, resp);
		} else {
			PrintWriter print = resp.getWriter();
			print.write("<h1>Data not Saved</h1>");
		}
	}
}
