package elocalc;
import java.util.Random;
import java.lang.Object;

public class ELOcalc {

    public static void main(String[] args) {
        
        player player1 = new player();  // player creation
        player1.elo = 1500.0;
        player1.winChance = .5;
        player player2 = new player();
        player2.elo = 1600.0;
        player2.winChance = .5;
        
        player1.winningOdds(player1, player2);
        
    }
}
