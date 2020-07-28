package utils;

import com.geophy.evra.pages.BasePage;
import org.openqa.selenium.WebDriver;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;


public class commonUtils extends BasePage {

    public commonUtils(WebDriver driver) {

        super(driver);
    }

    public static String emailGenerator() {

        return String.format("test%s@geophy.com", getAdditionalEmailValue());
    }

    private static String getAdditionalEmailValue() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getRandomNumber(int len) {

        char[] ch = "0123456789".toCharArray();

        char[] c = new char[len];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < len; i++) {
            c[i] = ch[random.nextInt(ch.length)];
        }

        return new String(c);
    }

}
