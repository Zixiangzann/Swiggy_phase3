package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;

public class BasePage extends DriverFactory{
	
	protected WebDriverWait wait;
	protected Actions actions;
	protected JavascriptExecutor jsExecutor;
	
    public BasePage(){
    	this.wait = new WebDriverWait(getDriver(),Duration.ofSeconds(15));
    	this.actions = new Actions(getDriver());
        this.jsExecutor=((JavascriptExecutor)getDriver());
    }
    
    public void waitAndClickElement(WebElement element,int delay) throws InterruptedException {
    	this.wait.until(ExpectedConditions.elementToBeClickable(element));
    	Thread.sleep(delay);
    	element.click();
    }
    
    public void waitAndClickNthElement(List <WebElement> elements, int nthElement,int delay) throws InterruptedException {
    	Thread.sleep(delay);
    	this.wait.until(ExpectedConditions.elementToBeClickable(elements.get(nthElement)));
    	Thread.sleep(delay);
    	elements.get(nthElement).click();
    	
    }
    
    public void sendKeys(WebElement element,String textToSend) throws InterruptedException {
    	this.wait.until(ExpectedConditions.visibilityOf(element));
    	Thread.sleep(1000);
    	element.sendKeys(textToSend);
    }
    
    public int getElementSize(List <WebElement> elements, int delay) throws InterruptedException {
    	Thread.sleep(delay);
    	return elements.size();
    }
    
    public String getElementAttribute(WebElement element,String attribute) {
    	return element.getAttribute(attribute);
    	
    }
    
    public String getCurrentUrl() {
    	return driver.get().getCurrentUrl();
    }
    
    public String getText(WebElement element) {
    	return element.getText();
    }
    
    public void goToUrl(String url) {
    	driver.get().get(url);
    }
    
	public void executeJS(String script) {
		jsExecutor.executeScript(script);
	}

	public Object returnExecuteJS(String script) {
		Object js = jsExecutor.executeScript("return " + script);
		return js;
	}

    

}
