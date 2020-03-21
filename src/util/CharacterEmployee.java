package util;

import java.util.function.Predicate;

import entities.Employee;

public class CharacterEmployee implements Predicate<Employee> {
	
	private char c;

	public CharacterEmployee(char c) {
		this.c = c;
	}
	
	@Override
	public boolean test(Employee e) {
		return e.getName().charAt(0) == c;
	}
}
