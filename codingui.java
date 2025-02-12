package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class codingui {

	public static void main(String[] args)
	{

		
	    	
	    		
	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1: Open browser and navigate to ebay.com
	            driver.get("https://www.ebay.com");
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	            // Step 2: Search for 'book'
	            WebElement searchBox = driver.findElement(By.id("gh-ac"));
	            searchBox.sendKeys("book");
	            searchBox.submit();

	            // Step 3: Click on the first book in the search results
	            WebElement firstBook = driver.findElement(By.xpath("(//li[contains(@class, 's-item')])[1]//a"));
	            firstBook.click();

	            // Step 4: Click on 'Add to cart'
	            WebElement addToCartButton = driver.findElement(By.id("atcRedesignId_btn"));
	            addToCartButton.click();

	            // Step 5: Wait and verify that the cart has been updated
	            Thread.sleep(5000); // Wait for cart update
	            WebElement cartCountElement = driver.findElement(By.id("gh-cart-n"));
	            String cartCount = cartCountElement.getText();

	            if (Integer.parseInt(cartCount) > 0) 
	            {
	                System.out.println("Book added to cart: " + cartCount);
	            } else {
	                System.out.println("Book not added to cart.");
	            }

	        } catch (Exception e)
	        {
	            System.out.println("Test Failed due to an error: " + e.getMessage());
	        } finally
	        {
	            // Step 6: Close the browser
	            driver.quit();
	        }
	    }
	        }
	    }
	}
	}

}
