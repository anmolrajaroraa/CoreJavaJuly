package com.company.serialization.proxy;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Data implements Serializable{
	
	private static final long serialVersionUID = -3028087100084032670L;
	
	private String data;
	
	public Data(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Data{data="+ data +"}";
	}
	
	//serialization proxy class
	private static class DataProxy implements Serializable{
		
		private static final long serialVersionUID = 7676493883979183511L;

		private String dataProxy;
		
		private static final String PREFIX = "ABC";
		private static final String SUFFIX = "DEFG";
		
		public DataProxy(Data data) {
			this.dataProxy = PREFIX + data.data + SUFFIX;
		}
		
		private Object readResolve() throws InvalidObjectException {
			if(dataProxy.startsWith(PREFIX) && dataProxy.endsWith(SUFFIX)) {
				return new Data(dataProxy.substring(3, dataProxy.length()-4));
			}
			else {
				throw new InvalidObjectException("Data corrupted");
			}
		}
		
	}  // dataProxy class ends here
		
	private Object writeReplace() {
		return new DataProxy(this);
	}
	
	private void readObject(ObjectInputStream oin) throws InvalidObjectException {
		throw new InvalidObjectException("Proxy is not used, something fishy");
	}
	
}



/* Both Data and DataProxy should implement Serializable interface
 * DataProxy should be able to maintain state of Data class (same number of fields should be there)
 * DataProxy is inner private static class, so that other classes can't access it
 * DataProxy constructor should always have one parameter - Data object
 * Data class should always implement writeReplace() returning DataProxy object
 * So that when Data object is serialized, the DataProxy object goes into the stream actually
 * DataProxy class is not visible outside, so it can't be used directly
 * DataProxy should implement readResolve() returning Data object
 * So when DataProxy is deserialized, internally it gets converted to Data object
 * We implement readObject() also to avoid anyone to parse private class and serialize Data object directly
 */
