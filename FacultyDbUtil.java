package mainPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class FacultyDbUtil {
	
	//DataSource is used to make our connection
	private DataSource dataSource;
	public FacultyDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	//we can tell this is our helper class as we are using the bas class Student here to create an Array List we also create our SQL variables here.
	public List<Faculty> getFaculty()throws Exception{
		List <Faculty> faculty = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		//remember that all sql connections and querys must be wraped in a try catch or try finally box
		try{
			//get a SQL connection
			myConn = dataSource.getConnection();
			
			//create SQL statement 
			String sql = "select * from faculty order by last_name";
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set. Line 38 below is telling java to keep looping until all data is pulled from the database.
			while (myRs.next()){
				
				//retrieve data from result set. now we see these newly created variables int id String fristName and although these are the same
				//variable name from Student base class they are local here and are therefore temporary and then depending on the data type the result set
				//will use getInt or getString and inside of the parameter area use the actual database column name.
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String mail = myRs.getString("email");
				String address = myRs.getString("address");
				String phoneNumber = myRs.getString("phone_number");
				String jobTitle = myRs.getString("job_title");
				
				//create new student object. Notice the variable being used are the local variable above and not the actual sql column names. 
				Faculty tempFaculty = new Faculty(id, firstName, lastName, mail, address, phoneNumber, jobTitle);
				
				//add data to list of students.
				faculty.add(tempFaculty);
			}
			
			return faculty;
		}
		finally{
			//close JDBC objects. we call on the close method to close all JDBC objects, this is best practice but is not 100% needed  
			close(myConn, myStmt, myRs);
		}
		
	
	}

	//method created to close JDBC objects
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
			if(myRs != null){
				myRs.close();
			}
			if(myStmt != null){
				myStmt.close();
			}
			if(myConn != null){
				myConn.close();
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}

	public void addFaculty(Faculty theFaculty) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
			//get a SQL connection
			myConn = dataSource.getConnection();
			
//create sql insert statement. the second line of code is the name of the tables in mysql so get those right
//the question marks are place holders and they start at 1 not 0. the question marks corelate directly with lines 102-104
			String sql = "insert into faculty "
			+ "(first_name, last_name, email, address, phone_number, job_title)"
			+ "values (?, ?, ?, ?, ?, ?)";
					
			myStmt = myConn.prepareStatement(sql);
			
			//set the parameter values for the student
			myStmt.setString(1, theFaculty.getFirstName());
			myStmt.setString(2, theFaculty.getLastName());
			myStmt.setString(3, theFaculty.getMail());
			myStmt.setString(4, theFaculty.getAddress());
			myStmt.setString(5, theFaculty.getPhoneNumber());
			myStmt.setString(6, theFaculty.getJobTitle());
			//execute statement
			myStmt.execute();
			
		}finally{
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
//this method was created to pr-populate the fields when the user wishes to update database data.
	public Faculty getFaculty(String theFacultyId) throws Exception{
		//creating a new Student object of the main class Student 
		Faculty theFaculty = null;
		
		//create local studentId variable
		int facultyId;
		
		//prepare JDBC
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		
		try{
			//convert student id to int
			facultyId = Integer.parseInt(theFacultyId);
			//get connection to database
			myConn = dataSource.getConnection();
			//create sql code to get selected student
			String sql = "select * from faculty where id=?";
			//create prepared statement 
			myStmt = myConn.prepareStatement(sql);
			//set params
			myStmt.setInt(1, facultyId);
			//execute statement
			myRs = myStmt.executeQuery();
			//retrieve data from result set row
			if(myRs.next()){
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String address = myRs.getString("address");
				String phoneNumber = myRs.getString("phone_number");
				String jobTitle = myRs.getString("job_title");
			//below we grab theStudent from line 118, giving us a new student object all of the variables in the parameter area were created
			//above and will now be passed to the main Student class using our second Student constructor that used an id.
				theFaculty = new Faculty(facultyId, firstName, lastName, email, address, phoneNumber, jobTitle);
			}
			else{
				throw new Exception("Could not find faculty id: " + facultyId);
			}
			
		return theFaculty;
		}
		finally{
			close(myConn, myStmt, myRs);
		}
	}

	public void updateFaculty(Faculty theFaculty) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
		//get connection to database
		myConn = dataSource.getConnection();
		//create sql code to get selected student. the last space before the (") on lines 168 and 169 are on purpose and must be done.
		String sql = "update faculty "
				   + "set first_name =?, last_name=?, email=?, address=?, phone_number=?, job_title=? "
				   + "where id=?";
		//create prepared statement 
		myStmt = myConn.prepareStatement(sql);
		
		//set params number 1 in the parameter area is the first question mark on line 169 we then take the new Student object we created
		//on line 162 to grab the .getFirstName method from the main Student method and the rest below follow the same methodology 
		myStmt.setString(1, theFaculty.getFirstName());
		myStmt.setString(2, theFaculty.getLastName());
		myStmt.setString(3, theFaculty.getMail());
		myStmt.setString(4, theFaculty.getAddress());
		myStmt.setString(5, theFaculty.getPhoneNumber());
		myStmt.setString(6, theFaculty.getJobTitle());
		myStmt.setInt(7, theFaculty.getId());
		//execute statement
		myStmt.execute();
	}
	finally{
		close(myConn, myStmt, null);
	}
	}

	public void deleteFaculty(String theFacultyId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
			//convert student id to integer
			int facultyId = Integer.parseInt(theFacultyId);
			//get connection to database
			myConn = dataSource.getConnection();
			//create sql delete student
			String sql = "delete from faculty where id=?";
			//create prepared statement 
			myStmt = myConn.prepareStatement(sql);	
			//set perams
			myStmt.setInt(1, facultyId);
			//execute statement
			myStmt.execute();
		}
		finally{
			
				close(myConn, myStmt, null);
		}
		
	}	

}
