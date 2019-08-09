package acorntest.com.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; // 리눅스에서 사용

import oracle.net.aso.d;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlertExampleTest {
	static WebDriver driver;
	private String url =
			"http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
	
	@BeforeClass
	public static void setupTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void AlertExampleTest() {
		driver.navigate().to(url); // 주소로 이동
		driver.manage().window().maximize(); //창을 최대크기로 키움
		driver.switchTo().frame("iframeResult");
		
		// 웹 요소를 가리킬수 있도록 셀레니움에서 생성된 객체
		// docuent 
		// id, css, 
		WebElement alertButton = driver.findElement(By.cssSelector("html>body>button"));
		alertButton.click(); // 이벤트 호출
		
		String expectedAlertMessage = "I am an alert Box!";
		String actualAlertMessage = driver.switchTo().alert().getText();
		assertThat(expectedAlertMessage, is(actualAlertMessage));
		driver.switchTo().alert().accept();
	}
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}
	
	

}











