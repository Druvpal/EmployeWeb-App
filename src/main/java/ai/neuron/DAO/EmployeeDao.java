package ai.neuron.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ai.neuron.Entity.Entity;

public class EmployeeDao {
	private Connection connection;

	public EmployeeDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addEmployee(String empName, String empEmail, String empJobRole, String empContact) {
		boolean f = false;
		
		try {
			
			String sqlQuery="insert into new_table(empName,empEmail,empJobRole,empContact) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, empName);
			ps.setString(2, empEmail);
			ps.setString(3, empJobRole);
			ps.setString(4, empContact);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Entity> getEmployee(){
		List<Entity> list = new ArrayList<Entity>();
		Entity t = null;
		
		try {
			
			String sql = "select * from new_table";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet resultset=pst.executeQuery();
			
			while(resultset.next()) {
				t = new Entity();
				t.setId(resultset.getInt(1));
				t.setName(resultset.getString(2));
				t.setEmail(resultset.getString(3));
				t.setJobrole(resultset.getString(4));
				t.setContact(resultset.getInt(5));
				list.add(t);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Entity getEmployeeId(int id) {
		Entity t = null;
		
		try {
			
			String sqlQuery="select * from new_table where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				t = new Entity();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setJobrole(rs.getString(4));
				t.setContact(rs.getInt(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	public boolean UpdateEmployee(Entity t) {
		boolean f = false;
		try {
			
			String sqlQuery="update new_table set empName=?,empEmail=?,empJobRole=?,empContact=? where ID=?";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setString(1,t.getName());
			pst.setString(2,t.getEmail());
			pst.setString(3,t.getJobrole());
			pst.setInt(4, t.getContact());
			pst.setInt(5, t.getId());
			
			int i = pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	public boolean DeleteEmp(int id) {
		
		boolean f = false;
		
		try {
			
			String sqlQuery="delete from new_table where id=?";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1, id);
			int i = pst.executeUpdate();
			
			
			if(i==1) {
				f=true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}

