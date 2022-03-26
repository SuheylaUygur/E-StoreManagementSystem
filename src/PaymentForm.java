
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Font;
import java.awt.HeadlessException;


public class PaymentForm extends JFrame  // This class was created for the payment interface.
{
	JTable tabl;                            // contains a table like an invoice.
	float sum_price = 0;                    // The customer completes her shopping by following the transactions.
	Cargo cargo;
	Area area;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PaymentForm frame = new PaymentForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PaymentForm() 
	{
		super("Payment");
		Payment payment = new Payment();
		setBounds(100, 100, 900, 700);           // This is the window size we always use.
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 882, 200);
		getContentPane().add(panel);
		Object[]column = {"category","brand","name","serial number","stock","price"};   // These are the product features we determined.
		Object [][]veriler = new Object[ShoppingForm.total_product][6];
		this.setLocationRelativeTo(null);    // it always makes sure the window is in the middle
		
		for (int i = 0; i < ShoppingForm.total_product; i++) 
		{
			veriler[i][0]=ShoppingForm.card.products_in_shoppingCart.get(i).getCategory();  // Here, products are drawn from the shopping cart.
			veriler[i][1]=ShoppingForm.card.products_in_shoppingCart.get(i).getBrand();
			veriler[i][2]=ShoppingForm.card.products_in_shoppingCart.get(i).getName();
			veriler[i][3]=ShoppingForm.card.products_in_shoppingCart.get(i).getSerialNumber();
			veriler[i][4]=ShoppingForm.card.products_in_shoppingCart.get(i).getStock();
			veriler[i][5]=ShoppingForm.card.products_in_shoppingCart.get(i).getPrice();
			sum_price += ShoppingForm.card.products_in_shoppingCart.get(i).getPrice();
		}
		panel.setLayout(null);
		
		tabl = new JTable(veriler,column);          // Products are thrown to jtable component
		tabl.setBounds(180, 230, 450, 300);
		tabl.setCellSelectionEnabled(true);
		panel.add(tabl);             // The table is added to the screen.
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		comboBox.setBounds(564, 83, 230, 22);   // A comboBox component with cities is used to select the cargo.
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"ADANA", "ADIYAMAN", "AFYONKARAH\u0130SAR", "A\u011ERI", 
				"AMASYA", "ANKARA", "ANTALYA", "ARTV\u0130N", "AYDIN", "BALIKES\u0130R", "B\u0130LEC\u0130K", "B\u0130NG\u00D6L", 
				"B\u0130TL\u0130S", "BOLU", "BURDUR", "BURSA", "\u00C7ANAKKALE", "\u00C7ANKIRI", "\u00C7ORUM", "DEN\u0130ZL\u0130", 
				"D\u0130YARBAKIR", "ED\u0130RNE", "ELAZI\u011E", "ERZ\u0130NCAN", "ERZURUM", "ESK\u0130\u015EEH\u0130R", "GAZ\u0130ANTEP", 
				"G\u0130RESUN", "G\u00DCM\u00DC\u015EHANE", "HAKKAR\u0130", "HATAY", "ISPARTA", "MERS\u0130N", "\u0130STANBUL", "\u0130ZM\u0130R", 
				"KARS", "KASTAMONU", "KAYSER\u0130", "KIRKLAREL\u0130", "KIR\u015EEH\u0130R", "KOCAEL\u0130", "KONYA\t", "K\u00DCTAHYA", "MALATYA",
				"MAN\u0130SA", "KAHRAMANMARA\u015E", "MARD\u0130N", "MU\u011ELA", "MU\u015E", "NEV\u015EEH\u0130R", "N\u0130\u011EDE", "ORDU",
				"R\u0130ZE", "SAKARYA", "SAMSUN", "S\u0130\u0130RT", "S\u0130NOP", "S\u0130VAS", "TEK\u0130RDA\u011E", "TOKAT", "TRABZON", 
				"TUNCEL\u0130", "\u015EANLIURFA", "U\u015EAK", "VAN", "YOZGAT", "ZONGULDAK", "AKSARAY", "BAYBURT", "KARAMAN", "KIRIKKALE",
				"BATMAN", "\u015EIRNAK", "BARTIN", "ARDAHAN", "I\u011EDIR", "YALOVA", "KARAB\u00DCK", "K\u0130L\u0130S", "OSMAN\u0130YE", 
				"D\u00DCZCE"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(0, 153, 255));
		panel.add(comboBox);
		
		JButton MakePaymentButton = new JButton("make payment");  
		MakePaymentButton.addMouseListener(new MouseAdapter() { // This will be activated when the make payment button is pressed.
			@Override
			public void mouseClicked(MouseEvent e) 
			{
					if(payment.makePayment(sum_price, payment)==true)
					{
						JOptionPane.showMessageDialog(null, "Thank you !","Message",JOptionPane.INFORMATION_MESSAGE);
					}				
				else {
					JOptionPane.showMessageDialog(null, "please check balance first !","Message",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		MakePaymentButton.setBounds(48, 134, 175, 25);
		MakePaymentButton.setBackground(new Color(0, 204, 102));
		panel.add(MakePaymentButton);
		
		JLabel costLabel = new JLabel("");
		costLabel.setForeground(new Color(0, 0, 0));
		costLabel.setBackground(new Color(0, 204, 102));
		costLabel.setBounds(646, 533, 208, 73);
		panel.add(costLabel);
		String costt = String.valueOf(sum_price);
		costLabel.setText("total cost :"+costt);
	
		JButton balanceQueryButton = new JButton("balance query");
		balanceQueryButton.setBounds(48, 82, 175, 25);
		balanceQueryButton.setBackground(new Color(0, 204, 102));
		panel.add(balanceQueryButton);
		
		JLabel infoTextLabel = new JLabel("Please select the address to which we will send your cargo ");
		infoTextLabel.setBackground(new Color(0, 204, 102));
		infoTextLabel.setFont(new Font("Arial", Font.BOLD, 13));
		infoTextLabel.setForeground(new Color(0, 0, 0));
		infoTextLabel.setBounds(469, 25, 385, 37);
		panel.add(infoTextLabel);
		
		JLabel categoryLabel = new JLabel("category");
		categoryLabel.setBounds(180, 201, 56, 16);
		panel.add(categoryLabel);
		
		JLabel brandLabel = new JLabel("brand");
		brandLabel.setBounds(255, 201, 56, 16);
		panel.add(brandLabel);
		
		JLabel nameLabel = new JLabel("name");
		nameLabel.setBounds(326, 201, 56, 16);
		panel.add(nameLabel);
		
		JLabel serialNumberLabel = new JLabel("serial no");
		serialNumberLabel.setBounds(394, 201, 56, 16);
		panel.add(serialNumberLabel);
		
		JLabel stockLabel = new JLabel("stock");
		stockLabel.setBounds(482, 201, 56, 16);
		panel.add(stockLabel);
		
		JLabel priceLabel = new JLabel("price");
		priceLabel.setBounds(550, 201, 56, 16);
		panel.add(priceLabel);
		
		JButton ConfirmButton = new JButton("Confirm cargo address");
		ConfirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(Payment.flag==true)
				{
					String cargoSendWhichCity = String.valueOf(comboBox.getSelectedItem());  // The destination city of the cargo will be selected.
				
					cargo = new Cargo(cargoSendWhichCity,"the order is getting prepared",
							ShoppingForm.card.products_in_shoppingCart,Customer.profileCustomer);
					area = new Area(cargoSendWhichCity);
					area.q.enqueue(cargo);
					
					
					try {
						cargo.SaveCargo(cargo);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, ", zero cargo ! ","Warning",JOptionPane.WARNING_MESSAGE);
					
					}
					
					JOptionPane.showMessageDialog(null, "Your order has been received.","Message",JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "To be sent to "+cargoSendWhichCity,"Message",JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "Goodbye :) ","Message",JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please make payment first ","Message",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		ConfirmButton.setBackground(new Color(0, 153, 255));
		ConfirmButton.setBounds(564, 118, 230, 25);
		panel.add(ConfirmButton);
		balanceQueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) // This is activated when the check balance button is pressed.
			{
				try {
					if(payment.checkedBalanced(sum_price)==true)
					{
						// balance is sufficient
					}
					else {
						// balance is insufficient 
						JOptionPane.showMessageDialog(null, "insufficient balance !","Message",JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, "You are directed to the shopping page.","Message",JOptionPane.INFORMATION_MESSAGE);
						try 
						{
							new ShoppingForm().setVisible(true);
							setVisible(false);
						} catch (FileNotFoundException e) {}
					}
				} catch (HeadlessException e) 
				{
					e.printStackTrace();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}	
			}
		});
	}
}
