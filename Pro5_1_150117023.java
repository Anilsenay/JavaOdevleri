/*
 * Rolling 10 dice program
 * This program rolling 10 dice for n times that user writes as input.
 * After rolling 10 dices n times, program shows number of times "summary of each 10 dice" .
 */
import java.util.Scanner;

/**
 *
 * @author anilsenay / Anıl Şenay / Number: 150117023
 */

public class Pro5_1_150117023 {
    	public static void main(String[] args){
		Scanner input = new Scanner(System.in); 
		int[] summaryOfTenDices = new int[51]; //the array which keeps number of times each total occurs.

		System.out.print("Enter a value: ");
		int howManyTimes = Integer.parseInt(args[0]);//input.nextInt();
		rollingDice(howManyTimes, summaryOfTenDices);
		printResult(summaryOfTenDices);
    	}

	public static void rollingDice(int n, int sumArray[]){
                int sum = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 10; j++){

				sum += (int)(Math.random()*6)+1;

			}

			sumArray[sum-10]++;
			sum = 0;
		}
	}

	public static void printResult(int sumArray[]){
		for(int i = 10; i <= 60; i++){
			System.out.print(i +": ");
			for(int j = 0; j < sumArray[i-10]; j++){
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
