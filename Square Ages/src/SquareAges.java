public class SquareAges {



	static final int MAX_AGE = 123;
	static final int CURRENT_YEAR = 2018;
	static final int LARGEST_YEAR = CURRENT_YEAR + MAX_AGE;
	static final int SMALLEST_YEAR = 2018 - MAX_AGE;


	public static void main (String[]args)
	{
		for (int age = 0;age <= MAX_AGE ;age++)
		{
			int matchedYear = age*age;

			if ((matchedYear >= SMALLEST_YEAR) && (matchedYear < LARGEST_YEAR) &&
					(CURRENT_YEAR - MAX_AGE < matchedYear - age ) && (matchedYear - age <= CURRENT_YEAR ))
			// condition 1,2 : State the range for matching years.
			// condition 3	 : Make sure the person was born before SMALLEST_YEAR.

			System.out.println("On year "+ matchedYear + ", the people were be born on "
			+(matchedYear - age)+ " at the age of " + age + "\nwould have met the year of their age squared.\n");

		}

	}
}
