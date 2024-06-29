package com.student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the current session, or create a new one if it doesn't exist
      System.out.println("Logging out bye bye************************************************************");
    	HttpSession session = request.getSession(false);

        if (session != null) {
        	session.setAttribute("userLoggedIn", false); 
            // Invalidate the session to log the user out
            session.invalidate();
        }

        // Redirect to the login page or any other page as needed
        response.sendRedirect("login.jsp");
    }
}
