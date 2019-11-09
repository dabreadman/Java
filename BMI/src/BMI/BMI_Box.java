import javax.swing.JOptionPane;
import java.util.Scanner;

public class BMI_box {

	public static void main (String []args)
	{
		String input1 = JOptionPane.showInputDialog("Enter mass: ");
		Scanner mass1 = new Scanner(input1);
		double mass = mass1.nextDouble();

		String input2 = JOptionPane.showInputDialog("Enter height: ");
		Scanner height1 = new Scanner(input2);
		double height = height1.nextDouble();

		JOptionPane.showMessageDialog(null, "BMI= " + mass/height/height);


	}
}
