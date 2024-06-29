package com.student.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.Candidate;
import com.student.dao.CandidateDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/fire")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateDAO candidateDAO;

	public void init() {
		System.out.println("hi babe");
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

		// Check if id parameter is null or empty
		if (idParam == null || idParam.isEmpty()) {
			System.out.println("ID parameter is missing or empty");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is missing or empty");
			return;
		}

		try {
			int id = Integer.parseInt(idParam);
			Candidate existingCandidate = candidateDAO.selectCandidate(id);
			
			if (existingCandidate == null) {
				System.out.println("No candidate found with ID: " + id);
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "No candidate found with the provided ID");
				return;
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("updatecandidateform.jsp");
			request.setAttribute("candidate", existingCandidate);
			dispatcher.forward(request, response);
		} catch (NumberFormatException e) {
			System.out.println("ID parameter is not a valid integer: " + idParam);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is not a valid integer");
		}
	}
}
