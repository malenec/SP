import java.lang.reflect.Array;
import java.util.ArrayList;

public class Knockout extends Tournament{
    ArrayList<Team[]> gamePlan = new ArrayList<>();
    ArrayList<Integer> chosenIndexes = new ArrayList<>();


    // Makes an ArrayList of Arrays with match up of teams
    @Override
    public void makeGamePlan() {
        Team[] matchUp = new Team[2];

        for(int j = 0; j < Tournament.allTeams.size(); j++) {
            boolean continueBoolean = false;
            int randomInteger;

            if(matchUp[0] != null && matchUp[1] != null) {
                gamePlan.add(matchUp);
                matchUp[0] = null;
                matchUp[1] = null;
            }

            do {
                continueBoolean = true;
                randomInteger = (int) Math.floor(Math.random() * Tournament.allTeams.size());
                System.out.println(randomInteger);

                for (int i = 0; i < chosenIndexes.size(); i++) {
                    if (randomInteger == chosenIndexes.get(i)) {
                        continueBoolean = false;
                    }
                }
            } while (continueBoolean == false);

            chosenIndexes.add(randomInteger);
            Team chosenTeam = Tournament.allTeams.get(randomInteger);

            if (matchUp[0] != null) {
                matchUp[1] = chosenTeam;
            } else {
                matchUp[0] = chosenTeam;
            }


        }
        gamePlan.add(matchUp);


    }

    public void getType () {
        System.out.println("This is a knockout tournament");
    }

}

