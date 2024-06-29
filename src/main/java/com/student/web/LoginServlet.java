package com.student.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        // JDBC Database Connection
        String jdbcURL = "jdbc:mysql://localhost:3306/student_management";
        String dbUser = "root";
        String dbPassword = "pandu";
        System.out.println(":::::::::::::::::::::::::::In Loginservlet");
        

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
System.out.println("**********************************************************************");
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                // Login successful
            	System.out.println("successful login");
            	request.getSession().setAttribute("userLoggedIn", true);
            	//request.getRequestDispatcher(request.getContextPath()+"/candidateslist.jsp").forward(request, response);
            	response.sendRedirect("RegisterServlet");
            } else {
                // Login failed
            	request.setAttribute("loginFailed", true);
            	request.getRequestDispatcher("login.jsp").forward(request, response);
            	//response.sendRedirect("index.jsp");
            }

            result.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
