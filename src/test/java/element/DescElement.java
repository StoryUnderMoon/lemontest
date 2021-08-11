package element;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class DescElement {
    private By by;
    private String Desc;

    public DescElement(String desc, By by) {
        this.by = by;
        this.Desc = desc;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
