import java.io.FileWriter;
import java.io.IOException;

public class User {

    public static String MSG = "Write you answer below:"; //todo: clean up the double questions

    public static void userMenu(){
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            View.showGamePlan();
            View.showScoreboard();
            View.showRegistrationMenu();
            Main.input = UI.getUserInput(MSG);
            if (Main.input.equalsIgnoreCase("x")) {
                Main.mainMenu();
            }else if (Main.input.equals("1")) {
                createTeam();
            } else if (Main.input.equals("2")) {
                removePlayerFromTeam();
            } else if (Main.input.equals("3")) {
                addPlayerToTeam();
            } else if (Main.input.equals("4")) {
                removeTeam();
        } else if (Main.input.equals("5")) {
                View.showRegisteredTeams();
            }else {
                System.out.println("Not a valid answer, please try again \n");
                rerunBoolean = true;
            }
        } while(rerunBoolean==true);
    }

    public static void createTeam(){
        System.out.println("You have chosen to create a team \nTo return to the main menu press Q \nWrite team name here: ");
        Main.input = UI.getUserInput("");
        if (Main.input.equalsIgnoreCase("Q")) {
            userMenu();
        }else {
            Tournament.allTeams.add(new Team(Main.input));
        }

    }

    public static void removeTeam(){
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            System.out.println("To return to the main menu press Q \nWrite team name here to remove team: ");
            Main.input = UI.getUserInput("");
            if (Main.input.equalsIgnoreCase("Q")) {
                userMenu();
            } else {
                boolean teamExists = false;
                for (Team team : Tournament.allTeams) {
                    if (team.getTeamName().equals(Main.input)) {
                        teamExists = true;
                    }
                }
                if (teamExists == false) {
                    System.out.println("That team name does not exist");
                    rerunBoolean = true;

                } else if (teamExists == true) {
                    for (Team t : Tournament.allTeams) {
                        if (t.getTeamName().equals(Main.input)) {
                            Tournament.allTeams.remove(t);
                        }
                    }
                }
            }
        } while (rerunBoolean == true);
    }

    public static void addPlayerToTeam(){
        System.out.println("You have chosen to add a player \nTo return to the main menu press Q");
        Main.input = UI.getUserInput(MSG);
        if (Main.input.equalsIgnoreCase("Q")) {
            userMenu();
        }
    }

    public static void removePlayerFromTeam(){
        System.out.println("You have chosen to remove a player \nTo return to the main menu press Q");
        Main.input = UI.getUserInput(MSG);
        if (Main.input.equalsIgnoreCase("Q")) {
            userMenu();
        }
    }

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
}


