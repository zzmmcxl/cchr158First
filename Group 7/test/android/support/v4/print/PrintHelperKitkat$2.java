package android.support.v4.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument.Page;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.pdf.PrintedPdfDocument;
import android.support.v4.print.PrintHelperKitkat;
import android.support.v4.print.PrintHelperKitkat$2$1;
import android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;

class PrintHelperKitkat$2 extends PrintDocumentAdapter {
   private PrintAttributes mAttributes;
   Bitmap mBitmap;
   AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;

   PrintHelperKitkat$2(PrintHelperKitkat var1, String var2, Uri var3, PrintHelperKitkat$OnPrintFinishCallback var4, int var5) {
      this.this$0 = var1;
      this.val$jobName = var2;
      this.val$imageFile = var3;
      this.val$callback = var4;
      this.val$fittingMode = var5;
      this.mBitmap = null;
   }

   private void cancelLoad() {
      // $FF: Couldn't be decompiled
   }

   public void onFinish() {
      super.onFinish();
      this.cancelLoad();
      if(this.mLoadBitmap != null) {
         this.mLoadBitmap.cancel(true);
      }

      if(this.val$callback != null) {
         this.val$callback.onFinish();
      }

      if(this.mBitmap != null) {
         this.mBitmap.recycle();
         this.mBitmap = null;
      }

   }

   public void onLayout(PrintAttributes var1, PrintAttributes var2, CancellationSignal var3, LayoutResultCallback var4, Bundle var5) {
      boolean var6 = true;
      this.mAttributes = var2;
      if(var3.isCanceled()) {
         var4.onLayoutCancelled();
      } else if(this.mBitmap != null) {
         PrintDocumentInfo var7 = (new Builder(this.val$jobName)).setContentType(1).setPageCount(1).build();
         if(var2.equals(var1)) {
            var6 = false;
         }

         var4.onLayoutFinished(var7, var6);
      } else {
         this.mLoadBitmap = (new PrintHelperKitkat$2$1(this, var3, var2, var1, var4)).execute(new Uri[0]);
      }
   }

   public void onWrite(PageRange[] var1, ParcelFileDescriptor var2, CancellationSignal var3, WriteResultCallback var4) {
      PrintedPdfDocument var17 = new PrintedPdfDocument(this.this$0.mContext, this.mAttributes);
      Bitmap var16 = PrintHelperKitkat.access$000(this.this$0, this.mBitmap, this.mAttributes.getColorMode());
      boolean var11 = false;

      try {
         var11 = true;
         Page var5 = var17.startPage(1);
         RectF var6 = new RectF(var5.getInfo().getContentRect());
         Matrix var18 = PrintHelperKitkat.access$100(this.this$0, this.mBitmap.getWidth(), this.mBitmap.getHeight(), var6, this.val$fittingMode);
         var5.getCanvas().drawBitmap(var16, var18, (Paint)null);
         var17.finishPage(var5);

         try {
            var17.writeTo(new FileOutputStream(var2.getFileDescriptor()));
            var4.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            var11 = false;
         } catch (IOException var14) {
            Log.e("PrintHelperKitkat", "Error writing printed content", var14);
            var4.onWriteFailed((CharSequence)null);
            var11 = false;
         }
      } finally {
         if(var11) {
            if(var17 != null) {
               var17.close();
            }

            if(var2 != null) {
               try {
                  var2.close();
               } catch (IOException var12) {
                  ;
               }
            }

            if(var16 != this.mBitmap) {
               var16.recycle();
            }

         }
      }

      if(var17 != null) {
         var17.close();
      }

      if(var2 != null) {
         try {
            var2.close();
         } catch (IOException var13) {
            ;
         }
      }

      if(var16 != this.mBitmap) {
         var16.recycle();
      }

   }
}
