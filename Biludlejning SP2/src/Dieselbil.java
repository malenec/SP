public class Dieselbil extends Bil {

    private boolean harPartikelfilter;
    private double kmPrL;

    public Dieselbil(String regNr, String mærke, String model, int årgang, int antalDøre, boolean harPartikelfilter, double kmPrL) {
        super(regNr, mærke, model, årgang, antalDøre);
        this.harPartikelfilter = harPartikelfilter;
        this.kmPrL = kmPrL;
    }

    public boolean isHarPartikelfilter() {
        return harPartikelfilter;
    }

    public void setHarPartikelfilter(boolean harPartikelfilter) {
        this.harPartikelfilter = harPartikelfilter;
    }

    public double getKmPrL() {
        return kmPrL;
    }

    public void setKmPrL(double kmPrL) {
        this.kmPrL = kmPrL;
    }

    @Override
    public String toString() {
        return "Dieselbil " + super.toString() +
                "harPartikelfilter = " + harPartikelfilter +
                ", kmPrL = " + kmPrL + '\n';
    }

    @Override
    public double beregnGrønEjerafgift() {
        int afgift = 330;
        int partikeludledningsafgift = 1000;
        if (kmPrL >= 20 && kmPrL <= 50){
            afgift = 330+130;
        }else if(kmPrL < 20 && kmPrL >= 15){
            afgift = 1050+1390;
        }else if(kmPrL < 15 && kmPrL >= 10){
            afgift = 2340+1850;
        }else if(kmPrL < 10 && kmPrL >= 5){
            afgift = 5500+2770;
        }else if(kmPrL < 5 ){
            afgift = 10470+15260;
        }
        if(harPartikelfilter==true){
            return afgift;
        }else{
            return afgift + partikeludledningsafgift;
        }
    }
}
