import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Referee {
    	
	Game myGame;
	Dice playingDice;
	
	public Referee() {
		// TODO Auto-generated constructor stub
	}
	
	public void startGame () {
		
		String playerNum;
		int playerInt = 0;
		List<Player> initializedPlayerList = new ArrayList<Player>();
		String initializedName;
		
		playerNum = JOptionPane.showInputDialog("Please Input player number: ");
		playerInt = Integer.parseInt(playerNum);
		
		for (int i = 0; i < playerInt; i++) {
			
			String nameInputString;
			if (i == 0) {
				nameInputString = "Please input the first player's name : ";
			} else if (i == 1) {
				nameInputString = "Please input the second player's name : ";
			} else if (i == 2) {
				nameInputString = "Please input the third player's name : ";
			} else {
				nameInputString = "Please input the 4th player's name : ";
			}
			
			initializedName = JOptionPane.showInputDialog(nameInputString);
			Player newPlayer = new Player(i+1, initializedName);
			initializedPlayerList.add(newPlayer);
			
		}
		
		myGame = new Game(initializedPlayerList);

		myGame.setCurrentPlayerId(1);
        
        
        while(true) {
        	
        	System.out.printf("Player %d is playing ... \n", myGame.getCurrentPlayerId());
        	

        	// choosen dice 
        	
        	int chooseDice = (int) Math.floor(Math.random() *(4));
        	playingDice = myGame.diceList.get(chooseDice);
        	
        	// roll dice
        	
        	int currentDice = playingDice.roll();
        	
            // switch players
        	System.out.printf("Player %d get %d score \n", myGame.getCurrentPlayerId(), currentDice);
        	
        	if (!calculatePoint(currentDice)) {        		
        		myGame.getCurrentPlayer().notifyScore();
        		nextPlayer();
        	} else {
            	myGame.declareTheWinner();
            	break;
        	}
        	
        }  
		
	}
	
	public void nextPlayer () {
		
	     if(myGame.getCurrentPlayerId() == 1) {
	    	 
	    	 myGame.setCurrentPlayerId(2);
             
         } else if (myGame.getCurrentPlayerId() == 2){
        	 
        	 myGame.setCurrentPlayerId(3);
             
         } else if (myGame.getCurrentPlayerId() == 3){
        	 
        	 myGame.setCurrentPlayerId(4);
             
         } else {
        	 
        	 myGame.setCurrentPlayerId(1);
             
         } 
	}
	
	public boolean calculatePoint (int currentDice) {
		
		boolean gameEnd = false;
		
		int currentScore = myGame.getCurrentPlayer().getCurrentScore();
		
		if (currentScore + currentDice == 21) {
			
			gameEnd = true;
			
		} else if (currentScore + currentDice > 21) {
			
			myGame.getCurrentPlayer().updateScore(0);
			
		} else {
			
			myGame.getCurrentPlayer().updateScore(currentScore + currentDice);
		}
		
		return gameEnd;
		
	}
	
}
