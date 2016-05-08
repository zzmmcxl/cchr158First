package android.support.v4.view;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateImpl;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateStubImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityDelegateCompat {
   private static final Object DEFAULT_DELEGATE;
   private static final AccessibilityDelegateCompat$AccessibilityDelegateImpl IMPL;
   final Object mBridge;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl();
      } else {
         IMPL = new AccessibilityDelegateCompat$AccessibilityDelegateStubImpl();
      }

      DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
   }

   public AccessibilityDelegateCompat() {
      this.mBridge = IMPL.newAccessiblityDelegateBridge(this);
   }

   public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, var1, var2);
   }

   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1) {
      return IMPL.getAccessibilityNodeProvider(DEFAULT_DELEGATE, var1);
   }

   Object getBridge() {
      return this.mBridge;
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, var1, var2);
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, var1, var2);
   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, var1, var2);
   }

   public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, var1, var2, var3);
   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return IMPL.performAccessibilityAction(DEFAULT_DELEGATE, var1, var2, var3);
   }

   public void sendAccessibilityEvent(View var1, int var2) {
      IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, var1, var2);
   }

   public void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
      IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, var1, var2);
   }
}
