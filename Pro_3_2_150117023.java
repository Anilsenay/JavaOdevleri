
import java.util.Scanner;

/*
 * This program basicly prints X,Y,Z,W letters 
 * User determine the size and which letter which user wants.
 * Then program prints the letter as the specified size by user.
 */

/**
 *
 * @author anilsenay / Anıl Şenay / Number: 150117023
 */
public class Pro_3_2_150117023 {
    public static void main(String[] args){
        
        System.out.println("Welcome to letter printer program.");
        Scanner input = new Scanner(System.in);
        boolean correctSize = false; //control variable for true size
        boolean correctLetter = false; //control variable for true letter
        boolean continued = true; //control variable for if user wants to continue
        
        do{
            //getting size
            System.out.print("Enter the size: ");  
            int size = input.nextInt();
            while(correctSize == false){
                if(size % 2 != 0 && size >= 5){
                    correctSize = true;
                }
                else{
                    System.out.print("Invalid size. Enter the size again: ");
                    size = input.nextInt();
                }
            }
		correctSize = false;
            //getting letter
            System.out.print("Enter the letter: ");
            String letter = input.next().toUpperCase();
            while(correctLetter == false){
                if(letter.charAt(0) == 'X' || letter.charAt(0) == 'Y' || letter.charAt(0) == 'Z' || letter.charAt(0) == 'W')
                    correctLetter = true;
                else{
                    System.out.print("Invalid letter. Enter the letter again: ");
                    letter = input.next().toUpperCase();
                    }
            }
		correctLetter = false;
            //controls for letters
            switch(letter.charAt(0)){
                //  Z letter
                case 'Z':
                
                    for(int i = 0; i < size; i++){
                        System.out.print("*");
                    }
                    System.out.println();
                
                    for(int j = size-2; j > 0; j--){
                        for(int k = 0; k < j; k++){
                            System.out.print(" ");
                        }
                        System.out.print("*");
                        System.out.println();    
                    }
                
                    for(int i = 0; i < size; i++){
                        System.out.print("*");
                    }
                    System.out.println();
                    break;
                //  X letter
                case 'X':
                
                    for(int i = 0; i < size/2+1; i++){
                        for(int j = 0; j < size-1-i; j++){
                            if(i == j)
                                System.out.print("*");
                            else{
                                System.out.print(" ");
                            }
                        }
                        System.out.print("*");
                        System.out.println();        
                    }
                    for(int a = size/2; a > 0; a--){
                        for(int b = size; b >= 0; b--){
                            if(b == a || b == size -a+1)
                                System.out.print("*");
                            else{
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                //  W letter
                case 'W':
                    for(int i = 0; i < size; i++){
                        for(int j = 0; j < 4*size-1; j++){
                            if( i == j || i+j == (4*size -3)/2 || j-i == (4*size-3)/2 || i+j == (4*size -4))
                                System.out.print("*");
                            else
                                System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;
                //  Y letter
                case 'Y':
                    for(int i = 0; i < size/2+1; i++){
                        for(int j = 0; j < size-1-i; j++){
                            if(i == j)
                                System.out.print("*");
                            else{
                                System.out.print(" ");
                            }
                        }
                        System.out.print("*");
                        System.out.println();
                    }
                    for(int a = 0; a < size/2; a++){
                        for(int b = 0; b < size /2 ;b++){
                            System.out.print(" ");
                        }
                        System.out.print("*");
                        System.out.println();
                    }
                    break;
            }//end of letters block
            
            //asking user if wants to continue
            System.out.print("Would you like to continue? (Y or N): ");
            String ifContinue = input.next().toUpperCase();
            if(ifContinue.charAt(0) == 'Y'); //it is an empty if block
            else{
                continued = false;
                System.out.println("Program ends, see you later!");
            }
            
        }while(continued);
    }
}
