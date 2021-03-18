// Finding non-repeating values in an integer array
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class NonRepeatingNumbers {

	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.print("Enter an amount of elements in an integer array: ");
		int n = scanner.nextInt();
		
		System.out.print("Enter a lower limit of the array values: ");
		int lwrLimit = scanner.nextInt();
		
		System.out.print("Enter an upper limit of the array values: ");
		int uprLimit = scanner.nextInt();
		
		int[] array = new int[n];
		
		boolean[] flags = new boolean[n]; // true if i-th element of the array is repeating
		
		// Filling the array with random values ranging from lwrLimit to uprLimit
		for (int i = 0; i < n; i++) {
			
			array[i] = random.nextInt(uprLimit + 1 - lwrLimit) + lwrLimit;
			
			flags[i] = false;
			
		}
		
		System.out.println("The generated array: " + Arrays.toString(array));
		
		for (int i = 0; i < n; i++) {
			
			if(flags[i] == false) {
			
				for (int j = i+1; j < n; j++) {
					
					if(array[i] == array[j]) {
						
						flags[i] = true;
						flags[j] = true;
						
					}
					
				}
				
			}
			
		}
		
		System.out.print("Non-repeating values in the array:");
		
		for (int i = 0; i < n; i++) {
			
			if (flags[i] == false) {
				
				System.out.print(" " + array[i]);
				
			}
			
		}
		
		scanner.close();
		
	}
	
}
