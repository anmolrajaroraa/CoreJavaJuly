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

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Program started...");
		
		NewEmployee[] arr = new NewEmployee[10];

		for(int i = 0; i < 10; i++) {
			NewEmployee employee = new NewEmployee();
			employee.name = "Ram" + i;
			arr[i] = employee;
			
		}
		
		NewEmployee employee = new NewEmployee();
		employee.name = "Shyam";
		employee.basicSalary = 1500000;
		employee.printDetails();

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
