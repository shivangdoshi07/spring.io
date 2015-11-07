<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persons</title>
</head>
<body>

	<table border=1>
		<thead><tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Description</th>
				<th>Organization ID</th>
				<th>Organization Name</th>
				<th>Organization Address</th>
				<th>Organization Description</th>
				<th>Friends Name</th>	
		</tr></thead>

		<tr>
			<td>${person.id}</td>
			<td>${person.firstname}</td>
			<td>${person.lastname}</td>
			<td>${person.email}</td>
			<td>${person.address.street}, ${person.address.city}, ${person.address.state}, ${person.address.zip}</td>
			<td>${person.description}</td>
			<td>${person.org.organization_id}</td>
			<td>${person.org.name}</td>
			<td>${person.org.address.street}, ${person.org.address.city}, ${person.org.address.state}, ${person.org.address.zip}</td>
			<td>${person.org.description}</td>
			<td><ul>
					<c:forEach var="friend" items="${person.friends}">
							<li>${friend.firstname} ${friend.lastname} </li>
					</c:forEach>
			</ul></td>
			
		</tr>
	</table>

</body>
</html>