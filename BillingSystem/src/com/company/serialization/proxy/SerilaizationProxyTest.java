package com.company.serialization.proxy;

import java.io.IOException;

import com.company.serialization.SerializationUtil;

public class SerilaizationProxyTest {

	public static void main(String[] args) {
		String fileName = "data.ser";
		
		Data data = new Data("something_secret");
		
		try {
			SerializationUtil.serialize(data, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Data newData = (Data) SerializationUtil.deserialize(fileName);
			System.out.println("subClass is " + data);
			System.out.println("newSubClass is " + newData);
		}
		catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
