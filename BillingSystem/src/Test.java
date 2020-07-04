class Employee{
	int id = 101;
	String name;
}

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Program started...");
		
//		ArrayList<Employee> al = new ArrayList<>();
		
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Total memory is " + runtime.totalMemory());
		System.out.println("Free memory before for loop " + runtime.freeMemory());
		
//		while(true) {
//		for(int i = 0; i < 100000; i++) {
//			Employee employee = new Employee();
//			employee.name = "Ram" + i;
//			al.add(employee);
//			
//		}
		
		System.out.println("Free memory after for loop " + runtime.freeMemory());

	}

}

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

//public native void createArray(int size)
