package FoxitEMBSDK;

import com.foxitsample.exception.*;

public class EMBJavaSupport {
	
	public final static int EMBJavaSupport_RESULT_SUCCESS = 0;
	public final static int EMBJavaSupport_RESULT_MEMORY = 1;
	public final static int EMBJavaSupport_RESULT_ERROR = -1;	
	
	//Define interfaces of EMB SDK. Users can define them according to their own requirement.
	//Users can get descriptions of these interfaces from FoxitEMBSDK Help Document.
	///////////////////
	static{
		System.loadLibrary("fpdfembedsdk");
	}
	
	////////////////////
	//Document Module
	public static native int FPDFDocLoad(int fileRead, String password) throws parameterException, invalidLicenseException, fileAccessException, formatException, memoryException, passwordException, errorException;
	public static native void FPDFDocClose(int document) throws parameterException;	  
	public static native int FPDFDocGetPageCount(int document) throws parameterException, memoryException;
	public static native int FPDFPageLoad(int document, int index) throws parameterException;
	public static native void FPDFPageClose(int page) throws parameterException;
	public static native int FPDFPageStartParse(int page, int text_only, int pauseHandler) throws toBeContinuedException, parameterException, statusException, memoryException;
	public static native int FPDFPageContinueParse(int page, int pauseHandler) throws toBeContinuedException, parameterException, statusException, memoryException;
	public static native float FPDFPageGetSizeX(int pageHandle) throws parameterException;
	public static native float FPDFPageGetSizeY(int pageHandle) throws parameterException;
	
	public class Rectangle
	{
		public int		left;
		public int		top;
		public int		right;
		public int		bottom;

	} 
	
	public class RectangleF
	{
		public float		left;
		public float		top;
		public float		right;
		public float		bottom;

	} 
	
	public class PointF
	{
		public float x;
		public float y;
	}



	public static native void FPDFPagePageToDeviceRectF(int page, int start_x, int start_y, 
			int size_x, int size_y, int rotate, RectangleF rect);

	////////////////////
	//View Module
	public static native int FPDFRenderPageStart(int dib, int page, int start_x, int start_y, 
											int size_x, int size_y, int rotate, int flags,
											Rectangle clip, int pauseHandler) throws toBeContinuedException, parameterException, memoryException, statusException, errorException;
	public static native int FPDFRenderPageContinue(int page, int pauseHandler) throws toBeContinuedException, parameterException, memoryException, statusException, errorException;
	public static native int FPDFPageDeviceToPageRect(int page, int start_x, int start_y, 
											int size_x, int size_y, int rotate, Rectangle rect);

	///////////////////
	//Test Module
	public static native int FPDFTextLoadPage(int page);
	public static native void FPDFTextCloseTextPage(int textPage);
	public static native int FPDFTextFindStart(int textPage, String findWhat, long flags, int startIndex);
	public static native int FPDFTextFindNext(int handle);
	public static native int FPDFTextFindPrev(int handle);
	public static native int FPDFTextGetSchResultIndex(int handle);
	public static native int FPDFTextGetSchCount(int handle);
	public static native int FPDFTextFindClose(int handle);
	public static native int FPDFTextCountRects(int textPage, int start, int count);
	public static native int FPDFTextCountChars(int textpage);
	public static native RectangleF FPDFTextGetRect(int textpage, int index);
	public static native String FPDFTextGetText(int textpage, int start, int count);
	////////////////////
	//Base data Module

	public static native void FSInitLibrary(int hInstance);
	public static native void FSDestroyLibrary();
	
	public static native void FSMemInitFixedMemory(int size) throws parameterException, invalidLicenseException;
	public static native void FSMemDestroyMemory();
	
	public static native int FSBitmapCreate(int width, int height, int format, byte[] buffer, int stride) throws parameterException, memoryException, errorException;
	public static native void FSBitmapDestroy(int dib) throws parameterException;
	public static native byte[] FSBitmapGetBuffer(int dib) throws parameterException;
	public static native void FSBitmapFillColor(int dib, int argb) throws parameterException;	
	
	public static native void FSFontLoadGBCMap();
	public static native void FSFontLoadGBExtCMap();
	public static native void FSFontLoadCNSCMap();
	public static native void FSFontLoadKoreaCMap();
	public static native void FSFontLoadJapanCMap();
	public static native void FSFontLoadJapanExtCMap();
	public static native void FSLoadJbig2Decoder();
	public static native void FSLoadJpeg2000Decoder();
	
	public static native int FSFileReadAlloc(String filePath) throws memoryException;
	public static native void FSFileReadRelease(int fileRead);
	
	public static native int FSPauseHandlerAlloc() throws memoryException;
	public static native void FSPauseHandlerRelease(int pauseHandler);
	
	public static native void FPDFPagePageToDevicePointF(int page, int start_x,int start_y, int size_x, int size_y, int rotate, PointF point);
	

	public static native void FSUnlock(String sn,String code);
	
	public static native void FSSetFileFontmap(String filepath) throws parameterException;	
}