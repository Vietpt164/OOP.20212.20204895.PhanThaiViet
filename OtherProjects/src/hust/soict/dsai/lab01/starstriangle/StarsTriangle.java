package hust.soict.dsai.lab01.starstriangle;
import java.util.Scanner;

public class StarsTriangle {
	public static String stringOfChar(int NumOfSpaces, char Char) {
		String strChar = "";
		for (int i = 1; i <= NumOfSpaces; i++) {
			strChar += Char;
		}
		return strChar;
	}
	public static void main(String[] args) {
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("Input the height of the triangle: ");
		int iHeight = keyboard.nextInt();
		
		for (int i = 1; i <= iHeight; i++) {
			System.out.println(stringOfChar(iHeight - i, ' ') + stringOfChar(2*i - 1, '*'));
		}
	}	
}
