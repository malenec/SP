import java.util.Locale;

public class Main {

    public static String input = "";

    public static void main(String[] args) {
        // ASK IF USER OR ADMIN. SHOW MENUS

        mainMenu();
        Tournament knockout = new Knockout();


    }

    public static void mainMenu() {
        boolean rerunBoolean;
        do {
            rerunBoolean = false;
            input = UI.getUserInput("Are you a User or an Admin?: \n").toLowerCase();
            if (input.equals("admin")) {
                Admin.adminMainMenu();
            } else if (input.equals("user")) {
                User.userMenu();
            } else {
                System.out.println("Something went wrong. Please try again");
                rerunBoolean = true;
            }

        } while (rerunBoolean == true);

    }

}
