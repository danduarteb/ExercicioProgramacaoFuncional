package entities;

import java.util.List;
import java.util.function.Predicate;

public class Employee {
	
	private String name;
	private String email;
	private Double salary;
	
	public Employee(String name, String email, Double salary) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public static int compareEmail(Employee e1, Employee e2) {
		return e1.getEmail().toUpperCase().compareTo(e2.getEmail().toUpperCase());
	}
	
	public static String applyEmail(Employee e) {
		return e.email;
	}
	
	public static boolean testCharacter(Employee e) {
		return e.getName().charAt(0) == 'M';
	}
	
	public static double filteredSum(List<Employee> empregados, Predicate<Employee> criteria) {
		double sum = 0;
		for(Employee e : empregados) {
			if(criteria.test(e)) {
				sum += e.getSalary();
			}
		}
		
		return sum;
	}
	
	public static void acceptSalary(Employee e) {
		e.setSalary(e.getSalary()*0.1);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
	
}
