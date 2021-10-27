public class Elbil extends Bil {

    private double batterikapacitetKWh;
    private double maxKm;
    private double whPrKm;


    public Elbil(String regNr, String mærke, String model, int årgang, int antalDøre, double batterikapacitetKWh, double maxKm, double whPrKm) {
        super(regNr, mærke, model, årgang, antalDøre);
        this.batterikapacitetKWh = batterikapacitetKWh;
        this.maxKm = maxKm;
        this.whPrKm = whPrKm;
    }

    public double getBatterikapacitetKWh() {
        return batterikapacitetKWh;
    }

    public void setBatterikapacitetKWh(double batterikapacitetKWh) {
        this.batterikapacitetKWh = batterikapacitetKWh;
    }

    public double getWhPrKm() {
        return whPrKm;
    }

    public void setWhPrKm(double maxKm) {
        this.whPrKm = whPrKm;
    }

    @Override
    public String toString() {
        return "Elbil " + super.toString() +
                "batterikapacitetKWh = " + batterikapacitetKWh +
                ", maxKm = " + maxKm + '\n';
    }

    @Override
    public double beregnGrønEjerafgift() {
        double kmPrL = 100/ (whPrKm/91.25);
        double afgift = 330;
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
