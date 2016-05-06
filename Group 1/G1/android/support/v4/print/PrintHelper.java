package android.support.v4.print;

import java.io.FileNotFoundException;
import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Build$VERSION;
import android.content.Context;

public final class PrintHelper
{
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    PrintHelperVersionImpl mImpl;
    
    public PrintHelper(final Context context) {
        super();
        if (systemSupportsPrint()) {
            mImpl = (PrintHelperVersionImpl)new PrintHelperKitkatImpl(context);
            return;
        }
        mImpl = (PrintHelperVersionImpl)new PrintHelperStubImpl();
    }
    
    public static boolean systemSupportsPrint() {
        return Build$VERSION.SDK_INT >= 19;
    }
    
    public int getColorMode() {
        return mImpl.getColorMode();
    }
    
    public int getOrientation() {
        return mImpl.getOrientation();
    }
    
    public int getScaleMode() {
        return mImpl.getScaleMode();
    }
    
    public void printBitmap(final String s, final Bitmap bitmap) {
        mImpl.printBitmap(s, bitmap, null);
    }
    
    public void printBitmap(final String s, final Bitmap bitmap, final OnPrintFinishCallback onPrintFinishCallback) {
        mImpl.printBitmap(s, bitmap, onPrintFinishCallback);
    }
    
    public void printBitmap(final String s, final Uri uri) throws FileNotFoundException {
        mImpl.printBitmap(s, uri, null);
    }
    
    public void printBitmap(final String s, final Uri uri, final OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        mImpl.printBitmap(s, uri, onPrintFinishCallback);
    }
    
    public void setColorMode(final int colorMode) {
        mImpl.setColorMode(colorMode);
    }
    
    public void setOrientation(final int orientation) {
        mImpl.setOrientation(orientation);
    }
    
    public void setScaleMode(final int scaleMode) {
        mImpl.setScaleMode(scaleMode);
    }
}
