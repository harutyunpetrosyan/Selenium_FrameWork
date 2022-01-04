package helper.browserConfiguration.config;

import helper.resource.ResourceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author
 */
public class PropertyReader {

    public static Properties OR;
    private static FileInputStream file;

    static {
        try {
            String filePath = ResourceHelper.getResourcePath("src/main/resources/configfile/config.properties");
            file = new FileInputStream(new File(filePath));
            OR = new Properties();
            OR.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getImpliciteWait() {
        return Integer.parseInt(OR.getProperty("implicitwait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(OR.getProperty("explicitwait"));
    }

    public static int getPageLoadTime() {
        return Integer.parseInt(OR.getProperty("pageloadtime"));
    }

    public static String getBrowserType() {
        if (System.getProperty("browserType") != null) {
            return System.getProperty("browserType");
        }
        return (OR.getProperty("browserType"));
    }

    public static String getUserName() {
        if (System.getProperty("userName") != null) {
            return System.getProperty("userName");
        }
        return OR.getProperty("userName");
    }

    public static String getPassword() {
        if (System.getProperty("password") != null) {
            return System.getProperty("password");
        }
        return OR.getProperty("password");
    }

    public static String getUrl() {
        if (System.getProperty("url") != null) {
            return System.getProperty("url");
        }
        return OR.getProperty("applicationUrl");
    }

}
