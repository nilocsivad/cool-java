package org.cool.java.local.invoke;

import java.lang.reflect.InvocationTargetException;

public class _StartupInvoke_ {

	public _StartupInvoke_() {
		// TODO Auto-generated constructor stub
	}

	public static void main( String[] args ) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InvocationTargetException, NoSuchMethodException {

		Student student = new Student();
		System.out.println( student );
		
//		Student.class.getClass().getDeclaredField( "name" ).set( student, Math.random() + "" );;
//		student.getClass().getDeclaredField( "name" ).set( student, Math.random() + "" );;
		System.out.println( student );
		
//		System.out.println( student.getClass().getDeclaredField( "name" ).get( student ) );
		
//		student.getClass().getDeclaredField( "name" ).set( student, Math.random() + "" );;
		System.out.println( student );
		
//		Student.class.getClass().getDeclaredMethod( "setName", String.class ).invoke( student, Math.random() + "" );
		student.getClass().getDeclaredMethod( "setName", String.class ).invoke( student, Math.random() + "" );
		System.out.println( student );
		
	}

}

class Student {
	private String name;

	@Override
	public String toString() {
		return "Name: " + name;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName( String name ) {
		this.name = name;
	}

}
