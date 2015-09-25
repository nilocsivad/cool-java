/**
 * 
 */
package org.cool.java.local.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.cool.java.local.datetime.DateTimeUtil;

/**
 * @author Colin
 *
 */
public final class FileNameUtil {

	/**
	 * 
	 */
	private FileNameUtil() {
		// TODO Auto-generated constructor stub
	}
	
	private static final class FileNameSingleton {
		private static final FileNameUtil INSTANCE = new FileNameUtil();
	}
	
	public static FileNameUtil getInstance() {
		return FileNameSingleton.INSTANCE;
	}
	
	/**
	 * rename to serializable number ( not include subdirectories and subdirectories' files )
	 * @param path the path of folder
	 * @throws Exception 
	 */
	public void R2SerializableNum( final String path ) throws Exception {
		this.R2SerializableNum( path, 1 );
	}
	
	/**
	 * rename to serializable number ( not include subdirectories and subdirectories' files )
	 * @param path the path of folder
	 * @param start index of files
	 * @throws Exception 
	 */
	public void R2SerializableNum( final String path, final int start ) throws Exception {
		this.R2SerializableNum( path, start, false );
	}
	
	/**
	 * rename to serializable number ( not include subdirectories and subdirectories' files )
	 * @param path the path of folder
	 * @param fullWidth whether or not rename to the same width name
	 * @throws Exception 
	 */
	public void R2SerializableNum( final String path, final boolean fullWidth ) throws Exception {
		this.R2SerializableNum( path, 1, false );
	}
	
	/**
	 * rename to serializable number ( not include subdirectories and subdirectories' files )
	 * @param path the path of folder
	 * @param start index of files
	 * @param fullWidth whether or not rename to the same width name
	 * @throws Exception 
	 */
	public void R2SerializableNum( final String path, final int start, final boolean fullWidth ) throws Exception {
		
		File[] files = FileUtil.ListFiles( path );
		
		int len = files.length;
		long total = len + start;
		int maxLen = Long.toString( total ).length();
		
		int begin = start;
		for ( File file : files ) {
			String name = file.getName();
			int idx = name.lastIndexOf(".");
			String new_name = this.CalcSuffix( fullWidth, maxLen, begin + "" ) + ( idx > 0 ? name.substring( idx ) : "" );
			file.renameTo( new File( file.getParentFile(), new_name ) );
			begin++;
		}
	}
	
	private String CalcSuffix( final boolean fullWidth, final int maxLen, final String content ) {
		if ( fullWidth ) {
			int len = content.length();
			StringBuilder buf = new StringBuilder();
			for ( ; maxLen > len; ++len ) buf.append( "0" );
			return buf + content;
		} else {
			return content;
		}
	}
	
	public void R2UUID( final String path ) throws Exception {
		File[] files = FileUtil.ListFiles( path );
		for ( File file : files ) {
			String name = file.getName();
			int idx = name.lastIndexOf(".");
			String new_name = UUID.randomUUID() + ( idx > 0 ? name.substring( idx ) : "" );
			file.renameTo( new File( file.getParentFile(), new_name ) );
		}
	}
	
	public void R2DateTimeUUID( final String path ) throws Exception {
		File[] files = FileUtil.ListFiles( path );
		for ( File file : files ) {
			String name = file.getName();
			int idx = name.lastIndexOf(".");
			String new_name = DateTimeUtil.getInstance().getDateTime() + "_" + UUID.randomUUID() + ( idx > 0 ? name.substring( idx ) : "" );
			file.renameTo( new File( file.getParentFile(), new_name ) );
		}
	}
	
	public void R2Prefix( final String path, final String prefix ) throws Exception {
		File[] files = FileUtil.ListFiles( path );
		String _prefix = prefix == null ? "" : prefix;
		for ( File file : files ) {
			file.renameTo( new File( file.getParentFile(), _prefix + file.getName() ) );
		}
	}
	
	public void R2Suffix( final String path, final String suffix ) throws Exception {
		File[] files = FileUtil.ListFiles( path );
		for ( File file : files ) {
			if ( !file.getName().endsWith( suffix ) )
				file.renameTo( new File( file.getParentFile(), file.getName() + suffix ) );
		}
	}
	
	public void R2ReplaceSuffix( final String path, final String suffix ) throws Exception {
		File[] files = FileUtil.ListFiles( path );
		for ( File file : files ) {
			if ( !file.getName().endsWith( suffix ) ) {
				String name = file.getName();
				int idx = name.lastIndexOf(".");
				String _final = name.substring( 0, idx ) + suffix;
				file.renameTo( new File( file.getParentFile(), _final ) );
			}
		}
	}
	
	public void R2Replace( final String path, final String source, final String to ) throws Exception {
		File[] files = FileUtil.List( path );
		for ( File file : files ) {
			file.renameTo( new File( file.getParentFile(), file.getName().replace( source, to ) ) );
		}
	}
	
	public static void css_file_min(File file) throws IOException {
		String random = (Math.random() + "").substring(3, 8);
		File newFile = new File(file.getParentFile().getAbsoluteFile() + "\\" + random + file.getName());
		newFile.createNewFile();
		InputStream is = new FileInputStream(file);
		byte[] buf = new byte[is.available()];
		is.read(buf);
		is.close();
		String content = new String(buf);
		content = content.replaceAll("\r\n", "");
		content = content.replaceAll("\t", " ");
		content = content.replaceAll("@CHARSET \"UTF-8\";", "@CHARSET \"UTF-8\";\r\n");
		content = content.replaceAll("}", "}\r\n");
		content = content.replaceAll(": ", ":");
		content = content.replaceAll("; ", ";");
		FileWriter fw = new FileWriter(newFile);
		fw.write(content);
		fw.close();
		file.delete();
		newFile.renameTo(file);
	}

}
