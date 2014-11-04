/************
* Proj5.java  big 12 loan calculator
*
* Michael Bradshaw Thur.  1230
* 
* This program is designed to calculate the loan payments for big 12 midwest bank.  you will either be able to pick from a promotional 
* offer, or able to calculate the parameters of a loan based on input from the user.
* 
*
************/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Proj5 {

public static void main (String [] args) throws IOException {
Scanner keyboard = new Scanner(System.in);
DecimalFormat dfMoney = new DecimalFormat ("$#,###,###.##");
DecimalFormat dfInterest = new DecimalFormat ("#.##%");

final double promotionalLoanAmount = 200000;
final int promotionalYears = 20;
final double promotionalInterest = 0.0375;

String userID;
char menuInput;
int invalidInput; // 0 means there was a vaild input made; 1 means there was NOT a valid input made
int loanLength; // 0 means there was a vaild input made; 1 means there was NOT a valid input made
int endProgram;
double npInterestRate;
double monthlyPayment;
double totalLoanAmount;
double loanAmount;

do{
System.out.println("\n\n\n\n\n\n\n\n\n\n\nWelcome to the Big 12 Bank Midwest Loan Calculator");
System.out.println("\n\n\n\n\nPlease make a selection from the menu below:"); 
do {
	System.out.println("\n(P)romotional loan rate < " + dfMoney.format(promotionalLoanAmount) + " for " + promotionalYears + " years at " + dfInterest.format(promotionalInterest) + " >");
	System.out.println("(N)on-promotional Individual Loan");
	System.out.println("(Q)uit the Loan Calculator");
	menuInput = keyboard.nextLine().charAt(0);
	switch (menuInput){
		case 'P':
		case 'p':
			userID = userIDVerification();
			System.out.println("\nYou have chosen to take advantage of our promotional offer.\n");
			//System.out.print("Your promotional loan amount is : $" + promotionalLoanAmount + "\n");
			//System.out.print("Your promotional interest rate is : " + promotionalInterest + "\n");
			//System.out.print("Your promotional loan term is : " + promotionalYears + "\n");
			monthlyPayment = monthlyPayment (promotionalLoanAmount, promotionalInterest, promotionalYears);
			totalLoanAmount = totalPayment(monthlyPayment, promotionalYears);
			paymentDisplay(userID, promotionalLoanAmount, promotionalYears, promotionalInterest, monthlyPayment, totalLoanAmount);
			paymentTextWrite(userID, promotionalLoanAmount, promotionalYears, promotionalInterest, monthlyPayment, totalLoanAmount);
			endProgram = endScreen();
			invalidInput = 0;
			break;
		case 'N':
		case 'n':
			userID = userIDVerification();		
			System.out.println("\nYou have chosen to apply for a non-promotional individual loan.");
			npInterestRate = interestRateVerification();
			loanLength = loanLength();
			loanAmount = loanAmount();
			monthlyPayment = monthlyPayment(loanAmount, npInterestRate, loanLength);
			totalLoanAmount = totalPayment(monthlyPayment, loanLength);
			paymentDisplay(userID, loanAmount, loanLength, npInterestRate, monthlyPayment, totalLoanAmount);
			paymentTextWrite(userID, loanAmount, loanLength, npInterestRate, monthlyPayment, totalLoanAmount);
			endProgram = endScreen();
			invalidInput = 0;
			break;
		case 'Q':
		case 'q':
			System.out.println("\nThank you for using Big 12 Midwest Bank Loan Calculator.");
			invalidInput = 0;
			endProgram = 1;
			break;
		default:
			System.out.println("\nINVALID INPUT: Please select from our menu.");
			invalidInput = 1;
			endProgram = 1;
	} //closes swtitch
} while (invalidInput == 1); //closes menu execution do
} while (endProgram == 0); //closes the program loop do
} // closes main


//*****************************************************************************************************************
public static String userIDVerification () {
/* this method will determine if the user input ID is a valid one.
* perameters are not passed in, everything needed is asked in the method.
* @Return userID is a string that will be passed back to the main method for both promotional and new individual
*/
Scanner keyboard = new Scanner (System.in);

String userID;
int userIDCheck = 0; // 0 is repeat 1 is go


	System.out.println("\n\nPlese enter your Big 12 Midwest Bank User ID");
do {
	System.out.println("\n\nMake an user ID that is 4 characters long");
	userID = keyboard.nextLine();
	switch (userID.length()){
		case 4:
			int i = 0;
			for (i = 0; i < userID.length(); i++)
				if (Character.isDigit(userID.charAt(i))) 
					userIDCheck = 1;
				else if (Character.isLetter(userID.charAt(i)))
					userIDCheck = 1;
				else {
					System.out.println("Please only use letters or numbers");
					userIDCheck = 0;
					break;
				}
			break;
		default:
			System.out.println("INVALID INPUT: make a user ID 4 characters long\n");
			userIDCheck = 0;
		} //closes switch
} while (userIDCheck == 0); // closes character length do
return userID;

} // closes method
// ****************************************************************************************************************

// ****************************************************************************************************************
public static double interestRateVerification () {
/* this method is to determine if an interest rate is within the bounds set by the program
* perameters are not paseed into the method, everything needed will be asked inside the method
* @Return npinterestRate is a double that will be within the bouds set by the software and in decimal form
*/
Scanner keyboard = new Scanner (System.in);

String inputString;
String inputTemp;  // string that is made of chars from the array and about to turn into parse.
double input;

int i = 0;

System.out.println("\nWhat is the interest rate for the non-promotional individual loan?");
do {
	System.out.println("   please enter interest rate between 3.00% and 7.00% as #.##        \n");
	inputString = keyboard.nextLine();

	inputTemp = "";
		for (i = 0; i < inputString.length(); i++) {
			if (Character.isDigit(inputString.charAt(i))) {
				inputTemp += inputString.charAt(i);
			} // closes if
			else {}
		} // closes for loop

if (inputTemp.length() == 1)
	inputTemp += "00";
else if (inputTemp.length() == 2)
	inputTemp += "0";
else {}
input = Double.parseDouble(inputTemp);
input = (input)/10000;
} while (input < 0.030 || input > 0.070);

return input;
} //this closes interest rate verification method
// ****************************************************************************************************************

// ****************************************************************************************************************
public static int loanLength () {
/* this method is to determine if the length of the loan is within the bounds set 10-40
* There are not inputs passed into the method, all data needed will be called in method
* @Return loanlength is an integer in range 10-40 INCLUSIVE that is passed back to main
*/
Scanner keyboard = new Scanner (System.in);

int loanLength;
int loanLengthDo = 0;
String inputTemp;
String inputString;

System.out.println("\nWhat is the length for the non-promotional individual loan?");
do{
	System.out.println("** Please enter a length between 10 and 40 years **\n");
	inputString = keyboard.nextLine();
	int i=0;
	inputTemp = "";
		for (i = 0; i < inputString.length(); i++) {
			if (Character.isDigit(inputString.charAt(i))) {
				inputTemp += inputString.charAt(i);
			} // closes if
			else {}
		} // closes for loop
	loanLength = Integer.parseInt(inputTemp);
} while (loanLength < 10 || loanLength > 40); // closes do
return loanLength;

} //closes loan length
// ****************************************************************************************************************

// ****************************************************************************************************************
public static double loanAmount () {
/* this method is to determine if the loan amount is within the bounds set by the customer.  $75,000 - $1,000,000
* There are no inputs passed to the method, all inputs will be collected within the method.
* @Return loanAmount is an double that passes back to method that is 75000 - 1000000 EXCLUSIVE
*/
Scanner keyboard = new Scanner (System.in);

double loanAmount;
String inputTemp;
String inputString;

System.out.println("\nWhat is the loan amount being taken out for the non-promotional individual loan?");
do {
	System.out.println("        ** Please enter an amount between $75,001 and $999,999 **\n");
	inputString = keyboard.nextLine();
	int i=0;
	inputTemp = "";
		for (i = 0; i < inputString.length(); i++) {
			if (Character.isDigit(inputString.charAt(i))) {
				inputTemp += inputString.charAt(i);
			} // closes if
			else {}
		} // closes for loop
	loanAmount = Integer.parseInt(inputTemp);
} while (loanAmount < 75001 || loanAmount > 999999);

return loanAmount;

} // closes loan amount
// ****************************************************************************************************************

// ****************************************************************************************************************

public static double monthlyPayment (double principal, double interest, int length) {
/* this method is to calculate the monthly payments for a loan, but promotional and non-promotional
* @principal is the loan amount taken out, i
* @interest is the interest ratethat was given for the loan both promotional and non-promotional
* @length is the length of the loan for both the promotional and non-promotional
* @Return is the monthly payment calculated form the formula in proj5 outline
*/

DecimalFormat dfMoney = new DecimalFormat ("$#,###,###.##");

double monthlyPayment;
double months = length * 12;
double interest1 = ((interest)/12);

double a = (1 + interest1);// this is adding 1+Interest
double b = Math.pow(a, months); // raised to the N (months)
double top = interest1 * b; // whole top part
double bottom = b - 1; // while bottom part

monthlyPayment = principal * (top/bottom);
System.out.println("Your monthly payments for the individual loan is: " + dfMoney.format(monthlyPayment));
return monthlyPayment;


} // closes monthlyPayment
// ****************************************************************************************************************

// ****************************************************************************************************************
public static double totalPayment (double monthly, int length) {
/* this method is to calculate the total payments for the loan including monthly payments for promotional and non-promotional
* there are two inputs passed to the method: 
* @monthly is the monthly payments 
* @length is the length of the loan
* @return is the total amount of the loan, including interest
*/
double totalLoanAmount = (monthly * (length * 12)); 
return totalLoanAmount;

} // closes totalPayment
// ****************************************************************************************************************

// ****************************************************************************************************************
public static void paymentDisplay (String userID, double loanAmount, int length, double interestRate, double monthlyPayment, double totalLoanAmount) {
/* this method is to display the loan information to the screen for viewing.  
* this method takes in 6 parameters
* @userID: from method userID
* @loanAmount: amount of the loan before interest
* @length: length of the loan on years
* @interestRate: interest rate of the loan
* @monthlyPayment: monthly payments from 
* @totalLoanAmount: monthly payments x length
* @return: nothing returned
*/
DecimalFormat dfMoney = new DecimalFormat ("$#,###,###.00");
DecimalFormat dfInterest = new DecimalFormat("#.00%");

System.out.println("\n************************ Loan Summary ****************************");
System.out.println("                 Customer ID: " + userID);
System.out.println("                 Loan amount: " + dfMoney.format(loanAmount));
System.out.println("          Length of the loan: " + length + " years");
System.out.println("          Loan Interest Rate: " + dfInterest.format(interestRate));
System.out.println("            Monthly payments: " + dfMoney.format(monthlyPayment));
System.out.println("           Total loan amount: " + dfMoney.format(totalLoanAmount));


} // this closes payment display
// ***************************************************************************************************************

// ***************************************************************************************************************
public static void paymentTextWrite (String userID, double loanAmount, int length, double interestRate, double monthlyPayment, double totalLoanAmount) throws IOException {
/* this method is to write to a file.  
* this method takes in 6 parameters
* @userID: from method userID
* @loanAmount: amount of the loan before interest
* @length: length of the loan on years
* @interestRate: interest rate of the loan
* @monthlyPayment: monthly payments from 
* @totalLoanAmount: monthly payments x length
* @return: nothing returned
*/
DecimalFormat dfMoney = new DecimalFormat ("$#,###,###.##");
DecimalFormat dfInterest = new DecimalFormat("#.00%");

Scanner keyboard = new Scanner (System.in);
int invalidInput = 0; // 0 is continue     1 is to stop cycle
int method = 0;
do {
System.out.println("\nPlease enter the name of the file you would like to save to.");
System.out.println("      ********** Do not add a file extention **********       ");
String filename = keyboard.nextLine();
filename += ".txt";
File file = new File(filename);
	if (file.exists() == true) {
	
	Scanner inputFile = new Scanner (file);
  	do {
  		System.out.println("\nThe file exists, would you like to: ");
  		System.out.println("(A)ppend the file");
  		System.out.println("(E)rase the file and create a new one");
  		System.out.println("(R)e-enter a file name");
  		char printYN = keyboard.nextLine().charAt(0);
  		switch (printYN){
  			case 'A':
  			case 'a':
				FileWriter writer = new FileWriter(filename, true);
				writer.write("\n************************ Loan Summary ****************************");
				writer.write("\n                 Customer ID: " + userID);
				writer.write("\n                 Loan amount: " + dfMoney.format(loanAmount));
				writer.write("\n          Length of the loan: " + length + " years");
				writer.write("\n          Loan Interest Rate: " + dfInterest.format(interestRate));
				writer.write("\n            Monthly payments: " + dfMoney.format(monthlyPayment));
				writer.write("\n           Total loan amount: " + dfMoney.format(totalLoanAmount));
				writer.close();
				invalidInput = 1;
				method = 1;
				break;
  			case 'E':
  			case 'e':
				System.out.println("\nYou have chosen to rewrite the file");
				PrintWriter pw = new PrintWriter(filename);
				pw.print("\n************************ Loan Summary ****************************");
				pw.print("\n                 Customer ID: " + userID);
				pw.print("\n                 Loan amount: " + dfMoney.format(loanAmount));
				pw.print("\n          Length of the loan: " + length + " years");
				pw.print("\n          Loan Interest Rate: " + dfInterest.format(interestRate));
				pw.print("\n            Monthly payments: " + dfMoney.format(monthlyPayment));
				pw.print("\n           Total loan amount: " + dfMoney.format(totalLoanAmount));
				pw.close();
				invalidInput = 1;
				method = 1;
				break;
			case 'R':
			case 'r':
				invalidInput = 1;
				method = 0;
				break;
  			default:
  				System.out.println("\nINVALID INPUT: please enter a valid choice");
  				invalidInput = 0;
  				break;
			} // closes switch
		} while (invalidInput == 0);// closes do
	} // closes if
	else if (file.exists() == false){ 
		System.out.println("File does not exist");
		method = 0;
	} // closes else
 }while (method == 0);
} // closes method

// ***************************************************************************************************************

// ***************************************************************************************************************
public static int endScreen () {
/* this method is the end screen for the program, but it does loop back into the main if option is chosen
* nothing is passed into the method
* @Return endProgram is passed to the main
*/
Scanner keyboard = new Scanner (System.in);

int endProgram;
char endScreenMenu;

do {
System.out.println("\n\n************* Your loan has been processed ***************\n\n");
System.out.println("Would you like to process a (N)ew loan or (E)xit?");
endScreenMenu = keyboard.nextLine().charAt(0);
switch (endScreenMenu){
	case 'N':
	case 'n':
		System.out.println("\n\n\n\n\nRedirecting to welcome screen");
		endProgram = 0; // continue the program
		break;
	case 'E':
	case 'e':
		System.out.println("\n\n\n\n\nThank you for using the Big 12 Midwest Bank Loan Calculator\n\n\n\n\n\n");
		endProgram = 1; // end the program
		break;
	default:
		System.out.println("\nINVALID INPUT: please choose (N)ew loan or (E)xit\n\n\n\n\n\n\n\n\n");
		endProgram = 0;
		break;
	}//closes switch
} while (endScreenMenu != 'n' && endScreenMenu != 'N' && endScreenMenu != 'E' && endScreenMenu != 'e'); 
return endProgram;

} // this closes end screen
// ***************************************************************************************************************


} // closes class







