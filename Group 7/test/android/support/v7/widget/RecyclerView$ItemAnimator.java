package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorFinishedListener;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorListener;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$ItemAnimator {
   public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
   public static final int FLAG_CHANGED = 2;
   public static final int FLAG_INVALIDATED = 4;
   public static final int FLAG_MOVED = 2048;
   public static final int FLAG_REMOVED = 8;
   private long mAddDuration = 120L;
   private long mChangeDuration = 250L;
   private ArrayList<RecyclerView$ItemAnimator$ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
   private RecyclerView$ItemAnimator$ItemAnimatorListener mListener = null;
   private long mMoveDuration = 250L;
   private long mRemoveDuration = 120L;

   static int buildAdapterChangeFlagsForAnimations(RecyclerView$ViewHolder var0) {
      int var2 = RecyclerView$ViewHolder.access$6500(var0) & 14;
      if(var0.isInvalid()) {
         return 4;
      } else {
         int var1 = var2;
         if((var2 & 4) == 0) {
            int var3 = var0.getOldPosition();
            int var4 = var0.getAdapterPosition();
            var1 = var2;
            if(var3 != -1) {
               var1 = var2;
               if(var4 != -1) {
                  var1 = var2;
                  if(var3 != var4) {
                     var1 = var2 | 2048;
                  }
               }
            }
         }

         return var1;
      }
   }

   public abstract boolean animateAppearance(@NonNull RecyclerView$ViewHolder var1, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo var2, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var3);

   public abstract boolean animateChange(@NonNull RecyclerView$ViewHolder var1, @NonNull RecyclerView$ViewHolder var2, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var3, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var4);

   public abstract boolean animateDisappearance(@NonNull RecyclerView$ViewHolder var1, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var2, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo var3);

   public abstract boolean animatePersistence(@NonNull RecyclerView$ViewHolder var1, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var2, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var3);

   public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView$ViewHolder var1) {
      return true;
   }

   public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView$ViewHolder var1, @NonNull List<Object> var2) {
      return this.canReuseUpdatedViewHolder(var1);
   }

   public final void dispatchAnimationFinished(RecyclerView$ViewHolder var1) {
      this.onAnimationFinished(var1);
      if(this.mListener != null) {
         this.mListener.onAnimationFinished(var1);
      }

   }

   public final void dispatchAnimationStarted(RecyclerView$ViewHolder var1) {
      this.onAnimationStarted(var1);
   }

   public final void dispatchAnimationsFinished() {
      int var2 = this.mFinishedListeners.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         ((RecyclerView$ItemAnimator$ItemAnimatorFinishedListener)this.mFinishedListeners.get(var1)).onAnimationsFinished();
      }

      this.mFinishedListeners.clear();
   }

   public abstract void endAnimation(RecyclerView$ViewHolder var1);

   public abstract void endAnimations();

   public long getAddDuration() {
      return this.mAddDuration;
   }

   public long getChangeDuration() {
      return this.mChangeDuration;
   }

   public long getMoveDuration() {
      return this.mMoveDuration;
   }

   public long getRemoveDuration() {
      return this.mRemoveDuration;
   }

   public abstract boolean isRunning();

   public final boolean isRunning(RecyclerView$ItemAnimator$ItemAnimatorFinishedListener var1) {
      boolean var2 = this.isRunning();
      if(var1 != null) {
         if(var2) {
            this.mFinishedListeners.add(var1);
            return var2;
         }

         var1.onAnimationsFinished();
      }

      return var2;
   }

   public RecyclerView$ItemAnimator$ItemHolderInfo obtainHolderInfo() {
      return new RecyclerView$ItemAnimator$ItemHolderInfo();
   }

   public void onAnimationFinished(RecyclerView$ViewHolder var1) {
   }

   public void onAnimationStarted(RecyclerView$ViewHolder var1) {
   }

   @NonNull
   public RecyclerView$ItemAnimator$ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView$State var1, @NonNull RecyclerView$ViewHolder var2) {
      return this.obtainHolderInfo().setFrom(var2);
   }

   @NonNull
   public RecyclerView$ItemAnimator$ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView$State var1, @NonNull RecyclerView$ViewHolder var2, int var3, @NonNull List<Object> var4) {
      return this.obtainHolderInfo().setFrom(var2);
   }

   public abstract void runPendingAnimations();

   public void setAddDuration(long var1) {
      this.mAddDuration = var1;
   }

   public void setChangeDuration(long var1) {
      this.mChangeDuration = var1;
   }

   void setListener(RecyclerView$ItemAnimator$ItemAnimatorListener var1) {
      this.mListener = var1;
   }

   public void setMoveDuration(long var1) {
      this.mMoveDuration = var1;
   }

   public void setRemoveDuration(long var1) {
      this.mRemoveDuration = var1;
   }
}
