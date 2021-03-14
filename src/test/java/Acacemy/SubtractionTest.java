package Acacemy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObject.CalculatorBlock;

import resources.base;

public class SubtractionTest extends base {

	public WebDriver driver;
	CalculatorBlock calculatorBlock;

	@BeforeTest

	public void initialization() throws IOException {
		driver = Initializebrowser();
		calculatorBlock = new CalculatorBlock(driver);

	}

	@Test
	public void SubtractAscendRangeAndDescendRange() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("12345-67890");

		Assert.assertEquals(calculatorBlock.GetTextResult(), "-55545");
	}

	@Test()
	public void SubtractZeroAndZero() {
		calculatorBlock.ClickWholeEquation("1-1");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "0");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void SubtractZeroAndOne() {
		calculatorBlock.ClickWholeEquation("3-1");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void SubtractOneAndZero() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("1-7");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "-6");
	}

	@Test(description = "Subtractition test of zero and minus one")
	public void SubtractBracketsFiveAndTwo() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("-5--2");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "-7");
	}

	@Test(description = "Subtractition test of zero and minus one")
	public void SubtractDecimalTwoPointTwoMinusOne() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("2.2-1");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "3.2");
	}

	@Test
	public void SubtractMorethanTwoNumbers() throws InterruptedException {

		calculatorBlock.ClickWholeEquation("12-6-3");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "3");
	}

	@AfterTest
	public void Teardown() {
		driver.close();
	}

}
