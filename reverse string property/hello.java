//Created by Anastassiya Neznanova
//This program determines the following word's criteria
//if you move the first letter to the end of the word, and then spell the result backwards,
//you will get the original word. For example, banana-->ananab=banana
//department of Computer Science
//Mac-190
//09/21/2014
//Prof. L.Muller
import java.util.Scanner; // for input from user

public class hello //declaration of the class
{
public static void main(String[] args)
{
   Scanner keyboard = new Scanner(System.in);//for user input
   int length;
   System.out.print(" ***This program determines the following word's criteria:\n " +
   "if you move the first letter to the end of the word, and then spell the result backwards,\n" +
   " you will get the original word.***\n\n");
   System.out.print(" **Enter your word and type quit if you want this program to quit.**");
   String originalWord = keyboard.next();// for user input

 // Program loops until user iputs quit
while (!originalWord.equalsIgnoreCase("quit"))
{
    originalWord = originalWord.toLowerCase();//converts the word to lower case letters
    length = originalWord.length();
    String backWord = originalWord.substring(0,1);//back word equal to the first letter of original word
// Loop letters from last to second into backWord
do
{
    backWord =backWord+ originalWord.charAt(length - 1);//reverts original word 
    length--;//decrements the length
    }
    while (length > 1);
    System.out.println(backWord + " " + originalWord);
    // Determines if originalWord == to backWord
    if (originalWord.equals(backWord))
    System.out.println("The word " + originalWord + " has this property and it is equal to the original word");
       else
    System.out.println("The word " + originalWord + " does not have this property and it is not equal to the original word.");
    System.out.print("Enter another word or type 'quit' to end this program ");
    originalWord = keyboard.next();//input from the user
}
    System.out.println("Thank you for using this program");
}
}
