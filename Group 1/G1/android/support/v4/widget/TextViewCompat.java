package android.support.v4.widget;

import android.support.annotation.StyleRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.TextView;
import android.os.Build$VERSION;

public final class TextViewCompat
{
    static final TextViewCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = (TextViewCompatImpl)new Api23TextViewCompatImpl();
            return;
        }
        if (sdk_INT >= 18) {
            IMPL = (TextViewCompatImpl)new JbMr2TextViewCompatImpl();
            return;
        }
        if (sdk_INT >= 17) {
            IMPL = (TextViewCompatImpl)new JbMr1TextViewCompatImpl();
            return;
        }
        if (sdk_INT >= 16) {
            IMPL = (TextViewCompatImpl)new JbTextViewCompatImpl();
            return;
        }
        IMPL = (TextViewCompatImpl)new BaseTextViewCompatImpl();
    }
    
    private TextViewCompat() {
        super();
    }
    
    public static int getMaxLines(@NonNull final TextView textView) {
        return IMPL.getMaxLines(textView);
    }
    
    public static int getMinLines(@NonNull final TextView textView) {
        return IMPL.getMinLines(textView);
    }
    
    public static void setCompoundDrawablesRelative(@NonNull final TextView textView, @Nullable final Drawable drawable, @Nullable final Drawable drawable2, @Nullable final Drawable drawable3, @Nullable final Drawable drawable4) {
        IMPL.setCompoundDrawablesRelative(textView, drawable, drawable2, drawable3, drawable4);
    }
    
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull final TextView textView, @DrawableRes final int n, @DrawableRes final int n2, @DrawableRes final int n3, @DrawableRes final int n4) {
        IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, n, n2, n3, n4);
    }
    
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull final TextView textView, @Nullable final Drawable drawable, @Nullable final Drawable drawable2, @Nullable final Drawable drawable3, @Nullable final Drawable drawable4) {
        IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable, drawable2, drawable3, drawable4);
    }
    
    public static void setTextAppearance(@NonNull final TextView textView, @StyleRes final int n) {
        IMPL.setTextAppearance(textView, n);
    }
}
