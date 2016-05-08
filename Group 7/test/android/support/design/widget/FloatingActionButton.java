package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.R$dimen;
import android.support.design.R$style;
import android.support.design.R$styleable;
import android.support.design.widget.CoordinatorLayout$DefaultBehavior;
import android.support.design.widget.FloatingActionButton$1;
import android.support.design.widget.FloatingActionButton$Behavior;
import android.support.design.widget.FloatingActionButton$OnVisibilityChangedListener;
import android.support.design.widget.FloatingActionButton$ShadowDelegateImpl;
import android.support.design.widget.FloatingActionButtonEclairMr1;
import android.support.design.widget.FloatingActionButtonIcs;
import android.support.design.widget.FloatingActionButtonImpl;
import android.support.design.widget.FloatingActionButtonImpl$InternalVisibilityChangedListener;
import android.support.design.widget.FloatingActionButtonLollipop;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.MeasureSpec;

@CoordinatorLayout$DefaultBehavior(FloatingActionButton$Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
   private static final String LOG_TAG = "FloatingActionButton";
   private static final int SIZE_MINI = 1;
   private static final int SIZE_NORMAL = 0;
   private ColorStateList mBackgroundTint;
   private Mode mBackgroundTintMode;
   private int mBorderWidth;
   private boolean mCompatPadding;
   private AppCompatImageHelper mImageHelper;
   private int mImagePadding;
   private FloatingActionButtonImpl mImpl;
   private int mRippleColor;
   private final Rect mShadowPadding;
   private int mSize;

   public FloatingActionButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public FloatingActionButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public FloatingActionButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mShadowPadding = new Rect();
      ThemeUtils.checkAppCompatTheme(var1);
      TypedArray var6 = var1.obtainStyledAttributes(var2, R$styleable.FloatingActionButton, var3, R$style.Widget_Design_FloatingActionButton);
      this.mBackgroundTint = var6.getColorStateList(R$styleable.FloatingActionButton_backgroundTint);
      this.mBackgroundTintMode = parseTintMode(var6.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), (Mode)null);
      this.mRippleColor = var6.getColor(R$styleable.FloatingActionButton_rippleColor, 0);
      this.mSize = var6.getInt(R$styleable.FloatingActionButton_fabSize, 0);
      this.mBorderWidth = var6.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
      float var4 = var6.getDimension(R$styleable.FloatingActionButton_elevation, 0.0F);
      float var5 = var6.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
      this.mCompatPadding = var6.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
      var6.recycle();
      this.mImageHelper = new AppCompatImageHelper(this, AppCompatDrawableManager.get());
      this.mImageHelper.loadFromAttributes(var2, var3);
      var3 = (int)this.getResources().getDimension(R$dimen.design_fab_image_size);
      this.mImagePadding = (this.getSizeDimension() - var3) / 2;
      this.getImpl().setBackgroundDrawable(this.mBackgroundTint, this.mBackgroundTintMode, this.mRippleColor, this.mBorderWidth);
      this.getImpl().setElevation(var4);
      this.getImpl().setPressedTranslationZ(var5);
      this.getImpl().updatePadding();
   }

   private FloatingActionButtonImpl createImpl() {
      int var1 = VERSION.SDK_INT;
      return (FloatingActionButtonImpl)(var1 >= 21?new FloatingActionButtonLollipop(this, new FloatingActionButton$ShadowDelegateImpl(this, (FloatingActionButton$1)null)):(var1 >= 14?new FloatingActionButtonIcs(this, new FloatingActionButton$ShadowDelegateImpl(this, (FloatingActionButton$1)null)):new FloatingActionButtonEclairMr1(this, new FloatingActionButton$ShadowDelegateImpl(this, (FloatingActionButton$1)null))));
   }

   private FloatingActionButtonImpl getImpl() {
      if(this.mImpl == null) {
         this.mImpl = this.createImpl();
      }

      return this.mImpl;
   }

   private void hide(@Nullable FloatingActionButton$OnVisibilityChangedListener var1, boolean var2) {
      this.getImpl().hide(this.wrapOnVisibilityChangedListener(var1), var2);
   }

   static Mode parseTintMode(int var0, Mode var1) {
      switch(var0) {
      case 3:
         return Mode.SRC_OVER;
      case 5:
         return Mode.SRC_IN;
      case 9:
         return Mode.SRC_ATOP;
      case 14:
         return Mode.MULTIPLY;
      case 15:
         return Mode.SCREEN;
      default:
         return var1;
      }
   }

   private static int resolveAdjustedSize(int var0, int var1) {
      int var2 = MeasureSpec.getMode(var1);
      var1 = MeasureSpec.getSize(var1);
      switch(var2) {
      case Integer.MIN_VALUE:
         return Math.min(var0, var1);
      case 0:
         return var0;
      case 1073741824:
         return var1;
      default:
         return var0;
      }
   }

   private void show(FloatingActionButton$OnVisibilityChangedListener var1, boolean var2) {
      this.getImpl().show(this.wrapOnVisibilityChangedListener(var1), var2);
   }

   @Nullable
   private FloatingActionButtonImpl$InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable FloatingActionButton$OnVisibilityChangedListener var1) {
      return var1 == null?null:new FloatingActionButton$1(this, var1);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.getImpl().onDrawableStateChanged(this.getDrawableState());
   }

   @Nullable
   public ColorStateList getBackgroundTintList() {
      return this.mBackgroundTint;
   }

   @Nullable
   public Mode getBackgroundTintMode() {
      return this.mBackgroundTintMode;
   }

   public float getCompatElevation() {
      return this.getImpl().getElevation();
   }

   @NonNull
   public Drawable getContentBackground() {
      return this.getImpl().getContentBackground();
   }

   public boolean getContentRect(@NonNull Rect var1) {
      boolean var2 = false;
      if(ViewCompat.isLaidOut(this)) {
         var1.set(0, 0, this.getWidth(), this.getHeight());
         var1.left += this.mShadowPadding.left;
         var1.top += this.mShadowPadding.top;
         var1.right -= this.mShadowPadding.right;
         var1.bottom -= this.mShadowPadding.bottom;
         var2 = true;
      }

      return var2;
   }

   final int getSizeDimension() {
      switch(this.mSize) {
      case 1:
         return this.getResources().getDimensionPixelSize(R$dimen.design_fab_size_mini);
      default:
         return this.getResources().getDimensionPixelSize(R$dimen.design_fab_size_normal);
      }
   }

   public boolean getUseCompatPadding() {
      return this.mCompatPadding;
   }

   public void hide() {
      this.hide((FloatingActionButton$OnVisibilityChangedListener)null);
   }

   public void hide(@Nullable FloatingActionButton$OnVisibilityChangedListener var1) {
      this.hide(var1, true);
   }

   @TargetApi(11)
   public void jumpDrawablesToCurrentState() {
      super.jumpDrawablesToCurrentState();
      this.getImpl().jumpDrawableToCurrentState();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.getImpl().onAttachedToWindow();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.getImpl().onDetachedFromWindow();
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = this.getSizeDimension();
      var1 = Math.min(resolveAdjustedSize(var3, var1), resolveAdjustedSize(var3, var2));
      this.setMeasuredDimension(this.mShadowPadding.left + var1 + this.mShadowPadding.right, this.mShadowPadding.top + var1 + this.mShadowPadding.bottom);
   }

   public void setBackgroundColor(int var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundDrawable(Drawable var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundResource(int var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundTintList(@Nullable ColorStateList var1) {
      if(this.mBackgroundTint != var1) {
         this.mBackgroundTint = var1;
         this.getImpl().setBackgroundTintList(var1);
      }

   }

   public void setBackgroundTintMode(@Nullable Mode var1) {
      if(this.mBackgroundTintMode != var1) {
         this.mBackgroundTintMode = var1;
         this.getImpl().setBackgroundTintMode(var1);
      }

   }

   public void setCompatElevation(float var1) {
      this.getImpl().setElevation(var1);
   }

   public void setImageResource(@DrawableRes int var1) {
      this.mImageHelper.setImageResource(var1);
   }

   public void setRippleColor(@ColorInt int var1) {
      if(this.mRippleColor != var1) {
         this.mRippleColor = var1;
         this.getImpl().setRippleColor(var1);
      }

   }

   public void setUseCompatPadding(boolean var1) {
      if(this.mCompatPadding != var1) {
         this.mCompatPadding = var1;
         this.getImpl().onCompatShadowChanged();
      }

   }

   public void show() {
      this.show((FloatingActionButton$OnVisibilityChangedListener)null);
   }

   public void show(@Nullable FloatingActionButton$OnVisibilityChangedListener var1) {
      this.show(var1, true);
   }
}
