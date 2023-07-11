package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ModalFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            modalForm = $("#output"),
            nameItem = $("#output #name"),
            emailItem = $("#output #email"),
            currentAddressItem = $("#output #currentAddress"),
            permanentAddressItem = $("#output #permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String userName) {
        userNameInput.setValue(userName);
        return this;
    }

    public TextBoxPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;

    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;

    }

    public TextBoxPage submitForm() {
        submitButton.click();
        return this;
    }

    //modal component with assertions
    public TextBoxPage checkResultFormAppeared() {
        modalForm.should(exist);
        return this;
    }

    public TextBoxPage validateItemsInForm(String name, String email, String currentAddress, String permanentAddress) {
        nameItem.shouldHave(text(name));
        emailItem.shouldHave(text(email));
        currentAddressItem.shouldHave(text(currentAddress));
        permanentAddressItem.shouldHave(text(permanentAddress));
        return this;
    }
}
