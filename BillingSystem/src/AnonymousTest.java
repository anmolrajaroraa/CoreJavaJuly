
interface Test1{
	public abstract void run();
	public default void stop() {
		
	}
}

//class TestChild implements Test1{  // step 1 // step 2
//
//	@Override
//	public void run() {   // step 3
//		System.out.println("I am test child");
//	}
//	
//}

public class AnonymousTest {

	public static void main(String[] args) {
//		Test1 obj = new TestChild();   // step 4 // step 5
//		obj.run();
		
		Test1 obj2 = new Test1() {

			@Override
			public void run() {
				System.out.println("I am sitting inside an anonymous class");
			}

			@Override
			public void stop() {
				
			}
			
		};
		
		obj2.run();
		
		
		
		Test1 obj3 = () -> System.out.println("I am sitting inside an lambda expression");
		obj3.run();
		// lambda expressions only work for functional interfaces
		// functional interfaces are the ones who have only one abstract method
		
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				
			}
			
		});
	}

}
