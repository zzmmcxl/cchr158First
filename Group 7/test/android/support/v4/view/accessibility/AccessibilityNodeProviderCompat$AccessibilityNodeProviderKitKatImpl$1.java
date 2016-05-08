package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1 implements AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge {
   AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1(AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl var1, AccessibilityNodeProviderCompat var2) {
      this.this$0 = var1;
      this.val$compat = var2;
   }

   public Object createAccessibilityNodeInfo(int var1) {
      AccessibilityNodeInfoCompat var2 = this.val$compat.createAccessibilityNodeInfo(var1);
      return var2 == null?null:var2.getInfo();
   }

   public List<Object> findAccessibilityNodeInfosByText(String var1, int var2) {
      List var5 = this.val$compat.findAccessibilityNodeInfosByText(var1, var2);
      ArrayList var4 = new ArrayList();
      int var3 = var5.size();

      for(var2 = 0; var2 < var3; ++var2) {
         var4.add(((AccessibilityNodeInfoCompat)var5.get(var2)).getInfo());
      }

      return var4;
   }

   public Object findFocus(int var1) {
      AccessibilityNodeInfoCompat var2 = this.val$compat.findFocus(var1);
      return var2 == null?null:var2.getInfo();
   }

   public boolean performAction(int var1, int var2, Bundle var3) {
      return this.val$compat.performAction(var1, var2, var3);
   }
}
