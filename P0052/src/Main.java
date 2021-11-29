
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        ArrayList <Country> list = new ArrayList <>();
        while (true) {
            int choice = ManageEastAsiaCountries.menu();
            switch (choice){
                case 1:
                    ManageEastAsiaCountries.inputCountry(list);
                    break;
                case 2:
                    ManageEastAsiaCountries.displayCountry(list);
                    break;
                case 3:
                    ManageEastAsiaCountries.searchByName(list);
                    break;
                case 4:
                    ManageEastAsiaCountries.sortedCountry(list);
                    break;
                case 5:
                    return;
            }   
        }
    }
}
