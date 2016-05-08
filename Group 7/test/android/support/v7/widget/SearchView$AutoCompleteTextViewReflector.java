package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$AutoCompleteTextViewReflector {
   private Method doAfterTextChanged;
   private Method doBeforeTextChanged;
   private Method ensureImeVisible;
   private Method showSoftInputUnchecked;

   SearchView$AutoCompleteTextViewReflector() {
      try {
         this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
         this.doBeforeTextChanged.setAccessible(true);
      } catch (NoSuchMethodException var5) {
         ;
      }

      try {
         this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
         this.doAfterTextChanged.setAccessible(true);
      } catch (NoSuchMethodException var4) {
         ;
      }

      try {
         this.ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
         this.ensureImeVisible.setAccessible(true);
      } catch (NoSuchMethodException var3) {
         ;
      }

      try {
         this.showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
         this.showSoftInputUnchecked.setAccessible(true);
      } catch (NoSuchMethodException var2) {
         ;
      }
   }

   void doAfterTextChanged(AutoCompleteTextView var1) {
      if(this.doAfterTextChanged != null) {
         try {
            this.doAfterTextChanged.invoke(var1, new Object[0]);
         } catch (Exception var2) {
            return;
         }
      }

   }

   void doBeforeTextChanged(AutoCompleteTextView var1) {
      if(this.doBeforeTextChanged != null) {
         try {
            this.doBeforeTextChanged.invoke(var1, new Object[0]);
         } catch (Exception var2) {
            return;
         }
      }

   }

   void ensureImeVisible(AutoCompleteTextView var1, boolean var2) {
      if(this.ensureImeVisible != null) {
         try {
            this.ensureImeVisible.invoke(var1, new Object[]{Boolean.valueOf(var2)});
         } catch (Exception var3) {
            return;
         }
      }

   }

   void showSoftInputUnchecked(InputMethodManager var1, View var2, int var3) {
      if(this.showSoftInputUnchecked != null) {
         try {
            this.showSoftInputUnchecked.invoke(var1, new Object[]{Integer.valueOf(var3), null});
            return;
         } catch (Exception var5) {
            ;
         }
      }

      var1.showSoftInput(var2, var3);
   }
}
