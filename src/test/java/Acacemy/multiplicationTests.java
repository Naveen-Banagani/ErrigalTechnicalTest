package Acacemy;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.CalculatorBlock;
import resources.base;

public class multiplicationTests extends base {

	public WebDriver driver;
	CalculatorBlock calculatorBlock;

	@BeforeTest
	public void initialization() throws IOException {
		driver = Initializebrowser();
		calculatorBlock = new CalculatorBlock(driver);

	}

	@Test
	public void MultiplyAscendRangeAndDescendRange() throws InterruptedException {

		calculatorBlock.ClickWholeEquation("12345X67890");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "38102050.0");
	}
	@Test
	public void MultiplytwoNumbersBig() throws InterruptedException {

		calculatorBlock.ClickWholeEquation("434343X6363636");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "2.764000751148E12");
	}

	@Test
	public void MultiplyMorethanTwoNumbers() throws InterruptedException {

		calculatorBlock.ClickWholeEquation("12X6X3");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "216.0");
	}
	@Test
	public void MultiplyMorethanTwoBigNumbers() throws InterruptedException {

		calculatorBlock.ClickWholeEquation("425431X1818X8778");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "6.789199772124E12");
	}

	@Test()
	public void MultiplyZeroAndZero() {
		calculatorBlock.ClickWholeEquation("0X0");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "0");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void MultiplyZeroAndOne() {
		calculatorBlock.ClickWholeEquation("0X1");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "0");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void MultiplyOneAndZero() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("1X0");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "0");
	}

	@Test(description = "Multiplyition test of zero and minus one")
	public void MultiplyNegativeandPostiveNumbers() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("-7X+5");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "-35.0");
	}

	@Test(description = "Multiplyition test of zero and minus one")
	public void MultiplyDecimalTwoPointTwoMinusOne() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("2.25X5");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "11.25");
	}

	@AfterTest
	public void Teardown() {
		driver.close();
	}

}
