/**
 * 
 */
package org.cool.java.local;

/**
 * @author Colin
 *
 */
public class _StartupOutput_ {

	/**
	 * 
	 */
	public _StartupOutput_() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for ( int i = 1001; i <= 1008; ++i ) {
			System.out.println( "							<li><a href=\"#\"><img alt=\"\" src=\"\" data-src=\"./images/" + i + ".jpg\" /></a></li>" );
//			System.out.println( "							<li><a href=\"#\" onclick=\"show_img(this)\" onmouseout=\"auto_show(true)\"></a></li>" );
		}
		
		System.out.println( _StartupOutput_.class.getCanonicalName() + "-->" + _StartupOutput_.class.getSimpleName() );
		
		System.out.println( "=================================" );

		boolean b = Boolean.parseBoolean( null );
		System.out.println( b );
	}

}
