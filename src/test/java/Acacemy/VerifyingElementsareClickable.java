package Acacemy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObject.CalculatorBlock;

import resources.base;

public class VerifyingElementsareClickable extends base {

	public WebDriver driver;
	CalculatorBlock calculatorBlock;

	@BeforeTest

	public void initialization() throws IOException {
		driver = Initializebrowser();
		calculatorBlock = new CalculatorBlock(driver);
		calculatorBlock.ClickWholeEquation("C");

	}

	@Test
	public void number0() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("0");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "0", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "0", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number1() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("1");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "1", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "1", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number2() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("2");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "2", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "2", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number3() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("3");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "3", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "3", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number4() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("4");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "4", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "4", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number5() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("5");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "5", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "5", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number6() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("6");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "6", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "6", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number7() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("7");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "7", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "7", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number8() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("8");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "8", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "8", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void number9() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("9");
		try {
			// use IF condition to match Strings (ExpeNote1, ActeNote1)are equal
			Assert.assertEquals(calculatorBlock.Output(), "9", "PASSED");
		} catch (Exception e) {
			Assert.assertEquals(calculatorBlock.Output(), "9", "FAILED");
		} finally {
			calculatorBlock.ClickWholeEquation("C");
		}

	}

	@Test
	public void plus() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("+");
		Assert.assertEquals(calculatorBlock.Output(), "+");

		calculatorBlock.ClickWholeEquation("C");
	}

	@Test
	public void minus() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("-");
		Assert.assertEquals(calculatorBlock.Output(), "-");

		calculatorBlock.ClickWholeEquation("C");
	}

	@Test
	public void divide() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("/");
		// Assert.assertEquals(calculatorBlock.Output(), "/");
		Assert.assertTrue(calculatorBlock.Output().contains("/"));
		calculatorBlock.ClickWholeEquation("C");
	}

	@Test
	public void multiply() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("X");
		Assert.assertEquals(calculatorBlock.Output(), "x");
		calculatorBlock.ClickWholeEquation("C");
	}

	@Test
	public void clear() throws InterruptedException {
		calculatorBlock.ClickWholeEquation("C");

	}

	@AfterTest
	public void Teardown() {
		driver.close();
	}

}
