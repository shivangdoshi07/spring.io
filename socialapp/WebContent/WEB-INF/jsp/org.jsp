<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organization</title>
</head>
<body>

	<table border=1>
		<thead><tr>
				<th>Organization ID</th>
				<th>Organization Name</th>
				<th>Organization Address</th>
				<th>Organization Description</th>
		</tr></thead>

		<tr>
			<td>${org.organization_id}</td>
			<td>${org.name}</td>
			<td>${org.address.street}, ${org.address.city}, ${org.address.state}, ${org.address.zip}</td>
			<td>${org.description}</td>
		</tr>

	</table>
</body>
</html>