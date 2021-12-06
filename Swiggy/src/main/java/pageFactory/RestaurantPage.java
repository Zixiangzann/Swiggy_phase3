package pageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RestaurantPage extends BasePage{
	
	public @FindBy(xpath="//div[@class='_3Mn31']/div[3]") List<WebElement> deliveryTime;
	public @FindBy(xpath="//div[@class='nVWSi']") List<WebElement> costs;
	public @FindBy(xpath="//div[@class='_3Mn31']/div[5]") List<WebElement> price;
	public @FindBy(xpath="//div[contains(@class,'_2-ofZ')]") List<WebElement> sortingTab;
	public @FindBy(xpath="//div[contains(text(),'Delivery Time')]") WebElement deliveryTimeTab;
	public @FindBy(xpath="//div[contains(text(),'Cost: High to Low')]") WebElement costHighToLowTab;
	
	public RestaurantPage() throws IOException{
		super();
	}
	
	public List<String> getSortingTab() {
		List<String> sortingList = new ArrayList<>();
		sortingTab.forEach(x -> {
			if(!x.getText().contains("Filters")) {
				sortingList.add(x.getText());
			}
		});
		return sortingList;
	}
	
	public RestaurantPage clickDeliveryTimeTab() throws InterruptedException, IOException {
		waitAndClickElement(deliveryTimeTab,500);
		return new RestaurantPage();
	}
	
	public RestaurantPage clickCostHighToLowTab() throws InterruptedException, IOException {
		waitAndClickElement(costHighToLowTab,500);
		return new RestaurantPage();
	}
	
	public List<Integer> getDeliveryTime() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOfAllElements(deliveryTime));
		
		//Scroll to end of page
		while((Long)basePage.returnExecuteJS("window.scrollY;") 
				< 
				//Scroll to half of the full page
				//Full test may take some time, if want to perform full test may remove the /2 
				(Long)basePage.returnExecuteJS("document.documentElement.scrollHeight - document.documentElement.clientHeight;")/2) 
		{		
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
		}
		
		List<Integer> deliveryTimeList = new ArrayList<>();
		deliveryTime.forEach(x -> {
			int time = Integer.parseInt(x.getText().replaceAll("[^\\d]", ""));
			deliveryTimeList.add(time);
		});
		return deliveryTimeList;
	}
	
	public List<Integer> getCost() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOfAllElements(costs));
		
		//workaround, some element not loading after switching tab
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		
		//Scroll to end of page
		while((Long)basePage.returnExecuteJS("window.scrollY;") 
				< 
				//Scroll to half of the full page
				//Full test may take some time, if want to perform full test may remove the /2 
				(Long)basePage.returnExecuteJS("document.documentElement.scrollHeight - document.documentElement.clientHeight;")/2)
		{		
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);
		}
		
		List<Integer> costsList = new ArrayList<>();
		costs.forEach(x -> {
			int time = Integer.parseInt(x.getText().replaceAll("[^\\d]", ""));
			costsList.add(time);
		});
		return costsList;
	}
	
	
}
