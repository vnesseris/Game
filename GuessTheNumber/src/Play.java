

public class Play {
	
	int randomNumber;
	
	public Play() {
		randomNumber = (int)(Math.random()*100);
	}
	
	public String guessTheNumber(int number) {
		String result = "";
		if(number > randomNumber) {
			result = "Please choose a smaller number";
		}
		else if(number < randomNumber) {
			result = "Please choose a bigger number";
		}
		else {
			result = "Congrats. You found the number";
		}
		return result;
	}
	
	public void restart() {
		randomNumber = (int)(Math.random()*100);
	}
			
}



