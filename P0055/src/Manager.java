
import java.util.ArrayList;

public class Manager {
    ArrayList<Doctor> list = new ArrayList<>();

    public Manager() {
    }

    public void setList(ArrayList<Doctor> list) {
        this.list = list;
    }

    public ArrayList<Doctor> getList() {
        return list;
    }
    
    public boolean compareCode(String doctorCode){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCode().equals(doctorCode)){
                return true;
            }
        }
        return false;
    }
    
    public int getDoctorID(String doctorCode){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCode().equals(doctorCode)){
                return i;
            }
        }
        return -1;
    }    
    
    public Doctor searchDoctor(String doctorCode){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCode().equals(doctorCode)){
                return list.get(i);
            }
        }
        return null;
    }
    
    public Doctor searchDoctorName(String doctorName){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(doctorName)){
                return list.get(i);
            }
            if(list.get(i).getName().contains(doctorName)){
                return list.get(i);
            }
        }
        
        return null;
    }
    
    public void addInfo(){
        Doctor doctorInfo = new Doctor();
        System.out.println("----------------Add info-----------------------------");
        doctorInfo.inputInfo();
        if(compareCode(doctorInfo.getCode())){
            System.out.println("There is already a doctor with that code");
            System.out.println("Please try again.");
        }else{
            list.add(doctorInfo);
//            System.out.println(searchDoctor(doctorInfo.getCode()));
            System.out.println("Doctor info has been added");
        }
    }    
    
    public void updateInfo(){
       Checking val = new Checking();
        String doctorCode;
        String doctorName;
        String doctorS;
        int doctorA;
        Doctor x = new Doctor();
        System.out.println("--------------------Update Doctor---------------------------------------------");
        if(list.isEmpty()){
            System.out.println("The list is currently empty");
        }else{
            doctorCode = val.manageCode("Enter doctor code(Dxx): ", "Invalied input");
            if(compareCode(doctorCode)){
                if(searchDoctor(doctorCode) != null){
                    doctorName = val.manageName("Enter doctor name(String): ", "Invalied input");
                    doctorS = val.manageSpecialization("Enter specialization(String): ", "Invalied input");
                    doctorA = val.manageAvailability("Enter availability(Int): ", "Invalied input", 0, 10);
                    x = searchDoctor(doctorCode);
                    x.setName(doctorName);
                    x.setSpecialization(doctorS);
                    x.setAvailability(doctorA);
                }else{
                    System.out.println("There is something wrong with the list");
                }
            }else{
                System.out.println("There is no doctor with that code");
            }            
        }
    }
    
    public void removeInfo(){
        Checking val = new Checking();
        String doctorCode;
        if(list.isEmpty()){
            System.out.println("The list is currently empty");
        }else{
            System.out.println("-------------Deleted Doctor-------------------------------");        
            doctorCode = val.manageCode("Enter doctor code(Dxx): ", "Invalied input");
            if(compareCode(doctorCode)){
                list.remove(getDoctorID(doctorCode));
                System.out.println("Doctor info has been remove");
            }else{
                System.out.println("There is no doctor with that code");
            }            
        }
    }
    
    public void searchInfo(){
        Checking val = new Checking();
        String doctorCode;
        System.out.println("--------------------Search Doctor--------------------------");
        if(list.isEmpty()){
            System.out.println("The list is currently empty");
        }else{
            doctorCode = val.manageCode("Enter doctor code(Dxx): ", "Invalied input");
            System.out.println("--------------------Result---------------------------------");
            if(searchDoctor(doctorCode) != null){
                System.out.println("Code\tName\tSpecialization\tAvailability");
                //ASK Question about this part
                System.out.println(searchDoctor(doctorCode));
            }else{
                System.out.println("There is no doctor with that code");
            }
        }            
    }
    public void searchInfo2(){
        Checking val = new Checking();
        String doctorName;
        System.out.println("--------------------Search Doctor--------------------------");
        if(list.isEmpty()){
            System.out.println("The list is currently empty");
        }else{
            doctorName = val.manageName("Enter doctor Name: ", "Invalied input");
            System.out.println("--------------------Result---------------------------------");
            if(searchDoctorName(doctorName) != null){
                System.out.println("Code\tName\tSpecialization\tAvailability");
                //ASK Question about this part
                System.out.println(searchDoctorName(doctorName));
            }else{
                System.out.println("There is no doctor with that code");
            }
        }            
    }
}