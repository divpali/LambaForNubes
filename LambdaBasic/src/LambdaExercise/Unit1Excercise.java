package LambdaExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Excercise {

	public static void main(String[] args) {
		List<Person> person = Arrays.asList(new Person("Divya", "Pali", 26), new Person("Diya", "Wali", 27),
				new Person("Tia", "Tali", 29), new Person("Pia", "Pali", 16), new Person("Chia", "Mali", 20));

		// 1. sort list by last name
		Collections.sort(person, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		// 2. create a method that prints all elements in the list
		System.out.println("create a method that prints all elements in the list :");
		System.out.println("");
		printAll(person);
		
		// 3. create a method that prints all the people with last name beginning with P
		System.out.println("");
		System.out.println("create a method that prints all the people with last name beginning with P : ");
		printLastNameWithP(person);

	}

	/*
	 * Now even though this gets the job done but what if i want to print Person with
	 * last name 'C' or any other alphabet. 
	 * A good idea is to make an interface of it pass it as a behavior
	 */
	private static void printLastNameWithP(List<Person> person) {
		// TODO Auto-generated method stub
		for (Person person2 : person) {
			if (person2.lastName.startsWith("P")) {
				System.out.println(person2);
			}
		}

	}

	private static void printAll(List<Person> person) {
		for (Person person2 : person) {
			System.out.println(person2);
		}
	}
}

