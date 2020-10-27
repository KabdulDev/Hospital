public class Doctor implements SeesPatients, Comparable<Doctor> {

    private static int numDoctors = 0;
    private String name;
    private int licenseNumber;
    private Patient [] patients;
    private int numberOfPatients;

    //Constructor

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
        return patients;
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
        patients[numberOfPatients] = p;
        numberOfPatients++;

    }

    @Override
    public int compareTo(Doctor o) {
        // TODO Auto-generated method stub
        return 0;
    }

    

    @Override
    public boolean isPatient(Patient p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString(){
        String doctor = String.format("Doctor: name= %20s | license number= %06d | %s", name, licenseNumber, getPatientsAsString() );
        return doctor;
    }

    @Override
    public boolean equals(Object o){


    }

    
}
