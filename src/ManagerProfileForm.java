
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ManagerProfileForm extends JFrame {  // // It is the profiled interface for the Manager.

	private JPanel contentPane;                      // Manager's information is displayed.
	JTable tablo;

	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					ManagerProfileForm frame = new ManagerProfileForm();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public ManagerProfileForm() 
	{
		setTitle("Manager Profile");
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
		panel.setBounds(0, 0, 882, 325);
		contentPane.add(panel);
		Object[]column = {"Profile Information"};
		panel.setLayout(null);
		
		tablo = new JTable(Manager.profileManager,column);
		tablo.setFont(new Font("Arial", Font.BOLD, 17));
		tablo.setBackground(new Color(240, 248, 255));
		tablo.setBounds(156, 99, 391, 80);
		panel.add(tablo);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new ManagerPage().setVisible(true);
					setVisible(false);
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Ohh noo a small error occur  !","Message",JOptionPane.ERROR_MESSAGE);
				}
			    
			}
		});
		btnNewButton.setBounds(629, 40, 145, 31);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(149, 28, 145, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1-city");
		lblNewLabel_1.setBounds(12, 83, 127, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("2-name\r\n");
		lblNewLabel_1_1.setBounds(12, 99, 127, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("3-surname");
		lblNewLabel_1_2.setBounds(12, 117, 127, 16);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("4-username");
		lblNewLabel_1_3.setBounds(12, 136, 127, 16);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("5-password");
		lblNewLabel_1_4.setBounds(12, 156, 127, 16);
		panel.add(lblNewLabel_1_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 323, 882, 330);
		contentPane.add(panel_1);
		
	}
}
