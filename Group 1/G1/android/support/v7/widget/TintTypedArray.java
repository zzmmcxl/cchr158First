package android.support.v7.widget;

import android.util.TypedValue;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.content.res.TypedArray;
import android.content.Context;

public class TintTypedArray
{
    private final Context mContext;
    private final TypedArray mWrapped;
    
    private TintTypedArray(final Context mContext, final TypedArray mWrapped) {
        super();
        mContext = mContext;
        mWrapped = mWrapped;
    }
    
    public static TintTypedArray obtainStyledAttributes(final Context context, final AttributeSet set, final int[] array) {
        return new TintTypedArray(context, context.obtainStyledAttributes(set, array));
    }
    
    public static TintTypedArray obtainStyledAttributes(final Context context, final AttributeSet set, final int[] array, final int n, final int n2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(set, array, n, n2));
    }
    
    public boolean getBoolean(final int n, final boolean b) {
        return mWrapped.getBoolean(n, b);
    }
    
    public int getChangingConfigurations() {
        return mWrapped.getChangingConfigurations();
    }
    
    public int getColor(final int n, final int n2) {
        return mWrapped.getColor(n, n2);
    }
    
    public ColorStateList getColorStateList(final int n) {
        return mWrapped.getColorStateList(n);
    }
    
    public float getDimension(final int n, final float n2) {
        return mWrapped.getDimension(n, n2);
    }
    
    public int getDimensionPixelOffset(final int n, final int n2) {
        return mWrapped.getDimensionPixelOffset(n, n2);
    }
    
    public int getDimensionPixelSize(final int n, final int n2) {
        return mWrapped.getDimensionPixelSize(n, n2);
    }
    
    public Drawable getDrawable(final int n) {
        if (mWrapped.hasValue(n)) {
            final int resourceId = mWrapped.getResourceId(n, 0);
            if (resourceId != 0) {
                return AppCompatDrawableManager.get().getDrawable(mContext, resourceId);
            }
        }
        return mWrapped.getDrawable(n);
    }
    
    public Drawable getDrawableIfKnown(final int n) {
        if (mWrapped.hasValue(n)) {
            final int resourceId = mWrapped.getResourceId(n, 0);
            if (resourceId != 0) {
                return AppCompatDrawableManager.get().getDrawable(mContext, resourceId, true);
            }
        }
        return null;
    }
    
    public float getFloat(final int n, final float n2) {
        return mWrapped.getFloat(n, n2);
    }
    
    public float getFraction(final int n, final int n2, final int n3, final float n4) {
        return mWrapped.getFraction(n, n2, n3, n4);
    }
    
    public int getIndex(final int n) {
        return mWrapped.getIndex(n);
    }
    
    public int getIndexCount() {
        return mWrapped.getIndexCount();
    }
    
    public int getInt(final int n, final int n2) {
        return mWrapped.getInt(n, n2);
    }
    
    public int getInteger(final int n, final int n2) {
        return mWrapped.getInteger(n, n2);
    }
    
    public int getLayoutDimension(final int n, final int n2) {
        return mWrapped.getLayoutDimension(n, n2);
    }
    
    public int getLayoutDimension(final int n, final String s) {
        return mWrapped.getLayoutDimension(n, s);
    }
    
    public String getNonResourceString(final int n) {
        return mWrapped.getNonResourceString(n);
    }
    
    public String getPositionDescription() {
        return mWrapped.getPositionDescription();
    }
    
    public int getResourceId(final int n, final int n2) {
        return mWrapped.getResourceId(n, n2);
    }
    
    public Resources getResources() {
        return mWrapped.getResources();
    }
    
    public String getString(final int n) {
        return mWrapped.getString(n);
    }
    
    public CharSequence getText(final int n) {
        return mWrapped.getText(n);
    }
    
    public CharSequence[] getTextArray(final int n) {
        return mWrapped.getTextArray(n);
    }
    
    public int getType(final int n) {
        return mWrapped.getType(n);
    }
    
    public boolean getValue(final int n, final TypedValue typedValue) {
        return mWrapped.getValue(n, typedValue);
    }
    
    public boolean hasValue(final int n) {
        return mWrapped.hasValue(n);
    }
    
    public int length() {
        return mWrapped.length();
    }
    
    public TypedValue peekValue(final int n) {
        return mWrapped.peekValue(n);
    }
    
    public void recycle() {
        mWrapped.recycle();
    }
}
