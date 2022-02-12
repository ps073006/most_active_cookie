//package most_active_cookie;

import java.io.*;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class ActiveCookie {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		try {
		//get inputs
		String csvLoc = args[0];
		String date = args[2];
		// variable for maximum cookie counter and hashmap for storing tracking cookies and count
		int maxCookie = Integer.MIN_VALUE;
		Map<String,Integer> cookieMap = new HashMap<>();
		
		
			//csv file reader part
			File csvFile = new File(csvLoc);
			BufferedReader bufR = new BufferedReader(new FileReader(csvFile));
			String currentLine = "";
			LocalDate searchDate = LocalDate.parse(date,DateTimeFormatter.ISO_DATE);
			while((currentLine = bufR.readLine())!= null) {
				//System.out.println(currentLine);
				String[] cookieDate =  currentLine.split(",");
				String Cookie = cookieDate[0];		
				if(Cookie.compareTo("cookie")==0) continue;
				OffsetDateTime currentDateTime = OffsetDateTime.parse(cookieDate[1],DateTimeFormatter.ISO_OFFSET_DATE_TIME);
				LocalDate currentDate = currentDateTime.toLocalDate();				
				if(searchDate.compareTo(currentDate)==0) {
					cookieMap.put(Cookie,cookieMap.getOrDefault(Cookie, 0)+1);
					maxCookie = Math.max(maxCookie, cookieMap.get(Cookie));
					//check if the current date from csv is lower than search date then no need to search more
				}else if(searchDate.compareTo(currentDate)>0) {
					break;
				}
				
			}
			
			bufR.close();
			//loop through map and print the most active cookie
			for(String key: cookieMap.keySet()) {
				if(cookieMap.get(key)== maxCookie) {
					System.out.println(key);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print("Could not found file in the given location or file information is incorrect");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.print("Wrong input parameter");
			//e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Parameter Input format is incorrect");
		}
		
		
	} 

}
