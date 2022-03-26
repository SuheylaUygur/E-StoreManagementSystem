
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AdminPageForm extends JFrame {  // This class contains the interface designed for admin.
                                             // Can use admin privileges.
	private JPanel contentPane;
	Image img_admin = new ImageIcon(this.getClass().getResource("admin.jpeg")).getImage();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPageForm frame = new AdminPageForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminPageForm() {
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setLocationRelativeTo(null);
		setBounds(100, 100, 900, 700);
		//setUndecorated(true);
		this.setLocationRelativeTo(null);    // it always makes sure the window is in the middle
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menuu = new JPanel();
		menuu.setBackground(new Color(0, 128, 128));
		menuu.setBounds(0, 0, 315, 653);
		contentPane.add(menuu);
		menuu.setLayout(null);
		
		JLabel adminIcon = new JLabel("");
		adminIcon.setHorizontalAlignment(SwingConstants.CENTER);
		adminIcon.setBounds(10, 10, 293, 144);
		adminIcon.setIcon(new ImageIcon(img_admin));
		menuu.add(adminIcon);
		
		JPanel cargo_operations = new JPanel();
		cargo_operations.addMouseListener(new PanelButtonMouseAdapter(cargo_operations));
		cargo_operations.setBackground(new Color(0, 139, 139));
		cargo_operations.setBounds(0, 291, 313, 54);
		menuu.add(cargo_operations);
		cargo_operations.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("customer store satisfaction statistics");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				new StatistikForm().setVisible(true);
			    setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 293, 34);
		cargo_operations.add(lblNewLabel);
		
		JButton managerPageButton = new JButton("Manager Settings");
		managerPageButton.setBackground(new Color(0, 128, 128));
		managerPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		managerPageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ProfileManager().setVisible(true);
			    setVisible(false);
			}
		});
		managerPageButton.setBounds(0, 344, 313, 54);
		menuu.add(managerPageButton);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new LoginForm().setVisible(true);
			    setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(0, 396, 313, 54);
		menuu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Product Management");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(0, 229, 313, 62);
		menuu.add(btnNewButton_1);
		JLabel CargoLabel = new JLabel("");
		CargoLabel.setBounds(377, 73, 436, 444);
		contentPane.add(CargoLabel);
		JButton btnShowAllCargo = new JButton("Cargo to be sent");
		Area area = new Area();
		try {
			area.showAllCargo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnShowAllCargo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if(area.q.isEmpty()==true)
				{
					CargoLabel.setText("");
					JOptionPane.showMessageDialog(null, "All cargo is over !","Message",JOptionPane.WARNING_MESSAGE);
				}
				else 
				{
					CargoLabel.setText((String)area.q.peek());
					area.q.dequeue();
				}
			
			}
			
		});
		btnShowAllCargo.setBackground(new Color(0, 128, 128));
		btnShowAllCargo.setBounds(0, 447, 313, 54);
		menuu.add(btnShowAllCargo);
		
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AdminManageForm().setVisible(true);
			    setVisible(false);
			}
		});
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panelProducts;
		public PanelButtonMouseAdapter(JPanel panelProducts) {
			this.panelProducts = panelProducts;
		}
		
		public void mouseEntered(MouseEvent e) {
			panelProducts.setBackground(new Color(120, 120, 150));
			
		}
		public void mouseExited(MouseEvent e) {
			panelProducts.setBackground(new Color(50, 80, 80));
		}
		public void mousePressed(MouseEvent e) {
			panelProducts.setBackground(new Color(120, 120, 150));
		}
		public void mouseReleased(MouseEvent e) {
			panelProducts.setBackground(new Color(120, 120, 150));
		}
	}
}

