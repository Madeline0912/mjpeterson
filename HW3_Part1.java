/***************************
*HW3_Part1.java
*Maddy Peterson
*
*Solve a quadratic equation
****************************/
import java.util.Scanner;

public class HW3_Part1
{
   public static void main(String[] args)
   {
    Scanner stdIn = new Scanner(System.in);
    
    int a;
    int b;
    int c;
    double x1;
    double x2;
    
    System.out.println("Given that the format for the standard quadratic equation is ax^2+bx+c=0");
    System.out.print("Enter value for a: ");
    a = stdIn.nextInt();
    System.out.print("Enter value for b: ");
    b = stdIn.nextInt();
    System.out.print("Enter value for c: ");
    c = stdIn.nextInt();
    
    if (Math.sqrt(b*b-4*a*c) < 0)
    {
      System.out.println("There are no real solutions");
    }
    
    else if(Math.sqrt(b*b-4*a*c) == 0)
    {
      x1 = -b/(2*a); 
      System.out.println("The only solution is " + x1);
    }
    
    else
    {
      x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
      x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
      System.out.println("The first solution is " + x1 + " and the second solution is " + x2);
    }
    
   } //end main method  
   
} //end class HW3_Part1 
    
    
    
