package util;

import java.util.Comparator;

import entities.Employee;

public class EmailComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getEmail().toUpperCase().compareTo(o2.getEmail().toUpperCase());
	}

}
