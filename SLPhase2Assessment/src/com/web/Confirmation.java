package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Airlines;
import com.entity.Flights;
import com.utility.HiberanteUtlity;

@WebServlet("/Confirmation")
public class Confirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Confirmation() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("navigate.html").include(request, response);
		HttpSession s = request.getSession(false);
		String username = (String) s.getAttribute("uname");
		int count=0;
		String date="",airline="";
		double cost=0.0,amount=0.0;
		try {
			Session session = HiberanteUtlity.getSession();
			List<Flights> fdetails = session.createQuery("from Flights").list();
			List<Airlines> bdetails = session.createQuery("from Airlines").list();
			out.print("<style> table,td,th {" + "border:2px solid gray;" + "padding: 10px; " + "}</style>");
			out.print("<style>th{background-color: #4287f5;\r\n" + " color: white; }</style>");
			out.print("<style> table{ margin-left: auto;\r\n" + "  margin-right: auto;}</style>");
			out.print("<br><br><br>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Airline </th>");
			out.print("<th> Cost </th>");
			out.print("<th> Journey Date </th>");
			out.print("<th> Total no. of Travllers </th>");
			out.print("<th> Total Amount</th>");
		    out.print("</tr>");
		    for(Flights f:fdetails) {
		    	int c=f.getTravellers();
		    	count=count+c;
		    	date=f.getDate();
		    }
		    
			int id= (int)request.getSession().getAttribute("id");
			    for(Airlines p:bdetails) {
			    	if(p.getId()==id) {
					airline=p.getAirline();
					cost=p.getPrice();
			    	}
			    }
			    amount=count*cost;
				out.print("<tr>");
				out.print("<td>"+airline+"</td>");
				out.print("<td>"+cost+"</td>");
				out.print("<td>"+date+"</td>");
				out.print("<td>"+count+"</td>");
				out.print("<td>"+amount+"</td>");
				out.print("</tr>");
				out.print("</table>");
				request.getRequestDispatcher("PaymentConfirmation.html").include(request, response);
				Session del=HiberanteUtlity.getSession();
				Transaction  tc=del.beginTransaction();
				
				for(Flights f: fdetails) {
					Flights flight=new Flights(f.getId());
					del.delete(flight);
					
				}
				tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
