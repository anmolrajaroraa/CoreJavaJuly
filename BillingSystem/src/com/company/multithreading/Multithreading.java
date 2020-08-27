package com.company.multithreading;

public class Multithreading {

	public static void main(String[] args) {
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
		// above is a one - liner statement to create a new thread
		// here we are creating an anonymous class and implemeting Runnable side by side
		// plus we have implemented the run() also
		
		// With Java 8 lambda expressions, we can create Thread in java like this also
		// This is possible only coz Runnable is a functional interface
		
		Thread t2 = new Thread(() -> {
			System.out.println("My runnable");
			long startTime = System.currentTimeMillis();
			try {
				Thread.sleep(2000, 999999);
				System.out.println("Total time taken by thread in ms - " + 
									(System.currentTimeMillis() - startTime) );
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		});
		t2.start();

	}

}

/* Java thread is a lightweight process that executes some task
 * Java provides Thread class using which an application can create multiple threads executing concurrently
 * 
 * There are two types of threads -
 * - User thread
 * - Daemon thread
 * When we start an application, main is the first user thread created and after that we can create
 * multiple threads as well as daemon threads. When all threads are completely executed, JVM terminates the program
 * We can set different priorities for different threads
 * But it doesn't guarantee that higher priority thread will execute first than lower priority thread
 * Thread Scheduler is part of OS and when thread gets started, it's execution is controlled by Thread Scheduler
 * Moreover, JVM also doesn't have any control over threads' execution
 * 
 * We can create threads by either implementing Runnable interface or by extending Thread class
 * 
 * Process - A process is a self contained execution environment - a program or an application
 * However a program itself contains multiple processes inside it.
 * Java Runtime Env runs as a single process.
 * But it contains multiple classes and programs as processes.
 * 
 * Thread - lightweight process. 
 * Thread requires less resources to create and exists inside the process
 * Thread shares process resources
 * 
 * Every java application has at least one thread - main thread.
 * Although there are many other threads running in background like memory mgmt, system mgmt, signal processing etc
 * but from application pov - main is the first thread & we can create multiple threads from it
 * 
 * Multi-threading refers to two or more threads executing concurrently.
 * A computer single core processor can execute only one thread at a time
 * Time slicing is the OS feature to share processor time between different processes and threads
 * 
 * Benefits:
 * - Java threads are lightweight compared to processes, 
 * it takes less time and resources to create a thread
 * - Threads share their parent process data and code
 * - Context switching between threads is less expensive than between processes
 * - Thread intercommunication is relatively easy than process communication
 * 
 * Runnable vs Thread
 * - If your class provides more functionality rather than just running as a Thread, you should implement
 * Runnable interface. If your class only goal is to run as Thread, you can Thread class.
 * - Implementing Runnable is preferred because Java supports implementing multiple interfaces.
 * If you extend Thread class, you can't extend any other classes.
 * 
 * From Java 8 onwards, Runnable is a functional interface and we can lambda expressions to provide
 * its implementation rather than using anonymous class.
 * 
 * Thread.sleep() method can be used to pause the execution of current thread for specified time in
 * milliseconds. 
 * Argument value for milliseconds can't be negative else it throws IllegalArgumentException
 * 
 * There is another overloaded method sleep(long millis, int nanos) that can be used to pause the execution
 * for specified ms and ns. Nano second value is b/w 0 and 999999
 * 
 * If you will run the above program, you will notice that the thread sleep time it prints is 
 * slightly greater than 2000ms. This is caused by how thread sleep works and operating system specific
 * implementation of thread scheduler.
 * 
 * Thread.sleep imp points
 * - It always pause the current thread execution
 * - The actual time thread sleeps before waking up and start execution depends on system timers
 * and schedulers. For a quiet system, the actual time for sleep is near to the specified sleep time
 * but for a busy system it will be a little more.
 * - Thread sleep doesn't lose any locks current thread has acquired.
 * - Any other thread can interrupt the current thread in sleep, in that case InterruptedException is thrown
 * 
 * How thread sleep works
 * Thread.sleep() interacts with the thread scheduler to put the current thread in wait state for the 
 * specified period of time. Once the wait time is over, thread state is changed to runnable state and
 * wait for the CPU for further execution. So, the actual time that current thread sleep depends on the
 * thread scheduler that is part of Operating System.
 * 
 * Java Thread join method can be used to pause the current thread execution until unless the specified
 * thread is dead.
 * There are three overloaded join functions.
 * - public final void join() -> This java thread join method puts the current thread on wait until 
 * the thread on which it's called is dead. If the thread is interrupted, it throws InterruptedException.
 * - public syncronized void join(long millis) -> This method is used to wait for the thread 
 * on which it's called to be dead or wait for specified milliseconds. Since thread execution depends on OS
 * implemevtation, it doesn't guarantee that the current thread will wait only for given time.
 * - public syncronized void join(long millis, int nanos) -> This method is used to wait for thread to 
 * die for given milliseconds plus nanoseconds. 
 * 
 * New
 * When we create a new Thread object using new operator, thread state is New Thread.
 * At this point, thread is not alive and it's a state internal to Java.
 * 
 * Runnable
 * When we call start() on Thread object, it's state is changed to Runnable.
 * The control is given to Thread scheduler to finish it's execution.
 * Whether to run this thread instantly or keep it in runnable thread pool before running, depends on the thread scheduler
 * 
 * Blocked / waiting
 * A thread can be waiting for other thread to finish using thread join or it can be waiting 
 * for some resources to be available. For example - IO resources, then it's state is changed to Waiting.
 * Once the thread wait state is over, it's state is changed to Runnable and it's moved back to runnable thread pool
 * 
 * Dead
 * Once the thread finished executing, it's state is changed to Dead and it's considered to be not alive
 *
 * Object class in Java contains three final methods that allow threads to communicate about the 
 * lock status of a resource. These methods are wait(), notify(), notifyAll().
 * 
 * The current thread which invokes these methods on any object should have the monitor else it throws
 * java.lang.IllegalMonitorStateException
 * 
 * wait
 * Object wait methods has three variances, one which waits indefinitely for any other thread to call 
 * notify or notifyAll method on the object to wake up the current thread. Other two variances 
 * puts the current thread in wait for specific amount of time before they wake up.
 * 
 * notify
 * notify method wakes up only one thread waiting on the object and that thread starts execution.
 * So, if there are multiple threads waiting for an object, this method will wake up only one of them.
 * The choice of the thread to wake depends on OS's thread management
 * 
 * notifyAll
 * notifyAll method wakes up all the threads waiting for an object, although which one will process first
 * depends on OS implementation.
 * 
 * Thread Safety
 * The reason for data inconsistency is because updating any field value is not an atomic process, 
 * it requires three steps; first to read the current value, second to do the necessary operations
 * to get the updated value and third to assign the updated value to the field reference
 * 
 * Thread safety in Java is the process to make our program safe to use in multi-threaded environments.
 * - Synchronization is the easiest and most widely used tool for thread safety in Java
 * - Use of Atomic Wrapper classes from java.util.concurrent.atomic package. For example: AtomicInteger
 * - Use of locks from java.util.concurrent.locks package
 * - Using thread safety collection classes. For example: ConcurrentHashMap
 * - Using volatile keyword with variables to make every thread read the data from memory, not read from thread cache
 * 
 * Java synchronized
 * Synchronization is the tool using which we can achieve thread-safety. JVM guarantees that synchronized
 * code will be executed by only one thread at a time. Java keyword synchronized is used to create
 * synchronized code and internally it uses locks on Object or Class to make sure only one thread is 
 * executing the synchronized code
 * 
 * When a method is synchronized, it locks the Object, if method is static it locks the Class, so it's
 * always a good practice to use synchronized block to lock only the sections of the method that needs synchronization
 */
