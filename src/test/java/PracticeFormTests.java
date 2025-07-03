import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static data.TestData.*;


public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceForm = new PracticeFormPage();


    @Test
    void fillPracticeFormTest() {
        practiceForm.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhoneNumber(phoneNumber)
                    .setDateOfBirth(day, month, year)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .setPicture(avatar)
                    .setAddress(streetAddress)
                    .setState(state)
                    .setCity(city)
                    .submitForm()
                    .checkModalIsOpen()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", avatar)
                    .checkResult("Address", streetAddress)
                    .checkResult("State and City", state + " " + city)
                    .closeModal();
    }

    @Test
    void fillNecessaryOnlyPracticeFormTest() {
        practiceForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .submitForm()
                .checkModalIsOpen()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .closeModal();
    }

    @Test
    void fillNothingPracticeFormTest() {
        practiceForm.openPage()
                .submitForm()
                .checkValidation()
                .checkModalIsNotOpen();
    }
}
