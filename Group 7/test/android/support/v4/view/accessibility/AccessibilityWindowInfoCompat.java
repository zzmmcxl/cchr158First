package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$1;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoApi21Impl;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoImpl;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoStubImpl;

public class AccessibilityWindowInfoCompat {
   private static final AccessibilityWindowInfoCompat$AccessibilityWindowInfoImpl IMPL;
   public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
   public static final int TYPE_APPLICATION = 1;
   public static final int TYPE_INPUT_METHOD = 2;
   public static final int TYPE_SYSTEM = 3;
   private static final int UNDEFINED = -1;
   private Object mInfo;

   static {
      if(VERSION.SDK_INT >= 21) {
         IMPL = new AccessibilityWindowInfoCompat$AccessibilityWindowInfoApi21Impl((AccessibilityWindowInfoCompat$1)null);
      } else {
         IMPL = new AccessibilityWindowInfoCompat$AccessibilityWindowInfoStubImpl((AccessibilityWindowInfoCompat$1)null);
      }
   }

   private AccessibilityWindowInfoCompat(Object var1) {
      this.mInfo = var1;
   }

   public static AccessibilityWindowInfoCompat obtain() {
      return wrapNonNullInstance(IMPL.obtain());
   }

   public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat var0) {
      return wrapNonNullInstance(IMPL.obtain(var0.mInfo));
   }

   private static String typeToString(int var0) {
      switch(var0) {
      case 1:
         return "TYPE_APPLICATION";
      case 2:
         return "TYPE_INPUT_METHOD";
      case 3:
         return "TYPE_SYSTEM";
      case 4:
         return "TYPE_ACCESSIBILITY_OVERLAY";
      default:
         return "<UNKNOWN>";
      }
   }

   static AccessibilityWindowInfoCompat wrapNonNullInstance(Object var0) {
      return var0 != null?new AccessibilityWindowInfoCompat(var0):null;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         AccessibilityWindowInfoCompat var2 = (AccessibilityWindowInfoCompat)var1;
         if(this.mInfo == null) {
            if(var2.mInfo != null) {
               return false;
            }
         } else if(!this.mInfo.equals(var2.mInfo)) {
            return false;
         }
      }

      return true;
   }

   public void getBoundsInScreen(Rect var1) {
      IMPL.getBoundsInScreen(this.mInfo, var1);
   }

   public AccessibilityWindowInfoCompat getChild(int var1) {
      return wrapNonNullInstance(IMPL.getChild(this.mInfo, var1));
   }

   public int getChildCount() {
      return IMPL.getChildCount(this.mInfo);
   }

   public int getId() {
      return IMPL.getId(this.mInfo);
   }

   public int getLayer() {
      return IMPL.getLayer(this.mInfo);
   }

   public AccessibilityWindowInfoCompat getParent() {
      return wrapNonNullInstance(IMPL.getParent(this.mInfo));
   }

   public AccessibilityNodeInfoCompat getRoot() {
      return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getRoot(this.mInfo));
   }

   public int getType() {
      return IMPL.getType(this.mInfo);
   }

   public int hashCode() {
      return this.mInfo == null?0:this.mInfo.hashCode();
   }

   public boolean isAccessibilityFocused() {
      return IMPL.isAccessibilityFocused(this.mInfo);
   }

   public boolean isActive() {
      return IMPL.isActive(this.mInfo);
   }

   public boolean isFocused() {
      return IMPL.isFocused(this.mInfo);
   }

   public void recycle() {
      IMPL.recycle(this.mInfo);
   }

   public String toString() {
      boolean var2 = true;
      StringBuilder var3 = new StringBuilder();
      Rect var4 = new Rect();
      this.getBoundsInScreen(var4);
      var3.append("AccessibilityWindowInfo[");
      var3.append("id=").append(this.getId());
      var3.append(", type=").append(typeToString(this.getType()));
      var3.append(", layer=").append(this.getLayer());
      var3.append(", bounds=").append(var4);
      var3.append(", focused=").append(this.isFocused());
      var3.append(", active=").append(this.isActive());
      StringBuilder var5 = var3.append(", hasParent=");
      boolean var1;
      if(this.getParent() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      var5.append(var1);
      var5 = var3.append(", hasChildren=");
      if(this.getChildCount() > 0) {
         var1 = var2;
      } else {
         var1 = false;
      }

      var5.append(var1);
      var3.append(']');
      return var3.toString();
   }
}
