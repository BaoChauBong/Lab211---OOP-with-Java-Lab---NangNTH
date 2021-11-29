
import java.util.Random;
import java.util.Scanner;

public class DataInput {

    private final Scanner sc = new Scanner(System.in);

    public int inputInt(String msg, int min, int max) {
        int number;
        while (true) {
            try {
                System.out.print(msg);
                number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.out.println("Please input in range [1-3]");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer number!");
            }
        }
    }

    public String randomCaptcha() {
        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String captcha = "";
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(s.length());
            captcha = captcha + s.charAt(index);
            s = s.substring(0, index) + s.substring(index + 1);
        }
        return captcha;
    }

    public String inputString(String msg, String err) {
        
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (s.isEmpty()) {
                System.out.println(err);
                continue;
            }
            return s;
        }
    }
}