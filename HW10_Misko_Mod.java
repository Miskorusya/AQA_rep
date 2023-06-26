package My_project;

import Papaka.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW10_Misko_Mod extends BaseTestClass {

    @Test(dataProvider = "frameNames")
    public void switchToFrame(String frameName) {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        String body = switchToFrameAndGetText(frameName);
        Assert.assertEquals(body, frameName.toUpperCase());
    }

    private String switchToFrameAndGetText(String frameName) {
        if (frameName.equals("bottom")) {
            driver.switchTo().frame("frame-bottom");
        } else {
            driver.switchTo().frame("frame-top");
            if (frameName.equals("left") || frameName.equals("middle") || frameName.equals("right")) {
                driver.switchTo().frame("frame-" + frameName);
            }
        }

        String body = driver.findElement(By.xpath("//body")).getText();

        driver.switchTo().defaultContent();
        return body;
    }

    @DataProvider(name = "frameNames")
    public Object[][] getData() {
        return new Object[][] {
                {"bottom"},
                {"left"},
                {"middle"},
                {"right"}
        };
    }
}