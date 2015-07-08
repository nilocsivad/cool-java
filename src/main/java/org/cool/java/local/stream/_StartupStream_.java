/**
 * 
 */
package org.cool.java.local.stream;

import java.io.IOException;
import java.util.Map;

/**
 * @author Colin
 *
 */
public class _StartupStream_ {

	/**
	 * 
	 */
	public _StartupStream_() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String path = "E:\\map.dat";
		
//		Map<String, Object> map = new LinkedHashMap<>( 10 );
//		map.put( "key1", "value1" );
//		map.put( "key2", 10001 );
//		map.put( "key3", 100000001L );
//		map.put( "key4", 110.110F );
//		map.put( "key5", 111110.1110D );
//		
//		StreamOfObject.getInstance().write2File( map, path );
		
		Map<String, Object> map = StreamOfObject.getInstance().readFileData( path );
		map.forEach( (key, val) -> { System.out.println( key + " --> " + val.getClass().getName() + " --> " + val ); } );
	}

}
