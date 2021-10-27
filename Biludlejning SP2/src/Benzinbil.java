public class Benzinbil extends Bil {

    private int oktantal;
    private double kmPrL;

    public Benzinbil(String regNr, String mærke, String model, int årgang, int antalDøre, int oktantal, double kmPrL) {
        super(regNr, mærke, model, årgang, antalDøre);
        this.oktantal = oktantal;
        this.kmPrL = kmPrL;
    }

    public int getOktantal() {
        return oktantal;
    }

    public void setOktantal(int oktantal) {
        this.oktantal = oktantal;
    }

    public double getKmPrL() {
        return kmPrL;
    }

    public void setKmPrL(double kmPrL) {
        this.kmPrL = kmPrL;
    }

    @Override
    public String toString() {
        return "Benzinbil " + super.toString() +
                "oktantal = " + oktantal +
                ", kmPrL = " + kmPrL + '\n';
    }

    @Override
    public double beregnGrønEjerafgift() {
        int afgift = 330;
        if (kmPrL >= 20 && kmPrL <= 50){
            afgift = 330;
        }else if(kmPrL < 20 && kmPrL >= 15){
            afgift = 1050;
    }else if(kmPrL < 15 && kmPrL >= 10){
        afgift = 2340;
        }else if(kmPrL < 10 && kmPrL >= 5){
            afgift = 5500;}
        else if(kmPrL < 5 ){
            afgift = 10470;}
        return afgift;
    }
}
