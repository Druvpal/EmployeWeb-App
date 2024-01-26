<%@page import="ai.neuron.Entity.Entity"%>
<%@page import="ai.neuron.DAO.EmployeeDao"%>
<%@page import="ai.neuron.database.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="component/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Edit Employee</h3>
						
						<%
							int id = Integer.parseInt(request.getParameter("id"));
							EmployeeDao dao = new EmployeeDao(DBConnect.getConn());
							Entity t = dao.getEmployeeId(id);
						%>
						<form action="update" method="post" >
						
						<input type="hidden" value="<%=t.getId() %>" name="id">
							<div class="mb-3">
								<label for="NameTextInput" class="form-label">Name</label> <input
									type="text" id="nameInput" class="form-control" name="Name" value=
									"<%=t.getName() %>">
									
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="exampleInput" aria-describedby="emailHelp" name="Email" 
									value="<%=t.getEmail() %>">
							</div>

							<div class="mb-3">
								<label for="jobRoleInput" class="form-label">JobRole</label> <input
									type="text" id="jobRoleInput" class="form-control" 
									id="jobroleInput" aria-describedby="jobroleHelp" name="JobRole" value="<%=t.getJobrole()%>">
							</div>

							<div class="mb-3">
								
								<label for="contactNumberInput" class="form-label">Contact</label>
								<input type="text" id="contactInput" class="form-control" 
								id="contactInput" aria-describedby="contantHelp" name="Contact" value="<%=t.getContact()%>">
							</div>

							
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>