package tao.xiao.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotatedClass {

	@EaiFieldName(value = "named")
	public String getName() {
		return "tt";
	}

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		AnnotatedClass clazz = new AnnotatedClass();

		Method[] ms = clazz.getClass().getMethods();

		for (Method m : ms) {
			if (m.isAnnotationPresent(EaiFieldName.class)) {
				EaiFieldName e = m.getAnnotation(EaiFieldName.class);
				System.out.println(e.value());
				System.out.println(m.invoke(clazz));
			}
		}
	}
}
