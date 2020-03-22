package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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
			//empregados.removeIf(new SalaryPredicate(salary));
			
			/*Predicate<Employee> predicaSalary = p1 -> {
				return p1.getSalary() <= salary;
			};*/
			
			//Predicate<Employee> pred = p1 -> p1.getSalary() <= 2000.00;
			
			//empregados.removeIf(pred);
			
			empregados.removeIf(p1 -> p1.getSalary() <= 2000);
			
			//empregados.sort(new EmailComparator());
			
			/*Comparator<Employee> comp = new Comparator<Employee>() {
				
				public int compare(Employee e1, Employee e2) {
					return e1.getEmail().toUpperCase().compareTo(e2.getEmail().toUpperCase());
				}
			};
			
			empregados.sort(comp);*/
			
			//empregados.sort(Employee::compareEmail);
			
			//empregados.sort(Employee::compareNonStaticEmail);
			
			/*Comparator<Employee> comp = (p1, p2) -> {
				return p1.getEmail().toUpperCase().compareTo(p2.getEmail().toUpperCase());
			};*/
			
			/*Comparator<Employee> comp = (p1, p2) -> 
				p1.getEmail().toUpperCase().compareTo(p2.getEmail().toUpperCase());
			
			empregados.sort(comp);*/
			
			empregados.sort((p1, p2) -> 
				p1.getEmail().toUpperCase().compareTo(p2.getEmail().toUpperCase()));
			
			//emails = empregados.stream().map(new EmailEmployee()).collect(Collectors.toList());
			
			/*Function<Employee, String> funct = new Function<Employee, String>() {
				@Override
				public String apply(Employee e) {
					return e.getEmail();
				}
			};
			
			emails = empregados.stream().map(funct).collect(Collectors.toList());*/
			
			//emails = empregados.stream().map(Employee::applyEmail).collect(Collectors.toList());
			
			/*Function<Employee, String> func = (p) -> {
				return p.getEmail();
			};*/
			
			/*Function<Employee, String> func = p ->  p.getEmail();
			
			emails = empregados.stream().map(func).collect(Collectors.toList());*/
			
			emails = empregados.stream().map(p -> p.getEmail()).collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than " + salary);
			emails.forEach(System.out::println);
			
			char c = 'M';
			
			/*System.out.println("Sum of salary of people whose name starts with 'M': " 
					+ new EmployeeService().filteredSum(empregados2
							, new CharacterEmployee(c)));*/
			
			/*Predicate<Employee> predic = new Predicate<Employee>() {
				public boolean test(Employee e) {
					return e.getName().charAt(0) == c;
				}
			};
			
			System.out.println("Sum of salary of people whose name starts with 'M': " 
					+ new EmployeeService().filteredSum(empregados2
							, predic));*/
			
			/*System.out.println("Sum of salary of people whose name starts with 'M': " 
					+ Employee.filteredSum(empregados2
							, Employee::testCharacter));*/
			
			/*Predicate<Employee> pred2 = p -> {
				return p.getName().charAt(0) == 'M';
			};*/
			
			/*Predicate<Employee> pred2 = p -> p.getName().charAt(0) == 'M';
			
			System.out.println("Sum of salary of people whose name starts with 'M': " 
					+ Employee.filteredSum(empregados2
							, pred2));*/
			
			System.out.println("Sum of salary of people whose name starts with 'M': " 
					+ Employee.filteredSum(empregados2
							, p -> p.getName().charAt(0) == 'M'));
			
			//empregados2.forEach(new SalaryUpdate());
			
			/*Consumer<Employee> cons = new Consumer<Employee>() {
				@Override
				public void accept(Employee e) {
					e.setSalary(e.getSalary()*0.1);
				}
			};
			
			empregados2.forEach(cons);*/
			
			//empregados2.forEach(Employee::acceptSalary);
			
			/*Consumer<Employee> consum = e -> {
				e.setSalary(e.getSalary()*0.1);
			};*/
			
			/*Consumer<Employee> consum = e -> e.setSalary(e.getSalary() * 0.1);
			
			empregados2.forEach(consum);*/
			
			empregados2.forEach(p -> p.setSalary(p.getSalary() * 0.1));
			
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
