package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ValidateIpAddress {

	public static void main (String args[]) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader("/home/ravichandrasadineni/mscontest/JudgeInput.txt"));
			writer = new PrintWriter("/home/ravichandrasadineni/mscontest/outputFile", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		String address[][] = new String[3][];
		try {
			while ((line = reader.readLine()) != null) {
				String outPut = "";
				String[] currentvalues = line.split("\\s+");
				if(currentvalues.length > 3)
				{
					outPut = "InValid";
					continue;
				}
				for(int i =0; i < currentvalues.length; i++ ) {	    	
					System.out.println(currentvalues[i].split("\\.")[0]);
					address[i] = currentvalues[i].split("\\.");
					if(address[i].length > 4) {
						outPut ="InValid";
					}

				}
				try {
					for(int i =0; i< 4; i++) {

						if(Integer.parseInt(address[2][i])  < 0 || Integer.parseInt(address[2][i]) > 255 ) {
							outPut ="InValid";
						}



					}
					if(outPut.equals("")) {
						outPut = "InRange";
					}

					if(Integer.parseInt(address[2][0])  <  Integer.parseInt(address[0][0]) || Integer.parseInt(address[2][0]) > Integer.parseInt(address[1][0]) ) {
						if(!outPut.equals("InValid")) {
							outPut = "OutRange";
						}
					}
					else if (Integer.parseInt(address[2][0]) == Integer.parseInt(address[1][0])) {
						if(Integer.parseInt(address[2][1]) <  Integer.parseInt(address[0][1]) ||   Integer.parseInt(address[2][1]) > Integer.parseInt(address[1][1]) ) {
							if(!outPut.equals("InValid")) {
								outPut = "OutRange";
							}
						}
						else if (Integer.parseInt(address[2][1])  == Integer.parseInt(address[1][1]) ) {
							if(Integer.parseInt(address[2][2]) <  Integer.parseInt(address[0][2]) ||   Integer.parseInt(address[2][2]) > Integer.parseInt(address[1][2]) ) {
								if(!outPut.equals("InValid")) {
									outPut = "OutRange";
								}
							}
							else if (Integer.parseInt(address[2][2])  == Integer.parseInt(address[1][2]) ) {
								if(Integer.parseInt(address[2][3]) <  Integer.parseInt(address[0][3]) ||   Integer.parseInt(address[2][3]) > Integer.parseInt(address[1][3]) ) {
									if(!outPut.equals("InValid")) {
										outPut = "OutRange";
									}	
								}

							}
						}
					}
				}

					catch(NumberFormatException e) {
						outPut ="InValid";	
					}

					writer.println(outPut);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.close();
		}

	}
