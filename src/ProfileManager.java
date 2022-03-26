
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ProfileManager extends JFrame {  // It is designed for admin to access manager information.

	private JPanel contentPane;
	private JTextField name_textField;
	private JTextField surname_textField;
	private JTextField username_textField;
	private JTextField city_textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileManager frame = new ProfileManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProfileManager() 
	{
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); // always makes sure the window is in the middle
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(33, 0, 815, 653);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel NameTextLabel = new JLabel("Name");
		NameTextLabel.setFont(new Font("Ebrima", Font.BOLD, 18));
		NameTextLabel.setBounds(81, 46, 79, 34);
		panel.add(NameTextLabel);
		
		JLabel SurnameTextLabel = new JLabel("Surname");
		SurnameTextLabel.setFont(new Font("Ebrima", Font.BOLD, 18));
		SurnameTextLabel.setBounds(81, 100, 79, 34);
		panel.add(SurnameTextLabel);
		
		JLabel UsernameTextLabel = new JLabel("Username");
		UsernameTextLabel.setFont(new Font("Ebrima", Font.BOLD, 18));
		UsernameTextLabel.setBounds(81, 158, 103, 34);
		panel.add(UsernameTextLabel);
		
		JLabel CityTextLabel = new JLabel("City");
		CityTextLabel.setFont(new Font("Ebrima", Font.BOLD, 18));
		CityTextLabel.setBounds(81, 217, 79, 34);
		panel.add(CityTextLabel);
		
		name_textField = new JTextField();
		name_textField.setBounds(203, 54, 154, 22);
		panel.add(name_textField);
		name_textField.setColumns(10);
		
		surname_textField = new JTextField();
		surname_textField.setColumns(10);
		surname_textField.setBounds(203, 108, 154, 22);
		
		
		panel.add(surname_textField);
		username_textField = new JTextField();
		username_textField.setColumns(10);
		username_textField.setBounds(203, 166, 154, 22);
	
		
		panel.add(username_textField);
		city_textField = new JTextField();
		city_textField.setColumns(10);
		city_textField.setBounds(203, 225, 154, 22);
		
		
		panel.add(city_textField);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();  // cities are thrown into a comboBox component
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"ADANA", "ADIYAMAN", "AFYONKARAH\u0130SAR", 
				"A\u011ERI", "AMASYA", "ANKARA", "ANTALYA", "ARTV\u0130N", "AYDIN", "BALIKES\u0130R", "B\u0130LEC\u0130K", 
				"B\u0130NG\u00D6L", "B\u0130TL\u0130S", "BOLU", "BURDUR", "BURSA", "\u00C7ANAKKALE", "\u00C7ANKIRI", "\u00C7ORUM",
				"DEN\u0130ZL\u0130", "D\u0130YARBAKIR", "ED\u0130RNE", "ELAZI\u011E", "ERZ\u0130NCAN", "ERZURUM",
				"ESK\u0130\u015EEH\u0130R", "GAZ\u0130ANTEP", "G\u0130RESUN", "G\u00DCM\u00DC\u015EHANE", "HAKKAR\u0130",
				"HATAY", "ISPARTA", "MERS\u0130N", "\u0130STANBUL", "\u0130ZM\u0130R", "KARS", "KASTAMONU", "KAYSER\u0130",
				"KIRKLAREL\u0130", "KIR\u015EEH\u0130R", "KOCAEL\u0130", "KONYA\t", "K\u00DCTAHYA", "MALATYA", "MAN\u0130SA",
				"KAHRAMANMARA\u015E", "MARD\u0130N", "MU\u011ELA", "MU\u015E", "NEV\u015EEH\u0130R", "N\u0130\u011EDE", "ORDU", 
				"R\u0130ZE", "SAKARYA", "SAMSUN", "S\u0130\u0130RT", "S\u0130NOP", "S\u0130VAS", "TEK\u0130RDA\u011E", "TOKAT",
				"TRABZON", "TUNCEL\u0130", "\u015EANLIURFA", "U\u015EAK", "VAN", "YOZGAT", "ZONGULDAK", "AKSARAY", "BAYBURT",
				"KARAMAN", "KIRIKKALE", "BATMAN", "\u015EIRNAK", "BARTIN", "ARDAHAN", "I\u011EDIR", "YALOVA", "KARAB\u00DCK",
				"K\u0130L\u0130S", "OSMAN\u0130YE", "D\u00DCZCE"}));
		comboBox.setBounds(81, 345, 246, 22);
		panel.add(comboBox);
		
		JButton btnGetProfile = new JButton("Get Profile");
		btnGetProfile.setForeground(new Color(255, 255, 0));
		btnGetProfile.setBackground(new Color(139, 0, 139));
		btnGetProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String city = String.valueOf(comboBox.getSelectedItem());
					if(checkManager(city)==true) {
						
					}
					else {
						JOptionPane.showMessageDialog(null, "There is no manager in that city yet !","Message",JOptionPane.ERROR_MESSAGE);
					}
				}catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Not found !","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGetProfile.setFont(new Font("Ebrima", Font.BOLD, 18));
		btnGetProfile.setBounds(410, 342, 175, 25);
		panel.add(btnGetProfile);
		
		JLabel lblPleaseSelectCity = new JLabel("please select city");
		lblPleaseSelectCity.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblPleaseSelectCity.setBounds(81, 302, 246, 34);
		panel.add(lblPleaseSelectCity);
		
		JLabel icon1_Label = new JLabel("");
		icon1_Label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Image miniIcon = new ImageIcon(this.getClass().getResource("mini_s2.jpg")).getImage();
		icon1_Label.setIcon(new ImageIcon(miniIcon));
		icon1_Label.setBounds(731, 23, 56, 57);
		panel.add(icon1_Label);
		
		JLabel icon2_Label = new JLabel("");
		icon2_Label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		icon2_Label.setIcon(new ImageIcon(miniIcon));
		icon2_Label.setBounds(731, 108, 56, 53);
		panel.add(icon2_Label);
		
		JLabel icon3_Label = new JLabel("");
		icon3_Label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		icon3_Label.setIcon(new ImageIcon(miniIcon));
		icon3_Label.setBounds(731, 198, 56, 53);
		panel.add(icon3_Label);
		
		JLabel manager_icon_Label = new JLabel("");
		manager_icon_Label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Image managerIcon = new ImageIcon(this.getClass().getResource("manager_1.png")).getImage();  
		manager_icon_Label.setIcon(new ImageIcon(managerIcon));
		manager_icon_Label.setBounds(81, 401, 246, 239);
		panel.add(manager_icon_Label);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				new AdminPageForm().setVisible(true);
				setVisible(false);
			}
		});
		btnGoBack.setForeground(Color.YELLOW);
		btnGoBack.setFont(new Font("Ebrima", Font.BOLD, 18));
		btnGoBack.setBackground(new Color(139, 0, 139));
		btnGoBack.setBounds(410, 380, 175, 25);
		panel.add(btnGoBack);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 0));
		panel_1.setBounds(0, 0, 34, 653);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 0));
		panel_2.setBounds(848, 0, 34, 653);
		contentPane.add(panel_2);
	}                                                           // Manager information is checked and queried.
	public boolean checkManager(String city) throws IOException // Here, manager information is found and the screen is printed.
	{
		boolean flag = false;
		String address = "Managers.txt";
		File file = new File(address);
		 if (!file.exists()) 
		 {
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
         for (int i = 0; i < city_x.length; i++) 
         {
			if(city_x[i]!=null && city != null && city_x[i].equalsIgnoreCase(city)) 
			{
				flag = true;
				city_textField.setText(city_x[i]);
		        name_textField.setText(name_x[i]);
		        surname_textField.setText(surname_x[i]);
		        username_textField.setText(username_x[i]);
		        break;
			  }
		   }
         reader_.close();
         return flag;
	}
}

