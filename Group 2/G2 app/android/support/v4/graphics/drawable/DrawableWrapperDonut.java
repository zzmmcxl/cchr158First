package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.graphics.drawable.DrawableWrapper;

class DrawableWrapperDonut extends Drawable implements Callback, DrawableWrapper {
   static final Mode DEFAULT_MODE;
   private boolean mColorFilterSet;
   private int mCurrentColor;
   private Mode mCurrentMode;
   Drawable mDrawable;
   private ColorStateList mTintList;
   private Mode mTintMode;

   static {
      DEFAULT_MODE = Mode.SRC_IN;
   }

   DrawableWrapperDonut(Drawable var1) {
      this.mTintMode = DEFAULT_MODE;
      this.setWrappedDrawable(var1);
   }

   private boolean updateTint(int[] var1) {
      if(this.mTintList != null && this.mTintMode != null) {
         int var2 = this.mTintList.getColorForState(var1, this.mTintList.getDefaultColor());
         Mode var3 = this.mTintMode;
         if(!this.mColorFilterSet || var2 != this.mCurrentColor || var3 != this.mCurrentMode) {
            this.setColorFilter(var2, var3);
            this.mCurrentColor = var2;
            this.mCurrentMode = var3;
            this.mColorFilterSet = true;
            return true;
         }
      }

      return false;
   }

   public void draw(Canvas var1) {
      this.mDrawable.draw(var1);
   }

   public int getChangingConfigurations() {
      return this.mDrawable.getChangingConfigurations();
   }

   public Drawable getCurrent() {
      return this.mDrawable.getCurrent();
   }

   public int getIntrinsicHeight() {
      return this.mDrawable.getIntrinsicHeight();
   }

   public int getIntrinsicWidth() {
      return this.mDrawable.getIntrinsicWidth();
   }

   public int getMinimumHeight() {
      return this.mDrawable.getMinimumHeight();
   }

   public int getMinimumWidth() {
      return this.mDrawable.getMinimumWidth();
   }

   public int getOpacity() {
      return this.mDrawable.getOpacity();
   }

   public boolean getPadding(Rect var1) {
      return this.mDrawable.getPadding(var1);
   }

   public int[] getState() {
      return this.mDrawable.getState();
   }

   public Region getTransparentRegion() {
      return this.mDrawable.getTransparentRegion();
   }

   public Drawable getWrappedDrawable() {
      return this.mDrawable;
   }

   public void invalidateDrawable(Drawable var1) {
      this.invalidateSelf();
   }

   public boolean isStateful() {
      return this.mTintList != null && this.mTintList.isStateful() || this.mDrawable.isStateful();
   }

   public Drawable mutate() {
      Drawable var1 = this.mDrawable;
      Drawable var2 = var1.mutate();
      if(var2 != var1) {
         this.setWrappedDrawable(var2);
      }

      return this;
   }

   protected void onBoundsChange(Rect var1) {
      this.mDrawable.setBounds(var1);
   }

   protected boolean onLevelChange(int var1) {
      return this.mDrawable.setLevel(var1);
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      this.scheduleSelf(var2, var3);
   }

   public void setAlpha(int var1) {
      this.mDrawable.setAlpha(var1);
   }

   public void setChangingConfigurations(int var1) {
      this.mDrawable.setChangingConfigurations(var1);
   }

   public void setColorFilter(ColorFilter var1) {
      this.mDrawable.setColorFilter(var1);
   }

   public void setDither(boolean var1) {
      this.mDrawable.setDither(var1);
   }

   public void setFilterBitmap(boolean var1) {
      this.mDrawable.setFilterBitmap(var1);
   }

   public boolean setState(int[] var1) {
      boolean var2 = this.mDrawable.setState(var1);
      return this.updateTint(var1) || var2;
   }

   public void setTint(int var1) {
      this.setTintList(ColorStateList.valueOf(var1));
   }

   public void setTintList(ColorStateList var1) {
      this.mTintList = var1;
      this.updateTint(this.getState());
   }

   public void setTintMode(Mode var1) {
      this.mTintMode = var1;
      this.updateTint(this.getState());
   }

   public boolean setVisible(boolean var1, boolean var2) {
      return super.setVisible(var1, var2) || this.mDrawable.setVisible(var1, var2);
   }

   public void setWrappedDrawable(Drawable var1) {
      if(this.mDrawable != null) {
         this.mDrawable.setCallback((Callback)null);
      }

      this.mDrawable = var1;
      if(var1 != null) {
         var1.setCallback(this);
      }

      this.invalidateSelf();
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      this.unscheduleSelf(var2);
   }
}
