import java.util.Random;

public class Dice {

	int result;
	
	Random rng = new Random();
	int roll(){
	result = rng.nextInt(6)+1;
	return result;
	}
	
public static void main(String[]args){
	Dice dice = new Dice();
	dice.roll();
}
}


