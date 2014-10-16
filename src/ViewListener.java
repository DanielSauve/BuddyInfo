import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


public class ViewListener implements ActionListener{
	private AddressBook addressBook;
	private static AddressBookGUI gui;
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		case "add":
			addBuddy();
			break;
		case "edit":
			editBuddy();
			break;
		case "remove":
			removeBuddy();
			break;
		case "save":
			saveAB();
			break;
		
		}
	}
	
	public void addBuddy()
	{
		BuddyInfo b = new BuddyInfo(JOptionPane.showInputDialog("What is your friends name?"), 
				JOptionPane.showInputDialog("What is your friends address?"), 
				JOptionPane.showInputDialog("What is your friends phone number?"));
		if (!(addressBook.contains(b)||b.getName().equals(null)||b.getName().equals(null)||b.getName().equals(null)))
		{
			addressBook.addBuddy(b);
		}
	}
	
	public void removeBuddy()
	{
		addressBook.removeBuddy(gui.getSelectedIndex());
	}
	
	public void editBuddy()
	{
		addressBook.editBuddy(gui.getSelectedIndex());
	}
	
	public void saveAB()
	{
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("AddressBook.txt"));
			for(int i = 0; i<addressBook.getSize();i++)
			{
				out.write(addressBook.get(i).toString()+"\r");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public AddressBook getAddressBook()
	{
		return addressBook;
	}

	public ViewListener()
	{
		super();
		addressBook = new AddressBook();
	}
	
	public static void main(String[] args)
	{
		gui = new AddressBookGUI();
	}
}
