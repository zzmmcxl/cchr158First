package android.support.graphics.drawable;

import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import android.content.res.Resources;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.TypedArray;
import android.support.v4.util.ArrayMap;
import android.graphics.Matrix;
import java.util.ArrayList;

private static class VGroup
{
    private int mChangingConfigurations;
    final ArrayList<Object> mChildren;
    private String mGroupName;
    private final Matrix mLocalMatrix;
    private float mPivotX;
    private float mPivotY;
    private float mRotate;
    private float mScaleX;
    private float mScaleY;
    private final Matrix mStackedMatrix;
    private int[] mThemeAttrs;
    private float mTranslateX;
    private float mTranslateY;
    
    public VGroup() {
        super();
        this.mStackedMatrix = new Matrix();
        this.mChildren = new ArrayList<Object>();
        this.mRotate = 0.0f;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTranslateX = 0.0f;
        this.mTranslateY = 0.0f;
        this.mLocalMatrix = new Matrix();
        this.mGroupName = null;
    }
    
    public VGroup(final VGroup vGroup, final ArrayMap<String, Object> arrayMap) {
        super();
        this.mStackedMatrix = new Matrix();
        this.mChildren = new ArrayList<Object>();
        this.mRotate = 0.0f;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTranslateX = 0.0f;
        this.mTranslateY = 0.0f;
        this.mLocalMatrix = new Matrix();
        this.mGroupName = null;
        this.mRotate = vGroup.mRotate;
        this.mPivotX = vGroup.mPivotX;
        this.mPivotY = vGroup.mPivotY;
        this.mScaleX = vGroup.mScaleX;
        this.mScaleY = vGroup.mScaleY;
        this.mTranslateX = vGroup.mTranslateX;
        this.mTranslateY = vGroup.mTranslateY;
        this.mThemeAttrs = vGroup.mThemeAttrs;
        this.mGroupName = vGroup.mGroupName;
        this.mChangingConfigurations = vGroup.mChangingConfigurations;
        if (this.mGroupName != null) {
            arrayMap.put(this.mGroupName, this);
        }
        this.mLocalMatrix.set(vGroup.mLocalMatrix);
        final ArrayList<Object> mChildren = vGroup.mChildren;
        for (int i = 0; i < mChildren.size(); ++i) {
            final VGroup value = mChildren.get(i);
            if (value instanceof VGroup) {
                this.mChildren.add(new VGroup((VGroup)value, arrayMap));
            }
            else {
                VPath vPath;
                if (value instanceof VFullPath) {
                    vPath = new VFullPath((VFullPath)value);
                }
                else {
                    if (!(value instanceof VClipPath)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    vPath = new VClipPath((VClipPath)value);
                }
                this.mChildren.add(vPath);
                if (vPath.mPathName != null) {
                    arrayMap.put(vPath.mPathName, vPath);
                }
            }
        }
    }
    
    static /* synthetic */ int access$100(final VGroup vGroup) {
        return vGroup.mChangingConfigurations;
    }
    
    static /* synthetic */ float access$200(final VGroup vGroup) {
        return vGroup.mRotate;
    }
    
    static /* synthetic */ Matrix access$700(final VGroup vGroup) {
        return vGroup.mStackedMatrix;
    }
    
    static /* synthetic */ Matrix access$800(final VGroup vGroup) {
        return vGroup.mLocalMatrix;
    }
    
    private void updateLocalMatrix() {
        mLocalMatrix.reset();
        mLocalMatrix.postTranslate(-mPivotX, -mPivotY);
        mLocalMatrix.postScale(mScaleX, mScaleY);
        mLocalMatrix.postRotate(mRotate, 0.0f, 0.0f);
        mLocalMatrix.postTranslate(mTranslateX + mPivotX, mTranslateY + mPivotY);
    }
    
    private void updateStateFromTypedArray(final TypedArray typedArray, final XmlPullParser xmlPullParser) {
        mThemeAttrs = null;
        mRotate = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, mRotate);
        mPivotX = typedArray.getFloat(1, mPivotX);
        mPivotY = typedArray.getFloat(2, mPivotY);
        mScaleX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, mScaleX);
        mScaleY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, mScaleY);
        mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, mTranslateX);
        mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, mTranslateY);
        final String string = typedArray.getString(0);
        if (string != null) {
            mGroupName = string;
        }
        this.updateLocalMatrix();
    }
    
    public String getGroupName() {
        return mGroupName;
    }
    
    public Matrix getLocalMatrix() {
        return mLocalMatrix;
    }
    
    public float getPivotX() {
        return mPivotX;
    }
    
    public float getPivotY() {
        return mPivotY;
    }
    
    public float getRotation() {
        return mRotate;
    }
    
    public float getScaleX() {
        return mScaleX;
    }
    
    public float getScaleY() {
        return mScaleY;
    }
    
    public float getTranslateX() {
        return mTranslateX;
    }
    
    public float getTranslateY() {
        return mTranslateY;
    }
    
    public void inflate(final Resources resources, final AttributeSet set, final Resources$Theme resources$Theme, final XmlPullParser xmlPullParser) {
        final TypedArray obtainAttributes = VectorDrawableCommon.obtainAttributes(resources, resources$Theme, set, AndroidResources.styleable_VectorDrawableGroup);
        this.updateStateFromTypedArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }
    
    public void setPivotX(final float mPivotX) {
        if (mPivotX != this.mPivotX) {
            this.mPivotX = mPivotX;
            this.updateLocalMatrix();
        }
    }
    
    public void setPivotY(final float mPivotY) {
        if (mPivotY != this.mPivotY) {
            this.mPivotY = mPivotY;
            this.updateLocalMatrix();
        }
    }
    
    public void setRotation(final float mRotate) {
        if (mRotate != this.mRotate) {
            this.mRotate = mRotate;
            this.updateLocalMatrix();
        }
    }
    
    public void setScaleX(final float mScaleX) {
        if (mScaleX != this.mScaleX) {
            this.mScaleX = mScaleX;
            this.updateLocalMatrix();
        }
    }
    
    public void setScaleY(final float mScaleY) {
        if (mScaleY != this.mScaleY) {
            this.mScaleY = mScaleY;
            this.updateLocalMatrix();
        }
    }
    
    public void setTranslateX(final float mTranslateX) {
        if (mTranslateX != this.mTranslateX) {
            this.mTranslateX = mTranslateX;
            this.updateLocalMatrix();
        }
    }
    
    public void setTranslateY(final float mTranslateY) {
        if (mTranslateY != this.mTranslateY) {
            this.mTranslateY = mTranslateY;
            this.updateLocalMatrix();
        }
    }
}
