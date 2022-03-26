
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class ShoppingForm extends JFrame  // This class is the interface that contains the shopping page.
{
	private JPanel contentPane;
	JTable jApparel;                   // There are five product categories.
	JTable jToys;                     // There are tables for product categories.
	JTable jElectronic;
	JTable jCosmetic;
	JTable jSupermarket;
	JTable tabl;
	int index = 0;
	JTable liste;
	Stack<Integer> survey_results = new Stack<Integer>();
	
	DefaultListModel<String> l1 = new DefaultListModel<>();
    JLabel cartLabel = new JLabel("");
    ListSelectionModel model ; // These are the elements that indicate where the tables in different categories will be processed when they are active.
    ListSelectionModel model1;
    ListSelectionModel model2 ;
    ListSelectionModel model3;
    ListSelectionModel model4 ;
    ListSelectionModel model5;
    
    static ShoppingCart card ;      // it is shopping cart.
    static int total_product = 0 ;     // It is the variable that will hold the total number of products purchased by the customer.

	static ProductStorage productStorage;  // products in our warehouse have been stored

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ShoppingForm frame = new ShoppingForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ShoppingForm() throws FileNotFoundException 
	{
		productStorage  = new ProductStorage();  // object of products
		productStorage.readProductList();
		
		
		card  = new ShoppingCart();
		setTitle("Deu Ceng Store\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 146, 678, 110);
		panel.setBackground(new Color(204, 51, 102));
		contentPane.add(panel);
		panel.setLayout(null);
		this.setLocationRelativeTo(null); // it always makes sure the window is in the middle.
		
		JLabel lblNewLabel = new JLabel("Choose by category -->");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblNewLabel.setBounds(69, 47, 195, 22);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 678, 147);
		panel_1.setBackground(new Color(255, 99, 71));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JButton profileButton_1 = new JButton("Profile");
		profileButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "The items in your cart will be deleted.","Information",JOptionPane.INFORMATION_MESSAGE);
					new CustomerProfileForm().setVisible(true);
					setVisible(false);
				} catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(null, "A problem occur","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		profileButton_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		profileButton_1.setBackground(Color.YELLOW);
		profileButton_1.setBounds(12, 33, 127, 31);
		panel_1.add(profileButton_1);
		
		JButton wishBoxButton_1 = new JButton("Wish Box");
		wishBoxButton_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				try {
					String messageToAdmin = JOptionPane.showInputDialog("Write your message"); 
					if(messageToAdmin.equals("")) {
						JOptionPane.showMessageDialog(null, "There is no message to send Please write your message.","Error",JOptionPane.OK_OPTION);
					}
					else {
						JOptionPane.showMessageDialog(null, "Your message has been sent.","Result",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Cancel?","Error",JOptionPane.OK_OPTION);
				}
			}
		});
		wishBoxButton_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		wishBoxButton_1.setBackground(Color.YELLOW);
		wishBoxButton_1.setBounds(182, 33, 133, 31);
		panel_1.add(wishBoxButton_1);
		
		
		JButton anketButton = new JButton("Survey");
		anketButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try {
					String answer = JOptionPane.showInputDialog(null, "How satisfied were you with our shopping store? "
							+ "( 1 = Too bad) ( 2 = Not bad) (3 = Middle) (4 = Good) (5 = Very good) ! ",JOptionPane.QUESTION_MESSAGE);
					
					int answer_integer = Integer.parseInt(answer);
					if(answer_integer!=1 && answer_integer!=2 && answer_integer!=3 && answer_integer!=4 && answer_integer!=5 ) 
					{
						JOptionPane.showMessageDialog(null, "You must enter a value in the range of 1-5  ! ","Error",JOptionPane.WARNING_MESSAGE); 
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Your response has been recorded! ","Error",JOptionPane.INFORMATION_MESSAGE); 
						survey_results.add(Integer.valueOf(answer));
						add_in_file(survey_results);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Cansel  ! ","Error",JOptionPane.ERROR_MESSAGE); 
				}
			}

			private void add_in_file(Stack<Integer> survey_results) throws IOException 
			{
				File fil = new File("survey_results.txt");    
			    if (!fil.exists()) {
			        fil.createNewFile();
			    }

			    FileWriter filWriter = new FileWriter(fil, true);
			    BufferedWriter biWriter = new BufferedWriter(filWriter);
			    for (int i = 0; i < survey_results.size(); i++) 
			    {
			    	   biWriter.write(survey_results.peek()+"\n");
			    	   survey_results.pop();
				}
			    biWriter.close();
				
			}
		});
		anketButton.setFont(new Font("Sitka Small", Font.BOLD, 13));
		anketButton.setBackground(Color.YELLOW);
		anketButton.setBounds(539, 35, 127, 31);
		panel_1.add(anketButton);
		
		JButton wishBoxButton_1_1 = new JButton("Go Login");
		wishBoxButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				new LoginForm().setVisible(true);
				setVisible(false);
			}
		});
		wishBoxButton_1_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		wishBoxButton_1_1.setBackground(Color.YELLOW);
		wishBoxButton_1_1.setBounds(363, 33, 133, 31);
		panel_1.add(wishBoxButton_1_1);
	
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 255, 678, 398);
		panel_2.setBackground(new Color(255, 99, 71));
		contentPane.add(panel_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.YELLOW);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Apparel", "Toys", "Electronic", "Cosmetic", "Supermarket"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(305, 47, 297, 22);
		panel.add(comboBox);
		
		JLabel Ctext = new JLabel("Category");
		Ctext.setForeground(new Color(248,103,48));
		Ctext.setFont(new Font("Sitka Small", Font.BOLD, 13));
		Ctext.setBounds(0, 94, 111, 16);
		panel.add(Ctext);
		
		JLabel BText = new JLabel("Brand");
		BText.setForeground(new Color(248,103,48));
		BText.setFont(new Font("Sitka Small", Font.BOLD, 13));
		BText.setBounds(112, 93, 111, 16);
		panel.add(BText);
		
		JLabel NText = new JLabel("Name");
		NText.setForeground(new Color(248,103,48));
		NText.setFont(new Font("Sitka Small", Font.BOLD, 13));
		NText.setBounds(226, 93, 111, 16);
		panel.add(NText);
		
		JLabel SText = new JLabel("Serial Number");
		SText.setForeground(new Color(248,103,48));
		SText.setFont(new Font("Sitka Small", Font.BOLD, 13));
		SText.setBounds(315, 94, 111, 16);
		panel.add(SText);
		
		JLabel Stext = new JLabel("Stock");
		Stext.setForeground(new Color(248,103,48));
		Stext.setFont(new Font("Sitka Small", Font.BOLD, 13));
		Stext.setBounds(452, 93, 111, 16);
		panel.add(Stext);
		
		JLabel PText = new JLabel("Price ");
		PText.setForeground(new Color(248,103,48));
		PText.setFont(new Font("Sitka Small", Font.BOLD, 13));
		PText.setBounds(567, 93, 111, 16);
		panel.add(PText);
		
		String[] columnNames = { "Category", "Brand", "Name", "Serial Number" , "Stock" , "Price"};
		
		Object[][]data = new Object[productStorage.apparel_count][6]; // A data array is formed for the table.
		int apparel0_row_count = 0;
		int apparel0_index = 0;
		while(productStorage.products.size() > apparel0_row_count ) // The data array is populated and the table is created.
		{
			if(productStorage.products.get(apparel0_row_count).getCategory().equalsIgnoreCase("Apparel"))
			{
				data[apparel0_index][0] = productStorage.products.get(apparel0_row_count).getCategory();
				data[apparel0_index][1] = productStorage.products.get(apparel0_row_count).getBrand();
				data[apparel0_index][2] = productStorage.products.get(apparel0_row_count).getName();
				data[apparel0_index][3] = productStorage.products.get(apparel0_row_count).getSerialNumber();
				data[apparel0_index][4] = productStorage.products.get(apparel0_row_count).getStock();
				data[apparel0_index][5] = productStorage.products.get(apparel0_row_count).getPrice()-10;
				
				apparel0_index++;
			}
			apparel0_row_count++;
		}
        // Column Names
        
        // Initializing the JTable
        jApparel = new JTable(data, columnNames);  // table created
        jApparel.setBounds(0, 0, 678, 160);
        jApparel.setFont(new Font("Sitka Small", Font.BOLD, 10));
        jApparel.setRowMargin(3);
        jApparel.setAlignmentY(Component.TOP_ALIGNMENT);
        jApparel.setMinimumSize(new Dimension(800, 800));
        jApparel.setBackground(new Color(255, 99, 71));
  
        jApparel.setVisible(true);
        panel_2.setLayout(null);
        panel_2.add(jApparel);
        
        JPanel cartPanel = new JPanel();
        cartPanel.setBounds(677, 0, 305, 147);
        cartPanel.setBackground(Color.YELLOW);
        contentPane.add(cartPanel);
        cartPanel.setLayout(null);
        
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(comboBox.getSelectedItem().equals("Apparel")) {
					if(jApparel !=null && jApparel.isVisible()==true) {
						jApparel.setVisible(false);
						
						panel_2.remove(jApparel);
					}
					if(jToys !=null && jToys.isVisible()==true) {
						jToys.setVisible(false);
						
						panel_2.remove(jToys);
					}
					if(jCosmetic!=null && jCosmetic.isVisible()==true) {
						jCosmetic.setVisible(false);
						
						panel_2.remove(jCosmetic);
					}
					if(jElectronic != null && jElectronic.isVisible()==true) {
						jElectronic.setVisible(false);
						
						panel_2.remove(jElectronic);
					}
					if(jSupermarket != null && jSupermarket.isVisible()==true) {
						jSupermarket.setVisible(false);
						
						panel_2.remove(jSupermarket);
					}
					
					Object[][]data = new Object[productStorage.apparel_count][6];
					int apparel_row_count = 0;
					int apparel_index = 0;
					while(productStorage.products.size() > apparel_row_count ) 
					{
						if(productStorage.products.get(apparel_row_count).getCategory().equalsIgnoreCase("Apparel"))
						{
							data[apparel_index][0] = productStorage.products.get(apparel_row_count).getCategory();
							data[apparel_index][1] = productStorage.products.get(apparel_row_count).getBrand();
							data[apparel_index][2] = productStorage.products.get(apparel_row_count).getName();
							data[apparel_index][3] = productStorage.products.get(apparel_row_count).getSerialNumber();
							data[apparel_index][4] = productStorage.products.get(apparel_row_count).getStock();
							data[apparel_index][5] = productStorage.products.get(apparel_row_count).getPrice()-10;
							
							apparel_index++;
						}
						apparel_row_count++;
					}
			  
			        // Initializing the JTable
			        jApparel= new JTable(data, columnNames);
			        jApparel.setMinimumSize(new Dimension(800, 800));
			        jApparel.setBounds(new Rectangle(0, 0, 100, 100));
			        jApparel.setBounds(40, 50, 678, 348);
			        jApparel.setLocation(0, 0);
			        jApparel.setBackground(new Color(255, 99, 71));
			        jApparel.setFont(new Font("Sitka Small", Font.BOLD, 10));
			     
			        if(jApparel.isVisible()==false) 
			        {
			        	jApparel.setVisible(true);
			        }
			        
			        panel_2.add(jApparel);
			        model5 = jApparel.getSelectionModel();
			        model5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			        model5.addListSelectionListener(new ListSelectionListener() 
			        {
			        	int stok = 0;
			         	public void valueChanged(ListSelectionEvent e) 
			         	{  // this is active when something is selected from the table.
			         	         
			         		try {
			         			int rowIndex = jApparel.getSelectedRow();
				         		Object categoryO = jApparel.getValueAt(rowIndex, 0);        // 0 category
				         		Object brandO = jApparel.getValueAt(rowIndex, 1);           // 1 brand 
				         		Object choosedElementO = jApparel.getValueAt(rowIndex, 2);  // 2 product name
				         		int serialO = (int) jApparel.getValueAt(rowIndex, 3);       // 3 serial number
				         		int stockO = (int) jApparel.getValueAt(rowIndex, 4);        // 4 stock 
				         		float priceO = (float) jApparel.getValueAt(rowIndex, 5);    // 5 price
				         		
				       
								String number = JOptionPane.showInputDialog("How many "+String.valueOf(choosedElementO)+" would you like?"); 
								
								try {
									stok = Integer.parseInt(number); // the number of products requested by the user
									
									if(stok<=0) 
									{
										JOptionPane.showMessageDialog(null, "You must enter a positive number  ! ","Error",
												JOptionPane.WARNING_MESSAGE); 
									}
									else {
										
										if(stok > stockO) {
											JOptionPane.showMessageDialog(null, "Insufficient stock","Error",JOptionPane.OK_OPTION);
										}
										else {
											int newStock = (stockO- stok) ;
											String newStk = String.valueOf(newStock);
											jApparel.setValueAt(newStk, rowIndex, 4);  // updates stock count.
											int price = (int) priceO;
											int total = price * stok;  // total price
											JOptionPane.showMessageDialog(null,  total + " TL - "+ String.valueOf(choosedElementO) +
													" has been added to your cart");
											
									         l1.addElement(String.valueOf(choosedElementO));  
											 JList<String> list = new JList<>(l1);  
											 cartLabel.add(list);
											 card.addProductToShoppingCart(String.valueOf(choosedElementO),productStorage.products,stok,total);
											 total_product = total_product + 1; // number of products added to cart
											 
									         list.setBounds(100,0,75,500); 
									         list.setVisible(true);
									         
									         list.addMouseListener(new MouseAdapter() {
										         	@Override
										         	public void mouseClicked(MouseEvent arg0) {
										         		try {
										         			
										         			String eleman = list.getSelectedValue();
											         		JOptionPane.showMessageDialog(null, eleman +", do you want to delete it ! ",
											         				"Warning",JOptionPane.WARNING_MESSAGE);
												         		
												         total_product = total_product - 1;
												         l1.removeElement(String.valueOf(eleman));
												        
														 
															
														} catch (Exception e2) {
															JOptionPane.showMessageDialog(null,"Cansel ! ",
											         				"Warning",JOptionPane.INFORMATION_MESSAGE);
														}
										         		
										         		
										         	}
										         });
										}	
									}
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Enter quantity ! ","Error",JOptionPane.WARNING_MESSAGE); 	
								}
								
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Error please try again ! ","Error",JOptionPane.ERROR_MESSAGE);
							}
			         	 }
			         	});
			        
				}
				if(comboBox.getSelectedItem().equals("Toys")) {
					if(jToys !=null && jToys.isVisible()==true) {
						jToys.setVisible(false);
						
						panel_2.remove(jToys);
					}
					if(jApparel != null && jApparel.isVisible()==true) {
						jApparel.setVisible(false);
						panel_2.remove(jApparel);
					}
					if(jCosmetic!=null && jCosmetic.isVisible()==true ) {
						jCosmetic.setVisible(false);
						
						panel_2.remove(jCosmetic);
					}
					if(jElectronic != null && jElectronic.isVisible()==true  ) {
						jElectronic.setVisible(false);
						
						panel_2.remove(jElectronic);
					}
					if(jSupermarket != null && jSupermarket.isVisible()==true) {
						jSupermarket.setVisible(false);
					
						panel_2.remove(jSupermarket);
					}
					
					Object[][]data = new Object[productStorage.toys_count][6];
					int toys_row_count = 0;
					int toys_index = 0;
					while(productStorage.products.size() > toys_row_count ) 
					{
						if(productStorage.products.get(toys_row_count).getCategory().equalsIgnoreCase("Toys"))
						{
							data[toys_index][0] = productStorage.products.get(toys_row_count).getCategory();
							data[toys_index][1] = productStorage.products.get(toys_row_count).getBrand();
							data[toys_index][2] = productStorage.products.get(toys_row_count).getName();
							data[toys_index][3] = productStorage.products.get(toys_row_count).getSerialNumber();
							data[toys_index][4] = productStorage.products.get(toys_row_count).getStock();
							data[toys_index][5] = productStorage.products.get(toys_row_count).getPrice()-10;
							
							toys_index++;
						}
						toys_row_count++;
					}
			  
			        // Initializing the JTable
			        jToys = new JTable(data, columnNames);
			        jToys.setMinimumSize(new Dimension(800, 800));
			        jToys.setBounds(new Rectangle(0, 0, 100, 100));
			        jToys.setBounds(40, 50,678, 348);
			        jToys.setLocation(0, 0);
			        jToys.setBackground(new Color(255, 99, 71));
			        jToys.setFont(new Font("Sitka Small", Font.BOLD, 10));
			       
			        if(jToys.isVisible()==false) 
			        {
			        	jToys.setVisible(true);
			        }
			        
			        panel_2.add(jToys);
			        
			        model1 = jToys.getSelectionModel();
			        model1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			        model1.addListSelectionListener(new ListSelectionListener() {
			         	public void valueChanged(ListSelectionEvent e) 
			         	{  // this is active when something is selected from the table.
			         		
			         		try {
			         			
			         			int rowIndex = jToys.getSelectedRow();
				         		String categoryO = (String) jToys.getValueAt(rowIndex, 0);          // 0 category 
				         		String brandO = (String) jToys.getValueAt(rowIndex, 1);             // 1 brand 
				         		String choosedElementO = (String) jToys.getValueAt(rowIndex, 2);    // 2 product name
				         		int serialO = (int) jToys.getValueAt(rowIndex, 3);                  // 3 serial number 
				         		int stockO = (int) jToys.getValueAt(rowIndex, 4);                   // 4 stock
				         		float priceO = (float) jToys.getValueAt(rowIndex, 5);               // 5 price
				         		
				       
								String number = JOptionPane.showInputDialog("How many "+String.valueOf(choosedElementO)+" would you like?"); 
								int stok = 0;
								try {
									stok = Integer.parseInt(number); // the number of products requested by the user
									
									if(stok<=0) {
										JOptionPane.showMessageDialog(null, "You must enter a positive number  ! ","Error",
												JOptionPane.WARNING_MESSAGE); 
									}
									else {
										
										if(stok>stockO) {
											JOptionPane.showMessageDialog(null, "Insufficient stock","Error",JOptionPane.OK_OPTION);
										}
										else {
											int newStock = stockO- stok ;
											String newStk = String.valueOf(newStock);
											jToys.setValueAt(newStk, rowIndex, 4);  // updates the stock count
											int price = (int) priceO;
											int total = price * stok;  // toplam fiyat
											JOptionPane.showMessageDialog(null,  total + " TL - "+ String.valueOf(choosedElementO) +
													" has been added to your cart");
											l1.addElement(choosedElementO);
											JList<String> list = new JList<>(l1);  
											cartLabel.add(list);
											card.addProductToShoppingCart(String.valueOf(choosedElementO),productStorage.products,stok,total);
											total_product = total_product + 1; // number of products added to cart
									        list.setBounds(100,0,75,500); 
									        list.setVisible(true);
									        
									        list.addMouseListener(new MouseAdapter() {
									         	@Override
									         	public void mouseClicked(MouseEvent arg0) 
									         	{
									         		try {
									         			
									         			String eleman = list.getSelectedValue();
										         		JOptionPane.showMessageDialog(null, eleman +", do you want to delete it ! ",
										         				"Warning",JOptionPane.WARNING_MESSAGE);
											         		
											         total_product = total_product - 1;
											         l1.removeElement(String.valueOf(eleman));
													 
														
													} catch (Exception e2) {
														JOptionPane.showMessageDialog(null,"Cansel ! ",
										         				"Warning",JOptionPane.INFORMATION_MESSAGE);
													}
									         	}
									         });
										}	
									}
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Enter quantity ! ","Error",JOptionPane.WARNING_MESSAGE); 	
								}
							} catch (Exception e2) 
			         		{
								JOptionPane.showMessageDialog(null, "Error please try again ! ","Error",JOptionPane.ERROR_MESSAGE);
							}
			         	 }
			         	});
				}
				if(comboBox.getSelectedItem().equals("Electronic")) {
					if(jElectronic != null && jElectronic.isVisible()==true) {
						jElectronic.setVisible(false);
						 
						panel_2.remove(jElectronic);
					}
					if(jApparel != null && jApparel.isVisible()==true) {
						jApparel.setVisible(false);
					
						panel_2.remove(jApparel);
					}
					if(jCosmetic!=null && jCosmetic.isVisible()==true) {
						jCosmetic.setVisible(false);
						
						panel_2.remove(jCosmetic);
					}
					if(jToys !=null && jToys.isVisible()==true) {
						jToys.setVisible(false);
					
						panel_2.remove(jToys);
					}
					if(jSupermarket != null && jSupermarket.isVisible()==true) {
						jSupermarket.setVisible(false);
						
						panel_2.remove(jSupermarket);
					}
					
					// Data to be displayed in the JTable
					Object[][]data = new Object[productStorage.electronics_count][6];
					int electronic_row_count = 0;
					int electronic_index = 0;
					while(productStorage.products.size() > electronic_row_count ) 
					{
						if(productStorage.products.get(electronic_row_count).getCategory().equalsIgnoreCase("Electronic"))
						{
							data[electronic_index][0] = productStorage.products.get(electronic_row_count).getCategory();
							data[electronic_index][1] = productStorage.products.get(electronic_row_count).getBrand();
							data[electronic_index][2] = productStorage.products.get(electronic_row_count).getName();
							data[electronic_index][3] = productStorage.products.get(electronic_row_count).getSerialNumber();
							data[electronic_index][4] = productStorage.products.get(electronic_row_count).getStock();
							data[electronic_index][5] = productStorage.products.get(electronic_row_count).getPrice()-10;
							
							electronic_index++;
						}
						electronic_row_count++;
					}
			  
			        // Initializing the JTable
			       jElectronic = new JTable(data, columnNames);
			       jElectronic.setMinimumSize(new Dimension(800, 800));
			        jElectronic.setBounds(new Rectangle(0, 0, 100, 100));
			        jElectronic.setBounds(40, 50, 678, 348);
			        jElectronic.setLocation(0, 0);
			        jElectronic.setBackground(new Color(255, 99, 71));
			        jElectronic.setFont(new Font("Sitka Small", Font.BOLD, 10));
			        
			        if(jElectronic.isVisible()==false) {
			        	jElectronic.setVisible(true);
			        }
			        
			        panel_2.add(jElectronic);
			        model2 = jElectronic.getSelectionModel();
			        model2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			        model2.addListSelectionListener(new ListSelectionListener() {
			         	public void valueChanged(ListSelectionEvent e) 
			         	{  // this is active when something is selected from the table.
			     
			         		try {
			         			int rowIndex = jElectronic.getSelectedRow();
				         		Object categoryO = jElectronic.getValueAt(rowIndex, 0);          // 0 category 
				         		Object brandO = jElectronic.getValueAt(rowIndex, 1);             // 1 brand 
				         		Object choosedElementO = jElectronic.getValueAt(rowIndex, 2);    // 2 product name
				         		int serialO = (int) jElectronic.getValueAt(rowIndex, 3);         // 3 serial number 
				         		int stockO = (int) jElectronic.getValueAt(rowIndex, 4);          // 4 stock
				         		float priceO = (float) jElectronic.getValueAt(rowIndex, 5);      // 5 price
				         		
				       
								String number = JOptionPane.showInputDialog("How many "+String.valueOf(choosedElementO)+" would you like?"); 
								int stok = 0;
								try {
									stok = Integer.parseInt(number); // the number of products requested by the user
									
									if(stok<=0) {
										JOptionPane.showMessageDialog(null, "You must enter a positive number  ! ","Error",
												JOptionPane.WARNING_MESSAGE); 
									}
									else {
										
										if(stok>stockO) {
											JOptionPane.showMessageDialog(null, "Insufficient stock","Error",JOptionPane.OK_OPTION);
										}
										else {
											int newStock = stockO- stok ;
											String newStk = String.valueOf(newStock);
											jElectronic.setValueAt(newStk, rowIndex, 4);  // updates the stock count
											int price = (int) priceO;
											int total = price * stok;  // total price
											JOptionPane.showMessageDialog(null,  total + " TL - "+ String.valueOf(choosedElementO) +
													" has been added to your cart");
											
											// ürünü sepete ekleyin !!!
											
											
											 l1.addElement(String.valueOf(choosedElementO));
											 JList<String> list = new JList<>(l1); 
											 cartLabel.add(list);
											 card.addProductToShoppingCart(String.valueOf(choosedElementO),productStorage.products,stok,total);
											 total_product = total_product + 1; // number of products added to cart
											
									         list.setBounds(100,0,75,500); 
									         list.setVisible(true);
									         
									         list.addMouseListener(new MouseAdapter() {
										         	@Override
										         	public void mouseClicked(MouseEvent arg0) {
										         		
										         			try {
										         			
										         			String eleman = list.getSelectedValue();
											         		JOptionPane.showMessageDialog(null, eleman +", do you want to delete it ! ",
											         				"Warning",JOptionPane.WARNING_MESSAGE);
												         		
												         total_product = total_product - 1;
												         l1.removeElement(String.valueOf(eleman));
														 
															
														} catch (Exception e2) {
															JOptionPane.showMessageDialog(null,"Cansel ! ",
											         				"Warning",JOptionPane.INFORMATION_MESSAGE);
														}
										         	}
										         });
										}	
									}
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Enter quantity ! ","Error",JOptionPane.WARNING_MESSAGE); 	
								}
								
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Error please try again ! ","Error",JOptionPane.ERROR_MESSAGE); 
							}
			         		
			         	 }
			         	});
			     
				}
				if(comboBox.getSelectedItem().equals("Cosmetic")) 
				{
					if(jCosmetic!=null && jCosmetic.isVisible()==true ) {
						jCosmetic.setVisible(false);
						
						panel_2.remove(jCosmetic);
					}
					if(jApparel != null && jApparel.isVisible()==true) {
						jApparel.setVisible(false);
					 
						panel_2.remove(jApparel);
					}
					if(jToys !=null && jToys.isVisible()==true) {
						jToys.setVisible(false);
					
						panel_2.remove(jToys);
					}
					if(jElectronic != null && jElectronic.isVisible()==true) {
						jElectronic.setVisible(false);
						 
						panel_2.remove(jElectronic);
					}
					if(jSupermarket != null && jSupermarket.isVisible()==true) {
						jSupermarket.setVisible(false);
						
						panel_2.remove(jSupermarket);
					}
					
					
					// Data to be displayed in the JTable

					Object[][]data = new Object[productStorage.cosmetics_count][6];
					int cosmetic_row_count = 0;
					int cosmetic_index = 0;
					while(productStorage.products.size() > cosmetic_row_count ) 
					{
						if(productStorage.products.get(cosmetic_row_count).getCategory().equalsIgnoreCase("Cosmetic"))
						{
							data[cosmetic_index][0] = productStorage.products.get(cosmetic_row_count).getCategory();
							data[cosmetic_index][1] = productStorage.products.get(cosmetic_row_count).getBrand();
							data[cosmetic_index][2] = productStorage.products.get(cosmetic_row_count).getName();
							data[cosmetic_index][3] = productStorage.products.get(cosmetic_row_count).getSerialNumber();
							data[cosmetic_index][4] = productStorage.products.get(cosmetic_row_count).getStock();
							data[cosmetic_index][5] = productStorage.products.get(cosmetic_row_count).getPrice()-10;
							
							cosmetic_index++;
							
						}
						cosmetic_row_count++;
					}
			  
			
			  
			        // Initializing the JTable
			       jCosmetic = new JTable(data, columnNames);
			       jCosmetic.setMinimumSize(new Dimension(800, 800));
			       jCosmetic.setBounds(new Rectangle(0, 0, 100, 100));
			       jCosmetic.setBounds(40, 50, 678, 348);
			       jCosmetic.setLocation(0, 0);
			       jCosmetic.setBackground(new Color(255, 99, 71));
			       jCosmetic.setFont(new Font("Sitka Small", Font.BOLD, 10));
			       if(jCosmetic.isVisible()==false) {
			    	   jCosmetic.setVisible(true);
			       }
			       
			        panel_2.add(jCosmetic);
			        model3 = jCosmetic.getSelectionModel();
			        model3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			        model3.addListSelectionListener(new ListSelectionListener() {
			         	public void valueChanged(ListSelectionEvent e) 
			         	{  // this is active when something is selected from the table.
			         		
			         		try {
			         			int rowIndex = jCosmetic.getSelectedRow();
				         		Object categoryO = jCosmetic.getValueAt(rowIndex, 0);        // 0 category 
				         		Object brandO = jCosmetic.getValueAt(rowIndex, 1);           // 1 brand 
				         		Object choosedElementO = jCosmetic.getValueAt(rowIndex, 2);  // 2 product name
				         		int serialO = (int) jCosmetic.getValueAt(rowIndex, 3);       // 3 serial number 
				         		int stockO = (int) jCosmetic.getValueAt(rowIndex, 4);        // 4 stock
				         		float priceO = (float) jCosmetic.getValueAt(rowIndex, 5);    // 5 price
				         		
				       
								String number = JOptionPane.showInputDialog("How many "+String.valueOf(choosedElementO)+" would you like?"); 
								int stok = 0;
								try {
									stok = Integer.parseInt(number); // the number of products requested by the user
									
									if(stok<=0) {
										JOptionPane.showMessageDialog(null, "You must enter a positive number  ! ","Error",
												JOptionPane.WARNING_MESSAGE); 
									}
									else {
										
										if(stok>stockO) {
											JOptionPane.showMessageDialog(null, "Insufficient stock","Error",JOptionPane.OK_OPTION);
										}
										else {
											int newStock = stockO- stok ;
											String newStk = String.valueOf(newStock);
											jCosmetic.setValueAt(newStk, rowIndex, 4);  // updates the stock count
											int price = (int) priceO;
											int total = price * stok;  // total price
											JOptionPane.showMessageDialog(null,  total + " TL - "+ String.valueOf(choosedElementO) +
													" has been added to your cart");
											
											 l1.addElement(String.valueOf(choosedElementO));
											 JList<String> list = new JList<>(l1);  
											 cartLabel.add(list);
											 card.addProductToShoppingCart(String.valueOf(choosedElementO),productStorage.products,stok,total);
											 total_product = total_product + 1; // number of products added to cart
									         list.setBounds(100,0,75,500); 
									         list.setVisible(true);
									         
									         list.addMouseListener(new MouseAdapter() {
										         	@Override
										         	public void mouseClicked(MouseEvent arg0) {
										         		try {
										         			
										         			String eleman = list.getSelectedValue();
											         		JOptionPane.showMessageDialog(null, eleman +", do you want to delete it ! ",
											         				"Warning",JOptionPane.WARNING_MESSAGE);
												         		
												         total_product = total_product - 1;
												         l1.removeElement(String.valueOf(eleman));
														 
															
														} catch (Exception e2) {
															JOptionPane.showMessageDialog(null,"Cansel ! ",
											         				"Warning",JOptionPane.INFORMATION_MESSAGE);
														}
										         	}
										         });
										}	
									}
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Enter quantity ! ","Error",JOptionPane.WARNING_MESSAGE); 	
								}
								
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Error please try again ! ","Error",JOptionPane.ERROR_MESSAGE);
							}
			         		
			         	 }
			         	});
			 
				}
				if(comboBox.getSelectedItem().equals("Supermarket"))
				{
					if(jSupermarket != null && jSupermarket.isVisible()==true) {
						jSupermarket.setVisible(false);
						
						panel_2.remove(jSupermarket);
					}
					if(jApparel != null && jApparel.isVisible()==true) {
						jApparel.setVisible(false);
						
						panel_2.remove(jApparel);
					}
					if(jCosmetic!=null && jCosmetic.isVisible()==true) {
						jCosmetic.setVisible(false);
						
						panel_2.remove(jCosmetic);
					}
					if(jElectronic != null && jElectronic.isVisible()==true) {
						jElectronic.setVisible(false);
						
						panel_2.remove(jElectronic);
					}
					if(jToys !=null && jToys.isVisible()==true) {
						jToys.setVisible(false);
						
						panel_2.remove(jToys);
					}
					
					// Data to be displayed in the JTable

					Object[][]data = new Object[productStorage.supermarket_count][6];
					int supermarket_row_count = 0;
					int supermarket_index = 0;
					while(productStorage.products.size() > supermarket_row_count ) 
					{
						if(productStorage.products.get(supermarket_row_count).getCategory().equalsIgnoreCase("Supermarket"))
						{
							data[supermarket_index][0] = productStorage.products.get(supermarket_row_count).getCategory();
							data[supermarket_index][1] = productStorage.products.get(supermarket_row_count).getBrand();
							data[supermarket_index][2] = productStorage.products.get(supermarket_row_count).getName();
							data[supermarket_index][3] = productStorage.products.get(supermarket_row_count).getSerialNumber();
							data[supermarket_index][4] = productStorage.products.get(supermarket_row_count).getStock();
							data[supermarket_index][5] = productStorage.products.get(supermarket_row_count).getPrice()-10;
							
							supermarket_index++;	
						}
						supermarket_row_count++;
					}
			  
			        // Initializing the JTable
			        jSupermarket = new JTable(data, columnNames);
			        jSupermarket.setMinimumSize(new Dimension(800, 800));
			        jSupermarket.setBounds(new Rectangle(0, 0, 100, 100));
			        jSupermarket.setBounds(40, 50, 678, 348);
			        jSupermarket.setFont(new Font("Sitka Small", Font.BOLD, 10));
			        jSupermarket.setLocation(0, 0);
			        jSupermarket.setBackground(new Color(255, 99, 71));
			        
			        if(jSupermarket.isVisible()==false) {
			        	jSupermarket.setVisible(true);
			        }
			        
			        panel_2.add(jSupermarket);
			        model4 = jSupermarket.getSelectionModel();
			        model4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			        model4.addListSelectionListener(new ListSelectionListener() {
			         	public void valueChanged(ListSelectionEvent e) 
			         	{  // this is active when something is selected from the table.
			         		
			         		try {
			         			
			         			int rowIndex = jSupermarket.getSelectedRow();
				         		Object categoryO = jSupermarket.getValueAt(rowIndex, 0);                 // 0 category 
				         		Object brandO = jSupermarket.getValueAt(rowIndex, 1);                     // 1 brand 
				         		String choosedElementO = (String) jSupermarket.getValueAt(rowIndex, 2);   // 2 product name
				         		int serialO = (int) jSupermarket.getValueAt(rowIndex, 3);                 // 3 serial number 
				         		int stockO = (int) jSupermarket.getValueAt(rowIndex, 4);                  // 4 stock
				         		float priceO = (float) jSupermarket.getValueAt(rowIndex, 5);              // 5 price
				         		
				       
								String number = JOptionPane.showInputDialog("How many "+String.valueOf(choosedElementO)+" would you like?"); 
								int stok = 0;
								try {
									stok = Integer.parseInt(number); // the number of products requested by the user
									
									if(stok<=0) {
										JOptionPane.showMessageDialog(null, "You must enter a positive number  ! ","Error",
												JOptionPane.WARNING_MESSAGE); 
									}
									else {
										
										if(stok>stockO) {
											JOptionPane.showMessageDialog(null, "Insufficient stock","Error",JOptionPane.OK_OPTION);
										}
										else {
											int newStock = stockO- stok ;
											String newStk = String.valueOf(newStock);
											jSupermarket.setValueAt(newStk, rowIndex, 4);  // updates the stock count
											int price = (int) priceO;
											int total = price * stok;  // total price
											JOptionPane.showMessageDialog(null,  total + " TL - "+ String.valueOf(choosedElementO) +
													" has been added to your cart");
											 l1.addElement(choosedElementO);
											 JList<String> list = new JList<>(l1);  
											 cartLabel.add(list);
											 card.addProductToShoppingCart(String.valueOf(choosedElementO),productStorage.products,stok,total);
											 total_product = total_product + 1; // number of products added to cart
									         list.setBounds(100,0,75,500); 
									         list.setVisible(true);
									     
									         list.addMouseListener(new MouseAdapter()
									         {
									         	@Override
									         	public void mouseClicked(MouseEvent arg0)
									         	{
									         		try {
									         			
									         			String eleman = list.getSelectedValue();
										         		JOptionPane.showMessageDialog(null, eleman +", do you want to delete it ! ",
										         				"Warning",JOptionPane.WARNING_MESSAGE);
											         		
											         total_product = total_product - 1;
											         l1.removeElement(String.valueOf(eleman));
													 
														
													} catch (Exception e2) {
														JOptionPane.showMessageDialog(null,"Cansel ! ",
										         				"Warning",JOptionPane.INFORMATION_MESSAGE);
													}
									         	}
									         });
										}	
									}
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Enter quantity ! ","Error",JOptionPane.WARNING_MESSAGE); 	
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Error please try again ! ","Error",JOptionPane.ERROR_MESSAGE);
							}	
			         	 }
			         	}); 
				}
			}
		});
       
		jApparel.setCellSelectionEnabled(true);  //  The selectable feature of the table is activated.
        ListSelectionModel model = jApparel.getSelectionModel();
        model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model.addListSelectionListener(new ListSelectionListener() {
         	public void valueChanged(ListSelectionEvent e) 
         	{  // this is active when something is selected from the table.
         		
         		try {	
         			int rowIndex = jApparel.getSelectedRow();
             		Object categoryO = jApparel.getValueAt(rowIndex, 0);          // 0 category 
             		Object brandO = jApparel.getValueAt(rowIndex, 1);              // 1 brand 
             		Object choosedElementO = jApparel.getValueAt(rowIndex, 2);    // 2 product name
             		int serialO = (int) jApparel.getValueAt(rowIndex, 3);         // 3 serial number 
             		int stockO = (int) jApparel.getValueAt(rowIndex, 4);          // 4 stock 
             		// stokta bazen cast hatasý veriyor !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
             		float priceO = (float) jApparel.getValueAt(rowIndex, 5);      // 5 price
             		
           
    				String number = JOptionPane.showInputDialog("How many "+String.valueOf(choosedElementO)+" would you like?"); 
    				int stok = 0;
    				try {
    					stok = Integer.parseInt(number); // the number of products requested by the user
    					
    					if(stok<=0) {
    						JOptionPane.showMessageDialog(null, "You must enter a positive number  ! ","Error",JOptionPane.WARNING_MESSAGE); 
    					}
    					else {
    						
    						if(stok>stockO) {
    							JOptionPane.showMessageDialog(null, "Insufficient stock","Error",JOptionPane.OK_OPTION);
    						}
    						else {
    							int newStock = stockO- stok ;
    							String newStk = String.valueOf(newStock);
    							jApparel.setValueAt(newStk, rowIndex, 4);  // updates the stock count
    							int price = (int) priceO;
    							int total = price * stok;  // total price
    							JOptionPane.showMessageDialog(null,  total + " TL - "+ String.valueOf(choosedElementO) +" "
    									+ "has been added to your cart");
    							
    							// ürünü sepete ekleyin !!!
    							 l1.addElement(String.valueOf(choosedElementO));
    							 JList<String> list = new JList<>(l1);
    							 cartLabel.add(list);
    							 card.addProductToShoppingCart(String.valueOf(choosedElementO),productStorage.products,stok,total);
								 total_product = total_product + 1; // number of products added to cart
    					         list.setBounds(100,0,75,500); 
    					         list.setVisible(true);
    					         list.addMouseListener(new MouseAdapter() {
    						         	@Override
    						         	public void mouseClicked(MouseEvent arg0) {
    						         		try {
							         			
							         			String eleman = list.getSelectedValue();
								         		JOptionPane.showMessageDialog(null, eleman +", do you want to delete it ! ",
								         				"Warning",JOptionPane.WARNING_MESSAGE);
									         		
									         total_product = total_product - 1;
									         l1.removeElement(String.valueOf(eleman));
											 
												
											} catch (Exception e2) {
												JOptionPane.showMessageDialog(null,"Cansel ! ",
								         				"Warning",JOptionPane.INFORMATION_MESSAGE);
											}
    						         	}
    						         });
    						}	
    					}
    				} catch (Exception e2) {
    					JOptionPane.showMessageDialog(null, "Enter quantity ! ","Error",JOptionPane.WARNING_MESSAGE); 	
    				}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ohh sorry , try again ! ","Error",JOptionPane.WARNING_MESSAGE); 	
				}
         	
         	 }
         	});
        
        JButton StopShopButton = new JButton("finish shopping");
        StopShopButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) 
        	{
        		try {
        			JOptionPane.showMessageDialog(null, "Thanks for shopping, "
        					+ "you are redirected to the payment page !","Message",JOptionPane.INFORMATION_MESSAGE);
        			new PaymentForm().setVisible(true);
				    setVisible(false);
        			
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Cancel ! ","Error",JOptionPane.WARNING_MESSAGE); 	
				}
        	}
        });
        StopShopButton.setBounds(95, 30, 122, 25);
        cartPanel.add(StopShopButton);
        
        JLabel shoppingCartTextLabel = new JLabel(" Shopping Cart");
        shoppingCartTextLabel.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 25));
        shoppingCartTextLabel.setBounds(54, 86, 209, 48);
        cartPanel.add(shoppingCartTextLabel);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(677, 146, 305, 507);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
        
        cartLabel.setBounds(0, 0, 305, 507);
        panel_3.add(cartLabel); 
	}
}
