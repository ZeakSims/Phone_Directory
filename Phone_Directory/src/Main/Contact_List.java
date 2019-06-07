package Main;
/*this is my object class where I declare where I declare several 
objects such as both first and last name and phone number. 
It has constructors to declare the objects for the linked list, 
and it has getters and setters to grab and use these objects at
any time.*/
public class Contact_List {
	 private String firstName;
	 private String lastName;
	 private String phoneNumber;
	 
	 public  Contact_List() {
			
		firstName = "";
		lastName = "";
		phoneNumber = "";
	}
		
	public  Contact_List(String fn, String ln, String pn) {
			
		firstName = fn;
		lastName = ln;
		phoneNumber = pn;
	}
		
		
	public String getFirstName() {
	
		return firstName;
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String pn) {
		phoneNumber = pn;
	}
}
