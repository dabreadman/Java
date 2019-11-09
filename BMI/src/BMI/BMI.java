import java.util.Scanner;

public class BMI {
	public static void main(String[] args) {
		System.out.println("Enter your mass (kg):" );
		Scanner input = new Scanner(System.in);
		double mass = input.nextDouble();

		System.out.println("Enter your height (m):" );
		double height = input.nextDouble();

		System.out.println("BMI= " + mass/height/height);

			}

}
