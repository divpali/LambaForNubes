package LambdaExercise;

public class Person {

	String firstName;
	String lastName;
	int age;

	Person(String firstName, String lastName, int age) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person[firstname = " + firstName + ", lastname = " + lastName + " ,age = " + age + "]";

	}
}
