package ai.neuron.database;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
public class DBConnect extends HttpServlet {

	private static Connection connection;
	
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql:///employeedata";
			String useName="root";
			String pw="Manish@3123";
			connection = DriverManager.getConnection(url,useName,pw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
