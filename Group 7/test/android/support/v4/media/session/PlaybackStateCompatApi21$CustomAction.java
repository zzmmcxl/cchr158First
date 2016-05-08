package android.support.v4.media.session;

import android.media.session.PlaybackState.CustomAction;
import android.media.session.PlaybackState.CustomAction.Builder;
import android.os.Bundle;

final class PlaybackStateCompatApi21$CustomAction {
   public static String getAction(Object var0) {
      return ((CustomAction)var0).getAction();
   }

   public static Bundle getExtras(Object var0) {
      return ((CustomAction)var0).getExtras();
   }

   public static int getIcon(Object var0) {
      return ((CustomAction)var0).getIcon();
   }

   public static CharSequence getName(Object var0) {
      return ((CustomAction)var0).getName();
   }

   public static Object newInstance(String var0, CharSequence var1, int var2, Bundle var3) {
      Builder var4 = new Builder(var0, var1, var2);
      var4.setExtras(var3);
      return var4.build();
   }
}
