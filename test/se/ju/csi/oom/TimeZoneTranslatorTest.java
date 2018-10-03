package se.ju.csi.oom;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import se.ju.csi.oom.lab4.DateTime;
import se.ju.csi.oom.lab4.Event;
import se.ju.csi.oom.lab4.Participant;
import se.ju.csi.oom.lab4.Place;
import se.ju.csi.oom.lab4.TimeZone;
import se.ju.csi.oom.lab4.TimeZoneTranslator;

public class TimeZoneTranslatorTest extends TimeZoneTranslator {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime date = new DateTime(2018,05,14,15,25,40);
		DateTime newDate = shiftTimeZone(date, TimeZone.HAWAII.getOffset(), TimeZone.ALASKA.getOffset());
		DateTime expectedDate = new DateTime(2018,05,14,16,25,40);

		assertEquals(newDate.toString(), expectedDate.toString());
		
		
		DateTime testDate = new DateTime(2016,01,01,06,00,00);
		DateTime newTestDate = shiftTimeZone(testDate, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_PACIFIC.getOffset());
		
		DateTime expectedTestDate = new DateTime(2015,12,31,21,00,00);
		
		assertEquals(newTestDate.toString(), expectedTestDate.toString());


		
	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime startDate = new DateTime(2018,05,14,15,25,40);
		DateTime endDate = new DateTime(2018,05,17,15,25,40);
		Set<Participant> participant = null;
		
		Place place = new Place("london", 1.2323, 1.2424, 234.3243);
		
		Event event = new Event("fotboll", startDate, endDate, participant, place);
		Event newEvent = shiftEventTimeZone(event, TimeZone.HAWAII, TimeZone.ALASKA);
		
		
		DateTime startDate2 = new DateTime(2018,05,14,16,25,40);
		DateTime endDate2 = new DateTime(2018,05,17,16,25,40);
		Event expectedEvent = new Event("fotboll", startDate2, endDate2, participant, place);
		
		
		assertEquals(newEvent.getStartDate().toString(), expectedEvent.getStartDate().toString());
		assertEquals(newEvent.getEndDate().toString(), expectedEvent.getEndDate().toString());

	}

}
