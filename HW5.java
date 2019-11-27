/********************************
*HW5.java
*Maddy Peterson
*
*Converts decimal numbers binary
*********************************/
import java.util.Scanner;

public class HW5
{
   public static void main(String[] args)
   { 
    Scanner stdIn = new Scanner(System.in);
    
    String strInput;
    int numInput;
    boolean keepGoing = true;
    
    do
    {
    System.out.print("Welcome to BinaryCalc 3000!");
    System.out.print("\nPlease input a decimal integer or q to quit: ");
    strInput = getDecimal(stdIn);
    
    if(strInput.equals("Au revoir!"))
    {
        keepGoing = false;
    }
    while(!(isDecimal(strInput)) && keepGoing)
    {
      System.out.print("\n"+strInput);
      System.out.print("\nPlease input a decimal integer or q to quit: ");
	   strInput = getDecimal(stdIn);
    }
    if(isDecimal(strInput))
    {
        System.out.print(getDecimal(stdIn));
    }
    }while(keepGoing);
   }
   
  public static boolean isDecimal(String num)
   {
      char letter;
      boolean userInput = true;
	   
      for(int i = 0; i < num.length() && userInput; i++)
      {
         letter = num.charAt(i);
         
         switch(letter)
         {
            case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
            userInput = true;
            break;
            default:
            userInput = false;
            break;
          }
	    }
      return userInput;
   }
   
    public static String getDecimal(Scanner stdIn)
   {
      String input = stdIn.nextLine();
      if(input.equalsIgnoreCase("q"))
      {
         input = "Au revoir";
      }
      else if(isDecimal(input))
      {
         input = input + " in binary is: " + toBinary(input) + "\n";
      }
      else
      {
         input = "Invalid input, try again";
      }
      return input;
   }
  
   
   public static String toBinary(String num) 
   {
     int digit = Integer.parseInt(num);
     String sum = "";
     int value = 0;
     String oddValue = "0";
     boolean even = true;
     int pow = 0;
     
     while(even)
     {
      if(Math.pow(2,pow) <= digit)
      {
       pow++;
      }
      else
      {
         even = false;
      }
     }
     if(digit%2 != 0)
     {
      value ++;
      oddValue = "1";
     }
      for(int run = pow -1; value < digit || run > 0; run--)
      {
         value += Math.pow(2, run);
         if(value <= digit)
         {
          sum += "1";
         }  
         else
         {
          value -= Math.pow(2, run);
          sum += "0";
         }
      }
         return sum + oddValue;
  }
  }
