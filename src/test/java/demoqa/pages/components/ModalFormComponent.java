package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class ModalFormComponent {

    public void verifyLabelValue(SelenideElement table, String label, String value){
        table.$(byText(label)).sibling(0).shouldHave(text(value));

    }
}
