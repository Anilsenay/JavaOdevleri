
import java.util.Scanner;

/*
 * This program does processing with strings. 
 * The program has 6 different option such as counting characters, print words, deleting or replacing substring, sorting, founding hash code. 
 * It is basicly analyzing the string which taking from user according to selected option.
 */

/**
 *
 * @author anilsenay / Anıl Şenay / Number : 150117023
 */
public class Pro4_150117023 {
    
    public static void main(String[] args){
        
        String str = "";
        char ch;
        int type;
        String subStr;
        String subStr2;
        int valueB;
        
        Scanner in = new Scanner(System.in);
        System.out.print("Welcome to our String Analyzer Program.\n"
                + "     1. Count number of chars \n" 
                + "     2. Print the words in a sentence \n"
                + "     3. Delete substring \n"
                + "     4. Replace substring \n"
                + "     5. Sort characters \n"
                + "     6. Hash code of a string \n" );
        System.out.print("Please enter your menu choice: ");
        String userChoice = in.nextLine();
        
        //beginning of infinite loop for continue if user did not write exit or quit
        while(!userChoice.toLowerCase().contains("exit") && !userChoice.toLowerCase().contains("quit")){
        //Choice = 1
        if(userChoice.charAt(0) == '1'){
            System.out.print("Enter an input string: ");
            str = in.nextLine();
            System.out.print("Enter an input char: ");
            ch = in.nextLine().charAt(0);
            
            System.out.println("The number of " + ch + " in " + str + " is " + numOfChars(str, ch) + ".");
            System.out.println();
            
        }
        //Choice = 2
        else if(userChoice.charAt(0) == '2'){
            System.out.print("Enter and input string: ");
            str = in.nextLine();
            System.out.println("The output is:");
            printWords(str);
            System.out.println();
    
        }
        //Choice = 3
        else if(userChoice.charAt(0) == '3'){
            System.out.print("Enter an input string: ");
            str = in.nextLine();
            System.out.print("Enter a substring: ");
            subStr = in.nextLine();
            System.out.print("Enter a type: ");
            type = (in.nextLine().charAt(0))-48;
            System.out.println(delete(str, subStr, type));
                
        }
        //Choice = 4
        else if(userChoice.charAt(0) == '4'){
            System.out.print("Enter an input string: ");
            str = in.nextLine();
            System.out.print("Enter the first substring: ");
            subStr = in.nextLine();
            System.out.print("Enter the second substring: ");
            subStr2 = in.nextLine();
            System.out.print(replace(str, subStr, subStr2));
            System.out.println();
                
        }
        //Choice = 5
        else if(userChoice.charAt(0) == '5'){
            System.out.print("Enter an input string: ");
            str = in.nextLine();
            System.out.print("Enter a type: ");
            type = (in.nextLine().charAt(0))-48;
            System.out.print(sortChars(str, type));
            System.out.println();
                
        }
        //Choice = 6
        else if(userChoice.charAt(0) == '6'){
            System.out.print("Enter an input string: ");
            str = in.nextLine();
            System.out.print("Enter a value for b: ");
            valueB = Integer.parseInt(in.nextLine());
            System.out.println("The hash code of " + str + " is " + hashCode(str, valueB) + ".");
                
        }
        
        System.out.print("Please enter your menu choice: ");
        userChoice = in.nextLine();
        }
        //ending of infinite loop for continue
        System.out.println("Program ends... Bye :)");
    }
    
    /*
    ############# BEGINNING OF THE METHODS ###############
    */
    // 1- Character number counting method. 
    public static int numOfChars(String str, char ch){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch)
                count++;
            
        }
        return count;
    }
    // 2- Prints words in a string one by one.
    public static void printWords(String str){
        
        for(int i = 0; i < str.length(); i++){
            
            if(str.charAt(i) == ' ') //when blank character is next one, it will go next line.
                System.out.println();
                       
            else if(str.charAt(i) == ',' || 
               str.charAt(i) == '!' || 
               str.charAt(i) == '_' || 
               str.charAt(i) == '(' || 
               str.charAt(i) == ')' || 
               str.charAt(i) == '.' || 
               str.charAt(i) == '?' ||
               str.charAt(i) == '-' ){
               
                if(i>1 && (Character.isLetter(str.charAt(i-1)) || Character.isDigit(str.charAt(i-1)))) // if any digit or letter before punctuations it will go next line.
                    System.out.println();
                
            }
            else
                System.out.print(str.charAt(i));

        }
    }
    // 3- Deleting a sub string from a string.
    public static String delete(String str, String subStr, int type){
        String newStr = "";
        
        if(type == 0){
            newStr = str.substring(0, str.indexOf(subStr)) + str.substring( str.indexOf(subStr) + subStr.length(), str.length() );            
            //this statement actually skip first choosen substring. Prints before and after parts of string.
        }
        else if(type == 1){
            int i = 0;
        
            while(i<str.length()) {
            
                if(((int)str.indexOf(subStr, i) != -1)){
                    newStr += (str.substring(i, str.indexOf(subStr, i))); //adding a substring from i to choosen subStr to newStr
                    i = str.indexOf(subStr, i) + subStr.length(); //i will be equal to next character index after subStr
                }
                else{
                    newStr += str.substring(i, str.length());
                    i = str.length();
                }
            }
            
        }
        else{
            newStr = "Wrong type!";
        }
        
        //This loop deleting remaining blank character after deleting a substring
        String newStr2 = "";
        for(int j = 0; j < newStr.length(); j++){
            if(j>1 && (newStr.charAt(j) == ' ' && newStr.charAt(j-1) == ' '));
                
            else
                newStr2 += newStr.charAt(j);
        }
        return newStr2;
    }
    
    // 4- Replaces sub strings in a string.
    public static String replace(String str, String subStr1, String subStr2){
        int i = 0;
            String newStr = "";
        
            while(i<str.length()) {
            
                if(((int)str.indexOf(subStr1, i) != -1)){
                    newStr += (str.substring(i, str.indexOf(subStr1, i))) + subStr2;
                    i = str.indexOf(subStr1, i) + subStr1.length();
                }
                else{
                    newStr += str.substring(i, str.length());
                    i = str.length();
                }
            }
            return newStr;        
    }
    // 5- Sorting characters in a string by their ascii values
    public static String sortChars(String str, int type){

        String newStr = "";
        String newStrOtherChars = "";

        int[] newString = new int[str.length()];
            
        for(int i = 0; i < str.length(); i++){
            newString[i] = str.charAt(i);
        }
        // ### type = 0 beginning ###
        if(type == 0){
            
            for(int j = 1; j < str.length(); j++){
                for(int k = 1; k < str.length(); k++){
                    if(newString[k] < newString[k-1]){
                        int temp = newString[k];
                        newString[k] = newString[k-1];
                        newString[k-1] = temp;
                    }
                }
            }
            
            for(int a = 0; a < str.length(); a++)
                newStr += (char)newString[a];
            return newStr;
        }
        // end of type = 0
        
        // ### type = 1 beginning###
        else if(type == 1){
            int[] typeOfChar = new int[4];// [0] = lower , [1] = upper , [2] = digit , [3] = others
            
            for(int i = 0; i < str.length(); i++){
                if(Character.isLowerCase(newString[i]))
                    typeOfChar[0]++;
                else if(Character.isUpperCase(newString[i]))
                    typeOfChar[1]++;
                else if(Character.isDigit(newString[i]))
                    typeOfChar[2]++;
                else
                    typeOfChar[3]++;
            }
            char[] otherChars = new char[typeOfChar[3]];
            
            //Sorting as groups of characters.
            while(typeOfChar[0] != 0 || typeOfChar[1] != 0 || typeOfChar[2] != 0){
                //sorting lower case characters
                while(typeOfChar[0]>0){ 
                    for(int i = 0; i < str.length(); i++){
                        if(Character.isLowerCase(newString[i])){
                            newStr += (char)newString[i];
                            typeOfChar[0]--;
                        }    
                    }
                }
                //sorting upper case characters
                while(typeOfChar[1]>0){ 
                    for(int i = 0; i < str.length(); i++){
                        if(Character.isUpperCase(newString[i])){
                            newStr += (char)newString[i];
                            typeOfChar[1]--;
                        }    
                    }
                }    
                //sorting digits
                while(typeOfChar[2]>0){ 
                    for(int i = 0; i < str.length(); i++){
                        if(Character.isDigit(newString[i])){
                            newStr += (char)newString[i];
                            typeOfChar[2]--;
                        }    
                    }
                }
                //sorting other characters
                while(typeOfChar[3]>0){ 
                    for(int i = 0; i < str.length(); i++){
                        if(!Character.isDigit(newString[i]) && !Character.isUpperCase(newString[i]) && !Character.isLowerCase(newString[i])){
                            newStrOtherChars += (char)newString[i];
                            typeOfChar[3]--;
                        }    
                    }
                }
                //Creating a array and filling with 'other character' group elements.
                //This array will be used for sorting by ascii value.
                for(int i = 0; i < newStrOtherChars.length(); i++){
                    otherChars[i] = newStrOtherChars.charAt(i);
                }
                //This loop is for sorting other characters by ascii value. This is the same loop as the one when type = 0               
                for(int j = 1; j < otherChars.length; j++){
                    for(int k = 1; k < otherChars.length; k++){
                        if(otherChars[k] < otherChars[k-1]){
                            char temp = otherChars[k];
                            otherChars[k] = otherChars[k-1];
                            otherChars[k-1] = temp;
                        }
                    }
                }
                //adding 'ordered other chars group' to our newStr string which will be returned.
                for(int i = 0; i < otherChars.length; i++){
                    newStr += otherChars[i];
                }
                
                //sorting other characters ending.
            }
        }
        //end of type = 1
        return newStr;
        
    }
    // 6- Finds the hash code of a string.
    public static int hashCode(String str, int b){
        int hash = 0;
        int length = str.length();
        for(int i = 0; i < str.length(); i++){
            
            hash = hash + (int)(str.charAt(i)) * (int)Math.pow(b, length-1);
            length--;
        }
        return hash;
    }
}
