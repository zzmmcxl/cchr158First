package android.support.v7.widget;

import android.view.ViewGroup$LayoutParams;
import android.view.ViewParent;
import android.view.ViewGroup;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.view.LayoutInflater;
import java.lang.ref.WeakReference;
import android.view.View;

public final class ViewStubCompat extends View
{
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;
    
    public ViewStubCompat(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ViewStubCompat(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mLayoutResource = 0;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ViewStubCompat, n, 0);
        mInflatedId = obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        mLayoutResource = obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        this.setId(obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }
    
    protected void dispatchDraw(final Canvas canvas) {
    }
    
    public void draw(final Canvas canvas) {
    }
    
    public int getInflatedId() {
        return mInflatedId;
    }
    
    public LayoutInflater getLayoutInflater() {
        return mInflater;
    }
    
    public int getLayoutResource() {
        return mLayoutResource;
    }
    
    public View inflate() {
        final ViewParent parent = this.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (mLayoutResource != 0) {
            final ViewGroup viewGroup = (ViewGroup)parent;
            LayoutInflater layoutInflater;
            if (mInflater != null) {
                layoutInflater = mInflater;
            }
            else {
                layoutInflater = LayoutInflater.from(this.getContext());
            }
            final View inflate = layoutInflater.inflate(mLayoutResource, viewGroup, false);
            if (mInflatedId != -1) {
                inflate.setId(mInflatedId);
            }
            final int indexOfChild = viewGroup.indexOfChild((View)this);
            viewGroup.removeViewInLayout((View)this);
            final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            }
            else {
                viewGroup.addView(inflate, indexOfChild);
            }
            mInflatedViewRef = new WeakReference<View>(inflate);
            if (mInflateListener != null) {
                mInflateListener.onInflate(this, inflate);
            }
            return inflate;
        }
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(0, 0);
    }
    
    public void setInflatedId(final int mInflatedId) {
        this.mInflatedId = mInflatedId;
    }
    
    public void setLayoutInflater(final LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }
    
    public void setLayoutResource(final int mLayoutResource) {
        this.mLayoutResource = mLayoutResource;
    }
    
    public void setOnInflateListener(final OnInflateListener mInflateListener) {
        this.mInflateListener = mInflateListener;
    }
    
    public void setVisibility(final int n) {
        if (mInflatedViewRef != null) {
            final View view = (View)mInflatedViewRef.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(n);
        }
        else {
            super.setVisibility(n);
            if (n == 0 || n == 4) {
                this.inflate();
            }
        }
    }
}
