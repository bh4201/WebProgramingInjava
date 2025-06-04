package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.cdac.dao.CandidateDaoImpl;
import com.cdac.pojos.Candidate;
import com.cdac.pojos.User;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/admin_dashboard")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("in admin dashboard...");
			HttpSession session =request.getSession();
			User user = (User) session.getAttribute("user_info");
			CandidateDaoImpl candidiateDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
			pw.print("<h3>"+user.getFirstName()+"  "+user.getLastName()+"</h3>");
	
			List<Candidate> topTwoCandidates = candidiateDao.getTop2Candidates();
			Map<String,Integer> partyVotes = candidiateDao.getPartyVotes();
			pw.print("<h3> Top 2 andidates having highest vote</h3>");
			pw.print("<table border='2' cellpadding='10'> <tr>"
					+ "<th> Id </th>"
					+ "<th> Name </th>"
					+ "<th> Party </th>"
					+ "<th> votes </th>"
					+ " </tr>");
			for(Candidate c : topTwoCandidates) {
				pw.print("<tr>"
						+ "<td>"+ c.getCandidateId() +"</td>"
						+ "<td>"+ c.getName() +"</td>"
						+ "<td>"+ c.getPartyName()+"</td>"
						+ "<td>"+ c.getVotes() +"</td>"
						+ "</tr>");
			}
			pw.print("</table>");
			
			//party wise voyes
			pw.print("</table>");
			
			pw.print("<h3> Party wise candidate votes </h3>");
			pw.print("<table border='2' cellpadding='10'> <tr>"
					+ "<th> Party </th>"
					+ "<th> Votes </th> </tr>");
			partyVotes.forEach((party, votes)-> {
				pw.print("<tr>"
						+ "<td>" + party + "</td>"
						+ "<td>" + votes + "</td>"
						+"</tr>"
						);
			});
			pw.print("</table>");
			session.invalidate();
			
			pw.print("<h3> you are logged out </h3>");
			pw.print("<h3> <a href='login.html'>Visit again</a</h3>");
		}
		catch (Exception e) {
			
			throw new ServletException();
		}
		
	}

}
