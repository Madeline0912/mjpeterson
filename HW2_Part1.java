/*************************************************
*HW2_Part1.java
*Maddy Peterson
*
* Calculates and outputs a baseball pitcher's ERA
***************************************************/
import java.util.Scanner;

public class HW2_Part1
{
   public static void main(String[] args)
   {
    Scanner stdIn = new Scanner(System.in);
   
    String first;
    String last;
    int ER; //earned runs
    int IP; //innings pitched
    double ERA; //earned run average
    
    System.out.print("Enter first and last name of the pitcher seperated by a space: ");
    first = stdIn.next();
    last = stdIn.next();
    
    System.out.print("Enter pitcher's number of earned runs: ");
    ER = stdIn.nextInt();
    
    System.out.print("Enter pitcher's number of innings pitched: ");
    IP = stdIn.nextInt(); 
    
    ERA = (double) ER*9.0/ (double) IP;
    System.out.print("Pitcher's earned runs average: " + ERA);
   } //end main method
} //end class HW2_Part1
    
  
