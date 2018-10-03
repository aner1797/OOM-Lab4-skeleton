package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		DateTime date = new DateTime(2018,05,14,15,25,40);
		
		String stringDate = date.toString();
		
		
		assertEquals(stringDate, "2018-05-14 15:25");

	}

	@Test
	public void testDateTimeString() {
		
		DateTime date = new DateTime("2018-05-14 15:25:40");
		DateTime expectedDate = new DateTime(2018,05,14,15,25,40);


		assertEquals(date.toString(), expectedDate.toString());

	}

}
