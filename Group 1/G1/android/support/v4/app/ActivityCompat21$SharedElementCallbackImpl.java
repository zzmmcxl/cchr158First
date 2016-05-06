package android.support.v4.app;

import java.util.Map;
import java.util.List;
import android.content.Context;
import android.os.Parcelable;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.view.View;
import android.app.SharedElementCallback;

private static class SharedElementCallbackImpl extends SharedElementCallback
{
    private SharedElementCallback21 mCallback;
    
    public SharedElementCallbackImpl(final SharedElementCallback21 mCallback) {
        super();
        this.mCallback = mCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(final View view, final Matrix matrix, final RectF rectF) {
        return mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }
    
    public View onCreateSnapshotView(final Context context, final Parcelable parcelable) {
        return mCallback.onCreateSnapshotView(context, parcelable);
    }
    
    public void onMapSharedElements(final List<String> list, final Map<String, View> map) {
        mCallback.onMapSharedElements(list, map);
    }
    
    public void onRejectSharedElements(final List<View> list) {
        mCallback.onRejectSharedElements(list);
    }
    
    public void onSharedElementEnd(final List<String> list, final List<View> list2, final List<View> list3) {
        mCallback.onSharedElementEnd(list, list2, list3);
    }
    
    public void onSharedElementStart(final List<String> list, final List<View> list2, final List<View> list3) {
        mCallback.onSharedElementStart(list, list2, list3);
    }
}
