package ua.itea.reflect;

import java.lang.reflect.*;

/**
 * @author Polischuk
 * HomeWork_2, Variant_18
 * @param <E>
 */
public class ClassAnalyser<E> {
	
	@SuppressWarnings("unchecked")
	public void printClassWithMethods(String className) {
		try {
			Class<E> cl;
			cl = (Class<E>) Class.forName(className);
			Class<?> supercl = cl.getSuperclass();
		//print superclass
			String supermodif = Modifier.toString(supercl.getModifiers());
			if(supermodif.length() > 0)
				System.out.print(supermodif + " ");
			System.out.println("class " + supercl.getName() + " {");
			printMethods(supercl);
			System.out.println("}\n");
		//print class
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print("class " + className);
			if(supercl != null && supercl != Object.class)
				System.out.print(" extends " + supercl.getName());
			System.out.println(" {");
			printMethods(cl);
			System.out.println("}\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// print superclass methods and class methods
	public void printMethods(Class<?> cl) {
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			Class<?> rt = m.getReturnType();
			String methodName = m.getName();
			System.out.print("	");
			String modifs = Modifier.toString(m.getModifiers());
			if(modifs.length() > 0)
				System.out.print(modifs + " ");
			System.out.print(rt.getName() + " " + methodName + "(");
							
			Class<?>[] pt = m.getParameterTypes();
			for(int i = 0; i < pt.length; i++) {
				if(i > 0)
					System.out.print(", ");
				System.out.print(pt[i].getName());
			}
			System.out.println(");");
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void callAnnotatedMethods(Class cl) {
		try {
			Method[] methods = cl.getDeclaredMethods();
			for(Method m : methods) {
				if(m.isAnnotationPresent(Called.class)) {
					Called an = (Called) m.getAnnotation(Called.class);
	              	int[] params = an.params();
	              	Object obj = cl.newInstance();
	              	if(params[0] > Integer.MIN_VALUE) {
						System.out.println(m.invoke(obj, params));
	                } else System.out.println(m.invoke(obj));
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
	}
}
