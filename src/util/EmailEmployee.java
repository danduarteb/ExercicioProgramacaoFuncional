package util;

import java.util.function.Function;

import entities.Employee;

public class EmailEmployee implements Function<Employee, String> {

	@Override
	public String apply(Employee t) {
		// TODO Auto-generated method stub
		return t.getEmail();
	}

}
