import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Manager extends Person   // Manager class extends from the Person abstract class.
{                                     // Here there are the functions of manager privileges.
	private String city;              // A city can have a manager.
	static Object[][]profileManager = new Object[5][1];  // The profileManager is for the manager profile. It goes to the JTable component as a parameter.
	
	public Manager(String city,String name, String surname, String username, String password)
	{
		super(name, surname, username, password);
		this.city = city;
	}
	
	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public void addProducts(Products productToAdd) 
	{    // Managers can add products.
		Products p = new Products(productToAdd.getCategory(),productToAdd.getBrand(),productToAdd.getName(),productToAdd.getSerialNumber(),
				productToAdd.getStock(),productToAdd.getPrice());
		ProductStorage pr = new ProductStorage();
		pr.addProduct(p);
	}
	
	public void deleteProducts(Products productToDelete) throws IOException 
	{  // Mnagers can delete products.
		ProductStorage pr = new ProductStorage();
		pr.removeProduct (productToDelete);
	}

	@Override
	public void deleteUser() {}

	@Override
	public void sendMessageToAdmin() {}

	@Override
	public void Save()  // Manager is saved to file.
	{
		File fil = new File("Managers.txt");   
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
			biWriter.write(this.city+";"+this.getName()+";"+this.getSurname()+";"+this.getUsername()+";"+this.getPassword()+'\n');
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    try {
			biWriter.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	    JOptionPane.showMessageDialog(null, "Saved Successfully !","Message",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static  void createProfile(String city,String name,String surname,String username,String password) 
	{  // For the JTable component, the array that will come as the parameter is created.
		profileManager[0][0]="1- "+city;
		profileManager[1][0]="2- "+name;
		profileManager[2][0]="3- "+surname;
		profileManager[3][0]="4- "+username;
		profileManager[4][0]="5- "+password;
	}
}
