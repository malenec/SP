public class Player {

    String playerName;
    String schoolClassName;
    int phoneNumber;

    public Player(String playerName, String schoolClassName, int phoneNumber) {
        this.playerName = playerName;
        this.schoolClassName = schoolClassName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PLAYER NAME: " + playerName + " FROM SCHOOL CLASS: " + schoolClassName;
    }
}




