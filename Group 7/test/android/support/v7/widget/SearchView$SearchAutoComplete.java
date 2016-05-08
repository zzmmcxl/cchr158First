package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.appcompat.R$attr;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.InputMethodManager;

public class SearchView$SearchAutoComplete extends AppCompatAutoCompleteTextView {
   private SearchView mSearchView;
   private int mThreshold;

   public SearchView$SearchAutoComplete(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SearchView$SearchAutoComplete(Context var1, AttributeSet var2) {
      this(var1, var2, R$attr.autoCompleteTextViewStyle);
   }

   public SearchView$SearchAutoComplete(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mThreshold = this.getThreshold();
   }

   private boolean isEmpty() {
      return TextUtils.getTrimmedLength(this.getText()) == 0;
   }

   public boolean enoughToFilter() {
      return this.mThreshold <= 0 || super.enoughToFilter();
   }

   protected void onFocusChanged(boolean var1, int var2, Rect var3) {
      super.onFocusChanged(var1, var2, var3);
      this.mSearchView.onTextFocusChanged();
   }

   public boolean onKeyPreIme(int var1, KeyEvent var2) {
      if(var1 == 4) {
         DispatcherState var3;
         if(var2.getAction() == 0 && var2.getRepeatCount() == 0) {
            var3 = this.getKeyDispatcherState();
            if(var3 != null) {
               var3.startTracking(var2, this);
            }

            return true;
         }

         if(var2.getAction() == 1) {
            var3 = this.getKeyDispatcherState();
            if(var3 != null) {
               var3.handleUpEvent(var2);
            }

            if(var2.isTracking() && !var2.isCanceled()) {
               this.mSearchView.clearFocus();
               SearchView.access$2100(this.mSearchView, false);
               return true;
            }
         }
      }

      return super.onKeyPreIme(var1, var2);
   }

   public void onWindowFocusChanged(boolean var1) {
      super.onWindowFocusChanged(var1);
      if(var1 && this.mSearchView.hasFocus() && this.getVisibility() == 0) {
         ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput(this, 0);
         if(SearchView.isLandscapeMode(this.getContext())) {
            SearchView.HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
         }
      }

   }

   public void performCompletion() {
   }

   protected void replaceText(CharSequence var1) {
   }

   void setSearchView(SearchView var1) {
      this.mSearchView = var1;
   }

   public void setThreshold(int var1) {
      super.setThreshold(var1);
      this.mThreshold = var1;
   }
}
