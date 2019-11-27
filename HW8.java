/*****************************
*HW8.java
*Maddy Peterson
*
*Simulates single player Poker
******************************/
import java.util.Scanner;

public class HW8 
{
    
   public static void main(String[] args)
   { 
    Scanner stdIn = new Scanner(System.in);
    int chips = 100; 
    String response = "";
    String betChoice = "";
    int handsPlayed = 0;
    int betsWon = 0;
    int betsLost = 0;
    int bet = 0;
    int winnings = 0;
    boolean invalid = true;
    
    System.out.println("Welcome to 4 Card Poker\nYour initial bank roll is $100.00");
    System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n"); 
    
    System.out.print("Do you want to play a game? ");
    response = stdIn.nextLine();

    while(invalidInput(response))
    {
      System.out.print("Invalid input, try again\n");
      System.out.print("\nDo you want to play a game? ");
      response = stdIn.nextLine();
    }
    
    while(!response.equalsIgnoreCase("n") && chips > 0)
    {
      System.out.printf("\nPlace your bet [1, %d]: ",chips);
      betChoice = stdIn.nextLine();
      boolean notValid = true;
      String temp = betChoice.replaceAll("[^a-zA-Z]", "");
      if(betChoice.length() != temp.length())
      {
         notValid = false;
      }
      else
      {
         notValid = true;
      }
      while(notValid)
      {
         System.out.println("Invalid bet, try again.\n");
         System.out.printf("Place your bet [1, %d]: ",chips);
         betChoice = stdIn.nextLine();
         temp = betChoice.replaceAll("[^a-zA-Z]", "");
         if(betChoice.length() != temp.length())
         {
            notValid = false;
         }
         else
         {
            notValid = true;
         }
      }
     
      bet = Integer.parseInt(betChoice);
      while(bet < 0 || bet > chips)
      {
         System.out.println("Invalid bet, try again.\n");
         System.out.printf("Place your bet [1, %d]: ",chips);
         betChoice = stdIn.nextLine();
         bet = Integer.parseInt(betChoice);
      }
      chips -= bet;
      
      int[] deck = new int[36];
      initDeck(deck);
      int[] hand = new int[4];
      dealHand(deck, hand);
         
      //determine what the player has
      if(isQuad(hand))
      {
            winnings = 6545*bet;
            chips += bet + winnings;
            betsWon++;;
            System.out.print("\n\nCongrats: you got 4 of a kind and have won $" + winnings);
      }
         else if(isTrip(hand))
         {
            winnings = 51*bet;
            chips += bet + winnings;
            betsWon++;
            System.out.print("\n\nCongrats: you got 3 of a kind and have won $" + winnings);
         }
         else if(isStraight(hand))
         {
            winnings = 38*bet;
            chips += bet + winnings;
            betsWon++;
            System.out.print("\n\nCongrats: you got a straight and have won $" + winnings);
         }
         else if(is2Pair(hand))
         {
            winnings = 22*bet;
            chips += bet + winnings;
            betsWon++;
            System.out.print("\n\nCongrats: you got 2 pair and have won $" + winnings);
         }
         else if(isPair(hand))
         {
            winnings = bet;
            chips += bet + winnings;
            betsWon++;;
            System.out.print("\n\nCongrats: you got 2 of a kind and have won $" + winnings);
         }
         else
         {
            betsLost++;
            System.out.print("\n\nSorry: you got bubkiss and have lost $" + bet);
         }
         
         handsPlayed++;
         
         if(chips >= 1)
         {
            System.out.print("\n\nDo you want to play again? ");
            response = stdIn.nextLine();
            while(invalidInput(response))
            {
               System.out.println("\nInvalid input, please try again\n");
               System.out.print("\nDo you want to play again? ");
               response = stdIn.nextLine();
            }
         }
      }//end while loop
      
      //display how many hands were played, how many bets were won, how many bets were lost, and net winning
      System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
      System.out.println("\nThanks for playing.\n");
      System.out.printf("You played a total of %d hands.\n", handsPlayed);
      System.out.printf("Of which, you won %d\n", betsWon);
      System.out.printf("And you lost %d", betsLost);
      if(chips <= 0)
      {
         System.out.print("\n\nBut in the end you lost $100 ");
      }
      else 
      {
         chips -= 100;
         System.out.print("\n\nBut in the end you walked away with $" + chips);
      }
   }//end main method
   
   public static boolean invalidInput(String input)
   {
      if(input.charAt(0) == 'n' || input.charAt(0) == 'N' || input.charAt(0) == 'y' || input.charAt(0) == 'Y')
      {
         return false;
      }
      return true;
   }//end invalidInput method
   
   public static void sortHand(int[] hand)
   {
      for(int i = 0; i < hand.length; i++)
      {
         int maxLoc = i;
         for(int j = i+1; j < hand.length; j++)
         {
            if(hand[j] > hand[maxLoc])
            {
               maxLoc = j;
            }
         }
         int tmp = hand[i];
         hand[i] = hand[maxLoc];
         hand[maxLoc] = tmp;
      }
   }//end sortHand method
   
   public static void initDeck(int[] deck)
   {
      //assign elements of deck with values 1 to 9 four times, consecutively
      for(int i = 0; i < 9; i++)
      {
         deck[i] = i + 1;
      }
      for(int i = 0; i < 9; i++)
      {
         deck[i+9] = i + 1;
      }
      for(int i = 0; i < 9; i++)
      {
         deck[i+18] = i + 1;
      }
      for(int i = 0; i < 9; i++)
      {
         deck[i+27] = i + 1;
      }
   }//end initDeck method
   
   public static void shuffleDeck(int[] deck, int n)
   {
      int one = 0;
      int two = 0;
      int temp = 0;
      for(int i = 0; i < n; i++)
      {
         one = (int) (Math.random() * 35);
         two = (int) (Math.random() * 35);
         temp = deck[one];
         deck[one] = deck[two];
         deck[two] = temp;
      }
   }//end shuffleDeck method
   
   public static void dealHand(int[] deck, int[] hand)
   {
      initDeck(deck);
      shuffleDeck(deck, 36);
      //Use first four values in the deck to assign the four values of the hand
      for(int i = 0; i < 4; i++)
      {
         hand[i] = deck[i];
      }
      System.out.println("\nLet the cards fall where they may...");
      displayHand(hand);
      System.out.println("\n\nLet's get things in order...");
      sortHand(hand);
      displayHand(hand);
   }//end dealHand method
   
   public static void displayHand(int[] hand)
   {
      for(int i = 0; i < 4; i++)
      {
         System.out.print(hand[i] + " ");
      }
   }//end displayHand method
 
   public static boolean isQuad(int[] hand)
   {
      if(hand[0] == hand[1] && hand[0] == hand[2] && hand[0] == hand[3])
      {
         return true;
      }
      return false;
   }//end isQuad method
   
     public static boolean isTrip(int[] hand)
   {
      if((hand[0] == hand[1] && hand[0] == hand[2]) || hand[1] == hand[2] && hand[1] == hand[3])
      {
         return true;
      }
      return false;

   }//end isTrip method
   
     public static boolean isStraight(int[] hand)
   {
      if(hand[0] == (hand[1] +1) && hand[1] == (hand[2] + 1) && hand[2] == (hand[3] + 1))
      {
         return true;
      }
      return false;
   }//end isStraight method
   
     public static boolean is2Pair(int[] hand)
   {
      if(hand[0] == hand[1] && hand[2] == hand[3])
      {
         return true;
      }
      return false;
   }//end is2Pair method
   
     public static boolean isPair(int[] hand)
   {
      if(hand[0] == hand[1] || hand[1] == hand[2] || hand[2] == hand[3])
      {
         return true;
      }
      return false;
   }//end isPair method
}//end class HW8
