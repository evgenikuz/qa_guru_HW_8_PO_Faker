package data;

import com.github.javafaker.Faker;

import java.util.Date;

public class TestData {
    static Faker faker = new Faker();
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            streetAddress = faker.address().streetAddress(),
            subject = faker.options().option("Maths", "Hindi", "Biology", "Accounting", "Chemistry"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            avatar = faker.options().option("av1.jpeg", "av2.jpg", "av3.jpg"),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = faker.options().option("January", "February", "March", "April",
                                           "May", "June", "July", "August", "September",
                                           "October", "November", "December"),
            year = String.format("%s", faker.number().numberBetween(1920, 2024)),
            state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana"),
            city = getCityForState(state);

    public static String getCityForState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}
