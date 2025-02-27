package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.BusinessAccount;
import entities.Circle;
import entities.Company;
import entities.ImportedProduct;
import entities.Individual;
import entities.Product;
import entities.Rectangle;
import entities.SavingsAccount;
import entities.Shape;
import entities.TaxPayer;
import entities.UsedProduct;
import entities.enums.Color;

public class Program {
public static void main(String[] args) {

	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);

	List<TaxPayer> list = new ArrayList<>();


	System.out.println("Enter the number of payers: ");
	int n = sc.nextInt();

	for (int i = 1; i <= n; i++) {
		System.out.println("Tax payer #" + i + "data: ");
		System.out.print("Individual or company (i/c)? ");
		char type = sc.next().charAt(0);
		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Anual income: ");
		double income = sc.nextDouble();
		if (type == 'i') {
			System.out.print("Health expenditures: ");
			double healthExpenditures = sc.nextDouble();
			list.add(new Individual(name, income, healthExpenditures));
		}
		else {
			System.out.print("number of employee: ");
			int numberOfEmployees = sc.nextInt();
			list.add(new Company(name, income, numberOfEmployees));
		}

	}
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXED PAID:");
		for(TaxPayer tp : list) {
			double tax = tp.tax();
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
		}

		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

	sc.close();

	}
		
}
