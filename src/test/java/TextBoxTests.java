import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                    .setUserName("Alex")
                    .setUserEmail("alex@ya.ru")
                    .setUserCurrentAddress("Moscow")
                    .setUserPermanentAddress("Kazan")
                    .submitForm()
                    .checkResult("name", "Alex")
                    .checkResult("email", "alex@ya.ru")
                    .checkResult("currentAddress", "Moscow")
                    .checkResult("permanentAddress", "Kazan");
    }
}
