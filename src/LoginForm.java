import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoginForm extends JFrame {  // This is an interface created for registration operations.

	private JPanel contentPane;
	private JTextField usertext;
	private JPasswordField jpasswordText;


	public static void main(String[] args) {  
		
		LoginForm login = new LoginForm();
		login.setVisible(true);
	}

	public LoginForm() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 900, 700);  // commonly used window borders
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 882, 653);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 425, 652);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel userLabel = new JLabel("");
		Image imgUser1 = new ImageIcon(this.getClass().getResource("userpurple.png")).getImage(); // a picture is added
		userLabel.setIcon(new ImageIcon(imgUser1));
		userLabel.setBounds(76, 66, 132, 168);                    
		panel_1.add(userLabel);
		
		JLabel userLabel2 = new JLabel("");
		userLabel2.setBackground(new Color(0, 0, 0));
		Image imgUser2 = new ImageIcon(this.getClass().getResource("userorange.png")).getImage();
		userLabel2.setIcon(new ImageIcon(imgUser2));
		userLabel2.setBounds(221, 66, 132, 168);
		panel_1.add(userLabel2);
		
		JLabel lockIconLabel = new JLabel("");
		lockIconLabel.setBounds(102, 266, 214, 250);
		panel_1.add(lockIconLabel);
		Image imgLock = new ImageIcon(this.getClass().getResource("password.png")).getImage();
		lockIconLabel.setIcon(new ImageIcon(imgLock));
		
		JButton adminButton = new JButton("Admin Login");
		adminButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				String username = usertext.getText(); // username is taken from the screen
				String password = String.valueOf(jpasswordText.getPassword());  // password is taken from the screen
				if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin"))
				{
					new AdminPageForm().setVisible(true);
				    setVisible(false);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please enter username and password for admin.\r\n" + 
							"username: admin, password: admin !","Message",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		adminButton.setBounds(89, 566, 119, 38);
		panel_1.add(adminButton);
		adminButton.setForeground(new Color(0, 0, 0));
		adminButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adminButton.setBackground(new Color(255, 69, 0));
		
		JButton ManagerButton = new JButton("Manager Login");
		ManagerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ManagerForm().setVisible(true);
			    setVisible(false);
			}
		});
		ManagerButton.setBounds(247, 566, 119, 38);
		panel_1.add(ManagerButton);
		ManagerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ManagerButton.setForeground(new Color(0, 0, 0));
		ManagerButton.setBackground(new Color(123, 104, 238));
		
		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Sitka Small", Font.BOLD, 15));
		panel_2.setBackground(new Color(123, 104, 238));
		panel_2.setBounds(423, 0, 459, 652);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		usertext = new JTextField();
		usertext.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) 
			{
				if(usertext.getText().trim().toLowerCase().equals("username"))
				{
					usertext.setText("");
					usertext.setForeground(Color.BLACK);
				}
				Border jlabelicon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
				usertext.setBorder(jlabelicon);
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(usertext.getText().trim().equals("")|| usertext.getText().trim().toLowerCase().equals("username"))
				{
					usertext.setText("username");
					usertext.setForeground(new Color(153,153,153));
				}
			
			usertext.setBorder(null);
			}
		});
		usertext.setFont(new Font("Sitka Small", Font.BOLD, 15));
		usertext.setForeground(new Color(105, 105, 105));
		usertext.setText("username\r\n");
		usertext.setBounds(171, 221, 288, 43);
		panel_2.add(usertext);
		usertext.setColumns(10);
		
		jpasswordText = new JPasswordField();
		jpasswordText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				String pass = String.valueOf(jpasswordText.getPassword());  // password is taken
				if(pass.trim().toLowerCase().equals("password"))
				{
					jpasswordText.setText("");
					jpasswordText.setForeground(Color.BLACK);
				}
				Border jlabelicon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
				jpasswordText.setBorder(jlabelicon);
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				String pass = String.valueOf(jpasswordText.getPassword()); // password is taken
				if(pass.trim().equals("")|| pass.trim().toLowerCase().equals("password"))
				{
					jpasswordText.setText("username");
					jpasswordText.setForeground(new Color(153,153,153));
				}
			
				jpasswordText.setBorder(null);
			}
		});
		jpasswordText.setText("password");
		jpasswordText.setFont(new Font("Arial", Font.BOLD, 15));
		jpasswordText.setForeground(new Color(105, 105, 105));
		jpasswordText.setSelectionColor(Color.BLACK);
		jpasswordText.setSelectedTextColor(Color.BLACK);
		jpasswordText.setToolTipText("");
		jpasswordText.setBounds(171, 277, 288, 43);
		panel_2.add(jpasswordText);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(0, 38, 459, 78);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setFont(new Font("Sitka Small", Font.BOLD, 25));
		loginLabel.setForeground(new Color(255, 69, 0));
		loginLabel.setBounds(181, 13, 114, 52);
		panel_3.add(loginLabel);
		
		JLabel lblX = new JLabel(" X");
		lblX.setFont(new Font("Sitka Small", Font.BOLD, 25));
		lblX.setForeground(Color.WHITE);
		lblX.setBounds(411, 22, 36, 34);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Border jlabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
		lblX.setBorder(jlabel_border);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border jlabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW);
				lblX.setBorder(jlabel_border);
				lblX.setForeground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border jlabel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
				lblX.setBorder(jlabel_border);
				lblX.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panel_3.add(lblX);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(0, 221, 174, 43);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel uTextLabel = new JLabel("username");
		uTextLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));   // username Label
		uTextLabel.setForeground(new Color(255, 69, 0));
		uTextLabel.setBounds(12, 13, 121, 16);
		panel_4.add(uTextLabel);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(0, 0, 0));
		panel_4_1.setBounds(0, 277, 174, 43);
		panel_2.add(panel_4_1);
		panel_4_1.setLayout(null);
		
		JLabel pTextLabel = new JLabel("password");                         
		pTextLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));    // password Label
		pTextLabel.setForeground(new Color(255, 69, 0));
		pTextLabel.setBounds(12, 13, 133, 16);
		panel_4_1.add(pTextLabel);
		
		JButton saveButton = new JButton("Save");                     // Save Button
		saveButton.setFont(new Font("Sitka Small", Font.BOLD, 15));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usertext.getText();
				String password = String.valueOf(jpasswordText.getPassword());
				
			    if(username.equals("") || password.equals("")|| username.equals("username") || password.equals("password") || 
			    		username.equalsIgnoreCase("admin")||password.equalsIgnoreCase("admin")) {
			    	// send message cannot be empty!
			    	JOptionPane.showMessageDialog(null, "Error","Wrong",JOptionPane.OK_OPTION);
			    }
			    else 
			    {
			    	try 
			    	{
			    		// I'm checking if it's already taken before saving to the file
			    		Login log = new Login();
			    		
			    		if(log.checkPassword(username, password)==true) {
			    			JOptionPane.showMessageDialog(null, "You cannot use this username or password !","Message",JOptionPane.ERROR_MESSAGE);
			    		}
			    		else {
			    			saveInFile(username,password);    // it is saved to file.
			    			new CustomerForm().setVisible(true);
						    setVisible(false);
			    		}
					} 
			    	catch (IOException e) 
			    	{
						e.printStackTrace();
					}
			    }	
			}
			
		});
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				saveButton.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				saveButton.setBackground(Color.BLACK);
			}
		});
		saveButton.setForeground(new Color(255, 69, 0));
		saveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saveButton.setBackground(new Color(0, 0, 0));
		saveButton.setBounds(293, 371, 141, 50);
		panel_2.add(saveButton);
		
		JButton startShoppingButton = new JButton("Start Shopping");
		startShoppingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String username = usertext.getText();
				String password = String.valueOf(jpasswordText.getPassword());
				
				if(username.equalsIgnoreCase("admin") || password.equalsIgnoreCase("admin")) 
				{
					JOptionPane.showMessageDialog(null, "username or password is wrong !","Message",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					try {
						Login log = new Login();
						if(log.checkPassword(username, password)==true) 
						{	
							 new ShoppingForm().setVisible(true);
							 setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "username or password is wrong !","Message",JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException e) 
					{
						JOptionPane.showMessageDialog(null, " An error occured !","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		startShoppingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				startShoppingButton.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				startShoppingButton.setBackground(Color.BLACK);
			}
		});
		startShoppingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		startShoppingButton.setBackground(new Color(0, 0, 0));
		startShoppingButton.setForeground(new Color(255, 69, 0));
		startShoppingButton.setFont(new Font("Sitka Small", Font.BOLD, 15));
		startShoppingButton.setBounds(59, 372, 167, 48);
		panel_2.add(startShoppingButton);
		this.setLocationRelativeTo(null);
	}
	
	public void saveInFile(String username,String password) throws IOException 
	{
		File fil = new File("Customers_just_usernamePassword.txt");   
	    if (!fil.exists()) {
	        fil.createNewFile();
	    }

	    FileWriter filWriter = new FileWriter(fil, true);
	    BufferedWriter biWriter = new BufferedWriter(filWriter);
	    biWriter.write(username+";"+password+'\n');
	    biWriter.close();
	    JOptionPane.showMessageDialog(null, "Saved Successfully !","Message",JOptionPane.INFORMATION_MESSAGE);
	}
}

