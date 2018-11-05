package webdriverpackage2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exceldatadrivenpgm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Exceldataextract	Xldata=new	Exceldataextract();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		int si=Xldata.getlastrownumber("Sheet1");
		System.out.println(si);
		
		for (int i=1;i<=si;i++) {
			String un = Xldata.getexceldata("Sheet1", i, 0);
			String pw=Xldata.getexceldata("Sheet1", i, 1);
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.name("pwd")).sendKeys(pw);
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("logoutLink")).click();
			Thread.sleep(3000);
			
			
		}
		 
	
		

	}

}
