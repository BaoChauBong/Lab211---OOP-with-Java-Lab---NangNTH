
import java.util.*;

public class Main {

    static Scanner u = new Scanner(System.in);
    static Ebank e = new Ebank();

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("================ Menu ================");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1 --> 3): ");

            while (true) {
                if (!u.hasNextInt()) {
                    u.next();
                    System.err.print("Wrong Input. Please enter your item: ");
                    continue;
                }
                choice = u.nextInt();
                u.nextLine();
                if (choice < 1 || choice > 3) {
                    System.err.print("Wrong Input. Please enter your item: ");
                    continue;
                }
                break;
            }
            if (choice == 3) {
                return;
            }
            switch (choice) {
                case 1:
                    try {
                        e.setLocale(e.localeVi);
                    } catch (Exception ex) {
                    }
                    e.login();
                    break;

                case 2:
                    try {
                        e.setLocale(e.localeEn);
                    } catch (Exception ex) {
                    }
                    e.login();
                    break;
            }
        }

    }

    

}
