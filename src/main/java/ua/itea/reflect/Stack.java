package ua.itea.reflect;

import java.util.Arrays;

/**
 * @author Polischuk
 * HomeWork_2, Variant_18
 */
public class Stack {
	protected Integer[] stack;
	protected int top;
	
	public Stack() {
		stack = new Integer[10];
		top = -1;
	}
	
	public Stack(int capacity) {
		stack = new Integer[capacity];
		top = -1;
	}
	
	public boolean push(int element) {
		if(top < stack.length - 1) {
			stack[++top] = element;
			return true;
		} else {
			System.out.println("Array overflow!");
			return false;
		}
	}
	
	@Called
	public Integer pop() {
		showEntry();
		if(top >= 0) {
			return stack[top--];
		} else return null;
	}
	
	@Called(params = {7, 9, 3, 13, 12, 23, 546, 435}) //, 45, 23, 123, 12, 56
	public boolean pushSet(int...elements) {
		for(int e : elements) {
			if(!push(e)) return false;
		}
		showEntry();
		return true;
	}
	
	public void showEntry() {
		System.out.println(Arrays.toString(stack));
	}

}
