
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CustomerProfileForm extends JFrame { // It is the class from which the customer information is retrieved.

	private JPanel contentPane;
	JTable tablo;  // used to create a table

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerProfileForm frame = new CustomerProfileForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerProfileForm() {
		setTitle("Customer Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 900, 700); 
		this.setLocationRelativeTo(null); // always makes sure the window is in the middle.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 882, 354);
		contentPane.add(panel);
		Object[]column = {"Profile Information"};
		panel.setLayout(null);

		
		tablo = new JTable(Customer.profileCustomer,column);
		tablo.setBounds(151, 83, 391, 208);
		tablo.setFont(new Font("Arial", Font.BOLD, 17));
		tablo.setBackground(new Color(240, 248, 255));
		panel.add(tablo);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(629, 76, 145, 31);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new ShoppingForm().setVisible(true);
					setVisible(false);
					
				} catch (FileNotFoundException e1) {
					
					JOptionPane.showMessageDialog(null, "Ohh noo occur a small error !","Message",JOptionPane.ERROR_MESSAGE);
				}
			    
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setBounds(149, 28, 145, 42);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1-username");
		lblNewLabel_1.setBounds(12, 83, 127, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("2-password\r\n");
		lblNewLabel_1_1.setBounds(12, 99, 127, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("3-name");
		lblNewLabel_1_2.setBounds(12, 117, 127, 16);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("4-surname");
		lblNewLabel_1_3.setBounds(12, 136, 127, 16);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("5-balance");
		lblNewLabel_1_4.setBounds(12, 156, 127, 16);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("6-CVV");
		lblNewLabel_1_5.setBounds(12, 178, 127, 16);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("7-card password");
		lblNewLabel_1_6.setBounds(12, 196, 127, 16);
		panel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("8-gender");
		lblNewLabel_1_7.setBounds(12, 216, 127, 16);
		panel.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("9-age");
		lblNewLabel_1_8.setBounds(12, 233, 127, 16);
		panel.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("10-telephone");
		lblNewLabel_1_9.setBounds(12, 255, 127, 16);
		panel.add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_1_10 = new JLabel("11-country");
		lblNewLabel_1_10.setBounds(12, 275, 127, 16);
		panel.add(lblNewLabel_1_10);
		
		JLabel lblNewLabel_1_11 = new JLabel("12-city");
		lblNewLabel_1_11.setBounds(12, 296, 127, 16);
		panel.add(lblNewLabel_1_11);
		
		JLabel lblNewLabel_1_12 = new JLabel("13-street");
		lblNewLabel_1_12.setBounds(12, 317, 127, 16);
		panel.add(lblNewLabel_1_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 354, 882, 299);
		contentPane.add(panel_1);
		
	}
}
