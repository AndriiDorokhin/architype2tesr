package architype2test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://translate.google.ru")
public class GoogleTranslatePage extends PageObject {
    @FindBy(css = "div.sl-more.tlid-open-source-language-list[role=button]")
    private WebElementFacade leftLangugeOptions;

    @FindBy(css = "div.tl-more.tlid-open-target-language-list[role=button]")
    private WebElementFacade rightLangugeOptions;

    @FindBy(css = "div.language_list_item.language_list_item_language_name[aria-label^=English]")
    private WebElementFacade lefttLanguge;

    @FindBy(css = "div.language_list_item.language_list_item_language_name[aria-label^=English]")
    private WebElementFacade rightLanguge;

    ////div[@class='language-list-unfiltered-langs-sl_list']//div[.='English'][contains(@class,'language_list_item') and contains(@class,'language_list_item_language_name')]
}
