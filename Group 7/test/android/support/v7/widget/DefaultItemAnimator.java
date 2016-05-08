package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.DefaultItemAnimator$1;
import android.support.v7.widget.DefaultItemAnimator$2;
import android.support.v7.widget.DefaultItemAnimator$3;
import android.support.v7.widget.DefaultItemAnimator$4;
import android.support.v7.widget.DefaultItemAnimator$5;
import android.support.v7.widget.DefaultItemAnimator$6;
import android.support.v7.widget.DefaultItemAnimator$7;
import android.support.v7.widget.DefaultItemAnimator$8;
import android.support.v7.widget.DefaultItemAnimator$ChangeInfo;
import android.support.v7.widget.DefaultItemAnimator$MoveInfo;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
   private static final boolean DEBUG = false;
   private ArrayList<RecyclerView$ViewHolder> mAddAnimations = new ArrayList();
   private ArrayList<ArrayList<RecyclerView$ViewHolder>> mAdditionsList = new ArrayList();
   private ArrayList<RecyclerView$ViewHolder> mChangeAnimations = new ArrayList();
   private ArrayList<ArrayList<DefaultItemAnimator$ChangeInfo>> mChangesList = new ArrayList();
   private ArrayList<RecyclerView$ViewHolder> mMoveAnimations = new ArrayList();
   private ArrayList<ArrayList<DefaultItemAnimator$MoveInfo>> mMovesList = new ArrayList();
   private ArrayList<RecyclerView$ViewHolder> mPendingAdditions = new ArrayList();
   private ArrayList<DefaultItemAnimator$ChangeInfo> mPendingChanges = new ArrayList();
   private ArrayList<DefaultItemAnimator$MoveInfo> mPendingMoves = new ArrayList();
   private ArrayList<RecyclerView$ViewHolder> mPendingRemovals = new ArrayList();
   private ArrayList<RecyclerView$ViewHolder> mRemoveAnimations = new ArrayList();

   private void animateAddImpl(RecyclerView$ViewHolder var1) {
      ViewPropertyAnimatorCompat var2 = ViewCompat.animate(var1.itemView);
      this.mAddAnimations.add(var1);
      var2.alpha(1.0F).setDuration(this.getAddDuration()).setListener(new DefaultItemAnimator$5(this, var1, var2)).start();
   }

   private void animateChangeImpl(DefaultItemAnimator$ChangeInfo var1) {
      RecyclerView$ViewHolder var2 = var1.oldHolder;
      View var4;
      if(var2 == null) {
         var4 = null;
      } else {
         var4 = var2.itemView;
      }

      RecyclerView$ViewHolder var3 = var1.newHolder;
      View var5;
      if(var3 != null) {
         var5 = var3.itemView;
      } else {
         var5 = null;
      }

      ViewPropertyAnimatorCompat var6;
      if(var4 != null) {
         var6 = ViewCompat.animate(var4).setDuration(this.getChangeDuration());
         this.mChangeAnimations.add(var1.oldHolder);
         var6.translationX((float)(var1.toX - var1.fromX));
         var6.translationY((float)(var1.toY - var1.fromY));
         var6.alpha(0.0F).setListener(new DefaultItemAnimator$7(this, var1, var6)).start();
      }

      if(var5 != null) {
         var6 = ViewCompat.animate(var5);
         this.mChangeAnimations.add(var1.newHolder);
         var6.translationX(0.0F).translationY(0.0F).setDuration(this.getChangeDuration()).alpha(1.0F).setListener(new DefaultItemAnimator$8(this, var1, var6, var5)).start();
      }

   }

   private void animateMoveImpl(RecyclerView$ViewHolder var1, int var2, int var3, int var4, int var5) {
      View var6 = var1.itemView;
      var2 = var4 - var2;
      var3 = var5 - var3;
      if(var2 != 0) {
         ViewCompat.animate(var6).translationX(0.0F);
      }

      if(var3 != 0) {
         ViewCompat.animate(var6).translationY(0.0F);
      }

      ViewPropertyAnimatorCompat var7 = ViewCompat.animate(var6);
      this.mMoveAnimations.add(var1);
      var7.setDuration(this.getMoveDuration()).setListener(new DefaultItemAnimator$6(this, var1, var2, var3, var7)).start();
   }

   private void animateRemoveImpl(RecyclerView$ViewHolder var1) {
      ViewPropertyAnimatorCompat var2 = ViewCompat.animate(var1.itemView);
      this.mRemoveAnimations.add(var1);
      var2.setDuration(this.getRemoveDuration()).alpha(0.0F).setListener(new DefaultItemAnimator$4(this, var1, var2)).start();
   }

   private void dispatchFinishedWhenDone() {
      if(!this.isRunning()) {
         this.dispatchAnimationsFinished();
      }

   }

   private void endChangeAnimation(List<DefaultItemAnimator$ChangeInfo> var1, RecyclerView$ViewHolder var2) {
      for(int var3 = var1.size() - 1; var3 >= 0; --var3) {
         DefaultItemAnimator$ChangeInfo var4 = (DefaultItemAnimator$ChangeInfo)var1.get(var3);
         if(this.endChangeAnimationIfNecessary(var4, var2) && var4.oldHolder == null && var4.newHolder == null) {
            var1.remove(var4);
         }
      }

   }

   private void endChangeAnimationIfNecessary(DefaultItemAnimator$ChangeInfo var1) {
      if(var1.oldHolder != null) {
         this.endChangeAnimationIfNecessary(var1, var1.oldHolder);
      }

      if(var1.newHolder != null) {
         this.endChangeAnimationIfNecessary(var1, var1.newHolder);
      }

   }

   private boolean endChangeAnimationIfNecessary(DefaultItemAnimator$ChangeInfo var1, RecyclerView$ViewHolder var2) {
      boolean var3 = false;
      if(var1.newHolder == var2) {
         var1.newHolder = null;
      } else {
         if(var1.oldHolder != var2) {
            return false;
         }

         var1.oldHolder = null;
         var3 = true;
      }

      ViewCompat.setAlpha(var2.itemView, 1.0F);
      ViewCompat.setTranslationX(var2.itemView, 0.0F);
      ViewCompat.setTranslationY(var2.itemView, 0.0F);
      this.dispatchChangeFinished(var2, var3);
      return true;
   }

   private void resetAnimation(RecyclerView$ViewHolder var1) {
      AnimatorCompatHelper.clearInterpolator(var1.itemView);
      this.endAnimation(var1);
   }

   public boolean animateAdd(RecyclerView$ViewHolder var1) {
      this.resetAnimation(var1);
      ViewCompat.setAlpha(var1.itemView, 0.0F);
      this.mPendingAdditions.add(var1);
      return true;
   }

   public boolean animateChange(RecyclerView$ViewHolder var1, RecyclerView$ViewHolder var2, int var3, int var4, int var5, int var6) {
      if(var1 == var2) {
         return this.animateMove(var1, var3, var4, var5, var6);
      } else {
         float var7 = ViewCompat.getTranslationX(var1.itemView);
         float var8 = ViewCompat.getTranslationY(var1.itemView);
         float var9 = ViewCompat.getAlpha(var1.itemView);
         this.resetAnimation(var1);
         int var10 = (int)((float)(var5 - var3) - var7);
         int var11 = (int)((float)(var6 - var4) - var8);
         ViewCompat.setTranslationX(var1.itemView, var7);
         ViewCompat.setTranslationY(var1.itemView, var8);
         ViewCompat.setAlpha(var1.itemView, var9);
         if(var2 != null) {
            this.resetAnimation(var2);
            ViewCompat.setTranslationX(var2.itemView, (float)(-var10));
            ViewCompat.setTranslationY(var2.itemView, (float)(-var11));
            ViewCompat.setAlpha(var2.itemView, 0.0F);
         }

         this.mPendingChanges.add(new DefaultItemAnimator$ChangeInfo(var1, var2, var3, var4, var5, var6, (DefaultItemAnimator$1)null));
         return true;
      }
   }

   public boolean animateMove(RecyclerView$ViewHolder var1, int var2, int var3, int var4, int var5) {
      View var8 = var1.itemView;
      var2 = (int)((float)var2 + ViewCompat.getTranslationX(var1.itemView));
      var3 = (int)((float)var3 + ViewCompat.getTranslationY(var1.itemView));
      this.resetAnimation(var1);
      int var6 = var4 - var2;
      int var7 = var5 - var3;
      if(var6 == 0 && var7 == 0) {
         this.dispatchMoveFinished(var1);
         return false;
      } else {
         if(var6 != 0) {
            ViewCompat.setTranslationX(var8, (float)(-var6));
         }

         if(var7 != 0) {
            ViewCompat.setTranslationY(var8, (float)(-var7));
         }

         this.mPendingMoves.add(new DefaultItemAnimator$MoveInfo(var1, var2, var3, var4, var5, (DefaultItemAnimator$1)null));
         return true;
      }
   }

   public boolean animateRemove(RecyclerView$ViewHolder var1) {
      this.resetAnimation(var1);
      this.mPendingRemovals.add(var1);
      return true;
   }

   public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView$ViewHolder var1, @NonNull List<Object> var2) {
      return !var2.isEmpty() || super.canReuseUpdatedViewHolder(var1, var2);
   }

   void cancelAll(List<RecyclerView$ViewHolder> var1) {
      for(int var2 = var1.size() - 1; var2 >= 0; --var2) {
         ViewCompat.animate(((RecyclerView$ViewHolder)var1.get(var2)).itemView).cancel();
      }

   }

   public void endAnimation(RecyclerView$ViewHolder var1) {
      View var4 = var1.itemView;
      ViewCompat.animate(var4).cancel();

      int var2;
      for(var2 = this.mPendingMoves.size() - 1; var2 >= 0; --var2) {
         if(((DefaultItemAnimator$MoveInfo)this.mPendingMoves.get(var2)).holder == var1) {
            ViewCompat.setTranslationY(var4, 0.0F);
            ViewCompat.setTranslationX(var4, 0.0F);
            this.dispatchMoveFinished(var1);
            this.mPendingMoves.remove(var2);
         }
      }

      this.endChangeAnimation(this.mPendingChanges, var1);
      if(this.mPendingRemovals.remove(var1)) {
         ViewCompat.setAlpha(var4, 1.0F);
         this.dispatchRemoveFinished(var1);
      }

      if(this.mPendingAdditions.remove(var1)) {
         ViewCompat.setAlpha(var4, 1.0F);
         this.dispatchAddFinished(var1);
      }

      ArrayList var5;
      for(var2 = this.mChangesList.size() - 1; var2 >= 0; --var2) {
         var5 = (ArrayList)this.mChangesList.get(var2);
         this.endChangeAnimation(var5, var1);
         if(var5.isEmpty()) {
            this.mChangesList.remove(var2);
         }
      }

      for(var2 = this.mMovesList.size() - 1; var2 >= 0; --var2) {
         var5 = (ArrayList)this.mMovesList.get(var2);

         for(int var3 = var5.size() - 1; var3 >= 0; --var3) {
            if(((DefaultItemAnimator$MoveInfo)var5.get(var3)).holder == var1) {
               ViewCompat.setTranslationY(var4, 0.0F);
               ViewCompat.setTranslationX(var4, 0.0F);
               this.dispatchMoveFinished(var1);
               var5.remove(var3);
               if(var5.isEmpty()) {
                  this.mMovesList.remove(var2);
               }
               break;
            }
         }
      }

      for(var2 = this.mAdditionsList.size() - 1; var2 >= 0; --var2) {
         var5 = (ArrayList)this.mAdditionsList.get(var2);
         if(var5.remove(var1)) {
            ViewCompat.setAlpha(var4, 1.0F);
            this.dispatchAddFinished(var1);
            if(var5.isEmpty()) {
               this.mAdditionsList.remove(var2);
            }
         }
      }

      if(this.mRemoveAnimations.remove(var1)) {
         ;
      }

      if(this.mAddAnimations.remove(var1)) {
         ;
      }

      if(this.mChangeAnimations.remove(var1)) {
         ;
      }

      if(this.mMoveAnimations.remove(var1)) {
         ;
      }

      this.dispatchFinishedWhenDone();
   }

   public void endAnimations() {
      int var1;
      for(var1 = this.mPendingMoves.size() - 1; var1 >= 0; --var1) {
         DefaultItemAnimator$MoveInfo var3 = (DefaultItemAnimator$MoveInfo)this.mPendingMoves.get(var1);
         View var4 = var3.holder.itemView;
         ViewCompat.setTranslationY(var4, 0.0F);
         ViewCompat.setTranslationX(var4, 0.0F);
         this.dispatchMoveFinished(var3.holder);
         this.mPendingMoves.remove(var1);
      }

      for(var1 = this.mPendingRemovals.size() - 1; var1 >= 0; --var1) {
         this.dispatchRemoveFinished((RecyclerView$ViewHolder)this.mPendingRemovals.get(var1));
         this.mPendingRemovals.remove(var1);
      }

      for(var1 = this.mPendingAdditions.size() - 1; var1 >= 0; --var1) {
         RecyclerView$ViewHolder var6 = (RecyclerView$ViewHolder)this.mPendingAdditions.get(var1);
         ViewCompat.setAlpha(var6.itemView, 1.0F);
         this.dispatchAddFinished(var6);
         this.mPendingAdditions.remove(var1);
      }

      for(var1 = this.mPendingChanges.size() - 1; var1 >= 0; --var1) {
         this.endChangeAnimationIfNecessary((DefaultItemAnimator$ChangeInfo)this.mPendingChanges.get(var1));
      }

      this.mPendingChanges.clear();
      if(this.isRunning()) {
         int var2;
         ArrayList var7;
         for(var1 = this.mMovesList.size() - 1; var1 >= 0; --var1) {
            var7 = (ArrayList)this.mMovesList.get(var1);

            for(var2 = var7.size() - 1; var2 >= 0; --var2) {
               DefaultItemAnimator$MoveInfo var8 = (DefaultItemAnimator$MoveInfo)var7.get(var2);
               View var5 = var8.holder.itemView;
               ViewCompat.setTranslationY(var5, 0.0F);
               ViewCompat.setTranslationX(var5, 0.0F);
               this.dispatchMoveFinished(var8.holder);
               var7.remove(var2);
               if(var7.isEmpty()) {
                  this.mMovesList.remove(var7);
               }
            }
         }

         for(var1 = this.mAdditionsList.size() - 1; var1 >= 0; --var1) {
            var7 = (ArrayList)this.mAdditionsList.get(var1);

            for(var2 = var7.size() - 1; var2 >= 0; --var2) {
               RecyclerView$ViewHolder var9 = (RecyclerView$ViewHolder)var7.get(var2);
               ViewCompat.setAlpha(var9.itemView, 1.0F);
               this.dispatchAddFinished(var9);
               var7.remove(var2);
               if(var7.isEmpty()) {
                  this.mAdditionsList.remove(var7);
               }
            }
         }

         for(var1 = this.mChangesList.size() - 1; var1 >= 0; --var1) {
            var7 = (ArrayList)this.mChangesList.get(var1);

            for(var2 = var7.size() - 1; var2 >= 0; --var2) {
               this.endChangeAnimationIfNecessary((DefaultItemAnimator$ChangeInfo)var7.get(var2));
               if(var7.isEmpty()) {
                  this.mChangesList.remove(var7);
               }
            }
         }

         this.cancelAll(this.mRemoveAnimations);
         this.cancelAll(this.mMoveAnimations);
         this.cancelAll(this.mAddAnimations);
         this.cancelAll(this.mChangeAnimations);
         this.dispatchAnimationsFinished();
      }
   }

   public boolean isRunning() {
      return !this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty();
   }

   public void runPendingAnimations() {
      boolean var1;
      if(!this.mPendingRemovals.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var2;
      if(!this.mPendingMoves.isEmpty()) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if(!this.mPendingChanges.isEmpty()) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4;
      if(!this.mPendingAdditions.isEmpty()) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(var1 || var2 || var4 || var3) {
         Iterator var11 = this.mPendingRemovals.iterator();

         while(var11.hasNext()) {
            this.animateRemoveImpl((RecyclerView$ViewHolder)var11.next());
         }

         this.mPendingRemovals.clear();
         ArrayList var13;
         if(var2) {
            var13 = new ArrayList();
            var13.addAll(this.mPendingMoves);
            this.mMovesList.add(var13);
            this.mPendingMoves.clear();
            DefaultItemAnimator$1 var12 = new DefaultItemAnimator$1(this, var13);
            if(var1) {
               ViewCompat.postOnAnimationDelayed(((DefaultItemAnimator$MoveInfo)var13.get(0)).holder.itemView, var12, this.getRemoveDuration());
            } else {
               var12.run();
            }
         }

         if(var3) {
            var13 = new ArrayList();
            var13.addAll(this.mPendingChanges);
            this.mChangesList.add(var13);
            this.mPendingChanges.clear();
            DefaultItemAnimator$2 var14 = new DefaultItemAnimator$2(this, var13);
            if(var1) {
               ViewCompat.postOnAnimationDelayed(((DefaultItemAnimator$ChangeInfo)var13.get(0)).oldHolder.itemView, var14, this.getRemoveDuration());
            } else {
               var14.run();
            }
         }

         if(var4) {
            var13 = new ArrayList();
            var13.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(var13);
            this.mPendingAdditions.clear();
            DefaultItemAnimator$3 var15 = new DefaultItemAnimator$3(this, var13);
            if(!var1 && !var2 && !var3) {
               var15.run();
               return;
            }

            long var5;
            if(var1) {
               var5 = this.getRemoveDuration();
            } else {
               var5 = 0L;
            }

            long var7;
            if(var2) {
               var7 = this.getMoveDuration();
            } else {
               var7 = 0L;
            }

            long var9;
            if(var3) {
               var9 = this.getChangeDuration();
            } else {
               var9 = 0L;
            }

            var7 = Math.max(var7, var9);
            ViewCompat.postOnAnimationDelayed(((RecyclerView$ViewHolder)var13.get(0)).itemView, var15, var5 + var7);
            return;
         }
      }

   }
}
