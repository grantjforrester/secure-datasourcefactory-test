package com.github.grantjforrester.tomcat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DATASOURCE_CONTEXT = "java:comp/env/jdbc/mydatabase";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		DataSource ds = getJNDIDataSource();
		String greeting = getGreeting(ds);
		response.getWriter().append(greeting);
		} catch (NamingException | SQLException e) {
			throw new ServletException(e);
		}
	}

	private DataSource getJNDIDataSource() throws NamingException {
		Context initialContext = new InitialContext();
		DataSource datasource = (DataSource) initialContext.lookup(DATASOURCE_CONTEXT);
		return datasource;
	}
	
	private String getGreeting(DataSource ds) throws SQLException {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement ps = conn.prepareStatement("select * from greeting where id = 0")) {
				try (ResultSet rs = ps.executeQuery()) {
					rs.next();
					return rs.getString(2);
				}
			}
		}
	}

}
