package android.support.v4.view;

import android.view.View;
import android.content.Context;
import java.util.Locale;
import android.text.method.SingleLineTransformationMethod;

private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod
{
    private static final String TAG = "SingleLineAllCapsTransform";
    private Locale mLocale;
    
    public SingleLineAllCapsTransform(final Context context) {
        super();
        this.mLocale = context.getResources().getConfiguration().locale;
    }
    
    public CharSequence getTransformation(final CharSequence charSequence, final View view) {
        final CharSequence transformation = super.getTransformation(charSequence, view);
        if (transformation != null) {
            return transformation.toString().toUpperCase(mLocale);
        }
        return null;
    }
}
