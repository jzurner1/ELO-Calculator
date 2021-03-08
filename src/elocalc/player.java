package elocalc;

public class player {
    public double winChance;  // adjusts depending on elo
    public double elo;
    
    
    
    public void play(player playerName) {
        // idk yet
    }
    
    public double winningOdds(player first, player second) {
        // x = elo difference
        // y = win probability
    	
    	double eloDiff = Math.abs(first.elo - second.elo);  // calculates elo difference
    	double tempNum = Math.pow(10, (-eloDiff / 400));  // equation part 1
    	double p1odds = 1 / (1 + tempNum);  // equation part 2
    	return(p1odds);  // return odds
    	
    }
}
