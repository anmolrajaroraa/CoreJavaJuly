package com.company.serialization;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1118157340674852342L;
//	private static final long serialVersionUID = -6060337023591725244L;
//	private static final long serialVersionUID = -5946969309741602533L;
	
	private String name;
	private int id;
	private int salary;
	private String password;
	public String companyName = "XYZ, Inc.";
	private String designation;

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + 
				", password=" + password + ", designation=" + designation + 
				", companyName=" + companyName + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	

}






/* Serialization in Java - 1.1
 * It allows us to convert an object to stream 
 * We can send this object as a stream over the network or save it as a file
 * Or we can store it in DB for later use.
 * De-serialization is the process of converting Object stream back to an actual Java object which can be used by our programs
 * 
 * If we want that a class object can be serialized, we need to implement java.io.Serializable
 * Serializable is just a marker interface - no fields no methods
 * It's just like an opt-in process through which we make our classes serializable
 * 
 * Serialization is implemented by ObjectInputStream and ObjectOutputStream
 * We need to wrap them over to save streams to the file
 * 
 * Since password is a transient variable, it's value was not saved to file
 * That's why, password was null when we retrieved the object from file
 * Similarly, static variable values are also not serialized coz they belong to class instead of objects
 * 
 * Class Refactoring with serialVersionUID
 * Serialization in Java permits some changes in the class, but only if those changes can be ignored
 * Some changes that dont affect the deserialization process:
 * 1. Add new variables to the class
 * 2. Change the variables from transient to non-transient
 * For serialization, it's like a new field
 * 3. Change the variables from static to non-static
 * Again, for serialization, it's like having a new field
 * 
 * If you don't define serialVersionUID, you get java.io.InvalidClassException
 * The reason for this exception is that serialVersionUID of previous class used for serialization
 * and the current class being used for deserialization are different
 * If our class doesn't define serialVersionUID, it gets calculated automatically and assigned to the class
 * Java uses class variables, methods, class name, package etc to generate a unique long number
 * If you dont define serialVersionUID, you also get a working that you haven't declare the unique long ID for the class
 * We can use the utility "serialver" provided by Eclipse IDE to generate the class serialVersionUID
 * 
 * It's not mandatory to generate a serialVersionUID, program can do that itself at runtime.
 * It just needs to be there to let deserialization process know that the new class is just a slightly different version of the original class 
 * And most probably there shouldn't be any problem in deserialization
 * 
 * Externalizable
 * 
 * Java Serialization Methods
 * 
 * 1. readObject(ObjectInputStream oin) - if this method is present in class, readObject(worker) will use
 * this overridden method for reading the object from stream
 * 
 * 2. writeObject(ObjectOutputStream out) - if this method is present in class, writeObject(worker) will use
 * this overridden method to write the object to the stream
 * 
 * 3. Object writeReplace() - if this method is present, then after serialization process this method is called
 * and the object returned is serialized to the stream
 * 
 * 4. Object readResolve() - if this method is present, then after deserialization process, this method is called
 * to return the final object to the main method
 * 
 * - Usually while implementing these methods, we keep them private so that any subclass is unable to override them
 *   These functions are meant for serialization only & keeping them private avoids any security issues also.
 * 
 * 
 * Serialization with Inheritance
 * 
 * Sometimes we inherit a class that has not implemented the Serializable interface
 * Then the problem is if we rely on automatic serialization and there are some variables in parent class also that need to be serialized
 * Then those variables will never be converted to stream and hence you can't store them.
 * 
 * This is the place where readObject() and writeObject() are really helpful. 
 * By overriding them and providing their implementation, we can save the variables of parent class also to the stream 
 * And then retrieve them later on.
 * 
 * So in this way, we can serialize super class variables even though it's not implementing Serializable interface
 * This strategy comes in use when the super class is a third-party class that we can't change in any case
 * 
 * 
 * Serialization Proxy Pattern
 * 
 * Serialization in java has some pitfalls:
 * - The class structure can't be changed a lot without breaking serialization process.
 * So even though we don't need some variables later on,  we need to keep them just for backward compatibility
 * - Serialization causes huge security risks, an attacker can change the stream sequence and cause harm to the system
 * For example, user role is serialized and an attacker change the stream value to make it admin and run malicious code
 * 
 * Proxy pattern is a way to achieve greater security with Serialization
 * In this pattern, an inner private static class is used as a proxy class for serialization purpose
 * It is implemented by creating readResolve() and writeReplace() methods
 * 
 */