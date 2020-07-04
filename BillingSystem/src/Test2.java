
class NewEmployee{
	int id = 101;
	String name;
	int basicSalary;
	
	public int calculateTax(double netSalary) {
		return (int) (0.10 * netSalary);
	}
	
	public void printDetails() {
		System.out.println("Employee [id=" + id + ", name=" + name + 
				", basicSalary = " + basicSalary + ", tax = " + 
				calculateTax(0.80 * basicSalary) + "]");
	}
	
	
	
}

public class Test2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
//		System.out.println("Going to call myself again...");
//		main(new String[1]);
		
		System.out.println("Program started...");
		
//		int i = 10;
		Class.forName("Employee").newInstance();
		
		NewEmployee[] arr = new NewEmployee[1000000];

		for(int i = 0; i < 1000000; i++) {
			NewEmployee employee = new NewEmployee();
			employee.name = "Ram" + i;
			arr[i] = employee;
			System.out.println("Object created...");
			Thread.sleep(10);
			
		}
		
		NewEmployee employee = new NewEmployee();
		employee.name = "Shyam";
		employee.basicSalary = 1500000;
		employee.printDetails();
		
		String name = new String("Ram");
		String name2 = "Ram";
		String name3 = "Ram";
		
		System.gc();
		
		while(true) {
			Thread.sleep(10);
		}
		
		

	}

}

//WORA -> Write Once Run Anywhere
//javac Test.java -> bytecode
//java Test -> 
//1. Bytecode loading, classes loading, static things loading and linking
//2. Bytecode verification
//3. Conversion of bytecode to machine code
//4. Machine code execution

// -Xmx{}m  -  run configuration - virtual machine args
// -Xss{}m

// Heap : 
//- It is a shared runtime data area where the actual objects (class instances and arrays) are stored in memory.
//- Heap is instantiated during the virtual machine startup.
//- int[] arr = new arr[10];
//- int size = arr.length;
//- int a = 10;  // primitive
//
//- Heap can be of fixed or dynamic size depending upon the run or system configuration
//- When we use new keyword, object is assigned a space in heap, but the reference of this object is maintained on call stack
//- There exists only one heap for a running JVM process

// Method :
//- Method Area is a logical part of heap 
//- It is created when virtual machine starts up
//- It is allocated to method data, constructor field data, interfaces, class structures, special method in classes
//- It may or may not garbage collected
//- But garbage collection is compulsory in heap
//- Memory needs not to be contiguous

// JVM Stacks :
//- A stack is created at the same time when a thread is created
//- A stack is used to store data and partial results which will be needed while returning values from methods and performing dynamic linking
//- Memory for stack needs to be contiguous

// Native method stacks (also called as C stacks)
// native stacks are not written in Java language
// This memory is allocated for each thread

// Working of a Garbage Collector:
//- JVM triggers this process and as per the JVM orders, Garbage Collection is done or withheld
//- It reduces the programmer's burden by allocating and deallocating memory automatically
//- Garbage collection causes the other threads to pause in between and thus is costly in terms of time and speed.
//- This problem is unacceptable so Garbage Collection tuning is done
//- Another solution is the generational garbage collection - it adds an age field to the objects
//- As more and more objects are created, the list of objects to be deleted gets long thereby garbage collection time also increases quite a bit
//- On the basis of how many GC cycles the objects survive, objects are grouped and allocated an age tag accordingly


//public native void createArray(int size)
