package com.company.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * A simple class with generic serialize and deserialize method implementations
 * 
 * @author Anmol
 *
 */
public class SerializationUtil {
	
	public static void serialize(Object object, String fileName) throws IOException {
		FileOutputStream fout = new FileOutputStream(fileName);
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(object);
		fout.close();
	}
	
	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(fileName);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object object = oin.readObject();
		fin.close();
		return object;
	}
	
}
