
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class ManageEastAsiaCountries {
    public static Scanner sc = new Scanner (System.in);
    
    public static int menu(){
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = checkInput(1, 5);
        return choice;
    }

    private static int checkInput(int a, int b) {
        while (true){
            try {
                int re = Integer.parseInt(sc.nextLine());
                if (re < a || re > b){
                    throw new Exception();
                }
                return re;
            }
            catch (Exception e){
                System.out.println("Enter choice from " + a + " to " + b);
                System.out.print("Enter again: ");
            }
        }
    }
    
    // Check String
    public static String checkString (){
        while (true){
            String re = sc.nextLine();
            if (re.isEmpty()){
                System.out.println("Error!");
                System.out.print("Enter again: ");
            }
            else {
                return re;
            }
        }
    }
    
    // Check Double
    public static double checkDouble(){
        while (true){
            try {
                double re = Double.parseDouble(sc.nextLine());
                return re;
            }
            catch (Exception e){
                System.out.println("Enter Double number: ");
                System.out.print("Enter again: ");
            }
        }
    }
    
    // Enter Coutry
    public static void inputCountry (ArrayList <Country> list){
        String con = "y";
        do {
            System.out.println("Enter code of country: ");
            String countryCode = checkString();
            // Check code exist or not
            if (!checkExistCountry(list, countryCode)){
                System.out.println("Country exist!");
            }
        
            System.out.println("Enter name of country: ");
            String countryName = checkString();
        
            System.out.println("Enter total area: ");
            double totalArea = checkDouble();
        
            System.out.println("Enter terrain of country: ");
            String countryTerrain = checkString();
        
            list.add(new Country (countryTerrain, countryCode, countryName, (float) totalArea));
            System.out.println("Add succesful!");
        
            System.out.println("Nhấn phím y để tiếp tục, nhấn q để thoát!");
            con = sc.nextLine();
            if (con == "q"){
                System.out.println("Thoát chương trình!");
            }
        }
        while (con == "y");
        }
    
     
    private static boolean checkExistCountry(ArrayList<Country> list, String countryCode) {
        for (Country country : list) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)){
                return false;
            }
        }
        return true;
    }
    
    // Display country
    public static void displayCountry (ArrayList <Country> list){
        String con = "y";
        do {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        
            for (Country country : list) {
                country.display();
            }
            System.out.println();
            
            System.out.println("Nhấn phím y để tiếp tục, nhấn q để thoát!");
            con = sc.nextLine();
            if (con == "q"){
                System.out.println("Thoát chương trình!");
            }
        }
        while (con == "y");
        }
        
    // Search by Name
    public static void searchByName (ArrayList <Country> list){
        String con = "y";
        do {
            System.out.println("Enter the name you want to search for: ");
            String countryName = checkString();
            System.out.printf("%-10s%-15s%-25s%-20s\n", "ID", "Name", "Total Area", "Terrain");
            for (Country country : list) {
                if (country.getCountryName().equalsIgnoreCase(countryName)){
                    country.display();
                }
            }
            System.out.println();
        
            con = sc.nextLine();
            if (con == "q"){
                System.out.println("Thoát chương trình!");
            }
         }
        while (con == "y");
    }
    
    
    // Sorting name in ascending
    public static void sortedCountry (ArrayList <Country> list){
        String con = "y";
        do {
            Collections.sort(list);
            System.out.printf("%-10s%-15s%-25s%-20s\n", "ID", "Name", "Total Area", "Terrain");
            for (Country country : list) {
                country.display();
            }
            System.out.println();
            
            con = sc.nextLine();
            if (con == "q"){
                System.out.println("Thoát chương trình!");
            }
        }
        while (con == "y");
    }
    
}
