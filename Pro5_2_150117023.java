import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anil
 */
public class Pro5_2_150117023 {

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String inputString = input.nextLine();

                int arraySize = defineArraySize(inputString);

		int inputArray[] = new int[arraySize];

		stringToArray(inputString, inputArray);

		int[][] updatedTable = new int[arraySize][arraySize];
		fillUpdatedTable(updatedTable, inputArray);
		for(int i = 0; i < updatedTable.length; i++){
			for(int j = 0; j < updatedTable[i].length; j++)
				System.out.print(updatedTable[i][j]);
			System.out.println();
		}
	}

	public static int defineArraySize(String str) {
		int arraySize = 1;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '-')
				arraySize++;
		}
		return arraySize;
	}
	public static void stringToArray(String str, int[] inputArray){
		int a = 0;
		int indexArray = 0;
		for(int i = 0; i < inputArray.length+1; i++){
			if(((int)str.indexOf('-', a) != -1)){
			inputArray[indexArray] = Integer.parseInt( str.substring( a, str.indexOf('-', a) ) );
			a = str.indexOf('-', a)+1;

			indexArray++;
			}
			else{
				inputArray[indexArray] = Integer.parseInt( str.substring(a, str.length()) );
			}
		}

	}

	public static int[] convertDectoB(int number, int size){
		int[] numberAsBinary = new int[size];
		int indexNo = size-1;
		while(number >= 1){
			numberAsBinary[indexNo] = number % 2;
			number = number/2;
			indexNo--;
		}
		return numberAsBinary;
	}

	public static void fillUpdatedTable(int[][] TwoDTable, int[] OneDArray){
		for(int i = 0; i < TwoDTable.length; i++){
			TwoDTable[i] = convertDectoB(OneDArray[i], OneDArray.length);
		}
	}
}
