package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

interface AccessibilityDelegateCompat$AccessibilityDelegateImpl {
   boolean dispatchPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3);

   AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object var1, View var2);

   Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat var1);

   Object newAccessiblityDelegateDefaultImpl();

   void onInitializeAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3);

   void onInitializeAccessibilityNodeInfo(Object var1, View var2, AccessibilityNodeInfoCompat var3);

   void onPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3);

   boolean onRequestSendAccessibilityEvent(Object var1, ViewGroup var2, View var3, AccessibilityEvent var4);

   boolean performAccessibilityAction(Object var1, View var2, int var3, Bundle var4);

   void sendAccessibilityEvent(Object var1, View var2, int var3);

   void sendAccessibilityEventUnchecked(Object var1, View var2, AccessibilityEvent var3);
}
