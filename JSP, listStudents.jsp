<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<title>Student Data</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link href="https://fonts.googleapis.com/css?family=Alice" rel="stylesheet">
</head>



<body>
    <div id="wrapper">
        <div id="header">
            <h1>Carpe Noctem University Student Data</h1>
        </div>
    
    </div>
    
    
    <div id="container">
        <div id="content">
        <div><button onclick="window.location.href='add-student-form.jsp'; " class="add-student-button">Add Student</button></div>
            <table id="table">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Major</th>
                    <th>Action</th>
                </tr>
                <!-- studentList is the name created by the servlet  -->
                <c:forEach var="tempStudent" items="${studentList}">
                <!-- we create a new variable tempLink and point it towards our controller so the next line reads name="command" value="LOAD"
                which means we will be giving our controller a new command and the name of it is LOAD we give our next param a name of studentid
                and a value of tempStudent.id tempStudent comes from StudentDbUtil class and the .id part is grabing the getId method from our main Student class-->
                		<c:url var="tempLink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					  <!-- set up a link to delete student, remember where you see value DELETE, this is the value that will be referenced in the servlet on the switch statement -->
                		<c:url var="deleteLink" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
                 	<tr>
                 	<!-- remember these are actually get methods from the main student class somehow they do not need the get word?-->
                 		<td> ${tempStudent.firstName} </td>
                 		<td> ${tempStudent.lastName} </td>
                 		<td> ${tempStudent.mail} </td>
                 		<td> ${tempStudent.address} </td>
                 		<td> ${tempStudent.phoneNumber} </td>
                 		<td> ${tempStudent.major} </td>
                 		<td>
                 			<a href="${tempLink}">Update</a>
                 			<a href="${deleteLink}">Delete</a>
                 		
                 		
                 		</td>
                 	</tr>
               </c:forEach>
            </table>
        </div>
       
        
    </div>
    <a href="FacultyControllerServlet">Go to Faculty Data</a>
 
</body>
</html>
