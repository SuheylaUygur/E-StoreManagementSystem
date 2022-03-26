
public abstract class Person { // Person class is an abstract class. Admin,Manager,Customer has been extended from here.
	
	private String name = "";
	private String surname = "";   //  Common features are here. There are some functions that they need to override
	private String username = "";
	private String password = "";    // all users have the attributes.
	
	
	public Person(String name, String surname, String username, String password) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}
	
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getSurname() { return surname;}

	public void setSurname(String surname) { this.surname = surname;}

	public String getUsername() { return username;}

	public void setUsername(String username) { this.username = username;}

	public String getPassword() { return password;}

	public void setPassword(String password) { this.password = password;}

	public abstract void deleteUser();  // everybody can delete their account.
	
	public abstract void sendMessageToAdmin();  // everyone can send message to administrator.
	
	public abstract void Save();  // This method is to save the all users.
	
}
