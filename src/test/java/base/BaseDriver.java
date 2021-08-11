package base;

import cases.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseDriver {
    public static Logger logger = Logger.getLogger(BaseDriver.class);

    public static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    public static void setLogFileName(String deviceName){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String logFileName = sdf.format(date) + deviceName;
        System.setProperty("logfilename", logFileName);
        sdf.applyPattern("yyyy_MM_dd");
        String logDirName = sdf.format(date);
        System.setProperty("logdirname", logDirName);
    }

    public static AndroidDriver<AndroidElement> getAndroidDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", Constants.DEVICENAME);
        caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.baidu.launcher");
        caps.setCapability("appActivity", "com.baidu.duer.home.activity.LauncherActivity");
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(new URL(Constants.APPURL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
