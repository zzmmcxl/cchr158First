package android.support.v4.app;

import android.app.Activity;
import android.media.session.MediaController;
import android.support.v4.app.ActivityCompat21$SharedElementCallback21;
import android.support.v4.app.ActivityCompat21$SharedElementCallbackImpl;

class ActivityCompat21 {
   private static android.app.SharedElementCallback createCallback(ActivityCompat21$SharedElementCallback21 var0) {
      ActivityCompat21$SharedElementCallbackImpl var1 = null;
      if(var0 != null) {
         var1 = new ActivityCompat21$SharedElementCallbackImpl(var0);
      }

      return var1;
   }

   public static void finishAfterTransition(Activity var0) {
      var0.finishAfterTransition();
   }

   public static void postponeEnterTransition(Activity var0) {
      var0.postponeEnterTransition();
   }

   public static void setEnterSharedElementCallback(Activity var0, ActivityCompat21$SharedElementCallback21 var1) {
      var0.setEnterSharedElementCallback(createCallback(var1));
   }

   public static void setExitSharedElementCallback(Activity var0, ActivityCompat21$SharedElementCallback21 var1) {
      var0.setExitSharedElementCallback(createCallback(var1));
   }

   public static void setMediaController(Activity var0, Object var1) {
      var0.setMediaController((MediaController)var1);
   }

   public static void startPostponedEnterTransition(Activity var0) {
      var0.startPostponedEnterTransition();
   }
}
