
import java.util.Scanner;

/*
 * This program takes a string input from user as "[number]-[number]-..-[number]"
 * and converts the seperated numbers to binary equivalents. Then creates a 
 * 2D array with this binary numbers as size x size and prints in screen.
 * Then the times that user write as input, the 2D array will be updated with 
 * in order to some rules and prints in screen.
 * At the end the new decimal number will be printed.
 */

/**
 *
 * @author anilsenay / Anıl Şenay / Number: 150117023
 */
public class Pro5_2_150117023 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean end = false;

        while (!end) {

            System.out.print("Enter a string: ");
            String inputString = input.nextLine();

            int arraySize = defineArraySize(inputString);

            int inputArray[] = new int[arraySize];

            stringToArray(inputString, inputArray);

            if (!checkNumbers(inputArray, arraySize)) {
                System.out.println("The number " + wrongNumber(inputArray, arraySize) 
                + " can not be represented with " + arraySize + "x" + arraySize + " array!");
            } 
            
            else { //The actual program starting from here.

                System.out.print("Enter a number of steps: ");
                int steps = input.nextLine().charAt(0) - 48;

                int[][] firstTable = new int[arraySize][arraySize];

                //filling 2D array with 1D inputArray's elements.
                for (int i = 0; i < firstTable.length; i++) {
                    firstTable[i] = convertDectoB(inputArray[i], inputArray.length);
                }
                
                //printing firstTable
                for (int row = 0; row < firstTable.length; row++) {
                    for (int numberOfHypen = 0; numberOfHypen < firstTable.length * 4 + 1; numberOfHypen++) {
                        System.out.print("-");
                    }
                    System.out.println();
                    for (int column = 0; column < firstTable.length; column++) {
                        System.out.print("| " + firstTable[row][column] + " ");
                    }
                    System.out.print("|\n");
                }

                for (int numberOfHypen = 0; numberOfHypen < firstTable.length * 4 + 1; numberOfHypen++) {
                    System.out.print("-");
                }
                System.out.print("\n\n");
                //
                
                //the values which need to change in firstArray will import this table
                int[][] updatedTable = new int[firstTable.length][firstTable[0].length];

                for (int step = 0; step < steps; step++) {

                    //fill updatedTable with firstTable
                    for (int row = 0; row < firstTable.length; row++) {
                        for (int column = 0; column < firstTable.length; column++) {
                            updatedTable[row][column] = firstTable[row][column];
                        }
                    }

                    /**
                     * ********** Controlling and updating step starting ************
                     */
                    //Update firstTable and write into updatedTable
                    for (int i = 0; i < firstTable.length; i++) {
                        for (int j = 0; j < firstTable.length; j++) {

                            // ########  if in the middle ######## //
                            if (i > 0 && j > 0 && i < firstTable.length - 1 && j < firstTable.length - 1) {
                                //if cell has 1
                                if (firstTable[i][j] == 1) {
                                    int totalOneNumberOfNeighbours = (firstTable[i - 1][j] + firstTable[i - 1][j - 1] 
                                        + firstTable[i - 1][j + 1]+ firstTable[i][j - 1] + firstTable[i][j + 1]
                                        + firstTable[i + 1][j - 1] + firstTable[i + 1][j] + firstTable[i + 1][j + 1]);
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                //if cell has 0
                                if (firstTable[i][j] == 0) {
                                    int totalOneNumberOfNeighbours = (firstTable[i - 1][j] + firstTable[i - 1][j - 1] 
                                        + firstTable[i - 1][j + 1] + firstTable[i][j - 1] + firstTable[i][j + 1]
                                        + firstTable[i + 1][j - 1] + firstTable[i + 1][j] + firstTable[i + 1][j + 1]);
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }

                            }
                            // ######## if in the upper side ######## 
                            if (i == 0 && j > 0 && j < firstTable.length - 1) {
                                int totalOneNumberOfNeighbours = (firstTable[i][j - 1] + firstTable[i][j + 1]
                                    + firstTable[i + 1][j - 1] + firstTable[i + 1][j] + firstTable[i + 1][j + 1]);
                                
                                if (firstTable[i][j] == 1) {
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                if (firstTable[i][j] == 0) {
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }
                            }
                            // ######## if in the lower side ######## 
                            if (i == firstTable.length - 1 && j > 0 && j < firstTable.length - 1) {
                                int totalOneNumberOfNeighbours = (firstTable[i][j - 1] + firstTable[i][j + 1]
                                    + firstTable[i - 1][j - 1] + firstTable[i - 1][j] + firstTable[i - 1][j + 1]);
                                
                                if (firstTable[i][j] == 1) {
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                if (firstTable[i][j] == 0) {
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }
                            }
                            // ######## if in the left side ######## 
                            if (j == 0 && i > 0 && i < firstTable.length - 1) {
                                int totalOneNumberOfNeighbours = (firstTable[i + 1][j] + firstTable[i - 1][j]
                                    + firstTable[i + 1][j + 1] + firstTable[i][j + 1] + firstTable[i - 1][j + 1]);
                                
                                if (firstTable[i][j] == 1) {
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                if (firstTable[i][j] == 0) {
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }
                            }
                            // ######## if in the right side ######## 
                            if (j == firstTable.length - 1 && i > 0 && i < firstTable.length - 1) {
                                int totalOneNumberOfNeighbours = (firstTable[i + 1][j] + firstTable[i - 1][j]
                                    + firstTable[i + 1][j - 1] + firstTable[i][j - 1] + firstTable[i - 1][j - 1]);
                                
                                if (firstTable[i][j] == 1) {
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                if (firstTable[i][j] == 0) {
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }
                            }
                            // ######## if in the first corner ######## 
                            if (i == 0 && j == 0) {
                                int totalOneNumberOfNeighbours = (firstTable[i + 1][j] + firstTable[i + 1][j + 1] 
                                    + firstTable[i][j + 1]);
                                
                                if (firstTable[i][j] == 1) {
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                if (firstTable[i][j] == 0) {
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }
                            }
                            // ######## if in the second corner ######## 
                            if (i == 0 && j == firstTable.length - 1) {
                                int totalOneNumberOfNeighbours = (firstTable[i][j - 1] + firstTable[i + 1][j - 1]
                                    + firstTable[i + 1][j]);
                                
                                if (firstTable[i][j] == 1) {
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                if (firstTable[i][j] == 0) {
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }
                            }
                            // ######## if in the third corner ######## 
                            if (i == firstTable.length - 1 && j == 0) {
                                int totalOneNumberOfNeighbours = (firstTable[i - 1][j] + firstTable[i - 1][j + 1]
                                    + firstTable[i][j + 1]);
                                
                                if (firstTable[i][j] == 1) {
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                if (firstTable[i][j] == 0) {
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }
                            }
                            // ######## if in the forth corner ######## 
                            if (i == firstTable.length - 1 && j == firstTable.length - 1) {
                                int totalOneNumberOfNeighbours = (firstTable[i][j - 1] + firstTable[i - 1][j - 1] 
                                    + firstTable[i - 1][j]);
                                
                                if (firstTable[i][j] == 1) {
                                    if (totalOneNumberOfNeighbours > 3) {
                                        updatedTable[i][j] = 0;
                                    }
                                    if (totalOneNumberOfNeighbours < 2) {
                                        updatedTable[i][j] = 0;
                                    }
                                }
                                if (firstTable[i][j] == 0) {
                                    if (totalOneNumberOfNeighbours == 3) {
                                        updatedTable[i][j] = 1;
                                    }
                                }
                            }

                        }
                    }
                    /**
                     * ********** Controlling and updating step ending ************
                     */

                    //fill firstTable with updatedTable
                    for (int row = 0; row < firstTable.length; row++) {
                        for (int column = 0; column < firstTable.length; column++) {
                            firstTable[row][column] = updatedTable[row][column];
                        }
                    }
                    //
                    switch (step) {
                        case 0:
                            System.out.println("It is converted to the following table after 1st step:");
                            break;
                        case 1:
                            System.out.println("It is converted to the following table after 2nd step:");
                            break;
                        case 2:
                            System.out.println("It is converted to the following table after 3th step:");
                            break;
                        default:
                            System.out.println("It is converted to the following table after " + steps + " th step:");
                    }
                    
                    //printing table
                    for (int row = 0; row < updatedTable.length; row++) {
                        for (int numberOfHyphen = 0; numberOfHyphen < updatedTable.length * 4 + 1; numberOfHyphen++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        for (int column = 0; column < updatedTable.length; column++) {
                            System.out.print("| " + updatedTable[row][column] + " ");
                        }
                            System.out.print("|\n");
                    }

                    for (int numberOfHyphen = 0; numberOfHyphen < updatedTable.length * 4 + 1; numberOfHyphen++) {
                        System.out.print("-");
                    }
                    System.out.print("\n\n");
                    //
                }
                // convert Bin to Dec
                int[] convertedTable = new int[updatedTable.length];
                for (int i = 0; i < updatedTable.length; i++) {
                    int power = updatedTable.length - 1;
                    for (int j = 0; j < updatedTable.length; j++) {
                        convertedTable[i] += updatedTable[i][j] * (int) Math.pow(2, power);
                        power--;
                    }
                }
                //print decimal value of new table
                System.out.print("The decimal value for the second table after " + steps + " steps: ");
                for (int i = 0; i < convertedTable.length; i++) {
                    System.out.print(convertedTable[i] + "-");
                }
                System.out.println("\b.");
                //

                //when everything is printed, set end to true for breaking loop.
                end = true;
            }
        }
    }

    ///////////////////////// Methods ////////////////////////////
    /*
    defineArraySize method returns the value of number 
    which seperated with '-' in input string.
    Method has 1 String parameter which taken from user.
    */
    public static int defineArraySize(String str) {
        int arraySize = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                arraySize++;
            }
        }
        return arraySize;
    }
    
    /*
    stringToArray method import numbers seperated with '-' in string to an array.
    Method has 1 String parameter which taken from user and 1 integer type array
    which have to fill with string's elements.
    */
    public static void stringToArray(String str, int[] inputArray) {
        int beginningIndex = 0;
        int indexArray = 0;
        for (int i = 0; i < inputArray.length + 1; i++) {
            if (((int) str.indexOf('-', beginningIndex) != -1)) {
                inputArray[indexArray] = Integer.parseInt(str.substring(beginningIndex, str.indexOf('-', beginningIndex)));
                beginningIndex = str.indexOf('-', beginningIndex) + 1;

                indexArray++;
            } else {
                inputArray[indexArray] = Integer.parseInt(str.substring(beginningIndex, str.length()));
            }
        }

    }
    
    /*
    This method checking numbers in array if they can represent with the number
    of size's field.
    Method has 1 integer type array and 1 integer value.
    */
    public static boolean checkNumbers(int[] inputArray, int size) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] >= Math.pow(2, size)) {
                return false;
            }
        }
        return true;
    }
    
    /*
    This method doing same thing with checkNumbers method but
    returns the value which can not represent with number of size's field.
    */
    public static int wrongNumber(int[] inputArray, int size) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] >= Math.pow(2, size)) {
                int wrongNumber = inputArray[i];
                return wrongNumber;
            }
        }
        return 0;
    }
    
    /*
    This method converting decimal numbers to binary numbers and returns
    an integer type array which filled with binary numbers.
    */
    public static int[] convertDectoB(int number, int size) {
        int[] numberAsBinary = new int[size];
        int indexNo = size - 1;

        while (number >= 1) {
            numberAsBinary[indexNo] = number % 2;
            number = number / 2;
            indexNo--;
        }
        return numberAsBinary;
    }
    
    
/*
    public static void fillUpdatedTable(int[][] TwoDTable, int[] OneDArray) {
        for (int i = 0; i < TwoDTable.length; i++) {
            TwoDTable[i] = convertDectoB(OneDArray[i], OneDArray.length);
        }
    }*/
/*
    public static void drawArray(int[][] TwoDTable) {
        for (int i = 0; i < TwoDTable.length; i++) {
            for (int k = 0; k < TwoDTable.length * 4 + 1; k++) {
                System.out.print("-");
            }
            System.out.println();
            for (int j = 0; j < TwoDTable.length; j++) {
                System.out.print("| " + TwoDTable[i][j] + " ");
            }
            System.out.print("|\n");
        }

        for (int k = 0; k < TwoDTable.length * 4 + 1; k++) {
            System.out.print("-");
        }
        System.out.println();
    }
*/
}
