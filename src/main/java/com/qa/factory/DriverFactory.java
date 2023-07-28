package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//this class is for initialising the driver and returning it.
//this class will also help in parallel runs because we will use the concept of threadlocal.
//thread local is java 8 feature.
public class DriverFactory {

	public WebDriver driver;
	// we want to initialize the webdriver with help of threadlocal so we pass
	// WebDriver as generics.
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	// pass the browser and webdriver will open that browser.
	// this method should also return webdriver.
	/**
	 * this method is used to initialize the threadlocal driver on the basis of
	 * given browser.
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is" + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// tl will give set and get method.
			// here chrome driver object is created and it is set with thread local driver.
			// local copy of chrome driver object is created and assigned to one thread.
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			// for safari there is no binary so no web driver manager.
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("please pass the correct browser" + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

//get the driver.
	// this will return the threadlocal instance.
	// threadlocal has different browsers that driver will invoke.
	// we are writing synchronized because multiple threads will call this method at
	// same time.
	/**
	 * this is used to get the driver with thread local.
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}