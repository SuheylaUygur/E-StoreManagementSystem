
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ManagerForm extends JFrame { // ManagerForm manager is designed for registration processes.

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	public static Manager manager;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerForm frame = new ManagerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ManagerForm() {
		setTitle("MANAGER LOGIN PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); // always makes sure the window is in the middle.
		JComboBox<Object> cityComboBox = new JComboBox<Object>();
		cityComboBox.setBackground(Color.WHITE);
		cityComboBox.setForeground(Color.BLACK);
		cityComboBox.setModel(new DefaultComboBoxModel<Object>(new String[]  // A city can have a manager.
				{"ADANA", "ADIYAMAN", "AFYONKARAH\u0130SAR", "A\u011ERI", "AMASYA", "ANKARA", "ANTALYA", "ARTV\u0130N", 
						"AYDIN", "BALIKES\u0130R", "B\u0130LEC\u0130K", "B\u0130NG\u00D6L", "B\u0130TL\u0130S", "BOLU", "BURDUR", 
						"BURSA", "\u00C7ANAKKALE", "\u00C7ANKIRI", "\u00C7ORUM", "DEN\u0130ZL\u0130", "D\u0130YARBAKIR", "ED\u0130RNE", 
						"ELAZI\u011E", "ERZ\u0130NCAN", "ERZURUM", "ESK\u0130\u015EEH\u0130R", "GAZ\u0130ANTEP", "G\u0130RESUN", 
						"G\u00DCM\u00DC\u015EHANE", "HAKKAR\u0130", "HATAY", "ISPARTA", "MERS\u0130N", "\u0130STANBUL", "\u0130ZM\u0130R", 
						"KARS", "KASTAMONU", "KAYSER\u0130", "KIRKLAREL\u0130", "KIR\u015EEH\u0130R", "KOCAEL\u0130", "KONYA\t", 
						"K\u00DCTAHYA", "MALATYA", "MAN\u0130SA", "KAHRAMANMARA\u015E", "MARD\u0130N", "MU\u011ELA", "MU\u015E", 
						"NEV\u015EEH\u0130R", "N\u0130\u011EDE", "ORDU", "R\u0130ZE", "SAKARYA", "SAMSUN", "S\u0130\u0130RT", "S\u0130NOP", 
						"S\u0130VAS", "TEK\u0130RDA\u011E", "TOKAT", "TRABZON", "TUNCEL\u0130", "\u015EANLIURFA", "U\u015EAK", "VAN", 
						"YOZGAT", "ZONGULDAK", "AKSARAY", "BAYBURT", "KARAMAN", "KIRIKKALE", "BATMAN", "\u015EIRNAK", "BARTIN", "ARDAHAN", 
						"I\u011EDIR", "YALOVA", "KARAB\u00DCK", "K\u0130L\u0130S", "OSMAN\u0130YE", "D\u00DCZCE"}));
		cityComboBox.setBounds(45, 86, 332, 32);
		contentPane.add(cityComboBox);
		
		JLabel cityTextLabel = new JLabel("Please select a city");
		cityTextLabel.setForeground(new Color(220, 20, 60));
		cityTextLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
		cityTextLabel.setBounds(43, 40, 334, 33);
		contentPane.add(cityTextLabel);
		
		JPanel redPanel = new JPanel();
		redPanel.setBackground(new Color(220, 20, 60));
		redPanel.setBounds(0, 156, 882, 60);
		contentPane.add(redPanel);
		redPanel.setLayout(null);
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(new Color(135, 206, 250));
		bluePanel.setBounds(0, 215, 882, 237);
		contentPane.add(bluePanel);
		bluePanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Enter Name");
		nameLabel.setForeground(new Color(220, 20, 60));
		nameLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
		nameLabel.setBounds(36, 68, 119, 34);
		bluePanel.add(nameLabel);
		
		JLabel surnameLabel = new JLabel("Enter Surname");
		surnameLabel.setForeground(new Color(220, 20, 60));
		surnameLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
		surnameLabel.setBounds(225, 68, 119, 34);
		bluePanel.add(surnameLabel);
		
		JLabel usernameLabel = new JLabel("Enter Username");
		usernameLabel.setForeground(new Color(220, 20, 60));
		usernameLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
		usernameLabel.setBounds(429, 68, 140, 34);
		bluePanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Enter Password");
		passwordLabel.setForeground(new Color(220, 20, 60));
		passwordLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 15));
		passwordLabel.setBounds(633, 68, 119, 34);
		bluePanel.add(passwordLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(12, 133, 155, 34);
		bluePanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(215, 133, 155, 34);
		bluePanel.add(surnameTextField);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(414, 133, 155, 34);
		bluePanel.add(usernameTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(613, 133, 193, 34);
		bluePanel.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 452, 882, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton saveButton = new JButton("Save");  // When the Save button is pressed, the manager information is checked.
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String manager_name = nameTextField.getText();
				if(checked_manager_name(manager_name) == true) {
					String manager_surname = surnameTextField.getText();
					if(checked_manager_surname(manager_surname) == true) {
						String manager_username = usernameTextField.getText();
						if(manager_username.equals("")) {
							JOptionPane.showMessageDialog(null, "Enter your username !","Message",JOptionPane.ERROR_MESSAGE);
						}
						else {
							String manager_password = String.valueOf(passwordField.getPassword());
							if(manager_password.equals("")) {
								JOptionPane.showMessageDialog(null, "enter your password !","Message",JOptionPane.ERROR_MESSAGE);
							}
							else {
								try {
									String manager_city = String.valueOf(cityComboBox.getSelectedItem()) ;
									if(checkManagerCity(manager_city)==true) 
									{
										JOptionPane.showMessageDialog(null, "There can only be one admin per city !","Message",
												JOptionPane.ERROR_MESSAGE);
									}
									else {
										JOptionPane.showMessageDialog(null, "Login successful","Message",JOptionPane.INFORMATION_MESSAGE);
										
										manager = new Manager(manager_city,manager_name,manager_surname,manager_username,manager_password);
										manager.createProfile(manager_city, manager_name, manager_surname, manager_username, manager_password);
										manager.Save();
										JOptionPane.showMessageDialog(null, "Login successful. You are redirected to the Manager page !",
												"Message",JOptionPane.INFORMATION_MESSAGE);
										new ManagerPage().setVisible(true);
									    setVisible(false);
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		});
		saveButton.setBounds(634, 62, 169, 47);
		saveButton.setForeground(new Color(220, 20, 60));
		saveButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
		saveButton.setBackground(Color.WHITE);
		panel.add(saveButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Image meetIcon = new ImageIcon(this.getClass().getResource("meeting.jpg")).getImage();  
		lblNewLabel.setIcon(new ImageIcon(meetIcon));
		lblNewLabel.setBounds(37, 0, 345, 201);
		panel.add(lblNewLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String manager_name = nameTextField.getText();
				String manager_surname = surnameTextField.getText();
				String manager_username = usernameTextField.getText();
				String manager_password = String.valueOf(passwordField.getPassword());
				String manager_city = String.valueOf(cityComboBox.getSelectedItem()) ;
				try {
					if(checkManager(manager_city,manager_name,manager_surname,manager_username, manager_password)==true) 
					{
						Manager.createProfile(manager_city, manager_name, manager_surname, manager_username, manager_password);
						JOptionPane.showMessageDialog(null, "Login successful. You are redirected to the Manager page!",
								"Message",JOptionPane.INFORMATION_MESSAGE);
						new ManagerPage().setVisible(true);
					    setVisible(false);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Login failed, try again !",
								"Message",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		loginButton.setForeground(new Color(220, 20, 60));
		loginButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
		loginButton.setBackground(Color.WHITE);
		loginButton.setBounds(441, 62, 169, 47);
		panel.add(loginButton);
		
		JPanel icon_panel = new JPanel();
		icon_panel.setBackground(Color.WHITE);
		icon_panel.setBounds(0, 0, 882, 154);
		contentPane.add(icon_panel);
		icon_panel.setLayout(null);
		
		JLabel TurkeyLabel = new JLabel("");
		TurkeyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Image TRIcon = new ImageIcon(this.getClass().getResource("turkey.jpg")).getImage(); 
		TurkeyLabel.setIcon(new ImageIcon(TRIcon));
		TurkeyLabel.setBounds(518, 13, 216, 117);
		icon_panel.add(TurkeyLabel);
	}
	
	// CONTROL MANAGER NAME
	public boolean checked_manager_name(String name) 
	{
		boolean control = false;
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "enter your name !","Message",JOptionPane.ERROR_MESSAGE);
			control=false;
		}
		else {
			for (int i = 0; i < name.length(); i++) {
				if(name.charAt(i)<(char)65 || name.charAt(i)>(char)122 || name.charAt(i)==(char)91 || name.charAt(i)==(char)92 || 
						name.charAt(i)==(char)93 || name.charAt(i)==(char)94 || name.charAt(i)==(char)95 || name.charAt(i)==(char)96	)
				{
					JOptionPane.showMessageDialog(null, "You entered your name wrong !","Message",JOptionPane.ERROR_MESSAGE);
					nameTextField.setText("");
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
	// CONTROL MANAGER SURNAME
	public boolean checked_manager_surname(String surname) {
		boolean control = false;
		if(surname.equals("")) {
			JOptionPane.showMessageDialog(null, "Enter your last name !","Message",JOptionPane.ERROR_MESSAGE);
			control=false;
		}
		else {
			for (int i = 0; i < surname.length(); i++) {
				if(surname.charAt(i)<(char)65 || surname.charAt(i)>(char)122 || surname.charAt(i)==(char)91 || surname.charAt(i)==(char)92 || 
						surname.charAt(i)==(char)93 || surname.charAt(i)==(char)94 || surname.charAt(i)==(char)95 || surname.charAt(i)==(char)96	)
				{
					JOptionPane.showMessageDialog(null, "You entered your last name incorrectly !","Message",JOptionPane.ERROR_MESSAGE);
					surnameTextField.setText("");
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
	// CONTROL MANAGER    // Manager file is read and control is made from the recorded information.
	public boolean checkManager(String city,String name,String surname,String username, String password) throws IOException {
		boolean flag = false;
		
		String address = "Managers.txt";
		File file = new File(address);
		 if (!file.exists()) {
		        file.createNewFile();
		    }
		    
	        BufferedReader reader_ = new BufferedReader(new FileReader(file));
	        String row = reader_.readLine();
	        String[] words = null;
	        String[]username_x=new String[100];
	        String[]password_x=new String[100];
	        String[]city_x=new String[100];
	        String[]name_x=new String[100];
	        String[]surname_x=new String[100];
	        
	        int count = 0;
	        
         while (row!=null) 
         {
  		   words = row.split(";");
  		   city_x[count] = words[0];
		   name_x[count] = words[1];
		   surname_x[count] = words[2];
  		   username_x[count] = words[3];
  		   password_x[count] = words[4];
      	   count++;
           row = reader_.readLine();
         
         }
         
         
         for (int i = 0; i < city_x.length; i++) {
			if(city.equals(city_x[i])) {
				if(name.equals(name_x[i])) {
					if(surname.equals(surname_x[i])) {
					if(username.equals(username_x[i])) {
						if(password.equals(password)) {
							flag = true;
							break;
						}
					}
				  }
				}
			}
		}
         reader_.close();
         return flag;
	}
	// CONTROL MANAGER CITY
	public boolean checkManagerCity(String city) throws IOException {
		boolean flag = false;
		
		String address = "Managers.txt";
		File file = new File(address);
		 if (!file.exists()) {
		        file.createNewFile();
		    }
		    
	        BufferedReader reader2 = new BufferedReader(new FileReader(file));
	        String row = reader2.readLine();
	        String[] words = null;
	      
	        String[]city_x=new String[100];
	      
	        int count = 0;
	        
         while (row!=null) 
         {
  		   words = row.split(";");
  		   city_x[count] = words[0];
      	   count++;
           row = reader2.readLine();
         
         }
         
         for (int i = 0; i < city_x.length; i++) {
			if(city.equals(city_x[i])) {
				flag = true;
				break;
				
			}
		}
         reader2.close();
         return flag;
	}
}
