
import java.io.IOException;
import javax.swing.JOptionPane;

public class Payment {  // In this class, the customer's balance is checked and paid.  There is a method that updates the balance of the customer.
	static boolean flag = false;
	public static boolean checkedBalanced(float sum_price) throws IOException
	{
		// check balance
		if(Customer.bakiye!=0) {
			int balance = Customer.bakiye ; // this is the current customer's balance
			if((int)sum_price<=balance)
			{
				// balance is sufficient
				JOptionPane.showMessageDialog(null, "your balance is sufficient you can make payment !","Message",JOptionPane.INFORMATION_MESSAGE);
				Customer.profileCustomer[4][0] = (balance-sum_price);  // new balance
				JOptionPane.showMessageDialog(null, "Your remaining balance: "+(balance-sum_price),"Message",JOptionPane.INFORMATION_MESSAGE);
				flag = true;
				
				int new_balance =  balance-(int)sum_price;
				Customer.setBakiye(new_balance);
				CreditCard carrd = new CreditCard();
				carrd.updateFile( Customer.username_ , new_balance);
				updateLast();
			
			}
			else {
				// insufficient balance   	
				flag = false;
			}
		}
		return flag;
	}

	public static boolean makePayment(float sum_price, Payment payment) 
	{
		boolean flagPayment = false;    // payment control point
		if(flag==true)
		{
			flagPayment = true;
		}
		else {
			flagPayment = false;
		}
		return flagPayment;
	}
	
	public static void updateLast() throws IOException // Customer balance is updated
	{
		ProductStorage products_all = new ProductStorage();
		products_all.readProductList();
		for (int j = 0; j < ShoppingCart.products_in_shoppingCart.size(); j++) 
		{
			//int decreasing_amount = ShoppingCart.products_in_shoppingCart.get(j).getStock();
			products_all.removeProduct(ShoppingCart.products_in_shoppingCart.get(j));
			
		}
		products_all.updateFile(products_all.getProducts());
		
		 
	}
}
