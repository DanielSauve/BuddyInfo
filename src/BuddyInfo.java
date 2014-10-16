public class BuddyInfo {
	
	private String name;
	private String address;
	private String number;
	
	public BuddyInfo(String name, String address, String number)
	{
		this.setName(name);
		this.setAddress(address);
		this.setNumber(number);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public boolean equals(BuddyInfo b)
	{
		if(this.getName().equals(b.getName()) && this.getAddress().equals(b.getAddress()) && this.getNumber()==b.getNumber())
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return this.getName() + ", " + this.getAddress() + ", " + this.getNumber();
	}
}
