import java.awt.*;
import java.awt.event.*;

public class RobotTest {
	
	static Robot myRobot = null;
	
	public static void openChrome()
	{		
		// Press and release "Windows" Key
		myRobot.keyPress(KeyEvent.VK_WINDOWS);
        myRobot.keyRelease(KeyEvent.VK_WINDOWS);
        
        myRobot.delay(100);			// delay needed for start menu to pop-up
        
        // Type "chrome" and hit enter
        type("chrome");
        hitEnter();
	}
	
	public static void goTo(String address)
	{
		type(address);
		hitEnter();
	}
	
	public static void openNewTab()
	{
		myRobot.keyPress(KeyEvent.VK_CONTROL);
		myRobot.keyPress(KeyEvent.VK_T);
        myRobot.keyRelease(KeyEvent.VK_T);
        myRobot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void hitEnter()
	{
        myRobot.keyPress(KeyEvent.VK_ENTER);
        myRobot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void pressAt()
	{
		myRobot.keyPress(KeyEvent.VK_SHIFT);
		myRobot.keyPress(KeyEvent.VK_2);
        myRobot.keyRelease(KeyEvent.VK_2);
        myRobot.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	public static void type(String word)
	{
		String upWord = word.toUpperCase();
		char[] letters = upWord.toCharArray();
		for (char letter : letters)
		{
			if (letter == '@')
			{
				pressAt();
			}
			
			else
			{
				
				myRobot.keyPress((int)letter);
				myRobot.keyRelease((int)letter);
			}
		}
	}
	
	public static void main(String[] args)
	{
		try 
		{
			myRobot = new Robot();
		}
		catch (AWTException e) 
		{
			System.out.println("Failed to create instance of Robot.");
		}
        
		openChrome();		// open Google Chrome
		myRobot.delay(2000);			// delay needed for crhome to open up
//		goTo("www.google.com");		// go to google.com
		
//		openNewTab();				// open a new tab
//		goTo("www.youtube.com");	// go to youtube.com
		
//		openNewTab();
		goTo("www.github.com/zusyed");
	}
}
