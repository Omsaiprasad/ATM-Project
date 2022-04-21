package com.sbi;

import java.util.Scanner;

public class BankAccount {
	// Creating the Attributes
	int customerid;
	String customername;
	int balance;
	int previousTransaction;

	// Creating the Constructor
	BankAccount(String cname, int cid) {

		customername = cname;
		customerid = cid;
	}

	// Creating Deposit Method
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	// Creating Withdraw Method
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}

	// Getting the Previous Transaction
	void getpreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited:" + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn:" + Math.abs(previousTransaction));
		} else
			System.out.println("No Transaction Occured");
	}

	// Creating the Options on the Display Method
	void showMenu() {

		char option = '\0';
		// Creating the Scanner Object
		Scanner sc = new Scanner(System.in);

		System.out.println("Hi, Welcome " + customername + "   Your ID is:" + customerid);
		System.out.println("A. Check Balance");
		System.out.println("B. Withdraw");
		System.out.println("C. Deposit");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		System.out.println();

		// Creating the Do while Loop
		do {
			System.out.print("Enter an Option:");
			option = sc.next().charAt(0);
			System.out.println("\n");

			switch (option) {
			case 'A':
				System.out.print("Balance=" + balance);
				System.out.println("\n");
				break;

			case 'B':
				System.out.print("Enter an Amount to withdraw:");
				int amount = sc.nextInt();
				withdraw(amount);
				System.out.println("The Amount withdrawn is:" + amount);
				break;

			case 'C':
				System.out.print("Enter an Amount to deposit:");
				int amount2 = sc.nextInt();
				deposit(amount2);
				System.out.println("The Amount Deposited is:" + amount2);
				break;

			case 'D':
				getpreviousTransaction();
				System.out.println("\n");
				break;

			case 'E':
				break;

			default:
				System.out.println("Invaild Option Please Try Again");
				break;
			}

		} while (option != 'E');
		System.out.println("Thank you for Using Our Services...Bye!!!");

		// Closing the Scanner Object
		sc.close();
	}
}
