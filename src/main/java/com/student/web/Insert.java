package com.student.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.Candidate;
import com.student.dao.CandidateDAO;

@WebServlet("/Iron")
public class Insert extends HttpServlet {
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

		System.out.println("Name " + request.getParameter("name"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String qualification = request.getParameter("qualification");
		String state = request.getParameter("state");
		Candidate candidate = new Candidate(name, gender, email, qualification, state);
		try {
			candidateDAO.insertCandidate(candidate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response.sendRedirect("/crud");
		response.sendRedirect(request.getContextPath() + "/RegisterServlet");


	}
}
