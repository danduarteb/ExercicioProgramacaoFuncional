package util;

import java.util.List;
import java.util.function.Predicate;

import entities.Employee;

public class EmployeeService {
	
	public double filteredSum(List<Employee> employees, Predicate<Employee> criteria) {
		double sum = 0;
		for(Employee e : employees) {
			if(criteria.test(e)) {
				sum += e.getSalary();
			}
		}
		
		return sum;
	}

}
