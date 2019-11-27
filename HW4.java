/*******************************************************
*HW4.java
*Maddy Peterson
*
* Allows user to play a simple dice game against computer
*********************************************************/
import java.util.Scanner;

public class HW4 
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		String input;
		boolean keepRolling = true;
      boolean userInput = true;
      
      int playerDie1 = 0;
      int playerDie2 = 0;
      int opponentDie1 = 0;
      int opponentDie2 = 0;
      String whoWon = " ";
      String name;
      
      int rounds = 0;
      int wins = 0;
      int losses = 0;
      
      System.out.println("Welcome to Computer Dice");
      System.out.println("-------------------------------");
      System.out.println("You will be playing dice agaisnt the computer\nyou can only win with a pair or a straight\nany pair beats any straight\nany pair beats any junker\nin the case of two pairs - highest pair wins\nin the case of two straights - highest straight wins\nin the case of a tie - you lose");
      System.out.println("-------------------------------");
      System.out.println("Input your first name: ");
      name = stdIn.next();      
		
		do
		{
         System.out.println(name);
         System.out.println("--------");
         playerDie1 = (int)(Math.random() * 6) + 1;
         playerDie2 = (int)(Math.random() * 6) + 1;
			System.out.println(playerDie1 + " " + playerDie2);			
         System.out.println("Opponent");
         System.out.println("--------");
         opponentDie1 = (int)(Math.random() * 6) + 1;
         opponentDie1 = (int)(Math.random() * 6) + 1;
			System.out.println(opponentDie1 + " " + opponentDie2);
         whoWon = winner(playerDie1, playerDie2, opponentDie1, opponentDie2);			
         System.out.println(whoWon);
         
         if(whoWon.equals("Congrats," + name + "you win!"))
         {
            wins++;
         }
         else
         {
            losses++;
         }
         
         do
         {
            System.out.print("\nWould you like to play again, " + name + "[y/n]: ");
			   input = stdIn.next();
			   if(input.equalsIgnoreCase("y"))
			   {
               userInput = false;
			   }
			   else if (input.equalsIgnoreCase("n"))
			   {
			   	keepRolling = false;
               userInput = false;
			   }
            else
            {
               System.out.println("Invalid input, " + name + "try again");
               userInput = true;
            }
         }while(userInput);
         rounds++;
		}while(keepRolling);
      System.out.println("\nGame stats");
      System.out.println("-----------------");
      System.out.println("Rounds played: " + rounds);
      System.out.println("Number of wins: " + wins);
      System.out.println("Number of losses: " + losses);
      System.out.println("-----------------");
	}
   
   public static String winner(int a, int b, int c, int d) 
   {
      String winnerIs = " ";
      
      if(a == b)
      {
         if(c == d)
         {
            if(a > c)
           {
              winnerIs = "Congrats, you win!";
           }
           else
           {
              winnerIs = "Sorry, you lose.";
           }
         }
         else
         {
            winnerIs = "Congrats, you win!";
         }
      }
      else if(a == (b+1) || a == (b-1))
      {
         if(c == d)
         {
            winnerIs = "Sorry, you lose.";
         }
         else if(c == (d+1) || c == (d-1))
         {
            if((a+b) > (c+d))
            {
               winnerIs = "Congrats, you win!";  
            }
            else 
            {
               winnerIs = "Sorry, you lose."; 
            }
           }
          else
          {
             winnerIs = "Congrats, you win!";
          }
       }
       else
       {
          winnerIs = "Sorry, you lose.";
       }
       return winnerIs;
   }
 }