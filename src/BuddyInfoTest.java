import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BuddyInfoTest {
	BuddyInfo b1 = null;
	BuddyInfo b2 = null;
	AddressBook book = null;

	@Before
	public void setUp() throws Exception 
	{
		book = new AddressBook();
		b1 = new BuddyInfo("Dave","14 Trellis Court","6135218200");
		b1.setAge(17);
		b2 = new BuddyInfo("Daniel","3128 Findlay Creek","6135554411");
		b2.setAge(20);
		book.addBuddy(b1);
		book.addBuddy(b2);
	}


	@Test
	public void testIsOver18() 
	{
		assertTrue(b2.isOver18());
		assertFalse(b1.isOver18());
	}
	
	@Test
	public void testCloneBuddy()
	{
		BuddyInfo b3 = new BuddyInfo(b1);
		assertEquals(b1.toString(),b3.toString());
	}
	
	@Test
	public void testSize()
	{
		assertEquals(book.size(),2);
		book.removeBuddy(1);
		assertEquals(book.size(),1);
	}
	
	@Test
	public void testClear()
	{
		assertEquals(book.size(),2);
		book.clear();
		assertEquals(book.size(),0);
	}
	
	@Test
	public void testGreeting()
	{
		assertEquals("Hello Daniel", b2.greetBuddy());
		assertEquals("Hello Dave", b1.greetBuddy());
	}
}
