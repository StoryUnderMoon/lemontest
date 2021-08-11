package page.launcher.unlock;

import base.BasePage;
import cases.Constants;
import com.sun.tools.internal.jxc.ap.Const;
import element.DescElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class CypherUnlock extends BasePage {

    public CypherUnlock(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public DescElement key_0 = new DescElement("数字按钮-0", By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[@index='11']"));

    public void clickKey(char key){
        switch (key){
            case '0':
                find(key_0.getBy()).click();
        }
    }

    public void inputUnlockCypher(){
        for(char key : Constants.UNLOCK_CYPHER.toCharArray()){
            clickKey(key);
        }
    }
}
