package org.cool.java.datetime;

import java.text.ParseException;
import java.util.Calendar;

public class _StartupDateTime_ {

	public _StartupDateTime_() {
		// TODO Auto-generated constructor stub
	}

	public static void main( String[] args ) throws ParseException {

		long l = Long.valueOf( "1441089934378" );

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis( l );
		
		System.out.println( DateTimeUtil.FMT_DATE_TIME.format( c.getTime() ) );

		// Calendar c = Calendar.getInstance();
		// String dt = DateTimeUtil.FMT_DATE.format( c.getTime() );
		// System.out.println( dt );
		// for ( int i = 0; i < 6; ++ i ) {
		// c.add( Calendar.DAY_OF_MONTH, -1 );
		// dt = DateTimeUtil.FMT_DATE.format( c.getTime() );
		// System.out.println( dt );
		// }

	}

}
