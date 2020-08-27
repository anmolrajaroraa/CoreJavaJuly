package com.company.serialization.inheritance;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SubClass extends SuperClass implements Serializable, ObjectInputValidation{

	private static final long serialVersionUID = 8946664465085934916L;

	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "SubClass{id=" + getId() + ", value=" + getValue() + ", name=" + name + "}";
	}
	
	// helper method to serialize/save superclass variables
	private void readObject(ObjectInputStream oin) throws ClassNotFoundException, IOException {
		oin.defaultReadObject(); // retrieve name
		setId(oin.readInt());    // retrieve id
		setValue((String)oin.readObject()); // retrieve value
	}
	
	private void writeObject(ObjectOutputStream oout) throws IOException {
		oout.defaultWriteObject(); // save name
		oout.writeInt(getId());    // save id
		oout.writeObject(getValue()); // save value
	}

	@Override
	public void validateObject() throws InvalidObjectException {
		if(name == null || name.equals("")) {
			throw new InvalidObjectException("name can't be null or empty");
		}
		if(getId() <= 0) {
			throw new InvalidObjectException("ID can't be negative or zero");
		}
	}
	
}
