public class Gerontologist extends Doctor {
    private static int patientCutOffYear = 2002;
    private boolean performsHouseCalls;
    private double visitFee;

    //Constructor
    public Gerontologist(){
        super();
        performsHouseCalls = true;
        visitFee= 0.0;
    }

    public Gerontologist (String name){
        super(name);
        performsHouseCalls = true;
        visitFee = 0.0;
    }

    public Gerontologist(String name, boolean performsHouseCalls, double visitFee){
        super(name);
        this.performsHouseCalls = performsHouseCalls;
        this. visitFee = visitFee;
    }

    //Getters
    public boolean performsHouseCalls(){
        return performsHouseCalls;
    }

    public double getVisitFee(){
        return visitFee;
    }

    //Setters
    public void setPerformsHouseCalls(boolean houseCalls){
        this.performsHouseCalls = houseCalls;
    }

    public void setVistFee (double visitFee){
        this.visitFee = visitFee;
    }

    //Public Methods
    @Override
    public void addPatient (Patient p) throws PatientException {
        try{
            if( p.getBirthYear()>=patientCutOffYear){
                throw PatientException;
            }
            super.addPatient(p);
            
        }
        catch (PatientException pE){
            System.out.println(pE.getMessage() ) ;
        }

        
    }

    @Override
    public String toString(){
        String gerontologist = String.format("%s%nGerontologist: %s | visit fee=%02.2f", super.toString(), (performsHouseCalls ? "performs house calls" : "no house calls"), visitFee);

        return gerontologist;

    }

    @Override
    public boolean equals(Object o){
        if( o instanceof Gerontologist){
            super.equals(o);
            Gerontologist g = (Gerontologist) o;
            if(performsHouseCalls== g.performsHouseCalls()){
                if(Math.abs(visitFee-g.getVisitFee() ) <=.05 ){
                    return true;
                }
            }

        }
        return false;
    }

    
}
