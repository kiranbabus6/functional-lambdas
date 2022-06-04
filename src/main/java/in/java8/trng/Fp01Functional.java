package in.java8.trng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01Functional {

	
	public static void main(String[] args)
	{
		printAllNumbersInListStructured(Arrays.asList(12,9,13,4,6,9,0) );
		printAllNumbersInListFunctional(Arrays.asList(12,9,13,4,6,9,0) );
		printReduceNumbersInListFunctional(Arrays.asList(12,9,13,4,6,9,0) );
	//	printAllStringsInListFunctional(Arrays.asList("spring","spring boot","microservices", "api", "aws", "azure", "docker", "kubernetes") );
		
	}
	
	private static void print(int number)
	{
		System.out.println(number);
	}
	
	private static void printAllNumbersInListStructured(List<Integer> nums)
	{
		System.out.println("From legacy");
		for(int num : nums)
		{
			System.out.println(num);
		}
	}
	
	private static void printAllNumbersInListFunctional(List<Integer> numsList )
	{
		System.out.println("from functional");
		numsList.stream().filter(num -> num%2==1).forEach(System.out::println);
		System.out.println("squaring them");
		numsList.stream().map(num -> num*num).forEach(System.out::println);
		System.out.println("cube odd numbers");
		numsList.stream().filter(num -> num%2==1).map(num -> num*num*num).forEach(System.out::println);
	}
	
	private static void printAllStringsInListFunctional(List<String> strs)
	{
		System.out.println("print all");
		strs.stream().forEach(System.out::println);
		System.out.println("print spring contains");
		strs.stream().filter(str -> str.contains("spring") ).forEach(System.out::println);
		System.out.println("name contains atlest 4");
		strs.stream().filter(str -> str.length() >= 4).forEach(System.out::println);
		System.out.println("print number of chars");
		strs.stream().map(str -> str.length()).forEach(System.out::println);
		System.out.println("printing sorted strings");
		strs.stream().map(str -> str.length()).sorted().forEach(System.out::println);
		System.out.println("printing sorted strings in another way");
		strs.stream().sorted(Comparator.comparing(x -> x.length()) ).forEach(System.out::println);		
		
	}
	
	private static Integer add(Integer a, Integer b)
	{
		return a+b;
	}
	
	private static void printReduceNumbersInListFunctional(List<Integer> numsList )
	{
		System.out.println("from functional");
		numsList.stream().filter(num -> num%2==1).forEach(System.out::println);
		System.out.println("squaring them");
		numsList.stream().map(num -> num*num).forEach(System.out::println);
		System.out.println("cube odd numbers");
		numsList.stream().filter(num -> num%2==1).map(num -> num*num*num).forEach(System.out::println);
		System.out.println("adding them");
		System.out.println("added nums "+numsList.stream().reduce(0,Fp01Functional::add));
		System.out.println("adding them with lambda");
		System.out.println("added nums "+numsList.stream().reduce(0,(x,y) -> x+y));
		System.out.println("square and adding them with lambda");
		System.out.println("added nums "+numsList.stream().map(x -> x*x).reduce(0,(x,y) -> x+y));
		System.out.println("max with lambda");
		System.out.println("max no "+numsList.stream().reduce(0,(x,y) -> x>y?x:y));
		System.out.println("min with lambda");
		System.out.println("min no "+numsList.stream().reduce(Integer.MAX_VALUE,(x,y) -> x<y?x:y));
		System.out.println("sort numbers");
		numsList.stream().sorted().forEach(System.out::println);
		System.out.println("distinct sort numbers");
		numsList.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("assign to list");
		List<Integer> intList = numsList.stream().map(x -> x*x ).collect(Collectors.toList()) ;
		intList.stream().forEach(System.out::print);
		
	}
	
}
