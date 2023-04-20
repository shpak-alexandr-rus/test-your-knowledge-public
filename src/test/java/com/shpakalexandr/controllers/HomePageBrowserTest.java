/**
 * ToDo: Добавить описание
 */
package com.shpakalexandr.controllers;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HomePageBrowserTest {
    /**
     * ToDo: Добавить описание
     */
    @LocalServerPort
    private int port;
    private static HtmlUnitDriver browser;

    /**
     * ToDo: Добавить описание
     */
    @BeforeAll
    public static void setup() {
        browser = new HtmlUnitDriver();

        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * ToDo: Добавить описание
     */
    @AfterAll
    public static void teardown() {
        browser.quit();
    }

    /**
     * ToDo: Добавить описание
     */
    @Test
    public void testHomePage() {
        String homePage = "http://localhost:" + port;
        browser.get(homePage);

        String titleText = browser.getTitle();
        Assertions.assertEquals("Test Your Knowledge Project", titleText);

        String h1Text = browser.findElement(By.tagName("h1")).getText();
        Assertions.assertEquals("Welcome to Test Your Knowledge Project!", h1Text);

        String imgSrc = browser.findElement(By.tagName("img"))
                .getAttribute("src");
        Assertions.assertEquals(homePage + "/images/starling_home.jpg", imgSrc);
    }
}
