package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class AppCompatRatingBar extends RatingBar {
   private static final int[] TINT_ATTRS = new int[]{16843067, 16843068};
   private Bitmap mSampleTile;

   public AppCompatRatingBar(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatRatingBar(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.ratingBarStyle);
   }

   public AppCompatRatingBar(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      if(TintManager.SHOULD_BE_USED) {
         TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, TINT_ATTRS, var3, 0);
         Drawable var5 = var4.getDrawableIfKnown(0);
         if(var5 != null) {
            this.setIndeterminateDrawable(this.tileifyIndeterminate(var5));
         }

         var5 = var4.getDrawableIfKnown(1);
         if(var5 != null) {
            this.setProgressDrawable(this.tileify(var5, false));
         }

         var4.recycle();
      }

   }

   private Shape getDrawableShape() {
      return new RoundRectShape(new float[]{5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F}, (RectF)null, (float[])null);
   }

   private Drawable tileify(Drawable var1, boolean var2) {
      Drawable var6;
      if(var1 instanceof DrawableWrapper) {
         var6 = ((DrawableWrapper)var1).getWrappedDrawable();
         if(var6 != null) {
            var6 = this.tileify(var6, var2);
            ((DrawableWrapper)var1).setWrappedDrawable(var6);
         }
      } else if(var1 instanceof LayerDrawable) {
         LayerDrawable var7 = (LayerDrawable)var1;
         int var4 = var7.getNumberOfLayers();
         Drawable[] var8 = new Drawable[var4];

         int var3;
         for(var3 = 0; var3 < var4; ++var3) {
            int var5 = var7.getId(var3);
            var6 = var7.getDrawable(var3);
            if(var5 != 16908301 && var5 != 16908303) {
               var2 = false;
            } else {
               var2 = true;
            }

            var8[var3] = this.tileify(var6, var2);
         }

         LayerDrawable var11 = new LayerDrawable(var8);
         var3 = 0;

         while(true) {
            var1 = var11;
            if(var3 >= var4) {
               break;
            }

            var11.setId(var3, var7.getId(var3));
            ++var3;
         }
      } else if(var1 instanceof BitmapDrawable) {
         Bitmap var9 = ((BitmapDrawable)var1).getBitmap();
         if(this.mSampleTile == null) {
            this.mSampleTile = var9;
         }

         ShapeDrawable var12 = new ShapeDrawable(this.getDrawableShape());
         BitmapShader var10 = new BitmapShader(var9, TileMode.REPEAT, TileMode.CLAMP);
         var12.getPaint().setShader(var10);
         var1 = var12;
         if(var2) {
            var1 = new ClipDrawable(var12, 3, 1);
         }

         return (Drawable)var1;
      }

      return (Drawable)var1;
   }

   private Drawable tileifyIndeterminate(Drawable var1) {
      Object var4 = var1;
      if(var1 instanceof AnimationDrawable) {
         AnimationDrawable var6 = (AnimationDrawable)var1;
         int var3 = var6.getNumberOfFrames();
         var4 = new AnimationDrawable();
         ((AnimationDrawable)var4).setOneShot(var6.isOneShot());

         for(int var2 = 0; var2 < var3; ++var2) {
            Drawable var5 = this.tileify(var6.getFrame(var2), true);
            var5.setLevel(10000);
            ((AnimationDrawable)var4).addFrame(var5, var6.getDuration(var2));
         }

         ((AnimationDrawable)var4).setLevel(10000);
      }

      return (Drawable)var4;
   }

   protected void onMeasure(int var1, int var2) {
      synchronized(this){}

      try {
         super.onMeasure(var1, var2);
         if(this.mSampleTile != null) {
            this.setMeasuredDimension(ViewCompat.resolveSizeAndState(this.mSampleTile.getWidth() * this.getNumStars(), var1, 0), this.getMeasuredHeight());
         }
      } finally {
         ;
      }

   }
}
