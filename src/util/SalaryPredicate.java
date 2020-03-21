package util;

import java.util.function.Predicate;

import entities.Employee;

public class SalaryPredicate implements Predicate<Employee> {

	private double salary;
	
	public SalaryPredicate(double salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean test(Employee t) {
		// TODO Auto-generated method stub
		return t.getSalary() <= salary;
	}

}
