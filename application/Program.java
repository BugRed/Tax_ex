package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> listPayer = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data");
			System.out.print("Individual or Company (i/c)?");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();

			if (resp == 'i') {

				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();

				listPayer.add(new Individual(name, anualIncome, healthExpenditures));

			} else if (resp == 'c') {

				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();

				listPayer.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID: ");

		for (TaxPayer payer : listPayer) {

			if (payer instanceof Individual) {

				System.out.println("Individual: ");

			} else if (payer instanceof Company) {

				System.out.println("Company: ");
			}
			System.out.println(payer.getName() + ": $" + String.format("%.2f", payer.tax()));
		}
		System.out.println();
		double sum = 0.0;
		for (TaxPayer payer : listPayer) {
			sum += payer.tax();
		}

		System.out.print("TOTAL TAXES: $" + String.format("%.2f%n", sum));

		sc.close();
	}

}
