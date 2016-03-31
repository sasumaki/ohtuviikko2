/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sasumaki
 */
public class statisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    public statisticsTest() {
        stats = new Statistics(readerStub);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void searchTest() {
        String name = "Kurri";
        String kurri = stats.search(name).getName();
        assertEquals(kurri, name);

    }

    @Test
    public void searchTest2() {
        String name = "MÄPÄ";
        assertEquals(stats.search(name), null);
    }

    @Test
    public void teamTest() {
        String teamName = "EDM";
        List<String> pelaajat = new ArrayList<String>();
        pelaajat.add(readerStub.getPlayers().get(0).getName());
        pelaajat.add(readerStub.getPlayers().get(2).getName());
        pelaajat.add(readerStub.getPlayers().get(4).getName());
        List<Player> pelaajat2 = stats.team(teamName);
        List<String> nimet = new ArrayList<String>();
        nimet.add(pelaajat2.get(0).getName());
        nimet.add(pelaajat2.get(1).getName());
        
        assertEquals(nimet.get(0), pelaajat.get(0));
        assertEquals(nimet.get(1), pelaajat.get(1));

    }
    @Test
    public void topScorers(){
        List<Player> pelaajat = new ArrayList<Player>();
        pelaajat.add(new Player("Gretzky", "EDM", 35, 89));
        
        assertEquals(stats.topScorers(1).get(0).getName(), pelaajat.get(0).getName());
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
