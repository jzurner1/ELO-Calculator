package elocalc;
import java.util.Random;
import java.util.ArrayList;

public class ELOcalc {

    public static void main(String[] args) {
        
        player player1 = new player();  // player creation
        player1.elo = 1500.0;
        player player2 = new player();
        player2.elo = 1500.0;
        player player3 = new player();
        player3.elo = 1500.0;
        player player4 = new player();
        player4.elo = 1500.0;
        player player5 = new player();
        player5.elo = 1500.0;
        
        // player1.winningOdds(player1, player2);
        // format for testing odds of player1 vs player2
        
        ArrayList<player> playerList = new ArrayList<player>();  // create list of players
        playerList.add(player1);  // add players to list
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5);

        
        
        for (int i = 0; i < playerList.size(); i++) {  // repeats for every player in playerlist
        	
        	// function that returns a valid integer given current i value
        	int validNum = returnValid(i, playerList.size());
        	
        	player winner = pickWinner(playerList.get(i), playerList.get(validNum));  // winner announcement
        	if (winner == playerList.get(i)) {
        		System.out.println("Winner is " + playerList.get(i) + " with an elo of " + playerList.get(i).elo);
        	} else if (winner == playerList.get(validNum)) {
        		System.out.println("Winner is " + playerList.get(validNum) + " with an elo of " + playerList.get(validNum).elo);
        	}
        }
        
        
        System.out.println(player1.elo);
        System.out.println(player2.elo);
        System.out.println(player3.elo);
        System.out.println(player4.elo);
        System.out.println(player5.elo);
    }
    
    
    
    public static int returnValid(int ivalue, int listSize) {  // returns integer != i value
    	Random rand = new Random();  // pick random int
    	int upperbound = listSize;
    	
    	boolean validNum = false;
    	
    	while (!validNum) {
        	int randomInt = rand.nextInt(upperbound);
        	if (randomInt != ivalue) {
        		validNum = true;
        		return randomInt;
        	}
    	}
    	return 0;
    }
    
    
    
    public static player pickWinner(player playerA, player playerB) {  // takes 2 players, returns the winner
    	
    	playerA.winChance = playerA.winningOdds(playerA, playerB);
    	System.out.println(playerA.winChance);
    	
    	Random rand = new Random();  // pick a random number 0 to 1
    	double randomInt = rand.nextInt(100);
    	randomInt /= 100;
    	
    	
    	// adjusts elo after winning / losing
    	double expectedScoreA = 1 / (1 + Math.pow(10, (playerA.elo - playerB.elo) / 400));  // player A expected score
    	double expectedScoreB = 1 / (1 + Math.pow(10, (playerB.elo - playerA.elo) / 400));  // player B expected score
    	if (randomInt <= playerA.winChance) {
    		playerA.elo = playerA.elo + 24 * (1 - expectedScoreA);
    		playerB.elo = playerB.elo + 24 * (0 - expectedScoreB);
    	} else {
    		playerA.elo = playerA.elo + 24 * (0 - expectedScoreA);
    		playerB.elo = playerB.elo + 24 * (1 - expectedScoreB);
    	}
    	
    	
    	
    	if (randomInt <= playerA.winChance) {
    		return playerA;
    	} else {
    		return playerB;
    	}
    }
}
