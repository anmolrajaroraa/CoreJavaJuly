interface Pair<K,V>{
	public K getKey();
	public V getValue();
}

class OrderedPair<K,V> implements Pair<K,V>{
	
	private K key;
	private V value;
	
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}
	
}

public class GenericsDemo2 {

	public static void main(String[] args) {
		
		OrderedPair<String, Integer> orderedPair = new OrderedPair<>("Even", 8);
		// auto-boxing - object of primitive type will automatically be created
		Pair<String, String> orderedPair2 = new OrderedPair<>("hello", "world");  // upcasting
		Pair<String, NewBox<Integer> > ordererPair3 = new OrderedPair<>("primes", new NewBox<>());
		// You can substitute type parameter (T,K,V) with a class name, interface name , array, or with another type parameterized class or interface
	}

}
