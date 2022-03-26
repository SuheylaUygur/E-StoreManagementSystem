import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Area {
	
	private String locationName; // This is the variable that holds the name of the city where the cargo will go.
	Queue q = new Queue(1000);  // it holds all outgoing cargo. // it allows max 1000 cargo.
	
	
	public Area(String locationName) 
	{
		super();
		this.locationName = locationName;
	}
	
	public Area() {
		super();
	}
	
	public ArrayList<String> showAllCargo() throws IOException  // The data from the "cargo.txt" file is thrown into the queue structure.
	{
		String address = "cargo.txt";                           // Cargoes are sorted in the queue and sent from the queue according to their priority.
		
	    File file = new File(address);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        int count = 0;
        String [] words;
     
        Cargo cargo;
         while (line!=null) 
         {
           words = line.split(";");     // Here the cargo is created.
           cargo = new Cargo(words[0],words[1],words[2],words[3],words[4],words[5],words[6],words[7],words[8],words[9],words[10]);
		   q.enqueue(cargo);
           line = reader.readLine();
           count++;
         }
         reader.close();
         FileWriter writer = new FileWriter(file);
         writer.append("");    // The file is emptied when the cargoes are gone.
         writer.flush();
         
       
		return null;
	}
	
	public void send_cargo(Cargo c,String state) 
	{   // it sets the status of the cargo.
		c.setState(state);
	}
}
