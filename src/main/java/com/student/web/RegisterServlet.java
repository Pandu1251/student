package com.student.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
       
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

		List<Candidate> listCandidates;
		try {
			listCandidates = candidateDAO.selectAllCandidates();
			request.setAttribute("listCandidate", listCandidates);
			RequestDispatcher dispatcher = request.getRequestDispatcher("candidateslist.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
