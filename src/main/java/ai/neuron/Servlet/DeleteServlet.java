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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeDao dao = new EmployeeDao(DBConnect.getConn());

		boolean f = dao.DeleteEmp(id);

		HttpSession session = request.getSession();

		if (f) {
			session.setAttribute("sucMsg", "Employee Deleted Sucessfully");
			response.sendRedirect("index.jsp");
		} else {
			session.setAttribute("faildMsg", "Something is wrong on server");
			response.sendRedirect("index.jsp");
		}
	}

}
