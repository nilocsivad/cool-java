/**
 * 
 */
package org.cool.java.local.file;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Colin
 *
 */
public final class _StartupFile_ {

	/**
	 * 
	 */
	public _StartupFile_() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		/*
		 * FileName.getInstance().R2ReplaceSuffix( "D:\\2015-05-28", ".novel" ); FileName.getInstance().R2Replace( "D:\\2015-05-28", ".noveld", "" );
		 */

		String suffix = "txt";
		String path = String.format( "E:\\%s.%s", "__说明__", suffix );
		RandomAccessFile aFile = new RandomAccessFile( path, "rw" );
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate( 96 );

		int byteReade = inChannel.read( buf );
		while ( byteReade != -1 ) {
			buf.flip();
			// int len = buf.remaining();
			// System.out.println( new String( buf.array(), 0, len, "UTF-8" ) );
			while ( buf.hasRemaining() ) {
				System.out.print( ( char ) buf.get() );
			}
			System.out.println();
			buf.clear();
			byteReade = inChannel.read( buf );
		}

		aFile.close();

		// String suffix = "mp4";
		// String url = "http://182.92.228.160:80/defence/meetya/chatfiles/b5af52d0-4f8c-11e5-a0b4-ed168590d78d";
		// String path = String.format( "E:\\tmp\\meetya\\%d-%g.%s", System.currentTimeMillis(), Math.random(), suffix );
		// FileDownloadUtil.getInstance().download( url, path );

		// String path = "E:\\javadb\\space-java\\meetya\\src\\main\\java\\com\\defence\\chat\\meetya\\mdl";

		// FileName.getInstance().R2SerializableNum( path, 1001 );
		// FileNameUtil.getInstance().R2Replace( path, "Mdl_", "Entity" );

		// FileName.getInstance().R2Prefix( path, "p" );
		// File[] files = FileUtil.ListFiles( path );
		// for ( File file : files ) {
		// System.out.println( file.getAbsolutePath() );
		// }
		// System.out.println("===============================");
		// files = FileUtil.listDirs( path );
		// for ( File file : files ) {
		// System.out.println( file.getAbsolutePath() );
		// }
	}

}
