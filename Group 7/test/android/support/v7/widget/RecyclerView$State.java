package android.support.v7.widget;

import android.util.SparseArray;

public class RecyclerView$State {
   static final int STEP_ANIMATIONS = 4;
   static final int STEP_LAYOUT = 2;
   static final int STEP_START = 1;
   private SparseArray<Object> mData;
   private int mDeletedInvisibleItemCountSincePreviousLayout = 0;
   private boolean mInPreLayout = false;
   private boolean mIsMeasuring = false;
   int mItemCount = 0;
   private int mLayoutStep = 1;
   private int mPreviousLayoutItemCount = 0;
   private boolean mRunPredictiveAnimations = false;
   private boolean mRunSimpleAnimations = false;
   private boolean mStructureChanged = false;
   private int mTargetPosition = -1;
   private boolean mTrackOldChangeHolders = false;

   void assertLayoutStep(int var1) {
      if((this.mLayoutStep & var1) == 0) {
         throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(var1) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
      }
   }

   public boolean didStructureChange() {
      return this.mStructureChanged;
   }

   public <T> T get(int var1) {
      return this.mData == null?null:this.mData.get(var1);
   }

   public int getItemCount() {
      return this.mInPreLayout?this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout:this.mItemCount;
   }

   public int getTargetScrollPosition() {
      return this.mTargetPosition;
   }

   public boolean hasTargetScrollPosition() {
      return this.mTargetPosition != -1;
   }

   public boolean isMeasuring() {
      return this.mIsMeasuring;
   }

   public boolean isPreLayout() {
      return this.mInPreLayout;
   }

   public void put(int var1, Object var2) {
      if(this.mData == null) {
         this.mData = new SparseArray();
      }

      this.mData.put(var1, var2);
   }

   public void remove(int var1) {
      if(this.mData != null) {
         this.mData.remove(var1);
      }
   }

   RecyclerView$State reset() {
      this.mTargetPosition = -1;
      if(this.mData != null) {
         this.mData.clear();
      }

      this.mItemCount = 0;
      this.mStructureChanged = false;
      this.mIsMeasuring = false;
      return this;
   }

   public String toString() {
      return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
   }

   public boolean willRunPredictiveAnimations() {
      return this.mRunPredictiveAnimations;
   }

   public boolean willRunSimpleAnimations() {
      return this.mRunSimpleAnimations;
   }
}
