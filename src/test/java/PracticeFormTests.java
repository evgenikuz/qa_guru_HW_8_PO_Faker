import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;


public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceForm = new PracticeFormPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.numerify("##########");
    String streetAddress = faker.address().streetAddress();

    @Test
    void fillPracticeFormTest() {
        practiceForm.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender("Other")
                    .setPhoneNumber(phoneNumber)
                    .setDateOfBirth("08", "September", "1912")
                    .setSubject("Maths")
                    .setSubject("Hindi")
                    .setHobby("Reading")
                    .setHobby("Music")
                    .setPicture("Ob1aUY2U.jpeg")
                    .setAddress(streetAddress)
                    .setState("Rajasthan")
                    .setCity("Jaipur")
                    .submitForm()
                    .checkModalIsOpen()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", "Other")
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", "08 September,1912")
                    .checkResult("Subjects", "Maths, Hindi")
                    .checkResult("Hobbies", "Reading, Music")
                    .checkResult("Picture", "Ob1aUY2U.jpeg")
                    .checkResult("Address", streetAddress)
                    .checkResult("State and City", "Rajasthan Jaipur")
                    .closeModal();
    }

    @Test
    void fillNecessaryOnlyPracticeFormTest() {
        practiceForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender("Male")
                .setPhoneNumber(phoneNumber)
                .submitForm()
                .checkModalIsOpen()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", "Male")
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
