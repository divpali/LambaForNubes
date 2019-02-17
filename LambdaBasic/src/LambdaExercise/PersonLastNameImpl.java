package LambdaExercise;

import java.util.List;

public class PersonLastNameImpl implements PersonLastName{
	
	@Override
	public void printLastNameWithGivenCondition(List<Person> person) {
		// TODO Auto-generated method stub
		for (Person person2 : person) {
			if (person2.lastName.startsWith("P")) {
				System.out.println(person2);
			}
		}

	}
}
