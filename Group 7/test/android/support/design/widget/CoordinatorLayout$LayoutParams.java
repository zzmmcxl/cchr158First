package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.R$styleable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout$Behavior;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class CoordinatorLayout$LayoutParams extends MarginLayoutParams {
   public int anchorGravity = 0;
   public int gravity = 0;
   public int keyline = -1;
   View mAnchorDirectChild;
   int mAnchorId = -1;
   View mAnchorView;
   CoordinatorLayout$Behavior mBehavior;
   boolean mBehaviorResolved = false;
   Object mBehaviorTag;
   private boolean mDidAcceptNestedScroll;
   private boolean mDidBlockInteraction;
   private boolean mDidChangeAfterNestedScroll;
   final Rect mLastChildRect = new Rect();

   public CoordinatorLayout$LayoutParams(int var1, int var2) {
      super(var1, var2);
   }

   CoordinatorLayout$LayoutParams(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R$styleable.CoordinatorLayout_LayoutParams);
      this.gravity = var3.getInteger(R$styleable.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
      this.mAnchorId = var3.getResourceId(R$styleable.CoordinatorLayout_LayoutParams_layout_anchor, -1);
      this.anchorGravity = var3.getInteger(R$styleable.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
      this.keyline = var3.getInteger(R$styleable.CoordinatorLayout_LayoutParams_layout_keyline, -1);
      this.mBehaviorResolved = var3.hasValue(R$styleable.CoordinatorLayout_LayoutParams_layout_behavior);
      if(this.mBehaviorResolved) {
         this.mBehavior = CoordinatorLayout.parseBehavior(var1, var2, var3.getString(R$styleable.CoordinatorLayout_LayoutParams_layout_behavior));
      }

      var3.recycle();
   }

   public CoordinatorLayout$LayoutParams(CoordinatorLayout$LayoutParams var1) {
      super(var1);
   }

   public CoordinatorLayout$LayoutParams(LayoutParams var1) {
      super(var1);
   }

   public CoordinatorLayout$LayoutParams(MarginLayoutParams var1) {
      super(var1);
   }

   private void resolveAnchorView(View var1, CoordinatorLayout var2) {
      this.mAnchorView = var2.findViewById(this.mAnchorId);
      if(this.mAnchorView == null) {
         if(var2.isInEditMode()) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
         } else {
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + var2.getResources().getResourceName(this.mAnchorId) + " to anchor view " + var1);
         }
      } else if(this.mAnchorView == var2) {
         if(var2.isInEditMode()) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
         } else {
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
         }
      } else {
         View var4 = this.mAnchorView;

         for(ViewParent var3 = this.mAnchorView.getParent(); var3 != var2 && var3 != null; var3 = var3.getParent()) {
            if(var3 == var1) {
               if(var2.isInEditMode()) {
                  this.mAnchorDirectChild = null;
                  this.mAnchorView = null;
                  return;
               }

               throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
            }

            if(var3 instanceof View) {
               var4 = (View)var3;
            }
         }

         this.mAnchorDirectChild = var4;
      }
   }

   private boolean verifyAnchorView(View var1, CoordinatorLayout var2) {
      if(this.mAnchorView.getId() != this.mAnchorId) {
         return false;
      } else {
         View var4 = this.mAnchorView;

         for(ViewParent var3 = this.mAnchorView.getParent(); var3 != var2; var3 = var3.getParent()) {
            if(var3 == null || var3 == var1) {
               this.mAnchorDirectChild = null;
               this.mAnchorView = null;
               return false;
            }

            if(var3 instanceof View) {
               var4 = (View)var3;
            }
         }

         this.mAnchorDirectChild = var4;
         return true;
      }
   }

   void acceptNestedScroll(boolean var1) {
      this.mDidAcceptNestedScroll = var1;
   }

   boolean checkAnchorChanged() {
      return this.mAnchorView == null && this.mAnchorId != -1;
   }

   boolean dependsOn(CoordinatorLayout var1, View var2, View var3) {
      return var3 == this.mAnchorDirectChild || this.mBehavior != null && this.mBehavior.layoutDependsOn(var1, var2, var3);
   }

   boolean didBlockInteraction() {
      if(this.mBehavior == null) {
         this.mDidBlockInteraction = false;
      }

      return this.mDidBlockInteraction;
   }

   View findAnchorView(CoordinatorLayout var1, View var2) {
      if(this.mAnchorId == -1) {
         this.mAnchorDirectChild = null;
         this.mAnchorView = null;
         return null;
      } else {
         if(this.mAnchorView == null || !this.verifyAnchorView(var2, var1)) {
            this.resolveAnchorView(var2, var1);
         }

         return this.mAnchorView;
      }
   }

   public int getAnchorId() {
      return this.mAnchorId;
   }

   public CoordinatorLayout$Behavior getBehavior() {
      return this.mBehavior;
   }

   boolean getChangedAfterNestedScroll() {
      return this.mDidChangeAfterNestedScroll;
   }

   Rect getLastChildRect() {
      return this.mLastChildRect;
   }

   void invalidateAnchor() {
      this.mAnchorDirectChild = null;
      this.mAnchorView = null;
   }

   boolean isBlockingInteractionBelow(CoordinatorLayout var1, View var2) {
      if(this.mDidBlockInteraction) {
         return true;
      } else {
         boolean var4 = this.mDidBlockInteraction;
         boolean var3;
         if(this.mBehavior != null) {
            var3 = this.mBehavior.blocksInteractionBelow(var1, var2);
         } else {
            var3 = false;
         }

         var3 |= var4;
         this.mDidBlockInteraction = var3;
         return var3;
      }
   }

   boolean isDirty(CoordinatorLayout var1, View var2) {
      return this.mBehavior != null && this.mBehavior.isDirty(var1, var2);
   }

   boolean isNestedScrollAccepted() {
      return this.mDidAcceptNestedScroll;
   }

   void resetChangedAfterNestedScroll() {
      this.mDidChangeAfterNestedScroll = false;
   }

   void resetNestedScroll() {
      this.mDidAcceptNestedScroll = false;
   }

   void resetTouchBehaviorTracking() {
      this.mDidBlockInteraction = false;
   }

   public void setAnchorId(int var1) {
      this.invalidateAnchor();
      this.mAnchorId = var1;
   }

   public void setBehavior(CoordinatorLayout$Behavior var1) {
      if(this.mBehavior != var1) {
         this.mBehavior = var1;
         this.mBehaviorTag = null;
         this.mBehaviorResolved = true;
      }

   }

   void setChangedAfterNestedScroll(boolean var1) {
      this.mDidChangeAfterNestedScroll = var1;
   }

   void setLastChildRect(Rect var1) {
      this.mLastChildRect.set(var1);
   }
}
