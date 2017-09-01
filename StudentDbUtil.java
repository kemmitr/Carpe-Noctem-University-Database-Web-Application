package mainPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	
	//DataSource is used to make our connection
	private DataSource dataSource;
	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	//we can tell this is our helper class as we are using the bas class Student here to create an Array List we also create our SQL variables here.
	public List<Student> getStudent()throws Exception{
		List <Student> students = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		//remember that all sql connections and querys must be wraped in a try catch or try finally box
		try{
			//get a SQL connection
			myConn = dataSource.getConnection();
			
			//create SQL statement 
			String sql = "select * from student order by last_name";
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
				String major = myRs.getString("major");
				
				//create new student object. Notice the variable being used are the local variable above and not the actual sql column names. 
				Student tempStudent = new Student(id, firstName, lastName, mail, address, phoneNumber, major);
				
				//add data to list of students.
				students.add(tempStudent);
			}
			
			return students;
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

	public void addStudent(Student theStudent) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
			//get a SQL connection
			myConn = dataSource.getConnection();
			
//create sql insert statement. the second line of code is the name of the tables in mysql so get those right
//the question marks are place holders and they start at 1 not 0. the question marks corelate directly with lines 102-104
			String sql = "insert into student "
			+ "(first_name, last_name, email, address, phone_number, major)"
			+ "values (?, ?, ?, ?, ?, ?)";
					
			myStmt = myConn.prepareStatement(sql);
			
			//set the parameter values for the student
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getMail());
			myStmt.setString(4, theStudent.getAddress());
			myStmt.setString(5, theStudent.getPhoneNumber());
			myStmt.setString(6, theStudent.getMajor());
			//execute statement
			myStmt.execute();
			
		}finally{
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
//this method was created to pr-populate the fields when the user wishes to update database data.
	public Student getStudent(String theStudentId) throws Exception{
		//creating a new Student object of the main class Student 
		Student theStudent = null;
		
		//create local studentId variable
		int studentId;
		
		//prepare JDBC
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		
		try{
			//convert student id to int
			studentId = Integer.parseInt(theStudentId);
			//get connection to database
			myConn = dataSource.getConnection();
			//create sql code to get selected student
			String sql = "select * from student where id=?";
			//create prepared statement 
			myStmt = myConn.prepareStatement(sql);
			//set params
			myStmt.setInt(1, studentId);
			//execute statement
			myRs = myStmt.executeQuery();
			//retrieve data from result set row
			if(myRs.next()){
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String address = myRs.getString("address");
				String phoneNumber = myRs.getString("phone_number");
				String major = myRs.getString("major");
			//below we grab theStudent from line 118, giving us a new student object all of the variables in the parameter area were created
			//above and will now be passed to the main Student class using our second Student constructor that used an id.
				theStudent = new Student(studentId, firstName, lastName, email, address, phoneNumber, major);
			}
			else{
				throw new Exception("Could not find student id: " + studentId);
			}
			
		return theStudent;
		}
		finally{
			close(myConn, myStmt, myRs);
		}
	}

	public void updateStudent(Student theStudent) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
		//get connection to database
		myConn = dataSource.getConnection();
		//create sql code to get selected student. the last space before the (") on lines 168 and 169 are on purpose and must be done.
		String sql = "update student "
				   + "set first_name =?, last_name=?, email=?, address=?, phone_number=?, major=? "
				   + "where id=?";
		//create prepared statement 
		myStmt = myConn.prepareStatement(sql);
		
		//set params number 1 in the parameter area is the first question mark on line 169 we then take the new Student object we created
		//on line 162 to grab the .getFirstName method from the main Student method and the rest below follow the same methodology 
		myStmt.setString(1, theStudent.getFirstName());
		myStmt.setString(2, theStudent.getLastName());
		myStmt.setString(3, theStudent.getMail());
		myStmt.setString(4, theStudent.getAddress());
		myStmt.setString(5, theStudent.getPhoneNumber());
		myStmt.setString(6, theStudent.getMajor());
		myStmt.setInt(7, theStudent.getId());
		//execute statement
		myStmt.execute();
	}
	finally{
		close(myConn, myStmt, null);
	}
	}

	public void deleteStudent(String theStudentId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
			//convert student id to integer
			int studentId = Integer.parseInt(theStudentId);
			//get connection to database
			myConn = dataSource.getConnection();
			//create sql delete student
			String sql = "delete from student where id=?";
			//create prepared statement 
			myStmt = myConn.prepareStatement(sql);	
			//set perams
			myStmt.setInt(1, studentId);
			//execute statement
			myStmt.execute();
		}
		finally{
			
				close(myConn, myStmt, null);
		}
		
	}	

}
