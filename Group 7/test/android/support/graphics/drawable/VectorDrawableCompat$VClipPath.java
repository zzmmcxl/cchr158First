package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.support.graphics.drawable.AndroidResources;
import android.support.graphics.drawable.PathParser;
import android.support.graphics.drawable.TypedArrayUtils;
import android.support.graphics.drawable.VectorDrawableCommon;
import android.support.graphics.drawable.VectorDrawableCompat$VPath;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class VectorDrawableCompat$VClipPath extends VectorDrawableCompat$VPath {
   public VectorDrawableCompat$VClipPath() {
   }

   public VectorDrawableCompat$VClipPath(VectorDrawableCompat$VClipPath var1) {
      super(var1);
   }

   private void updateStateFromTypedArray(TypedArray var1) {
      String var2 = var1.getString(0);
      if(var2 != null) {
         this.mPathName = var2;
      }

      String var3 = var1.getString(1);
      if(var3 != null) {
         this.mNodes = PathParser.createNodesFromPathData(var3);
      }

   }

   public void inflate(Resources var1, AttributeSet var2, Theme var3, XmlPullParser var4) {
      if(TypedArrayUtils.hasAttribute(var4, "pathData")) {
         TypedArray var5 = VectorDrawableCommon.obtainAttributes(var1, var3, var2, AndroidResources.styleable_VectorDrawableClipPath);
         this.updateStateFromTypedArray(var5);
         var5.recycle();
      }
   }

   public boolean isClipPath() {
      return true;
   }
}
