/**
 * 
 */
package org.cool.java.local.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Colin
 *
 */
public final class DateTimeUtil {

	/**
	 * 
	 */
	public DateTimeUtil() {
		// TODO Auto-generated constructor stub
	}
	
	private static final class DateTimeUtilSingleton {
		private static final DateTimeUtil INSTANCE = new DateTimeUtil();
	}
	
	public static DateTimeUtil getInstance() {
		return DateTimeUtilSingleton.INSTANCE;
	}
	
	public static final String STR_FMT_DATE = "yyyy-MM-dd";
	public static final DateFormat FMT_DATE = new SimpleDateFormat( STR_FMT_DATE );
	
	public static final String STR_FMT_TIME = "HH:mm:ss";
	public static final DateFormat FMT_TIME = new SimpleDateFormat( STR_FMT_TIME );
	
	public static final String STR_FMT_MILLIS = "S";
	public static final DateFormat FMT_MILLIS = new SimpleDateFormat( STR_FMT_MILLIS );
	
	public static final String STR_FMT_DATE_TIME = STR_FMT_DATE + " " + STR_FMT_TIME;
	public static final DateFormat FMT_DATE_TIME = new SimpleDateFormat( STR_FMT_DATE_TIME );
	
	public static final String STR_FMT_DATE_TIME_MILLIS = STR_FMT_DATE + " " + STR_FMT_TIME + " " + STR_FMT_MILLIS;
	public static final DateFormat FMT_DATE_TIME_MILLIS = new SimpleDateFormat( STR_FMT_DATE_TIME_MILLIS );
	
	public static final String STR_FMT_NAMED_DATE_TIME = STR_FMT_DATE + "_" + STR_FMT_TIME;
	public static final DateFormat FMT_NAMED_DATE_TIME = new SimpleDateFormat( STR_FMT_NAMED_DATE_TIME );
	
	public static final String STR_FMT_NAMED_DATE_TIME_MILLIS = STR_FMT_DATE + "_" + STR_FMT_TIME + "_" + STR_FMT_MILLIS;
	public static final DateFormat FMT_NAMED_DATE_TIME_MILLIS = new SimpleDateFormat( STR_FMT_NAMED_DATE_TIME_MILLIS );
	
	public String getDate() {
		return FMT_DATE.format( new Date() );
	}
	
	public String getTime() {
		return FMT_TIME.format( new Date() );
	}
	
	public String getMillis() {
		return FMT_MILLIS.format( new Date() );
	}
	
	public String getDateTime() {
		return FMT_DATE_TIME.format( new Date() );
	}
	
	public String getDateTimeMillis() {
		return FMT_DATE_TIME_MILLIS.format( new Date() );
	}
	
	public String getNamedDateTime() {
		return FMT_NAMED_DATE_TIME.format( new Date() );
	}
	
	public String getNamedDateTimeMillis() {
		return FMT_NAMED_DATE_TIME_MILLIS.format( new Date() );
	}

}
