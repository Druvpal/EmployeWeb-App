<%@page import="ai.neuron.database.DBConnect"%>
<%@page import="ai.neuron.DAO.EmployeeDao"%>
<%@page import="ai.neuron.Entity.Entity"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="IOS-8859-1">
<title></title>
<%@include file="component/all_css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>


	<h1 class="text-center text-success">Employee-Data</h1>
	<%
	String sucMsg = (String) session.getAttribute("sucMsg");
	if (sucMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=sucMsg%></div>
	<%
	session.removeAttribute("sucMsg");
	}
	%>

	<%
	String failedMsg = (String) session.getAttribute("failedMsg");
	if (failedMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=failedMsg%></div>
	<%
	session.removeAttribute("failedMsg");
	}
	%>
	<div class="container">
		<table class="table table-striped" border="1px">
		
			<thead class="bg-success text-white">
				<tr colspan="6">
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Job-Role</th>
					<th scope="col">Contact</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
			<%
			EmployeeDao dao = new EmployeeDao(DBConnect.getConn());
			List<Entity> emp= dao.getEmployee();
			for(Entity t : emp){
			%>
				<tr colspan="6">
					<th scope="row" border="black"><%=t.getId() %></th>
					<th scope="col"><%=t.getName() %></th>
					<td><%=t.getEmail() %></td>
					<td><%=t.getJobrole() %></td>
					<td><%=t.getContact() %></td>
					<td><a href="edit.jsp?id=<%=t.getId() %>" class="btn btn-sm btn-success">Edit</a>
					 <a href="delete?id=<%=t.getId() %>" class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
			<% }%>
		
				

			</tbody>
		</table>
	</div>
</body>
</html>