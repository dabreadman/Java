import javax.swing.JOptionPane;
import java.util.Scanner;

public class Wages {
	public static final int MINUTES_PER_HOUR = 60; 
	public static void main(String[] args) {
		while (true){
			String input = JOptionPane.showInputDialog("Enter time worked (hours : minutes):");
			Scanner inputScanner = new Scanner( input );
			inputScanner.useDelimiter(":");
			String hours_input = inputScanner.next();
			String hours_only = hours_input.replaceFirst(".*?(\\d+).*","$1");
			int hours = Integer.parseInt(hours_only);
			String minutes_input = inputScanner.next();
			String minutes_only = minutes_input.replaceFirst(".*?(\\d+).*","$1");
			int minutes = Integer.parseInt(minutes_only);
			inputScanner.close();
		
			input = JOptionPane.showInputDialog("Enter hourly rates (Euro.cent)");
			inputScanner = new Scanner(input);
			String wages_input = inputScanner.next();
			String wages_only = wages_input.replaceFirst(".*?(\\d+)","$1");
			double wages = Double.parseDouble(wages_only);
			inputScanner.close();
			
			if (minutes >=60){
				while (minutes >= 60){
					minutes = minutes - 60;
					hours = hours + 1;					
					if (minutes<60){
						JOptionPane.showMessageDialog(null, "Having worked " + hours + " hours and " + minutes + " minutes, \nyou have earned £" + (((double)hours +(double)minutes/MINUTES_PER_HOUR))*(double)wages + ", \n with an hourly rate of " + wages + ".");
						JOptionPane.getRootFrame().dispose();   
					}
				}
			}
			else if (minutes < 60){
				JOptionPane.showMessageDialog(null, "Having worked " + hours + " hours and " + minutes + " minutes, \nyou have earned £" + (((double)hours +(double)minutes/MINUTES_PER_HOUR))*(double)wages + ", \n with an hourly rate of " + wages + ".");
				JOptionPane.getRootFrame().dispose();   
					}
			
		
		
		}
		
		}
	
	}











































		
		
		
		
	













	












