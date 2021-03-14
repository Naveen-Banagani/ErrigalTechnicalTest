package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class base {
	public WebDriver driver;
	public Properties prop = new Properties();

	public WebDriver Initializebrowser() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\navee\\eclipse-workspace\\Errigal\\src\\main\\java\\resources\\browser.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\navee\\eclipse-workspace\\Errigal\\src\\main\\java\\resources\\chromedriver.exe");
					//"C:\\Users\\navee\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		String url = prop.getProperty("url");
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports2\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
	
}
