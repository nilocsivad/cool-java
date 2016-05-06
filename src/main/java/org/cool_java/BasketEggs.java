/**
 * 
 */
package org.cool_java;


/**
 * @author Colin
 */
public class BasketEggs {
	
	/**
	 * 
	 */
	public BasketEggs() {}
	
	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		
		int max = 10000 * 100; //
		
		boolean[][] eggs = new boolean[ 8 ][ max ];
		for ( int i = 0, l = eggs.length; l > i; ++ i ) {
			
			boolean[] arr = eggs[ i ];
			for ( int k = 0, c = arr.length; c > k; ++ k ) {
				arr[ k ] = false;
			}
		}
		
		for ( int i = 1, l = max / 10; i < l; ++ i ) {
			eggs[ 0 ][ i * 2 + 1 ] = true;
			eggs[ 1 ][ i * 3 ] = true;
			eggs[ 2 ][ i * 4 + 1 ] = true;
			eggs[ 3 ][ i * 5 + 4 ] = true;
			eggs[ 4 ][ i * 6 + 3 ] = true;
			eggs[ 5 ][ i * 7 + 5 ] = true;
			eggs[ 6 ][ i * 8 + 1 ] = true;
			eggs[ 7 ][ i * 9 ] = true;
		}
		
		for ( int i = 1, l = max / 10; i < l; ++ i ) {
			if ( eggs[ 0 ][ i ] &&
					eggs[ 1 ][ i ] &&
					eggs[ 2 ][ i ] &&
					eggs[ 3 ][ i ] &&
					eggs[ 4 ][ i ] &&
					eggs[ 5 ][ i ] &&
					eggs[ 6 ][ i ] &&
					eggs[ 7 ][ i ] ) {
					
				System.out.println( i );
			}
		}
		System.out.println( "=========================" );
		
	}
	
}
