package ComparableAndComparator;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	private int ID;
	private String name;
	private double salary;
	
	public Employee(int ID, String name, double salary){
		this.ID = ID;
		this.name = name;
		this.salary = salary;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getSalary(){
		return this.salary;
	}

	@Override
	public int compareTo(Employee employee) {
		return this.ID - employee.ID;
	}
	
	public static Comparator<Employee> IDComparator = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2){
			return e1.getID() - e2.getID();
		}
	};
	
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2){
			return e1.getName().compareTo(e2.getName());
		}
	};
	
	public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2){
			return (int) (e1.getSalary() - e2.getSalary());
		}
	};
	
	public String toString(){
		return " Employee: { ID: "+ this.ID + " ,Name: " + this.name + " ,Salary: " + this.salary + " }";  
	}
}
