import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Before


    public void setUp() throws Exception {
        Team testTeam = new Team("De Sejeste");
        testTeam.addPlayer("Malene", "Dat1B", 42752212);
        testTeam.addPlayer("Sofia", "Dat1B", 123455678);
        testTeam.addPlayer("Kristian", "Dat1B",87654321);
        testTeam.addPlayer("Betül","Dat1B",12468123);
    }

    @Test
    public void testToString() {
        return "Team: " + teamName + '\'' +
                ", teamPlayers=" + teamPlayers;

    }
}