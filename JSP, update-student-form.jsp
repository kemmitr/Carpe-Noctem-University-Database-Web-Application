<!DOCTYPE html>
<htmL>
<head>
<title>Update Student</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/add-student-style.css">
    <link href="https://fonts.googleapis.com/css?family=Alice" rel="stylesheet">
</head>

<body>
<div id="wrapper">
        <div id="header">
            <h2>Update Student Data</h2>
        </div>
    </div>
    
<div id="container">
	<h3>Update Student</h3>
	<!-- below will call doGet method from the StudentControllerServlet -->
	<form action="StudentControllerServlet" method="GET">
	<!-- when all of the data below is submitted, it will be sent back to our doGet method in our controller servlet. 
	in the servlet we reference the name command but it is that value UPDATE that will be called upon in the switch statement in the servlet-->
		<input type="hidden" name="command" value="UPDATE"/>
		<!-- this and the command above will be called upon in the servlet -->
		<input type="hidden" name="studentId" value="${THE_STUDENT.id}"/>
		  <table>
		      <tbody>
		          
                   
                   <tr> 
                   <!-- below in value we call on THE_STUDENT object created in the servlet on line 100 this will pre-populate the form using the correct getter method-->
                   <td><label>First name:</label></td>  
                   <td><input type="text" name="firstName"
                   			  value="${THE_STUDENT.firstName}"></td>
                   </tr>
                   
                    <tr> 
                   <td><label>Last name:</label></td>  
                   <td><input type="text" name="lastName"
                   			  value="${THE_STUDENT.lastName}"></td>
                   </tr>
                   
                    <tr> 
                   <td><label>Email:</label></td>  
                   <td><input type="text" name="mail"
                              value="${THE_STUDENT.mail}"></td>
                   </tr>
                   
                   <tr> 
                   <td><label>Address:</label></td>  
                   <td><input type="text" name="address"
                              value="${THE_STUDENT.address}"></td>
                   </tr>
                   
                   <tr> 
                   <td><label>Phone Number:</label></td>  
                   <td><input type="text" name="phoneNumber"
                              value="${THE_STUDENT.phoneNumber}"></td>
                   </tr>
                   
                    <tr> 
                   <td><label>Major:</label></td>  
                   <td><input type="text" name="major"
                              value="${THE_STUDENT.major}"></td>
                   </tr>
                   
                   
                   <tr> 
                   <td><label></label></td>  
                   <td><input type="submit" value="Save" class="save"></td>
                   </tr>
                   
                    
		
		
		         
		
		      </tbody>
		
		  </table>
	</form>
	<div style="clear: both;"></div>
	<p><a href="StudentControllerServlet">Back to Student Data</a></p>
	
	
</div>

</body>

</htmL>
