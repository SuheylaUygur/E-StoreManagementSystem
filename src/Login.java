import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Login 
{
	public boolean checkPassword(String username, String password) throws IOException 
	{  // It is the function where the information of the users is taken and saved at login.
		    boolean flag = false;
		    String address = "Customers_all_data.txt";
		    
		    File file = new File(address);
		    if (!file.exists()) 
		    {
		        file.createNewFile();
		    }
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String row = reader.readLine();
	        String[] words = null;
	        String[]name_x=new String[100];
	        String[]surname_x=new String[100];
	        String[]username_x=new String[100];
	        String[]password_x=new String[100];
	        String[]shopCard_x=new String[100];
	        String[]balance_x=new String[100];
	        String[]CVV_x=new String[100];
	        String[]cardPassword_x=new String[100];
	        String[]gender_x=new String[100];
	        String[]age_x=new String[100];
	        String[]areaCode_x=new String[100];
	        String[]phoneCode_x=new String[100];
	        String[]phone_x=new String[100];
	        String[]country_x=new String[100];
	        String[]city_x=new String[100];
	        String[]street_x=new String[100];
	        int count = 0;
	        
	    
         while (row!=null) 
         {
  		   words = row.split(";");
  		   name_x[count] = words[0];
  		   surname_x[count] = words[1];
  		   username_x[count] = words[2];
		   password_x[count] = words[3];
		   shopCard_x[count] = words[4];
  		   balance_x[count] = words[5];
  		   CVV_x[count] = words[6];
		   cardPassword_x[count] = words[7];
		   gender_x[count] = words[8];
  		   age_x[count] = words[9];
  		   areaCode_x[count] = words[10];
		   phoneCode_x[count] = words[11];
		   phone_x[count] = words[12];
  		   country_x[count] = words[13];
  		   city_x[count] = words[14];
		   street_x[count] = words[15];
      	   count++;
           row = reader.readLine();
         
         }
         
         for (int i = 0; i < username_x.length; i++) 
         {
			if(username.equals(username_x[i])) 
			{
				if(password.equals(password_x[i])) 
				{
					flag = true;
					Customer.createProfile(username,password,name_x[i],surname_x[i],Integer.parseInt(balance_x[i]),
							Integer.parseInt(CVV_x[i]),cardPassword_x[i],gender_x[i],
							age_x[i], areaCode_x[i],phoneCode_x[i], phone_x[i],country_x[i],city_x[i],street_x[i]) ;
					break;
				}
			}
		}
         return flag;
	}
}
