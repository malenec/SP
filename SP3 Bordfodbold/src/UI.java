import java.util.Scanner;

public class UI {

    public static String getUserInput (String MSG) {
        System.out.println(MSG);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
}
