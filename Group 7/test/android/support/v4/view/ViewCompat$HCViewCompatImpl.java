package android.support.v4.view;

import android.graphics.Paint;
import android.support.v4.view.ViewCompat$GBViewCompatImpl;
import android.support.v4.view.ViewCompatHC;
import android.view.View;

class ViewCompat$HCViewCompatImpl extends ViewCompat$GBViewCompatImpl {
   public int combineMeasuredStates(int var1, int var2) {
      return ViewCompatHC.combineMeasuredStates(var1, var2);
   }

   public float getAlpha(View var1) {
      return ViewCompatHC.getAlpha(var1);
   }

   long getFrameTime() {
      return ViewCompatHC.getFrameTime();
   }

   public int getLayerType(View var1) {
      return ViewCompatHC.getLayerType(var1);
   }

   public int getMeasuredHeightAndState(View var1) {
      return ViewCompatHC.getMeasuredHeightAndState(var1);
   }

   public int getMeasuredState(View var1) {
      return ViewCompatHC.getMeasuredState(var1);
   }

   public int getMeasuredWidthAndState(View var1) {
      return ViewCompatHC.getMeasuredWidthAndState(var1);
   }

   public float getPivotX(View var1) {
      return ViewCompatHC.getPivotX(var1);
   }

   public float getPivotY(View var1) {
      return ViewCompatHC.getPivotY(var1);
   }

   public float getRotation(View var1) {
      return ViewCompatHC.getRotation(var1);
   }

   public float getRotationX(View var1) {
      return ViewCompatHC.getRotationX(var1);
   }

   public float getRotationY(View var1) {
      return ViewCompatHC.getRotationY(var1);
   }

   public float getScaleX(View var1) {
      return ViewCompatHC.getScaleX(var1);
   }

   public float getScaleY(View var1) {
      return ViewCompatHC.getScaleY(var1);
   }

   public float getTranslationX(View var1) {
      return ViewCompatHC.getTranslationX(var1);
   }

   public float getTranslationY(View var1) {
      return ViewCompatHC.getTranslationY(var1);
   }

   public float getX(View var1) {
      return ViewCompatHC.getX(var1);
   }

   public float getY(View var1) {
      return ViewCompatHC.getY(var1);
   }

   public void jumpDrawablesToCurrentState(View var1) {
      ViewCompatHC.jumpDrawablesToCurrentState(var1);
   }

   public void offsetLeftAndRight(View var1, int var2) {
      ViewCompatHC.offsetLeftAndRight(var1, var2);
   }

   public void offsetTopAndBottom(View var1, int var2) {
      ViewCompatHC.offsetTopAndBottom(var1, var2);
   }

   public int resolveSizeAndState(int var1, int var2, int var3) {
      return ViewCompatHC.resolveSizeAndState(var1, var2, var3);
   }

   public void setActivated(View var1, boolean var2) {
      ViewCompatHC.setActivated(var1, var2);
   }

   public void setAlpha(View var1, float var2) {
      ViewCompatHC.setAlpha(var1, var2);
   }

   public void setLayerPaint(View var1, Paint var2) {
      this.setLayerType(var1, this.getLayerType(var1), var2);
      var1.invalidate();
   }

   public void setLayerType(View var1, int var2, Paint var3) {
      ViewCompatHC.setLayerType(var1, var2, var3);
   }

   public void setPivotX(View var1, float var2) {
      ViewCompatHC.setPivotX(var1, var2);
   }

   public void setPivotY(View var1, float var2) {
      ViewCompatHC.setPivotY(var1, var2);
   }

   public void setRotation(View var1, float var2) {
      ViewCompatHC.setRotation(var1, var2);
   }

   public void setRotationX(View var1, float var2) {
      ViewCompatHC.setRotationX(var1, var2);
   }

   public void setRotationY(View var1, float var2) {
      ViewCompatHC.setRotationY(var1, var2);
   }

   public void setSaveFromParentEnabled(View var1, boolean var2) {
      ViewCompatHC.setSaveFromParentEnabled(var1, var2);
   }

   public void setScaleX(View var1, float var2) {
      ViewCompatHC.setScaleX(var1, var2);
   }

   public void setScaleY(View var1, float var2) {
      ViewCompatHC.setScaleY(var1, var2);
   }

   public void setTranslationX(View var1, float var2) {
      ViewCompatHC.setTranslationX(var1, var2);
   }

   public void setTranslationY(View var1, float var2) {
      ViewCompatHC.setTranslationY(var1, var2);
   }

   public void setX(View var1, float var2) {
      ViewCompatHC.setX(var1, var2);
   }

   public void setY(View var1, float var2) {
      ViewCompatHC.setY(var1, var2);
   }
}
