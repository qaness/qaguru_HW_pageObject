package demoqa.tests;

import demoqa.pages.RegistrationPage;
import demoqa.utils.TestsRandomData;
import org.junit.jupiter.api.Test;

public class FormsTestsWithFakeData extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestsRandomData randomValue = new TestsRandomData();

    @Test
    void successfulRegistrationTest() {

        String firstName = randomValue.firstName,
                lastName = randomValue.lastName,
                userEmail = randomValue.userEmail,
                userNumber = randomValue.userNumber,
                currentAddress = randomValue.currentAddress,
                gender = randomValue.gender,
                hobbies = randomValue.hobbies,
                birthdayDay = randomValue.birthdayDay,
                birthdayMonth = randomValue.birthdayMonth,
                birthdayYear = randomValue.birthdayYear,
                subject = randomValue.subject,
                state = randomValue.state,
                city = randomValue.city,
                picture = "example.png";

        registrationPage.openPage()
                //Input fields
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setCurrentAddress(currentAddress)

                //Radio & checkbox
                .setGender(gender)
                .setHobbies(hobbies)

                // Date & drop-down
                .setBirthDay(birthdayDay, birthdayMonth, birthdayYear)
                .setSubjects(subject)
                .setStateAndCity(state, city)

                //Upload Image field
                .uploadPicture(picture)

                //submit
                .submitForm()

                // assertions
                .checkResultFormAppeared()
                .validateItemsInForm("Student Name", firstName + " " + lastName)
                .validateItemsInForm("Student Email", userEmail)
                .validateItemsInForm("Gender", gender)
                .validateItemsInForm("Mobile", userNumber)
                .validateItemsInForm("Date of Birth", birthdayDay + " " + birthdayMonth + "," + birthdayYear)
                .validateItemsInForm("Subjects", subject)
                .validateItemsInForm("Hobbies", hobbies)
                .validateItemsInForm("Picture", picture )
                .validateItemsInForm("Address", currentAddress)
                .validateItemsInForm("State and City", state + " " + city);
    }

}
