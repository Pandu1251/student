package com.student.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.CandidateDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/water")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateDAO candidateDAO;

	public void init() {
		candidateDAO = new CandidateDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("contextPath:::::::::getContextPath:::::::::" + request.getContextPath());

		String action = request.getServletPath();
		System.out.println("action:::::::::getServletPath:::::::::" + action);

		String idParam = request.getParameter("id");
		System.out.println("Received idParam: " + idParam);

		// Check if the id parameter is null or empty
		if (idParam == null || idParam.isEmpty()) {
			System.out.println("ID parameter is missing or empty");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is missing or empty");
			return;
		}

		try {
			int id = Integer.parseInt(idParam);
			
			// Check if the candidate exists
			if (candidateDAO.selectCandidate(id) == null) {
				System.out.println("No candidate found with ID: " + id);
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "No candidate found with the provided ID");
				return;
			}

			// Attempt to delete the candidate
			try {
				candidateDAO.deleteCandidate(id);
				System.out.println("Candidate with ID: " + id + " successfully deleted");
			} catch (SQLException e) {
				System.out.println("SQL exception occurred during candidate deletion: " + e.getMessage());
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting candidate");
				return;
			}

			// Redirect to the desired page after successful deletion
			response.sendRedirect(request.getContextPath() + "/RegisterServlet");

		} catch (NumberFormatException e) {
			System.out.println("ID parameter is not a valid integer: " + idParam);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is not a valid integer");
		}
	}
}
