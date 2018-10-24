package org;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Permission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Hello extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().print("<h1>Hello Servlet </h1>");
		response.getWriter().print("session=" + request.getSession(true).getId());
	}
	
	
	/*
	 *
	 A doua metoda de a insera in baza de date,folosind metoda doPost fara a mai folosi o clasa DAO pentru atributele pe care
	 le doresc sa le inserez in baza de date
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		if(name!=null && !name.isEmpty() && email!=null && !email.isEmpty())
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JettyDB", "postgres", "1q2w3e");
				PreparedStatement ps = con.prepareStatement("INSERT INTO person (name, email) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setString(2, email);
				int i = ps.executeUpdate();
				if (i > 0) {
					out.print("Registered successfully!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.print("ERROR!");
			}
		else
			out.print("Please enter your Name and Email.");
}

	private class MySecurityManager extends SecurityManager {

		@Override
		public void checkPermission(Permission perm) {
			return;
		}
	}

}
