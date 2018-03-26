package Automation;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;


import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppTest {

	@Test
	public void test()throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		File f= new File("src");
	     File fs= new File(f,"Raaga.apk");
	     
	    DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TestEmu");
	    cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	    AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	    Thread.sleep(4000);
	    
		
		//AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction t=new TouchAction(driver);
		
		
		
		driver.findElementByAndroidUIAutomator("text(\"LATER\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Done\")").click();
		driver.findElementByXPath("//android.widget.TextView[@text='or Skip to Raaga']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/music_home_raaga_live\"))");
		driver.findElementById("com.raaga.android:id/music_home_raaga_live").click();
		driver.findElementById("com.raaga.android:id/toolbar_logo").click();
		driver.findElementById("com.raaga.android:id/menu_settings_btn").click();
		//driver.findElementByAndroidUIAutomator("text(\"Push Notification\")").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Push Notification']").click();
		
		
		//Toggle on and off for the push notification 
		Point point= driver.findElementById("com.raaga.android:id/toggle_notifyrecommend").getLocation();
		
		//Toggle On
		t.tap(point.x+20, point.y+30).perform();
		//Toggle Off
		t.tap(point.x+80, point.y+30).perform();
		
		
		
		
		
		

	}

}
