import javax.swing.JOptionPane;
import java.util.Scanner;

public class CurrencyConverter {

	public static final double OLD_PENNY_TO_NEW_PENNY    = 67;
	public static final double OLD_SHILLING_TO_NEW_PENNY = 804;	 //Old Shilling equal to 12 Old Pennies; 12*67 = 804
	public static final double OLD_POUND_TO_NEW_PENNY    = 16080;//Old pound = 20 Old Shilling ;      20*804 = 16080
	public static final double NEW_PENNY_TO_NEW_POUND    = 0.01; //New Penny to New Pound =  1 / 100 = 0.1

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog(null,"Enter amount of old Sterling \npounds, shillings and pennies seperated"
				+ " by comma \neg:" + " 12,23,34 *enters* for 12 old pounds 23 old shillings and 34 old pennies","Input",3);
		Scanner amount = new Scanner(input);
		amount.useDelimiter(",");
		Double oldPound,oldShilling,oldPenny;
		oldPound    = amount.nextDouble();
		oldShilling = amount.nextDouble();
		oldPenny    = amount.nextDouble();
		amount.close();

		double modernValue = ((oldPound*OLD_POUND_TO_NEW_PENNY) + (oldShilling*OLD_SHILLING_TO_NEW_PENNY)
				       + (oldPenny*OLD_PENNY_TO_NEW_PENNY)) * NEW_PENNY_TO_NEW_POUND;

		JOptionPane.showMessageDialog(null, oldPound + " old pound, " + oldShilling + " old shilling and " +
		                                  oldPenny + " old pence = �" + String.format("%.2f", modernValue), "Result", 1);

	}

}
