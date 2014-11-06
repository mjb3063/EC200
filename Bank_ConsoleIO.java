/**
* (description of the project)
*
* @author Michael Bradshaw
* @version version 1.0
*/ 

import java.util.*;
import java.text.*;

public class Bank_ConsoleIO {
/**
* (description of the method)
*
* @param (describe first parameter)
* @param (describe second parameter)
* (list all parameters, one per line)
* @return (describe what is being returned)
*/ 	
Scanner keyboard = new Scanner (System.in);
DecimalFormat dfMoney = new DecimalFormat ("$#,###,###.##");
DecimalFormat dfInterest = new DecimalFormat ("#.##%");

final double promotionalLoanAmount = 100000;
final int promotionalYears = 10;
final double promotionalInterest = 0.055;

	public Bank_ConsoleIO () {} // contstructor 

	public void welcomeScreen () { // bank welcome screen
		System.out.println("\n\n\n\n\n\n\n\n\n\n\nWelcome to the Big 12 Bank Midwest Loan Calculator");
	} // closes bank welcomeScreen

	public char menuScreen () { //this is the loan menu
		System.out.println("\n\n\n\n\nPlease make a selection from the menu below:");
		System.out.println("\n(P)romotional loan rate < " + dfMoney.format(promotionalLoanAmount) + " for " + promotionalYears + " years at " + dfInterest.format(promotionalInterest) + " >");
		System.out.println("(N)on-promotional Individual Loan");
		System.out.println("(Q)uit the Loan Calculator");
		char input = keyboard.nextLine().charAt(0);
		return input;
	} // closes menuScreen

	public void promotionalLoanDetails () { // this displays the details of the promotional loan
		System.out.println("\nYou have chosen to take advantage of our promotional offer.\n");
		System.out.print("Your promotional loan amount is : $" + promotionalLoanAmount + "\n");
		System.out.print("Your promotional interest rate is : " + promotionalInterest + "\n");
		System.out.print("Your promotional loan term is : " + promotionalYears + "\n");
	} // closes promotional loan details



} // closes class


