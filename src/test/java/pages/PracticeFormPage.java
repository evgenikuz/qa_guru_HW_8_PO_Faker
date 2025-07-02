package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private SelenideElement header = $("h1"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput =  $("#subjectsInput"),
            subjectOption = $("#react-select-2-option-0"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state .css-1wy0on6"),
            cityInput = $("#city .css-1wy0on6"),
            submitButton = $("#submit"),
            modalHeader = $(".modal-content #example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive"),
            closeButton = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        header.shouldHave(text("Practice Form"));
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setPhoneNumber(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectInput.setValue(value);
        subjectOption.click();
        return this;
    }

    public PracticeFormPage setHobby(String value) {
        $(byText(value)).click();
        return this;
    }

    public PracticeFormPage setPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();
        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkModalIsOpen() {
        modalHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public PracticeFormPage checkModalIsNotOpen() {
        modalHeader.shouldNotBe(visible);
        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public PracticeFormPage closeModal() {
        closeButton.click();
        header.shouldHave(text("Practice Form"));
        return this;
    }

    public PracticeFormPage checkValidation() {
        $(".was-validated").shouldBe(visible);
        return this;
    }
}
