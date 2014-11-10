/**
* (description of the project)
*
* @author Michael Bradshaw
* @version version 1.0
*/ 

import java.util.*;
import java.io.*;


public class MortgageDriver {
	public static void main (String [] args) throws IOException {

	Scanner keyboard = new Scanner (System.in);

//*******************
	int invalidInput = 0; // 0 means continue - 1 means loop
	int endProgram = 0; // 0 means contimue - 1 means end the program
	double interestRate;
	int loanLength;
	double loanAmount;	
	int validinput = 0;
	char contProg;
//*******************
		System.out.println("Would you like to use: \n(G)UI or \n(C)onsole?");
		char graphics = keyboard.nextLine().charAt(0);

		if (graphics == 'G' || graphics == 'g') {
		Bank_GUIIO io = new Bank_GUIIO();
		Mortgage mortgage = new Mortgage();


		io.welcomeScreen();
		do {
			char menuInput = io.menuScreen();
			do {
				switch (menuInput) {
					case 'P':
					case 'p':
						io.promotionalLoanDetails(); // pull promotional loan details
						mortgage.setMonthlyPayment(); // sets the monthly payment for the mortgage
						mortgage.setTotalPayment(); // sets the total payments fo the mortgage
						invalidInput = 0;
						break;
					case 'N':
					case 'n':
						mortgage.setInterestRate(io.interestRateScreen()) ; // gets the interest rate
						mortgage.setLoanLength(io.loanLengthScreen()); // gets the loan length
						mortgage.setLoanAmount(io.loanAmountScreen()); // gets the loan amount
						mortgage.setMonthlyPayment(); // sets the monthly payment for the mortgage
						mortgage.setTotalPayment(); // sets the total payments fo the mortgage
						invalidInput = 0;
						break;
					case 'Q':
					case 'q':
						invalidInput = 0;
						endProgram = 1;
						break;
					default:
						io.invalidInput();
						invalidInput = 1;
				} // closes swtitch
			} while (invalidInput == 1); //closes menu execution do
			
			if (endProgram != 1) {
				String filePath = io.filePathScreen();
				do {
					char printYN = io.fileWriteMenu();
						switch (printYN) {
							case 'A':
  							case 'a':
  								io.fileWriteAppend(mortgage);
  								validinput = 1;
								break;
  							case 'E':
  							case 'e':
								io.printWriteErase(mortgage);
								validinput = 1;
								break;
							case 'R':
							case 'r':
								validinput = 0;
								break;
							default:
								io.invalidInput();
								validinput = 0;
  						} // closes switch
  				} while (validinput == 0); //
  			} // closes the file if
  			if (endProgram != 1){
  				endProgram = io.continueProgramScreen();
  			} // closes the end program if
  		} while (endProgram == 0);
  		io.quitScreen();
  		} //closes graphics if
//*******************************************************************************
  		else {

		Bank_ConsoleIO io = new Bank_ConsoleIO();
		Mortgage mortgage = new Mortgage();


		io.welcomeScreen();
		do {
			char menuInput = io.menuScreen();
			do {
				switch (menuInput) {
					case 'P':
					case 'p':
						io.promotionalLoanDetails(); // pull promotional loan details
						mortgage.setMonthlyPayment(); // sets the monthly payment for the mortgage
						mortgage.setTotalPayment(); // sets the total payments fo the mortgage
						invalidInput = 0;
						break;
					case 'N':
					case 'n':
						mortgage.setInterestRate(io.interestRateScreen()) ; // gets the interest rate
						mortgage.setLoanLength(io.loanLengthScreen()); // gets the loan length
						mortgage.setLoanAmount(io.loanAmountScreen()); // gets the loan amount
						mortgage.setMonthlyPayment(); // sets the monthly payment for the mortgage
						mortgage.setTotalPayment(); // sets the total payments fo the mortgage
						invalidInput = 0;
						break;
					case 'Q':
					case 'q':
						invalidInput = 0;
						endProgram = 1;
						break;
					default:
						io.invalidInput();
						invalidInput = 1;
				} // closes swtitch
			} while (invalidInput == 1); //closes menu execution do
			
			if (endProgram != 1) {
				String filePath = io.filePathScreen();
				do {
					char printYN = io.fileWriteMenu();
						switch (printYN) {
							case 'A':
  							case 'a':
  								io.fileWriteAppend(mortgage);
  								validinput = 1;
								break;
  							case 'E':
  							case 'e':
								io.printWriteErase(mortgage);
								validinput = 1;
								break;
							case 'R':
							case 'r':
								validinput = 0;
								break;
							default:
								io.invalidInput();
								validinput = 0;
  						} // closes switch
  				} while (validinput == 0); //
  			} // closes the file if
  			if (endProgram != 1){
  				endProgram = io.continueProgramScreen();
  			} // closes the end program if
  		} while (endProgram == 0);
  		io.quitScreen();
  		} //closes graphics if


	} // closes main
} // closes Mortgage driver




