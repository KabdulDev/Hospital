public class Gerontologist extends Doctor {

    private boolean performsHouseCalls;
    private double visitFee;

    //Constructor
    public Gerntologist (String name){
        super(name);
        performsHouseCalls = true;
        visitFee = 0.0;
    }

    public Gerontologist(String name, boolean performsHouseCalls, double visitFee){
        super(name);
        this.performsHouseCalls = performsHouseCalls;
        this. visitFee = visitFee;
    }
    
}
