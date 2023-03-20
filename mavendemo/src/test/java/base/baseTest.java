package base;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public static Properties loc = new Properties();
	public static FileReader fr1;


	@BeforeTest
	public void setUp() throws IOException {
		if (driver == null) {
		 fr = new FileReader(
					System.getProperty("user.dir") + "\\\\src\\\\test\\\\resources\\\\configfiles\\\\config.properties");
			prop.load(fr);
			
		 fr1 = new FileReader(
					System.getProperty("user.dir") + "\\\\src\\\\test\\\\resources\\\\configfiles\\\\locators.properties");
			loc.load(fr1);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");

			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver(option);

			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("TearDown successfully");
	}

}
