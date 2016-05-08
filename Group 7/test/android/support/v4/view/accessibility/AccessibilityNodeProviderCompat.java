package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderImpl;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl;
import java.util.List;

public class AccessibilityNodeProviderCompat {
   private static final AccessibilityNodeProviderCompat$AccessibilityNodeProviderImpl IMPL;
   private final Object mProvider;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl();
      } else {
         IMPL = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl();
      }
   }

   public AccessibilityNodeProviderCompat() {
      this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
   }

   public AccessibilityNodeProviderCompat(Object var1) {
      this.mProvider = var1;
   }

   public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int var1) {
      return null;
   }

   public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String var1, int var2) {
      return null;
   }

   public AccessibilityNodeInfoCompat findFocus(int var1) {
      return null;
   }

   public Object getProvider() {
      return this.mProvider;
   }

   public boolean performAction(int var1, int var2, Bundle var3) {
      return false;
   }
}
