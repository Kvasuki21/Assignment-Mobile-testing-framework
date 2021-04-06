package Appium.practiseassignment;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Appium.practiseassignment.Capability;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class Demo extends Capability {

	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /f /im node.exe");
		Thread.sleep(3000);
		
	}
	
	@Test
	public void test() throws InterruptedException, IOException
	{
		service = startserver();
		Thread.sleep(8000);
		driver=capabilities(apppackage,appactivity,devicename,platformname,chromedriver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		Thread.sleep(3000);
		driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("vasukik21@gmail.com");
		driver.findElementByAccessibilityId("Password").sendKeys("vasukik21");
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("Sign in").click();
		Thread.sleep(2000);
		driver.findElements(By.className("android.widget.ImageView")).get(0).click();
		String actualname= "K Vasuki";
		Thread.sleep(2000);
		String name = driver.findElements(By.className("android.widget.TextView")).get(1).getText();
		Assert.assertEquals(actualname, name);
		
		 
	}
	@Test
	public void test1() throws InterruptedException
	{
		driver.navigate().back();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.view.ViewGroup\")).scrollIntoView(new UiSelector().textMatches(\"Edit\"))");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Edit\")")).click();
		Thread.sleep(2000);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"org.khanacademy.android:id/content_root\")).scrollIntoView(new UiSelector().textMatches(\"Early math\"))");
		int prod = driver.findElements(By.className("android.widget.Button")).size();
		System.out.println(prod);
        for(int i=0;i<prod;i++)
        {
        	String prodname=driver.findElements(By.className("android.widget.TextView")).get(i).getText();
        	System.out.print(prodname);
        	if(prodname.equals("Early math"))
        	{
        		driver.findElements(By.className("android.widget.TextView")).get(i).click();
        		break;
        	}
        }
//		//Clicking on done button
        int buttonsize = driver.findElements(By.className("android.widget.TextView")).size();
		System.out.println(buttonsize);
        for(int i=0;i<buttonsize;i++)
        {
        	String buttonname=driver.findElements(By.className("android.widget.TextView")).get(i).getText();
        	System.out.print(buttonname);
        	if(buttonname.equals("Done"))
        	{
        		driver.findElements(By.className("android.widget.TextView")).get(i).click();
        		Thread.sleep(5000);
        		break;
        	}
        }
        //Checking added or not
        int prod1 = driver.findElements(By.className("android.widget.Button")).size();
		System.out.println(prod1);
        for(int i=0;i<prod1;i++)
        {
        	String prodname=driver.findElements(By.className("android.widget.TextView")).get(i).getText();
        	System.out.print(prodname);
        	if(prodname.equals("Early math"))
        	{
//        		driver.findElements(By.className("android.widget.TextView")).get(i).click();
        		Assert.assertEquals(prodname, "Early math");
        		System.out.println("Added");
        		break;
        	}
        }
        
        //driver.navigate().back();
	}
	@Test
	public void test2() throws InterruptedException
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.view.ViewGroup\")).scrollIntoView(new UiSelector().textMatches(\"Edit\"))");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Edit\")")).click();
		Thread.sleep(2000);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"org.khanacademy.android:id/content_root\")).scrollIntoView(new UiSelector().textMatches(\"Early math\"))");
		int prod = driver.findElements(By.className("android.widget.Button")).size();
		System.out.println(prod);
        for(int i=0;i<prod;i++)
        {
        	String prodname=driver.findElements(By.className("android.widget.TextView")).get(i).getText();
        	System.out.print(prodname);
        	if(prodname.equals("Early math"))
        	{
        		driver.findElements(By.className("android.widget.TextView")).get(i).click();
        		break;
        	}
        }
        
      //Clicking on done button
        int buttonsize = driver.findElements(By.className("android.widget.TextView")).size();
		System.out.println(buttonsize);
        for(int i=0;i<buttonsize;i++)
        {
        	String buttonname=driver.findElements(By.className("android.widget.TextView")).get(i).getText();
        	System.out.print(buttonname);
        	if(buttonname.equals("Done"))
        	{
        		driver.findElements(By.className("android.widget.TextView")).get(i).click();
        		Thread.sleep(5000);
        		break;
        	}
        }
      
	}
	
	@Test
	public void test3() throws InterruptedException
	{
		driver.findElements(By.className("android.widget.ImageView")).get(0).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign out\")")).click();
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(3000);
		boolean sign = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).isDisplayed();
		System.out.println(sign);
		Assert.assertEquals(true,sign);
	}
	@Test
	public void test4() throws InterruptedException
	{
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Terms of service\")")).click();
		driver.findElement(By.id("android:id/title")).click();
		driver.findElement(By.id("android:id/button_once")).click();
		
		Thread.sleep(8000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
//		driver.context("WEBVIEW_chrome");
//		driver.context("WEBVIEW_org.khanacademy.android");
//		WebElement check = driver.findElement(By.id("com.android.chrome:id/url_bar"));
//		TouchAction t = new TouchAction(driver);
//		t.tap(tapOptions().withElement(element(check))).perform();
		driver.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys("IBM",Keys.ENTER);
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
//		driver.context("NATIVE_APP");
	}
	
}
