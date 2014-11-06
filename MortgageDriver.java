/**
* (description of the project)
*
* @author Michael Bradshaw
* @version version 1.0
*/ 

import java.util.*;



public class MortgageDriver {
	public static void main (String [] args) {

	Bank_ConsoleIO io = new Bank_ConsoleIO ();
	Mortgage mortgage = new Mortgage ();

	io.welcomeScreen();
	char menuinput = io.menuScreen();
	switch (menuInput){
		case 'P':
		case 'p':
			io.promotionalLoanDetails();
			monthlyPayment = monthlyPayment (promotionalLoanAmount, promotionalInterest, promotionalYears); // mortgage obj 
			totalLoanAmount = totalPayment(monthlyPayment, promotionalYears);
			paymentDisplay(userID, promotionalLoanAmount, promotionalYears, promotionalInterest, monthlyPayment, totalLoanAmount);
			paymentTextWrite(userID, promotionalLoanAmount, promotionalYears, promotionalInterest, monthlyPayment, totalLoanAmount);
			endProgram = endScreen();
			break;
		case 'N':
		case 'n':
/*
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
*/



	} // closes main
} // closes Mortgage driver




