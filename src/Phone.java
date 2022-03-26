
public class Phone                         // This class is the class that holds the phone number.
{
	private String areaCode;               // areaCode + phoneCode + phone  //  3 number + 3 number + 4 number = 10 number 
	private String phoneCode;                                               //  first number 0, it is not important
	private String phone;
	
	public Phone(String areaCode, String phoneCode, String phone)           //  get & set methods are available
	{
		super();
		this.areaCode = areaCode;
		this.phoneCode = phoneCode;
		this.phone = phone;
	}
	
	public String getAreaCode()
	{
		return areaCode;
	}
	
	public void setAreaCode(String areaCode) 
	{
		this.areaCode = areaCode;
	}
	
	public String getPhoneCode()
	{
		return phoneCode;
	}
	
	public void setPhoneCode(String phoneCode)
	{
		this.phoneCode = phoneCode;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	} 
}
