
import java.util.ResourceBundle;

public class TPBankView {

    DataInput in = new DataInput();
    TPBankController ctrl = new TPBankController();

    public void inputAccount(ResourceBundle bundle) {
        
        String msg = bundle.getString("account");
        String invalidAccount = bundle.getString("invalid.account");
        while (true) {
            String account = in.inputString(msg, invalidAccount);
            if (ctrl.checkAccount(bundle, account)) {
                break;
            }
            System.out.println(invalidAccount);
        }
    }

    public void inputPassWord(ResourceBundle bundle) {
        String msg = bundle.getString("password");
        String invalidPass = bundle.getString("invalid.password");
        while (true) {
            String password = in.inputString(msg, invalidPass);
            if (ctrl.checkPassWord(bundle, password)) {
                break;
            }
            System.out.println(invalidPass);
        }
    }

    public void inputCaptcha(ResourceBundle bundle) {
        String msg = bundle.getString("captchaInput");
        String invalidCaptcha = bundle.getString("invalid.captcha");

        System.out.println(bundle.getString("captcha"));
        String captcha = in.randomCaptcha();
        System.out.println(captcha);
        while (true) {

            String captchaInput = in.inputString(msg, invalidCaptcha);
            if (ctrl.checkCaptcha(bundle, captcha, captchaInput)) {
                break;
            }
            System.out.println(invalidCaptcha);
        }
    }


}