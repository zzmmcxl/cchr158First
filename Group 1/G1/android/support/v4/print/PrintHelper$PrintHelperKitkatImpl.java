package android.support.v4.print;

import java.io.FileNotFoundException;
import android.net.Uri;
import android.graphics.Bitmap;
import android.content.Context;

private static final class PrintHelperKitkatImpl implements PrintHelperVersionImpl
{
    private final PrintHelperKitkat mPrintHelper;
    
    PrintHelperKitkatImpl(final Context context) {
        super();
        this.mPrintHelper = new PrintHelperKitkat(context);
    }
    
    @Override
    public int getColorMode() {
        return mPrintHelper.getColorMode();
    }
    
    @Override
    public int getOrientation() {
        return mPrintHelper.getOrientation();
    }
    
    @Override
    public int getScaleMode() {
        return mPrintHelper.getScaleMode();
    }
    
    @Override
    public void printBitmap(final String s, final Bitmap bitmap, final OnPrintFinishCallback onPrintFinishCallback) {
        Object o = null;
        if (onPrintFinishCallback != null) {
            o = new PrintHelperKitkat.OnPrintFinishCallback() {
                final /* synthetic */ PrintHelperKitkatImpl this$0;
                final /* synthetic */ PrintHelper.OnPrintFinishCallback val$callback;
                
                PrintHelper$PrintHelperKitkatImpl$1() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onFinish() {
                    onPrintFinishCallback.onFinish();
                }
            };
        }
        mPrintHelper.printBitmap(s, bitmap, (PrintHelperKitkat.OnPrintFinishCallback)o);
    }
    
    @Override
    public void printBitmap(final String s, final Uri uri, final OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        Object o = null;
        if (onPrintFinishCallback != null) {
            o = new PrintHelperKitkat.OnPrintFinishCallback() {
                final /* synthetic */ PrintHelperKitkatImpl this$0;
                final /* synthetic */ PrintHelper.OnPrintFinishCallback val$callback;
                
                PrintHelper$PrintHelperKitkatImpl$2() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onFinish() {
                    onPrintFinishCallback.onFinish();
                }
            };
        }
        mPrintHelper.printBitmap(s, uri, (PrintHelperKitkat.OnPrintFinishCallback)o);
    }
    
    @Override
    public void setColorMode(final int colorMode) {
        mPrintHelper.setColorMode(colorMode);
    }
    
    @Override
    public void setOrientation(final int orientation) {
        mPrintHelper.setOrientation(orientation);
    }
    
    @Override
    public void setScaleMode(final int scaleMode) {
        mPrintHelper.setScaleMode(scaleMode);
    }
}
