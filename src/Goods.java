
public interface Goods {  // It is used for the status and location of cargoes. It is an interface class.
	
	String state    = "good";
	String location = "";
	
	public void setLocation(String location);  // it holds where the product is.
	
	public void setState(String state); // it stores the status of the product.  (good or damaged)
	
	public String displayGoodsInformation();   //  it will allow users to list the info of the goods at whatever stage it is in.
		
}
