package android.support.v4.app;

import java.util.Map;
import java.util.List;
import android.content.Context;
import android.os.Parcelable;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.view.View;

private static class SharedElementCallback21Impl extends SharedElementCallback21
{
    private SharedElementCallback mCallback;
    
    public SharedElementCallback21Impl(final SharedElementCallback mCallback) {
        super();
        this.mCallback = mCallback;
    }
    
    @Override
    public Parcelable onCaptureSharedElementSnapshot(final View view, final Matrix matrix, final RectF rectF) {
        return mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }
    
    @Override
    public View onCreateSnapshotView(final Context context, final Parcelable parcelable) {
        return mCallback.onCreateSnapshotView(context, parcelable);
    }
    
    @Override
    public void onMapSharedElements(final List<String> list, final Map<String, View> map) {
        mCallback.onMapSharedElements(list, map);
    }
    
    @Override
    public void onRejectSharedElements(final List<View> list) {
        mCallback.onRejectSharedElements(list);
    }
    
    @Override
    public void onSharedElementEnd(final List<String> list, final List<View> list2, final List<View> list3) {
        mCallback.onSharedElementEnd(list, list2, list3);
    }
    
    @Override
    public void onSharedElementStart(final List<String> list, final List<View> list2, final List<View> list3) {
        mCallback.onSharedElementStart(list, list2, list3);
    }
}
