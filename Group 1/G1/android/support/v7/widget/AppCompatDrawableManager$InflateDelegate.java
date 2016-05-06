package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.support.annotation.NonNull;
import android.content.Context;

private interface InflateDelegate
{
    Drawable createFromXmlInner(@NonNull final Context p0, @NonNull final XmlPullParser p1, @NonNull final AttributeSet p2, @Nullable final Resources$Theme p3);
}
