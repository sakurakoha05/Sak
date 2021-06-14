/**
 * 
 * Purpose: Build a number game
 * 
 * Date: 05/10/21
 * 
 * Programmer: Sakurako Huynh-Aoyama
 * 
 */

import java.util.Scanner;
public class FindTheRule
{ 
    static int output = 0;
    static int number = 0;
    static int numGuesses = 0;
    static String guess = null;
    static boolean option1 = false;
    static boolean option2 = false;
    static boolean option3 = false;
    static boolean option4= false;
    static boolean userAnswer = false;
    static String operation1 = null;
    static String operation2 = null;
    static String YN = null;
    static String answerKey= null;
    static boolean userGuess = false;
    static int temporary =0;
    static Scanner in = new Scanner (System.in);

    public static void main(String [] args)
    {
        Scanner in = new Scanner (System.in);

        System.out.print(" Welcome to Find The Rule! The rules are simple, you");
        System.out.println(" must find the pattern / set of equations that occurs from the input to output :] ");
        System.out.println("");

        while(userGuess!=true){
            System.out.println(" ");
            System.out.println("Menu Selection: ");
            System.out.println("[0] Try an input");
            System.out.println("[1] Guess the pattern");
            System.out.println("[2] Quit");
            System.out.println("");

            int choiceSelection = in.nextInt();

            if(choiceSelection == 0){
                generateOutput();
            }
            if(choiceSelection == 2){
                userGuess = true;
                System.out.println("Number of guesses: " + numGuesses);
                System.out.println("Answer: " + answerKey );
                System.out.println("");
            }
            if(choiceSelection ==1){
                setUserOperation();
            }
            } 
        }
        private static void generateOutput(){
                int random = (int) (Math.random()*10+1);
                int random2 = (int) (Math.random()*10+1);
                int equationSelection = (int)(Math.random()*10+1);
                System.out.println(" Please type in any number you would like as your input");
                number = in.nextInt();   
                numGuesses++;
                if(equationSelection==1 || equationSelection == 2){
                    output= (int) number* random;
                    answerKey = number + "*" + random;
                    option1=true;
                }
                else if(equationSelection==3||equationSelection==4||equationSelection==5||equationSelection==9){
                    output= (int) number/random+random2;
                    answerKey = number + "/" + random + "+" + random2;
                    option2=true;
                }
                else if(equationSelection==6||equationSelection==7||equationSelection==8||equationSelection==10){      
                    output = (int) number*random-random2;
                    answerKey = number + "*" + random + "-" + random2;
                    option3=true;
                }
                System.out.println(" Input: " + number + " Output: " + output);
                System.out.println("");
    }
    private static void setUserOperation(){ 
        numGuesses++;
        temporary=number;
        updateTempWithUserInput();
       
        // Ask for additional operation
        System.out.println("Would you like to add another operation? (yes or no)");
        
        String YN = in.next();
        while (YN.equalsIgnoreCase("yes"))
        {
            updateTempWithUserInput();  
            System.out.println("Would you like to add another operation? (yes or no)");
            YN = in.next();
        }
        
        // Check their guesses
        checkUserGuess();
        System.out.println("");
    }
    private static void updateTempWithUserInput()
    {
        String userOperator = getUserEquationOperator();
        int userNumber = getUserEquationNumber();
        switch (userOperator)
        {
            case "+": temporary += userNumber;
                break;
            case"-" : temporary -= userNumber;
                break;
            case "*": temporary *= userNumber;
                break;
            case "/" : temporary /= userNumber;
                break;
            default : {
                System.out.println("Please enter one of the accepted operations");
                updateTempWithUserInput();
            }
        }
    }
    private static String getUserEquationOperator()
    {
        System.out.println(" Please type in the operator: ");
        return in.next();
    }
    private static int getUserEquationNumber()
    {
        System.out.println(" Please type in the number: ");
        return in.nextInt();
    }
    private static void checkUserGuess(){
        if(temporary == output){
            System.out.println("Congratulations!! You have guessed the pattern correctly :))");
            System.out.println("Number of guesses: " + (numGuesses-1));
            System.out.println("");
            userGuess= true;
        }
        else{
            System.out.println("Wrong...");
            System.out.println("");
        }
    }
}