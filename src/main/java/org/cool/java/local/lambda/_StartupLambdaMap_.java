/**
 * 
 */
package org.cool.java.local.lambda;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Colin
 *
 */
public class _StartupLambdaMap_ {

	/**
	 * 
	 */
	public _StartupLambdaMap_() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		_StartupLambdaMap_ lambdaMap = new _StartupLambdaMap_();
		
		Map<String, Object> map = new LinkedHashMap<>( 10 );
		map.put( "key1", "value1" );
		map.put( "key2", 10001 );
		map.put( "key3", 100000001L );
		map.put( "key4", 110.110F );
		map.put( "key5", 111110.1110D );
		
		lambdaMap.forEach( map );
		
	}
	
	public void forEach( Map<String, Object> map ) {
		map.forEach( ( key, val ) -> { System.out.println( key + " --> " + val.getClass().getName() + " --> " + val ); } );
	}

}
