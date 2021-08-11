package utils.appInstaller;

import base.BaseDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

public class AppInstaller {

    public static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
    public static List<String> deviceList = new ArrayList<String>(); // 设备sn列表
    public static FileInputStream fis = null; // 应用文件
    public static Map<String, Map<String, String>> packageMapList = new HashMap<String, Map<String, String>>();
    public static Map<String, List<String>> instAppListMap = new HashMap<String, List<String>>();
    public static List<String> producerList = new ArrayList<String>();
    public static List<String> consumerList = new ArrayList<String>();

    public static void main(String[] args) throws InterruptedException {
        service.start();
        packageMapList.put("origin", new HashMap<String, String>());
        // 初始化设备列表&应用列表文件
        try {
            fis = new FileInputStream(args[args.length - 1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (args.length < 2) {
            System.out.println("缺少参数！！");
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                deviceList.add(args[i]);
            }
        }

        // 从excel中读取要安装的应用
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= 50; i++) {
            Row row = null;
            row = sheet.getRow(i);
            Cell appNameCell = row.getCell(1);
            appNameCell.setCellType(CellType.STRING);
            String appName = appNameCell.getStringCellValue(); // 应用名
            Cell packageNameCell = row.getCell(2);
            packageNameCell.setCellType(CellType.STRING);
            String packageName = packageNameCell.getStringCellValue(); // 包名
            packageMapList.get("origin").put(appName, packageName);
        }

        for (String device : deviceList) {
            instAppListMap.put(device, new ArrayList<String>());
            packageMapList.put(device, packageMapList.get("origin"));

            Thread producer = new Thread(new Producer(device));
            producer.start();
            producerList.add(device);

            Thread consumer = new Thread(new Consumer(device));
            consumer.start();
            consumerList.add(device);
        }

        while(!producerList.isEmpty() || !consumerList.isEmpty()){
            Thread.sleep(5000);
        }
        service.stop();
    }
}
