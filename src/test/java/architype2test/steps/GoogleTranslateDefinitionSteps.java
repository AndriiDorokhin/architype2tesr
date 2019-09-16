package architype2test.steps;

import architype2test.steps.serenity.EndUserSteps;
import architype2test.steps.serenity.GoogleTranslateSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GoogleTranslateDefinitionSteps {
    private final String translatedWord = "apple";
    private final String definitionWord = "яблоко";
    private final int translatedWordLength = 5;


    @Steps
    GoogleTranslateSteps googleTranslateSteps;

    @Given("the user is on the google translate page")
    public void userOnTheGoogleTranslatePage() {
        googleTranslateSteps.openGoogleTranslatePage();
    }

    @Given("selected languages from '$source' to '$target'")
    public void userSelectLanguages(String source, String target){
        googleTranslateSteps.setLanguages(source, target);
    }

    @When("the user looks up the translation of the word '$apple'")
    public void userPrintTheWord(String translatedWord) {
        googleTranslateSteps.printText(translatedWord);
    }

    @Then("they should see the translation '$яблоко'")
    public void userShouldSeeText(String яблоко) {
        googleTranslateSteps.shouldSeeText(translatedWord);
    }

    @Then("they should see the translation 'яблоко'")
    public void userShouldSeeDefinition(String text) {
        googleTranslateSteps.shouldSeeText(definitionWord);
    }

    @Then("number of characters must be '5'.")
    public void detectedTextShouldHaveLangth() {
        googleTranslateSteps.detectedTextShouldHaveLangth(translatedWord, translatedWordLength);
    }

}
