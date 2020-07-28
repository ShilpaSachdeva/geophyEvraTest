package utils;

import java.util.ResourceBundle;

public class configFileUtils {

	public static String getCurrentDirectory() {

		return System.getProperty("user.dir");
	}

	public static String getProperty(String type) {

		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb.getString(type);
	}

}
