/**
* (description of the project)
*
* @author Michael Bradshaw
* @version version 1.0
*/ 

import java.util.*;



public class MortgageDriver {
	public static void main (Strings[] args) {

menuInput = keyboard.nextLine().charAt(0); // this comes from IO
	switch (menuInput){
		case 'P':
		case 'p':
	//IO	System.out.println("\nYou have chosen to take advantage of our promotional offer.\n");
	//IO	//System.out.print("Your promotional loan amount is : $" + promotionalLoanAmount + "\n");
	//IO	//System.out.print("Your promotional interest rate is : " + promotionalInterest + "\n");
	//IO	//System.out.print("Your promotional loan term is : " + promotionalYears + "\n");
	//MO	monthlyPayment = monthlyPayment (promotionalLoanAmount, promotionalInterest, promotionalYears); // mortgage obj 
	//MO	totalLoanAmount = totalPayment(monthlyPayment, promotionalYears);
	//IO	paymentDisplay(userID, promotionalLoanAmount, promotionalYears, promotionalInterest, monthlyPayment, totalLoanAmount);
	//IO	paymentTextWrite(userID, promotionalLoanAmount, promotionalYears, promotionalInterest, monthlyPayment, totalLoanAmount);
	//IO	endProgram = endScreen();
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




	} // closes main
} // closes Controler




