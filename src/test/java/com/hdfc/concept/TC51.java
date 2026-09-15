package com.hdfc.concept;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC51 {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		      Page page = browser.newPage();
		      page.navigate("https://playwright.dev/");
		      System.out.println("Start");
		      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:\\AutomationProject\\HDFC_Playwright_AI\\Screenshots\\example.png")));
		      System.out.println("end");
	}
	}
}
