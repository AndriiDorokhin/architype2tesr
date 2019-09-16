package architype2test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://translate.google.ru")
public class GoogleTranslatePage extends PageObject {

    private String LOCATOR = "//div[@class='language-list-unfiltered-langs-sl_list']//div[text()='%s']";

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

    public GoogleTranslatePage choseLanguge(String source, String target) {
        leftLangugeOptions.click();

        try {
            findBy(String.format(LOCATOR, source)).click();
        }catch(Exception e) {}

        rightLangugeOptions.click();

        try {
            findBy(String.format(LOCATOR, target)).click();
        }catch(Exception e) {}

        return this;
    }

    public GoogleTranslatePage enterKeywords(String keyword) {
        lefttTextArea.type(keyword);
        return this;
    }

    public String getTranslatedText() {
        return rightTextArea.getText();
    }

}
