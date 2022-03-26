import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class ProductStorage  // This class is the class where the products are stored. It acts as a warehouse.
{
	ArrayList <Products >products = new ArrayList<Products>(); // The products arraylist contains all products and their attributes.
	public int apparel_count;
	public int toys_count;
	public int electronics_count;
	public int cosmetics_count;
	public int supermarket_count;
	
	
	public void arrangedStatistics() {}
	
	public ArrayList<Products> getProducts() { return products;}

	public void setProducts(ArrayList<Products> products) { this.products = products;}

	public ArrayList<Products> searchProducts(String productName){ return products; }
	
	public void updateFile(ArrayList <Products> p) throws IOException {// When the shopping is finished, the stock amount of the products is updated.
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("stuff.txt"));
		//writer.write("sdfsfsdf");
		for(int i = 0; i < p.size(); i++) {
			float a = p.get(i).getPrice()-10;
			if(i==p.size()-1){// we check it because we dont want it to add another line to txt file.
			writer.write(p.get(i).getCategory()+";"+p.get(i).getBrand()+";"+p.get(i).getName()+";"+p.get(i).getSerialNumber()+";"+p.get(i).getStock()+
					";"+a);
			}
			else {
				writer.write(p.get(i).getCategory()+";"+p.get(i).getBrand()+";"+p.get(i).getName()+";"+p.get(i).getSerialNumber()+";"+p.get(i).getStock()+
						";"+a+'\n');
			}
			
		}

		writer.close();
	}
	
	public void addProduct1(Products productSingle) {// go through the arraylist and check if there is already the same product.
		boolean flag = false;
		for(int i = 0; i < this.products.size(); i++) {
			Products productList = this.products.get(i);
			if(this.products.get(i).getName().equalsIgnoreCase(productSingle.getName()) && this.products.get(i).getBrand().equalsIgnoreCase(productSingle.getBrand())){
				flag = true;
				productList.setStock(productList.getStock()+productSingle.getStock()); // get the total of both of them. 
			}else {
				//products.add(productSingle);
			}
			// Also update the .txt file 
			
		}
		if (flag == false)
		{
			productSingle.setPrice(productSingle.getPrice()+10);
			products.add(productSingle);
		}
			
			
				
	}
	
	public void removeProduct(Products productSingle) throws IOException {//When the shopping is finished, the stock amount of the products is updated.
			
			for(int i = 0; i < this.products.size(); i++) {
				Products productList = this.products.get(i);
				if(this.products.get(i).getName().equalsIgnoreCase(productSingle.getName()) && 
						this.products.get(i).getBrand().equalsIgnoreCase(productSingle.getBrand()))
				{
					
					int result = productList.getStock()-productSingle.getStock();
					productList.setStock(result); // get the total of both of them.
					
					if((result) <= 0) 
					{
						products.remove(i);
					}
				} 	
		    }
			this.updateFile(products);
		}
	
	public void addProduct(Products p) { // when a new product is added, it is written to the file.
		
		File fil = new File("stuff.txt");  
	    if (!fil.exists()) {
	        try {
				fil.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    }

	    FileWriter filWriter = null;
		try {
			filWriter = new FileWriter(fil, true);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	    BufferedWriter biWriter = new BufferedWriter(filWriter);
	    try {
			biWriter.write(p.getCategory()+";"+p.getBrand()+";"+p.getName()+";"+p.getSerialNumber()+";"+p.getStock()+
					";"+p.getPrice()+'\n');
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    try {
			biWriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	}
	
	public Products getLeastSoldByCategory(String category) {return null;}
	
	public Products getMostSoldByCategory(String category) {return null;}
	
	public void readProductList() throws FileNotFoundException {
		//This part reads the file and creates a place to hold the items
		        apparel_count = 0;
		        toys_count = 0;
		        cosmetics_count = 0;
		        electronics_count = 0;
		        supermarket_count = 0;
				Scanner scanner = new Scanner(new File("stuff.txt"));
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] parts = line.split(";");
					Products productToHoldIntoStorageUnit = new Products(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]),
							Integer.parseInt(parts[4]),Float.parseFloat(parts[5])+'\n');
					this.products.add(productToHoldIntoStorageUnit);
					if(parts[0].equals("Apparel")) {
						apparel_count++;
					}
					else if(parts[0].equals("Toys")) {
						toys_count++;
					}
					else if(parts[0].equals("Cosmetic")) {
						cosmetics_count++;
					}
					else if(parts[0].equals("Electronic")) {
						electronics_count++;
					}
					else if(parts[0].equals("Supermarket")) {
						supermarket_count++;
					}
				}
	    }
}
