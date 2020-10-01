package actionsonjqueryui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShotDemo {
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
	public void takeScreenshotofpage() throws IOException {
	
		TakesScreenshot shot = (TakesScreenshot)driver;
		File sourceoutputfile = shot.getScreenshotAs(OutputType.FILE);
		
		//File sourceOutputFile;
		
		
		FileUtils.copyFile(sourceoutputfile, new File("./Screenshot/fullpage/png"));
		//if showing error here search in google which library require for Fileutils ?
		//ans: Apache Commons IO
		// go to https://search.maven.org/search?q=g:commons-io and search Commons IO dowload it and add external jar in project
		}
	@Test
	public void webElementScreenshot() throws IOException, InterruptedException {
		WebElement draggable = driver.findElement(By.xpath("//a[text()='Draggable']"));
		
		if(draggable.isDisplayed()) {
			if(draggable.isEnabled()) {
			File draggablebox =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			BufferedImage buffImage = ImageIO.read(draggablebox);
			//Now i need a location of my WebElment
			Point elementlocation = draggable.getLocation();
			
			//How to get Height and width of any WebElemnt
			int elementHeight = draggable.getSize().getHeight();
			int elemntWidth = draggable.getSize().getWidth();
			int elementX = elementlocation.getX();
			int elementY = elementlocation.getY();
			System.out.println(elementHeight);
			System.out.println(elemntWidth);
			System.out.println(elementX);
			System.out.println(elementY);
			
			BufferedImage eleFinal = buffImage.getSubimage(elementX, elementY, elemntWidth, elementHeight);
			ImageIO.write(eleFinal, "png", draggablebox);
		
			FileUtils.copyFile(draggablebox, new File("./Screenshot/webElement.png"));
			Thread.sleep(4000);
			
			}
		}
	
}
}
