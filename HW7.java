/*******************************************************
*HW7.java
*Maddy Peterson
*
*2 player game where one player guessee a common phrase
*********************************************************/
import java.util.Scanner;

public class HW7 
{
    
   public static void main(String[] args)
   { 
    Scanner stdIn = new Scanner(System.in);
    
    char guess = ' ';
    int temp = 0;
    int spaces = 0;
    int vowels = 0;
    int consonants = 0;
    boolean keepRunning = true;
    boolean start = false;
    
    System.out.println("Player 1, enter a phrase with all lowercase letters: ");
    String phrase = stdIn.nextLine();
    
    //declare character array with size length.phrase
    char [] cPhrase = new char[phrase.length()];
    System.out.print("\n\n\n\n\n\n\n\n");
    spaces = initTemplateArray(phrase, cPhrase);
    
    while(!(start))
    {
      printTemplateArray(cPhrase);
      
      guess = getConsonant(stdIn);
      consonants += updateTemplateArray(cPhrase, phrase, guess);
      if(consonants > 0)
      {
         start = true;
      }
    }
    
    while(keepRunning && start)
    {
       printTemplateArray(cPhrase);
       
       System.out.print("\nWould you like to buy a vowel? ");
       String input = stdIn.next().toLowerCase();
       if(input.charAt(0) == 'y' && input.length() == 1)
       {
         guess = getVowel(stdIn);
         vowels +=  updateTemplateArray(cPhrase, phrase, guess);
         
       }
       else if(input.charAt(0) == 'n' && input.length() == 1)
       {
         guess = getConsonant(stdIn);
         consonants += updateTemplateArray(cPhrase, phrase, guess);
       }
       keepRunning = keepGoing(cPhrase);
    }
    
    printTemplateArray(cPhrase);
    System.out.printf("\nCongratulations, you uncovered the secret message! \nThe phrase contained: %d space(s) %d vowel(s) and %d consonant(s)", spaces, vowels, consonants);
   }//end main method
   
   public static boolean keepGoing(char [] tmpArr)
   {
      for(int i=0; i<tmpArr.length; i++)
      {
         if(tmpArr[i] == '?')
         {
            return true;
         }
      }
      return false;
   }
   
   public static int initTemplateArray(String sPhrase, char [] tmpArr)
   {
      //for loop to replace letters with ? and spaces stay spaces
      //spaces++ in for loops for spaces
      //return space characters
      int spaces = 0;
      for(int i=0; i<sPhrase.length(); i++)
      {
         tmpArr[i] = sPhrase.charAt(i);
      }
      for(int j=0; j<sPhrase.length(); j++)
      {
         if(tmpArr[j] == ' ')
         {
            spaces++;
         }
         else
         {
            tmpArr[j] = '?';
         }
      }
      return spaces;
   }
   
   public static void printTemplateArray(char [] tmpArr)
   {
      //print template array with for loop
      System.out.print("\nCommon Phrase\n --------------\n");
      for(int i=0; i<tmpArr.length; i++)
      {
         System.out.print(tmpArr[i]);
      }
   }
   
   public static boolean isVowel(char c)
   {
      //returns true when c is a vowel
      boolean vowel = false;
      if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
      {
         vowel = true;  
      }
      return vowel;
   }
   
   public static char getConsonant(Scanner stdIn)
   {
      //prompts user for a char response until it is a lower case consonant
      boolean keepGoing = true;
      String sGuess = "";
      char guess = ' ';
      System.out.print("\nEnter a lowercase consonant guess: ");
      while(keepGoing)
      {
         sGuess = stdIn.next();
         guess = sGuess.charAt(0);
         if(isVowel(guess))
         {
            keepGoing = true;
            System.out.print("\nInvalid entry, enter a lowercase consonant guess: ");
         }
         else
         {
            keepGoing = false;
         }
      }
      return guess;
   }
   
   public static char getVowel(Scanner stdIn)
   {
      //goes til user input is a vowel
      boolean keepGoing = true;
      String sGuess = "";
      char guess = ' ';
      System.out.print("\nEnter a lowercase vowel guess: ");
      while(keepGoing)
      {
         sGuess = stdIn.next();
         guess = sGuess.charAt(0);
         if(isVowel(guess))
         {
            keepGoing = false;
         }
         else
         {
            System.out.print("\nInvalid entry, enter a lowercase vowel guess: ");
         }
      }
      return guess;
   }
   
   public static int updateTemplateArray(char [] tmpArr, String sPhrase, char guess)
   {
      //replace ? with guess and count number of places the letter went
      int temp = 0;
      for(int i=0; i<tmpArr.length; i++)
      {
         if(sPhrase.charAt(i) == guess)
         {
            tmpArr[i] = guess;
            temp++;
         }
      }
      return temp;
   }
}//end class HW7    
    
