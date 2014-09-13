package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

	public static void main (String[] args) {
		int numberOfCompleteTokens=0;
		int numOfPrefixes=0;
		String firstToken ="";
		BufferedReader reader = null;
		PrintWriter writer = null;
		String[] token;
		String line = null;
		List<String> tokens = new ArrayList<String>();
				try {
					reader = new BufferedReader(new FileReader("/home/ravichandrasadineni/Downloads/PracticeInput.txt"));
					writer = new PrintWriter("/home/ravichandrasadineni/mscontest/outputFile", "UTF-8");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		try {
			String tokenToBeSearched =  reader.readLine();
			
			while ((line = reader.readLine()) != null) {
				token  = line.split("\\P{Alpha}+");
				if(token!= null && token.length!=0) {
					for(String tk : token) {
						tokens.add(tk);
					}
				}
				
			}
			for(String presentToken : tokens) {
				if(presentToken.equalsIgnoreCase(tokenToBeSearched)) {
					numberOfCompleteTokens++;
				}
				if(presentToken.toLowerCase().startsWith(tokenToBeSearched.toLowerCase())) {
					if( numOfPrefixes == 0) {
						firstToken  = presentToken; 
						
					}
					numOfPrefixes++;
				}
			}
			System.out.println(numberOfCompleteTokens+ ";" + numOfPrefixes+ ";" +firstToken);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
