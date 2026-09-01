package com.hdfc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

@Configuration
public class PlaywrightConfig {
	
	private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	private static final ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static final ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
	private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
	
	@Value("${browser:chromium}")
	private String browserType;
	
	@Value("${headless:trueMinutes}")
	private boolean isHeadless;
	
	@Value("${remote.url}")
	private String remoteUrl;
	
	@Bean
	@Scope("Cucumber-glue")
	public Page getPage()
	{
		if(tlPage.get() == null)
		{
			initPlaywright(browserType, isHeadless, remoteUrl);
			
		}
		return tlPage.get();
	}
	
	public void initPlaywright(String browserName, boolean headless, String rUrl)
	{
		tlPlaywright.set(Playwright.create());
		BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(headless);
		
		Browser browser = null;
		if(rUrl != null && !rUrl.isEmpty())
		{
			//Remote execution connection
		}
		else
		{
			//Local Execution
			switch(browserName.toLowerCase()) {
			case "firefox":
				browser = tlPlaywright.get().firefox().launch(options);
				break;
			case "webkit":
				browser = tlPlaywright.get().webkit().launch(options);
				break;
			default:
				browser = tlPlaywright.get().chromium().launch(options);
				break;
			}
		}
		tlBrowser.set(browser);
		tlContext.set(tlBrowser.get().newContext());
		tlPage.set(tlContext.get().newPage());
	}
	
	
	public static void closeBrowser()
	{
		if(tlPage.get() != null)
		{
			tlPage.get().close();
		}
		if(tlContext.get() != null)
		{
			tlContext.get().close();
		}
		if(tlBrowser.get() != null)
		{
			tlBrowser.get().close();
		}
		if(tlPlaywright.get() != null)
		{
			tlPlaywright.get().close();
		}
		
		tlPage.remove();
		tlContext.remove();
		tlBrowser.remove();
		tlPlaywright.remove();
	}
	

}
