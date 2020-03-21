package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;
import util.CharacterEmployee;
import util.EmailComparator;
import util.EmailEmployee;
import util.EmployeeService;
import util.SalaryPredicate;
import util.SalaryUpdate;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String path;
		Double salary;
		
		System.out.print("Enter full file path: ");
		path = sc.next();
		System.out.print("Enter salary: ");
		salary = sc.nextDouble();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linha = br.readLine();
			
			List<Employee> empregados = new ArrayList<>();
			List<Employee> empregados2 = new ArrayList<>();
			List<String> emails = new ArrayList<>();
			
			while(linha != null) {
				String valores[] = linha.split(",");
				
				empregados.add(new Employee(valores[0], valores[1]
						, Double.parseDouble(valores[2])));
				
				linha = br.readLine();
			}
			
			empregados2.addAll(empregados);
			empregados.removeIf(new SalaryPredicate(salary));
			empregados.sort(new EmailComparator());
			emails = empregados.stream().map(new EmailEmployee()).collect(Collectors.toList());
			
			
			System.out.println("Email of people whose salary is more than " + salary);
			emails.forEach(System.out::println);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + new EmployeeService().filteredSum(empregados2, new CharacterEmployee('M')));
			
			empregados2.forEach(new SalaryUpdate());
			empregados2.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
