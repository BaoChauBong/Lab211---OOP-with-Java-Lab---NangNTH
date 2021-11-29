public class Doctor {
    //field
    String code;
    String name;
    String specialization;
    int availability;
    //cóntructor
    public Doctor(){
        code = "D00";
        name = "Admin";
        specialization = "none";
        availability = 0;
    }
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }
    //setter

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    //getter

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAvailability() {
        return availability;
    }
    
    public void inputInfo(){
        Checking val = new Checking();
        code = val.manageCode("Enter code(Dxx): ", "Invalied input");
        name = val.manageName("Enter name(String): ", "Invalied input");
        specialization = val.manageSpecialization("Enter specialization(String): ", "Invalied input");
        availability = val.manageAvailability("Enter availability(Int): ", "Invalied input", 0, 10);
    }

    @Override
    public String toString() {
        return code+"\t"+name+"\t"+specialization+"\t"+availability;
    }
    
    
}