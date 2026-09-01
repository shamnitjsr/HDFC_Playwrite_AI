package com.hdfc.concept;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TC50_CountLinksExample {

	public static void main(String[] args) {
		
		try(Playwright playwright = Playwright.create())
		{
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			//page.navigate("https://www.wikipedia.org/");
			page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Locator links = page.locator("a");
			System.out.println(links.count());
		}

	}

}
