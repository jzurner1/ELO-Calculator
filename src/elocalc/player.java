package elocalc;

public class player {
    public double winChance;  // adjusts depending on elo
    public double elo;
    
    
    
    public void play(player playerName) {
        // idk yet
    }
    
    public void winningOdds(player first, player second) {
        // x = elo difference
        // y = win probability
    	
    	double eloDiff = Math.abs(first.elo - second.elo);
    	double tempNum = Math.pow(10, (-eloDiff / 400));
    	double p1odds = 1 / (1 + tempNum);
    	System.out.println(p1odds);
    	
    }
}
