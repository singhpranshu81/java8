package com.java8.eg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsUserDefined {

	public static void main(String[] args) {
		Employee[] emparr= {
			new Employee("Sachin","Tendulkar","IT",5000),
			new Employee("Amir","Khan","HR",4000),
			new Employee("MS","Dhoni","Sales",7000),
			new Employee("Virat","Kohli","Sales",5500),
			new Employee("Pranshu","Singh","IT",3500)			
		};
		List<Employee> emplist=Arrays.asList(emparr);
		emplist.forEach(li->System.out.println(li));
		long empcount=emplist.stream().count();
		System.out.println("Employee count is: "+empcount);
		
		int sumofsal=emplist.stream().mapToInt(Employee::getSalary).sum();
		
		System.out.println("Employee aggregate salary is: "+sumofsal);
		IntSummaryStatistics st=emplist.stream().mapToInt(Employee::getSalary).summaryStatistics();
		System.out.println("max salary is: "+st.getMax());
		
		List<Employee> ascsrt=emplist.stream().sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList());
		ascsrt.forEach(li->System.out.println(li));
		
		List<Employee> descsrt=emplist.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
		descsrt.forEach(li->System.out.println(li));
		
	     Arrays.stream(emparr).filter(e-> e.getFname().startsWith("S")).forEach(em->System.out.println(em));
	     
	     //anyMatch() , allMatch() , noneMatch()
	     
	     boolean anymtch= emplist.stream().anyMatch(e-> e.getFname().startsWith("S"));
	     if(anymtch) {
	    	 System.out.println("Employee with sattrinfg letter S is: ");
	    	 emplist.stream().filter(e-> e.getFname().startsWith("S")).forEach(e->System.out.println(e.getFname()+" "+e.getLname()));
	     }
	}

}
