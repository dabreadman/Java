public class Rational {

	int numerator;
	int denominator;

	public final int ONE = 1;

	Rational(int n,int d){
		numerator = n;
		denominator = d;
	}

	Rational(int number){
		numerator = number;
		denominator = ONE;
	}

	public Rational add (Rational number){
		Rational result = new Rational(0);
		result.numerator = numerator*number.denominator + number.numerator*denominator;
		result.denominator = denominator*number.denominator;
		return result;
	}

	public Rational substract (Rational number){
		Rational result = new Rational(0);
		result.numerator = numerator*number.denominator - number.numerator*denominator;
		result.denominator = denominator*number.denominator;
		return result;
	}

	public Rational multiply (Rational number){
		Rational result = new Rational(0);
		result.numerator = numerator*number.numerator;
		result.denominator = denominator*number.denominator;
		return result;
	}

	public Rational divide (Rational number){
		Rational result = new Rational(0);
		result.numerator = numerator*number.denominator;
		result.denominator = denominator*number.numerator;
		return result;
	}

	public boolean isEqual (Rational number){
		if (numerator*number.denominator==number.numerator*denominator)
			return true;
		else
			return false;
	}

	public boolean isLessThan (Rational number){
		if (numerator*number.denominator<denominator*number.numerator)
			return true;
		else
			return false;
	}

	public void simplify (){
		int gcd = gcd();
		numerator /=gcd;
		denominator /=gcd;
	}

	public int gcd (){
		int gcd;
		gcd = (numerator>denominator)? numerator:denominator;
		while (numerator%gcd!=0 || denominator%gcd!=0)
			gcd--;
		return gcd;
	}

	public String toString(){
		return (denominator==1)? ""+numerator:numerator+"/"+denominator;

	}

}
