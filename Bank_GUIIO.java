/**
* (description of the project)
*
* @author Michael Bradshaw
* @version version 1.0
*/ 

import java.util.*;
import java.text.*;
import java.io.*;
import javax.swing.*;

public class Bank_GUIIO {
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


	public Bank_GUIIO () {} // contstructor 


	public void welcomeScreen () { // bank welcome screen
		JOptionPane.showMessageDialog(null, "Welcome to the Big 12 Bank Midwest Loan Calculator");
	} // closes bank welcomeScreen


	public char menuScreen () { //this is the loan menu
		char input = (JOptionPane.showInputDialog("Please make a selection from the menu below:" + 
					"\n\n(P)romotional loan rate " + dfMoney.format(PROMOTIONAL_LOAN_AMOUNT) + "\n\tfor " + PROMOTIONAL_YEARS + " years at " + dfInterest.format(PROMOTIONAL_INTEREST) + 
					"\n\n(N)on-promotional Individual Loan" + 
					"\n(Q)uit the Loan Calculator").charAt(0));
		return input;
	} // closes menuScreen


	public void promotionalLoanDetails () { // this displays the details of the promotional loan
		JOptionPane.showMessageDialog(null, "\n\nYou have chosen to take advantage of our promotional offer.\n" + 
					"\nYour promotional loan amount is: " + dfMoney.format(PROMOTIONAL_LOAN_AMOUNT) + 
					"\nYour promotional interest rate is: " + dfInterest.format(PROMOTIONAL_INTEREST) + 
					"\nYour promotional loan term is: " + PROMOTIONAL_YEARS + " years.");
	} // closes promotional loan details


	public double interestRateScreen() { // this screen gets the interest rate for an unique individual loan
		double interestRate = 0;

		JOptionPane.showMessageDialog(null, "You have chosen to get an unique individual loan.");
		do {
			interestRate = (Double.parseDouble(JOptionPane.showInputDialog("Please enter the Interest rate for the loan." + 
					"\nThe interest rates range between 3.00% - 7.00%.")));
		} while ((interestRate < 3.00) && (interestRate > 7.00));
		return interestRate;
	} // closes interestRateScreen


	public int loanLengthScreen() { // gets the length of the loan in years
		int loanLength = 0;

		do {
			loanLength = (Integer.parseInt(JOptionPane.showInputDialog("Please enter the length of your unique individual loan." + 
					"\nThe loan lengths range between 10 - 40 years.")));
		} while ((loanLength < 10) && (loanLength > 40));
		return loanLength;
	} // closes the loanLengthScreen


	public double loanAmountScreen () { // get the loan amount 
		double loanAmount = 0;

		do{
			loanAmount = (Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount for the loan." + 
					"\nWe are able to give loans between $75,001 and $999,999.")));
		} while ((loanAmount < 75000) && (loanAmount > 1000000));
		return loanAmount;
	} // closes loanAmountScreen


	public void quitScreen() { // this is the quit screen
		JOptionPane.showMessageDialog(null, "Now quitting the Calculator." + 
					"\nThank you for choosing Big 12 Midwest Bank.");
	}  // closes the quit screen


	public String filePathScreen () { // opens get file path
		filepath = (JOptionPane.showInputDialog("Please enter the file name for the output file." + 
					"\nInclude the file extenstion."));
		return filepath;
	} // closes the get file path


	public char fileWriteMenu () { // gets the menu to write a file
		char printYN;
		printYN = (JOptionPane.showInputDialog("The file exists, would you like to: " + 
  					"\n\n\t(A)ppend the file" + 
  					"\n\t(E)rase the file and create a new one" + 
  					"\n\t(R)e-enter a file name").charAt(0));
  		return printYN;
	} // closes the menu 


	public void fileWriteAppend (Mortgage mortgage) throws IOException { // appends the file that already exists
		FileWriter writer = new FileWriter(filepath, true);
		JOptionPane.showMessageDialog(null, mortgage.toString());
		writer.write(mortgage.toString());
		writer.close();
	} // closes the append section


	public void printWriteErase (Mortgage mortgage) throws IOException { // erases the file and places a new 
		PrintWriter pw = new PrintWriter(filepath);
		JOptionPane.showMessageDialog(null, mortgage.toString());
		pw.print(mortgage.toString());
		pw.close();
	} // closes the erase


	public void invalidInput () { // invalid input screen
		JOptionPane.showMessageDialog(null, "INVALID INPUT: please enter a valid choice");
	} // closes invalidInput


	public int continueProgramScreen () { // asks if the person wants to reprocess a loan
		int contProg;
		char temp = (JOptionPane.showInputDialog("Would you like to process another loan? \n(Y)es or (N)0").charAt(0));
		if (temp == 'Y' || temp == 'y'){
			contProg = 0;
		} // closes if
		else {
			contProg = 1;
		}
		return contProg;
	} // closes screen


	public char graphicsPreference () {
		char graphics;
		graphics = (JOptionPane.showInputDialog("Would you like: + \n(G)UI or \n (C)onsole?").charAt(0));
		return graphics;
	} // closes graphicsPreference

} // closes class


