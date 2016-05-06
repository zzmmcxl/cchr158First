package android.support.v4.widget;

import android.support.annotation.StyleRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.TextView;

static class BaseTextViewCompatImpl implements TextViewCompatImpl
{
    BaseTextViewCompatImpl() {
        super();
    }
    
    @Override
    public int getMaxLines(final TextView textView) {
        return TextViewCompatDonut.getMaxLines(textView);
    }
    
    @Override
    public int getMinLines(final TextView textView) {
        return TextViewCompatDonut.getMinLines(textView);
    }
    
    @Override
    public void setCompoundDrawablesRelative(@NonNull final TextView textView, @Nullable final Drawable drawable, @Nullable final Drawable drawable2, @Nullable final Drawable drawable3, @Nullable final Drawable drawable4) {
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }
    
    @Override
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull final TextView textView, @DrawableRes final int n, @DrawableRes final int n2, @DrawableRes final int n3, @DrawableRes final int n4) {
        textView.setCompoundDrawablesWithIntrinsicBounds(n, n2, n3, n4);
    }
    
    @Override
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull final TextView textView, @Nullable final Drawable drawable, @Nullable final Drawable drawable2, @Nullable final Drawable drawable3, @Nullable final Drawable drawable4) {
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }
    
    @Override
    public void setTextAppearance(final TextView textView, @StyleRes final int n) {
        TextViewCompatDonut.setTextAppearance(textView, n);
    }
}
