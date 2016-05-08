package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.print.PrintHelper$OnPrintFinishCallback;
import android.support.v4.print.PrintHelper$PrintHelperVersionImpl;

final class PrintHelper$PrintHelperStubImpl implements PrintHelper$PrintHelperVersionImpl {
   int mColorMode;
   int mOrientation;
   int mScaleMode;

   private PrintHelper$PrintHelperStubImpl() {
      this.mScaleMode = 2;
      this.mColorMode = 2;
      this.mOrientation = 1;
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

   public void printBitmap(String var1, Bitmap var2, PrintHelper$OnPrintFinishCallback var3) {
   }

   public void printBitmap(String var1, Uri var2, PrintHelper$OnPrintFinishCallback var3) {
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
