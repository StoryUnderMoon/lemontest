package cases.fingertips;

import cases.BaseSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.launcher.desktop.ChannelTalent;
import page.launcher.fingertips.Index;

public class Open extends BaseSteps {

    @Test
    public void open_clickText_success(){
        ChannelTalent channelTalent = new ChannelTalent(driver);
        channelTalent.click(channelTalent.text_fingertips);
        Index index = new Index(driver);
        Assert.assertNotNull(index.button_back);
    }

}
