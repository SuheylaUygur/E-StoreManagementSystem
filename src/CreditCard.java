import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreditCard {             // This class stores credit card information. These are cardPassword, CVV, balance
	
	private int creditNumber;         // We did not include this attribute because it is not required for operations.
	private String cardPassword;      // get & set methods are available 
	private int CVV; 
	private int balance;
	
	public CreditCard(int creditNumber, String cardPassword, int cVV, int balance) 
	{
		super();
		this.creditNumber = creditNumber;
		this.cardPassword = cardPassword;
		CVV = cVV;
		this.balance = balance;
	}
	public CreditCard() 
	{
		super();
	}

	public int getCreditNumber()
	{
		return creditNumber;
	}

	public void setCreditNumber(int creditNumber)
	{
		this.creditNumber = creditNumber;
	}

	public String getCardPassword()
	{
		return cardPassword;
	}

	public void setCardPassword(String cardPassword) 
	{
		this.cardPassword = cardPassword;
	}

	public int getCVV() 
	{
		return CVV;
	}

	public void setCVV(int cVV) 
	{
		CVV = cVV;
	}

	public int getBalance() 
	{
		return balance;
	}

	public void setBalance(int balance) throws IOException   // After shopping, the customer's balance is updated.
	{
		this.balance = balance;
		String address = "Customers_all_data.txt";
		
	    File file = new File(address);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String row = reader.readLine();
        int count = 0;
        String[] words = null;
        String[]username_x=new String[100];
        String[]password_x=new String[100];
	
         while (row!=null) 
         {
        	words = row.split(";");
    		  username_x[count] = words[0];
    		   password_x[count] = words[1];
           row = reader.readLine();
           count++;
         }
         
        reader.close();
	}
	public void updateFile(String username, int newAmount) throws IOException {  // After shopping, the stock number of the products is updated.
		File file = new File("Customers_all_data.txt");
		
		FileReader fr=new FileReader(file); 
		
		BufferedReader br=new BufferedReader(fr);
		
		StringBuffer sb=new StringBuffer();
		
		String line;  
		
		while((line=br.readLine())!=null)  
		{  	String lineToHold;
     //line feed   
			String[] parts = line.split(";");
			if(parts[2].equalsIgnoreCase(username)) {
				 line = parts[0]+";"+parts[1]+";"+parts[2]+";"+parts[3]+";"+parts[4]+";"+newAmount+";"
			+parts[6]+";"+parts[7]+";"+parts[8]+";"+parts[9]+";"+parts[10]+";"+parts[11]+";"+parts[12]+";"+parts[13]+";"+parts[14]
					+";"+parts[15];
				
			}
			sb.append(line);      //appends line to string buffer  
			sb.append("\n");
		}  
		fr.close();
		
	      FileWriter writer = new FileWriter("Customers_all_data.txt");
	      writer.append(sb);
	      writer.flush();
	}
}
