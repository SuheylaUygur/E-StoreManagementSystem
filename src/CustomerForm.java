
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;  // The JTextField component is a blank on the screen and is filled.
	private JTextField ageField;
	private JTextField genderField;
	private JTextField pAreaCodeField;
	private JTextField phoneCodeField;
	private JTextField phoneField;
	private JTextField countryField;
	private JTextField cityField;
	private JTextField streetField;
	private JTextField balanceField;
	private JTextField cvvField;
	private JPasswordField cardpasswordField;
	public static Customer customer;  // A customer is created.

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerForm frame = new CustomerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CustomerForm() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(238, 232, 170));
		registerPanel.setBounds(0, 0, 447, 653);
		contentPane.add(registerPanel);
		registerPanel.setLayout(null);
		this.setLocationRelativeTo(null); // always makes sure the window is in the middle
		JLabel genderLabel = new JLabel("gender");
		genderLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		genderLabel.setBounds(12, 225, 83, 33);
		registerPanel.add(genderLabel);
		
		JLabel nameLabel = new JLabel("name");
		nameLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		nameLabel.setBounds(12, 79, 83, 33);
		registerPanel.add(nameLabel);
		
		JLabel surnameLabel = new JLabel("surname");
		surnameLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		surnameLabel.setBounds(12, 133, 83, 33);
		registerPanel.add(surnameLabel);
		
		JLabel ageLabel = new JLabel("age");
		ageLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		ageLabel.setBounds(12, 179, 83, 33);
		registerPanel.add(ageLabel);
		
		JLabel pLabel = new JLabel("phone");
		pLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		pLabel.setBounds(12, 285, 83, 33);
		registerPanel.add(pLabel);
		
		JLabel lblAddress = new JLabel("address");
		lblAddress.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblAddress.setBounds(12, 393, 83, 33);
		registerPanel.add(lblAddress);
		
		JLabel areaLabel = new JLabel("area code\r\n");
		areaLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		areaLabel.setBounds(77, 285, 83, 33);
		registerPanel.add(areaLabel);
		
		JLabel phoneCodeLabel = new JLabel("phone code");
		phoneCodeLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		phoneCodeLabel.setBounds(77, 314, 99, 33);
		registerPanel.add(phoneCodeLabel);
		
		JLabel phoneLabel = new JLabel("phone");
		phoneLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		phoneLabel.setBounds(77, 347, 83, 33);
		registerPanel.add(phoneLabel);
		
		JLabel countryLabel = new JLabel("country");
		countryLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		countryLabel.setBounds(77, 424, 83, 33);
		registerPanel.add(countryLabel);
		
		JLabel cityLabel = new JLabel("city\r\n");
		cityLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		cityLabel.setBounds(77, 453, 99, 33);
		registerPanel.add(cityLabel);
		
		JLabel streetLabel = new JLabel("street");
		streetLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		streetLabel.setBounds(77, 485, 83, 33);
		registerPanel.add(streetLabel);
		
		JLabel registerFormText = new JLabel("Register Form\r\n");
		registerFormText.setFont(new Font("Sitka Small", Font.BOLD, 18));
		registerFormText.setBounds(123, 13, 147, 39);
		registerPanel.add(registerFormText);
		
		JLabel lblCreditCard = new JLabel("Credit card");
		lblCreditCard.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblCreditCard.setBounds(12, 531, 110, 33);
		registerPanel.add(lblCreditCard);
		
		JLabel cardPasswordLabel = new JLabel("card password");
		cardPasswordLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		cardPasswordLabel.setBounds(123, 565, 124, 33);
		registerPanel.add(cardPasswordLabel);
		
		JLabel cvvLabel = new JLabel("CVV");
		cvvLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		cvvLabel.setBounds(123, 607, 83, 33);
		registerPanel.add(cvvLabel);
		
		JLabel balanceLabel = new JLabel("balance");
		balanceLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		balanceLabel.setBounds(123, 531, 83, 33);
		registerPanel.add(balanceLabel);
		
		nameField = new JTextField();
		nameField.setBounds(107, 83, 194, 22);
		registerPanel.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setBounds(107, 137, 194, 22);
		registerPanel.add(surnameField);
		surnameField.setColumns(10);
		
		ageField = new JTextField();
		ageField.setBounds(107, 183, 194, 22);
		registerPanel.add(ageField);
		ageField.setColumns(10);
		
		genderField = new JTextField();
		genderField.setBounds(107, 229, 194, 22);
		registerPanel.add(genderField);
		genderField.setColumns(10);
		
		pAreaCodeField = new JTextField(3);
		pAreaCodeField.setBounds(185, 289, 60, 22);
		registerPanel.add(pAreaCodeField);
		
		phoneCodeField = new JTextField(3);
		phoneCodeField.setBounds(185, 318, 60, 22);
		registerPanel.add(phoneCodeField);
		
		phoneField = new JTextField(3);
		phoneField.setBounds(185, 351, 60, 22);
		registerPanel.add(phoneField);
		
		countryField = new JTextField(3);
		countryField.setBounds(187, 428, 60, 22);
		registerPanel.add(countryField);
		
		cityField = new JTextField(3);
		cityField.setBounds(187, 457, 60, 22);
		registerPanel.add(cityField);
		
		streetField = new JTextField(3);
		streetField.setBounds(187, 489, 60, 22);
		registerPanel.add(streetField);
		
		balanceField = new JTextField();
		balanceField.setBounds(259, 535, 93, 22);
		registerPanel.add(balanceField);
		
		cvvField = new JTextField(3);
		cvvField.setBounds(259, 611, 60, 22);
		registerPanel.add(cvvField);
		
		cardpasswordField = new JPasswordField();
		cardpasswordField.setBounds(259, 569, 172, 22);
		registerPanel.add(cardpasswordField);
		
		this.setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 69, 0));
		panel_1.setBounds(448, 0, 434, 653);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel textLabel1 = new JLabel("PLEASE MAKE SURE");
		textLabel1.setFont(new Font("Sitka Small", Font.BOLD, 20));
		textLabel1.setBounds(103, 41, 228, 59);
		panel_1.add(textLabel1);
		
		JLabel rabbitIconLabel = new JLabel("");
		rabbitIconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Image rabbitIcon = new ImageIcon(this.getClass().getResource("rabbit.png")).getImage();  
		// Images do not disappear when icon is created.
		rabbitIconLabel.setIcon(new ImageIcon(rabbitIcon));
		rabbitIconLabel.setBounds(103, 248, 253, 317);
		panel_1.add(rabbitIconLabel);
		
		JButton saveButton2 = new JButton("Save");
		saveButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {   // In this section, the user registration information is checked using the functions below.
				/// Let the checks begin
				
				String name = nameField.getText();
				
				if(checkName(name)==true)
				{
					String surname = surnameField.getText();
					if(checkSurname(surname)==true) 
					{
						String age = ageField.getText();
						if(checkAge(age)==true) 
						{
							String gender = genderField.getText();
							if(checkGender(gender)==true)
							{
								String pAreaCode = pAreaCodeField.getText();
								if(checkPAreaCode(pAreaCode)==true) 
								{
									String phoneCode = phoneCodeField.getText();
									if(checkPhoneCode(phoneCode)==true) 
									{
										String phone = phoneField.getText();
										if(checkPhone(phone)==true)
										{
											String country = countryField.getText();
											if(checkCountry(country)==true)
											{
												String city = cityField.getText();
												if(checkCity(city)==true) 
												{
													String street = streetField.getText();
													if(checkStreet(street)==true)
													{
														String balance = balanceField.getText();
														if(checkBalance(balance)==true)
														{
															String cvv = cvvField.getText();
															if(checkCvv(cvv)==true) 
															{
																String cardpassword = String.valueOf(cardpasswordField.getPassword());
												
																//If there is no problem with the information, the record is created.
																
																Phone phone_ = new Phone(pAreaCode,phoneCode,phone);
																Address address_ = new Address(country,city,street);
																CreditCard creditcard_ = new CreditCard(000,cardpassword,Integer.valueOf(cvv),
																		Integer.valueOf(balance));
																try {
																	takeUsernamePassword();
																} catch (IOException e) {
																	e.printStackTrace();
																}
																List <Products >products = new ArrayList<Products>();  // ????????????
																ShoppingCart shopCard = new ShoppingCart();
																customer = new Customer(name,surname,username,password,
																shopCard,creditcard_,gender,Integer.valueOf(age),phone_,address_);
																
																customer.createProfile(username,password,name,surname,
																		creditcard_.getBalance(),creditcard_.getCVV(),creditcard_.getCardPassword(),
																		gender,age,phone_.getAreaCode(),phone_.getPhoneCode(),phone_.getPhone(),
																		address_.getCountry(),address_.getCity(),address_.getStreet());
									
																customer.Save(); // The customer is saving.
																try {
																	new ShoppingForm().setVisible(true);
																	 setVisible(false);
																} catch (FileNotFoundException e) {}  
															}
															
														}
														
													}
													
												}
												
											}
											
										}
										
									}
									
								}
							}
							
						}
					}
				  }
			      }
				});
		
				saveButton2.setBackground(new Color(0, 0, 0));
				saveButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				saveButton2.setForeground(new Color(255, 69, 0));
				saveButton2.setFont(new Font("Sitka Small", Font.BOLD, 15));
				saveButton2.setBounds(169, 199, 108, 46);
				panel_1.add(saveButton2);
				
				JLabel textLabel2 = new JLabel("you fill in all the blanks correctly!");
				textLabel2.setFont(new Font("Sitka Small", Font.BOLD, 20));
				textLabel2.setBounds(32, 113, 379, 59);
				panel_1.add(textLabel2);
				
			}
			
			// Name Control Method
			public boolean checkName(String name) {
				boolean control = false;
				if(name.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "enter your name !","Message",JOptionPane.ERROR_MESSAGE);
					control=false;
				}
				else {
					for (int i = 0; i < name.length(); i++) {
						if(name.charAt(i)<(char)65 || name.charAt(i)>(char)122 || name.charAt(i)==(char)91 || name.charAt(i)==(char)92 || 
								name.charAt(i)==(char)93 || name.charAt(i)==(char)94 || name.charAt(i)==(char)95 || name.charAt(i)==(char)96	)
						{
							JOptionPane.showMessageDialog(null, "You entered your name wrong!","Message",JOptionPane.ERROR_MESSAGE);
							nameField.setText("");
							control = false;
							break;
							
						}
						else {
							control = true;
						}		
					}
				}
				return control;
				
			}
			
			// Surname Control Method
			public boolean checkSurname(String surname) {
				boolean control = false;
				if(surname.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Enter your last name !","Message",JOptionPane.ERROR_MESSAGE);
					control=false;
				}
				else {
					for (int i = 0; i < surname.length(); i++) {
						if(surname.charAt(i)<(char)65 || surname.charAt(i)>(char)122 || surname.charAt(i)==(char)91 || surname.charAt(i)==(char)92 || 
								surname.charAt(i)==(char)93 || surname.charAt(i)==(char)94 || surname.charAt(i)==(char)95 || surname.charAt(i)==(char)96	)
						{
							JOptionPane.showMessageDialog(null, "You entered your last name incorrectly !","Message",JOptionPane.ERROR_MESSAGE);
							surnameField.setText("");
							control = false;
							break;
						}
						else {
							control = true;
						}
					}
				}
				return control;
			}
	
			// Age Control Method
			public boolean checkAge(String age) {
				boolean control = false;
				try {
					if(age.equals("")) {
						JOptionPane.showMessageDialog(null, "Enter your age !","Message",JOptionPane.ERROR_MESSAGE);
						control = false;
					}
					else {
						int age_ = Integer.valueOf(age);
						if(age_>120 || age_<0) {
							JOptionPane.showMessageDialog(null, "You entered your age incorrectly  !","Message",JOptionPane.ERROR_MESSAGE);
							ageField.setText("");
							control = false;
						}
						else {
							control = true;
						}
					}
				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "your age is wrong !","Message",JOptionPane.ERROR_MESSAGE);
					ageField.setText("");
					control = false;
					// if it is dropped here, string is entered instead of age and an error message is sent.
					
				}
				return control;
			}
	
			// Gender Control Method
			public boolean checkGender(String gender) {
				boolean control = false;
				if(gender.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter your gender !","Message",JOptionPane.ERROR_MESSAGE);
					control = false;
				}
				else {
					if(gender.equalsIgnoreCase("F")|| gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("Man") || gender.equalsIgnoreCase("Woman") ) {
						// no problem
						control = true;
					}
					else {
						JOptionPane.showMessageDialog(null, "Gender was entered incorrectly!","Message",JOptionPane.ERROR_MESSAGE);
						genderField.setText("");
						control = false;
					}
				}
				return control;
			}
		
			
			// Phone Control Methods (3 methods) 
			public boolean checkPAreaCode(String pAreaCode) {
				boolean control = false;
				try {
					if(pAreaCode.equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Please enter area code !","Message",JOptionPane.ERROR_MESSAGE);
						control = false;
					}
					else
					{
						
						if(pAreaCode.length()!=3) {
							JOptionPane.showMessageDialog(null, "Phone Area code was entered incorrectly, only 3 digits !",
									"Message",JOptionPane.ERROR_MESSAGE);
							pAreaCodeField.setText("");
							control = false;
						}
						else 
						{
							
							int CodeControl = Integer.valueOf(pAreaCode);
							control = true;
						}
						
					}	
				} catch (Exception e) {
				
					JOptionPane.showMessageDialog(null, "enter number !","Message",JOptionPane.ERROR_MESSAGE);
					pAreaCodeField.setText("");
					control = false;
					// if it fell here, string is entered instead of digit and I will send an error.
					
				}
				return control;
			}
	
			public boolean checkPhoneCode(String phoneCode) {
				boolean control = false;
				try {
					if(phoneCode.equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Please enter phone code !","Message",JOptionPane.ERROR_MESSAGE);
						control = false;
					}
					else 
					{
						if(phoneCode.length()!=3) {
							JOptionPane.showMessageDialog(null, "Phone code was entered incorrectly, only 3 digits !",
									"Message",JOptionPane.ERROR_MESSAGE);
							phoneCodeField.setText("");
							control = false;
						}
						else 
						{
							
							int phoneC = Integer.valueOf(phoneCode);
							control = true;
						
						}
		
						
					}
					
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "enter number !","Message",JOptionPane.ERROR_MESSAGE);
					phoneCodeField.setText("");
					control = false;
					// if it fell here, string is entered instead of digit and I will send an error.
				}
				return control;
			}
			
			public boolean checkPhone(String phone) {
				boolean control = false;
				try {
					if(phone.equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Please enter phone !","Message",JOptionPane.ERROR_MESSAGE);
						control = false;
					}
					else 
					{
						if(phone.length()!=4) 
						{
							JOptionPane.showMessageDialog(null, "Phone entered incorrectly, only 4 digits !",
									"Message",JOptionPane.ERROR_MESSAGE);
							phoneField.setText("");
							control = false;
						}
						else 
						{
							int pho= Integer.valueOf(phone);
							control = true;
							
						}
		
						
					}
					
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "enter number !","Message",JOptionPane.ERROR_MESSAGE);
					phoneField.setText("");
					control = false;
					// if it fell here, string is entered instead of digit and I will send an error.
				}
				return control;
			}
			
			// Country Control Method
			public boolean checkCountry(String country) {
				boolean control = false;
				if(country.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "enter country !","Message",JOptionPane.ERROR_MESSAGE);
					control=false;
				}
				else {
					for (int i = 0; i < country.length(); i++) {
						if(country.charAt(i)<(char)65 || country.charAt(i)>(char)122 || country.charAt(i)==(char)91 || country.charAt(i)==(char)92 || 
								country.charAt(i)==(char)93 || country.charAt(i)==(char)94 || country.charAt(i)==(char)95 || country.charAt(i)==(char)96	)
						{
							JOptionPane.showMessageDialog(null, "You entered your country wrong !","Message",JOptionPane.ERROR_MESSAGE);
							countryField.setText("");
							control = false;
							break;
							
						}
						else {
							control = true;
						}		
					}
				}
				return control;
			}
			
			
			// City Control Method
			public boolean checkCity(String city) {
				boolean control = false;
				if(city.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "enter city !","Message",JOptionPane.ERROR_MESSAGE);
					control=false;
				}
				else {
					for (int i = 0; i < city.length(); i++) {
						if(city.charAt(i)<(char)65 || city.charAt(i)>(char)122 || city.charAt(i)==(char)91 || city.charAt(i)==(char)92 || 
								city.charAt(i)==(char)93 || city.charAt(i)==(char)94 || city.charAt(i)==(char)95 || city.charAt(i)==(char)96	)
						{
							JOptionPane.showMessageDialog(null, "City entered incorrectly !","Message",JOptionPane.ERROR_MESSAGE);
							cityField.setText("");
							control = false;
							break;
							
						}
						else {
							control = true;
						}		
					}
				}
				return control;
			}
			
			// Street Control Method
			public boolean checkStreet(String street) {
				boolean control = false;
				if(street.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "enter street !","Message",JOptionPane.ERROR_MESSAGE);
					control=false;
				}
				else {
					for (int i = 0; i < street.length(); i++) {
						if(street.charAt(i)<(char)65 || street.charAt(i)>(char)122 || street.charAt(i)==(char)91 || street.charAt(i)==(char)92 || 
								street.charAt(i)==(char)93 || street.charAt(i)==(char)94 || street.charAt(i)==(char)95 || street.charAt(i)==(char)96	)
						{
							JOptionPane.showMessageDialog(null, "Street entered incorrectly !","Message",JOptionPane.ERROR_MESSAGE);
							streetField.setText("");
							control = false;
							break;
							
						}
						else {
							control = true;
						}		
					}
				}
				return control;
			}
			
			// Balance Control Method
			private boolean checkBalance(String balance) {
				boolean control = false;
				try {
					if(balance.equals("")) {
						JOptionPane.showMessageDialog(null, "Enter balance !","Message",JOptionPane.ERROR_MESSAGE);
						control=false;
					}
					else {
						int balanc = Integer.valueOf(balance);
						if(balanc<=0) {
							JOptionPane.showMessageDialog(null, "No balance, you can't buy anything !","Message",JOptionPane.ERROR_MESSAGE);
							balanceField.setText("");
							control=false;
						}
						else {
							control = true;
						}
					}
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "enter number !","Message",JOptionPane.ERROR_MESSAGE);
					balanceField.setText("");
					control = false;
					// if it fell here, string is entered instead of digit and I will send an error.
				}
				return control;
			}
			
			// CVV Control Method
			public boolean checkCvv(String cvv) {
				boolean control = false;
				try {
					if(cvv.equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Please enter cvv !","Message",JOptionPane.ERROR_MESSAGE);
						control = false;
					}
					else 
					{
						if(cvv.length()!=3) {
							JOptionPane.showMessageDialog(null, "cvv was entered incorrectly, only 3 digits !",
									"Message",JOptionPane.ERROR_MESSAGE);
							cvvField.setText("");
							control = false;
						}
						else 
						{
							
							int Cvv = Integer.valueOf(cvv);
							control = true;
						
						}
		
					}
					
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "enter number !","Message",JOptionPane.ERROR_MESSAGE);
					cvvField.setText("");
					control = false;
					// if it fell here, string is entered instead of digit and I will send an error.
				}
				return control;
			}
			String username;
			String password;
			public void takeUsernamePassword() throws IOException {  // The last user's username and password are retrieved.
				boolean flag = false;
				String address = "Customers_just_usernamePassword.txt";
			
			    File file = new File(address);
		        BufferedReader reader = new BufferedReader(new FileReader(file));
		        String row = reader.readLine();
		        int count = 0;
		        String[] words = null;
		        String[]username_x=new String[100];
		        String[]password_x=new String[100];
			
		         while (row!=null) 
		         {
		        	words = row.split(";");
		    		  username_x[count] = words[0];
		    		   password_x[count] = words[1];
		           row = reader.readLine();
		           count++;
		         }
		        
		        reader.close();
		       
	        username = username_x[count-1];
	        password = password_x[count-1];
				    
			}
}
