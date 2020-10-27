public class Pediatrician extends Doctor {
    private boolean hasPrivatePractice;
    private String hospitalName;


    //Constructors
    public Pediatrician(String name){
        super(name);
        hasPrivatePractice = false;
        hospitalName = "";
    }

    public Pediatrician(String name, boolean practice, String hospitalName){
        super(name);
        hasPrivatePractice = practice;
        this.hospitalName = hospitalName;
    }

    //Getters
    public boolean hasPrivatePractice(){
        return hasPrivatePractice;
    }

    public String getHospitalName(){
        return hospitalName;
    }

    //Setters
    public void setHospitalName (String hospitalName){
        this.hospitalName = hospitalName;
    }

    //Methods
    public void addPatient(Patient p) throws PatientException {

    }

    public String toString(){
        String test= super.toString();
        test += String.format("\nPediatrician: %s | hospital name=%15s", hasPrivatePractice, hospitalName);
        return test;
    }

    public boolean equals(){

    }

}
