package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Employee;
import com.service.EmpService;

@WebServlet("/display")
public class DisplayEmp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpService es= new EmpService();
		List<Employee> e1=es.getAll();
		
		PrintWriter pr= resp.getWriter();
		pr.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n"
				+ "<style>\r\n"
				+ "h1{\r\n"
				+ "	background-color: black;\r\n"
				+ "	color: white;\r\n"
				+ "	padding: 10px;\r\n"
				+ "	justify-content: center;\r\n"
				+ "	align-items: center;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<section class=\"container-fluid text-center\">\r\n"
				+ "	<h1>Employee Details</h1>\r\n"
				+ "        <div class=\"row\">\r\n"
				+ "            <div class=\"col-12\">\r\n"
				+ "            <form action=\"display\">\r\n"
				+ "                <table class=\"table table-bordered border-primary\">\r\n"
				+ "                    <thead class=\"one table-dark\">\r\n"
				+ "                        <tr>\r\n"
				+ "                        <th>Id</th>\r\n"
				+ "                        <th>Name</th>\r\n"
				+ "                        <th>AGE</th>\r\n"
				+ "                        <th>EMAIL</th>\r\n"
				+ "                        <th>SALARY</th>\r\n"
				+ "                        <th>ACTION</th>\r\n"
				+ "                        </tr>\r\n"
				+ "                    </thead>\r\n"
				+ "                    <tbody>");
		
		for(Employee employ : e1) {
			int id=employ.getId();
			String name=employ.getName();
			int age=employ.getAge();
			String email=employ.getEmail();
			int salary=employ.getSalary();
			
			pr.print("<tr>\r\n"
					+ "			                <td>"+id+"</td>\r\n"
					+ "			                <td>"+name+"</td>\r\n"
					+ "			                <td>"+age+"</td>\r\n"
					+ "			                <td>"+email+"</td>\r\n"
					+ "			                <td>"+salary+"</td>\r\n"
					+ "			                <td>\r\n"
					+ "			       			\r\n"
					+ "			                <a href=\"update.html\">Update</a>\r\n"
					+ "			                <a href=\"delete.html\">Delete</a>			                \r\n"
					+ "			                </td>\r\n"
					+ "			            </tr>");
		}
		pr.print("</tbody>\r\n"
				+ "                </table>\r\n"
				+ "                </form>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    </section>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
	}
	
}
