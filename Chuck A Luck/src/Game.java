import java.util.Scanner;

public class Game {

	static final int TRIPLE = 1;
	static final int FIELD = 2;
	static final int HIGH = 3;
	static final int LOW = 4;
	static final int QUIT = 0;

	public final static double STARTING_AMOUNT = 50.00;

	static int rollResult=10;

	public static void main(String[] args) {

		String betType="";
		//initialize the wallet
		Wallet wallet = new Wallet();
		wallet.put(STARTING_AMOUNT);
		System.out.println(wallet.toString());
		ResolveBet(betType,wallet);

	}

	public static void ResolveBet(String betType,Wallet wallet) {
		int choice=LOW;
		double bet = 5;

				//initialize the dices
				Dice dices[] = new Dice[3];
				iniDices(dices);

		String playerInputConclusion;

		Scanner scanner = new Scanner(System.in);

		boolean quit = false;

		while(wallet.check()>0 && !quit)
		{
			choice = choiceInput(scanner);

			if (choice == QUIT)
				quit = true;

			else
			{
				bet = betInput(scanner,wallet);

				rollDices(dices);

				playerInputConclusion = "Your choice: ";
				switch(choice) {
				case TRIPLE: playerInputConclusion+= "Triple";
				break;
				case FIELD:  playerInputConclusion+= "Field";
				break;
				case HIGH:  playerInputConclusion+= "High";
				break;
				default: playerInputConclusion+= "Low";
				break;
				}

				playerInputConclusion += " ; Bet amount: "+ bet;
				System.out.println(playerInputConclusion);

				if(isWon(rollResult,choice,dices))
					winMoney(wallet,bet,choice);
				else
					loseMoney(wallet,bet);
			}
		}
		if(wallet.check()>0)
		System.out.println("Wallet[cash = " +wallet.check()+ "]");
	}

	//initialize the dices
	public static void iniDices(Dice[]dices){
		for (int i=0; i<dices.length;i++)
			dices[i]= new Dice();
	}

	//roll the dices
	public static void rollDices(Dice[]dices){
		rollResult=0;
		for (int i =0; i<dices.length;i++)
		{
			System.out.println("Roll "+(i+1)+" rolled: "+dices[i].roll()+".");
			rollResult+=dices[i].result;
		}
		System.out.println("The total result is: "+rollResult);
	}

	//keep taking input from user until a valid input is given and return the valid input
	public static double betInput(Scanner scanner,Wallet wallet) {
		double bet=-1;
		String junk;
		boolean quit = false;

		while(!quit) {
			System.out.println("Wallet[cash = "+wallet.check()+"]"
					+"\nEnter the amount of bet: ");
			if (scanner.hasNextDouble())
			{
				bet =  scanner.nextDouble();
				if (bet<=0 || bet>wallet.check())
					System.out.println("Invalid input!");
				else
					return bet;
			}
			else
				junk =  scanner.next();
		}
		return bet;
	}

	//keep taking input from user until a valid input is given and return the valid input
	public static int choiceInput(Scanner scanner){
		int choice=-1;
		boolean quit = false;
		String junk;

		while(!quit){

			System.out.println("Enter your choice: "
					+"\nQUIT:0 ; TRIPLE:1 ; FIELD:2 ;  HIGH:3 ; LOW:4");

			if (scanner.hasNextInt())
			{
				choice = scanner.nextInt();
				if (choice>=0 && choice <= 4)
					quit = true;
				else
					System.out.println("Invalid input!");
			}
			else
			{
				junk = scanner.next();
				System.out.println("Invalid input!");
			}
		}
		return choice;
	}

	//updates the cash in Wallet and printing out the balance and winning
	public static void winMoney(Wallet wallet,double bet,int choice){
		int rate;
		if (choice == TRIPLE)
			rate = 30;
		else
			rate = 1;
		wallet.put(bet*rate);

		System.out.println("You've won!"
				+"\nWallet[cash = "+wallet.check()+("](+"+bet*rate)+")");

	}

	//updates the cash in Wallet and printing out the balance and losing
	public static void loseMoney(Wallet wallet,double bet) {
		wallet.get(bet);
		System.out.println("You've lost!"
				+"\nWallet[cash = "+wallet.check()+("](-"+bet+")"));
	}

	//checks if won condition is met and returns true if won
	public static boolean isWon (int rollResult, int choice, Dice[]dices){
		switch(choice){
		case TRIPLE:
			for (int i = 0; i<2;i++){
				if (dices[i].result!=dices[i+1].result)
					return false;
			}
			return true;

		case FIELD: if (rollResult>=8 || rollResult<=12)
			return false;

		case HIGH: if(rollResult<=10)
			return false;

		case LOW: if(rollResult>=11)
			return false;

		default:
			return true;
		}
	}

}
