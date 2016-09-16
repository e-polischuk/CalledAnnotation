package ua.itea.reflect;

/**
 * @author Polischuk
 * HomeWork_2, Variant_18
 */
public class Queue extends Stack {
	
	public Queue() {}
	
	public Queue(int capacity) {
		super(capacity);
		
	}
	
	@Called
	public Integer pop() {
		showEntry();
		
		if(top >= 0) {
			Integer element = stack[0];
			for(int i = 0; i < top; i++) {
				stack[i] = stack[i + 1];
			}
			stack[top--] = null;
			
			return element;
			
		} else
			return null;
			
	}

}
