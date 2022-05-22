package hust.soict.dsai.lab01.numdayofmonth;

import java.util.Scanner;

public class NumDaysOfMonth {
	public static int valueMonth(String strMonth) {
		int iMonth;
		switch(strMonth) {
			case "January": case "Jan.": case "Jan": case "1": iMonth = 1; break;
			case "February": case "Feb.": case "Feb": case "2": iMonth = 2; break;
			case "March": case "Mar.": case "Mar": case "3": iMonth = 3; break;
			case "April": case "Apr.": case "Apr": case "4": iMonth = 4; break;
			case "May": case "5": iMonth = 5; break;
			case "June": case "Jun": case "6": iMonth = 6; break;
			case "July": case "Jul": case "7": iMonth = 7; break;
			case "August": case "Aug.": case "Aug": case "8": iMonth = 8; break;
			case "September": case "Sept.": case "Sep": case "9": iMonth = 9; break;
			case "October": case "Oct.": case "Oct": case "10": iMonth = 10; break;
			case "November": case "Nov.": case "Nov": case "11": iMonth = 11; break;
			case "December": case "Dec.": case "Dec": case "12": iMonth = 12; break;
			default: 
				iMonth = -1;
				break;
		}
		return iMonth;
	}
	
	public static void main(String[] args) {
		Scanner keyboard  = new Scanner(System.in);
		
		System.out.println("Input the month: ");
		String strMonth = keyboard.nextLine();
		int iMonth = valueMonth(strMonth); 
		while (iMonth == -1) {
			System.out.println("Invalid month! Please enter again.");
			System.out.println("Input the month: ");
			strMonth = keyboard.nextLine();
			iMonth = valueMonth(strMonth);
		}	
		
		System.out.println("Input the year: ");
		int iYear = keyboard.nextInt();
		while (iYear < 0) {		
			System.out.println("Invalid year! Please enter again. ");
			System.out.println("Input the year: ");
			iYear = keyboard.nextInt();
		}
		
		//System.out.println(iMonth);
		
		int numDays = 0;
		switch (iMonth) {
        	case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        		numDays = 31;
        		break;
        	case 4: case 6: case 9: case 11:
        		numDays = 30;
        		break;
        	case 2:
        		if (((iYear % 4 == 0) && !(iYear % 100 == 0)) || (iYear % 400 == 0)) 
        			numDays = 29;
        		else
        			numDays = 28;
        		break;

    }
    System.out.println("Number of Days = " + numDays);
		
	}
}
