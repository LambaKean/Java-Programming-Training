/* Finding a second smallest element in an array 
 * (without taking into account the repetition of the minimum element)
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class SecondSmallest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.print("Enter an amount of elements in an integer array: ");
		int n = scanner.nextInt();
		
		System.out.print("Enter a lower limit of the array values: ");
		int lwrLimit = scanner.nextInt();
		
		System.out.print("Enter an upper limit of the array values: ");
		int uprLimit = scanner.nextInt();
		
		int[] array = new int[n];
		
		// Filling the array with random values ranging from lwrLimit to uprLimit
		for (int i = 0; i < n; i++) {
			
			array[i] = random.nextInt(uprLimit + 1 - lwrLimit) + lwrLimit;
			
		}
		
		System.out.println("The generated array: " + Arrays.toString(array));
		
		
		int firstMin = uprLimit;
		// +1 to handle the situation when there're two same smallest values in the array
		int secondMin = uprLimit + 1;
		
		for (int i = 0; i < n; i++) {
			
			if (array[i] < firstMin) {
				
				secondMin = firstMin;
				
				firstMin = array[i];
				
			} else if (array[i] > firstMin && array[i] < secondMin) {
				
				secondMin = array[i];
				
			}
		}
		
		if (secondMin == uprLimit + 1) {
			
			System.out.print("There's no a second smallest value in the array.");
			
		} else {
			
			System.out.print("A second smallest value in the array is: " + secondMin);
			
		}
	
		scanner.close();
		
	}
}
