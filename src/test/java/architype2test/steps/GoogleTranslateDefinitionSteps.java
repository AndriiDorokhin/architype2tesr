package architype2test.steps;

import architype2test.pages.GoogleTranslatePage;
import architype2test.steps.serenity.GoogleTranslateSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GoogleTranslateDefinitionSteps {
    private final String translatedWord = "apple";
//    private final String definitionWord = "яблоко";

    GoogleTranslatePage gtp;

    @Steps
    GoogleTranslateSteps googleTranslateSteps;

    @Given("the user is on the google translate page")
    public void userOnTheGoogleTranslatePage() {
        googleTranslateSteps.openGoogleTranslatePage();
    }

    @Given("selected languages from '$source' to '$target'")
    public void userSelectLanguages(String source, String target) {
        googleTranslateSteps.setLanguages(source, target);
    }

    @When("the user looks up the translation of the word '$apple'")
    public void userPrintTheWord(String givenWord) {
        googleTranslateSteps.printText(givenWord);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + gtp.getTextFromSide(GoogleTranslatePage.Side.LEFT));
    }

    @Then("they should see the translation '$text'")
    public void userShouldSeeText(String text) {
        googleTranslateSteps.shouldSeeText(text);
    }

    @Then("they should see the definition '$waitingText'")
    public void userShouldSeeDefinition(String definition) {
        googleTranslateSteps.shouldSeeDefinition(definition);
    }

    @Then("number of characters must be '$5'.")
    public void detectedTextShouldHaveLangth(int textLength) {
        googleTranslateSteps.detectedTextShouldHaveLangth(translatedWord, textLength);
    }

}
