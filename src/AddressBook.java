import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AddressBook extends DefaultListModel<BuddyInfo> implements java.io.Serializable{

	private static final long serialVersionUID = -5221002145074077907L;

	public AddressBook()
	{
		super();
	}
	public AddressBook(AddressBook a)
	{
		super();
	}
	
	public void addBuddy(BuddyInfo buddy)
	{
		this.addElement(buddy);
	}
	
	public void addBuddy(AddressBook a)
	{
		for (int i = 0; i<a.size(); i++)
		{
			this.addBuddy(a.get(i));			
		}
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
		int i = Integer.parseInt(JOptionPane.showInputDialog("What is your friends age?"));
		if (!(b.getName().equals(null)||b.getName().equals(null)||b.getName().equals(null)))
		{
			this.remove(index);
			b.setAge(i);
			this.insertElementAt(b, index);
		}	
	}
	
	public void loadAB()
	{
		try {
			/*BufferedReader in = new BufferedReader(new FileReader("AddressBook.txt"));
			String s = in.readLine();
			String name, address, phone;
			int age;
			BuddyInfo b;
			while (s!= null)
			{
				name = s;
				s = in.readLine();
				address = s;
				s = in.readLine();
				phone = s;
				s = in.readLine();
				age = Integer.parseInt(s);
				b = new BuddyInfo(name,address,phone);
				b.setAge(age);
				s = in.readLine();
				addressBook.addBuddy(b);
			}
			in.close();*/
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("AddressBook.ser"));
			this.addBuddy((AddressBook) in.readObject());
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveAB()
	{
		try {
			/*BufferedWriter out = new BufferedWriter(new FileWriter("AddressBook.txt"));
			for(int i = 0; i<addressBook.getSize();i++)
			{
				out.write(addressBook.get(i).toString()+"\r");
			}*/
			ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("AddressBook.ser"));
			out2.writeObject(this);
			out2.close();
			//out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
