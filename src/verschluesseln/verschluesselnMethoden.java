package verschluesseln;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class verschluesselnMethoden {
	static String stringInput = "";
	static int [] intArray;
	static int [] codeArray;
	static String[] encryptedCode;
	static char[] inputArray;
	
	public static void charToInt() {
		Scanner inputScanner = new Scanner(System.in);
		
		try {
			stringInput = new String(Files.readAllBytes(Paths.get("test.txt")));
		}
		catch (Exception e) {	
		}
		stringInput = stringInput.replaceAll("\\s","");
		stringInput = stringInput.toLowerCase();
		inputArray = stringInput.toCharArray();
		intArray = new int[inputArray.length];
		for(int i = 0; i < inputArray.length; i++) {
			if(inputArray[i]=='a') {
				intArray[i] = 0;
			}
			if(inputArray[i]=='b') {
				intArray[i] = 1;
			}
			if(inputArray[i]=='c') {
				intArray[i] = 2;
			}
			if(inputArray[i]=='d') {
				intArray[i] = 3;
			}
			if(inputArray[i]=='e') {
				intArray[i] = 4;
			}
			if(inputArray[i]=='f') {
				intArray[i] = 5;
			}
			if(inputArray[i]=='g') {
				intArray[i] = 6;
			}
			if(inputArray[i]=='h') {
				intArray[i] = 7;
			}
			if(inputArray[i]=='i') {
				intArray[i] = 8;
			}
			if(inputArray[i]=='j') {
				intArray[i] = 9;
			}
		}
		inputScanner.close();
	}
	
	public static void addCode() {
		codeArray = new int[intArray.length];
		int y = 0;
		Scanner input = new Scanner(System.in);
		String code = "";
		System.out.print("Code: ");
		code = input.next();
		char [] codeArrayChar = code.toCharArray();
		for(int i = 0; i < intArray.length; i++) {
			codeArray[i] = intArray[i] + Integer.valueOf(codeArrayChar[y] - 48);
			if(codeArray[i] >= 10) {
				codeArray[i] = codeArray[i] - 10;
 			}
			y++;
			if(y == codeArrayChar.length) {
				y = 0;
			}
		}
		input.close();
	}
	
	 static void backToLetters() {
		boolean fileExists = false;
		String finalOutput = "";
		encryptedCode = new String[codeArray.length];
		for(int i = 0; i < codeArray.length; i++) {
			if(codeArray[i] == 0) {
				encryptedCode[i] = "a";
			}
			if(codeArray[i] == 1) {
				encryptedCode[i] = "b";
			}
			if(codeArray[i] == 2) {
				encryptedCode[i] = "c";
			}
			if(codeArray[i] == 3) {
				encryptedCode[i] = "d";
			}
			if(codeArray[i] == 4) {
				encryptedCode[i] = "e";
			}
			if(codeArray[i] == 5) {
				encryptedCode[i] = "f";
			}
			if(codeArray[i] == 6) {
				encryptedCode[i] = "g";
			}
			if(codeArray[i] == 7) {
				encryptedCode[i] = "h";
			}
			if(codeArray[i] == 8) {
				encryptedCode[i] = "i";
			}
			if(codeArray[i] == 9) {
				encryptedCode[i] = "j";
			}
		}
		for(int i = 0; i < encryptedCode.length; i++) {
			finalOutput = finalOutput + encryptedCode[i];
		}
		File Output;
		Path file = Paths.get("Output.txt");
		if (Files.exists(file)) {
			fileExists = true;
		} else {
			Output = new File("Output.txt");
			fileExists = false;
		}
		try {
			if (fileExists) {
				Files.deleteIfExists(file);
				Output = new File("Output.txt");
			}
			FileWriter writer = new FileWriter("Output.txt");
			for (int i = 0; i < encryptedCode.length; i++) {
				writer.write(finalOutput);
				writer.close();
			}
		} catch (Exception e) {
		}
	}

}
