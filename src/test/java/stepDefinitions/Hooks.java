package stepDefinitions;

import base.BaseUtil;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utils.configFileUtils.getCurrentDirectory;
import static utils.configFileUtils.getProperty;
import static utils.dateUtils.getCurrentDateAndTime;

public class Hooks extends BaseUtil
{

    private BaseUtil base;
    private String imagesDirectory;


    public Hooks (BaseUtil base) {
        this.base = base;
        imagesDirectory = String.format("%s/%s", getCurrentDirectory(), "images");
    }

    @Before
    public void beforeScenario(Scenario scenario) {

        try {
            setBrowser();
            openBrowser();


        } catch(Throwable e) {

            System.out.println(e.getCause());
        }
    }
    @After
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {

            try {

                takeSnapShot(scenario.getName());

            } catch (Exception e) {

                System.out.println(e.getCause());
            }
        }

        base.driver.quit();
    }

    private void takeSnapShot(String scenarioName) throws IOException {

        System.out.println(imagesDirectory);
        TakesScreenshot scrShot =((TakesScreenshot) base.driver);

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        String filePath = String.format("%s/%s%s.png", imagesDirectory, scenarioName, getCurrentDateAndTime());
        File DestFile = new File(filePath);

        FileHandler.copy(SrcFile, DestFile);
    }


    public void setBrowser() throws Exception {

        String browserType = getProperty("browser");
        String os = System.getProperty("os.name").toLowerCase();
        String driverType;
        String driverName;

        if (browserType.equalsIgnoreCase("chrome")) {

            driverName = "webdriver.chrome.driver";

            if (os.contains("mac")) {

                driverType = getDriver(browserType);

            } else {

                driverType = getDriverWindow(browserType);
            }

            System.setProperty(driverName, getSystemPropertyValue() + driverType);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            base.driver = new ChromeDriver(options);

        } else if (browserType.equalsIgnoreCase("firefox")) {

            driverName = "webdriver.gecko.driver";

            if (os.contains("mac")) {

                driverType = getDriver(browserType);

            } else {

                driverType = getDriverWindow(browserType);
            }

            System.setProperty(driverName, getSystemPropertyValue() + driverType);
            base.driver = new FirefoxDriver();
        }

        else {

            throw new Exception("Invalid Browser type : " + browserType);
        }
    }

    public void openBrowser() {

        base.driver.manage().window().setSize(new Dimension(1280, 800));
        base.driver.manage().deleteAllCookies();
        String url = getProperty("url");
        base.driver.navigate().to(url);
    }

    private String getSystemPropertyValue() throws IOException {

        String currentDir = new java.io.File(".").getCanonicalPath();
        String pathSeparator = File.separator;
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {

            return String.format("%s%ssrc%smain%sresources%sdrivers%sios%s",
                    currentDir, pathSeparator, pathSeparator, pathSeparator, pathSeparator, pathSeparator,pathSeparator);

        } else if (os.contains("win")) {

            return String.format("%s%ssrc%smain%sresources%sdrivers%swindows%s",
                    currentDir, pathSeparator, pathSeparator, pathSeparator, pathSeparator, pathSeparator,pathSeparator);

        } else {

            return String.format("%s%ssrc%smain%sresources%sdrivers%slinux%s",
                    currentDir, pathSeparator, pathSeparator, pathSeparator, pathSeparator, pathSeparator, pathSeparator);
        }

    }


    private String getDriver(String driverName) {

        Map<String, String> driverExe = new HashMap<>();

        driverExe.put("chrome", "chromedriver");
        driverExe.put("firefox", "geckodriver");

        return driverExe.get(driverName);
    }

    private String getDriverWindow(String driverName) {

        Map<String, String> driverExe = new HashMap<>();

        driverExe.put("chrome", "chromedriver.exe");
        driverExe.put("firefox", "geckodriver.exe");

        return driverExe.get(driverName);
    }
}
