package cases;

import base.BaseDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseSteps {
    public static AppiumDriverLocalService service = BaseDriver.service;
    public static AndroidDriver<AndroidElement> driver = null;

    @BeforeTest
    public void startAppiumService(){
        service.start();
        if(service.isRunning()){
            System.out.println("appium-service已启动");
        } else {
            throw new RuntimeException("appium-service服务启动失败！！");
        }
    }

    @BeforeMethod
    public void presets(){
        driver = BaseDriver.getAndroidDriver();
        if(driver == null){
            throw new RuntimeException("driver实例化失败！");
        }
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void postsets(){
        driver.quit();
    }

    @AfterTest
    public void stopAppiumService(){
        service.stop();
    }
}
