import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Wordlink {

	static ArrayList<String>dictionary = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		//reads file
		FileReader fileReader = new FileReader("text.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		dictionary = readDictionary(bufferedReader);
		fileReader.close();


		Scanner scanner = new Scanner(System.in);
		String str;
		ArrayList<String> list = new ArrayList<String>();
		boolean quit=false;
		while(!quit){
			System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
			str = scanner.nextLine();
			if(!str.isEmpty()){
				str= str.replaceAll("\\s",""); //removes all spaces \s->space ; ->'\'+'n'->new line
				list = readWordList(str);
				if(!isUniqueList(list))
					System.out.println("The list contains duplicates, please try again.");
				else if(isListEnglish(list)){
					if(isWordChain(list))
						System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
					else
						System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
				}
				else{
					System.out.println("Contains words not included in the dictionary.");
				}
			}
			else {
				quit = true;
			}
		}
		System.out.println("The program has exitted. Thank you.");
	}

	//checks if the whole list is contained in the dictionary
	public static boolean isListEnglish(ArrayList<String>list){
		for (String str:list){
			if (!isEnglishWord(str))
				return false;
		}
		return true;
	}

	public static ArrayList<String> readDictionary(BufferedReader bufferedReader){
		ArrayList<String>list = new ArrayList<String>();
		try {
			boolean endOfFile = false;
	        while(!endOfFile){
	        	String word = bufferedReader.readLine();
	        	if (word != null) {
	        		list.add(word);
	        	}
	        	else {
	        		endOfFile = true;
	        	}
	        }
	        bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<String> readWordList(String input){
		String[] strArr = input.split(",");
		ArrayList<String> strArrList = new ArrayList<String>();
		for (String str:strArr)
		{
			if (str!=null || str!=" ")
			strArrList.add(str);
		}
		return strArrList;
	}

	public static boolean isDifferentByOne (String str1, String str2){
		if (str1.length()==str2.length()){
			char[] charArr1 = str1.toCharArray();
			char[] charArr2 = str2.toCharArray();
			int count = 0;
			for (int i =0; i<charArr1.length;i++){
				if (charArr1[i]!=charArr2[i])
					count++;
			}
			if (count ==1)
				return true;
		}
		return false;
	}
	public static boolean isUniqueList(ArrayList<String>list){
		for(int i=0;i<list.size()-1;i++){
			String str = list.get(i);
			for (int index=i+1;index<list.size();index++){
				if (list.get(index)==str)
					return false;
			}
		}
		return true;
	}

	public static boolean isEnglishWord(String str){
		String[] dict_a = dictionary.toArray(new String[dictionary.size()]);
		if(Arrays.binarySearch(dict_a, str)>=0)
			return true;
		return false;
	}

	public static boolean isWordChain(ArrayList<String>list){
		String str1=list.get(0);
		String str2;
		for (int i=1;i<list.size()-1;i++){
			str2 = list.get(i);
			//checks if string is in dictionary
			if (!isEnglishWord(str1)||!isEnglishWord(str2))
				return false;
			//checks if former string,str1 is linked to the latter,str2
			if(!isDifferentByOne(str1,str2))
				return false;
			str1 = str2;
		}
		return true;
	}

}
