public class Pediatrician extends Doctor {
    private static int patientCutOffYear = 2002;
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
    @Override
    public void addPatient(Patient p) throws PatientException {
        try{
            if( p.getBirthYear()<=patientCutOffYear){
               throw new PatientException("Patient too old");
            }
            super.addPatient(p);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String toString(){
        String test = String.format("%s%nPediatrician: %s | hospital name=%15s", super.toString(), hasPrivatePractice, hospitalName);
        return test;
    }

    public boolean equals(Object o){
        if (o instanceof Pediatrician){
            super.equals(o);
            Pediatrician p = (Pediatrician) o;
            if (hasPrivatePractice == p.hasPrivatePractice()){
                if (hospitalName.equals(p.getHospitalName())){
                    return true;
                }
            }
        }
        
        
        return false;
    }

}
