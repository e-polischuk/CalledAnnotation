package ua.itea.reflect;

import java.lang.annotation.*;

/**
 * @author Polischuk
 * HomeWork_2, Variant_18
 */
@Inherited
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Called {
	public int[] params() default Integer.MIN_VALUE;
}
