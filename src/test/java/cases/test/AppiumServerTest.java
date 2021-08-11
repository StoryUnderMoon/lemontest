package cases.test;


import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServerTest {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

        service.start();

        Thread.sleep(10000);

        service.stop();
    }


}
