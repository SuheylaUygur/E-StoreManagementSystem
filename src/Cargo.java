import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cargo implements Goods { // It is the class created for cargoes. It implements from the good interface. 
	
	private int trackingNumber;   // tracking number to use as an ID for making the cargo process possible between the areas.
	List <Products >products = new ArrayList<Products>();
	Object[][]customer;
	String customer_name;
	String customer_surname;           // Cargo features are available. These are location, state, some information about the customer.
	String customer_telephone;
	String location;
	String state;
	// When necessary, product information is taken from the products list, and customer information can be obtained from the array when necessary.

	public Cargo(String location,String state,List <Products> products,Object[][]customer) 
	{
		this.location = location;
		this.state = state;
		this.products = products;
		this.customer = customer;
	}

	public Cargo(String location,String state,String product_category,String product_brand,String product_name,
			String product_serial_number,String product_stock,String product_price,
			String customer_name,String customer_surname,String telephone) 
	{
		this.location = location;
		this.state = state;
		this.customer_name = customer_name;
		this.customer_surname = customer_surname;
		this.customer_telephone = telephone;
	
	}
	@Override
	public void setLocation(String location) 
	{
		this.location = location;	
	}

	@Override
	public void setState(String state) 
	{
		this.state = state;	
	}

	@Override
	public String displayGoodsInformation() 
	{	
		return null;
	}
	
	public void SaveCargo(Cargo c) throws IOException {  // It records the cargoes to the file.
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("cargo.txt"));
		//writer.write("sdfsfsdf");
		for (int i = 0; i < c.products.size(); i++) {
			writer.write(c.location+";"+c.state+";"+c.products.get(i).getCategory()+";"+c.products.get(i).getBrand()+";"
					+c.products.get(i).getName()+";"+c.products.get(i).getSerialNumber()+";"+c.products.get(i).getStock()+";"
					+c.products.get(i).getPrice()+";"+c.customer[2][0]+";"+c.customer[3][0]+";"+c.customer[9][0]+'\n');
		}
		
		writer.close();
	}
}
