package com.company.serialization;

import java.io.Serializable;

class Student implements Serializable{
	int id;
	String name;
	String courseName;
	int sem;
	String address;
	int phoneNo;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", courseName=" + courseName + ", sem=" + sem + ", address="
				+ address + ", phoneNo=" + phoneNo + "]";
	}



	Student cloneObject() {
		Student student = new Student();
		student.id = id;
		student.name = name;
		student.courseName = courseName;
		student.sem = sem;
		student.address = address;
		student.phoneNo = phoneNo;
		return student;
	}
	
	@Override
	protected Student clone() throws CloneNotSupportedException {
		return (Student) super.clone();
	}
}

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {

		Student student1 = new Student();
		student1.id = 101;
		student1.name = "Ram";
		student1.courseName = "BTech";
		student1.sem = 8;
		student1.address = "New Delhi";
		student1.phoneNo = 100;
		
		Student student2 = student1;  // sharing the object
		Student student3 = student1.cloneObject();   //cloning
		Student student4 = student1.clone();   //cloning using overridden method
		
		student2.name = "Shyam";
		student3.name = "Sita";
		
		System.out.println("Student1 is " + student1);
		System.out.println("Student2 is " + student2);
		System.out.println("Student3 is " + student3);
		
	}

}
