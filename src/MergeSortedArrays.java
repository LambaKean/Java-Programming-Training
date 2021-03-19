/* Merging two sorted arrays with ordering preserved */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.print("Enter a length of a first array: ");
		int[] firstArray = new int[scanner.nextInt()];
		
		System.out.print("Enter a length of a second array: ");
		int[] secondArray = new int[scanner.nextInt()];
		
		System.out.print("Enter a lower limit of the arrays' values: ");
		int lwrLimit = scanner.nextInt();
		
		System.out.print("Enter an upper limit of the arrays' values: ");
		int uprLimit = scanner.nextInt();
		
		// Filling the array with random values ranging from lwrLimit to uprLimit
		for (int i = 0; (i < firstArray.length || i < secondArray.length); i++) {
			
			if (i < firstArray.length) {
				
				firstArray[i] = random.nextInt(uprLimit + 1 - lwrLimit) + lwrLimit;
				
			}
			
			if (i < secondArray.length) {
				
				secondArray[i] = random.nextInt(uprLimit + 1 - lwrLimit) + lwrLimit;
				
			}
		}
		
		Arrays.sort(firstArray);
		Arrays.sort(secondArray);
		
		System.out.println("The first array: " + Arrays.toString(firstArray));
		System.out.println("The second array: " + Arrays.toString(secondArray));
		
		int[] mergingResultArray = new int[firstArray.length + secondArray.length];
		
		int frstArrPointer = 0;
		int scndArrPointer = 0;
		
		for (int i = 0; i < mergingResultArray.length; i++) {
			
			if (frstArrPointer == firstArray.length) {
				
				mergingResultArray[frstArrPointer + scndArrPointer] = secondArray[scndArrPointer];
				
				scndArrPointer++;
				
			} else if (scndArrPointer == secondArray.length) {
				
				mergingResultArray[scndArrPointer + frstArrPointer] = firstArray[frstArrPointer];
				
				frstArrPointer++;
				
			} else if (firstArray[frstArrPointer] <= secondArray[scndArrPointer]) {
				
				mergingResultArray[frstArrPointer + scndArrPointer] = firstArray[frstArrPointer];
				
				frstArrPointer++;
				
			} else {  // firstArray[frstArrPointer] > secondArray[scndArrPointer]
				
				mergingResultArray[frstArrPointer + scndArrPointer] = secondArray[scndArrPointer];
				
				scndArrPointer++;
				
			}
		}
		
		System.out.print("Merged array: " + Arrays.toString(mergingResultArray));
		
		scanner.close();
		
	}
}
