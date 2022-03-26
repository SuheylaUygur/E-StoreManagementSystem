
public class Address   // Address Class  // This class is created to hold the customer's address information.
{
	private String country;              // This class is the class that holds the subsets of the address,which is country, city, and street.
	private String city;                 // get & set methods are available
	private String street;               
	
	public Address(String country, String city, String street) 
	{
		super();
		this.country = country;
		this.city = city;
		this.street = street;
	}
	public String getCountry() 
	{
		return country;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getStreet() 
	{
		return street;
	}
	public void setStreet(String street) 
	{
		this.street = street;
	} 
}
