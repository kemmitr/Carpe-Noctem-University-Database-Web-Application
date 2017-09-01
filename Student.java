package mainPackage;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String mail;
	private String address;
	private String phoneNumber;
	private String major;
	
	public Student(String firstName, String lastName, String mail, String address, String phoneNumber, String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.major = major;
	}
	
	public Student(int id, String firstName, String lastName, String mail, String address, String phoneNumber, String major) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.major = major;
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
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	//used for debugging and logging
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + mail +", address=" + address +", phoneNumber=" + phoneNumber +", major=" + major + "]";
	}
	
	

}
