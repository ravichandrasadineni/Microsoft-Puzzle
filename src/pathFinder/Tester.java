package pathFinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String args[]) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		List<String> words = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader("/home/ravichandrasadineni/mscontest/PracticeInput"));
			writer = new PrintWriter("/home/ravichandrasadineni/mscontest/outputFile", "UTF-8");
			String line = null;
			String inputWord = reader.readLine();
			while ((line = reader.readLine()) != null) {
				words.add(line);
			}
			//
			// convert arrayList of words into char array;
			char[][] charArray = new char[words.size()][];
			char[] inputCharWord = inputWord.toCharArray();
			
			for(int i = 0; i < words.size(); i ++) {
				charArray[i] = words.get(i).toCharArray();
			}
			
			PathFinder pathFinder = new PathFinder(charArray,inputCharWord);
			char[][] outputArray = pathFinder.findPath();
			printArray(outputArray);
			

		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void printArray(char[][] outputArray) {
		
		for(int i = 0; i < outputArray.length; i++) {
			for(int j =0; j< outputArray[0].length; j++) {
				if(outputArray[i][j] == 0)
					System.out.print(". \t" );
				else {
					System.out.print(outputArray[i][j] + "\t");
				}
				
			}
			System.out.println();
		}
	}
}
