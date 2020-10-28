public class Doctor implements SeesPatients, Comparable<Doctor> {

    private static int numDoctors = 0;
    private String name;
    private int licenseNumber;
    private Patient [] patients;
    private int numberOfPatients;

    //Constructor

    public Doctor (){
        name = "";
        numDoctors++;
        licenseNumber = numDoctors;
        patients = new Patient [SeesPatients.MAX_PATIENTS];
        numberOfPatients = 0;

    }

    public Doctor (String name){
        this.name = name;
        numDoctors++;
        licenseNumber = numDoctors;
        patients= new Patient[SeesPatients.MAX_PATIENTS];
        numberOfPatients = 0;
    }

    //Doctor Getters
    public static int getNumDoctors(){
        return numDoctors;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public String getName(){
        return name;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    @Override
    public Patient[] getPatients() {
        Patient [] returnPatients = new Patient [numberOfPatients];
        for (int i =0; i<returnPatients.length; i++){
            returnPatients[i] = patients[i]; 
        }
        return returnPatients;
    }

    @Override
    public String getPatientsAsString() {
        String patientsString = "patients= ";
        for(int i=0; i<numberOfPatients; i++){
            patientsString+= String.join(",",patients[i].toString() );
        }

        return patientsString;
    }

    //Doctor Public Methods
    
    @Override
    public void addPatient(Patient p) throws PatientException {
        
        try{
            if (numberOfPatients == SeesPatients.MAX_PATIENTS){
                throw new PatientException(); 
            }
            patients[numberOfPatients] = p;
            numberOfPatients++;
        }
        catch (PatientException pE){
            System.out.print(pE.getMessage() );

        }

    }

    @Override
    public int compareTo(Doctor o) {
        int comparisonVal = numberOfPatients - o.getNumberOfPatients();
        if (comparisonVal > 0 ){
            return 1;
        }
        else if (comparisonVal <0){
            return -1;
        }
        else{
            return 0;
        }
    }

    

    @Override
    public boolean isPatient(Patient p) {
        for( Patient o : patients){
            if ( o.equals(p)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String doctor = String.format("Doctor: name= %20s | license number= %06d | %s", name, licenseNumber, getPatientsAsString() );
        return doctor;
    }

    @Override
    public boolean equals(Object o){
        if( o instanceof Doctor){
            Doctor d = (Doctor) o;
            if (this.compareTo(d) == 0){
                if (name.equals(d.name)){
                        return true;
                }
            }
        }
        return false;
    }

    
}
