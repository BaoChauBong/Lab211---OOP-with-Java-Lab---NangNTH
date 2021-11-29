
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ebank {

    static Scanner u = new Scanner(System.in);

    static ResourceBundle rb;
    static Locale localeEn = new Locale("en");
    static Locale localeVi = new Locale("vi");

    public static void setLocale(Locale locale) throws Exception {
        rb = ResourceBundle.getBundle("Language", locale);
    }

    public Ebank() {
    }

    public String checkAccount(String account) {
        while (true) {
            Pattern p = Pattern.compile("^[0-9]{10}$");
            if (p.matcher(account).find()) {
                return account;
            } else {

                return rb.getString("username_error");
            }
        }
    }

    public String checkPassword(String password) {
        while (true) {

            Pattern p = Pattern.compile("^[0-9A-Za-z]{8,31}$");
            Pattern pDigit = Pattern.compile("^[0-9A-Za-z]*[0-9]+[0-9A-Za-z]*$");
            Pattern pAlpha = Pattern.compile("^[0-9A-Za-z]*[A-Za-z]+[0-9A-Za-z]*$");
            if (p.matcher(password).find() && pDigit.matcher(password).find()
                    && pAlpha.matcher(password).find()) {
                return password;
            } else {

                return rb.getString("password_error");
            }
        }
    }

    public String generateCaptcha() {
        StringBuilder sb = new StringBuilder();
        String captcha = "";
        Random rd = new Random();
        int x;
        char ch;
        for (int i = 0; i < 6; i++) {
            x = rd.nextInt(74) + 48;
            if (x > 57 && x < 65) {
                x += 7;
            }
            if (x > 90 && x < 97) {
                x += 6;
            }
            ch = (char) x;
            sb.append(ch);

        }
        captcha += sb;
        return captcha;
    }

    public boolean checkGenerateCaptcha(String captcha) {
        String p = ".*[0-9].*";
        String pUpper = ".*[A-Z].*";
        String pLower = ".*[a-z].*";
        return (captcha.matches(p) && captcha.matches(pUpper) && captcha.matches(pLower));
    }

//    public String checkCaptcha(String captchaInput, String captchaCode) {
//        boolean verify;
//        while (true) {
//            verify = captchaInput.equals(captchaCode);
//            if (verify) {
//                System.out.println(rb.getString("verify"));
//                return captchaInput;
//
//            }
//            return rb.getString("captcha_error");
//
//        }
//    }
    public String checkCaptcha(String captchaInput, String captchaCode) {
        boolean verify;
        while (true) {
            if (captchaInput.isEmpty()) {
            } else {
                verify = captchaCode.contains(captchaInput);

                System.out.println(rb.getString("verify"));
                return captchaInput;
            }
            return rb.getString("captcha_error");

        }

    }

    public void login() {
        String accountMsg, passwordMsg, captchaMsg;
        String accountErrMsg, passwordErrMsg, captchaErrMsg;
        accountErrMsg = rb.getString("username_error");
        passwordErrMsg = rb.getString("password_error");
        captchaErrMsg = rb.getString("captcha_error");
        String account, password, captchaInput;
        while (true) {
            System.out.print(rb.getString("username"));
            account = u.nextLine();
            accountMsg = checkAccount(account);
            if (accountMsg.equals(accountErrMsg)) {
                System.err.println(accountErrMsg);
                continue;
            }
            break;
        }

        while (true) {
            System.out.print(rb.getString("password"));
            password = u.nextLine();
            passwordMsg = checkPassword(password);
            if (passwordMsg.equals(passwordErrMsg)) {
                System.err.println(passwordErrMsg);
                continue;
            }
            break;
        }

        String captchaCode = generateCaptcha();
        System.out.println(captchaCode);
        while (true) {
            System.out.print(rb.getString("captcha"));
            captchaInput = u.nextLine();
            captchaMsg = checkCaptcha(captchaInput, captchaCode);
            if (captchaMsg.equals(captchaErrMsg)) {
                System.err.println(captchaErrMsg);
                continue;
            }
            break;
        }

    }
}
