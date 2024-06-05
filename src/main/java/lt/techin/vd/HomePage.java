package lt.techin.vd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="item-name")
   private WebElement inputMeal;
    @FindBy(id="item-calories")
    private WebElement inputCalories;
    @FindBy(css = ".add-btn")
    WebElement clickAddMealButton;
    @FindBy(css="li#item-0 > strong")
    private WebElement displayedMeal;
    @FindBy(css="em")
    private  WebElement displayedCalories;
    @FindBy(css=".fa-pencil")
    private WebElement clickEditButton;
    @FindBy(css=".update-btn")
    private WebElement clickUpdateMealButton;
    @FindBy(css=".delete-btn")
    private WebElement clickDeleteMealButton;
    @FindBy(id="item-list")
    private WebElement displayedList;
    @FindBy(css=".blue.btn.clear-btn.lighten-3")
    private WebElement clickClearAllButton;
    @FindBy(css = ".total-calories")
    private WebElement totalCalories;

    @FindBy(css=".pull-right")
    private WebElement clickBackButton;

    @FindBy(css="ul#item-list li")
    private List<WebElement> meals;

   // public int count =0;
    public void inputMeal(String mealName){
        inputMeal.sendKeys(mealName);
        //count++;
    }

//    public int getCount() {
//        return count;
//    }

    public int sum =0;
    public void inputCalories(String caloriesAmount){
        inputCalories.sendKeys(caloriesAmount);
        sum = sum+Integer.parseInt(caloriesAmount);
    }
    public int getSum() {
        return sum;
    }

    public void clickAddMealButton(){
        clickAddMealButton.click();
    }
    public String getDisplayedMeal(){
        return displayedMeal.getText();
    }
    public String getDisplayedCalories(){
        return displayedCalories.getText();
    }
    public void clickEditButton(){
        clickEditButton.click();
    }
    public void clickUpdateMealButton(){
        clickUpdateMealButton.click();
    }
    public void clearFields(){
        inputMeal.clear();
        inputCalories.clear();
    }
    public void clickDeleteMealButton(){
        clickDeleteMealButton.click();
    }
    public String getDisplayeList(){
        return displayedList.getText();
    }
    public void clickClearAllButton(){
        clickClearAllButton.click();
    }
    public String getTotalCalories(){
        return totalCalories.getText();
    }

    public void clickBackButton(){
        clickBackButton.click();
    }
//    public void get (String []){
//      String s = "Bread: 150 Calaories";
////        String[] splitCorrectMeal = s.split(":");
////        ["Bread", " 150 Calories"]
////        String withoutSymbol = splitCorrectMeal[0].trim();
////        String antras = splitCorrectMeal[1].trim();
//        //arbba
//        s = s.replaceAll(":", "");
//        System.out.println(s);


//    }
    public int getNumberOfMeals(){
        return meals.size();
    }


}
