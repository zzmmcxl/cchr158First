package android.support.v4.widget;

import android.support.v4.widget.MaterialProgressDrawable;
import android.support.v4.widget.MaterialProgressDrawable$Ring;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class MaterialProgressDrawable$1 extends Animation {
   MaterialProgressDrawable$1(MaterialProgressDrawable var1, MaterialProgressDrawable$Ring var2) {
      this.this$0 = var1;
      this.val$ring = var2;
   }

   public void applyTransformation(float var1, Transformation var2) {
      if(this.this$0.mFinishing) {
         MaterialProgressDrawable.access$000(this.this$0, var1, this.val$ring);
      } else {
         float var3 = MaterialProgressDrawable.access$100(this.this$0, this.val$ring);
         float var4 = this.val$ring.getStartingEndTrim();
         float var6 = this.val$ring.getStartingStartTrim();
         float var5 = this.val$ring.getStartingRotation();
         MaterialProgressDrawable.access$200(this.this$0, var1, this.val$ring);
         if(var1 <= 0.5F) {
            float var7 = var1 / 0.5F;
            var7 = MaterialProgressDrawable.access$300().getInterpolation(var7);
            this.val$ring.setStartTrim(var6 + (0.8F - var3) * var7);
         }

         if(var1 > 0.5F) {
            var6 = (var1 - 0.5F) / 0.5F;
            var6 = MaterialProgressDrawable.access$300().getInterpolation(var6);
            this.val$ring.setEndTrim(var4 + var6 * (0.8F - var3));
         }

         this.val$ring.setRotation(var5 + 0.25F * var1);
         var3 = MaterialProgressDrawable.access$400(this.this$0) / 5.0F;
         this.this$0.setRotation(216.0F * var1 + 1080.0F * var3);
      }
   }
}
