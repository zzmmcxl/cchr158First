package android.support.v4.view.accessibility;

import android.graphics.Rect;

interface AccessibilityWindowInfoCompat$AccessibilityWindowInfoImpl {
   void getBoundsInScreen(Object var1, Rect var2);

   Object getChild(Object var1, int var2);

   int getChildCount(Object var1);

   int getId(Object var1);

   int getLayer(Object var1);

   Object getParent(Object var1);

   Object getRoot(Object var1);

   int getType(Object var1);

   boolean isAccessibilityFocused(Object var1);

   boolean isActive(Object var1);

   boolean isFocused(Object var1);

   Object obtain();

   Object obtain(Object var1);

   void recycle(Object var1);
}
