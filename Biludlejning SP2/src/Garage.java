import java.util.ArrayList;

public class Garage {

    private String garageNavn;
    private ArrayList <Bil> bilpark;

    public Garage(String garageNavn) {
        this.garageNavn = garageNavn;
        bilpark = new ArrayList<>();
    }

    public void setBilpark(Bil nyBil){
        bilpark.add(nyBil);
    }

    @Override
    public String toString() {
        return "I bilparken er der pt: "+ '\n' + bilpark;
    }

    public double beregnGrønAfgiftForBilpark(){
        double samletAfgift = 0;
        for(Bil b : bilpark){
            samletAfgift += b.beregnGrønEjerafgift();
        }
        return samletAfgift;
    }

    public String getGarageNavn() {
        return garageNavn;
    }

    public void setGarageNavn(String garageNavn) {
        this.garageNavn = garageNavn;
    }
}
