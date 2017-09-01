package mainPackage;

public class Faculty {
	private int id;
	private String firstName;
	private String lastName;
	private String mail;
	private String address;
	private String phoneNumber;
	private String jobTitle;
	
	public Faculty(String firstName, String lastName, String mail, String address, String phoneNumber, String jobTitle) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.jobTitle = jobTitle;
	}
	
	public Faculty(int id, String firstName, String lastName, String mail, String address, String phoneNumber, String jobTitle) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.jobTitle = jobTitle;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	//used for debugging and logging
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + mail +", address=" + address +", phoneNumber=" + phoneNumber +", jobTitle=" + jobTitle + "]";
	}
	
	

}
