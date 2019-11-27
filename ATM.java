/*Maddy Peterson 
 *ATM.java
 * 
 * Purpose: Provide bank users with an automated way of managing their bank account.
 */

import java.util.Scanner;

public class ATM
{
	/* main
	 * 
	 * This is where execution starts.
	 */
	public static void main(String args[])
	{
      Scanner in = new Scanner(System.in);
      int input;
      boolean keepGoing = true;
      boolean valid = true;
      double amount;
      String name;
      double balance;
      int acctNum;
		//Create the bank account by using one of the constructor methods of the BankAccount class that you will be doing some ATM opereation
      BankAccount one;
  
		// print out a welcome message
		System.out.println("Welcome!");
      System.out.print("\nEnter account name without a space, account number, and balance separated by a space: ");
      name = in.next();
      acctNum = in.nextInt();
      balance = in.nextDouble();
      one = new BankAccount(acctNum, name, balance);

	  // keep session going until user says to exit (Loop)
	  while(keepGoing)
     {		    
     // first give user options, then ask what user wants to do
		   //"Check Balance: 0"
		   //"Deposit: 1"
			//"Withdrawal: 2"
         //"Transfer: 3"
			//"Exit: 4"
			//"What would you like to do next? Enter a number:
         //Get the option number from the user and validate your input with a loop
         System.out.print("\nCheck Balance: 0 \nDeposit: 1 \nWithdrawal: 2 \nTransfer: 3 \nExit: 4 \nWhat would you like to do next? Enter a number: ");
         input = in.nextInt();
         switch(input)
         {
            case 0: case 1: case 2: case 3: case 4:
            valid = true;
            break;
            default:
            valid = false;
            break;
         }
         while(!(valid))
         {
            System.out.print("\nInvalid input. \n Check Balance: 0 \nDeposit: 1 \nWithdrawal: 2 \nTransfer: 3 \nExit: 4 \nWhat would you like to do next? Enter a number: ");
         }	
            
            		
			//option == 0
			    // get balance from bank account and print out
			if(input == 0)
         {
            System.out.print("\nYour balance is: " + one.getBalance() + "\n");
         }	
            
         //option == 1
				// for a deposit, ask how much to the user and get the input				
				// make the deposit
			else if(input == 1)
         {
            System.out.print("\nHow much would you like to deposit? ");
            amount = in.nextDouble();
            one.deposit(amount);
         }	
            
         //option == 2
			   // for a withdrawal, ask how much to the user and get the input			
				// make the withdrawal, but check if overdrawn				
		   else if(input == 2)
         {
            System.out.print("\nHow much would you like to withdraw? ");
            amount = in.nextDouble();
            if(one.withdrawal(amount))
            {
               one.withdrawal(amount);
            }
            else
            {
               System.out.print("\nSorry, you cannot withdraw " + amount + " you only have " + one.getBalance() + " in your account.\n");
            }
         }		
        
            
          //option == 3
            //Ask and Get the account number and the customer name from the user and create an account with initial balance $0
				// for a transfer, ask how much to the user and get the input
				// make the transfer, but check if overdrawn		
				// if overdrawn, report to user
                                //If not transfer the amount
          else if(input == 3)
          {
              System.out.print("\nEnter account name without a space and number separated by a space: ");
              name = in.next();
              acctNum = in.nextInt();
              BankAccount account = new BankAccount(acctNum, name, 0);
              System.out.print("\nHow much would you like to transfer? ");
              amount = in.nextDouble();
              if(one.transfer(account, amount))
              {
                 one.transfer(account, amount);
              }
              else
              {
                 System.out.print("\nSorry, you cannot transfer " + amount + "\n");
              }
          }  
            
         //option == 4)
            //Exit 
			else if(input == 4)
         {
            keepGoing = false;
            System.out.print("\nCome again!");
         }
       }	
  	} // end of method main
} // end of class ATM
