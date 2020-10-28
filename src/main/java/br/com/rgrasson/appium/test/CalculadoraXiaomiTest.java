package br.com.rgrasson.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class CalculadoraXiaomiTest {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "61f988a3");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.miui.calculator");
		desiredCapabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

		

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		
		MobileElement el0 = (MobileElement) driver.findElementById("android:id/button1");
	    el0.click();
		MobileElement el1 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("adição");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
	    el3.click();

	    MobileElement el4 = (MobileElement) driver.findElementById("com.miui.calculator:id/result");
	    Assert.assertEquals("4", el4.getText());

		driver.quit();
	}
}
