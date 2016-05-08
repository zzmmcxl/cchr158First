package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle$Delegate;
import android.support.v7.app.AppCompatDelegateImplBase;
import android.support.v7.appcompat.R$attr;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;

class AppCompatDelegateImplBase$ActionBarDrawableToggleImpl implements ActionBarDrawerToggle$Delegate {
   private AppCompatDelegateImplBase$ActionBarDrawableToggleImpl(AppCompatDelegateImplBase var1) {
      this.this$0 = var1;
   }

   public Context getActionBarThemedContext() {
      return this.this$0.getActionBarThemedContext();
   }

   public Drawable getThemeUpIndicator() {
      TintTypedArray var1 = TintTypedArray.obtainStyledAttributes(this.getActionBarThemedContext(), (AttributeSet)null, new int[]{R$attr.homeAsUpIndicator});
      Drawable var2 = var1.getDrawable(0);
      var1.recycle();
      return var2;
   }

   public boolean isNavigationVisible() {
      ActionBar var1 = this.this$0.getSupportActionBar();
      return var1 != null && (var1.getDisplayOptions() & 4) != 0;
   }

   public void setActionBarDescription(int var1) {
      ActionBar var2 = this.this$0.getSupportActionBar();
      if(var2 != null) {
         var2.setHomeActionContentDescription(var1);
      }

   }

   public void setActionBarUpIndicator(Drawable var1, int var2) {
      ActionBar var3 = this.this$0.getSupportActionBar();
      if(var3 != null) {
         var3.setHomeAsUpIndicator(var1);
         var3.setHomeActionContentDescription(var2);
      }

   }
}
