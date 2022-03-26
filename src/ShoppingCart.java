import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	static List <Products > products_in_shoppingCart = new ArrayList<Products>();
	// The products_in_shoppingCart list holds the customer's products in the cart.
	
	public ShoppingCart() {super();}
	
	public float total() {return 0;}
	
	public List<Products> getProducts() {
		return products_in_shoppingCart;
	}

	public void setProducts(List<Products> products) {
		this.products_in_shoppingCart = products;
	}

	public void addProductToShoppingCart(String choosedElement, ArrayList<Products> products,int stok,int total_price) 
	{   
		// in this method, we will add products into the shopping cart.
		for (Products products2 : products)
		{
			if(products2.getName().equalsIgnoreCase(choosedElement)) 
			{
				Products p = new Products(products2.getCategory(),products2.getBrand(),products2.getName(),products2.getSerialNumber(),stok,total_price);
				products2.setStock(products2.getStock()-stok);
				products_in_shoppingCart.add(p);
			}  
		}
	}
	
	public void deleteProductToShoppingCart(String choosedElement, ArrayList<Products> products,int stok,int total_price) 
	{   
		// in this method, we will delete products into the shopping cart.
		for (Products products2 : products)
		{
			if(products2.getName().equalsIgnoreCase(choosedElement)) 
			{
				Products p = new Products(products2.getCategory(),products2.getBrand(),products2.getName(),
						products2.getSerialNumber(),stok,total_price);
				products2.setStock(products2.getStock()+stok);
				products_in_shoppingCart.remove(p);
			}  
		}
	}
}
