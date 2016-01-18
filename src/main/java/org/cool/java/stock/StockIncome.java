/**
 * 
 */
package org.cool.java.stock;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Colin
 */
public class StockIncome {
	
	/**
	 * 
	 */
	public StockIncome() {}
	
	
	private float	buy;
	private int		count;
	private float	loop;
					
					
	@Before
	public void init() {
		
		buy = 0f + 3.123f;
		count = 100 * 44;
		
		loop = 0.001f;
	}
	
	@Test
	public void calcIt() {
		
		float cost = buy * count + 10;
		float area = buy * 1.1f;
		float start = buy * 0.9f;
		
		while ( start <= area ) {
			
			float balance = start * count - cost;
			float get = 0;
			if ( start <= buy ) {
				get = -( ( buy - start ) / buy * 100 );
			}
			else {
				get = ( start - buy ) / buy * 100;
			}
			
			System.out.println( String.format( "%7.3f --> %5.2f%% --> %6.2f", start, get, balance ) );
			
			start += loop;
		}
	}
	
}
