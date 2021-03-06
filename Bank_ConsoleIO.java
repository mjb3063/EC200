/**
* (description of the project)
*
* @author Michael Bradshaw
* @version version 1.0
*/ 

import java.util.*;
import java.text.*;
import java.io.*;

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
String filepath = "";
File file = new File(filepath);

DecimalFormat dfMoney = new DecimalFormat ("$#,###,###.00");
DecimalFormat dfInterest = new DecimalFormat ("#.##%");

final double PROMOTIONAL_LOAN_AMOUNT = 100000;
final int PROMOTIONAL_YEARS = 15;
final double PROMOTIONAL_INTEREST = 0.055;


	public Bank_ConsoleIO () {} // contstructor 


	public void welcomeScreen () { // bank welcome screen
		System.out.println("\n\n\n\n\n\n\n\nWelcome to the Big 12 Bank Midwest Loan Calculator");
	} // closes bank welcomeScreen


	public char menuScreen () { //this is the loan menu
		System.out.println("\n\n\n\n\n\n\n\nPlease make a selection from the menu below:");
		System.out.println("\n(P)romotional loan rate < " + dfMoney.format(PROMOTIONAL_LOAN_AMOUNT) + " for " + PROMOTIONAL_YEARS + " years at " + dfInterest.format(PROMOTIONAL_INTEREST) + " >");
		System.out.println("(N)on-promotional Individual Loan");
		System.out.println("(Q)uit the Loan Calculator");
		char input = keyboard.nextLine().charAt(0);
		return input;
	} // closes menuScreen


	public void promotionalLoanDetails () { // this displays the details of the promotional loan
		System.out.println("\n\nYou have chosen to take advantage of our promotional offer.\n");
		System.out.print("Your promotional loan amount is: " + dfMoney.format(PROMOTIONAL_LOAN_AMOUNT) + "\n");
		System.out.print("Your promotional interest rate is: " + dfInterest.format(PROMOTIONAL_INTEREST) + "\n");
		System.out.print("Your promotional loan term is: " + PROMOTIONAL_YEARS + " years.\n");
	} // closes promotional loan details


	public double interestRateScreen() { // this screen gets the interest rate for an unique individual loan
		double interestRate = 0;

		System.out.println("\n\nYou have chosen to get an unique individual loan.");
		do {
			System.out.println("\nPlease enter the Interest rate for the loan.");
			System.out.println("The interest rates range between 3.00% - 7.00%.\n");
			interestRate = Double.parseDouble(keyboard.nextLine());
			System.out.println("");
		} while ((interestRate < 3.00) && (interestRate > 7.00));
		return interestRate;
	} // closes interestRateScreen


	public int loanLengthScreen() { // gets the length of the loan in years
		int loanLength = 0;

		do {
			System.out.println("\n\nPlease enter the length of your unique individual loan.");
			System.out.println("The loan lengths range between 10 - 40 years.\n");
			loanLength = Integer.parseInt(keyboard.nextLine());
		} while ((loanLength < 10) && (loanLength > 40));
		return loanLength;
	} // closes the loanLengthScreen


	public double loanAmountScreen () { // get the loan amount 
		double loanAmount = 0;

		do{
			System.out.println("\n\nPlease enter the amount for the loan.");
			System.out.println("We are able to give loans between $75,001 and $999,999.\n");
			loanAmount = Integer.parseInt(keyboard.nextLine());
		} while ((loanAmount < 75000) && (loanAmount > 1000000));
		return loanAmount;
	} // closes loanAmountScreen


	public void quitScreen() { // this is the quit screen
		System.out.println("\n\nNow quitting the Calculator.");
		System.out.println("Thank you for choosing Big 12 Midwest Bank.\n");
	}  // closes the quit screen


	public String filePathScreen () { // opens get file path
		System.out.println("\n\nPlease enter the file name for the output file.");
		System.out.println("Include the file extenstion.");
		return filepath = keyboard.nextLine();
	} // closes the get file path


	public char fileWriteMenu () { // gets the menu to write a file
		char printYN;
		System.out.println("\n\nThe file exists, would you like to: ");
  		System.out.println("(A)ppend the file");
  		System.out.println("(E)rase the file and create a new one");
  		System.out.println("(R)e-enter a file name");
  		return printYN = keyboard.nextLine().charAt(0);
	} // closes the menu 


	public void fileWriteAppend (Mortgage mortgage) throws IOException { // appends the file that already exists
		FileWriter writer = new FileWriter(filepath, true);
		System.out.println(mortgage.toString());
		writer.write(mortgage.toString());
		writer.close();
	} // closes the append section


	public void printWriteErase (Mortgage mortgage) throws IOException { // erases the file and places a new 
		PrintWriter pw = new PrintWriter(filepath);
		System.out.println(mortgage.toString());
		pw.print(mortgage.toString());
		pw.close();
	} // closes the erase


	public void invalidInput () { // invalid input screen
		System.out.println("\n\nINVALID INPUT: please enter a valid choice");
	} // closes invalidInput


	public int continueProgramScreen () { // asks if the person wants to reprocess a loan
		int contProg;
		System.out.println("\n\nWould you like to process another loan? (Y)es or (N)0");
		char temp = keyboard.nextLine().charAt(0);
		if (temp == 'Y' || temp == 'y'){
			contProg = 0;
		} // closes if
		else {
			contProg = 1;
		}
		return contProg;
	} // closes screen



} // closes class


