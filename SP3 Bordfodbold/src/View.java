public class View {

    public static String showAdminMenu(){
        String s = "MAIN ADMIN MENU: \nCreate new tournament press 1 \n" +
                "Open for registration press 2 \nClose registration press 3 \n" +
                "Create or edit timetable press 4 \nEdit game plan press 5 \nStart match press 6";
        System.out.println(s);
        return s;
    }

    public static void showGamePlan(){
        System.out.println();
    }

    public static void showScoreboard(){
        System.out.println();
    }

    public static void showRegisteredTeams(){

        for (Team t : Tournament.allTeams) {
            System.out.println(t.getTeamName() + ": ");
            for (Player p : t.teamPlayers){
                System.out.print(p.playerName + ", ");
            }
        }
    }

    public static String showRegistrationMenu(){

        String s = "MAIN USER MENU: \nCreate team press 1 \nAdd player press 2 \n" +
                "Remove player press 3 \nRemove team press 4 \nView registered teams press 5";
        System.out.println(s);
        return s;
    }
}
