/**
 * 
 */
package org.cool.java.file;

import java.io.File;
import java.util.Arrays;

/**
 * @author Colin
 *
 */
public final class FileUtil {

	/**
	 * 
	 */
	private FileUtil() {
		// TODO Auto-generated constructor stub
	}
	
	private static final class FileUtilSingleton {
		private static final FileUtil INSTANCE = new FileUtil();
	}
	
	public static FileUtil getInstance() {
		return FileUtilSingleton.INSTANCE;
	}
	
	/**
	 * list the files under folder ( only files, no subdirectories and subdirectories' files )
	 * @param path the path of folder
	 * @return files
	 * @throws Exception 
	 */
	public static File[] List( final String path ) throws Exception {
		File dir = new File( path );
		if ( !dir.exists() || dir.isFile() ) {
			throw new Exception( path + " not exists or is a file!" );
		}
		File[] files = dir.listFiles();
		Arrays.sort( files, ( f1, f2 ) -> ( f1.getName().compareToIgnoreCase( f2.getName() ) ) );
		return files;
	}
	
	/**
	 * list the files under folder ( only files, no subdirectories and subdirectories' files )
	 * @param path the path of folder
	 * @return files
	 * @throws Exception 
	 */
	public static File[] ListFiles( final String path ) throws Exception {
		File dir = new File( path );
		if ( !dir.exists() || dir.isFile() ) {
			throw new Exception( path + " not exists or is a file!" );
		}
		File[] files = dir.listFiles( f -> f.isFile() );
		/*
		Arrays.sort( files, ( f1, f2 ) -> ( f1.getName().toLowerCase().compareTo( f2.getName().toLowerCase() ) ) );*/
		Arrays.sort( files, ( f1, f2 ) -> ( f1.getName().compareToIgnoreCase( f2.getName() ) ) );
		return files;
		/*
		return dir.listFiles(new FileFilter() {
					@Override public boolean accept(File f) {
						return f.isFile();
					}
				});*/
	}
	
	/**
	 * list the folders under folder ( only one layout, no subdirectories' files )
	 * @param path the path of folder
	 * @return files
	 * @throws Exception 
	 */
	public static File[] listDirs( final String path ) throws Exception {
		File dir = new File( path );
		if ( !dir.exists() || dir.isFile() ) {
			throw new Exception( path + " not exists or is a file!" );
		}
		File[] files = dir.listFiles( f -> f.isDirectory() );
		/*
		Arrays.sort( files, ( f1, f2 ) -> ( f1.getName().toLowerCase().compareTo( f2.getName().toLowerCase() ) ) );*/
		Arrays.sort( files, ( f1, f2 ) -> ( f1.getName().compareToIgnoreCase( f2.getName() ) ) );
		return files;
		/*
		return dir.listFiles(new FileFilter() {
					@Override public boolean accept(File f) {
						return f.isDirectory();
					}
				});*/
	}

}
