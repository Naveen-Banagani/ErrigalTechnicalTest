package Acacemy;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.CalculatorBlock;
import resources.base;

public class DivisionTests extends base {

	public WebDriver driver;
	CalculatorBlock calculatorBlock;

	@BeforeTest
	public void initialization() throws IOException {
		driver = Initializebrowser();
		calculatorBlock = new CalculatorBlock(driver);
		

	}

	@Test
	public void DivideAscendRangeAndDescendRange() throws InterruptedException {

		calculatorBlock.ClickWholeEquation("12345/67890");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "0.1818382677861246");
	}

	@Test
	public void DivideMorethanTwoNumbers() throws InterruptedException {

		calculatorBlock.ClickWholeEquation("143/4/3");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "11.916666666766666");
	}

	@Test()
	public void DivideZeroAndZero() {
		calculatorBlock.ClickWholeEquation("0/0");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "\"NaN\"");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void DivideZeroAndOne() {
		calculatorBlock.ClickWholeEquation("0/1");
		try {
			Assert.assertEquals(calculatorBlock.GetTextResult(), "0");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void DivideOneAndZero() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("1/0");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "\"Infinity\"");
	}

	@Test(description = "Divideition test of zero and minus one")
	public void DivideNegativeandPostiveNumbers() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("-7/+5");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "-1.4");
	}

	@Test(description = "Divideition test of zero and minus one")
	public void DivideDecimalTwoPointTwoMinusOne() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("2.25/5");
		Assert.assertEquals(calculatorBlock.GetTextResult(), "0.45");
	}

	@AfterTest
	public void Teardown() {
		driver.close();
	}

}
