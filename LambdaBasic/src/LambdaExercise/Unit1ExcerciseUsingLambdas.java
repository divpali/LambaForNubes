package LambdaExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExcerciseUsingLambdas {
	public static void main(String[] args) {
		List<Person> person = Arrays.asList(new Person("Divya", "Pali", 26), new Person("Diya", "Wali", 27),
				new Person("Tia", "Tali", 29), new Person("Pia", "Pali", 16), new Person("Chia", "Mali", 20));

		// 1. sort list by last name
		//using lambdas
		System.out.println("");
		System.out.println("using lambdas : ");
		Collections.sort(person, (Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		// 2. create a method that prints all elements in the list
		System.out.println("create a method that prints all elements in the list :");
		System.out.println("");
//		printAll(person);
		printConditionally(person, p -> true);

		// 3. create a method that prints all the people with last name beginning with P
		System.out.println("");
		System.out.println("create a method that prints all the people with last name beginning with P : ");
		printConditionally(person, new Condition() {

			@Override
			public boolean test(Person person) {
				// TODO Auto-generated method stub
				return person.lastName.startsWith("P");
			}
			
		});
		
		//converting above to Lambdas now {just copy paste the above code and keep removing what is not required}
		System.out.println("here:");
		printConditionally(person, p -> p.lastName.startsWith("P"));

	}

	/*
	 * Now even though this gets the job done but what if i want to print Person with
	 * last name 'C' or any other alphabet. 
	 * A good idea is to make an interface of it pass it as a behavior
	 */
	private static void printConditionally(List<Person> person, Condition condition) {
		// TODO Auto-generated method stub
		for (Person person2 : person) {
			if (condition.test(person2)) {  //test each person's condition with the functionality
				System.out.println(person2);
			}
		}

	}

}

//Create a condition interface with a functionality
interface Condition {
	boolean test(Person person);
}

