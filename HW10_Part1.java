/*****************************************************
*HW10_Part1.java
*Maddy Peterson
*
*Sorts an array of integers using insertion sort method
*******************************************************/
import java.util.Arrays;

public class HW10_Part1
{
   public static void main(String[] args)
   { 
      //create array using random ints
       int a = 0;
       int arr[] = new int[100];
       for(int i = 0; i < 100; i++)
       {
         a = (int) (Math.random() *100)+1;
         while(contains(arr, a))
         {
            a = (int) (Math.random() *100)+1;
         }
         arr[i] = a;
       }
       
       System.out.println("Original Array: " + Arrays.toString(arr));
      
       insertionSortRecursive(arr, arr.length);
         
       System.out.println("Sorted Array: " + Arrays.toString(arr));
   } //end main method 
   
   public static boolean contains(int[] arr, int a)
   {
      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i] == a)
        {
           return true;
        } 
      }
      return false;
   }
   
   public static void insertionSortRecursive(int[] arr, int n)
   {
        if (n <= 1)
            return;

        insertionSortRecursive(arr, n-1);
      
        int end = arr[n-1];
        int j = n-2;
      
        while (j >= 0 && arr[j] > end)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = end;
   }
} //end class HW10_Part1 