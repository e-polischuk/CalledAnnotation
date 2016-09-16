package ua.itea.reflect;

/**
 * @author Polischuk
 * HomeWork_2, Variant_18
 */
public class App {
	
	public static void main(String[] args ) {
    		Class<Queue> queue = Queue.class;
    		ClassAnalyser<Queue> analyser = new ClassAnalyser<>();
    		
    		analyser.printClassWithMethods(queue.getName());
    		
    		System.out.println(queue.getSuperclass().getSimpleName() + " annotated methods are calling: ");
    		analyser.callAnnotatedMethods(queue.getSuperclass());
    		
    		System.out.println("\n" + queue.getSimpleName() + " annotated methods are calling: ");
    		analyser.callAnnotatedMethods(queue);
    	}

}
