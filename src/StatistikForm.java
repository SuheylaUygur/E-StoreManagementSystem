
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatistikForm extends JFrame {

	private JPanel contentPane;
	static int VeryGood = 0;       // There are degrees of satisfaction in this class.
	static int Good = 0;
	static int Middle = 0;
	static int notBad = 0;
	static int tooBad = 0;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatistikForm frame = new StatistikForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StatistikForm() {
		setTitle("Statistiks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);    // it always makes sure the window is in the middle
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 882, 653);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel TooBadLabel = new JLabel("( 1 = Too bad) ");
		TooBadLabel.setForeground(Color.BLUE);
		TooBadLabel.setFont(new Font("Arial", Font.BOLD, 20));
		TooBadLabel.setBounds(47, 515, 171, 24);
		panel.add(TooBadLabel);
		
		JLabel NotBadLabel = new JLabel("( 2 = Not bad)");
		NotBadLabel.setForeground(Color.BLUE);
		NotBadLabel.setFont(new Font("Arial", Font.BOLD, 20));
		NotBadLabel.setBounds(47, 397, 171, 24);
		panel.add(NotBadLabel);
		
		JLabel MiddleLabel = new JLabel("(3 = Middle)");
		MiddleLabel.setForeground(Color.BLUE);
		MiddleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		MiddleLabel.setBounds(47, 279, 171, 24);
		panel.add(MiddleLabel);
		
		JLabel GoodLabel = new JLabel("(4 = Good)");
		GoodLabel.setForeground(Color.BLUE);
		GoodLabel.setFont(new Font("Arial", Font.BOLD, 20));
		GoodLabel.setBounds(47, 173, 171, 24);
		panel.add(GoodLabel);
		
		JLabel VeryGoodLabel = new JLabel("(5 = Very good)");
		VeryGoodLabel.setForeground(Color.BLUE);
		VeryGoodLabel.setFont(new Font("Arial", Font.BOLD, 20));
		VeryGoodLabel.setBounds(46, 57, 172, 24);
		panel.add(VeryGoodLabel);
		
		JProgressBar VeryGoodprogressBar = new JProgressBar();
		VeryGoodprogressBar.setForeground(Color.BLUE);
		VeryGoodprogressBar.setBounds(47, 94, 764, 31);
		panel.add(VeryGoodprogressBar);
		
		JProgressBar GoodprogressBar = new JProgressBar();
		GoodprogressBar.setForeground(Color.BLUE);
		GoodprogressBar.setBounds(47, 214, 764, 31);
		panel.add(GoodprogressBar);
		
		JProgressBar MiddleprogressBar = new JProgressBar();
		MiddleprogressBar.setForeground(Color.BLUE);
		MiddleprogressBar.setBounds(47, 331, 764, 31);
		panel.add(MiddleprogressBar);
		
		JProgressBar NotBadprogressBar = new JProgressBar();
		NotBadprogressBar.setForeground(Color.BLUE);
		NotBadprogressBar.setBounds(47, 452, 764, 31);
		panel.add(NotBadprogressBar);
		
		JProgressBar TooBadprogressBar = new JProgressBar();
		TooBadprogressBar.setForeground(Color.BLUE);
		TooBadprogressBar.setBounds(47, 568, 764, 31);
		panel.add(TooBadprogressBar);
		
		JButton btnNewButton = new JButton("SHOW STATISTICS");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(123, 104, 238));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				try {
					read_statistics();
				} catch (IOException e) {
					e.printStackTrace();
				}
				VeryGoodprogressBar.setValue(VeryGood); // 5 
				GoodprogressBar.setValue(Good);         // 4
				MiddleprogressBar.setValue(Middle);     // 3
				NotBadprogressBar.setValue(notBad);     // 2
				TooBadprogressBar.setValue(tooBad);     // 1
			}
		});
		btnNewButton.setBounds(47, 13, 248, 31);
		panel.add(btnNewButton);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				new AdminPageForm().setVisible(true);
				setVisible(false);
			}
		});
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setFont(new Font("Sitka Small", Font.BOLD, 20));
		btnGoBack.setBackground(new Color(123, 104, 238));
		btnGoBack.setBounds(564, 16, 248, 31);
		panel.add(btnGoBack);
	}
	public void read_statistics() throws IOException {// Statistics are read from the file and a graphical view is given with the JProggressBar component.
		String address = "survey_results.txt";
		
	    File file = new File(address);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        int count = 0;
        int[]statistics=new int[1000];
	
         while (line!=null) 
         {
           statistics[count] = Integer.valueOf(line);
           line = reader.readLine();
           count++;
         }
        reader.close();
        for (int i = 0; i < statistics.length; i++) {
			if(statistics[i]==5) 
			{
				VeryGood++;
			}
			else if(statistics[i]==4) 
			{
				Good++;
			}
			else if(statistics[i]==3) 
			{
				Middle++;		
			}
			else if(statistics[i]==2) 
			{
				notBad++;
			}
			else if(statistics[i]==1) 
			{
				tooBad++;
			}
		}
	}
}
