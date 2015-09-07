package org.cool.java.local.datetime;

import java.text.ParseException;

public class _StartupDateTime_ {

	public _StartupDateTime_() {
		// TODO Auto-generated constructor stub
	}

	public static void main( String[] args ) throws ParseException {

		System.out.println( DateTimeUtil.getInstance().calcAge( "1990-02-02" ) );
		System.out.println( DateTimeUtil.getInstance().calcAge( "1990-09-01" ) );
		System.out.println( DateTimeUtil.getInstance().calcAge( "1990-12-02" ) );

	}

}
