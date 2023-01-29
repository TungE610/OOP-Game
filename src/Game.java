import java.util.ArrayList;
import java.util.List;

public class Game {
	
	List<Player> playerList = new ArrayList<Player>();
	
	int currentPlayerId; // currently playing player
	
	List<Dice> diceList = new ArrayList<Dice>();

	public Game (List<Player> playerList) {
        // instantiate 4 players and one dice 
		
		String[] randomNames = {"Ronaldo", "Messi", "Kaka", "Benzema"};
		
		int initializePlayerNum = playerList.size();
		
		for (int i = 0 ; i < initializePlayerNum; i++) {
			this.playerList.add(playerList.get(i));
		}
		
		if (initializePlayerNum < 4) {
			for (int i = initializePlayerNum; i < 4; i++) {
				
				int randomNameChoose = (int)Math.floor(Math.random() * (randomNames.length -1));
				String choosenRandomName = randomNames[randomNameChoose];
				
				Player virtualPlayer = new Player(i+1, choosenRandomName);
				this.playerList.add(virtualPlayer);				
			}
		}
                
        currentPlayerId = 1; // player1 is the first-play player
        
        // instantiate dice object
        for (int i =1; i <= 4; i ++) {
        	Dice dice = new Dice(i);
        	
        	diceList.add(dice);
        }
        
	}
	
	public void setCurrentPlayerId (int id) {
		this.currentPlayerId = id;
	}
	
	public int getCurrentPlayerId () {
		return this.currentPlayerId;
	}
	
	public Player getCurrentPlayer () {
		
		return this.playerList.get(currentPlayerId - 1);
		
	}
	
	public void declareTheWinner () {
		System.out.printf("Player %s is the game winner !!\n", this.getCurrentPlayer().getName());
		for (Player p : this.playerList) {
			if (p.equals(this.getCurrentPlayer())) {
				continue;
			}
			p.showLose();
		}
	}

}
