package com.company.serialization;

import java.io.IOException;

public class SerializationTest {

	public static void main(String[] args) {
		
		// 2,23,55,72,533
		
//		4827 5612 3147
		
		// 13,34,66,83,644 -> fraud -> no money given
		
		String fileName = "employee.ser";
		Employee employee = new Employee();
		employee.setId(100);
		employee.setName("Ram");
		employee.setSalary(50000);
		employee.setPassword("ram1234");
		employee.setDesignation("Staff SWE");
//		Employee.companyName = "ABC Pvt. Ltd.";
		employee.companyName = "ABC Pvt. Ltd.";
//		employee.companyName = "x";
		
//		try {
//			SerializationUtil.serialize(employee, fileName);
//			System.out.println("Serialization Done...");
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
//		
		Employee newEmployee = null;
		
		try {
			newEmployee = (Employee) SerializationUtil.deserialize(fileName);
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Original employee object : " + employee);
		System.out.println("Desreialized employee object : " + newEmployee);
		

	}

}
