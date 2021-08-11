package base;

import element.DescElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public static Logger logger = Logger.getLogger(BasePage.class);

    protected AndroidDriver<AndroidElement> driver = null;

    public BasePage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
    }

    public AndroidElement find(By by){
        return driver.findElement(by);
    }

    public ArrayList<AndroidElement> finds(By by) {return (ArrayList<AndroidElement>) driver.findElements(by);}

    public void click(DescElement descElement){
        find(descElement.getBy()).click();
        logger.debug("点击[" + descElement.getDesc() + "]");
    }

    public void sendkeys(DescElement descElement, String string){
        find(descElement.getBy()).sendKeys(string);
        logger.debug("输入[" + string + "]到[" + descElement.getDesc() + "]");
    }

    public void query(String directive){
        try {
            Runtime.getRuntime().exec("adb shell am broadcast -a com.baidu.duer.query -e q " + directive);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leftSlide(){
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        AndroidTouchAction leftSlide = new AndroidTouchAction(driver);
        PointOption startPoint = new PointOption().withCoordinates(width * 3 / 4, height / 2);
        PointOption endPoint = new PointOption().withCoordinates(width * 1 / 4, height / 2);
        startPoint.build();
        endPoint.build();
        leftSlide.press(startPoint).moveTo(endPoint).perform();
    }

    public void rightSlide(){
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        AndroidTouchAction rightSlide = new AndroidTouchAction(driver);
        PointOption startPoint = new PointOption().withCoordinates(width * 3 / 4, height / 2);
        PointOption endPoint = new PointOption().withCoordinates(width * 1 / 4, height / 2);
        startPoint.build();
        endPoint.build();
        rightSlide.press(startPoint).moveTo(endPoint).perform();
    }

}
