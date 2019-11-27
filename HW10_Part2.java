/**********************************************************************************
*HW10_Part2.java
*Maddy Peterson
*
*Print all possible strings of length k that can be formed by a given set of letters
************************************************************************************/

public class HW10_Part2
{
   public static void main(String[] args)
   { 
      System.out.println("First Test"); 
      char[] setA = {'p', 'q'}; 
      int k = 3; 
      printAllKLength(setA, k); 
      
      System.out.println("\nSecond Test"); 
      char[] setB = {'c', 'o', 'd', 'e'}; 
      k = 1; 
      printAllKLength(setB, k);  
   } //end main method 
   
   static void printAllKLength(char[] set, int k) 
   { 
      int n = set.length;  
      printAllKLengthRec(set, "", n, k); 
   } 
   
   static void printAllKLengthRec(char[] set, String prefix, int n, int k) 
   { 
      if (k == 0)  
      { 
          System.out.println(prefix); 
          return; 
      } 

      for (int i = 0; i < n; ++i) 
      {  
          String newPrefix = prefix + set[i];  
           
          printAllKLengthRec(set, newPrefix, n, k - 1);  
      }
   }   
} //end class HW10_Part2 