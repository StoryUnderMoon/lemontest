package utils.appInstaller;

import java.io.*;

public class ShellCmdExecuter {
    public static BufferedReader execute(String cmd){
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        if(process != null) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        }
        return br;
    }
}
