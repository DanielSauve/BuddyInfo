import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		case "load":
			loadAB();
			break;
		
		}
	}

	public void addBuddy()
	{
		BuddyInfo b = new BuddyInfo(JOptionPane.showInputDialog("What is your friends name?"), 
				JOptionPane.showInputDialog("What is your friends address?"), 
				JOptionPane.showInputDialog("What is your friends phone number?"));
		b.setAge(Integer.parseInt(JOptionPane.showInputDialog("What is your friends age?")));
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
		addressBook.saveAB();
	}
	
	private void loadAB() {
		addressBook.loadAB();
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
