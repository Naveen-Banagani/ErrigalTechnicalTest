package Acacemy;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.CalculatorBlock;
import resources.base;

public class DifferentOperations extends base { // Extending the base class here to initialize the browser

	public WebDriver driver;
	CalculatorBlock calculatorBlock;

	@BeforeTest
	// Initializing the browser from base page
	public void initialization() throws IOException {
		driver = Initializebrowser();
		calculatorBlock = new CalculatorBlock(driver);

	}

	@Test
	public void AdditionSubtraction() throws InterruptedException {
		// Adding two  numbers and Subtract with another number
		calculatorBlock.ClickWholeEquation("123+321-90");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "354.0");

	}

	@Test
	public void AddTwoNmmbersandSubtractiongivesSevenDigitResult() throws InterruptedException {
		// Adding two big numbers and subtracting with another 7 digit number to get Seven Digit Result (Because if the result is
		// seven digit number,
		// it wont add (0.0000000001) to the result).
		calculatorBlock.ClickWholeEquation("2323232+3232323-1111111");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "4444444.0");
	}

	@Test
	public void AddMultiply() throws InterruptedException {
		// Adding two number, multiply with one number 
		calculatorBlock.ClickWholeEquation("6+2X3");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "12.0");
	}
	@Test
	public void AddMultiply2() throws InterruptedException {
		// Adding two big numbers and multiply with another big number 
		calculatorBlock.ClickWholeEquation("3232323+1212121*212121");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "2.57119550964E11");
	}

	@Test()
	public void AddDivision() {
		// Add two number and divide with another number
		calculatorBlock.ClickWholeEquation("12+6/2");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "15.0");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void MultiplyDivision() throws InterruptedException {
		// Multiply two big numbers and divide with another big number 
		calculatorBlock.ClickWholeEquation("32323232X121212/212121");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "18470418.2857");
	}

	
	

	@AfterTest
	//Close the Browser after all the Tests ran
	public void Teardown() {
		driver.close();
	}

}
