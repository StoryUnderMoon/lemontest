package page.launcher.fingertips;

import base.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class Index extends BasePage {
    public AndroidElement button_back = find(MobileBy.id("com.baidu.duer.aieye.fingertips:id/fingertip_loading_back"));

    public Index(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void click_backButton(){
        button_back.click();
    }

}
