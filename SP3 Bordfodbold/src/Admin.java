public class Admin {

    public String tournamentTypeChoice;
    public static String MSG = "Write you answer below:";

    public static void adminMainMenu() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            View.showAdminMenu();
            Main.input = UI.getUserInput(MSG);

            Main.input = UI.getUserInput(MSG);
            if (Main.input.equalsIgnoreCase("x")) {
                Main.mainMenu();
            } else if (Main.input.equals("1")) {
                createTournament();
            } else if (Main.input.equals("2")) {
                openRegistration();
            } else if (Main.input.equals("3")) {
                closeRegistration();
            } else if (Main.input.equals("4")) {
                setTimetable();
            } else if (Main.input.equals("5")) {
                editGamePlan();
            } else if (Main.input.equals("6")) {
                startMatch();
            } else {
                System.out.println("Not a valid answer, please try again \n");
                rerunBoolean = true;
            }
        } while(rerunBoolean==true);

    }

    public static Tournament createTournament() {
        Tournament chosenTournament = new Tournament();
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
        System.out.println("You have chosen to create a new tournament \nTo return to the main menu press Q\n\nTo create a Knockout Tournament write knockout\nTo create a Group Tournament write group");
        Main.input = UI.getUserInput(MSG);
        if (Main.input.equalsIgnoreCase("Q")) {
            adminMainMenu();
        }else if(Main.input.equalsIgnoreCase("knockout")){
            chosenTournament = new Knockout();
        }else if(Main.input.equalsIgnoreCase("group")) {
            chosenTournament = new GroupTournament();
        }else{System.out.println("Not a valid answer, please try again \n");
            rerunBoolean = true;}}
        while(rerunBoolean==true);
        chosenTournament.getType();
        return chosenTournament;
    }

        public static void openRegistration () {
            boolean rerunBoolean;
            do {
                    rerunBoolean = false;
                System.out.println("You have chosen to open for registration \nTo return to the main menu press Q " +
                        "\nTo open the registration press 1");
                Main.input = UI.getUserInput(MSG);
                if (Main.input.equalsIgnoreCase("Q")) {
                    adminMainMenu();
                }else if (Main.input.equalsIgnoreCase("1")){
                    Tournament.registrationIsOpen = true;
                } else{System.out.println("Not a valid answer, please try again \n");
                    rerunBoolean = true;}}
            while(rerunBoolean==true);

        }

            public static void closeRegistration () {
                boolean rerunBoolean;
                do {
                    rerunBoolean = false;
                    System.out.println("You have chosen to close the registration \nTo return to the main menu press Q " +
                            "\nTo close the registration press 1");
                    Main.input = UI.getUserInput(MSG);
                    if (Main.input.equalsIgnoreCase("Q")) {
                        adminMainMenu();
                    }else if (Main.input.equalsIgnoreCase("1")){
                        Tournament.registrationIsOpen = false;
                    } else{System.out.println("Not a valid answer, please try again \n");
                        rerunBoolean = true;}}
                while(rerunBoolean==true);

            }

            public static void setTimetable () {
                System.out.println("You have chosen to create or edit the timetable \nTo return to the main menu press Q");
                Main.input = UI.getUserInput(MSG);
                if (Main.input.equalsIgnoreCase("Q")) {
                    adminMainMenu();
                }
            }

            public static void editGamePlan () {
                System.out.println("You have chosen to edit the game plan \nTo return to the main menu press Q");
                Main.input = UI.getUserInput(MSG);
                if (Main.input.equalsIgnoreCase("Q")) {
                    adminMainMenu();
                }
            }

            public static void startMatch () {
                System.out.println("You have chosen to start a match \nTo return to the main menu press Q");
                Main.input = UI.getUserInput(MSG);
                if (Main.input.equalsIgnoreCase("Q")) {
                    adminMainMenu();
                }
            }


}
