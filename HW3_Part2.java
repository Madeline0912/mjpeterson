/********************************************
*HW3_Part2.java
*Maddy Peterson
*
*Verify if a given lock combination is valid
*********************************************/
import java.util.Scanner;

public class HW3_Part2
{
   public static void main(String[] args)
   {
    Scanner stdIn = new Scanner(System.in);
    
    String lock; //lock combination
    int length; //length of the lock combination
    char one;
    char two;
    char four;
    char five;
    char seven;
    char eight;
    char R1; //first required R
    char L; //required L
    char R2; //second required R
   
    System.out.print("Please enter a lock combination (ddRddLddR): ");
    lock = stdIn.nextLine();
    length = lock.length();
    
    if (length == 9)
    {
      one = lock.charAt(0);
      two = lock.charAt(1);
      R1 = lock.charAt(2);
      four = lock.charAt(3);
      five = lock.charAt(4);
      L = lock.charAt(5);
      seven = lock.charAt(6);
      eight = lock.charAt(7);
      R2 = lock.charAt(8);
      
      if(one >= '0' && one <= '9')
      {
         if(two >= '0' && two <= '9')
         {
            if(four >= '0' && four <= '9')
            {
               if(five >= '0' && five <= '9')
               {
                  if(seven >= '0' && seven <= '9')
                  {
                     if(eight >= '0' && eight <= '9')
                     {
                        if(R1 == 'R' && L == 'L' && R2 == 'R')
                        {
                           System.out.println(lock + " is a valid lock combination");
                        }
                     }
                   }
                 }
               }
             }
           }
         }
   else
   {
      System.out.println(lock + " is not a valid lock combination!");
      System.out.println("Check the length of the combination and position of Rs and Ls");
   }

    
 } //end main method  
   
} //end class HW3_Part2 