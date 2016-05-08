package android.support.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.Path;
import android.support.graphics.drawable.PathParser;
import android.support.graphics.drawable.PathParser$PathDataNode;
import android.util.Log;

class VectorDrawableCompat$VPath {
   int mChangingConfigurations;
   protected PathParser$PathDataNode[] mNodes = null;
   String mPathName;

   public VectorDrawableCompat$VPath() {
   }

   public VectorDrawableCompat$VPath(VectorDrawableCompat$VPath var1) {
      this.mPathName = var1.mPathName;
      this.mChangingConfigurations = var1.mChangingConfigurations;
      this.mNodes = PathParser.deepCopyNodes(var1.mNodes);
   }

   public String NodesToString(PathParser$PathDataNode[] var1) {
      String var4 = " ";

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var4 = var4 + var1[var2].type + ":";
         float[] var5 = var1[var2].params;

         for(int var3 = 0; var3 < var5.length; ++var3) {
            var4 = var4 + var5[var3] + ",";
         }
      }

      return var4;
   }

   public void applyTheme(Theme var1) {
   }

   public boolean canApplyTheme() {
      return false;
   }

   public PathParser$PathDataNode[] getPathData() {
      return this.mNodes;
   }

   public String getPathName() {
      return this.mPathName;
   }

   public boolean isClipPath() {
      return false;
   }

   public void printVPath(int var1) {
      String var3 = "";

      for(int var2 = 0; var2 < var1; ++var2) {
         var3 = var3 + "    ";
      }

      Log.v("VectorDrawableCompat", var3 + "current path is :" + this.mPathName + " pathData is " + this.NodesToString(this.mNodes));
   }

   public void setPathData(PathParser$PathDataNode[] var1) {
      if(!PathParser.canMorph(this.mNodes, var1)) {
         this.mNodes = PathParser.deepCopyNodes(var1);
      } else {
         PathParser.updateNodes(this.mNodes, var1);
      }
   }

   public void toPath(Path var1) {
      var1.reset();
      if(this.mNodes != null) {
         PathParser$PathDataNode.nodesToPath(this.mNodes, var1);
      }

   }
}
