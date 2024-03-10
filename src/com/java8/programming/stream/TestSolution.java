package com.java8.programming.stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSolution {
	
	/*1. Given a list of integers,
		find out all the even numbers that exist in the list using Stream functions?
	*/
	
	public static void findAllEvenNumberInList() {
		
		List<Integer> mylist=Arrays.asList(10,9,12,13,14,19,31,32);
			mylist.stream()
			.filter(s->s%2==0)
			.forEach(System.out::print);
		
	}
	/*
	 * 2. Given a list of integers, 
	 * find out all the numbers starting with 1 using Stream functions?
	 */
	public static void findNumberStartingWithOne() {
		List<Integer> mylist=Arrays.asList(10,9,12,13,14,19,31,32);
		
		mylist.stream()
		.map(s->s+"")
		.filter(s->s.startsWith("1",0))
		.forEach(System.out::print);
	}
	/*
	 * 3. How to find duplicate elements in a given
	 *  integers list in java using Stream functions?
	 */
	
	public static void findDuplicateElementInList() {
		List<Integer> mylist=Arrays.asList(10,9,12,13,14,19,31,32,10,9,31,10,9);
		
		Set<Integer> myset=new HashSet();
		Set<Integer> myset1=new HashSet();
		mylist.stream()
		.filter(s-> !myset.add(s))
		.filter(s->myset1.add(s))
		.forEach(System.out::print);
	}
	
	/*
	 * 4. Given the list of integers,
	 *  find the first element of the list using Stream functions?
	 */
	
	public static void findFirstElementOfList() {
		List<Integer> mylist=Arrays.asList(10,9,12,13,14,19,31,32,10,9,31);
		
		mylist.stream()
		.findFirst()
		.ifPresent(System.out::print);
		
		System.out.println();
	}
	
	/*Given a list of integers, 
	 * find the total number of elements present in the list using Stream functions?
	 * 
	 */
	
	public static void findTotalNumberOfElementInList() {
		List<Integer> mylist=Arrays.asList(10,9,12,13,14,19,31,32,10,9,31,10,9);	
		
		long count = mylist.stream()
		.count();
		
		System.out.println(count);
	}
	
	/*
	 * 6. Given a list of integers, 
	 * find the maximum value element present in it using Stream functions?
	 */
	
	public static void findMaxValeElement() {
		
		List<Integer> mylist=Arrays.asList(10,9,12,13,14,19,31,32,10,9,31,10,9);
		
		Integer integer = mylist.stream()
		.max(Integer::compare)
		.get();
		
		System.out.println(integer);
	}
	
	/*
	 * 7. Given a String, find the first non-repeated character in it using Stream functions?
	 */
	public static void findFirstNonRepeated() {
		 String input = "Java articles are Awesome";
		 
		 Character result=input.chars()
		 .mapToObj(s-> Character.toLowerCase(Character.valueOf((char) s)))
		 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()))
		 .entrySet()
		 .stream()
		 .filter(entry-> entry.getValue()==1L)
		 .map(entry-> entry.getKey())
		 .findFirst()
		 .get();
		 
		 System.out.println(result);
		 
		 Map<Character, Long> result1=input.chars()
				 .mapToObj(s-> Character.toLowerCase(Character.valueOf((char) s)))
				 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()));
				
		 result1.entrySet()
		 
		 .forEach(entry-> {
			  System.out.println("Key = "+entry.getKey() +"    Value = "+ entry.getValue()+"   ");
		 });
				 
	}
	/*
	 * 8. Given a String, find the first repeated character in it using Stream functions?
	 */
	public static void findFirstRepeatedCharacter() {
		
		 String input = "Java articles are Awesome";
		 
		 Character character = input.chars()
		 .mapToObj(c-> Character.toLowerCase(Character.valueOf((char) c ) ))
		 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting() ))
		 .entrySet()
		 .stream()
		 .filter(entry-> entry.getValue() > 1L)
		 .map(entry-> entry.getKey())
		 .findFirst()
		 .get();
		 
		 System.out.println(character);
	}
	
	/*
	 * 9. Given a list of integers, sort all the values present in it using Stream functions?
	 */
	public static void sortAllValuesInLIst() {
		List<Integer> mylist=Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		mylist.stream()
		.sorted()
		.forEach(s-> System.out.println(s));
	}
	
	/*
	 * 10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
	 * 
	 */
	public static void sortAllValuesInListInDescendingOrder() {
		List<Integer> mylist=Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		mylist.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(s-> System.out.println(s));
		
		
	}
	
	/*
	 * 11. Given an integer array nums, 
	 * return true if any value appears at least twice in the array, 
	 * and return false if every element is distinct.
	 */
	public static void checkArrayValueIsTwiceOrNot() {
		
		int[] num1= {1,1,2,2,3,3,4,4};
		int[] num2= {1,2,3,4};
		List<Integer> mylist=Arrays.stream(num2)
				.boxed()
				.collect(Collectors.toList());
		
		Set<Integer> set=new HashSet(mylist);
		if(set.size()==mylist.size()) {
			System.out.println("False");
		}
		else {
			System.out.println("True");
		}
				
	}
	
	public static void sortlist(List<String> str ) {
		
		List<String> collect = str.stream()
		.sorted(Comparator.comparing(String::length))
		.collect(Collectors.toList());
		
		String commaseprated=String.join(",",collect );
		System.out.println(commaseprated);
	}
	
	
	/*
	 * 12. How will you get the current date and time using Java 8 Date and Time API?
	 */
	public static void currentDateTimeInJava() {
		System.out.println("Local Date         "+LocalDate.now());
		System.out.println("Local Time   "+LocalTime.now());
		System.out.println("Local Date and Time    "+LocalDateTime.now());
	}
	public static void main(String[] args) {
	List<String> strlist=Arrays.asList("Java","C","C#","HTML","Kotlin");
	
	//sortlist(strlist);
		
		
		   Stream<Integer> takeWhile = Stream
           //Generate a stream of arrays like this {0,1}, {1, 1}, {1, 2}, {2, 3}, {3, 5}...etc.
           .iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
           //Keep only the 1st element of each array.
           .map(n -> n[0])
           //Drop only 0.
           .dropWhile(i -> i < 1)
           //Take any number which is <= 100.
           .takeWhile(i -> i <= 100);
		   
		   List<Integer> seq=takeWhile.toList();
		   List<String> collect = seq.stream().map(s->s.toString())
		   .collect(Collectors.toList());
		   
		   String comp=String.join(",",collect);
		   System.out.println(seq);

	//	findAllEvenNumberInList();
	//	findNumberStartingWithOne();
	//	findDuplicateElementInList();
		
	//	findFirstElementOfList();
		
	//	findTotalNumberOfElementInList();
		
	//	findMaxValeElement();
		
	//	findFirstNonRepeated();
	//	findFirstRepeatedCharacter();
		
	//	sortAllValuesInLIst();
		
	//	sortAllValuesInListInDescendingOrder();
	//	checkArrayValueIsTwiceOrNot();
	//	currentDateTimeInJava();
	}

}
