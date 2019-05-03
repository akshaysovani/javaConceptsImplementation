package ComparableAndComparator;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Employee[] employees = new Employee[5];
		employees[0] = new Employee(1, "Akshay", 100.12);
		employees[1] = new Employee(1, "Sanket", 101.12);
		employees[2] = new Employee(2, "Kunal", 500.10);
		employees[3] = new Employee(3, "Neel", 102.00);
		employees[4] = new Employee(4, "Aniket", 48.17);

		Arrays.sort(employees);
		for (Employee employee: employees){
			System.out.println(employee.toString());
		}
		
		Arrays.sort(employees, Employee.IDComparator);
		System.out.println("Sorted using ID: ");
		for (Employee employee: employees){
			System.out.println(employee.toString());
		}
		
		Arrays.sort(employees, Employee.NameComparator);
		System.out.println("Sorted using Name: ");
		for (Employee employee: employees){
			System.out.println(employee.toString());
		}
		
		Arrays.sort(employees, Employee.SalaryComparator);
		System.out.println("Sorted using Salary: ");
		for (Employee employee: employees){
			System.out.println(employee.toString());
		}
		
		Arrays.sort(employees, new EmployeeByNameAndId());
		System.out.println("Sorted using ID and then Name: ");
		for (Employee employee: employees){
			System.out.println(employee.toString());
		}
	}
}
