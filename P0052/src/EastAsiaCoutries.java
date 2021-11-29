
/**
 *
 * @author Admin
 */
public class EastAsiaCoutries {
    protected String countryCode;
    protected String CountryName;
    protected float totalArea;

    public EastAsiaCoutries() {
    }

    public EastAsiaCoutries(String countryCode, String CountryName, float totalArea) {
        this.countryCode = countryCode;
        this.CountryName = CountryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    
    public void display(){
    }
    
}
