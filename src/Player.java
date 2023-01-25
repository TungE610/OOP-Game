
public class Player {
	
    private int id;
    private String name;
    private int score;
 
    
	public Player(int id, String name) { 
		
        this.id = id;
        this.name = name;
        this.score = 0; // initialize with score = 0;
	}
	public int getCurrentScore () {
		return this.score;
	}
	
	public String getName () {
		return this.name;
	}
	
    public void updateScore(int currentDice) {
        this.score = currentDice;
    }
    
    public void notifyScore () {
    	System.out.printf("\nPlayer %s has %d scores !!", this.name, this.score);
    }
    
}
