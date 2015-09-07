/**
 * 
 */
package org.cool.java.local.file;


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
	public static void main(String[] args) throws Exception {
		
		/*
		FileName.getInstance().R2ReplaceSuffix( "D:\\2015-05-28", ".novel" );
		FileName.getInstance().R2Replace( "D:\\2015-05-28", ".noveld", "" ); */
		
		String path = "E:\\javadb\\space-java\\meetya\\src\\main\\java\\com\\defence\\chat\\meetya\\mdl"; 
		
//		FileName.getInstance().R2SerializableNum( path, 1001 );
		FileName.getInstance().R2Replace( path, "Mdl_", "Entity" );
		
		/*
		FileName.getInstance().R2Prefix( path, "p" );
		
		File[] files = FileUtil.ListFiles( path );
		for ( File file : files ) {
			System.out.println( file.getAbsolutePath() );
		}
		
		System.out.println("===============================");
		
		files = FileUtil.listDirs( path );
		for ( File file : files ) {
			System.out.println( file.getAbsolutePath() );
		}*/
	}

}
