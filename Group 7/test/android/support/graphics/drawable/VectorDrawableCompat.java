package android.support.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AndroidResources;
import android.support.graphics.drawable.TypedArrayUtils;
import android.support.graphics.drawable.VectorDrawableCommon;
import android.support.graphics.drawable.VectorDrawableCompat$VClipPath;
import android.support.graphics.drawable.VectorDrawableCompat$VFullPath;
import android.support.graphics.drawable.VectorDrawableCompat$VGroup;
import android.support.graphics.drawable.VectorDrawableCompat$VPath;
import android.support.graphics.drawable.VectorDrawableCompat$VPathRenderer;
import android.support.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState;
import android.support.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class VectorDrawableCompat extends VectorDrawableCommon {
   private static final boolean DBG_VECTOR_DRAWABLE = false;
   static final Mode DEFAULT_TINT_MODE;
   private static final int LINECAP_BUTT = 0;
   private static final int LINECAP_ROUND = 1;
   private static final int LINECAP_SQUARE = 2;
   private static final int LINEJOIN_BEVEL = 2;
   private static final int LINEJOIN_MITER = 0;
   private static final int LINEJOIN_ROUND = 1;
   static final String LOGTAG = "VectorDrawableCompat";
   private static final int MAX_CACHED_BITMAP_SIZE = 2048;
   private static final String SHAPE_CLIP_PATH = "clip-path";
   private static final String SHAPE_GROUP = "group";
   private static final String SHAPE_PATH = "path";
   private static final String SHAPE_VECTOR = "vector";
   private boolean mAllowCaching;
   private ConstantState mCachedConstantStateDelegate;
   private ColorFilter mColorFilter;
   private boolean mMutated;
   private PorterDuffColorFilter mTintFilter;
   private final Rect mTmpBounds;
   private final float[] mTmpFloats;
   private final Matrix mTmpMatrix;
   private VectorDrawableCompat$VectorDrawableCompatState mVectorState;

   static {
      DEFAULT_TINT_MODE = Mode.SRC_IN;
   }

   private VectorDrawableCompat() {
      this.mAllowCaching = true;
      this.mTmpFloats = new float[9];
      this.mTmpMatrix = new Matrix();
      this.mTmpBounds = new Rect();
      this.mVectorState = new VectorDrawableCompat$VectorDrawableCompatState();
   }

   private VectorDrawableCompat(@NonNull VectorDrawableCompat$VectorDrawableCompatState var1) {
      this.mAllowCaching = true;
      this.mTmpFloats = new float[9];
      this.mTmpMatrix = new Matrix();
      this.mTmpBounds = new Rect();
      this.mVectorState = var1;
      this.mTintFilter = this.updateTintFilter(this.mTintFilter, var1.mTint, var1.mTintMode);
   }

   private static int applyAlpha(int var0, float var1) {
      return var0 & 16777215 | (int)((float)Color.alpha(var0) * var1) << 24;
   }

   @Nullable
   public static VectorDrawableCompat create(@NonNull Resources param0, @DrawableRes int param1, @Nullable Theme param2) {
      // $FF: Couldn't be decompiled
   }

   public static VectorDrawableCompat createFromXmlInner(Resources var0, XmlPullParser var1, AttributeSet var2, Theme var3) throws XmlPullParserException, IOException {
      VectorDrawableCompat var4 = new VectorDrawableCompat();
      var4.inflate(var0, var1, var2, var3);
      return var4;
   }

   private void inflateInternal(Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      VectorDrawableCompat$VectorDrawableCompatState var8 = this.mVectorState;
      VectorDrawableCompat$VPathRenderer var9 = var8.mVPathRenderer;
      boolean var5 = true;
      Stack var10 = new Stack();
      var10.push(VectorDrawableCompat$VPathRenderer.access$000(var9));

      boolean var6;
      for(int var7 = var2.getEventType(); var7 != 1; var5 = var6) {
         if(var7 == 2) {
            String var12 = var2.getName();
            VectorDrawableCompat$VGroup var11 = (VectorDrawableCompat$VGroup)var10.peek();
            if("path".equals(var12)) {
               VectorDrawableCompat$VFullPath var14 = new VectorDrawableCompat$VFullPath();
               var14.inflate(var1, var3, var4, var2);
               var11.mChildren.add(var14);
               if(var14.getPathName() != null) {
                  var9.mVGTargetsMap.put(var14.getPathName(), var14);
               }

               var6 = false;
               var8.mChangingConfigurations |= var14.mChangingConfigurations;
            } else if("clip-path".equals(var12)) {
               VectorDrawableCompat$VClipPath var15 = new VectorDrawableCompat$VClipPath();
               var15.inflate(var1, var3, var4, var2);
               var11.mChildren.add(var15);
               if(var15.getPathName() != null) {
                  var9.mVGTargetsMap.put(var15.getPathName(), var15);
               }

               var8.mChangingConfigurations |= var15.mChangingConfigurations;
               var6 = var5;
            } else {
               var6 = var5;
               if("group".equals(var12)) {
                  VectorDrawableCompat$VGroup var16 = new VectorDrawableCompat$VGroup();
                  var16.inflate(var1, var3, var4, var2);
                  var11.mChildren.add(var16);
                  var10.push(var16);
                  if(var16.getGroupName() != null) {
                     var9.mVGTargetsMap.put(var16.getGroupName(), var16);
                  }

                  var8.mChangingConfigurations |= VectorDrawableCompat$VGroup.access$100(var16);
                  var6 = var5;
               }
            }
         } else {
            var6 = var5;
            if(var7 == 3) {
               var6 = var5;
               if("group".equals(var2.getName())) {
                  var10.pop();
                  var6 = var5;
               }
            }
         }

         var7 = var2.next();
      }

      if(var5) {
         StringBuffer var13 = new StringBuffer();
         if(var13.length() > 0) {
            var13.append(" or ");
         }

         var13.append("path");
         throw new XmlPullParserException("no " + var13 + " defined");
      }
   }

   private boolean needMirroring() {
      return false;
   }

   private static Mode parseTintModeCompat(int var0, Mode var1) {
      switch(var0) {
      case 3:
         return Mode.SRC_OVER;
      case 4:
      case 6:
      case 7:
      case 8:
      case 10:
      case 11:
      case 12:
      case 13:
      default:
         return var1;
      case 5:
         return Mode.SRC_IN;
      case 9:
         return Mode.SRC_ATOP;
      case 14:
         return Mode.MULTIPLY;
      case 15:
         return Mode.SCREEN;
      case 16:
         return Mode.ADD;
      }
   }

   private void printGroupTree(VectorDrawableCompat$VGroup var1, int var2) {
      String var4 = "";

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var4 = var4 + "    ";
      }

      Log.v("VectorDrawableCompat", var4 + "current group is :" + var1.getGroupName() + " rotation is " + VectorDrawableCompat$VGroup.access$200(var1));
      Log.v("VectorDrawableCompat", var4 + "matrix is :" + var1.getLocalMatrix().toString());

      for(var3 = 0; var3 < var1.mChildren.size(); ++var3) {
         Object var5 = var1.mChildren.get(var3);
         if(var5 instanceof VectorDrawableCompat$VGroup) {
            this.printGroupTree((VectorDrawableCompat$VGroup)var5, var2 + 1);
         } else {
            ((VectorDrawableCompat$VPath)var5).printVPath(var2 + 1);
         }
      }

   }

   private void updateStateFromTypedArray(TypedArray var1, XmlPullParser var2) throws XmlPullParserException {
      VectorDrawableCompat$VectorDrawableCompatState var4 = this.mVectorState;
      VectorDrawableCompat$VPathRenderer var3 = var4.mVPathRenderer;
      var4.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(var1, var2, "tintMode", 6, -1), Mode.SRC_IN);
      ColorStateList var5 = var1.getColorStateList(1);
      if(var5 != null) {
         var4.mTint = var5;
      }

      var4.mAutoMirrored = TypedArrayUtils.getNamedBoolean(var1, var2, "autoMirrored", 5, var4.mAutoMirrored);
      var3.mViewportWidth = TypedArrayUtils.getNamedFloat(var1, var2, "viewportWidth", 7, var3.mViewportWidth);
      var3.mViewportHeight = TypedArrayUtils.getNamedFloat(var1, var2, "viewportHeight", 8, var3.mViewportHeight);
      if(var3.mViewportWidth <= 0.0F) {
         throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      } else if(var3.mViewportHeight <= 0.0F) {
         throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
      } else {
         var3.mBaseWidth = var1.getDimension(3, var3.mBaseWidth);
         var3.mBaseHeight = var1.getDimension(2, var3.mBaseHeight);
         if(var3.mBaseWidth <= 0.0F) {
            throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires width > 0");
         } else if(var3.mBaseHeight <= 0.0F) {
            throw new XmlPullParserException(var1.getPositionDescription() + "<vector> tag requires height > 0");
         } else {
            var3.setAlpha(TypedArrayUtils.getNamedFloat(var1, var2, "alpha", 4, var3.getAlpha()));
            String var6 = var1.getString(0);
            if(var6 != null) {
               var3.mRootName = var6;
               var3.mVGTargetsMap.put(var6, var3);
            }

         }
      }
   }

   public boolean canApplyTheme() {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.canApplyTheme(this.mDelegateDrawable);
      }

      return false;
   }

   public void draw(Canvas var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.draw(var1);
      } else {
         this.copyBounds(this.mTmpBounds);
         if(this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
            Object var9;
            if(this.mColorFilter == null) {
               var9 = this.mTintFilter;
            } else {
               var9 = this.mColorFilter;
            }

            var1.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float var2 = Math.abs(this.mTmpFloats[0]);
            float var3 = Math.abs(this.mTmpFloats[4]);
            float var5 = Math.abs(this.mTmpFloats[1]);
            float var4 = Math.abs(this.mTmpFloats[3]);
            if(var5 != 0.0F || var4 != 0.0F) {
               var2 = 1.0F;
               var3 = 1.0F;
            }

            int var6 = (int)((float)this.mTmpBounds.width() * var2);
            int var7 = (int)((float)this.mTmpBounds.height() * var3);
            var6 = Math.min(2048, var6);
            var7 = Math.min(2048, var7);
            if(var6 > 0 && var7 > 0) {
               int var8 = var1.save();
               var1.translate((float)this.mTmpBounds.left, (float)this.mTmpBounds.top);
               if(this.needMirroring()) {
                  var1.translate((float)this.mTmpBounds.width(), 0.0F);
                  var1.scale(-1.0F, 1.0F);
               }

               this.mTmpBounds.offsetTo(0, 0);
               this.mVectorState.createCachedBitmapIfNeeded(var6, var7);
               if(!this.mAllowCaching) {
                  this.mVectorState.updateCachedBitmap(var6, var7);
               } else if(!this.mVectorState.canReuseCache()) {
                  this.mVectorState.updateCachedBitmap(var6, var7);
                  this.mVectorState.updateCacheStates();
               }

               this.mVectorState.drawCachedBitmapWithRootAlpha(var1, (ColorFilter)var9, this.mTmpBounds);
               var1.restoreToCount(var8);
               return;
            }
         }
      }

   }

   public int getAlpha() {
      return this.mDelegateDrawable != null?DrawableCompat.getAlpha(this.mDelegateDrawable):this.mVectorState.mVPathRenderer.getRootAlpha();
   }

   public int getChangingConfigurations() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getChangingConfigurations():super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
   }

   public ConstantState getConstantState() {
      if(this.mDelegateDrawable != null) {
         return new VectorDrawableCompat$VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
      } else {
         this.mVectorState.mChangingConfigurations = this.getChangingConfigurations();
         return this.mVectorState;
      }
   }

   public int getIntrinsicHeight() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getIntrinsicHeight():(int)this.mVectorState.mVPathRenderer.mBaseHeight;
   }

   public int getIntrinsicWidth() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getIntrinsicWidth():(int)this.mVectorState.mVPathRenderer.mBaseWidth;
   }

   public int getOpacity() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getOpacity():-3;
   }

   public float getPixelSize() {
      if((this.mVectorState != null || this.mVectorState.mVPathRenderer != null) && this.mVectorState.mVPathRenderer.mBaseWidth != 0.0F && this.mVectorState.mVPathRenderer.mBaseHeight != 0.0F && this.mVectorState.mVPathRenderer.mViewportHeight != 0.0F && this.mVectorState.mVPathRenderer.mViewportWidth != 0.0F) {
         float var1 = this.mVectorState.mVPathRenderer.mBaseWidth;
         float var2 = this.mVectorState.mVPathRenderer.mBaseHeight;
         float var3 = this.mVectorState.mVPathRenderer.mViewportWidth;
         float var4 = this.mVectorState.mVPathRenderer.mViewportHeight;
         return Math.min(var3 / var1, var4 / var2);
      } else {
         return 1.0F;
      }
   }

   Object getTargetByName(String var1) {
      return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(var1);
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3) throws XmlPullParserException, IOException {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.inflate(var1, var2, var3);
      } else {
         this.inflate(var1, var2, var3, (Theme)null);
      }
   }

   public void inflate(Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.inflate(this.mDelegateDrawable, var1, var2, var3, var4);
      } else {
         VectorDrawableCompat$VectorDrawableCompatState var5 = this.mVectorState;
         var5.mVPathRenderer = new VectorDrawableCompat$VPathRenderer();
         TypedArray var6 = obtainAttributes(var1, var4, var3, AndroidResources.styleable_VectorDrawableTypeArray);
         this.updateStateFromTypedArray(var6, var2);
         var6.recycle();
         var5.mChangingConfigurations = this.getChangingConfigurations();
         var5.mCacheDirty = true;
         this.inflateInternal(var1, var2, var3, var4);
         this.mTintFilter = this.updateTintFilter(this.mTintFilter, var5.mTint, var5.mTintMode);
      }
   }

   public void invalidateSelf() {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.invalidateSelf();
      } else {
         super.invalidateSelf();
      }
   }

   public boolean isStateful() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.isStateful():super.isStateful() || this.mVectorState != null && this.mVectorState.mTint != null && this.mVectorState.mTint.isStateful();
   }

   public Drawable mutate() {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.mutate();
      } else if(!this.mMutated && super.mutate() == this) {
         this.mVectorState = new VectorDrawableCompat$VectorDrawableCompatState(this.mVectorState);
         this.mMutated = true;
         return this;
      }

      return this;
   }

   protected boolean onStateChange(int[] var1) {
      if(this.mDelegateDrawable != null) {
         return this.mDelegateDrawable.setState(var1);
      } else {
         VectorDrawableCompat$VectorDrawableCompatState var2 = this.mVectorState;
         if(var2.mTint != null && var2.mTintMode != null) {
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, var2.mTint, var2.mTintMode);
            this.invalidateSelf();
            return true;
         } else {
            return false;
         }
      }
   }

   public void scheduleSelf(Runnable var1, long var2) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.scheduleSelf(var1, var2);
      } else {
         super.scheduleSelf(var1, var2);
      }
   }

   void setAllowCaching(boolean var1) {
      this.mAllowCaching = var1;
   }

   public void setAlpha(int var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setAlpha(var1);
      } else if(this.mVectorState.mVPathRenderer.getRootAlpha() != var1) {
         this.mVectorState.mVPathRenderer.setRootAlpha(var1);
         this.invalidateSelf();
         return;
      }

   }

   public void setBounds(int var1, int var2, int var3, int var4) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setBounds(var1, var2, var3, var4);
      } else {
         super.setBounds(var1, var2, var3, var4);
      }
   }

   public void setBounds(Rect var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setBounds(var1);
      } else {
         super.setBounds(var1);
      }
   }

   public void setColorFilter(ColorFilter var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setColorFilter(var1);
      } else {
         this.mColorFilter = var1;
         this.invalidateSelf();
      }
   }

   public void setTint(int var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTint(this.mDelegateDrawable, var1);
      } else {
         this.setTintList(ColorStateList.valueOf(var1));
      }
   }

   public void setTintList(ColorStateList var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTintList(this.mDelegateDrawable, var1);
      } else {
         VectorDrawableCompat$VectorDrawableCompatState var2 = this.mVectorState;
         if(var2.mTint != var1) {
            var2.mTint = var1;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, var1, var2.mTintMode);
            this.invalidateSelf();
            return;
         }
      }

   }

   public void setTintMode(Mode var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setTintMode(this.mDelegateDrawable, var1);
      } else {
         VectorDrawableCompat$VectorDrawableCompatState var2 = this.mVectorState;
         if(var2.mTintMode != var1) {
            var2.mTintMode = var1;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, var2.mTint, var1);
            this.invalidateSelf();
            return;
         }
      }

   }

   public boolean setVisible(boolean var1, boolean var2) {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.setVisible(var1, var2):super.setVisible(var1, var2);
   }

   public void unscheduleSelf(Runnable var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.unscheduleSelf(var1);
      } else {
         super.unscheduleSelf(var1);
      }
   }

   PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter var1, ColorStateList var2, Mode var3) {
      return var2 != null && var3 != null?new PorterDuffColorFilter(var2.getColorForState(this.getState(), 0), var3):null;
   }
}
