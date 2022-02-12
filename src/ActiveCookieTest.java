import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.*;
import org.junit.*;
public class ActiveCookieTest {
	private PrintStream systemOut;
	private ByteArrayOutputStream testOut;

	@Before
	public void setUpPrint() {
		testOut = new ByteArrayOutputStream();
		systemOut = System.out;
		System.setOut(new PrintStream(testOut));
	}
	@After
	public void restoreSystem() {
		System.setOut(systemOut);
	}
	@Test
	public void mostActiveCookieOne() throws Exception{
		String[] args = new String[] {
				"cookie_log.csv",
				"-d",
				"2018-12-09"				
		};
		ActiveCookie.main(args);
		assertEquals(String.format("AtY0laUfhglK3lC7%n"),testOut.toString());
	}
	@Test
	public void mostActiveCookieMultiple() throws Exception{
		String[] args = new String[] {
				"cookie_log.csv",
				"-d",
				"2018-12-08"				
		};
		ActiveCookie.main(args);
		assertEquals(String.format("fbcn5UAVanZf6UtG%nSAZuXPGUrfbcn5UA%n4sMM2LxV07bPJzwf%n"),testOut.toString());
	}
	@Test
	public void noActiveCookieFound() throws Exception{
		String[] args = new String[] {
				"cookie_log.csv",
				"-d",
				"2018-12-05"				
		};
		ActiveCookie.main(args);
		assertEquals("",testOut.toString());
	}
	/*
	@Test
	public void wrongFileNameorLocation() throws Exception{
		String[] args = new String[] {
				"cookie_log.cs",
				"-d",
				"2018-12-09"				
		};
		Exception e = assertThrows(FileNotFoundException.class,()-> ActiveCookie.main(args));
		String expectedMessage = "Could not found file in the given location or file information is incorrect";
		String actualMessage = e.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}*/
}
