package helper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Base {

	public static WebDriver driver;
	public static Properties p;

	static {
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resources/env.properties");
			p = new Properties();
			p.load(file);

		} catch (IOException e) {

		}

	}

	@Before
	public void launchUrl() {

		String browserName = p.getProperty("browser");

		switch (browserName) {

		case "chrome":

//			ChromeOptions option = new ChromeOptions();
//			option.addArguments("-- incognito");

			driver = new ChromeDriver();
			break;

		case "ff":

			driver = new FirefoxDriver();
			break;

		}

		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@After
	public void tearDown(Scenario status) {

		if (status.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(src,
						new File(System.getProperty("user.dir") + "/Screenshots/" + status.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		driver.quit();

	}

	public WebElement waitForExpectedElement(By locator) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		return w.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void explicitWaitForElementToBeClickable(WebElement ele, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

	public void explicitWaitForElementVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void clearAndEnter(By ele, String text) {
		driver.findElement(ele).click();
		driver.findElement(ele).sendKeys(text);

	}

	public void selectValueFromText(WebElement ele, String value) {

		Select s = new Select(ele);
		s.selectByVisibleText(value);

	}

	public void selectValue(WebElement ele, String value) {

		Select s = new Select(ele);
		s.selectByValue(value);

	}

	public void selectValueFromDropDown(WebElement ele, int num) {

		Select s = new Select(ele);
		s.selectByIndex(num);

	}

	public void selectFromBootsTrapDropDown(List<WebElement> ele, String value) {

		for (WebElement e : ele) {

			String actualValue = e.getText();

			if (actualValue.equals(value)) {

				e.click();
				break;

			}

		}

	}

	public void selectWindow(String title) {

		Set<String> window = driver.getWindowHandles();

		for (String w : window) {

			driver.switchTo().window(w);
			String actualtitle = driver.getTitle();

			if (actualtitle.equals(title)) {

				break;

			}

		}
	}

	public void mouseHover(WebElement ele) {

		Actions a = new Actions(driver);

		a.moveToElement(ele).build().perform();

	}

	public void switchToFrameByName(String name) {

		driver.switchTo().frame(name);

	}

	public void switchToFrameByIndex(int num) {

		driver.switchTo().frame(num);

	}

	public void switchToDefaultContent() {

		driver.switchTo().defaultContent();

	}

	public void clickOnElement(By locator) {

		try {
			waitForExpectedElement(locator).click();
		} catch (Exception e) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("", waitForExpectedElement(locator));

		}

	}

	public void validateText(By locator, String expectedText) {

		String actualText = waitForExpectedElement(locator).getText();
		Assert.assertEquals(expectedText, actualText);
	}

}
