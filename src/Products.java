
public class Products implements Goods {  // It is implemented from the Good interface class.
	private String category; 
	private String brand;         // There are five categories in total.
	private String name;          // The class contains the properties of the products.
	private int serialNumber; 
	private int stock; 
	private float price; 
	

	public Products(String category, String brand, String name, int serialNumber, int stock, float price) 
	{
		super();
		this.category = category;
		this.brand = brand;
		this.name = name;
		this.serialNumber = serialNumber;
		this.stock = stock;
		this.price = price;
	}
	
	
	@Override
	public void setLocation(String location) {}

	@Override
	public void setState(String state) {}

	@Override
	public String displayGoodsInformation() {return null;}

	public String getCategory() {return category;}

	public void setCategory(String category) {this.category = category;}

	public String getBrand() { return brand;}

	public void setBrand(String brand) { this.brand = brand;	}

	public String getName() {return name;}

	public void setName(String name) { this.name = name;}

	public int getSerialNumber() { return serialNumber;}

	public void setSerialNumber(int serialNumber) { this.serialNumber = serialNumber;}

	public int getStock() { return stock;}

	public void setStock(int stock) { this.stock = stock;}

	public float getPrice() { return price;}

	public void setPrice(float price) { this.price = price; }

}
