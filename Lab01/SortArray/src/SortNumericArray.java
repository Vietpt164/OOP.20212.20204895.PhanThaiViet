import java.util.Scanner;

public class SortNumericArray {
	public static void main(String[] args) {
		//Input the array
		Scanner keyboard  = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int arr_size = keyboard.nextInt();
		int[] arr = new int[arr_size];
		for (int i = 0; i < arr_size; i++) {
			System.out.print("a[" + (i) + "] = ");
			arr[i] = keyboard.nextInt();
		}
		
		//Display the original array
		System.out.println("Elements of original array: ");    
        for (int i = 0; i < arr_size; i++) {     
            System.out.print(arr[i] + " ");    
        }    
            
        //Sort the array in ascending order using selection sort    
        int minj, minx;
        for (int i = 0; i < arr_size-1; i++) {     
            minj = i; minx = arr[i];
        	for (int j = i+1; j < arr_size; j++) {     
               if(arr[j] < minx) {    
                   minj = j; minx = arr[j];   
               }
            }   
        	arr[minj] = arr[i]; arr[i] = minx;
        }    
          
        System.out.println();    
            
        //Display the sorted array   
        System.out.println("Elements of array sorted in ascending order: ");    
        for (int i = 0; i < arr_size; i++) {     
            System.out.print(arr[i] + " ");    
        }  
        
        System.out.println();
        
        //Calculate the sum and average of value of array elements
        double sum = 0;
        for (int i = 0; i < arr_size; i++) {     
            sum += arr[i];    
        }
        double avg = sum/arr_size;
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value of array elements: " + avg);
        
    }    
}    
