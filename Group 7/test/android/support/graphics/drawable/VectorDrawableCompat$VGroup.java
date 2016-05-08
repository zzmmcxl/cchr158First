package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Matrix;
import android.support.graphics.drawable.AndroidResources;
import android.support.graphics.drawable.TypedArrayUtils;
import android.support.graphics.drawable.VectorDrawableCommon;
import android.support.graphics.drawable.VectorDrawableCompat$VClipPath;
import android.support.graphics.drawable.VectorDrawableCompat$VFullPath;
import android.support.graphics.drawable.VectorDrawableCompat$VPath;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class VectorDrawableCompat$VGroup {
   private int mChangingConfigurations;
   final ArrayList<Object> mChildren = new ArrayList();
   private String mGroupName = null;
   private final Matrix mLocalMatrix = new Matrix();
   private float mPivotX = 0.0F;
   private float mPivotY = 0.0F;
   private float mRotate = 0.0F;
   private float mScaleX = 1.0F;
   private float mScaleY = 1.0F;
   private final Matrix mStackedMatrix = new Matrix();
   private int[] mThemeAttrs;
   private float mTranslateX = 0.0F;
   private float mTranslateY = 0.0F;

   public VectorDrawableCompat$VGroup() {
   }

   public VectorDrawableCompat$VGroup(VectorDrawableCompat$VGroup var1, ArrayMap<String, Object> var2) {
      this.mRotate = var1.mRotate;
      this.mPivotX = var1.mPivotX;
      this.mPivotY = var1.mPivotY;
      this.mScaleX = var1.mScaleX;
      this.mScaleY = var1.mScaleY;
      this.mTranslateX = var1.mTranslateX;
      this.mTranslateY = var1.mTranslateY;
      this.mThemeAttrs = var1.mThemeAttrs;
      this.mGroupName = var1.mGroupName;
      this.mChangingConfigurations = var1.mChangingConfigurations;
      if(this.mGroupName != null) {
         var2.put(this.mGroupName, this);
      }

      this.mLocalMatrix.set(var1.mLocalMatrix);
      ArrayList var4 = var1.mChildren;

      for(int var3 = 0; var3 < var4.size(); ++var3) {
         Object var5 = var4.get(var3);
         if(var5 instanceof VectorDrawableCompat$VGroup) {
            var1 = (VectorDrawableCompat$VGroup)var5;
            this.mChildren.add(new VectorDrawableCompat$VGroup(var1, var2));
         } else {
            if(var5 instanceof VectorDrawableCompat$VFullPath) {
               var5 = new VectorDrawableCompat$VFullPath((VectorDrawableCompat$VFullPath)var5);
            } else {
               if(!(var5 instanceof VectorDrawableCompat$VClipPath)) {
                  throw new IllegalStateException("Unknown object in the tree!");
               }

               var5 = new VectorDrawableCompat$VClipPath((VectorDrawableCompat$VClipPath)var5);
            }

            this.mChildren.add(var5);
            if(((VectorDrawableCompat$VPath)var5).mPathName != null) {
               var2.put(((VectorDrawableCompat$VPath)var5).mPathName, var5);
            }
         }
      }

   }

   private void updateLocalMatrix() {
      this.mLocalMatrix.reset();
      this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
      this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
      this.mLocalMatrix.postRotate(this.mRotate, 0.0F, 0.0F);
      this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
   }

   private void updateStateFromTypedArray(TypedArray var1, XmlPullParser var2) {
      this.mThemeAttrs = null;
      this.mRotate = TypedArrayUtils.getNamedFloat(var1, var2, "rotation", 5, this.mRotate);
      this.mPivotX = var1.getFloat(1, this.mPivotX);
      this.mPivotY = var1.getFloat(2, this.mPivotY);
      this.mScaleX = TypedArrayUtils.getNamedFloat(var1, var2, "scaleX", 3, this.mScaleX);
      this.mScaleY = TypedArrayUtils.getNamedFloat(var1, var2, "scaleY", 4, this.mScaleY);
      this.mTranslateX = TypedArrayUtils.getNamedFloat(var1, var2, "translateX", 6, this.mTranslateX);
      this.mTranslateY = TypedArrayUtils.getNamedFloat(var1, var2, "translateY", 7, this.mTranslateY);
      String var3 = var1.getString(0);
      if(var3 != null) {
         this.mGroupName = var3;
      }

      this.updateLocalMatrix();
   }

   public String getGroupName() {
      return this.mGroupName;
   }

   public Matrix getLocalMatrix() {
      return this.mLocalMatrix;
   }

   public float getPivotX() {
      return this.mPivotX;
   }

   public float getPivotY() {
      return this.mPivotY;
   }

   public float getRotation() {
      return this.mRotate;
   }

   public float getScaleX() {
      return this.mScaleX;
   }

   public float getScaleY() {
      return this.mScaleY;
   }

   public float getTranslateX() {
      return this.mTranslateX;
   }

   public float getTranslateY() {
      return this.mTranslateY;
   }

   public void inflate(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
      TypedArray var5 = VectorDrawableCommon.obtainAttributes(var1, var3, var2, AndroidResources.styleable_VectorDrawableGroup);
      this.updateStateFromTypedArray(var5, var4);
      var5.recycle();
   }

   public void setPivotX(float var1) {
      if(var1 != this.mPivotX) {
         this.mPivotX = var1;
         this.updateLocalMatrix();
      }

   }

   public void setPivotY(float var1) {
      if(var1 != this.mPivotY) {
         this.mPivotY = var1;
         this.updateLocalMatrix();
      }

   }

   public void setRotation(float var1) {
      if(var1 != this.mRotate) {
         this.mRotate = var1;
         this.updateLocalMatrix();
      }

   }

   public void setScaleX(float var1) {
      if(var1 != this.mScaleX) {
         this.mScaleX = var1;
         this.updateLocalMatrix();
      }

   }

   public void setScaleY(float var1) {
      if(var1 != this.mScaleY) {
         this.mScaleY = var1;
         this.updateLocalMatrix();
      }

   }

   public void setTranslateX(float var1) {
      if(var1 != this.mTranslateX) {
         this.mTranslateX = var1;
         this.updateLocalMatrix();
      }

   }

   public void setTranslateY(float var1) {
      if(var1 != this.mTranslateY) {
         this.mTranslateY = var1;
         this.updateLocalMatrix();
      }

   }
}
