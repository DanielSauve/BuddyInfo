import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

@SuppressWarnings("serial")
public class AddressBookGUI extends JFrame
{
	private JMenuBar menuBar;
	private JMenu menuAB;
	private JMenu menuBud;
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem add;
	private JList<BuddyInfo> text;
	private JMenuItem remove;
	private JMenuItem edit;
	private AddressBook addressBook;
	
	public AddressBookGUI()
	{
		super("Address Book");
		ViewListener listener = new ViewListener();
		this.setLayout(new FlowLayout());
		addressBook = listener.getAddressBook();
		text = new JList<BuddyInfo>();
		addressBook.addListDataListener(new ListDataListener()
		{
			@Override
			public void contentsChanged(ListDataEvent arg0) {
				text.updateUI();
				
			}

			@Override
			public void intervalAdded(ListDataEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void intervalRemoved(ListDataEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		text.setModel(addressBook);
		menuBar = new JMenuBar();
		menuAB = new JMenu("Address Book");
		menuBud = new JMenu("Buddy Info");
		save = new JMenuItem("Save");
		save.setActionCommand("save");
		save.addActionListener(listener);
		load = new JMenuItem("Load");
		load.setActionCommand("load");
		load.addActionListener(listener);
		add = new JMenuItem("Add");
		add.setActionCommand("add");
		add.addActionListener(listener);
		remove = new JMenuItem("Remove");
		remove.setActionCommand("remove");
		remove.addActionListener(listener);
		edit = new JMenuItem("Edit");
		edit.setActionCommand("edit");
		edit.addActionListener(listener);
		this.setJMenuBar(menuBar);
		menuBar.add(menuAB);
		menuBar.add(menuBud);
		menuAB.add(save);
		menuAB.add(load);
		menuBud.add(add);
		menuBud.add(remove);
		menuBud.add(edit);
		this.add(text);
		this.setSize(400, 225);
		this.setVisible(true);
	}
	public int getSelectedIndex()
	{
		return text.getSelectedIndex();
	}
}
