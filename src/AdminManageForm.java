
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AdminManageForm extends JFrame {  // This class is the interface designed for admin.

	private JPanel contentPane;
	private JTextField brandtextField;
	private JTextField nametextField;
	private JTextField serail_numbertextField;   // Product information is entered in the blanks and the product is added or deleted
	private JTextField stocktextField;
	private JTextField pricetextField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPage frame = new ManagerPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminManageForm() {
		setTitle("Admin Manage Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// It causes the application to exit when the application receives a close window event from the operating system.
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); // it always makes sure the window is in the middle.
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(34, 35, 814, 586);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBackground(new Color(255, 127, 80));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Apparel", "Toys", "Electronic", "Cosmetic", "Supermarket"}));
		comboBox.setBounds(41, 52, 212, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel.setBounds(40, 13, 213, 26);
		panel.add(lblNewLabel);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblBrand.setBounds(303, 19, 213, 26);
		panel.add(lblBrand);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblName.setBounds(544, 19, 213, 26);
		panel.add(lblName);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		lblSerialNumber.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblSerialNumber.setBounds(41, 173, 213, 26);
		panel.add(lblSerialNumber);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblStock.setBounds(288, 173, 213, 26);
		panel.add(lblStock);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblPrice.setBounds(544, 173, 213, 26);
		panel.add(lblPrice);
		
		brandtextField = new JTextField();
		brandtextField.setBounds(282, 52, 180, 22);
		panel.add(brandtextField);
		brandtextField.setColumns(10);
		
		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBounds(511, 52, 180, 22);
		panel.add(nametextField);
		
		serail_numbertextField = new JTextField();
		serail_numbertextField.setColumns(10);
		serail_numbertextField.setBounds(41, 208, 180, 22);
		panel.add(serail_numbertextField);
		
		stocktextField = new JTextField();
		stocktextField.setColumns(10);
		stocktextField.setBounds(282, 212, 180, 22);
		panel.add(stocktextField);
		
		pricetextField = new JTextField();
		pricetextField.setColumns(10);
		pricetextField.setBounds(511, 212, 180, 22);
		panel.add(pricetextField);
		
		JButton buttonAddProduct = new JButton("Add Product");
		////// burasý yeni eklendi
		buttonAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String category = String.valueOf(comboBox.getSelectedItem());
				String brand = brandtextField.getText();
				String name = nametextField.getText();
				String serial_number = serail_numbertextField.getText();  // int
				String stock = stocktextField.getText();                  // int
				String price = pricetextField.getText();                  // float
				if(checkBrand(brand)==true) {
					if(checkName(name)==true) {
						if(checkSerialNumber(serial_number)==true) {
							if(checkStock(stock)==true) {
								if(checkPrice(price)==true) {
									Products p = new Products(category,brand,name,Integer.parseInt(serial_number),
											Integer.parseInt(stock),Float.parseFloat(price));
									
									//ShoppingForm.productStorage.addProduct(p);
									ProductStorage pr = new ProductStorage();
									try {
										pr.readProductList();// read product list 
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									pr.addProduct1(p);// add the product after searching if there is the same product and we need to increase the quantity only.
									try {// update the txt file with created objects and updated Arraylist Structure.
										pr.updateFile(pr.getProducts());
									} catch (IOException e) {
							
										e.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Product added !","Message",JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					}
				}	
			}
		});
		buttonAddProduct.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
		buttonAddProduct.setBackground(new Color(255, 127, 80));
		buttonAddProduct.setBounds(454, 282, 303, 40);
		panel.add(buttonAddProduct);
		
		JButton buttonDeleteProduct = new JButton("Delete Product");
		buttonDeleteProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				String category = String.valueOf(comboBox.getSelectedItem());
				String brand = brandtextField.getText();
				String name = nametextField.getText();
				String serial_number = serail_numbertextField.getText();  // int
				String stock = stocktextField.getText();                  // int
				String price = pricetextField.getText();                  // float
				if(checkBrand(brand)==true) {
					if(checkName(name)==true) {
						if(checkSerialNumber(serial_number)==true) {
							if(checkStock(stock)==true) {
								if(checkPrice(price)==true) {
									Products p = new Products(category,brand,name,Integer.parseInt(serial_number),
											Integer.parseInt(stock),Float.parseFloat(price));
									
									//ShoppingForm.productStorage.addProduct(p);
									ProductStorage pr = new ProductStorage();
									try {
										pr.readProductList();// read product list 
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									try {
										pr.removeProduct(p);
									} catch (IOException e1) {
										e1.printStackTrace();
									};// add the product after searching if there is the same product and we need to increase the quantity only.
									
									JOptionPane.showMessageDialog(null, "Product is deleted !","Message",JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					}
				}	
			}
		});
		buttonDeleteProduct.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
		buttonDeleteProduct.setBackground(new Color(255, 127, 80));
		buttonDeleteProduct.setBounds(454, 335, 303, 40);
		panel.add(buttonDeleteProduct);
		
		JLabel icon_label = new JLabel("");
		icon_label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Image icon = new ImageIcon(this.getClass().getResource("store_manager.jpg")).getImage();  
		icon_label.setIcon(new ImageIcon(icon));
		icon_label.setBounds(123, 301, 224, 192);
		panel.add(icon_label);
		
		JLabel smileIconLabel = new JLabel("");
		smileIconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Image icon2 = new ImageIcon(this.getClass().getResource("smile.png")).getImage();  
		smileIconLabel.setIcon(new ImageIcon(icon2));
		smileIconLabel.setBounds(111, 488, 224, 62);
		panel.add(smileIconLabel);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				new AdminPageForm().setVisible(true);
				setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
		btnGoBack.setBackground(new Color(255, 127, 80));
		btnGoBack.setBounds(454, 395, 303, 40);
		panel.add(btnGoBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(0, 0, 34, 653);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(848, 0, 34, 653);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 128));
		panel_3.setBounds(34, 0, 814, 36);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 0, 128));
		panel_4.setBounds(34, 622, 814, 31);
		contentPane.add(panel_4);
	}
	public boolean checkBrand(String brand) 
	{
		boolean control = false;
		if(brand.equalsIgnoreCase("")) 
		{
			JOptionPane.showMessageDialog(null, "Enter brand !","Message",JOptionPane.ERROR_MESSAGE);
			control=false;
		}
		else {
			for (int i = 0; i < brand.length(); i++) {
				if(brand.charAt(i)<(char)65 || brand.charAt(i)>(char)122 || brand.charAt(i)==(char)91 || brand.charAt(i)==(char)92 || 
						brand.charAt(i)==(char)93 || brand.charAt(i)==(char)94 || brand.charAt(i)==(char)95 || brand.charAt(i)==(char)96	)
				{
					JOptionPane.showMessageDialog(null, "Brand is wrong !","Message",JOptionPane.ERROR_MESSAGE);
					brandtextField.setText("");
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
	public boolean checkName(String name) {
		boolean control = false;
		if(name.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Enter product name !","Message",JOptionPane.ERROR_MESSAGE);
			control=false;
		}
		else {
			for (int i = 0; i < name.length(); i++) {
				if(name.charAt(i)<(char)65 || name.charAt(i)>(char)122 || name.charAt(i)==(char)91 || name.charAt(i)==(char)92 || 
						name.charAt(i)==(char)93 || name.charAt(i)==(char)94 || name.charAt(i)==(char)95 || name.charAt(i)==(char)96)
				{
					JOptionPane.showMessageDialog(null, "There is an error in the product name, you entered it wrong !",
							"Message",JOptionPane.ERROR_MESSAGE);
					nametextField.setText("");
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
	private boolean checkSerialNumber(String serial_number) {  
		boolean control = false;
		try {
			if(serial_number.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter serial number !","Message",JOptionPane.ERROR_MESSAGE);
				control=false;
			}
			else {
				int balanc = Integer.valueOf(serial_number);
				if(balanc<0) {
					JOptionPane.showMessageDialog(null, "Cannot be negative !","Message",JOptionPane.ERROR_MESSAGE);
					serail_numbertextField.setText("");
					control=false;
				}
				else {
					control = true;
				}
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "enter number !","Message",JOptionPane.ERROR_MESSAGE);
			serail_numbertextField.setText("");
			control = false;
			// If it is dropped here, a string is entered instead of a number and an error is sent.
		}
		return control;
	}
	private boolean checkStock(String stock) {
		boolean control = false;
		try {
			if(stock.equals("")) {
				JOptionPane.showMessageDialog(null, "enter stock !","Message",JOptionPane.ERROR_MESSAGE);
				control=false;
			}
			else {
				int balanc = Integer.valueOf(stock);
				if(balanc<=0) {
					JOptionPane.showMessageDialog(null, "stock cannot be negative or zero !","Message",JOptionPane.ERROR_MESSAGE);
					stocktextField.setText("");
					control=false;
				}
				else {
					control = true;
				}
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "enter number !","Message",JOptionPane.ERROR_MESSAGE);
			stocktextField.setText("");
			control = false;
			// If it is dropped here, a string is entered instead of a number and an error is sent.
		}
		return control;
	}
	private boolean checkPrice(String price) {
		boolean control = false;
		try {
			if(price.equals("")) {
				JOptionPane.showMessageDialog(null, "enter price !","Message",JOptionPane.ERROR_MESSAGE);
				control=false;
			}
			else {
				int balanc = Integer.valueOf(price);
				if(balanc<=0) {
					JOptionPane.showMessageDialog(null, "price cannot be negative or zero !","Message",JOptionPane.ERROR_MESSAGE);
					pricetextField.setText("");
					control=false;
				}
				else {
					control = true;
				}
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "enter number !","Message",JOptionPane.ERROR_MESSAGE);
			pricetextField.setText("");
			control = false;
			// If it is dropped here, a string is entered instead of a number and an error is sent.
		}
		return control;
	}
	
	public boolean checkProducts(Products p) throws IOException {  // It is checked whether the product to be added or deleted exists.
		boolean flag = false;
		String address = "stuff.txt" ;
	
	    File file = new File(address);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String row = reader.readLine();
        int count = 0;
        String[] words = null;
        String[]category_x=new String[100];
        String[]brand_x=new String[100];
        String[]name_x=new String[100];
        String[]serial_number_x=new String[100];
        String[]stock_x=new String[100];
        String[]price_x=new String[100];
	
         while (row!=null) 
         {
        	words = row.split(";");
        	category_x[count]=words[0];
	        brand_x[count]=words[1];
	        name_x[count]=words[2];
	        serial_number_x[count]=words[3];
	        stock_x[count]=words[4];
	        price_x[count]=words[5];
      
            row = reader.readLine();
            count++;
         }
         
         for (int i = 0; i < brand_x.length; i++) {
			if(brand_x[i].equalsIgnoreCase(p.getBrand())) {
				if(category_x[i].equalsIgnoreCase(p.getCategory())) {
					if(name_x[i].equalsIgnoreCase(p.getName())) {
						if(serial_number_x[i].equalsIgnoreCase(String.valueOf(p.getSerialNumber()))) {
							if(stock_x[i].equalsIgnoreCase(String.valueOf(p.getStock()))) {
								if(price_x[i].equalsIgnoreCase(String.valueOf(p.getPrice()))) {
									flag = true;
								}
								else {
									break;
								}
							}
							else {
								break;
							}
						}
						else {
							break;
						}
					}
					else {
						break;
					}
				}
				else {
					break;
				}
			}
			
		}
         
        reader.close();
      
       
    return flag;
		    
	}
}
