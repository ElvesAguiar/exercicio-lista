package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1)+":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			while(hasId(list,id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			list.add(new Employee(id, name, salary));
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary incresse  : ");
		int id = sc.nextInt();

		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp==null) {
			System.out.println("This id does not exist!");
		}else {
		System.out.print("Enter the percentage: ");
		double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		sc.nextLine();
		for (Employee obj : list) {

			System.out.println(obj);
		}

		sc.close();
	}

	
	public static Integer position (List<Employee> list,int id) {
			for (Integer i=0 ;i<list.size();i++) {
				if (list.get(i).getId()==id) {
					return i;
				}
			}
			return null;
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
