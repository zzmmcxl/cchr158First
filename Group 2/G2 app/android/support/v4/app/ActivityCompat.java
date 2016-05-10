package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat21;
import android.support.v4.app.ActivityCompatHoneycomb;
import android.support.v4.app.ActivityCompatJB;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
   private static ActivityCompat21.SharedElementCallback21 createCallback(SharedElementCallback var0) {
      ActivityCompat.SharedElementCallback21Impl var1 = null;
      if(var0 != null) {
         var1 = new ActivityCompat.SharedElementCallback21Impl(var0);
      }

      return var1;
   }

   public static void finishAffinity(Activity var0) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.finishAffinity(var0);
      } else {
         var0.finish();
      }
   }

   public static void finishAfterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.finishAfterTransition(var0);
      } else {
         var0.finish();
      }
   }

   public static boolean invalidateOptionsMenu(Activity var0) {
      if(VERSION.SDK_INT >= 11) {
         ActivityCompatHoneycomb.invalidateOptionsMenu(var0);
         return true;
      } else {
         return false;
      }
   }

   public static void postponeEnterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.postponeEnterTransition(var0);
      }

   }

   public static void setEnterSharedElementCallback(Activity var0, SharedElementCallback var1) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.setEnterSharedElementCallback(var0, createCallback(var1));
      }

   }

   public static void setExitSharedElementCallback(Activity var0, SharedElementCallback var1) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.setExitSharedElementCallback(var0, createCallback(var1));
      }

   }

   public static void startActivity(Activity var0, Intent var1, @Nullable Bundle var2) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.startActivity(var0, var1, var2);
      } else {
         var0.startActivity(var1);
      }
   }

   public static void startActivityForResult(Activity var0, Intent var1, int var2, @Nullable Bundle var3) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.startActivityForResult(var0, var1, var2, var3);
      } else {
         var0.startActivityForResult(var1, var2);
      }
   }

   public static void startPostponedEnterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.startPostponedEnterTransition(var0);
      }

   }

   private static class SharedElementCallback21Impl extends ActivityCompat21.SharedElementCallback21 {
      private SharedElementCallback mCallback;

      public SharedElementCallback21Impl(SharedElementCallback var1) {
         this.mCallback = var1;
      }

      public Parcelable onCaptureSharedElementSnapshot(View var1, Matrix var2, RectF var3) {
         return this.mCallback.onCaptureSharedElementSnapshot(var1, var2, var3);
      }

      public View onCreateSnapshotView(Context var1, Parcelable var2) {
         return this.mCallback.onCreateSnapshotView(var1, var2);
      }

      public void onMapSharedElements(List var1, Map var2) {
         this.mCallback.onMapSharedElements(var1, var2);
      }

      public void onRejectSharedElements(List var1) {
         this.mCallback.onRejectSharedElements(var1);
      }

      public void onSharedElementEnd(List var1, List var2, List var3) {
         this.mCallback.onSharedElementEnd(var1, var2, var3);
      }

      public void onSharedElementStart(List var1, List var2, List var3) {
         this.mCallback.onSharedElementStart(var1, var2, var3);
      }
   }
}
