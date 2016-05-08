package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public interface AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean {
   boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2);

   Object getAccessibilityNodeProvider(View var1);

   void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2);

   void onInitializeAccessibilityNodeInfo(View var1, Object var2);

   void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2);

   boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3);

   boolean performAccessibilityAction(View var1, int var2, Bundle var3);

   void sendAccessibilityEvent(View var1, int var2);

   void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2);
}
