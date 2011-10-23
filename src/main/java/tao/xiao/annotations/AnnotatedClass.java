package tao.xiao.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class AnnotatedClass implements AnnotatedInterface {

	public String getName() {
		return "tt";
	}

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		AnnotatedClass clazz = new AnnotatedClass();

		System.out.println("ddd");
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		CollectionUtils.addAll(clazzs, clazz.getClass().getInterfaces());
		clazzs.add(clazz.getClass().getSuperclass());
		clazzs.add(clazz.getClass());

		for (Class<?> cla : clazzs) {
			Method[] ms = cla.getMethods();

			for (Method m : ms) {
				if (m.isAnnotationPresent(EaiFieldName.class)) {
					EaiFieldName e = m.getAnnotation(EaiFieldName.class);
					System.out.println(e.value());
					System.out.println(m.invoke(clazz));
				}
			}
		}
	}
}
