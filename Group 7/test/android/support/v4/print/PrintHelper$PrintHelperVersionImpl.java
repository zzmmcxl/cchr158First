package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.print.PrintHelper$OnPrintFinishCallback;
import java.io.FileNotFoundException;

interface PrintHelper$PrintHelperVersionImpl {
   int getColorMode();

   int getOrientation();

   int getScaleMode();

   void printBitmap(String var1, Bitmap var2, PrintHelper$OnPrintFinishCallback var3);

   void printBitmap(String var1, Uri var2, PrintHelper$OnPrintFinishCallback var3) throws FileNotFoundException;

   void setColorMode(int var1);

   void setOrientation(int var1);

   void setScaleMode(int var1);
}
