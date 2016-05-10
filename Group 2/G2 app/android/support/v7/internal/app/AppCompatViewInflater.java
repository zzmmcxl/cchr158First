package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import java.util.Map;

public class AppCompatViewInflater {
   private static final String LOG_TAG = "AppCompatViewInflater";
   private static final Map sConstructorMap = new ArrayMap();
   static final Class[] sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
   private final Object[] mConstructorArgs = new Object[2];

   private View createView(Context param1, String param2, String param3) throws ClassNotFoundException, InflateException {
      // $FF: Couldn't be decompiled
   }

   private View createViewFromTag(Context var1, String var2, AttributeSet var3) {
      String var4 = var2;
      if(var2.equals("view")) {
         var4 = var3.getAttributeValue((String)null, "class");
      }

      try {
         this.mConstructorArgs[0] = var1;
         this.mConstructorArgs[1] = var3;
         View var9;
         if(-1 != var4.indexOf(46)) {
            var9 = this.createView(var1, var4, (String)null);
            return var9;
         }

         var9 = this.createView(var1, var4, "android.widget.");
         return var9;
      } catch (Exception var7) {
         ;
      } finally {
         this.mConstructorArgs[0] = null;
         this.mConstructorArgs[1] = null;
      }

      return null;
   }

   private static Context themifyContext(Context var0, AttributeSet var1, boolean var2, boolean var3) {
      TypedArray var6 = var0.obtainStyledAttributes(var1, R.styleable.View, 0, 0);
      int var4 = 0;
      if(var2) {
         var4 = var6.getResourceId(R.styleable.View_android_theme, 0);
      }

      int var5 = var4;
      if(var3) {
         var5 = var4;
         if(var4 == 0) {
            var4 = var6.getResourceId(R.styleable.View_theme, 0);
            var5 = var4;
            if(var4 != 0) {
               Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
               var5 = var4;
            }
         }
      }

      var6.recycle();
      Object var7 = var0;
      if(var5 != 0) {
         if(var0 instanceof ContextThemeWrapper) {
            var7 = var0;
            if(((ContextThemeWrapper)var0).getThemeResId() == var5) {
               return (Context)var7;
            }
         }

         var7 = new ContextThemeWrapper(var0, var5);
      }

      return (Context)var7;
   }

   public final View createView(View var1, String var2, @NonNull Context var3, @NonNull AttributeSet var4, boolean var5, boolean var6, boolean var7) {
      Context var9 = var3;
      if(var5) {
         var9 = var3;
         if(var1 != null) {
            var9 = var1.getContext();
         }
      }

      Context var10;
      label67: {
         if(!var6) {
            var10 = var9;
            if(!var7) {
               break label67;
            }
         }

         var10 = themifyContext(var9, var4, var6, var7);
      }

      byte var8 = -1;
      switch(var2.hashCode()) {
      case -1946472170:
         if(var2.equals("RatingBar")) {
            var8 = 7;
         }
         break;
      case -1455429095:
         if(var2.equals("CheckedTextView")) {
            var8 = 4;
         }
         break;
      case -1346021293:
         if(var2.equals("MultiAutoCompleteTextView")) {
            var8 = 6;
         }
         break;
      case -938935918:
         if(var2.equals("TextView")) {
            var8 = 9;
         }
         break;
      case -339785223:
         if(var2.equals("Spinner")) {
            var8 = 1;
         }
         break;
      case 776382189:
         if(var2.equals("RadioButton")) {
            var8 = 3;
         }
         break;
      case 1413872058:
         if(var2.equals("AutoCompleteTextView")) {
            var8 = 5;
         }
         break;
      case 1601505219:
         if(var2.equals("CheckBox")) {
            var8 = 2;
         }
         break;
      case 1666676343:
         if(var2.equals("EditText")) {
            var8 = 0;
         }
         break;
      case 2001146706:
         if(var2.equals("Button")) {
            var8 = 8;
         }
      }

      switch(var8) {
      case 0:
         return new AppCompatEditText(var10, var4);
      case 1:
         return new AppCompatSpinner(var10, var4);
      case 2:
         return new AppCompatCheckBox(var10, var4);
      case 3:
         return new AppCompatRadioButton(var10, var4);
      case 4:
         return new AppCompatCheckedTextView(var10, var4);
      case 5:
         return new AppCompatAutoCompleteTextView(var10, var4);
      case 6:
         return new AppCompatMultiAutoCompleteTextView(var10, var4);
      case 7:
         return new AppCompatRatingBar(var10, var4);
      case 8:
         return new AppCompatButton(var10, var4);
      case 9:
         return new AppCompatTextView(var10, var4);
      default:
         return var3 != var10?this.createViewFromTag(var10, var2, var4):null;
      }
   }
}
