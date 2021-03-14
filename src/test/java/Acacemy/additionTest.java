package Acacemy;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.CalculatorBlock;
import resources.base;

public class additionTest extends base { // Extending the base class here to initialize the browser

	public WebDriver driver;
	CalculatorBlock calculatorBlock;

	@BeforeTest
	// Initializing the browser from base page
	public void initialization() throws IOException {
		driver = Initializebrowser();
		calculatorBlock = new CalculatorBlock(driver);

	}

	@Test
	public void AddAscendRangeAndDescendRange() throws InterruptedException {
		// Adding two big numbers
		calculatorBlock.ClickWholeEquation("12345+67890");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "80235.0");

	}

	@Test
	public void AddNmmbersgivesSevenDigitResult() throws InterruptedException {
		// Adding two big numbers to get Seven Digit Result (Because if the result is
		// seven digit number,
		// it wont add (0.0000000001) to the result).
		calculatorBlock.ClickWholeEquation("2323232+3232323");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "5555555.0");
	}

	@Test
	public void AddBigNumberandOne() throws InterruptedException {
		// Adding a big numbers and 1
		
		Assert.assertEquals(calculatorBlock.GetTextResult(), "8989899.0");
	}
	@Test
	public void AddTwoBigNumbers() throws InterruptedException {
		// Adding two big numbers 
		calculatorBlock.ClickWholeEquation("628628628+306306306");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "9.34934934E8");
	}

	@Test()
	public void AddZeroAndZero() {
		// Add two Zeroes
		calculatorBlock.ClickWholeEquation("0+0");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "0");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void AddZeroAndOne() {
		// Add 0 & 1
		calculatorBlock.ClickWholeEquation("0+1");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "1.0");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void AddMorethanTwoNumbers() throws InterruptedException {
		// Add more than two numbers
		calculatorBlock.ClickWholeEquation("12+6+3");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "21.0");
	}

	@Test
	public void AddTwoSingleDigits() throws InterruptedException {
		// Add two single numbers
		calculatorBlock.ClickWholeEquation("1+7");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "8.0");
	}

	@Test
	public void AddNegativeandPositiveNumbers() throws InterruptedException {
		// Add Negative and Positive Numbers
		calculatorBlock.ClickWholeEquation("-9+2");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "-7.0");
	}

	@Test
	public void AddDecimalNumbers() throws InterruptedException {
		//Adding two decimal Numbers
		calculatorBlock.ClickWholeEquation("2.13+3.21");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "5.34");
	}

	@AfterTest
	//Close the Browser after all the Tests ran
	public void Teardown() {
		driver.close();
	}

}
