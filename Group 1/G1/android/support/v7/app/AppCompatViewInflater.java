package android.support.v7.app;

import java.lang.reflect.InvocationTargetException;
import android.support.annotation.Nullable;
import java.lang.reflect.Method;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintContextWrapper;
import android.support.annotation.NonNull;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.support.v7.appcompat.R;
import android.view.InflateException;
import android.content.res.TypedArray;
import android.view.View$OnClickListener;
import android.support.v4.view.ViewCompat;
import android.os.Build$VERSION;
import android.content.ContextWrapper;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

class AppCompatViewInflater
{
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList;
    private static final Map<String, Constructor<? extends View>> sConstructorMap;
    private static final Class<?>[] sConstructorSignature;
    private static final int[] sOnClickAttrs;
    private final Object[] mConstructorArgs;
    
    static {
        sConstructorSignature = new Class[] { Context.class, AttributeSet.class };
        sOnClickAttrs = new int[] { 16843375 };
        sClassPrefixList = new String[] { "android.widget.", "android.view.", "android.webkit." };
        sConstructorMap = new ArrayMap<String, Constructor<? extends View>>();
    }
    
    AppCompatViewInflater() {
        super();
        mConstructorArgs = new Object[2];
    }
    
    private void checkOnClickListener(final View view, final AttributeSet set) {
        final Context context = view.getContext();
        if (!(context instanceof ContextWrapper) || (Build$VERSION.SDK_INT >= 15 && !ViewCompat.hasOnClickListeners(view))) {
            return;
        }
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, sOnClickAttrs);
        final String string = obtainStyledAttributes.getString(0);
        if (string != null) {
            view.setOnClickListener((View$OnClickListener)new DeclaredOnClickListener(view, string));
        }
        obtainStyledAttributes.recycle();
    }
    
    private View createView(final Context context, final String s, final String s2) throws ClassNotFoundException, InflateException {
        Constructor<? extends View> constructor = (Constructor<? extends View>)sConstructorMap.get(s);
        Label_0081: {
            if (constructor != null) {
                break Label_0081;
            }
            try {
                final ClassLoader classLoader = context.getClassLoader();
                String string;
                if (s2 != null) {
                    string = s2 + s;
                }
                else {
                    string = s;
                }
                constructor = classLoader.loadClass(string).<View>asSubclass(View.class).getConstructor(sConstructorSignature);
                sConstructorMap.put(s, constructor);
                constructor.setAccessible(true);
                return (View)constructor.newInstance(mConstructorArgs);
            }
            catch (Exception ex) {
                return null;
            }
        }
    }
    
    private View createViewFromTag(final Context context, String attributeValue, final AttributeSet set) {
        if (attributeValue.equals("view")) {
            attributeValue = set.getAttributeValue((String)null, "class");
        }
        try {
            mConstructorArgs[0] = context;
            mConstructorArgs[1] = set;
            if (-1 == attributeValue.indexOf(46)) {
                for (int i = 0; i < sClassPrefixList.length; ++i) {
                    final View view = this.createView(context, attributeValue, sClassPrefixList[i]);
                    if (view != null) {
                        return view;
                    }
                }
                return null;
            }
            return this.createView(context, attributeValue, null);
        }
        catch (Exception ex) {
            return null;
        }
        finally {
            mConstructorArgs[0] = null;
            mConstructorArgs[1] = null;
        }
    }
    
    private static Context themifyContext(Context context, final AttributeSet set, final boolean b, final boolean b2) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.View, 0, 0);
        int n = 0;
        if (b) {
            n = obtainStyledAttributes.getResourceId(R.styleable.View_android_theme, 0);
        }
        if (b2 && n == 0) {
            n = obtainStyledAttributes.getResourceId(R.styleable.View_theme, 0);
            if (n != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        obtainStyledAttributes.recycle();
        if (n != 0 && (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper)context).getThemeResId() != n)) {
            context = (Context)new ContextThemeWrapper(context, n);
        }
        return context;
    }
    
    public final View createView(final View view, final String s, @NonNull Context context, @NonNull final AttributeSet set, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final Context context2 = context;
        if (b && view != null) {
            context = view.getContext();
        }
        if (b2 || b3) {
            context = themifyContext(context, set, b2, b3);
        }
        if (b4) {
            context = TintContextWrapper.wrap(context);
        }
        int n = -1;
        switch (s.hashCode()) {
            case -938935918:
                if (s.equals("TextView")) {
                    n = 0;
                    break;
                }
                break;
            case 1125864064:
                if (s.equals("ImageView")) {
                    n = 1;
                    break;
                }
                break;
            case 2001146706:
                if (s.equals("Button")) {
                    n = 2;
                    break;
                }
                break;
            case 1666676343:
                if (s.equals("EditText")) {
                    n = 3;
                    break;
                }
                break;
            case -339785223:
                if (s.equals("Spinner")) {
                    n = 4;
                    break;
                }
                break;
            case -937446323:
                if (s.equals("ImageButton")) {
                    n = 5;
                    break;
                }
                break;
            case 1601505219:
                if (s.equals("CheckBox")) {
                    n = 6;
                    break;
                }
                break;
            case 776382189:
                if (s.equals("RadioButton")) {
                    n = 7;
                    break;
                }
                break;
            case -1455429095:
                if (s.equals("CheckedTextView")) {
                    n = 8;
                    break;
                }
                break;
            case 1413872058:
                if (s.equals("AutoCompleteTextView")) {
                    n = 9;
                    break;
                }
                break;
            case -1346021293:
                if (s.equals("MultiAutoCompleteTextView")) {
                    n = 10;
                    break;
                }
                break;
            case -1946472170:
                if (s.equals("RatingBar")) {
                    n = 11;
                    break;
                }
                break;
            case -658531749:
                if (s.equals("SeekBar")) {
                    n = 12;
                    break;
                }
                break;
        }
        Object viewFromTag = null;
        switch (n) {
            case 0:
                viewFromTag = new AppCompatTextView(context, set);
                break;
            case 1:
                viewFromTag = new AppCompatImageView(context, set);
                break;
            case 2:
                viewFromTag = new AppCompatButton(context, set);
                break;
            case 3:
                viewFromTag = new AppCompatEditText(context, set);
                break;
            case 4:
                viewFromTag = new AppCompatSpinner(context, set);
                break;
            case 5:
                viewFromTag = new AppCompatImageButton(context, set);
                break;
            case 6:
                viewFromTag = new AppCompatCheckBox(context, set);
                break;
            case 7:
                viewFromTag = new AppCompatRadioButton(context, set);
                break;
            case 8:
                viewFromTag = new AppCompatCheckedTextView(context, set);
                break;
            case 9:
                viewFromTag = new AppCompatAutoCompleteTextView(context, set);
                break;
            case 10:
                viewFromTag = new AppCompatMultiAutoCompleteTextView(context, set);
                break;
            case 11:
                viewFromTag = new AppCompatRatingBar(context, set);
                break;
            case 12:
                viewFromTag = new AppCompatSeekBar(context, set);
                break;
        }
        if (viewFromTag == null && context2 != context) {
            viewFromTag = this.createViewFromTag(context, s, set);
        }
        if (viewFromTag != null) {
            this.checkOnClickListener((View)viewFromTag, set);
        }
        return (View)viewFromTag;
    }
}
