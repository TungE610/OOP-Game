
public class Dice {

	int id;
	
	public Dice(int id) {
		this.id = id;
	}

    public int roll() {
    	double d = Math.random() * 100;
    	for (int i = 1; i <= 6; i ++) {
    		if (i == this.id) {
    			if ((d -= 20) < 0) {
    				return i;
    			}
    		} else {
    	    	if ((d -= 15) < 0) return i;
    		}
    	}

    	return 0;
    }
}
