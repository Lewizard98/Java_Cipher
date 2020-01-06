//import Scanner for getting user input in the command line
import java.util.Scanner;

public class Crypto {
	public static void main(String[] args){
		int cipherKey = 12;
		int groupSize = 5;
		String userInput = getUserInput();
		System.out.println(encrptyString(userInput, cipherKey,groupSize));
	}
	
	public static String encrptyString(String userInput, int cipherKey, int groupSize){
		userInput = normalizeText(userInput);
		String code = cipher(userInput, cipherKey);
		String codeOutput = groupCode(code, groupSize);
		return codeOutput;
	}
	
	
	//method to get a user input to turn into a cipher
	public static String getUserInput(){
		Scanner input = new Scanner(System.in);
		System.out.println("Input a sentance to turn into a code: ");
		String userInput = input.nextLine();
		return userInput;
	}
	
	//method takes a string and transforms it, returning a string made of only the letters and all in uppercase
	public static String normalizeText(String userInput){	
		userInput = userInput.replaceAll("\\W","");
		userInput = userInput.toUpperCase();
		return userInput;
	}
	
	//method to take a string of letters and convert it into a code using the Caesar Cipher, shifting the letters by the key number of times
	public static String cipher(String userInput, int key){
		//convert the string into a char array
		char[] inputArray = userInput.toCharArray();
		
		//looping through the array
		for (int i = 0; i < inputArray.length; i++){
			//shift the letters
			char letter = inputArray[i];
			letter = (char) (letter + key);
			if (letter > 'Z') {
				letter = (char) (letter - 26);
			} else if (letter < 'A'){
				letter = (char) (letter + 26);
			}
			inputArray[i] = letter;
		}
		return new String(inputArray);
	}
	
	//method takes a string and a int and groups the string into words the size of the int
	public static String groupCode(String codeInput, int groupSize){
		//split the string into an array and make an array to hold the grouped array
		char codeArray[] = codeInput.toCharArray();
		int arrLen = codeArray.length;
		String codeOutput = "";
		for (int i = 0; i < codeArray.length; i++){
			if (i % groupSize == 0){
				codeOutput = codeOutput + ' ';
			}
			codeOutput = codeOutput + codeArray[i];
		}
		
		while (arrLen % groupSize != 0){
			arrLen++;
			codeOutput = codeOutput + 'x';
		}
		return codeOutput;
	}
}