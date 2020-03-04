package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int n = scan.nextInt();
		scan.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println("Employee " + i + ":");
			System.out.print("Id: ");
			int id = scan.nextInt();
			scan.nextLine();
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Salary: ");
			double salary = scan.nextDouble();
			scan.nextLine();
			System.out.println();
			list.add(new Employee(id, name, salary));
		}
		System.out.println();
		System.out.print("Enter the employee id that will have a salary increase: ");
		int id = scan.nextInt();
		scan.nextLine();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentege = scan.nextDouble();
			scan.nextLine();
			emp.increaseSalary(percentege);
		}
		System.out.println();
		System.out.println("List of employees: ");
		for (Employee obj : list) {
			System.out.println(obj);
		}
		scan.close();
	}

}
