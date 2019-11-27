/***************************
*HW1_Part2
*Maddy Peterson
*
*Calculates volume of a box
****************************/
public class HW1_Part2
{
   public static void main(String[] args)
   {
    double length;
    double width;
    double height; 
    String units;
    
    length = 5.0;
    width = 4.0;
    height = 6.0;
    units = "inches";
    double volume = length * width * height;
    
    System.out.println("Given a length of " + length + " " + units + '\n' + "a width of " + width + " " + units + '\n' + "and a height of " + height + " " + units + '\n');
    System.out.println("The box's volume is: " + volume + " " + units + " cubed");
   }
}//end class HW1_part2