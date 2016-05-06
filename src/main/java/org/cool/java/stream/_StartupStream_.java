/**
 * 
 */
package org.cool.java.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Colin
 *
 */
public class _StartupStream_ {

	private static final String LOG_FILE_PATH = "E:\\log.log";

	/**
	 * 
	 */
	public _StartupStream_() {
		// TODO Auto-generated constructor stub
	}

	private static File logFile = new File(LOG_FILE_PATH);
	private static FileWriter FW;

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		FW = new FileWriter(logFile);

		// String path = "E:\\map.dat";

		// Map<String, Object> map = new LinkedHashMap<>( 10 );
		// map.put( "key1", "value1" );
		// map.put( "key2", 10001 );
		// map.put( "key3", 100000001L );
		// map.put( "key4", 110.110F );
		// map.put( "key5", 111110.1110D );
		//
		// StreamOfObject.getInstance().write2File( map, path );

		// Map< String, Object > map =
		// StreamOfObject.getInstance().readFileData( path );
		// map.forEach( ( key, val ) -> {
		// System.out.println( key + " --> " + val.getClass().getName() + " -->
		// " + val );
		// } );

		httpDownload("http://www.court.gov.cn/downloadPdf/Download?docId=10395033", "E://abcdef.pdf");
	}

	public static void httpDownload(String httpUrl, String saveFile) {

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/28.0");
			InputStream inStream = conn.getInputStream();
			FileOutputStream fs = new FileOutputStream(saveFile);

			byte[] buffer = new byte[1204];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				fs.write(buffer, 0, len);
			}
			inStream.close();
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				FW.write(httpUrl);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
