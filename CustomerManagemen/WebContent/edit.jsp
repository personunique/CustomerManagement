<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<title>New Item</title>
	</head>
	<body>
		<h2>New Item</h2>
		
		<form:form action="update.obj" method="POST" modelAttribute="item">
			<table>
				<tr>
					<td>Student Id</td>
					<td><form:input path="code" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>Student Name</td>
					<td><form:input path="custName"/>
						<form:errors path="custName"/>
					</td>
				</tr>
				<tr>
					<td>Student Mobile</td>
					<td><form:input path="custMob"/>
						<form:errors path="custMob"/>
					</td>
				</tr>
				<tr>
					<td>Student Email</td>
					<td><form:input path="custEmail"/>
						<form:errors path="custEmail"/>
					</td>
				</tr>
				
				<tr>
				
				
				
					<td>Student Date Of Birth</td>
					<td><form:input path="custDob" type="date"/>
						<form:errors path="custDob"/>
					</td>
				</tr>
				
				
				<tr>
					<td colspan="2">
						<button type="submit">SAVE</button>
					</td>
				</tr>
			</table>			
		</form:form>		
	</body>
</html>