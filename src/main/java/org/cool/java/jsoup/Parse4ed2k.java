/**
 * 
 */
package org.cool.java.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * @author Colin
 */
public class Parse4ed2k {

	/**
	 * 
	 */
	public Parse4ed2k() {
	}

	@Test
	public void parse() throws IOException {

		// String url = "http://www.bmhsr.com/index_291382.html";
		//
		// Document doc = Jsoup.connect( url ).timeout( 1000 * 60 ).get();
		// Element tbody = doc.getElementById( "linkPanel-1-1" );
		//
		// Elements trs = tbody.getElementsByTag( "tr" );
		// for ( Element tr : trs ) {
		// String link = tr.getElementsByTag( "a" ).get( 1 ).attr( "href" );
		// System.out.println( link );
		// }



		// String url = "http://www.ed2000.com/ShowFile/29489.html";
		//
		// Document doc = Jsoup.connect( url ).timeout( 1000 * 60 ).get();
		//// System.out.println( doc.html() );
		////
		//// Elements ss = doc.getElementsByTag( "script" );
		//// String script = ss.get( 0 ).html();
		//// System.out.println( script );
		//
		// Elements trs = doc.getElementsByClass( "CommonListArea" ).get( 1
		// ).getElementsByClass( "CommonListCell" );
		// for ( Element tr : trs ) {
		// String link = tr.getElementsByTag( "td" ).get( 1 ).child( 0 ).attr(
		// "href" );
		// System.out.println( link );
		// }



		String url = "http://www.xunleimi.com/huayudianshiju/18062/";

		Document doc = Jsoup.connect(url).timeout(1000 * 60).get();

		Elements its = doc.getElementsByClass("pu1");
		for (Element it : its) {
			String link = it.siblingElements().get(0).attr("href");
			System.out.println(link);
		}

	}

}
