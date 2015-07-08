/**
 * 
 */
package org.cool.java.local.collection;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Colin
 *
 */
public final class _StartupList_ {

	/**
	 * 
	 */
	public _StartupList_() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add( 5 );
		list.add( 8 );
		list.add( 3 );
		list.add( 4 );
		list.add( 9 );
		list.add( 6 );
		list.add( 2 );
		list.add( 1 );
		
//		list.sort( new Comparator<Integer>() {
//			@Override public int compare(Integer o1, Integer o2) {
//				return o2.intValue() - o1;
//			}
//		});
		
		list.sort( ( i1, i2 ) -> i1.intValue() - i2 );
		
		for ( int i : list ) {
			System.out.println( i + " --> " );
		}

	}

}
