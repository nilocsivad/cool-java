/**
 * 
 */
package org.cool.java.local.jsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * @author Colin
 */
public class _StartupJSoup {
	
	private static final String BASE_URI = "http://www.baidu.com";
	
	
	/**
	 * 
	 */
	public _StartupJSoup() {}
	
	@Test
	public void generateHtmlFromTemplate() throws IOException {
		
		InputStream input = this.getClass().getResourceAsStream( "/org/cool/java/local/jsoup/template.html" );
		// System.out.println( "available = " + input.available() );
		
		Document doc = Jsoup.parse( input, "UTF-8", BASE_URI );
		input.close();
		
		doc.title( String.format( "测试标题 --- %d", System.currentTimeMillis() ) );
		
		Element box = doc.getElementById( "wrap-box" );
		
		int max = new Random().nextInt( 10 ) + 1000;
		for ( int i = 1000; i < max; ++ i ) {
			box.append( String.format( "<p>%d --- %s</p>\r\n", i, UUID.randomUUID() ) );
		}
		
		Elements previous = doc.getElementsByClass( "previous" );
		previous.attr( "href", "1" );
		Elements next = doc.getElementsByClass( "next" );
		next.attr( "href", "2" );
		
		String html = doc.outerHtml();
		System.out.println( html );
		
		FileWriter writer = new FileWriter( new File( "D:\\fetch-novel", "hello.html" ) );
		writer.write( html );
		writer.close();
		
	}
	
}
