package com.company.serialization.inheritance;

import java.io.IOException;

import com.company.serialization.SerializationUtil;

public class InheritanceSerializationTest {

	public static void main(String[] args) {
		String fileName = "subclass.ser";
		
		SubClass subClass = new SubClass();
		subClass.setId(10);
		subClass.setValue("Data");
		subClass.setName("Ram");
		
//		try {
//			SerializationUtil.serialize(subClass, fileName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			SubClass newSubClass = (SubClass) SerializationUtil.deserialize(fileName);
			System.out.println("subClass is " + subClass);
			System.out.println("newSubClass is " + newSubClass);
		}
		catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
