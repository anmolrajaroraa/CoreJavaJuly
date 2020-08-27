package com.company.externalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizationTest {

	public static void main(String[] args) {
		
		String filename = "worker.ser";
		Worker worker = new Worker();
		worker.setId(100);
		worker.setName("Ram Kumar");
		worker.setGender("Male");
		
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(worker);
			fout.close();
			System.out.println("Serialization done...");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream oin = new ObjectInputStream(fin);
			Worker newWorker = (Worker) oin.readObject();
			fin.close();
			System.out.println("Worker is " + worker);
			System.out.println("New worker is " + newWorker);
		} 
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
