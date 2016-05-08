package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.support.graphics.drawable.AndroidResources;
import android.support.graphics.drawable.PathParser;
import android.support.graphics.drawable.TypedArrayUtils;
import android.support.graphics.drawable.VectorDrawableCommon;
import android.support.graphics.drawable.VectorDrawableCompat$VPath;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class VectorDrawableCompat$VFullPath extends VectorDrawableCompat$VPath {
   float mFillAlpha = 1.0F;
   int mFillColor = 0;
   int mFillRule;
   float mStrokeAlpha = 1.0F;
   int mStrokeColor = 0;
   Cap mStrokeLineCap;
   Join mStrokeLineJoin;
   float mStrokeMiterlimit;
   float mStrokeWidth = 0.0F;
   private int[] mThemeAttrs;
   float mTrimPathEnd = 1.0F;
   float mTrimPathOffset = 0.0F;
   float mTrimPathStart = 0.0F;

   public VectorDrawableCompat$VFullPath() {
      this.mStrokeLineCap = Cap.BUTT;
      this.mStrokeLineJoin = Join.MITER;
      this.mStrokeMiterlimit = 4.0F;
   }

   public VectorDrawableCompat$VFullPath(VectorDrawableCompat$VFullPath var1) {
      super(var1);
      this.mStrokeLineCap = Cap.BUTT;
      this.mStrokeLineJoin = Join.MITER;
      this.mStrokeMiterlimit = 4.0F;
      this.mThemeAttrs = var1.mThemeAttrs;
      this.mStrokeColor = var1.mStrokeColor;
      this.mStrokeWidth = var1.mStrokeWidth;
      this.mStrokeAlpha = var1.mStrokeAlpha;
      this.mFillColor = var1.mFillColor;
      this.mFillRule = var1.mFillRule;
      this.mFillAlpha = var1.mFillAlpha;
      this.mTrimPathStart = var1.mTrimPathStart;
      this.mTrimPathEnd = var1.mTrimPathEnd;
      this.mTrimPathOffset = var1.mTrimPathOffset;
      this.mStrokeLineCap = var1.mStrokeLineCap;
      this.mStrokeLineJoin = var1.mStrokeLineJoin;
      this.mStrokeMiterlimit = var1.mStrokeMiterlimit;
   }

   private Cap getStrokeLineCap(int var1, Cap var2) {
      switch(var1) {
      case 0:
         return Cap.BUTT;
      case 1:
         return Cap.ROUND;
      case 2:
         return Cap.SQUARE;
      default:
         return var2;
      }
   }

   private Join getStrokeLineJoin(int var1, Join var2) {
      switch(var1) {
      case 0:
         return Join.MITER;
      case 1:
         return Join.ROUND;
      case 2:
         return Join.BEVEL;
      default:
         return var2;
      }
   }

   private void updateStateFromTypedArray(TypedArray var1, XmlPullParser var2) {
      this.mThemeAttrs = null;
      if(TypedArrayUtils.hasAttribute(var2, "pathData")) {
         String var3 = var1.getString(0);
         if(var3 != null) {
            this.mPathName = var3;
         }

         var3 = var1.getString(2);
         if(var3 != null) {
            this.mNodes = PathParser.createNodesFromPathData(var3);
         }

         this.mFillColor = TypedArrayUtils.getNamedColor(var1, var2, "fillColor", 1, this.mFillColor);
         this.mFillAlpha = TypedArrayUtils.getNamedFloat(var1, var2, "fillAlpha", 12, this.mFillAlpha);
         this.mStrokeLineCap = this.getStrokeLineCap(TypedArrayUtils.getNamedInt(var1, var2, "strokeLineCap", 8, -1), this.mStrokeLineCap);
         this.mStrokeLineJoin = this.getStrokeLineJoin(TypedArrayUtils.getNamedInt(var1, var2, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
         this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(var1, var2, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
         this.mStrokeColor = TypedArrayUtils.getNamedColor(var1, var2, "strokeColor", 3, this.mStrokeColor);
         this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(var1, var2, "strokeAlpha", 11, this.mStrokeAlpha);
         this.mStrokeWidth = TypedArrayUtils.getNamedFloat(var1, var2, "strokeWidth", 4, this.mStrokeWidth);
         this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(var1, var2, "trimPathEnd", 6, this.mTrimPathEnd);
         this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(var1, var2, "trimPathOffset", 7, this.mTrimPathOffset);
         this.mTrimPathStart = TypedArrayUtils.getNamedFloat(var1, var2, "trimPathStart", 5, this.mTrimPathStart);
      }
   }

   public void applyTheme(Theme var1) {
      if(this.mThemeAttrs == null) {
         ;
      }

   }

   public boolean canApplyTheme() {
      return this.mThemeAttrs != null;
   }

   float getFillAlpha() {
      return this.mFillAlpha;
   }

   int getFillColor() {
      return this.mFillColor;
   }

   float getStrokeAlpha() {
      return this.mStrokeAlpha;
   }

   int getStrokeColor() {
      return this.mStrokeColor;
   }

   float getStrokeWidth() {
      return this.mStrokeWidth;
   }

   float getTrimPathEnd() {
      return this.mTrimPathEnd;
   }

   float getTrimPathOffset() {
      return this.mTrimPathOffset;
   }

   float getTrimPathStart() {
      return this.mTrimPathStart;
   }

   public void inflate(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
      TypedArray var5 = VectorDrawableCommon.obtainAttributes(var1, var3, var2, AndroidResources.styleable_VectorDrawablePath);
      this.updateStateFromTypedArray(var5, var4);
      var5.recycle();
   }

   void setFillAlpha(float var1) {
      this.mFillAlpha = var1;
   }

   void setFillColor(int var1) {
      this.mFillColor = var1;
   }

   void setStrokeAlpha(float var1) {
      this.mStrokeAlpha = var1;
   }

   void setStrokeColor(int var1) {
      this.mStrokeColor = var1;
   }

   void setStrokeWidth(float var1) {
      this.mStrokeWidth = var1;
   }

   void setTrimPathEnd(float var1) {
      this.mTrimPathEnd = var1;
   }

   void setTrimPathOffset(float var1) {
      this.mTrimPathOffset = var1;
   }

   void setTrimPathStart(float var1) {
      this.mTrimPathStart = var1;
   }
}
