package com.hdfc.concept;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC52 {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/java/");

            // Capture the visible viewport
           // page.screenshot(new Page.ScreenshotOptions()
              //  .setPath(Paths.get("D:\\AutomationProject\\HDFC_Playwright_AI\\Screenshots\\viewport_screenshot.png")));

            
            
         // Capture the entire webpage from top to bottom
//            page.screenshot(new Page.ScreenshotOptions()
//                .setPath(Paths.get("D:\\\\AutomationProject\\\\HDFC_Playwright_AI\\\\Screenshots\\\\full_page.png"))
//                .setFullPage(true));
            
            
            
         // Target a specific element by its CSS selector
            Locator header = page.locator("//*[@id=\"__docusaurus_skipToContent_fallback\"]/header/div/div/span/a[2]");

            // Capture only that element
            page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("D:\\\\\\\\AutomationProject\\\\\\\\HDFC_Playwright_AI\\\\\\\\Screenshots\\\\\\\\element_screenshot.png"))
            .setMask(java.util.Collections.singletonList(header)));
            
            
            browser.close();
        }

	}

}
