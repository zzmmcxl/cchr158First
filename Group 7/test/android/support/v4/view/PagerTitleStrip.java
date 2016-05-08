package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip$1;
import android.support.v4.view.PagerTitleStrip$PageListener;
import android.support.v4.view.PagerTitleStrip$PagerTitleStripImpl;
import android.support.v4.view.PagerTitleStrip$PagerTitleStripImplBase;
import android.support.v4.view.PagerTitleStrip$PagerTitleStripImplIcs;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager$Decor;
import android.support.v4.view.ViewPager$OnAdapterChangeListener;
import android.support.v4.view.ViewPager$OnPageChangeListener;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements ViewPager$Decor {
   private static final int[] ATTRS = new int[]{16842804, 16842901, 16842904, 16842927};
   private static final PagerTitleStrip$PagerTitleStripImpl IMPL;
   private static final float SIDE_ALPHA = 0.6F;
   private static final String TAG = "PagerTitleStrip";
   private static final int[] TEXT_ATTRS = new int[]{16843660};
   private static final int TEXT_SPACING = 16;
   TextView mCurrText;
   private int mGravity;
   private int mLastKnownCurrentPage;
   private float mLastKnownPositionOffset;
   TextView mNextText;
   private int mNonPrimaryAlpha;
   private final PagerTitleStrip$PageListener mPageListener;
   ViewPager mPager;
   TextView mPrevText;
   private int mScaledTextSpacing;
   int mTextColor;
   private boolean mUpdatingPositions;
   private boolean mUpdatingText;
   private WeakReference<PagerAdapter> mWatchingAdapter;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new PagerTitleStrip$PagerTitleStripImplIcs();
      } else {
         IMPL = new PagerTitleStrip$PagerTitleStripImplBase();
      }
   }

   public PagerTitleStrip(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public PagerTitleStrip(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mLastKnownCurrentPage = -1;
      this.mLastKnownPositionOffset = -1.0F;
      this.mPageListener = new PagerTitleStrip$PageListener(this, (PagerTitleStrip$1)null);
      TextView var6 = new TextView(var1);
      this.mPrevText = var6;
      this.addView(var6);
      var6 = new TextView(var1);
      this.mCurrText = var6;
      this.addView(var6);
      var6 = new TextView(var1);
      this.mNextText = var6;
      this.addView(var6);
      TypedArray var7 = var1.obtainStyledAttributes(var2, ATTRS);
      int var3 = var7.getResourceId(0, 0);
      if(var3 != 0) {
         this.mPrevText.setTextAppearance(var1, var3);
         this.mCurrText.setTextAppearance(var1, var3);
         this.mNextText.setTextAppearance(var1, var3);
      }

      int var4 = var7.getDimensionPixelSize(1, 0);
      if(var4 != 0) {
         this.setTextSize(0, (float)var4);
      }

      if(var7.hasValue(2)) {
         var4 = var7.getColor(2, 0);
         this.mPrevText.setTextColor(var4);
         this.mCurrText.setTextColor(var4);
         this.mNextText.setTextColor(var4);
      }

      this.mGravity = var7.getInteger(3, 80);
      var7.recycle();
      this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
      this.setNonPrimaryAlpha(0.6F);
      this.mPrevText.setEllipsize(TruncateAt.END);
      this.mCurrText.setEllipsize(TruncateAt.END);
      this.mNextText.setEllipsize(TruncateAt.END);
      boolean var5 = false;
      if(var3 != 0) {
         var7 = var1.obtainStyledAttributes(var3, TEXT_ATTRS);
         var5 = var7.getBoolean(0, false);
         var7.recycle();
      }

      if(var5) {
         setSingleLineAllCaps(this.mPrevText);
         setSingleLineAllCaps(this.mCurrText);
         setSingleLineAllCaps(this.mNextText);
      } else {
         this.mPrevText.setSingleLine();
         this.mCurrText.setSingleLine();
         this.mNextText.setSingleLine();
      }

      this.mScaledTextSpacing = (int)(16.0F * var1.getResources().getDisplayMetrics().density);
   }

   private static void setSingleLineAllCaps(TextView var0) {
      IMPL.setSingleLineAllCaps(var0);
   }

   int getMinHeight() {
      int var1 = 0;
      Drawable var2 = this.getBackground();
      if(var2 != null) {
         var1 = var2.getIntrinsicHeight();
      }

      return var1;
   }

   public int getTextSpacing() {
      return this.mScaledTextSpacing;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      ViewParent var1 = this.getParent();
      if(!(var1 instanceof ViewPager)) {
         throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
      } else {
         ViewPager var3 = (ViewPager)var1;
         PagerAdapter var2 = var3.getAdapter();
         var3.setInternalPageChangeListener(this.mPageListener);
         var3.setOnAdapterChangeListener(this.mPageListener);
         this.mPager = var3;
         PagerAdapter var4;
         if(this.mWatchingAdapter != null) {
            var4 = (PagerAdapter)this.mWatchingAdapter.get();
         } else {
            var4 = null;
         }

         this.updateAdapter(var4, var2);
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mPager != null) {
         this.updateAdapter(this.mPager.getAdapter(), (PagerAdapter)null);
         this.mPager.setInternalPageChangeListener((ViewPager$OnPageChangeListener)null);
         this.mPager.setOnAdapterChangeListener((ViewPager$OnAdapterChangeListener)null);
         this.mPager = null;
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      float var6 = 0.0F;
      if(this.mPager != null) {
         if(this.mLastKnownPositionOffset >= 0.0F) {
            var6 = this.mLastKnownPositionOffset;
         }

         this.updateTextPositions(this.mLastKnownCurrentPage, var6, true);
      }

   }

   protected void onMeasure(int var1, int var2) {
      if(MeasureSpec.getMode(var1) != 1073741824) {
         throw new IllegalStateException("Must measure with an exact width");
      } else {
         int var4 = this.getPaddingTop() + this.getPaddingBottom();
         int var5 = getChildMeasureSpec(var2, var4, -2);
         int var3 = MeasureSpec.getSize(var1);
         var1 = getChildMeasureSpec(var1, (int)((float)var3 * 0.2F), -2);
         this.mPrevText.measure(var1, var5);
         this.mCurrText.measure(var1, var5);
         this.mNextText.measure(var1, var5);
         if(MeasureSpec.getMode(var2) == 1073741824) {
            var1 = MeasureSpec.getSize(var2);
         } else {
            var1 = this.mCurrText.getMeasuredHeight();
            var1 = Math.max(this.getMinHeight(), var1 + var4);
         }

         this.setMeasuredDimension(var3, ViewCompat.resolveSizeAndState(var1, var2, ViewCompat.getMeasuredState(this.mCurrText) << 16));
      }
   }

   public void requestLayout() {
      if(!this.mUpdatingText) {
         super.requestLayout();
      }

   }

   public void setGravity(int var1) {
      this.mGravity = var1;
      this.requestLayout();
   }

   public void setNonPrimaryAlpha(@FloatRange(
   from = 0.0D,
   to = 1.0D
) float var1) {
      this.mNonPrimaryAlpha = (int)(255.0F * var1) & 255;
      int var2 = this.mNonPrimaryAlpha << 24 | this.mTextColor & 16777215;
      this.mPrevText.setTextColor(var2);
      this.mNextText.setTextColor(var2);
   }

   public void setTextColor(@ColorInt int var1) {
      this.mTextColor = var1;
      this.mCurrText.setTextColor(var1);
      var1 = this.mNonPrimaryAlpha << 24 | this.mTextColor & 16777215;
      this.mPrevText.setTextColor(var1);
      this.mNextText.setTextColor(var1);
   }

   public void setTextSize(int var1, float var2) {
      this.mPrevText.setTextSize(var1, var2);
      this.mCurrText.setTextSize(var1, var2);
      this.mNextText.setTextSize(var1, var2);
   }

   public void setTextSpacing(int var1) {
      this.mScaledTextSpacing = var1;
      this.requestLayout();
   }

   void updateAdapter(PagerAdapter var1, PagerAdapter var2) {
      if(var1 != null) {
         var1.unregisterDataSetObserver(this.mPageListener);
         this.mWatchingAdapter = null;
      }

      if(var2 != null) {
         var2.registerDataSetObserver(this.mPageListener);
         this.mWatchingAdapter = new WeakReference(var2);
      }

      if(this.mPager != null) {
         this.mLastKnownCurrentPage = -1;
         this.mLastKnownPositionOffset = -1.0F;
         this.updateText(this.mPager.getCurrentItem(), var2);
         this.requestLayout();
      }

   }

   void updateText(int var1, PagerAdapter var2) {
      int var3;
      if(var2 != null) {
         var3 = var2.getCount();
      } else {
         var3 = 0;
      }

      this.mUpdatingText = true;
      TextView var6 = null;
      CharSequence var5 = var6;
      if(var1 >= 1) {
         var5 = var6;
         if(var2 != null) {
            var5 = var2.getPageTitle(var1 - 1);
         }
      }

      this.mPrevText.setText(var5);
      var6 = this.mCurrText;
      if(var2 != null && var1 < var3) {
         var5 = var2.getPageTitle(var1);
      } else {
         var5 = null;
      }

      var6.setText(var5);
      var6 = null;
      var5 = var6;
      if(var1 + 1 < var3) {
         var5 = var6;
         if(var2 != null) {
            var5 = var2.getPageTitle(var1 + 1);
         }
      }

      this.mNextText.setText(var5);
      var3 = MeasureSpec.makeMeasureSpec(Math.max(0, (int)((float)(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight()) * 0.8F)), Integer.MIN_VALUE);
      int var4 = MeasureSpec.makeMeasureSpec(Math.max(0, this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()), Integer.MIN_VALUE);
      this.mPrevText.measure(var3, var4);
      this.mCurrText.measure(var3, var4);
      this.mNextText.measure(var3, var4);
      this.mLastKnownCurrentPage = var1;
      if(!this.mUpdatingPositions) {
         this.updateTextPositions(var1, this.mLastKnownPositionOffset, false);
      }

      this.mUpdatingText = false;
   }

   void updateTextPositions(int var1, float var2, boolean var3) {
      if(var1 != this.mLastKnownCurrentPage) {
         this.updateText(var1, this.mPager.getAdapter());
      } else if(!var3 && var2 == this.mLastKnownPositionOffset) {
         return;
      }

      this.mUpdatingPositions = true;
      int var9 = this.mPrevText.getMeasuredWidth();
      int var14 = this.mCurrText.getMeasuredWidth();
      int var8 = this.mNextText.getMeasuredWidth();
      int var13 = var14 / 2;
      int var10 = this.getWidth();
      int var6 = this.getHeight();
      int var12 = this.getPaddingLeft();
      int var11 = this.getPaddingRight();
      var1 = this.getPaddingTop();
      int var7 = this.getPaddingBottom();
      int var15 = var11 + var13;
      float var5 = var2 + 0.5F;
      float var4 = var5;
      if(var5 > 1.0F) {
         var4 = var5 - 1.0F;
      }

      var13 = var10 - var15 - (int)((float)(var10 - (var12 + var13) - var15) * var4) - var14 / 2;
      var14 += var13;
      int var17 = this.mPrevText.getBaseline();
      int var16 = this.mCurrText.getBaseline();
      var15 = this.mNextText.getBaseline();
      int var18 = Math.max(Math.max(var17, var16), var15);
      var17 = var18 - var17;
      var16 = var18 - var16;
      var15 = var18 - var15;
      var18 = this.mPrevText.getMeasuredHeight();
      int var19 = this.mCurrText.getMeasuredHeight();
      int var20 = this.mNextText.getMeasuredHeight();
      var18 = Math.max(Math.max(var17 + var18, var16 + var19), var15 + var20);
      switch(this.mGravity & 112) {
      case 16:
         var1 = (var6 - var1 - var7 - var18) / 2;
         var7 = var1 + var17;
         var6 = var1 + var16;
         var1 += var15;
         break;
      case 80:
         var1 = var6 - var7 - var18;
         var7 = var1 + var17;
         var6 = var1 + var16;
         var1 += var15;
         break;
      default:
         var7 = var1 + var17;
         var6 = var1 + var16;
         var1 += var15;
      }

      this.mCurrText.layout(var13, var6, var14, this.mCurrText.getMeasuredHeight() + var6);
      var6 = Math.min(var12, var13 - this.mScaledTextSpacing - var9);
      this.mPrevText.layout(var6, var7, var6 + var9, this.mPrevText.getMeasuredHeight() + var7);
      var6 = Math.max(var10 - var11 - var8, this.mScaledTextSpacing + var14);
      this.mNextText.layout(var6, var1, var6 + var8, this.mNextText.getMeasuredHeight() + var1);
      this.mLastKnownPositionOffset = var2;
      this.mUpdatingPositions = false;
   }
}
