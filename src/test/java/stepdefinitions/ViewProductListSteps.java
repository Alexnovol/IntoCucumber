package stepdefinitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static utilities.Locators.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ViewProductListSteps {

    @Given("Открытие главной страницы сайта {string}")
    public void openMainPage(String url) {
        open(url);

        $x(XPATH_MAIN_PAGE_CONTENT).shouldBe(enabled);
    }

    @When("Пользователь переходит в категорию {string}")
    public void goToCategory(String category) {

        $(CSS_BUTTON_FILTERS).click();

        $x(XPATH_CATEGORY.replace("category", category)).click();

    }

    @Then("Пользователь видит список товаров категории {string}")
    public void checkCategoryTitle(String category) {

        $(CLASS_CATEGORY_TITLE).shouldHave(text(category));
    }

    @When("Пользователь вводит {string} в строку поиска")
    public void enterInSearchField(String product) {

        SelenideElement searchField = $(ID_SEARCH_FIELD);
        searchField.click();
        searchField.setValue(product);
        searchField.sendKeys(Keys.ENTER);

    }

    @Then("Пользователь видит товар {string} в результатах поиска")
    public void checkSearchResults(String product) {

        $(CLASS_TITLE_RESULTS).shouldHave(text(product));

    }

    @Given("Допустим пользователь нашел товар {string}")
    public void findProduct(String product) {
        openMainPage("https://www.wildberries.ru/");

        enterInSearchField(product);

    }

    @When("Пользователь добавляет товар в корзину")
    public void addToCart() {

        $x(XPATH_IN_BASKET_BUTTON_FIRST_PRODUCT).scrollTo().click();

    }

    @Then("В корзине пользователя находится товар {string}")
    public void checkProductInBasket(String product) {

        $x(XPATH_BASKET_BUTTON).click();

        $(CLASS_NAME_PRODUCT).shouldHave(text(product));
    }




}
