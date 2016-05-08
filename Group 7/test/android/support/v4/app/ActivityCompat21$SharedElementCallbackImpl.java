package android.support.v4.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat21$SharedElementCallback21;
import android.view.View;
import java.util.List;
import java.util.Map;

class ActivityCompat21$SharedElementCallbackImpl extends android.app.SharedElementCallback {
   private ActivityCompat21$SharedElementCallback21 mCallback;

   public ActivityCompat21$SharedElementCallbackImpl(ActivityCompat21$SharedElementCallback21 var1) {
      this.mCallback = var1;
   }

   public Parcelable onCaptureSharedElementSnapshot(View var1, Matrix var2, RectF var3) {
      return this.mCallback.onCaptureSharedElementSnapshot(var1, var2, var3);
   }

   public View onCreateSnapshotView(Context var1, Parcelable var2) {
      return this.mCallback.onCreateSnapshotView(var1, var2);
   }

   public void onMapSharedElements(List<String> var1, Map<String, View> var2) {
      this.mCallback.onMapSharedElements(var1, var2);
   }

   public void onRejectSharedElements(List<View> var1) {
      this.mCallback.onRejectSharedElements(var1);
   }

   public void onSharedElementEnd(List<String> var1, List<View> var2, List<View> var3) {
      this.mCallback.onSharedElementEnd(var1, var2, var3);
   }

   public void onSharedElementStart(List<String> var1, List<View> var2, List<View> var3) {
      this.mCallback.onSharedElementStart(var1, var2, var3);
   }
}
