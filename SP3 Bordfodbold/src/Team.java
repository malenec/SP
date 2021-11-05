import java.util.ArrayList;

public class Team {

    private String teamName;
    public int totalScore = 0;
    public int numberOfGoals = 0;
    public ArrayList<Player> teamPlayers = new ArrayList<>();

    public Team(String teamName){

        this.teamName = teamName;
    }

    public void addPlayer(String name, String schoolClassName, int phoneNumber){

        teamPlayers.add(new Player(name, schoolClassName, phoneNumber));
    }

    public void removePlayer(String name){
        for(Player p: teamPlayers) {
            if (p.playerName.equals(name)) {
                teamPlayers.remove(p);
            }
        }

    }

    public String getTeamName(){
        return teamName;
    }


    @Override
    public String toString() {
        return "Team: " + teamName + '\'' +
                ", teamPlayers=" + teamPlayers;
    }
}
