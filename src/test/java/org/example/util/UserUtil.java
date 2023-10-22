package org.example.util;

import org.example.constant.DefaultUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserUtil {

    public static void login(DefaultUser user, WebDriver driver) {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(user.getUsername());
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.id("login-button")).click();
    }

}
