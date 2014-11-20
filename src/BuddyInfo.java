public class BuddyInfo implements java.io.Serializable{
	
	private String name;
	private String address;
	private String number;
	private int age;
	
	public BuddyInfo(String name, String address, String number)
	{
		this.setName(name);
		this.setAddress(address);
		this.setNumber(number);
	}
	
	public BuddyInfo(BuddyInfo b) {
		this.setName(b.getName());
		this.setAddress(b.getAddress());
		this.setNumber(b.getNumber());
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
		return this.getName() + " \n" + this.getAddress() + " \n" + this.getNumber() + " \n" + this.getAge();
	}

	private int getAge() {
		return this.age;
	}

	public void setAge(int i) {
		this.age = i;
		
	}

	public boolean isOver18() {
		return age>=18;
	}

	public String greetBuddy() {
		return "Hello " + this.getName();
	}
}
