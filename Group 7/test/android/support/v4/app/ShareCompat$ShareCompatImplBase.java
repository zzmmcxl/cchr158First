package android.support.v4.app;

import android.support.v4.app.ShareCompat$IntentBuilder;
import android.support.v4.app.ShareCompat$ShareCompatImpl;
import android.view.MenuItem;

class ShareCompat$ShareCompatImplBase implements ShareCompat$ShareCompatImpl {
   private static void withinStyle(StringBuilder var0, CharSequence var1, int var2, int var3) {
      for(; var2 < var3; ++var2) {
         char var4 = var1.charAt(var2);
         if(var4 == 60) {
            var0.append("&lt;");
         } else if(var4 == 62) {
            var0.append("&gt;");
         } else if(var4 == 38) {
            var0.append("&amp;");
         } else if(var4 <= 126 && var4 >= 32) {
            if(var4 != 32) {
               var0.append(var4);
            } else {
               while(var2 + 1 < var3 && var1.charAt(var2 + 1) == 32) {
                  var0.append("&nbsp;");
                  ++var2;
               }

               var0.append(' ');
            }
         } else {
            var0.append("&#" + var4 + ";");
         }
      }

   }

   public void configureMenuItem(MenuItem var1, ShareCompat$IntentBuilder var2) {
      var1.setIntent(var2.createChooserIntent());
   }

   public String escapeHtml(CharSequence var1) {
      StringBuilder var2 = new StringBuilder();
      withinStyle(var2, var1, 0, var1.length());
      return var2.toString();
   }
}
