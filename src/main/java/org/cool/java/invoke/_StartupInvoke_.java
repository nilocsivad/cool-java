package org.cool.java.invoke;

import java.lang.reflect.Field;

public class _StartupInvoke_ {

	public _StartupInvoke_() {
	}

	public static void main(String[] args) {


		String line = "\r\n-----------------------------------------";

		Object obj = new ClassT();
		Class<?> cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();

		System.out.println(line);
		for (Field field : fields) {
			String f = field.getName();
			System.out.print(f + ", ");
		}

		System.out.println(line);
		for (Field field : fields) {
			String f = field.getName();
			System.out.print("#{" + f + "}, ");
		}

		System.out.println(line);
		for (Field field : fields) {
			String f = field.getName();
			System.out.print("#{item." + f + "}, ");
		}

		System.out.println(line);
		for (Field field : fields) {
			String f = field.getName();
			System.out.println("\t\t\t<if test=\"" + f + " != null and " + f + " != ''\"> AND " + f + " = #{" + f + "} </if>");
		}

		System.out.println(line);
		for (Field field : fields) {
			String f = field.getName();
			System.out.println("\t\t\t<if test=\"" + f + " != null and " + f + " != ''\"> , " + f + " = #{" + f + "} </if>");
		}
		
		System.out.println(line);
		String format = "<isNotEmpty prepend=\",\" property=\"%s\"> %s = #%s# </isNotEmpty>";
		for (Field field : fields) {
			String f = field.getName();
			System.out.println(String.format("\t\t\t" + format, f, f, f));
		}

	}

}

class ClassT {

}
