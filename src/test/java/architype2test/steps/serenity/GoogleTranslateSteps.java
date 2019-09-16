package architype2test.steps.serenity;

import architype2test.pages.GoogleTranslatePage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertEquals;

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
        assertEquals(googleTranslatePage.getTranslatedText(), text);
    }

    @Step
    public void openGoogleTranslatePage() {
        googleTranslatePage.open();
    }

    @Step
    public void detectedTextShouldHaveLangth(String detectedText, int length) {
        assertEquals(detectedText.length(), length);
    }
}
