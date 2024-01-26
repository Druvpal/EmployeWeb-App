package ai.neuron.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ai.neuron.DAO.EmployeeDao;
import ai.neuron.database.DBConnect;
@WebServlet("/add_employee")
public class AddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Name = req.getParameter("Name");
		String Email = req.getParameter("Email");
		String JobRole = req.getParameter("JobRole");
		String Contact = req.getParameter("Contact");
		
		
		EmployeeDao dao = new EmployeeDao(DBConnect.getConn());
		boolean flag = dao.addEmployee(Name, Email, JobRole, Contact);
		
		HttpSession session = req.getSession();
		
		if(flag) {
			session.setAttribute("sucMsg", "Employee Added Sucessfully");
			resp.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("faildMsg", "Something is wrong on server");
			resp.sendRedirect("index.jsp");
		}
		
		

	}
	
}
