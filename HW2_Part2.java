/************************************************
*HW2_Part2.java
*Maddy Peterson
*
*Calculates and outputs a baseball pitcher's ERA
***************************************************/
import java.util.Scanner;

public class HW2_Part2
{
   public static void main(String[] args)
   { 
    Scanner stdIn = new Scanner(System.in);
    
    int earnedRuns = ER();
    int inningsPlayed = IP();
    
    String pitcherFirst = "Pitcher's first name: " + first();
    String pitcherLast = "Pitcher's last name: " + last();
    String pitcherER = "Number of earned runs: " + earnedRuns; 
    String pitcherIP = "Number of innings played: " + inningsPlayed;
    String pitcherERA = "Pitcher's ERA: " + ERA(earnedRuns, inningsPlayed);
    
    one(pitcherFirst);
    one(pitcherLast);
    one(pitcherER);
    one(pitcherIP);
    one(pitcherERA);
   } //end main method
   
   public static void one(String comment)
   {
    System.out.println(comment);
    return;
   } //end one method
   
   public static int ER()
   {
    Scanner stdIn = new Scanner(System.in);
    System.out.print("Enter pitcher's number of earned runs: ");
    int ER = stdIn.nextInt();  
    return ER;
   } //end ER method
   
   public static int IP()
   {
    Scanner stdIn = new Scanner(System.in);
    System.out.print("Enter pitcher's number of number innings pitched: "); 
    int IP = stdIn.nextInt(); 
    return IP;
   } //end IP method
   
   public static String first()
   {
    Scanner stdIn = new Scanner(System.in);
    System.out.print("Enter first name of the pitcher: ");
    String first = stdIn.nextLine();
    return first;
   } //end first method
   
    public static String last()
   {
    Scanner stdIn = new Scanner(System.in);
    System.out.print("Enter last name of the pitcher: ");
    String last = stdIn.nextLine();
    return last;
   } //end last method
   
   public static double ERA(int ER, int IP)
   {
    double ERA = (double) ER*9/(double) IP; 
    return ERA;
   } //end ERA method
   
} //end class HW2_Part2 