import java.util.ArrayList;
import java.util.Scanner;

// this class will work for any types
// since this class accepts and returns Object types you're free to pass and receive anything
// But it should not be primitive type
// this class after all is non-generic
// There is no way to verify at compile time how the class is used
class Box{
	
	private Object object;
	
	public void set(Object object) {
		this.object = object;
	}
	public Object get() {
		return object;
	}
	
}

class NewBox<T>{     // type parameter
	// T stands for "Type"
	private T object;
	
	public void set(T object) {
		this.object = object;
	}
	public T get() {
		return object;
	}
}

public class GenericsDemo {
	
	public static String getSomeString() {
		return "I am a static fn..";
	}

	public static void main(String[] args) {
		
		Box box = new Box();
		
		ArrayList<Employee> al = new ArrayList<>();
		box.set(al);
//		box.set(new int[10]);
//		
		Integer i = 100; // autoboxing
		box.set(i);
//		Integer j = (Integer) box.get();
		Employee j = (Employee)box.get();
//		
//		box.set(new Scanner(System.in));
		
//		char[] arr = getSomeString();
		String s = getSomeString();
		
		// NewBox of Thread
		NewBox<Thread> newBox = new NewBox<Thread>(); // we have to pass type argument
		// You need to specify type argument in both the places
		Thread thread = new Thread();
		newBox.set(thread);
		
		Thread threadCopy = newBox.get();
		
		// In Java 7, update said that you can omit the type argument on the right side 
		// but you still need to write empty set of arguments(<>), 
		// informally also called as the diamond
		// NewBox of String
		NewBox<String> newBox2 = new NewBox<>();
		newBox2.set("abcdef");
		System.out.println(newBox2.get());
		
		

	}

}

// Generic types
// It is a generic class or interface that is parameterized over type(s)
// Generic class format:
// class name<T1, T2, ... , Tn> { /* ... */ }

// <T1, T2, ... , Tn>  --> type parameters (variables) section

// Type parameter naming conventions
//- Type parameters names are single, upper-case letters -> T
//- Class and interface naming - word(s) - title case - NewBox - ArrayIndexOutOfBoundsException
//- Variable and function naming - camel case - almost title case but the first letter should be small
//- newBox2, findFirstNonRepeatingCharacter, printCharactersBasedOnIndexes, findLargestNumber, noOfIterations, largestNumber
//- final variables (constant) - upper-case and use underscores when space is needed - MIN_VALUE, MAX_VALUE, COLOR, WHITE
//- package naming - lower-case - com.company.billing.user.dto, com.company.billing.main, com.company.billing.util, com.company.billing.user.dao

// Most common type parameter names:
// T - type
// E - element
// K - key
// V - value
// N - Number
// T, S, U, V... etc