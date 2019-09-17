package architype2test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://translate.google.ru")
public class GoogleTranslatePage extends PageObject {

    private String LOCATOR = "//div[@class='language-list-unfiltered-langs-sl_list']//div[text()='%s']/parent::div";

    @FindBy(css = "div.sl-more.tlid-open-source-language-list[role=button]")
    private WebElementFacade leftLangugeOptions;

    @FindBy(css = "div.tl-more.tlid-open-target-language-list[role=button]")
    private WebElementFacade rightLangugeOptions;

    @FindBy(css = "div.language_list_item.language_list_item_language_name[aria-label^=English]")
    private WebElementFacade leftLanguge;

    @FindBy(css = "div.language_list_item.language_list_item_language_name[aria-label^=English]")
    private WebElementFacade rightLanguge;

    @FindBy(css = "textarea#source")
    private WebElementFacade lefttTextArea;

    @FindBy(css = "div.text-wrap.tlid-copy-target span[title]")
    private WebElementFacade rightTextArea;

    @FindBy(css = "div.gt-def-info div.gt-def-row")
    private List<WebElementFacade> definitions;

    public GoogleTranslatePage choseLanguge(String source, String target) {
        leftLangugeOptions.click();

        try {
            findBy(String.format(LOCATOR, source)).click();
        } catch (Exception e) {
        }

        rightLangugeOptions.click();

        WebElementFacade el = findBy(String.format("//div[text()='Все языки']/parent::div//div[contains(@aria-label,'%s')]", target));
        evaluateJavascript("arguments[0].scrollIntoView(true);", el);
        el.click();

        return this;
    }

    public GoogleTranslatePage enterKeywords(String keyword) {
        lefttTextArea.typeAndEnter(keyword);
        return this;
    }

    public GoogleTranslatePage getTextFromField(String keyword) {
        lefttTextArea.type(keyword);
        return this;
    }

    public String getTranslatedText() {
        return rightTextArea.getText();
    }

    public String getTextFromSide(Side side) {
        if (side == Side.LEFT) {
            return lefttTextArea.getText();
        } else {
            return rightTextArea.getText();
        }
    }

    public String getDefinitionText(String textForCompare) {
        String tmpString = "";

        for (WebElementFacade defEl : definitions) {
            tmpString = defEl.getText();

            if (tmpString.equalsIgnoreCase(textForCompare))
                return defEl.getText();
        }

        return tmpString;
    }

    public enum Side {
        LEFT,
        RIGHT
    }
}
