package utils.appInstaller;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class Producer implements Runnable {

    public AndroidDriver<AndroidElement> driver;
    public String device;

    public Producer(String device) {
        this.device = device;

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", device);
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.wyt.appstore_baidu");
        caps.setCapability("appActivity", "com.wyt.appstore_baidu.main.MainActivity");
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<AndroidElement>(caps);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(By.id("com.wyt.appstore_baidu:id/search")).click();
    }

    public void run() {
        while(!AppInstaller.packageMapList.get(device).isEmpty()){
            while(AppInstaller.instAppListMap.get(device).size() < 3){
                Iterator<Map.Entry<String, String>> it = AppInstaller.packageMapList.get(device).entrySet().iterator();
                Map.Entry entry = it.next();
                String appName = entry.getKey().toString();
                String packageName = entry.getValue().toString();
                //如果应用已安装则不再安装
                BufferedReader br = ShellCmdExecuter.execute("adb -s " + device + " shell pm list packages | grep " + packageName);
                String line = null;
                try {
                    line = br.readLine();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (line != null){
                    System.out.println("!!!!!!!!!! -> " + appName + " 应用已安装");
                    it.remove();
                    continue;
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.findElement(By.id("com.wyt.appstore_baidu:id/et")).sendKeys(appName);
                driver.findElement(By.id("com.wyt.appstore_baidu:id/search")).click();
                // 从应用商店搜索应用并下载
                try {
                    driver.findElement(By.xpath("//android.widget.TextView[@text='" + appName + "']/following::android.widget.TextView[@resource-id='com.wyt.appstore_baidu:id/bt']")).click();
//                    driver.findElement(By.xpath("//android.widget.TextView[@text='" + appName + "']/following::android.widget.TextView[@text='下载中']"));
                } catch (NotFoundException e){
                    System.out.println("!!!!!!!!!! -> 未找到要下载的应用：" + appName);
                    it.remove();
                    continue;
                }
                it.remove();
                AppInstaller.instAppListMap.get(device).add(packageName);
                System.out.println("!!!!!!!!!! -> " + AppInstaller.instAppListMap.get(device));
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        AppInstaller.producerList.remove(device);
        System.out.println("!!!!!!!!!!!!! -> producer线程退出");
    }
}
