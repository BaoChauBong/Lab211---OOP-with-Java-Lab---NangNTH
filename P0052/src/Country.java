
/**
 *
 * @author Admin
 */
public class Country extends EastAsiaCoutries implements Comparable<Country> {
    private String countryTerrain;

    public Country() {
    }

    public Country(String countryTerrain, String countryCode, String CountryName, float totalArea) {
        super(countryCode, CountryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public void display() {
        System.out.printf("%-10s%-15s%-25s%-20s\n", this.countryCode, this.CountryName, this.totalArea, this.countryTerrain);
    }
    
    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
   
    @Override
    public int compareTo(Country t) {
        return this.getCountryName().compareTo(t.getCountryName());
    }

    
}
