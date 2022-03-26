import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Customer extends Person     // Customer class extends Person abstract class.
{
	private ShoppingCart cart;        // This class contains information about the customer.
	private CreditCard creditcard;
	private String gender;
	private int age;
	private Phone phone;
	private Address address;
	static Object[][]profileCustomer = new Object[13][1]; // Used as parameter to JTable component.
	static int bakiye;
	static String username_;
	static String customerName;
	static String customerSurname;
	static String customerTelephone;
	
	
	public Customer(String name, String surname, String username, String password, ShoppingCart cart,
			CreditCard creditcard, String gender, int age, Phone phone, Address address) {
		super(name, surname, username, password);
		this.cart = cart;
		this.creditcard = creditcard;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		customerName = name;
		customerSurname = surname;
		customerTelephone=phone.getAreaCode()+phone.getPhoneCode()+phone.getPhone();
	}
	

	public static void setProfileCustomer(Object[][] profileCustomer) 
	{
		Customer.profileCustomer = profileCustomer;
	}

	 // in this method, the customer will be able to delete herself.
	@Override
	public void deleteUser(){ }

	 // in this method, the customer can convey her wishes and complaints to the administrator by message.
	@Override
	public void sendMessageToAdmin() { }

	@Override
	public void Save() {  // The client will be able to register herself.
			File fil = new File("Customers_all_data.txt");    // Customer information is written to the file.
		    if (!fil.exists()) {
		        try {
					fil.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }

		    FileWriter filWriter = null;
			try {
				filWriter = new FileWriter(fil, true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    BufferedWriter biWriter = new BufferedWriter(filWriter);
		    try {
				biWriter.write(this.getName()+";"+this.getSurname()+";"+this.getUsername()+";"+this.getPassword()+";"+this.cart+
						";"+this.creditcard.getBalance()+";"+this.creditcard.getCVV()+";"+this.creditcard.getCardPassword()+";"+
						this.gender+";"+this.age+";"+this.phone.getAreaCode()+";"+this.phone.getPhoneCode()+";"+this.phone.getPhone()+";"
						+this.address.getCountry()+";"+this.address.getCity()+";"+this.address.getStreet()+'\n');
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		    try {
				biWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		    JOptionPane.showMessageDialog(null, "Saved Successfully !","Message",JOptionPane.INFORMATION_MESSAGE);
		}
	
			public static void createProfile(String username,String password,String name,String surname, int balance,int CVV,String CardPassword,String gender,
					String age, String areaCode,String phoneCode, String phone,String country,String city,String street) 
			{  // It was created because the array will go as a parameter to the JTable component of the Swing library.
			   // It has also been used where necessary.
				profileCustomer[0][0]="1- "+username;
				username_ = username;
				profileCustomer[1][0]="2- "+password;
				profileCustomer[2][0]="3- "+name;
				customerName = name;
				profileCustomer[3][0]="4- "+surname;
				customerSurname = surname;
				profileCustomer[4][0]="5- "+balance;
				bakiye = balance;
				profileCustomer[5][0]="6- "+CVV;
				profileCustomer[6][0]="7- "+CardPassword;
				profileCustomer[7][0]="8- "+gender;
				profileCustomer[8][0]="9- "+age;
				profileCustomer[9][0]="10- "+areaCode+phoneCode+phone;
				customerTelephone = areaCode+phoneCode+phone;
				profileCustomer[10][0]="11- "+country;
				profileCustomer[11][0]="12- "+city;
				profileCustomer[12][0]="13- "+street;
				
			}
			
			public ShoppingCart getCart() { return cart;}

			public void setCart(ShoppingCart cart) { this.cart = cart;}

			public CreditCard getCreditcard() {return creditcard;}

			public void setCreditcard(CreditCard creditcard) { this.creditcard = creditcard;}

			public String getGender() {return gender;}

			public void setGender(String gender) {this.gender = gender;}

			public int getAge() {return age;}

			public void setAge(int age) { this.age = age;}

			public Phone getPhone() { return phone;}

			public void setPhone(Phone phone) { this.phone = phone;}

			public Address getAddress() { return address;}

			public void setAddress(Address address) { this.address = address;}

			public static Object[][] getProfileCustomer() { return profileCustomer;}
			
			public static int getBakiye() { return bakiye;}

			public static void setBakiye(int bakiye) 
			{
				Customer.bakiye = bakiye;
			}	
}


