package demoqa.tests;

import demoqa.pages.RegistrationPage;
import demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class FormsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                //Input fields
                .setFirstName("Nasty")
                .setLastName("Belova")
                .setUserEmail("email@example.com")
                .setUserNumber("9998887766")
                .setCurrentAddress("Pushkina st., Kolotushkina b.")

                //Radio & checkbox
                .setGender("Female")
                .setHobbies("Sports")

                // Date & drop-down
                .setBirthDay("30", "August", "1991")
                .setSubjects("a", "Arts")
                .setStateAndCity("Haryana", "Panipat")

                //Upload Image field
                .uploadPicture("example.png")

                //submit
                .submitForm()

                // assertions
                .checkResultFormAppeared()
                .validateItemsInForm("Student Name", "Nasty Belova")
                .validateItemsInForm("Student Email", "email@example.com")
                .validateItemsInForm("Gender", "Female")
                .validateItemsInForm("Mobile", "9998887766")
                .validateItemsInForm("Date of Birth", "30 August,1991")
                .validateItemsInForm("Subjects", "Arts")
                .validateItemsInForm("Hobbies", "Sports")
                .validateItemsInForm("Picture", "example.png")
                .validateItemsInForm("Address", "Pushkina st., Kolotushkina b.")
                .validateItemsInForm("State and City", "Haryana Panipat");
    }

    @Test
    void successfulTextBoxTest() {
        textBoxPage
                .openPage()
                .setUserName("Nasty")
                .setUserEmail("email@example.com")
                .setCurrentAddress("VLG")
                .setPermanentAddress("VLG perm")
                .submitForm()
                .checkResultFormAppeared()
                .validateItemsInForm("Nasty","email@example.com", "VLG", "VLG perm");
    }

}
