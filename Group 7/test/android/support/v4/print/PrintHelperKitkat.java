package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.support.v4.print.PrintHelperKitkat$1;
import android.support.v4.print.PrintHelperKitkat$2;
import android.support.v4.print.PrintHelperKitkat$OnPrintFinishCallback;
import java.io.FileNotFoundException;

class PrintHelperKitkat {
   public static final int COLOR_MODE_COLOR = 2;
   public static final int COLOR_MODE_MONOCHROME = 1;
   private static final String LOG_TAG = "PrintHelperKitkat";
   private static final int MAX_PRINT_SIZE = 3500;
   public static final int ORIENTATION_LANDSCAPE = 1;
   public static final int ORIENTATION_PORTRAIT = 2;
   public static final int SCALE_MODE_FILL = 2;
   public static final int SCALE_MODE_FIT = 1;
   int mColorMode = 2;
   final Context mContext;
   Options mDecodeOptions = null;
   private final Object mLock = new Object();
   int mOrientation = 1;
   int mScaleMode = 2;

   PrintHelperKitkat(Context var1) {
      this.mContext = var1;
   }

   private Bitmap convertBitmapForColorMode(Bitmap var1, int var2) {
      if(var2 != 1) {
         return var1;
      } else {
         Bitmap var3 = Bitmap.createBitmap(var1.getWidth(), var1.getHeight(), Config.ARGB_8888);
         Canvas var4 = new Canvas(var3);
         Paint var5 = new Paint();
         ColorMatrix var6 = new ColorMatrix();
         var6.setSaturation(0.0F);
         var5.setColorFilter(new ColorMatrixColorFilter(var6));
         var4.drawBitmap(var1, 0.0F, 0.0F, var5);
         var4.setBitmap((Bitmap)null);
         return var3;
      }
   }

   private Matrix getMatrix(int var1, int var2, RectF var3, int var4) {
      Matrix var6 = new Matrix();
      float var5 = var3.width() / (float)var1;
      if(var4 == 2) {
         var5 = Math.max(var5, var3.height() / (float)var2);
      } else {
         var5 = Math.min(var5, var3.height() / (float)var2);
      }

      var6.postScale(var5, var5);
      var6.postTranslate((var3.width() - (float)var1 * var5) / 2.0F, (var3.height() - (float)var2 * var5) / 2.0F);
      return var6;
   }

   private Bitmap loadBitmap(Uri param1, Options param2) throws FileNotFoundException {
      // $FF: Couldn't be decompiled
   }

   private Bitmap loadConstrainedBitmap(Uri param1, int param2) throws FileNotFoundException {
      // $FF: Couldn't be decompiled
   }

   public int getColorMode() {
      return this.mColorMode;
   }

   public int getOrientation() {
      return this.mOrientation;
   }

   public int getScaleMode() {
      return this.mScaleMode;
   }

   public void printBitmap(String var1, Bitmap var2, PrintHelperKitkat$OnPrintFinishCallback var3) {
      if(var2 != null) {
         int var4 = this.mScaleMode;
         PrintManager var6 = (PrintManager)this.mContext.getSystemService("print");
         MediaSize var5 = MediaSize.UNKNOWN_PORTRAIT;
         if(var2.getWidth() > var2.getHeight()) {
            var5 = MediaSize.UNKNOWN_LANDSCAPE;
         }

         PrintAttributes var7 = (new Builder()).setMediaSize(var5).setColorMode(this.mColorMode).build();
         var6.print(var1, new PrintHelperKitkat$1(this, var1, var2, var4, var3), var7);
      }
   }

   public void printBitmap(String var1, Uri var2, PrintHelperKitkat$OnPrintFinishCallback var3) throws FileNotFoundException {
      PrintHelperKitkat$2 var5 = new PrintHelperKitkat$2(this, var1, var2, var3, this.mScaleMode);
      PrintManager var6 = (PrintManager)this.mContext.getSystemService("print");
      Builder var4 = new Builder();
      var4.setColorMode(this.mColorMode);
      if(this.mOrientation == 1) {
         var4.setMediaSize(MediaSize.UNKNOWN_LANDSCAPE);
      } else if(this.mOrientation == 2) {
         var4.setMediaSize(MediaSize.UNKNOWN_PORTRAIT);
      }

      var6.print(var1, var5, var4.build());
   }

   public void setColorMode(int var1) {
      this.mColorMode = var1;
   }

   public void setOrientation(int var1) {
      this.mOrientation = var1;
   }

   public void setScaleMode(int var1) {
      this.mScaleMode = var1;
   }
}
