package page.launcher.desktop;

import base.BasePage;
import element.DescElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EduDesktop extends BasePage{
    public DescElement tab_talent = new DescElement("标签-小度超能力", MobileBy.xpath("//android.widget.TextView[@text='小度超能力']"));
    public DescElement tab_chinese = new DescElement("标签-语文", MobileBy.xpath("//android.widget.TextView[@text='语文']"));
    public DescElement tab_math = new DescElement("标签-数学", MobileBy.xpath("//android.widget.TextView[@text='数学']"));
    public DescElement tab_learningField = new DescElement("标签-趣学园地", MobileBy.xpath("//android.widget.TextView[@text='趣学园地']"));
    public DescElement tab_encyclopedias = new DescElement("标签-百科知识", MobileBy.xpath("//android.widget.TextView[@text='百科知识']"));
    public DescElement tab_myApplications = new DescElement("标签-我的应用", MobileBy.xpath("//android.widget.TextView[@text='我的应用']"));
    public DescElement icon_babyCentre = new DescElement("图标-宝贝中心", MobileBy.id("com.baidu.launcher:id/icon_setting"));
    public DescElement hint_left = new DescElement("hint-左", MobileBy.xpath("//android.widget.LinearLayout[@resource-id='com.baidu.launcher:id/voicebar_hint']/android.widget.TextView[1]"));
    public DescElement hint_right = new DescElement("hint-右", MobileBy.xpath("//android.widget.LinearLayout[@resource-id='com.baidu.launcher:id/voicebar_hint']/android.widget.TextView[2]"));
    public DescElement icon_wakeup = new DescElement("图标-唤醒", MobileBy.id("com.baidu.launcher:id/qsb_duer"));
    public DescElement icon_feedback = new DescElement("图标-用户反馈", MobileBy.xpath("//android.view.ViewGroup[@resource-id='com.baidu.launcher:id/edu_tab_fragment_content']/android.widget.ImageView"));

    public EduDesktop(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

}
