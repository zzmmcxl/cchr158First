package android.support.v4.print;

import android.os.CancellationSignal$OnCancelListener;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo$Builder;
import java.io.FileNotFoundException;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.os.CancellationSignal;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;

class PrintHelperKitkat$2$1 extends AsyncTask<Uri, Boolean, Bitmap> {
    final /* synthetic */ PrintHelperKitkat$2 this$1;
    final /* synthetic */ CancellationSignal val$cancellationSignal;
    final /* synthetic */ PrintDocumentAdapter$LayoutResultCallback val$layoutResultCallback;
    final /* synthetic */ PrintAttributes val$newPrintAttributes;
    final /* synthetic */ PrintAttributes val$oldPrintAttributes;
    
    PrintHelperKitkat$2$1(final PrintHelperKitkat$2 this$1, final CancellationSignal val$cancellationSignal, final PrintAttributes val$newPrintAttributes, final PrintAttributes val$oldPrintAttributes, final PrintDocumentAdapter$LayoutResultCallback val$layoutResultCallback) {
        this$1 = this$1;
        val$cancellationSignal = val$cancellationSignal;
        val$newPrintAttributes = val$newPrintAttributes;
        val$oldPrintAttributes = val$oldPrintAttributes;
        val$layoutResultCallback = val$layoutResultCallback;
        super();
    }
    
    protected Bitmap doInBackground(final Uri... array) {
        try {
            return PrintHelperKitkat.access$300(this$0, val$imageFile, 3500);
        }
        catch (FileNotFoundException ex) {
            return null;
        }
    }
    
    protected /* bridge */ Object doInBackground(final Object[] array) {
        return this.doInBackground((Uri[])array);
    }
    
    protected void onCancelled(final Bitmap bitmap) {
        val$layoutResultCallback.onLayoutCancelled();
        mLoadBitmap = null;
    }
    
    protected /* bridge */ void onCancelled(final Object o) {
        this.onCancelled((Bitmap)o);
    }
    
    protected void onPostExecute(final Bitmap mBitmap) {
        int n = 1;
        super.onPostExecute((Object)mBitmap);
        this$1.mBitmap = mBitmap;
        if (mBitmap != null) {
            final PrintDocumentInfo build = new PrintDocumentInfo$Builder(val$jobName).setContentType(n).setPageCount(n).build();
            if (val$newPrintAttributes.equals((Object)val$oldPrintAttributes)) {
                n = 0;
            }
            val$layoutResultCallback.onLayoutFinished(build, (boolean)(n != 0));
        }
        else {
            val$layoutResultCallback.onLayoutFailed((CharSequence)null);
        }
        mLoadBitmap = null;
    }
    
    protected /* bridge */ void onPostExecute(final Object o) {
        this.onPostExecute((Bitmap)o);
    }
    
    protected void onPreExecute() {
        val$cancellationSignal.setOnCancelListener((CancellationSignal$OnCancelListener)new CancellationSignal$OnCancelListener() {
            final /* synthetic */ PrintHelperKitkat$2$1 this$2;
            
            PrintHelperKitkat$2$1$1() {
                this$2 = this$2;
                super();
            }
            
            public void onCancel() {
                PrintHelperKitkat$2.access$200(this$1);
                this$2.cancel(false);
            }
        });
    }
}