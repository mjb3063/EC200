/**
 * Mortgage.java (MODEL)
 * Used to define a Mortgage object consisting of an annual interest rate,
 * the number of years for the loan and the loan amount. Contains methods to
 * calculate the monthly loan payment and the total amount paid.
*/
import java.text.DecimalFormat;

public class Mortgage {

  private double annualInterestRate;
  private int numOfYears;
  private double loanAmount;
  private double monthlyPayment;
  private double totalPayment;

 
  public Mortgage(){ // Default constructor - sets a 100,000 loan at 5.5% for 15 years Used for Advertised Promotion
   this (5.5, 15, 100000);			// calls 3-arg constructor below
  } // end Mortgage() constructor

  
  public Mortgage(double newInterestRate, int newNumOfYears,double newLoanAmount) { // Construct a mortgage with specified annual interest rate, number of years and loan amount
    annualInterestRate = newInterestRate;
    numOfYears = newNumOfYears;
    loanAmount = newLoanAmount;
  } // end 3-argument constructor

  public void setInterestRate (double interestRate) {
    annualInterestRate = interestRate;
  }

  public void setLoanAmount (double amount) {
    loanAmount = amount;
  }

  public void setLoanLength (int length) {
    numOfYears= length;
  }


// ------------------ Monthly Payment ---------------------
  public double getMonthlyPayment() { // returns the value for the private data property monthlyPayment currently not used...
    return 	monthlyPayment;
  } // end getMonthlyPayment

  
  public void setMonthlyPayment() { // Calculate and set the monthly payment for the loan
    double monthlyInterestRate = annualInterestRate/1200;
    monthlyPayment = loanAmount*monthlyInterestRate/(1 - (Math.pow(1/(1 + monthlyInterestRate), numOfYears*12)));
  } // end setMonthlyPayment


// ------------------ Total Payment --------------------- 
  public double getTotalPayment() { // returns the value for the private data property totalPayment currently not used...
    return 	totalPayment;
  } // end getMonthlyPayment

  
  public void setTotalPayment() { // Calculate and set the total amount to be paid on the loan
    totalPayment = monthlyPayment * numOfYears * 12;
  } // end totalPayment


// ------------------ Used to Display Output ---------------------
  public String toString() { 
    DecimalFormat df = new DecimalFormat("$#,###,###.00");
    DecimalFormat dfInterest = new DecimalFormat ("#.##");
    String s = "***********************************REPORT***********************************" + 
    "\n\nThe loan amount is: " + df.format(loanAmount) + "\nThe interestRate is: " + dfInterest.format(annualInterestRate) + "%\nThe monthly payment is " + df.format(monthlyPayment) + "\nThe total payment is " + df.format(totalPayment) + "\n\n\n\n"; 
    return s;
  } // end toString

} // end class