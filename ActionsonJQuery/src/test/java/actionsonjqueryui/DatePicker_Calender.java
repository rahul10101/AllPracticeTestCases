package actionsonjqueryui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker_Calender {
	static WebDriver driver;

	@BeforeMethod
	//public static void main(String[] args) {
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterMethod
	public void windowClose() {
		driver.close();
	}

	@Test
	public void clickonCalender() throws InterruptedException {
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.findElement(By.linkText("Format date")).click();
		driver.switchTo().frame(frame);
		driver.findElement(By.id("datepicker")).click();
		List<WebElement> days = driver.findElements(By.xpath("//a[@href='#']"));
		WebElement dropDown = driver.findElement(By.id("format"));
		
		Select select = new Select(dropDown);
		select.selectByValue("yy-mm-dd");
	//	select.selectByVisibleText(arg0);
	//	select.selectByIndex(index);
			
		}

	}

