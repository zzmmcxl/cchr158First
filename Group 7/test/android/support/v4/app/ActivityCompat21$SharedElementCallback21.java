package android.support.v4.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

public abstract class ActivityCompat21$SharedElementCallback21 {
   public abstract Parcelable onCaptureSharedElementSnapshot(View var1, Matrix var2, RectF var3);

   public abstract View onCreateSnapshotView(Context var1, Parcelable var2);

   public abstract void onMapSharedElements(List<String> var1, Map<String, View> var2);

   public abstract void onRejectSharedElements(List<View> var1);

   public abstract void onSharedElementEnd(List<String> var1, List<View> var2, List<View> var3);

   public abstract void onSharedElementStart(List<String> var1, List<View> var2, List<View> var3);
}
