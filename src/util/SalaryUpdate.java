package util;

import java.util.function.Consumer;

import entities.Employee;

public class SalaryUpdate implements Consumer<Employee> {
	
	@Override
	public void accept(Employee e) {
		e.setSalary(e.getSalary()*0.1);
	}

}
