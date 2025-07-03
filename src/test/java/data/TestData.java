package data;

import com.github.javafaker.Faker;

import java.util.Date;

public class TestData {
    static Faker faker = new Faker();
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.numerify("##########"),
            gender = faker.options().option("Male", "Female", "Other"),
            streetAddress = faker.address().streetAddress(),
            subject = faker.options().option("Maths", "Hindi", "Biology", "Accounting", "Chemistry"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            avatar = faker.options().option("av1.jpeg", "av2.jpg", "av3.jpg");

    static Date birthday = faker.date().birthday();
    public static String year = String.valueOf(birthday.getYear() + 1900);
    static int birthdayMonth = birthday.getMonth();
    static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    public static String month = months[birthdayMonth];
    static int bday = birthday.getDate();
    public static String day = (bday < 10) ? "0" + bday : String.valueOf(bday);

    public static String state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana");
    public static String city = getCityForState(state);
    public static String getCityForState(String state) {
        if (state.equals("NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        else if (state.equals("Uttar Pradesh")) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        }
        else if (state.equals("Rajasthan")) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }
        else if (state.equals("Haryana")) {
            city = faker.options().option("Karnal", "Panipat");
        }
        return city;
    }
}
