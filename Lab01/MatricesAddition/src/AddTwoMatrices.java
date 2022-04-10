import java.util.Scanner;

public class AddTwoMatrices {
	public static void main(String[] args) {	
		//Input
		Scanner keyboard  = new Scanner(System.in);
		System.out.print("Enter the number of rows of matrices: ");
		int numRow = keyboard.nextInt();
		System.out.print("Enter the number of columns of matrices: ");
		int numCol = keyboard.nextInt();
		int a[][] = new int[numRow][numCol];
		for (int r=0; r < numRow; r++) {
			for (int c=0; c < numCol; c++) {
				System.out.print("a[" + r + "][" + c + "] = ");
				a[r][c] = keyboard.nextInt();
			}
		}
		int b[][] = new int[numRow][numCol];
		for (int r=0; r < numRow; r++) {
			for (int c=0; c < numCol; c++) {
				System.out.print("b[" + r + "][" + c + "] = ");
				b[r][c] = keyboard.nextInt();
			}
		}
		
		//Create a matrice to store the sum of two matrices
		int c1[][] = new int[numRow][numCol];
		
		System.out.println();
		
		//Add two matrices and print the sum
		for (int r=0; r < numRow; r++){    
			for (int c=0; c < numCol; c++){    
			c1[r][c]=a[r][c]+b[r][c];  
			System.out.print(c1[r][c]+" ");    
			}    
			System.out.println();
		}
	}
}
