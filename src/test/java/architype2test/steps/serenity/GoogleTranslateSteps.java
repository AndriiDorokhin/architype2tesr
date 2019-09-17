package architype2test.steps.serenity;

import architype2test.pages.GoogleTranslatePage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;


public class GoogleTranslateSteps {
    GoogleTranslatePage googleTranslatePage;

    @Step
    public void printText(String keyword) {
        googleTranslatePage.enterKeywords(keyword);
    }

    @Step
    public void setLanguages(String source, String target) {
        googleTranslatePage.choseLanguge(source, target);
    }

    //    @Step("the user looks up the translation of the word '$definition'")
    @Step
    public void shouldSeeText(String text) {
        assertThat(googleTranslatePage.getTranslatedText()).as("The text is not match: " + googleTranslatePage.getTranslatedText()).isEqualTo(text);
    }

    @Step
    public void shouldSeeDefinition(String text) {
        assertThat(googleTranslatePage.getDefinitionText(text)).as("The text is not match: " + googleTranslatePage.getDefinitionText(text))
                .isEqualTo("the tree which bears apples.");

    }

    @Step
    public void openGoogleTranslatePage() {
        googleTranslatePage.open();
    }

    @Step
    public void detectedTextShouldHaveLangth(String detectedText, int length) {
        assertThat(detectedText.length()).as("Text lengtht is not the same").isEqualTo(length);
    }
}
