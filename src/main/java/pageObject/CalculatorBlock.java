package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorBlock {

	public WebDriver driver;

	@FindBy(id = "key-0")
	private WebElement num0;
	@FindBy(id = "key-1")
	private WebElement num1;
	@FindBy(id = "key-2")
	private WebElement num2;
	@FindBy(id = "key-3")
	private WebElement num3;
	@FindBy(id = "key-4")
	private WebElement num4;
	@FindBy(id = "key-5")
	private WebElement num5;
	@FindBy(id = "key-6")
	private WebElement num6;
	@FindBy(id = "key-7")
	private WebElement num7;
	@FindBy(id = "key-8")
	private WebElement num8;
	@FindBy(id = "key-9")
	private WebElement num9;
	@FindBy(id = "sign-multiply")
	private WebElement multiply;
	@FindBy(id = "sign-minus")
	private WebElement minus;
	@FindBy(id = "sign-divide")
	private WebElement divide;
	@FindBy(id = "sign-equal")
	private WebElement equal;
	@FindBy(id = "sign-clear")
	private WebElement clear;
	@FindBy(id = "sign-plus")
	private WebElement plus;
	@FindBy(id = "sign-decimal")
	private WebElement decimal;
	@FindBy(id = "output")
	private WebElement output;

	public CalculatorBlock(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public String GetTextResult() throws InterruptedException {
		equal.click();
		Thread.sleep(5000);
		return output.getAttribute("value");
	}

	public String Output() throws InterruptedException {

		Thread.sleep(5000);
		return output.getAttribute("value");
	}

	public void ClickWholeEquation(String equation) {
		// todo: filter only acceptable chars
		for (char character : equation.toCharArray())

		{
			// System.out.println(character);
			ClickElement(character);
		}

	}

	public void ClickElement(char character) {
		// Without explicit char parsing, it should be faster.
		WebElement element = null;

		switch (character) {

		case '0':
			element = num0;
			break;

		case '1':
			element = num1;
			break;

		case '2':
			element = num2;
			break;

		case '3':
			element = num3;
			break;

		case '4':
			element = num4;
			break;

		case '5':
			element = num5;
			break;

		case '6':
			element = num6;
			break;

		case '7':
			element = num7;
			break;

		case '8':
			element = num8;
			break;

		case '9':
			element = num9;
			break;

		case '-':
			element = minus;
			break;

		case '.':
			element = decimal;
			break;

		case '/':
			element = divide;
			break;

		case '=':
			element = equal;
			break;
		case '+':
			element = plus;
			break;
		case 'X':
			element = multiply;
			break;
		case 'C':
			element = clear;
			break;

		default:
			throw new Error("Invalid char found");

		}
		element.click();
	}

}
