package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordIcsImpl;
import android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordIcsMr1Impl;
import android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordImpl;
import android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordJellyBeanImpl;
import android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordStubImpl;
import android.view.View;
import java.util.List;

public class AccessibilityRecordCompat {
   private static final AccessibilityRecordCompat$AccessibilityRecordImpl IMPL;
   private final Object mRecord;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityRecordCompat$AccessibilityRecordJellyBeanImpl();
      } else if(VERSION.SDK_INT >= 15) {
         IMPL = new AccessibilityRecordCompat$AccessibilityRecordIcsMr1Impl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityRecordCompat$AccessibilityRecordIcsImpl();
      } else {
         IMPL = new AccessibilityRecordCompat$AccessibilityRecordStubImpl();
      }
   }

   public AccessibilityRecordCompat(Object var1) {
      this.mRecord = var1;
   }

   public static AccessibilityRecordCompat obtain() {
      return new AccessibilityRecordCompat(IMPL.obtain());
   }

   public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat var0) {
      return new AccessibilityRecordCompat(IMPL.obtain(var0.mRecord));
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         AccessibilityRecordCompat var2 = (AccessibilityRecordCompat)var1;
         if(this.mRecord == null) {
            if(var2.mRecord != null) {
               return false;
            }
         } else if(!this.mRecord.equals(var2.mRecord)) {
            return false;
         }
      }

      return true;
   }

   public int getAddedCount() {
      return IMPL.getAddedCount(this.mRecord);
   }

   public CharSequence getBeforeText() {
      return IMPL.getBeforeText(this.mRecord);
   }

   public CharSequence getClassName() {
      return IMPL.getClassName(this.mRecord);
   }

   public CharSequence getContentDescription() {
      return IMPL.getContentDescription(this.mRecord);
   }

   public int getCurrentItemIndex() {
      return IMPL.getCurrentItemIndex(this.mRecord);
   }

   public int getFromIndex() {
      return IMPL.getFromIndex(this.mRecord);
   }

   public Object getImpl() {
      return this.mRecord;
   }

   public int getItemCount() {
      return IMPL.getItemCount(this.mRecord);
   }

   public int getMaxScrollX() {
      return IMPL.getMaxScrollX(this.mRecord);
   }

   public int getMaxScrollY() {
      return IMPL.getMaxScrollY(this.mRecord);
   }

   public Parcelable getParcelableData() {
      return IMPL.getParcelableData(this.mRecord);
   }

   public int getRemovedCount() {
      return IMPL.getRemovedCount(this.mRecord);
   }

   public int getScrollX() {
      return IMPL.getScrollX(this.mRecord);
   }

   public int getScrollY() {
      return IMPL.getScrollY(this.mRecord);
   }

   public AccessibilityNodeInfoCompat getSource() {
      return IMPL.getSource(this.mRecord);
   }

   public List<CharSequence> getText() {
      return IMPL.getText(this.mRecord);
   }

   public int getToIndex() {
      return IMPL.getToIndex(this.mRecord);
   }

   public int getWindowId() {
      return IMPL.getWindowId(this.mRecord);
   }

   public int hashCode() {
      return this.mRecord == null?0:this.mRecord.hashCode();
   }

   public boolean isChecked() {
      return IMPL.isChecked(this.mRecord);
   }

   public boolean isEnabled() {
      return IMPL.isEnabled(this.mRecord);
   }

   public boolean isFullScreen() {
      return IMPL.isFullScreen(this.mRecord);
   }

   public boolean isPassword() {
      return IMPL.isPassword(this.mRecord);
   }

   public boolean isScrollable() {
      return IMPL.isScrollable(this.mRecord);
   }

   public void recycle() {
      IMPL.recycle(this.mRecord);
   }

   public void setAddedCount(int var1) {
      IMPL.setAddedCount(this.mRecord, var1);
   }

   public void setBeforeText(CharSequence var1) {
      IMPL.setBeforeText(this.mRecord, var1);
   }

   public void setChecked(boolean var1) {
      IMPL.setChecked(this.mRecord, var1);
   }

   public void setClassName(CharSequence var1) {
      IMPL.setClassName(this.mRecord, var1);
   }

   public void setContentDescription(CharSequence var1) {
      IMPL.setContentDescription(this.mRecord, var1);
   }

   public void setCurrentItemIndex(int var1) {
      IMPL.setCurrentItemIndex(this.mRecord, var1);
   }

   public void setEnabled(boolean var1) {
      IMPL.setEnabled(this.mRecord, var1);
   }

   public void setFromIndex(int var1) {
      IMPL.setFromIndex(this.mRecord, var1);
   }

   public void setFullScreen(boolean var1) {
      IMPL.setFullScreen(this.mRecord, var1);
   }

   public void setItemCount(int var1) {
      IMPL.setItemCount(this.mRecord, var1);
   }

   public void setMaxScrollX(int var1) {
      IMPL.setMaxScrollX(this.mRecord, var1);
   }

   public void setMaxScrollY(int var1) {
      IMPL.setMaxScrollY(this.mRecord, var1);
   }

   public void setParcelableData(Parcelable var1) {
      IMPL.setParcelableData(this.mRecord, var1);
   }

   public void setPassword(boolean var1) {
      IMPL.setPassword(this.mRecord, var1);
   }

   public void setRemovedCount(int var1) {
      IMPL.setRemovedCount(this.mRecord, var1);
   }

   public void setScrollX(int var1) {
      IMPL.setScrollX(this.mRecord, var1);
   }

   public void setScrollY(int var1) {
      IMPL.setScrollY(this.mRecord, var1);
   }

   public void setScrollable(boolean var1) {
      IMPL.setScrollable(this.mRecord, var1);
   }

   public void setSource(View var1) {
      IMPL.setSource(this.mRecord, var1);
   }

   public void setSource(View var1, int var2) {
      IMPL.setSource(this.mRecord, var1, var2);
   }

   public void setToIndex(int var1) {
      IMPL.setToIndex(this.mRecord, var1);
   }
}
