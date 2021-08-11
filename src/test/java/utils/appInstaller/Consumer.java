package utils.appInstaller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class Consumer implements Runnable {
    String device;

    public Consumer(String device){
        this.device = device;
    }
    public void run() {
        while(!AppInstaller.packageMapList.get(device).isEmpty()) {

            while (!AppInstaller.instAppListMap.get(device).isEmpty()) {
                Iterator<String> it = AppInstaller.instAppListMap.get(device).iterator();
                if (it.hasNext()) {
                    String packageName = it.next();
                    BufferedReader br = ShellCmdExecuter.execute("adb -s " + device + " shell pm list packages | grep " + packageName);
                    String line = null;
                    try {
                        line = br.readLine();
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (line != null) {
                        AppInstaller.instAppListMap.get(device).remove(packageName);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        AppInstaller.consumerList.remove(device);
        System.out.println("!!!!!!!!!!!!! -> consumer线程退出");
    }
}
