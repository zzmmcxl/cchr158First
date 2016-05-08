package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.support.v4.print.PrintHelperKitkat;
import android.support.v4.print.PrintHelperKitkat$2;
import android.support.v4.print.PrintHelperKitkat$2$1$1;
import java.io.FileNotFoundException;

class PrintHelperKitkat$2$1 extends AsyncTask<Uri, Boolean, Bitmap> {
   PrintHelperKitkat$2$1(PrintHelperKitkat$2 var1, CancellationSignal var2, PrintAttributes var3, PrintAttributes var4, LayoutResultCallback var5) {
      this.this$1 = var1;
      this.val$cancellationSignal = var2;
      this.val$newPrintAttributes = var3;
      this.val$oldPrintAttributes = var4;
      this.val$layoutResultCallback = var5;
   }

   protected Bitmap doInBackground(Uri... var1) {
      try {
         Bitmap var3 = PrintHelperKitkat.access$300(this.this$1.this$0, this.this$1.val$imageFile, 3500);
         return var3;
      } catch (FileNotFoundException var2) {
         return null;
      }
   }

   protected void onCancelled(Bitmap var1) {
      this.val$layoutResultCallback.onLayoutCancelled();
      this.this$1.mLoadBitmap = null;
   }

   protected void onPostExecute(Bitmap var1) {
      boolean var2 = true;
      super.onPostExecute(var1);
      this.this$1.mBitmap = var1;
      if(var1 != null) {
         PrintDocumentInfo var3 = (new Builder(this.this$1.val$jobName)).setContentType(1).setPageCount(1).build();
         if(this.val$newPrintAttributes.equals(this.val$oldPrintAttributes)) {
            var2 = false;
         }

         this.val$layoutResultCallback.onLayoutFinished(var3, var2);
      } else {
         this.val$layoutResultCallback.onLayoutFailed((CharSequence)null);
      }

      this.this$1.mLoadBitmap = null;
   }

   protected void onPreExecute() {
      this.val$cancellationSignal.setOnCancelListener(new PrintHelperKitkat$2$1$1(this));
   }
}
