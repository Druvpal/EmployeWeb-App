package ai.neuron.Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ai.neuron.DAO.EmployeeDao;
import ai.neuron.Entity.Entity;
import ai.neuron.database.DBConnect;
import ai.neuron.DAO.EmployeeDao;
import ai.neuron.Servlet.UpdateServlet;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String Name = req.getParameter("Name");
		String Email = req.getParameter("Email");
		String JobRole = req.getParameter("JobRole");
		int Contact = 	Integer.parseInt(req.getParameter("Contact"));
		EmployeeDao dao = new EmployeeDao(DBConnect.getConn());
		
		Entity t = new Entity();
		t.setId(id);
		t.setName(Name);
		t.setEmail(Email);
		t.setJobrole(JobRole);
		t.setContact(Contact);
		
		
		boolean f = dao.UpdateEmployee(t);
		
		HttpSession session = req.getSession();
		
		if(f) {
			session.setAttribute("sucMsg", "Employee Updeted Sucessfully");
			resp.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("faildMsg", "Something is wrong on server");
			resp.sendRedirect("index.jsp");
		}
	
	}

}
