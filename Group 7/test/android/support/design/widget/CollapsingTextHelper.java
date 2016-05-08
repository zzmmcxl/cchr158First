package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.design.R$styleable;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.MathUtils;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class CollapsingTextHelper {
   private static final boolean DEBUG_DRAW = false;
   private static final Paint DEBUG_DRAW_PAINT;
   private static final boolean USE_SCALING_TEXTURE;
   private boolean mBoundsChanged;
   private final Rect mCollapsedBounds;
   private float mCollapsedDrawX;
   private float mCollapsedDrawY;
   private int mCollapsedShadowColor;
   private float mCollapsedShadowDx;
   private float mCollapsedShadowDy;
   private float mCollapsedShadowRadius;
   private int mCollapsedTextColor;
   private int mCollapsedTextGravity = 16;
   private float mCollapsedTextSize = 15.0F;
   private Typeface mCollapsedTypeface;
   private final RectF mCurrentBounds;
   private float mCurrentDrawX;
   private float mCurrentDrawY;
   private float mCurrentTextSize;
   private Typeface mCurrentTypeface;
   private boolean mDrawTitle;
   private final Rect mExpandedBounds;
   private float mExpandedDrawX;
   private float mExpandedDrawY;
   private float mExpandedFraction;
   private int mExpandedShadowColor;
   private float mExpandedShadowDx;
   private float mExpandedShadowDy;
   private float mExpandedShadowRadius;
   private int mExpandedTextColor;
   private int mExpandedTextGravity = 16;
   private float mExpandedTextSize = 15.0F;
   private Bitmap mExpandedTitleTexture;
   private Typeface mExpandedTypeface;
   private boolean mIsRtl;
   private Interpolator mPositionInterpolator;
   private float mScale;
   private CharSequence mText;
   private final TextPaint mTextPaint;
   private Interpolator mTextSizeInterpolator;
   private CharSequence mTextToDraw;
   private float mTextureAscent;
   private float mTextureDescent;
   private Paint mTexturePaint;
   private boolean mUseTexture;
   private final View mView;

   static {
      boolean var0;
      if(VERSION.SDK_INT < 18) {
         var0 = true;
      } else {
         var0 = false;
      }

      USE_SCALING_TEXTURE = var0;
      DEBUG_DRAW_PAINT = null;
      if(DEBUG_DRAW_PAINT != null) {
         DEBUG_DRAW_PAINT.setAntiAlias(true);
         DEBUG_DRAW_PAINT.setColor(-65281);
      }

   }

   public CollapsingTextHelper(View var1) {
      this.mView = var1;
      this.mTextPaint = new TextPaint(129);
      this.mCollapsedBounds = new Rect();
      this.mExpandedBounds = new Rect();
      this.mCurrentBounds = new RectF();
   }

   private static int blendColors(int var0, int var1, float var2) {
      float var3 = 1.0F - var2;
      float var4 = (float)Color.alpha(var0);
      float var5 = (float)Color.alpha(var1);
      float var6 = (float)Color.red(var0);
      float var7 = (float)Color.red(var1);
      float var8 = (float)Color.green(var0);
      float var9 = (float)Color.green(var1);
      float var10 = (float)Color.blue(var0);
      float var11 = (float)Color.blue(var1);
      return Color.argb((int)(var4 * var3 + var5 * var2), (int)(var6 * var3 + var7 * var2), (int)(var8 * var3 + var9 * var2), (int)(var10 * var3 + var11 * var2));
   }

   private void calculateBaseOffsets() {
      byte var6 = 1;
      float var2 = this.mCurrentTextSize;
      this.calculateUsingTextSize(this.mCollapsedTextSize);
      float var1;
      if(this.mTextToDraw != null) {
         var1 = this.mTextPaint.measureText(this.mTextToDraw, 0, this.mTextToDraw.length());
      } else {
         var1 = 0.0F;
      }

      int var7 = this.mCollapsedTextGravity;
      byte var5;
      if(this.mIsRtl) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var8 = GravityCompat.getAbsoluteGravity(var7, var5);
      float var3;
      float var4;
      switch(var8 & 112) {
      case 48:
         this.mCollapsedDrawY = (float)this.mCollapsedBounds.top - this.mTextPaint.ascent();
         break;
      case 80:
         this.mCollapsedDrawY = (float)this.mCollapsedBounds.bottom;
         break;
      default:
         var3 = (this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0F;
         var4 = this.mTextPaint.descent();
         this.mCollapsedDrawY = (float)this.mCollapsedBounds.centerY() + (var3 - var4);
      }

      switch(var8 & 7) {
      case 1:
         this.mCollapsedDrawX = (float)this.mCollapsedBounds.centerX() - var1 / 2.0F;
         break;
      case 5:
         this.mCollapsedDrawX = (float)this.mCollapsedBounds.right - var1;
         break;
      default:
         this.mCollapsedDrawX = (float)this.mCollapsedBounds.left;
      }

      this.calculateUsingTextSize(this.mExpandedTextSize);
      if(this.mTextToDraw != null) {
         var1 = this.mTextPaint.measureText(this.mTextToDraw, 0, this.mTextToDraw.length());
      } else {
         var1 = 0.0F;
      }

      var7 = this.mExpandedTextGravity;
      if(this.mIsRtl) {
         var5 = var6;
      } else {
         var5 = 0;
      }

      var8 = GravityCompat.getAbsoluteGravity(var7, var5);
      switch(var8 & 112) {
      case 48:
         this.mExpandedDrawY = (float)this.mExpandedBounds.top - this.mTextPaint.ascent();
         break;
      case 80:
         this.mExpandedDrawY = (float)this.mExpandedBounds.bottom;
         break;
      default:
         var3 = (this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0F;
         var4 = this.mTextPaint.descent();
         this.mExpandedDrawY = (float)this.mExpandedBounds.centerY() + (var3 - var4);
      }

      switch(var8 & 7) {
      case 1:
         this.mExpandedDrawX = (float)this.mExpandedBounds.centerX() - var1 / 2.0F;
         break;
      case 5:
         this.mExpandedDrawX = (float)this.mExpandedBounds.right - var1;
         break;
      default:
         this.mExpandedDrawX = (float)this.mExpandedBounds.left;
      }

      this.clearTexture();
      this.setInterpolatedTextSize(var2);
   }

   private void calculateCurrentOffsets() {
      this.calculateOffsets(this.mExpandedFraction);
   }

   private boolean calculateIsRtl(CharSequence var1) {
      boolean var2 = true;
      if(ViewCompat.getLayoutDirection(this.mView) != 1) {
         var2 = false;
      }

      TextDirectionHeuristicCompat var3;
      if(var2) {
         var3 = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
      } else {
         var3 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
      }

      return var3.isRtl((CharSequence)var1, 0, var1.length());
   }

   private void calculateOffsets(float var1) {
      this.interpolateBounds(var1);
      this.mCurrentDrawX = lerp(this.mExpandedDrawX, this.mCollapsedDrawX, var1, this.mPositionInterpolator);
      this.mCurrentDrawY = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, var1, this.mPositionInterpolator);
      this.setInterpolatedTextSize(lerp(this.mExpandedTextSize, this.mCollapsedTextSize, var1, this.mTextSizeInterpolator));
      if(this.mCollapsedTextColor != this.mExpandedTextColor) {
         this.mTextPaint.setColor(blendColors(this.mExpandedTextColor, this.mCollapsedTextColor, var1));
      } else {
         this.mTextPaint.setColor(this.mCollapsedTextColor);
      }

      this.mTextPaint.setShadowLayer(lerp(this.mExpandedShadowRadius, this.mCollapsedShadowRadius, var1, (Interpolator)null), lerp(this.mExpandedShadowDx, this.mCollapsedShadowDx, var1, (Interpolator)null), lerp(this.mExpandedShadowDy, this.mCollapsedShadowDy, var1, (Interpolator)null), blendColors(this.mExpandedShadowColor, this.mCollapsedShadowColor, var1));
      ViewCompat.postInvalidateOnAnimation(this.mView);
   }

   private void calculateUsingTextSize(float var1) {
      boolean var7 = true;
      if(this.mText != null) {
         boolean var6 = false;
         boolean var5 = false;
         float var2;
         float var3;
         if(isClose(var1, this.mCollapsedTextSize)) {
            var3 = (float)this.mCollapsedBounds.width();
            float var4 = this.mCollapsedTextSize;
            this.mScale = 1.0F;
            var1 = var3;
            var2 = var4;
            if(this.mCurrentTypeface != this.mCollapsedTypeface) {
               this.mCurrentTypeface = this.mCollapsedTypeface;
               var5 = true;
               var2 = var4;
               var1 = var3;
            }
         } else {
            var3 = (float)this.mExpandedBounds.width();
            var2 = this.mExpandedTextSize;
            var5 = var6;
            if(this.mCurrentTypeface != this.mExpandedTypeface) {
               this.mCurrentTypeface = this.mExpandedTypeface;
               var5 = true;
            }

            if(isClose(var1, this.mExpandedTextSize)) {
               this.mScale = 1.0F;
               var1 = var3;
            } else {
               this.mScale = var1 / this.mExpandedTextSize;
               var1 = var3;
            }
         }

         var6 = var5;
         if(var1 > 0.0F) {
            if(this.mCurrentTextSize == var2 && !this.mBoundsChanged && !var5) {
               var5 = false;
            } else {
               var5 = true;
            }

            this.mCurrentTextSize = var2;
            this.mBoundsChanged = false;
            var6 = var5;
         }

         if(this.mTextToDraw == null || var6) {
            this.mTextPaint.setTextSize(this.mCurrentTextSize);
            this.mTextPaint.setTypeface(this.mCurrentTypeface);
            TextPaint var8 = this.mTextPaint;
            if(this.mScale == 1.0F) {
               var7 = false;
            }

            var8.setLinearText(var7);
            CharSequence var9 = TextUtils.ellipsize(this.mText, this.mTextPaint, var1, TruncateAt.END);
            if(!TextUtils.equals(var9, this.mTextToDraw)) {
               this.mTextToDraw = var9;
               this.mIsRtl = this.calculateIsRtl(this.mTextToDraw);
               return;
            }
         }
      }

   }

   private void clearTexture() {
      if(this.mExpandedTitleTexture != null) {
         this.mExpandedTitleTexture.recycle();
         this.mExpandedTitleTexture = null;
      }

   }

   private void ensureExpandedTexture() {
      if(this.mExpandedTitleTexture == null && !this.mExpandedBounds.isEmpty() && !TextUtils.isEmpty(this.mTextToDraw)) {
         this.calculateOffsets(0.0F);
         this.mTextureAscent = this.mTextPaint.ascent();
         this.mTextureDescent = this.mTextPaint.descent();
         int var1 = Math.round(this.mTextPaint.measureText(this.mTextToDraw, 0, this.mTextToDraw.length()));
         int var2 = Math.round(this.mTextureDescent - this.mTextureAscent);
         if(var1 > 0 && var2 > 0) {
            this.mExpandedTitleTexture = Bitmap.createBitmap(var1, var2, Config.ARGB_8888);
            (new Canvas(this.mExpandedTitleTexture)).drawText(this.mTextToDraw, 0, this.mTextToDraw.length(), 0.0F, (float)var2 - this.mTextPaint.descent(), this.mTextPaint);
            if(this.mTexturePaint == null) {
               this.mTexturePaint = new Paint(3);
               return;
            }
         }
      }

   }

   private void interpolateBounds(float var1) {
      this.mCurrentBounds.left = lerp((float)this.mExpandedBounds.left, (float)this.mCollapsedBounds.left, var1, this.mPositionInterpolator);
      this.mCurrentBounds.top = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, var1, this.mPositionInterpolator);
      this.mCurrentBounds.right = lerp((float)this.mExpandedBounds.right, (float)this.mCollapsedBounds.right, var1, this.mPositionInterpolator);
      this.mCurrentBounds.bottom = lerp((float)this.mExpandedBounds.bottom, (float)this.mCollapsedBounds.bottom, var1, this.mPositionInterpolator);
   }

   private static boolean isClose(float var0, float var1) {
      return Math.abs(var0 - var1) < 0.001F;
   }

   private static float lerp(float var0, float var1, float var2, Interpolator var3) {
      float var4 = var2;
      if(var3 != null) {
         var4 = var3.getInterpolation(var2);
      }

      return AnimationUtils.lerp(var0, var1, var4);
   }

   private Typeface readFontFamilyTypeface(int param1) {
      // $FF: Couldn't be decompiled
   }

   private static boolean rectEquals(Rect var0, int var1, int var2, int var3, int var4) {
      return var0.left == var1 && var0.top == var2 && var0.right == var3 && var0.bottom == var4;
   }

   private void setInterpolatedTextSize(float var1) {
      this.calculateUsingTextSize(var1);
      boolean var2;
      if(USE_SCALING_TEXTURE && this.mScale != 1.0F) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mUseTexture = var2;
      if(this.mUseTexture) {
         this.ensureExpandedTexture();
      }

      ViewCompat.postInvalidateOnAnimation(this.mView);
   }

   public void draw(Canvas var1) {
      int var7 = var1.save();
      if(this.mTextToDraw != null && this.mDrawTitle) {
         float var5 = this.mCurrentDrawX;
         float var4 = this.mCurrentDrawY;
         boolean var6;
         if(this.mUseTexture && this.mExpandedTitleTexture != null) {
            var6 = true;
         } else {
            var6 = false;
         }

         float var2;
         float var3;
         if(var6) {
            var2 = this.mTextureAscent * this.mScale;
            var3 = this.mTextureDescent;
            var3 = this.mScale;
         } else {
            var2 = this.mTextPaint.ascent() * this.mScale;
            this.mTextPaint.descent();
            var3 = this.mScale;
         }

         var3 = var4;
         if(var6) {
            var3 = var4 + var2;
         }

         if(this.mScale != 1.0F) {
            var1.scale(this.mScale, this.mScale, var5, var3);
         }

         if(var6) {
            var1.drawBitmap(this.mExpandedTitleTexture, var5, var3, this.mTexturePaint);
         } else {
            var1.drawText(this.mTextToDraw, 0, this.mTextToDraw.length(), var5, var3, this.mTextPaint);
         }
      }

      var1.restoreToCount(var7);
   }

   int getCollapsedTextColor() {
      return this.mCollapsedTextColor;
   }

   int getCollapsedTextGravity() {
      return this.mCollapsedTextGravity;
   }

   float getCollapsedTextSize() {
      return this.mCollapsedTextSize;
   }

   Typeface getCollapsedTypeface() {
      return this.mCollapsedTypeface != null?this.mCollapsedTypeface:Typeface.DEFAULT;
   }

   int getExpandedTextColor() {
      return this.mExpandedTextColor;
   }

   int getExpandedTextGravity() {
      return this.mExpandedTextGravity;
   }

   float getExpandedTextSize() {
      return this.mExpandedTextSize;
   }

   Typeface getExpandedTypeface() {
      return this.mExpandedTypeface != null?this.mExpandedTypeface:Typeface.DEFAULT;
   }

   float getExpansionFraction() {
      return this.mExpandedFraction;
   }

   CharSequence getText() {
      return this.mText;
   }

   void onBoundsChanged() {
      boolean var1;
      if(this.mCollapsedBounds.width() > 0 && this.mCollapsedBounds.height() > 0 && this.mExpandedBounds.width() > 0 && this.mExpandedBounds.height() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.mDrawTitle = var1;
   }

   public void recalculate() {
      if(this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
         this.calculateBaseOffsets();
         this.calculateCurrentOffsets();
      }

   }

   void setCollapsedBounds(int var1, int var2, int var3, int var4) {
      if(!rectEquals(this.mCollapsedBounds, var1, var2, var3, var4)) {
         this.mCollapsedBounds.set(var1, var2, var3, var4);
         this.mBoundsChanged = true;
         this.onBoundsChanged();
      }

   }

   void setCollapsedTextAppearance(int var1) {
      TypedArray var2 = this.mView.getContext().obtainStyledAttributes(var1, R$styleable.TextAppearance);
      if(var2.hasValue(R$styleable.TextAppearance_android_textColor)) {
         this.mCollapsedTextColor = var2.getColor(R$styleable.TextAppearance_android_textColor, this.mCollapsedTextColor);
      }

      if(var2.hasValue(R$styleable.TextAppearance_android_textSize)) {
         this.mCollapsedTextSize = (float)var2.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, (int)this.mCollapsedTextSize);
      }

      this.mCollapsedShadowColor = var2.getInt(R$styleable.TextAppearance_android_shadowColor, 0);
      this.mCollapsedShadowDx = var2.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0F);
      this.mCollapsedShadowDy = var2.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0F);
      this.mCollapsedShadowRadius = var2.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0F);
      var2.recycle();
      if(VERSION.SDK_INT >= 16) {
         this.mCollapsedTypeface = this.readFontFamilyTypeface(var1);
      }

      this.recalculate();
   }

   void setCollapsedTextColor(int var1) {
      if(this.mCollapsedTextColor != var1) {
         this.mCollapsedTextColor = var1;
         this.recalculate();
      }

   }

   void setCollapsedTextGravity(int var1) {
      if(this.mCollapsedTextGravity != var1) {
         this.mCollapsedTextGravity = var1;
         this.recalculate();
      }

   }

   void setCollapsedTextSize(float var1) {
      if(this.mCollapsedTextSize != var1) {
         this.mCollapsedTextSize = var1;
         this.recalculate();
      }

   }

   void setCollapsedTypeface(Typeface var1) {
      if(this.mCollapsedTypeface != var1) {
         this.mCollapsedTypeface = var1;
         this.recalculate();
      }

   }

   void setExpandedBounds(int var1, int var2, int var3, int var4) {
      if(!rectEquals(this.mExpandedBounds, var1, var2, var3, var4)) {
         this.mExpandedBounds.set(var1, var2, var3, var4);
         this.mBoundsChanged = true;
         this.onBoundsChanged();
      }

   }

   void setExpandedTextAppearance(int var1) {
      TypedArray var2 = this.mView.getContext().obtainStyledAttributes(var1, R$styleable.TextAppearance);
      if(var2.hasValue(R$styleable.TextAppearance_android_textColor)) {
         this.mExpandedTextColor = var2.getColor(R$styleable.TextAppearance_android_textColor, this.mExpandedTextColor);
      }

      if(var2.hasValue(R$styleable.TextAppearance_android_textSize)) {
         this.mExpandedTextSize = (float)var2.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, (int)this.mExpandedTextSize);
      }

      this.mExpandedShadowColor = var2.getInt(R$styleable.TextAppearance_android_shadowColor, 0);
      this.mExpandedShadowDx = var2.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0F);
      this.mExpandedShadowDy = var2.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0F);
      this.mExpandedShadowRadius = var2.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0F);
      var2.recycle();
      if(VERSION.SDK_INT >= 16) {
         this.mExpandedTypeface = this.readFontFamilyTypeface(var1);
      }

      this.recalculate();
   }

   void setExpandedTextColor(int var1) {
      if(this.mExpandedTextColor != var1) {
         this.mExpandedTextColor = var1;
         this.recalculate();
      }

   }

   void setExpandedTextGravity(int var1) {
      if(this.mExpandedTextGravity != var1) {
         this.mExpandedTextGravity = var1;
         this.recalculate();
      }

   }

   void setExpandedTextSize(float var1) {
      if(this.mExpandedTextSize != var1) {
         this.mExpandedTextSize = var1;
         this.recalculate();
      }

   }

   void setExpandedTypeface(Typeface var1) {
      if(this.mExpandedTypeface != var1) {
         this.mExpandedTypeface = var1;
         this.recalculate();
      }

   }

   void setExpansionFraction(float var1) {
      var1 = MathUtils.constrain(var1, 0.0F, 1.0F);
      if(var1 != this.mExpandedFraction) {
         this.mExpandedFraction = var1;
         this.calculateCurrentOffsets();
      }

   }

   void setPositionInterpolator(Interpolator var1) {
      this.mPositionInterpolator = var1;
      this.recalculate();
   }

   void setText(CharSequence var1) {
      if(var1 == null || !var1.equals(this.mText)) {
         this.mText = var1;
         this.mTextToDraw = null;
         this.clearTexture();
         this.recalculate();
      }

   }

   void setTextSizeInterpolator(Interpolator var1) {
      this.mTextSizeInterpolator = var1;
      this.recalculate();
   }

   void setTypefaces(Typeface var1) {
      this.mExpandedTypeface = var1;
      this.mCollapsedTypeface = var1;
      this.recalculate();
   }
}
