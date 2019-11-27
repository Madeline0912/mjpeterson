/*Maddy Peterson
 *BankAccout.Java
 * 
 *This is a class that represents a generic bank account.
 */
 
public class BankAccount {

  /** Data members: Account number as integer
  Customer name as String and the balance as double. */
  private int accountNumber;
  private String customerName;
  private double balance;
  
  
  /**
   * Constructor that sets Account number, customer's name and balance.
   * @param initialAmount The starting balance
   */
  public BankAccount(int accNum, String name, double initialAmount) 
  {
     this.accountNumber = accNum;
     this.customerName = name;
     this.balance = initialAmount;
   }
      
  
  /**
   * Constructor that sets Account number, customer's name and balance to zero.
   * 
   */
  public BankAccount(int AccNum, String name) 
  {
     this.accountNumber = 0;
     this.customerName = "";
     this.balance = 0;
  }

           
      
 /**
   * Mutator method to set the balance.
   * 
   */
  public void setBalance(double amount) 
  {
     this.balance = amount;
  }


/**
   * Mutator method to set the name.
   * 
   */
  public void setName(String name) 
  {
     this.customerName = name;
  }


/**
   * Mutator method to set the Account number.

   */
  public void setacctNum(int acctNum) 
  {
     this.accountNumber = acctNum;
  }
  
  
   /**
   * Accessor for the amount in the account.
   * @return The current balance
   */
  public double getBalance() 
  {
     return this.balance;
  }



  /**
   * Method to add money to the account.
   * @param amount What to add
   */
  public void deposit(double amount) 
  {
     this.balance += amount;
  }

  /**
   * Method to take money out.
   * @param amount What to remove
   * If the amount is greater than the balance then returns false 
   * otherwise it returns true and remove the money from the account
   */
  public boolean withdrawal(double amount) 
  {
      if(amount > this.balance)
      {
         return false;
      }
      else
      {
         this.balance -= amount;
         return true;
      }
  }


  /**
   * Transfers money from this account to another.
   * @param other The other account
   * @param amount The amount to transfer
   * If the amount is greater than balance then returns false 
   * otherwise it returns true and transfer the amount from this account to the other
   */
  public boolean transfer(BankAccount other, double amount) 
  {
     if(this.balance < amount)
     {
        return false;
     }
     else
     {
        this.balance -= amount;
        other.balance += amount;
        return true;
     }
  }

  /**
   * Method to print this account's info.Name, account number and the balance
   */
  public void report() 
  {
     System.out.print("Name : " + this.customerName + "\nAccount Number: " + this.accountNumber + "\nBalance: " + this.balance);
  }
}