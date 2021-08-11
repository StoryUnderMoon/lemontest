package page.launcher.desktop;

import base.BasePage;
import element.DescElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChannelTalent extends BasePage {

    public DescElement tab_talent = new DescElement("标签-小度超能力", MobileBy.xpath("//android.widget.TextView[@text='小度超能力']"));
    public DescElement tab_chinese = new DescElement("标签-语文", MobileBy.xpath("//android.widget.TextView[@text='语文']"));
    public DescElement tab_math = new DescElement("标签-数学", MobileBy.xpath("//android.widget.TextView[@text='数学']"));
    public DescElement tab_learningField = new DescElement("标签-趣学园地", MobileBy.xpath("//android.widget.TextView[@text='趣学园地']"));
    public DescElement tab_encyclopedias = new DescElement("标签-百科知识", MobileBy.xpath("//android.widget.TextView[@text='百科知识']"));
    public DescElement tab_myApplications = new DescElement("标签-我的应用", MobileBy.xpath("//android.widget.TextView[@text='我的应用']"));
    public DescElement icon_babyCentre = new DescElement("图标-宝贝中心", MobileBy.id("com.baidu.launcher:id/icon_setting"));

    public DescElement text_fingertips = new DescElement("文本-指尖查词", MobileBy.xpath("//android.widget.TextView[@text='指尖查词']"));
    public DescElement text_searchQuestion = new DescElement("文本-拍照搜题", MobileBy.xpath("//android.widget.TextView[@text='拍照搜题']"));
    public DescElement text_intelligenteye = new DescElement("文本-课文听读", MobileBy.xpath("//android.widget.TextView[@text='课文听读']"));
    public DescElement text_oralcalculation = new DescElement("文本-口算批改", MobileBy.xpath("//android.widget.TextView[@text='口算批改']"));
    public DescElement icon_fingertips = new DescElement("文本-指尖查词", MobileBy.xpath("//android.widget.TextView[@text='指尖查词']/preceding-sibling::android.widget.ImageView"));
    public DescElement icon_searchQuestion = new DescElement("文本-拍照搜题", MobileBy.xpath("//android.widget.TextView[@text='拍照搜题']/preceding-sibling::android.widget.ImageView"));
    public DescElement icon_intelligenteye = new DescElement("文本-课文听读", MobileBy.xpath("//android.widget.TextView[@text='课文听读']/preceding-sibling::android.widget.ImageView"));
    public DescElement icon_oralcalculation = new DescElement("文本-口算批改", MobileBy.xpath("//android.widget.TextView[@text='口算批改']/preceding-sibling::android.widget.ImageView"));

    public DescElement icon_feedback = new DescElement("图标-用户反馈", MobileBy.xpath("//android.view.ViewGroup[@resource-id='com.baidu.launcher:id/edu_tab_fragment_content']/android.widget.ImageView"));
    public DescElement icon_wakeup = new DescElement("图标-唤醒", MobileBy.id("com.baidu.launcher:id/iv_xd"));

    public By textView_fingertips = MobileBy.xpath("//android.widget.TextView[@text='指尖查词']");

    public ChannelTalent(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

}
