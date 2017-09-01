<!DOCTYPE html>
<htmL>
<head>
<title>Add Faculty Member</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/add-student-style.css">
    <link href="https://fonts.googleapis.com/css?family=Alice" rel="stylesheet">
</head>

<body>
<div id="wrapper">
        <div id="header">
            <h2>Add New Faculty Member</h2>
        </div>
    </div>
    
<div id="container">
	<h3>Add Faculty</h3>
	<!-- below will call doGet method from the StudentControllerServlet -->
	<form action="FacultyControllerServlet" method="GET">
	<!-- when all of the data below is submitted, it will be sent back to our doGet method in our controller servlet. 
	in the servlet we reference the name command but it is that value ADD that will be called upon in the switch statement in the servlet-->
		<input type="hidden" name="command" value="ADD"/>
		  <table>
		      <tbody>
		          
                   
                   <tr> 
                   <td><label>First name:</label></td>  
                   <td><input type="text" name="firstName"></td>
                   </tr>
                   
                    <tr> 
                   <td><label>Last name:</label></td>  
                   <td><input type="text" name="lastName"></td>
                   </tr>
                   
                    <tr> 
                   <td><label>Email:</label></td>  
                   <td><input type="text" name="mail"></td>
                   </tr>
                   
                    <tr> 
                   <td><label>Address:</label></td>  
                   <td><input type="text" name="address"></td>
                   </tr>
                   
                    <tr> 
                   <td><label>Phone Number:</label></td>  
                   <td><input type="text" name="phoneNumber"></td>
                   </tr>
                   
                    <tr> 
                   <td><label>Job Title:</label></td>  
                   <td><input type="text" name="jobTitle"></td>
                   </tr>
                   
                   <tr> 
                   <td><label></label></td>  
                   <td><input type="submit" value="Save" class="save"></td>
                   </tr>
                   
                    
		
		
		         
		
		      </tbody>
		
		  </table>
	</form>
	<div style="clear: both;"></div>
	<p><a href="FacultyControllerServlet">Back to Faculty Data</a></p>
	
	
</div>

</body>

</htmL>
