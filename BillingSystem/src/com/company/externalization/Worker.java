package com.company.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Worker implements Externalizable{
	
	private int id;
	private String name;
	private String gender;
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeObject(name + "xyz");
		out.writeObject("abc" + gender);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = in.readInt();
		
		name = (String) in.readObject();
		if(!name.endsWith("xyz")) throw new IOException("corrupted data");  // data integrity check
		name = name.substring(0, name.length() - 3);
		
		gender = (String) in.readObject();
		if(!gender.startsWith("abc")) throw new IOException("corrupted data");
		gender = gender.substring(3);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
	
}
		