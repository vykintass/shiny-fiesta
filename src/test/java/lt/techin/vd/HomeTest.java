package lt.techin.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HomeTest extends BaseTest {
    @Test
    void addMealTest() {
        HomePage homePage = new HomePage(driver);
        String meal1 = "chicken";
        String calories1 = "400";
     //   String inicial
        homePage.inputMeal(meal1);

        homePage.inputCalories(calories1);

        homePage.clickAddMealButton();

        Assertions.assertTrue(homePage.getDisplayedMeal().contains(meal1), "Meal names does not match");
        Assertions.assertTrue(homePage.getDisplayedCalories().contains(calories1), "Calories does not match");
    }

    @Test
    void updateMealTest() {
        HomePage homePage = new HomePage(driver);
        String meal1 = "chicken";
        String calories1 = "500";
        homePage.inputMeal(meal1);
        homePage.inputCalories(calories1);
        homePage.clickAddMealButton();

        homePage.clickEditButton();
        String meal2 = "pork";
        String calories2 = "400";
        homePage.clearFields();
        homePage.inputMeal(meal2);
        homePage.inputCalories(calories2);
        homePage.clickUpdateMealButton();

        Assertions.assertTrue(homePage.getDisplayedMeal().contains(meal2), "Meal names does not match");
        Assertions.assertTrue(homePage.getDisplayedCalories().contains(calories2), "Calories does not match");
    }

    @Test
    void deleteMealTest() {
        HomePage homePage = new HomePage(driver);
        String meal1 = "chicken";
        String calories1 = "500";
        homePage.inputMeal(meal1);
        homePage.inputCalories(calories1);
        homePage.clickAddMealButton();
        homePage.clickEditButton();

        homePage.clickDeleteMealButton();
        Assertions.assertTrue(homePage.getDisplayeList().isEmpty());
    }

    @Test
    void clearAllTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String meal1 = "chicken";
        String calories1 = "600";
        homePage.inputMeal(meal1);
        homePage.inputCalories(calories1);
        homePage.clickAddMealButton();
        String meal2 = "pork";
        String calories2 = "500";
        homePage.inputMeal(meal2);
        homePage.inputCalories(calories2);
        homePage.clickAddMealButton();
        String meal3 = "salads";
        String calories3 = "100";
        homePage.inputMeal(meal3);
        homePage.inputCalories(calories3);

        homePage.clickAddMealButton();

       // Assertions.assertEquals(homePage.getCount(), homePage.getNumberOfMeals(),"aaa");

        homePage.clickClearAllButton();
      Assertions.assertTrue(homePage.getDisplayeList().isEmpty(), "Meals wasn't deleted properly");
     Assertions.assertEquals("0", homePage.getTotalCalories(), "Sum of calories did not reset to 0");
    }

    @Test
    void sumOfCaloriesTest() {
        HomePage homePage = new HomePage(driver);
        String meal1 = "chicken";
        String calories1 = "500";
        homePage.inputMeal(meal1);
        homePage.inputCalories(calories1);
        homePage.clickAddMealButton();
        String meal2 = "pork";
        String calories2 = "400";
        homePage.inputMeal(meal2);
        homePage.inputCalories(calories2);
        homePage.clickAddMealButton();
        String meal3 = "salads";
        String calories3 = "100";
        homePage.inputMeal(meal3);
        homePage.inputCalories(calories3);
        homePage.clickAddMealButton();

        Assertions.assertEquals(homePage.getSum(), Integer.parseInt(homePage.getTotalCalories()), "Sum of calories did not reset to 0");
    }

    @Test
    void backButtonTest() {
        HomePage homePage = new HomePage(driver);
        String meal1 = "chicken";
        String calories1 = "500";
        homePage.inputMeal(meal1);
        homePage.inputCalories(calories1);
        homePage.clickAddMealButton();
        homePage.clickEditButton();

        homePage.clickBackButton();
        Assertions.assertTrue(homePage.clickAddMealButton.isDisplayed());
    }
    @ParameterizedTest
    @CsvSource({
            "bread ,        -1",
            "banana,        -2",
            "' ', 10",
            "'   ',    -700000",
            "apple, -3"
    })
    void addMealNegativeValueTest(String meal1, String calories1) {
        HomePage homePage = new HomePage(driver);

        int initialMeals= homePage.getNumberOfMeals();

        homePage.inputMeal(meal1);
        homePage.inputCalories(calories1);
        homePage.clickAddMealButton();

        int afterAddingMeals = homePage.getNumberOfMeals();

        Assertions.assertEquals(initialMeals,afterAddingMeals, "Calories cant be negative");
    }



}
