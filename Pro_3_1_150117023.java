
import java.util.Scanner;

/*
 * This program basicly prints stars, blank or new line character for amount that user write before character.
 * Program takes an input from user as characters and how many of them. Then prints them.
 * 
 */

/**
 *
 * @author anilsenay / Anıl Şenay / Number: 150117023
 */
public class Pro_3_1_150117023 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to image printer program.");
        System.out.print("Please enter your sequence: ");
        String sequence = input.next();
        int times = 1; //control variable for how many times we want to print a character

        for(int i=0; i < sequence.length(); i++){
            char ch = sequence.charAt(i);
            
            //getting amount if this character is a digit.
            if(Character.isDigit(ch)){
                times = (ch - 48);
            }
            //if character is not a digit
            else{
                int j = 0;
                while( j < times){
                    if(sequence.charAt(i) == 'b') 
                        System.out.print(" ");
                    
                    if(sequence.charAt(i) == 's')
                        System.out.print("*");
                    
                    if(sequence.charAt(i) == 'n')
                        System.out.print("\n");
                    
                j++;
                }
                
                times = 1;
            }
        }
    }
}
