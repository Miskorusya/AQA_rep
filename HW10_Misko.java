package Papaka;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW10_Misko extends BaseTestClass {

    @Test
    public void testLeftFrame() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "LEFT");

        driver.switchTo().defaultContent();
    }

    @Test
    public void testMiddleFrame() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "MIDDLE");

        driver.switchTo().defaultContent();
    }

    @Test
    public void testRightFrame() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "RIGHT");

        driver.switchTo().defaultContent();
    }

    @Test
    public void testBottomFrame() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-bottom");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "BOTTOM");

        driver.switchTo().defaultContent();
    }
}
