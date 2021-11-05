import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class matadorEx {

    /*
    public static void main(String [] arg){

        ui = new UI();
        //Få noget spiller data ind enten ved at læse det eller ved at starte en brugerdialog
        try {
            readGameData();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            ui.createAccounts();
        }
        printAccounts();

        //Byg spillepladen
        String [] data = readFileData();
        board = new Board(data);


        runLoop();
        saveGameData();
    }
    /**
     * Starter en dialog med brugeren så denne kan oprette op til 6(MAX) konti
     * todo: kod denne om sådan at man kan slippe ud af loopet selvom der kun er 3 deltagere
     * pseudo kode:
     *  tilføj quit mulighed i besked til brugeren
     *  før konstruktor kald, tjek om denne blev valgt
     *  break hvis det er tilfældet
     */
    public void createAccounts() {

        int i = 0;
        while(i<Main.MAX ){
            String input = getUserInput("Navn? (eller Q for at quitte) ");
            if(input.equalsIgnoreCase("Q")){
                break;
            }

            Main.players.add(new Player(input, 30000));
            i++;
        }
    }
     */
    /**
     *
     * Denne metode gemmer sessionens tilstand,
     * instantier en gamedata tekst-streng (String)
     * loop igennem accounts, og for hver linie tilføj data i formen "ejer:balance" til strengen
     * instantier FileWriter og kald dens write med den opbyggede streng som argument
     *
     */
    private static void saveTeamData() {
        String teamdata = "";

        for (Team t : Tournament.allTeams) {
            teamdata += t;
        }

        try {
            FileWriter writer = new FileWriter("src/Teams.txt");
            writer.write(teamdata);
            writer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Indlæser gamedata og danner spillerinstanser på baggrund af data
     * objekterne gemmes herefter i denne klasses ArrayList<Players>
     *
     *   'throws FileNotFoundException' i metodesignaturen fordi vi hellere vil fange indlæsningsfejl oppe i main
     *   - i de tilfælde kan vi i stedet igangsætte en dialog til manuel indtastning af spiller data
     */
    private static void readGameData() throws FileNotFoundException{
        File file = new File("src/data.txt");
        Scanner scan = null;

        scan = new Scanner(file);

        while(scan.hasNextLine()){
            String [] values = scan.nextLine().split(":");
            int converted_int = Integer.parseInt(values[1]);
            Player p = new Player(values[0], converted_int);
            players.add(p);
        }
    }
}
