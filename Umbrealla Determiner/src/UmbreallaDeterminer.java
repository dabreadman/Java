import javax.swing.JOptionPane;

public class UmbreallaDeterminer {


	public static void main(String[] args) {

		boolean rain,willRain,bringUmbrella,useUmbrella;
		String rainReply,willRainReply,bringUmbrellaReply,useUmbrellaReply,andOrBut;

		willRain = true;
		bringUmbrella = true;
		useUmbrella = true;

		int input = JOptionPane.showConfirmDialog(null, "This is a program to determine if you should bring an umbrella. "
				+ "\nPlease answer the following question(s):"
				+ "\nIs it raining?");
		rain = (input == JOptionPane.YES_OPTION);

		//If user selected "Cancel" option.
		if (input == JOptionPane.CANCEL_OPTION)
		{
			JOptionPane.showMessageDialog (null,"We're sorry to see you go, but have fun!");
			System.exit(0);
		}

		//Proceeds to ask question if it is not already raining.
		else if (!rain)
		{
			input = JOptionPane.showConfirmDialog(null, "Does it seems like it will be raining soon?");
			willRain = (input == JOptionPane.YES_OPTION);
			willRainReply = (willRain)? "rain soon, " : "not rain soon, ";

			if (willRain != true)
			{
				bringUmbrella = false;
				useUmbrella = false;
			}
		}

		willRainReply = " ";
		andOrBut = "";

		//Returns different replies for different conditions.
		rainReply = (rain)? "raining, " : "not raining, ";
		andOrBut = (willRain)? "but it will " : "and it will ";
		andOrBut = (rain)? "":"";
		bringUmbrellaReply = (bringUmbrella)? "bring " : "you do not have to bring ";
		useUmbrellaReply = (useUmbrella)? " and do not use it, yet." : ".";
		useUmbrellaReply = (rain)? " and use it.":"";


		JOptionPane.showMessageDialog(null, "Because it is " + rainReply + andOrBut + willRainReply
				+ bringUmbrellaReply + "your umbrella" + useUmbrellaReply );
	}

}
