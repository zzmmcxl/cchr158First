package android.support.v4.widget;

import java.lang.reflect.AccessibleObject;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

class TextViewCompatDonut
{
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompatDonut";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;
    
    TextViewCompatDonut() {
        super();
    }
    
    static int getMaxLines(final TextView textView) {
        if (!sMaxModeFieldFetched) {
            sMaxModeField = retrieveField("mMaxMode");
            sMaxModeFieldFetched = true;
        }
        if (sMaxModeField != null && retrieveIntFromField(sMaxModeField, textView) == 1) {
            if (!sMaximumFieldFetched) {
                sMaximumField = retrieveField("mMaximum");
                sMaximumFieldFetched = true;
            }
            if (sMaximumField != null) {
                return retrieveIntFromField(sMaximumField, textView);
            }
        }
        return -1;
    }
    
    static int getMinLines(final TextView textView) {
        if (!sMinModeFieldFetched) {
            sMinModeField = retrieveField("mMinMode");
            sMinModeFieldFetched = true;
        }
        if (sMinModeField != null && retrieveIntFromField(sMinModeField, textView) == 1) {
            if (!sMinimumFieldFetched) {
                sMinimumField = retrieveField("mMinimum");
                sMinimumFieldFetched = true;
            }
            if (sMinimumField != null) {
                return retrieveIntFromField(sMinimumField, textView);
            }
        }
        return -1;
    }
    
    private static Field retrieveField(final String s) {
        AccessibleObject declaredField = null;
        try {
            declaredField = TextView.class.getDeclaredField(s);
            declaredField.setAccessible(true);
            return (Field)declaredField;
        }
        catch (NoSuchFieldException ex) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + s + " field.");
            return (Field)declaredField;
        }
    }
    
    private static int retrieveIntFromField(final Field field, final TextView textView) {
        try {
            return field.getInt(textView);
        }
        catch (IllegalAccessException ex) {
            Log.d("TextViewCompatDonut", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }
    
    static void setTextAppearance(final TextView textView, final int n) {
        textView.setTextAppearance(textView.getContext(), n);
    }
}
