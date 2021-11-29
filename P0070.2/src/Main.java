
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static void displayMenu() {
        System.out.println("------Login Program--------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    public static void main(String[] args) {

        DataInput in = new DataInput();
        TPBankView view = new TPBankView();

        while (true) {
            displayMenu();
            int input = in.inputInt("Please choose one option: ", 1, 3);
            switch (input) {
                case 1:
                    Locale vi_Locale = new Locale("vi", "VN");
                    ResourceBundle vi_bundle = ResourceBundle.getBundle("language_vi_VN.properties", vi_Locale);
                    loginSystem(vi_bundle);
                    break;
                case 2:
                    Locale en_Locale = new Locale("en", "US");
                    ResourceBundle en_bundle = ResourceBundle.getBundle("language_en_US.properties", en_Locale);
                    loginSystem(en_bundle);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    public static void loginSystem(ResourceBundle bundle) {
        TPBankView view = new TPBankView();
        view.inputAccount(bundle);
        view.inputPassWord(bundle);
        view.inputCaptcha(bundle);
    }
}