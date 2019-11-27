/****************************************************
*HW9.java
*Maddy Peterson
*
*Allows user to add, remove, and print a list of words
******************************************************/
import java.util.*;

public class HW9 
{
    
   public static void main(String[] args)
   { 
      Scanner stdIn = new Scanner(System.in);
    
      String word;
      ArrayList<String> words = new ArrayList<String>();
      int choice = 0;
      String input = "";
      int numWords = 0;
      boolean action = true;
    
      System.out.println("Welcome to WordList!");
      System.out.println("---------------------------\n");
      System.out.print("\n1. Add Word\n2. Remove Word\n3. Print Words\n4. Quit\n");
      choice = getMenuChoice(stdIn);
      
      while(choice != 4)
      {
         if(choice == 1)
         {
            System.out.print("\nEnter a word to add to WordList: ");
            word = stdIn.nextLine();
            word.toLowerCase();
            action = addWord(words, numWords, word);
            if(action)
            {
               numWords++;
               System.out.println(word + " has been added");
            }
            else
            {
               System.out.println(word + " is already in the list");
            }
         }
         if(choice == 2)
         {
            System.out.print("\nEnter a word to remove from WordList: ");
            word = stdIn.nextLine();
            word.toLowerCase();
            action = removeWords(words, numWords, word);
            if(action)
            {
               numWords--;
               System.out.println(word + " has been removed");
            }
            else
            {
               System.out.println(word + " is not in the list");
            }
         }
         if(choice == 3)
         {
            printWords(words, numWords);
         }
         
         System.out.print("\n1. Add Word\n2. Remove Word\n3. Print Words\n4. Quit\n");
         choice = getMenuChoice(stdIn);
      }
   }//end main method
   
   public static boolean addWord(ArrayList<String> words, int numWords, String word)
   {
      //adds word parameter to words array if and only if the array does not currently contain it
      if(!words.contains(word) || numWords == 0)
      {
         words.add(word);
         return true;
      }
      return false;
   }
   
   public static boolean removeWords(ArrayList<String> words, int numWords, String word)
   {
      //removes word parameter from from the words array if and only if the array contains it
      if(words.contains(word))
      {
         words.remove(word);
         return true;
      }
      return false;
   }
   
   public static void printWords(ArrayList<String> words, int numWords)
   {
      //sorts the words and then prints them
      Collections.sort(words);
      System.out.print(words);
   }
   
   private static int findWord(ArrayList<String> words, String word)
   {
      //searches for the word and returns the index of the parameter or -1
      return words.indexOf(word);   
   }
   
   private static int getMenuChoice(Scanner stdIn)
   {
      //prints the menu options and validates the user choice
      int temp = 0;
      
      System.out.print("Choose an option (1-4): ");
      String sInput = stdIn.nextLine();
      String changed = sInput.replaceAll("[a-zA-Z]", "");
      
      if(sInput.length() == 1 && (changed.length() == 1))
      {
         int iInput = Integer.parseInt(sInput);
         if(iInput > 0 && iInput < 5)
         {
            return iInput;
         }
      }
      return getMenuChoice(stdIn);
   }
}
   
