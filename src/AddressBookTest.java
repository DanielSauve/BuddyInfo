import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AddressBookTest {

	AddressBook a1;
	AddressBook a2;
	BuddyInfo b1;
	BuddyInfo b2;
	@Before
	public void setUp()
	{
		b1 = new BuddyInfo("Daniel", "3128 Findlay Creek Drive", "6138220858");
		b2 = new BuddyInfo("David", "No where", "6135554422");
		a1 = new AddressBook();
		a1.addBuddy(b1);
		a1.addBuddy(b2);
		a2 = new AddressBook();
	}
	@Test
	public void testSerialize() {
		a1.saveAB();
		a2.loadAB();
		assertTrue(a1.toString().equals(a2.toString()));
	}

}
