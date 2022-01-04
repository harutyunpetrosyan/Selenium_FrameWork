package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(css = "[class='single_add_to_cart_button button alt']")
    private WebElement addToBasket;
    @FindBy(css = "input[type='number']")
    private WebElement numberOfBasketQuantity;
    @FindBy(css = "[class='button wc-forward']")
    private WebElement viewBasket;
    @FindBy(css = "[id='tab-description'] p")
    private WebElement descriptionParagraph;
    @FindBy(css = "li[class='reviews_tab']")
    private WebElement reviewsTab;
    @FindBy(id = "comment")
    private WebElement commentTab;
    @FindBy(id = "author")
    private WebElement author;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "submit")
    private WebElement submit;
    @FindBy(css = "[class='stars'] a")
    private List<WebElement> stars;
    @FindBy(css = "[class=\"comment_container\"] [itemprop=\"description\"] p")
    private WebElement reviewComment;
    @FindBy(css = "[class='cart_item']")
    private WebElement cartItem;
    @FindBy(css = "p[class=\"stock in-stock\"]")
    private WebElement stockText;
    @FindBy(css = "ul[class=\"woocommerce-error\"] li")
    private WebElement errorText;



    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPresentAddToBasket() {
        return addToBasket.isDisplayed() && addToBasket.getText().equals("ADD TO BASKET");
    }

    public void clickOnAddToBasket() {
        addToBasket.click();
    }

    public void writeNumberOfBasketQuantity(String number) {
        numberOfBasketQuantity.clear();
        numberOfBasketQuantity.sendKeys(number);
    }

    public void clickViewBasket() {
        viewBasket.click();
    }

    public boolean isPresentDescriptionParagraph() {
        return descriptionParagraph.getText().isEmpty();
    }

    public void clickOnReviewsTab() {
        reviewsTab.click();
    }

    public boolean checkAddedComment() {
        String commentText = RandomStringUtils.randomAlphanumeric(7);
        commentTab.sendKeys(commentText);
        author.sendKeys(RandomStringUtils.randomAlphabetic(7));
        email.sendKeys(RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomAlphabetic(3) + ".com");
        stars.get(4).click();
        submit.click();
        return reviewComment.getText().equals(commentText);
    }
    public boolean isPresentProductItemOnPage(){
        return cartItem.isDisplayed();
    }

    public boolean isAddedMoreBooksThanStock(){
        int value = Integer.parseInt(stockText.getText().replaceAll("[^0-9]", ""));
        numberOfBasketQuantity.sendKeys(String.valueOf(value+1));
        addToBasket.click();
        boolean isNotDisplayedViewBasket=false;
        try {
            viewBasket.isDisplayed();
        }catch (NoSuchElementException e){
            isNotDisplayedViewBasket=true;
        }
        numberOfBasketQuantity.clear();
        numberOfBasketQuantity.sendKeys(String.valueOf(value));
        addToBasket.click();
        addToBasket.getText().equals("ADD TO BASKET");
        numberOfBasketQuantity.clear();
        numberOfBasketQuantity.sendKeys(String.valueOf(value));
        addToBasket.click();
        return errorText.getText().contains("You cannot add that amount to the cart")
                &&isNotDisplayedViewBasket;
    }


}
