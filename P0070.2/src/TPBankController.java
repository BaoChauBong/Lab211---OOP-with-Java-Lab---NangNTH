
import java.util.ResourceBundle;

public class TPBankController {

    // return true if account have only 10 digits
    public boolean checkAccount(ResourceBundle bundle, String account) {
        return account.matches("^[0-9]{10}$");
    }

    // ^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$
    public boolean checkPassWord(ResourceBundle bundle, String password) {
        return password.matches("^(?=.*?[A-Za-z])(?=.*?[0-9]).{8,31}$");
    }


    public boolean checkCaptcha(ResourceBundle bundle, String captcha, String captchaInput) {
        if (captchaInput.length() == 1) {
            if (captcha.contains(captchaInput)) {
                return true;
            }
        }
        return false;
    }
}