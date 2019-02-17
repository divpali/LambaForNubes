package PassingBehaviourInOOPs;

public class Greeter {
	
	/*
	 * this method is always printing "HELLO WORLD"
	 */
	public void greet() {
		System.out.println("Hello World");
	}
	
	/*
	 * passing behaviour
	 * create interface and introduce functionality 
	 * implement that functionality in another class
	 * use that specific functionality anywhere by passing it as behaviour 
	 * This is classic polymorphism behaviour
	 * We are passing a thing which is a behaviour
	 * 
	 * 
	 * Lambdas help you achieve an action being passed in rather than a class
	 * that implements an action
	 * Lambdas help you creates this entities which are just functions and these
	 * functions are represented as values 
	 */
	public void greet_interface(GreetingImpl greetingImpl) {
		greetingImpl.perform();
	}
	
	public static void main(String[] args) {
		
		Greeter g = new Greeter(); 
		g.greet();
		  
		GreetingImpl greetingImpl = new GreetingImpl();
		g.greet_interface(greetingImpl);
		 
		
		MyLambdaExpression myLambdaFunction = () -> System.out.println("Hello world");
		
		Greeting g_new = new GreetingImpl();
		g_new.perform();
		
		//thus something similar can be done for greeting since Greeting also has an interface
		Greeting greeting = () -> System.out.println("Hello world");
		greeting.perform();
		//this lambda "greeting" is behaving like an implementation of Greeting
	}
	
	/*
	 * representing values
	 * String name = "Divya";
	 * aBlockOfCode = public void perform() {
						System.out.println("Hello world");
					  }
					  
	   aBlockOfCode = () -> System.out.println("Hello world");
	 */

}
