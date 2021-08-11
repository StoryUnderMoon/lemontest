package page.launcher.desktop;

import base.BasePage;
import element.DescElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import page.launcher.unlock.CypherUnlock;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppDesktop extends BasePage {
    public AppDesktop(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public ArrayList<Point> allCenterList = new ArrayList<Point>(){{
        add(new Point(160,307));add(new Point(480,307));add(new Point(800,307));add(new Point(1120,307));add(new Point(1440,307));add(new Point(1760,307));
        add(new Point(160,541));add(new Point(480,541));add(new Point(800,541));add(new Point(1120,541));add(new Point(1440,541));add(new Point(1760,541));
        add(new Point(160,658));add(new Point(480,775));add(new Point(800,775));add(new Point(1120,775));add(new Point(1440,775));add(new Point(1760,775));
        add(new Point(160,1009));add(new Point(480,1009));add(new Point(800,1009));add(new Point(1120,1009));add(new Point(1440,1009));add(new Point(1760,1009));
    }};


    // 页面元素
    public DescElement icon_list = new DescElement("应用icon列表", MobileBy.xpath("//android.view.ViewGroup[@resource-id='com.baidu.launcher:id/workspace_page_container']/android.widget.TextView"));
    public DescElement folder_list = new DescElement("文件夹icon列表", MobileBy.xpath("//android.view.ViewGroup[@resource-id='com.baidu.launcher:id/workspace_page_container']/android.widget.FrameLayout"));

    public ArrayList<Point> getAppCenterList(){
        ArrayList<AndroidElement> elements = finds(icon_list.getBy());
        ArrayList<Point> appCenters = new ArrayList<Point>();
        for(AndroidElement element : elements){
            appCenters.add(element.getCenter());
        }
        return appCenters;
    }

    public ArrayList<Point> getBlankCenterList(){
        ArrayList<Point> blankCenterList = allCenterList;
        blankCenterList.removeAll(getAppCenterList());
        return blankCenterList;
    }

    public void randMoveApp() throws InterruptedException {
        Random random = new Random();
        ArrayList<AndroidElement> elements = finds(icon_list.getBy());
        Point randomSelectedBlankCenter = getBlankCenterList().get(random.nextInt(getBlankCenterList().size() - 1));
        AndroidElement randomSelectedElement = elements.get(random.nextInt(elements.size()-1));

        ElementOption elementOption = new ElementOption();
        elementOption.withElement(randomSelectedElement);
        elementOption.build();
        Duration duration = Duration.ofSeconds(2);
        LongPressOptions longPressOptions = new LongPressOptions();
        longPressOptions.withDuration(duration);
        longPressOptions.withElement(elementOption);
        longPressOptions.build();
        PointOption<ElementOption> pointOption = new PointOption<>();
        pointOption.withCoordinates(randomSelectedBlankCenter);
        pointOption.build();
        WaitOptions waitOptions = new WaitOptions();
        waitOptions.withDuration(duration);
        waitOptions.build();
        AndroidTouchAction action = new AndroidTouchAction(driver);
        action.longPress(longPressOptions).moveTo(pointOption).release().waitAction(waitOptions).perform();
    }

    public void randOpenApp() {
        ArrayList<AndroidElement> elements = finds(icon_list.getBy());
        Random random = new Random();
        elements.get(random.nextInt(elements.size()-1)).click();
    }

    public void switchToStudentModule(){
        query("学生模式");
    }

    public void switchToParentsModule(){
        query("家长模式");
        try{
            new CypherUnlock(driver).inputUnlockCypher();
        } catch (NoSuchElementException e){
            System.out.print("");
        }
    }
}
