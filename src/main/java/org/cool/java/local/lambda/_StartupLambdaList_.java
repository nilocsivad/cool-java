/**
 * 
 */
package org.cool.java.local.lambda;

import java.util.ArrayList;
import java.util.List;

import org.cool.java.local.string.RandomString;

/**
 * @author Colin
 *
 */
public class _StartupLambdaList_ {

	/**
	 * 
	 */
	public _StartupLambdaList_() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		_StartupLambdaList_ lambdaList = new _StartupLambdaList_();
		
		List<String> list = new ArrayList<String>();
		list.add( RandomString.getInstance().Random( true ).Length( 20 ).toString() );
		
		for ( int i = 0; i < 99; ++i ) {
			list.add( RandomString.getInstance().toString() );
		}
		
		list.sort( ( i1, i2 ) -> { return i1.compareToIgnoreCase( i2 ); } );
		
		System.out.println( "===================" );
		lambdaList.count( list );
		System.out.println( "===================" );
		lambdaList.forEach( list );
		System.out.println( "===================" );
		lambdaList.filter2count( list );
		System.out.println( "===================" );
		lambdaList.filter( list );
	}
	
	public void forEach( List<?> list ) {
		list.forEach( System.out::println );
	}
	
	public void count( List<?> list ) {
		System.out.println( list.stream().count() );
	}
	
	public void filter( List<?> list ) {
		list.stream().filter( r -> { 
				char c = r.toString().charAt( 0 ); 
				return ( c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z'); 
			} ).forEach( v -> System.out.println( v ) );
	}
	
	public void filter2count( List<?> list ) {
		long l = list.stream().filter( r -> { 
			char c = r.toString().charAt( 0 ); 
			return ( c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z'); 
		} ).count();
		System.out.println( l );
	}

}
