package ai.neuron.Entity;

import javax.servlet.http.HttpServlet;

public class Entity extends HttpServlet {

	private int id;
	private String name;
	private String email;
	private String jobrole;
	private int contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", email=" + email + ", jobrole=" + jobrole + ", contact="
				+ contact + "]";
	}

	
	
}
