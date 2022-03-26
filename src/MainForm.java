
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class MainForm extends JFrame {  // This class is the first to run. 
                                        // This is a starting point. The MainForm class is the welcome class to the shopping page.
	private JPanel contentPane;
	private JProgressBar MyBar;
	private JLabel percentage;
	private JLabel smileIconLabel;
	private JLabel bucketIconLabel;
	private JLabel welcomeTextLabel;

	public static void main(String[] args) 
	{
		MainForm main = new MainForm();
		main.setVisible(true);
		try {
			for (int i = 0; i <= 100; i++)  // Here, progress bar element is filled slowly.
			{
				Thread.sleep(40);           
				main.MyBar.setValue(i);
				main.percentage.setText(Integer.toString(i)+"%");
			}
		}catch(Exception e) {}
		
		new LoginForm().setVisible(true);
		main.dispose();
	} 

	
	public MainForm() 
	{
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 882, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		percentage = new JLabel("%");
		percentage.setBounds(409, 543, 98, 64);
		percentage.setForeground(new Color(255, 69, 0));
		percentage.setFont(new Font("Sitka Small", Font.BOLD, 30));
		panel.add(percentage);
		
		smileIconLabel = new JLabel("");
		Image smileIcon = new ImageIcon(this.getClass().getResource("kid.png")).getImage();    // Here, one child picture is attached.
		smileIconLabel.setIcon(new ImageIcon(smileIcon));
		smileIconLabel.setBounds(37, 0, 343, 572);
		panel.add(smileIconLabel);
		
		bucketIconLabel = new JLabel("");
		Image bucketIcon = new ImageIcon(this.getClass().getResource("cart.png")).getImage();   // A picture of a basket has been added.
		bucketIconLabel.setIcon(new ImageIcon(bucketIcon));
		bucketIconLabel.setForeground(new Color(0, 0, 0));
		bucketIconLabel.setBounds(553, 380, 288, 227);
		panel.add(bucketIconLabel);
		
		welcomeTextLabel = new JLabel("Welcome to the Ceng Strore\r\n");
		welcomeTextLabel.setForeground(new Color(255, 69, 0));
		welcomeTextLabel.setFont(new Font("Sitka Small", Font.BOLD, 25));
		welcomeTextLabel.setBounds(397, 43, 393, 57);
		panel.add(welcomeTextLabel);
		
		MyBar = new JProgressBar();
		MyBar.setForeground(new Color(255, 69, 0));
		MyBar.setBackground(Color.WHITE);
		MyBar.setBounds(0, 620, 882, 33);
		contentPane.add(MyBar);
		this.setLocationRelativeTo(null);    // it always makes sure the window is in the middle

	}
}

