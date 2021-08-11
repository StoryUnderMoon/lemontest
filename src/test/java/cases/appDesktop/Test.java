package cases.appDesktop;

import cases.BaseSteps;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import page.launcher.desktop.AppDesktop;

import java.util.Random;

public class Test extends BaseSteps {

    @org.testng.annotations.Test
    public void randomTest() throws InterruptedException {
        AppDesktop appDesktop = new AppDesktop(driver);
        try{
            driver.findElement(By.id("com.baidu.launcher:id/tv_cancel")).click();
        } catch (NoSuchElementException e){
            System.out.println("未发现usb连接弹窗");
        }
        Thread.sleep(2000);
        appDesktop.query("我的应用");
        Thread.sleep(2000);
        try {
        while(true){
            Random random = new Random();
            int key = random.nextInt(4);
            switch (key) {
                case 0: //切换到学生模式
                    appDesktop.switchToStudentModule();
                    Thread.sleep(2000);
                    appDesktop.query("我的应用");

                case 1: //切换到家长模式
                    appDesktop.switchToParentsModule();
                    Thread.sleep(2000);

                case 2: //随机移动应用
                    appDesktop.randMoveApp();

                case 3: //随机打开应用，等待5s后退出
                    appDesktop.randOpenApp();
                    Thread.sleep(15000);
                    appDesktop.query("回首页");
                    Thread.sleep(2000);
                    try {
                        appDesktop.find(By.id("com.baidu.launcher:id/my_application"));
                    } catch (NoSuchElementException e) {
                        appDesktop.query("我的应用");
                        Thread.sleep(2000);
                    }

                case 4: //随机左右滑动页面
                    try {
                        AndroidElement container = appDesktop.find(By.id("//com.baidu.launcher:id/workspace_page_container"));
                        if (container.getAttribute("index").equals("0")) {
                            appDesktop.leftSlide();
                        } else {
                            appDesktop.rightSlide();
                        }
                    } catch (NoSuchElementException e) {
                        appDesktop.query("回首页");
                        Thread.sleep(2000);
                        try {
                            appDesktop.find(By.id("com.baidu.launcher:id/my_application"));
                        } catch (NoSuchElementException f) {
                            appDesktop.query("我的应用");
                            Thread.sleep(2000);
                        }
                    }

                }
            }
        } catch (Exception g){
            appDesktop.query("回首页");
            Thread.sleep(2000);
            try {
                appDesktop.find(By.id("com.baidu.launcher:id/my_application"));
            } catch (NoSuchElementException e) {
                appDesktop.query("我的应用");
                Thread.sleep(2000);
            }
        }
    }
}
