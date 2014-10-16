import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AddressBook extends DefaultListModel<BuddyInfo>{
	
	public AddressBook()
	{
		super();
	}
	public void addBuddy(BuddyInfo buddy)
	{
		this.addElement(buddy);
	}
	
	public void removeBuddy(int index)
	{
		if(index>=0)
		{
			this.remove(index);
		}
			
	}
	public boolean contains(BuddyInfo b)
	{
		return super.contains(b);
	}
	
	public void editBuddy(int index)
	{
		BuddyInfo b = new BuddyInfo(JOptionPane.showInputDialog("What is your friends name?"), 
			JOptionPane.showInputDialog("What is your friends address?"), 
			JOptionPane.showInputDialog("What is your friends phone number?"));
		if (!(b.getName().equals(null)||b.getName().equals(null)||b.getName().equals(null)))
		{
			this.remove(index);
			this.insertElementAt(b, index);
		}	
	}

}
