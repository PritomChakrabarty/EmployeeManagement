package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EmpService {
	private static String url = "jdbc:mysql://localhost:3306/empmng";
	private static String user = "root";
	private static String pwd = "root";
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	// Insert Employee
	public int saveEmp(Employee emp) {
		int no = 0;
		String sql = "insert into emp values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setInt(3, emp.getAge());
			pstm.setString(4, emp.getEmail());
			pstm.setInt(5, emp.getSalary());

			no = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return no;
	}
	// Display Employee
	public List<Employee> getAll(){
		List<Employee> l1=new ArrayList<>();
		String dis = "select * from emp";
		try {
			Statement stm=con.createStatement();
			
			ResultSet rs=stm.executeQuery(dis);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
				int salary=rs.getInt(5);
				
				l1.add(new Employee(id, name, age, email, salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l1;
	}
	// Update Employee
	public static int updateEmp(Employee empl) {
		int no2= 0;
		String upd = "update emp set name = ?, age = ?, email = ? salary = ? where id = ?;";
		try {
			PreparedStatement pstm = con.prepareStatement(upd);

			pstm.setString(1, empl.getName());
			pstm.setInt(2, empl.getAge());
			pstm.setString(3, empl.getEmail());
			pstm.setInt(4, empl.getSalary());
			pstm.setInt(5, empl.getId());

			no2 = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return no2;
	}
	// Delete Employee
	public int deleteEmp(int id) {
		int no1= 0;
		String del = "delete from emp where id = ?;";
		try {
			PreparedStatement pstm = con.prepareStatement(del);

			pstm.setInt(1, id);

			no1 = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return no1;
	}
}


















