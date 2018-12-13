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
		System.out.println("Welcome to dice simulator program.");
		System.out.print("Enter a value: ");
		int howManyTimes = input.nextInt();
		rollingDice(howManyTimes, summaryOfTenDices);
		printResult(summaryOfTenDices);
    }

	/**
	This method rolls 10 dices n times.
	All 10 dice adding and result keeping in array as array[summary - 10]
	After adding each 10 dice, temporary summary integer value setting 0 again for new roll.

	Method takes 2 parameter as an integer n value and an integer type array.
	*/
	public static void rollingDice(int rollTimes, int sumArray[]){
        int sum = 0;
		for(int i = 0; i < rollTimes; i++){
			for(int j = 0; j < 10; j++){

				sum += (int)(Math.random()*6)+1;

			}

			sumArray[sum-10]++;
			sum = 0;
		}
	}
	/**
	This method prints result of array which keeps dice summaries.

	Method takes 1 parameter as an integer type array.
	*/
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
