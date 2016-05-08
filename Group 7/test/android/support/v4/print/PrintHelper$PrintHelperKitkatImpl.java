package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.print.PrintHelper$OnPrintFinishCallback;
import android.support.v4.print.PrintHelper$PrintHelperKitkatImpl$1;
import android.support.v4.print.PrintHelper$PrintHelperKitkatImpl$2;
import android.support.v4.print.PrintHelper$PrintHelperVersionImpl;
import android.support.v4.print.PrintHelperKitkat;
import java.io.FileNotFoundException;

final class PrintHelper$PrintHelperKitkatImpl implements PrintHelper$PrintHelperVersionImpl {
   private final PrintHelperKitkat mPrintHelper;

   PrintHelper$PrintHelperKitkatImpl(Context var1) {
      this.mPrintHelper = new PrintHelperKitkat(var1);
   }

   public int getColorMode() {
      return this.mPrintHelper.getColorMode();
   }

   public int getOrientation() {
      return this.mPrintHelper.getOrientation();
   }

   public int getScaleMode() {
      return this.mPrintHelper.getScaleMode();
   }

   public void printBitmap(String var1, Bitmap var2, PrintHelper$OnPrintFinishCallback var3) {
      PrintHelper$PrintHelperKitkatImpl$1 var4 = null;
      if(var3 != null) {
         var4 = new PrintHelper$PrintHelperKitkatImpl$1(this, var3);
      }

      this.mPrintHelper.printBitmap(var1, (Bitmap)var2, var4);
   }

   public void printBitmap(String var1, Uri var2, PrintHelper$OnPrintFinishCallback var3) throws FileNotFoundException {
      PrintHelper$PrintHelperKitkatImpl$2 var4 = null;
      if(var3 != null) {
         var4 = new PrintHelper$PrintHelperKitkatImpl$2(this, var3);
      }

      this.mPrintHelper.printBitmap(var1, (Uri)var2, var4);
   }

   public void setColorMode(int var1) {
      this.mPrintHelper.setColorMode(var1);
   }

   public void setOrientation(int var1) {
      this.mPrintHelper.setOrientation(var1);
   }

   public void setScaleMode(int var1) {
      this.mPrintHelper.setScaleMode(var1);
   }
}
