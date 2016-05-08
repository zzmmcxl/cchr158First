package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$Recycler;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerView$ViewHolder {
   static final int FLAG_ADAPTER_FULLUPDATE = 1024;
   static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
   static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
   static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
   static final int FLAG_BOUND = 1;
   static final int FLAG_IGNORE = 128;
   static final int FLAG_INVALID = 4;
   static final int FLAG_MOVED = 2048;
   static final int FLAG_NOT_RECYCLABLE = 16;
   static final int FLAG_REMOVED = 8;
   static final int FLAG_RETURNED_FROM_SCRAP = 32;
   static final int FLAG_TMP_DETACHED = 256;
   static final int FLAG_UPDATE = 2;
   private static final List<Object> FULLUPDATE_PAYLOADS;
   public final View itemView;
   private int mFlags;
   private boolean mInChangeScrap = false;
   private int mIsRecyclableCount = 0;
   long mItemId = -1L;
   int mItemViewType = -1;
   int mOldPosition = -1;
   RecyclerView mOwnerRecyclerView;
   List<Object> mPayloads = null;
   int mPosition = -1;
   int mPreLayoutPosition = -1;
   private RecyclerView$Recycler mScrapContainer = null;
   RecyclerView$ViewHolder mShadowedHolder = null;
   RecyclerView$ViewHolder mShadowingHolder = null;
   List<Object> mUnmodifiedPayloads = null;
   private int mWasImportantForAccessibilityBeforeHidden = 0;

   static {
      FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
   }

   public RecyclerView$ViewHolder(View var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("itemView may not be null");
      } else {
         this.itemView = var1;
      }
   }

   private void createPayloadsIfNeeded() {
      if(this.mPayloads == null) {
         this.mPayloads = new ArrayList();
         this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
      }

   }

   private boolean doesTransientStatePreventRecycling() {
      return (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
   }

   private void onEnteredHiddenState() {
      this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
      ViewCompat.setImportantForAccessibility(this.itemView, 4);
   }

   private void onLeftHiddenState() {
      ViewCompat.setImportantForAccessibility(this.itemView, this.mWasImportantForAccessibilityBeforeHidden);
      this.mWasImportantForAccessibilityBeforeHidden = 0;
   }

   private boolean shouldBeKeptAsChild() {
      return (this.mFlags & 16) != 0;
   }

   void addChangePayload(Object var1) {
      if(var1 == null) {
         this.addFlags(1024);
      } else if((this.mFlags & 1024) == 0) {
         this.createPayloadsIfNeeded();
         this.mPayloads.add(var1);
         return;
      }

   }

   void addFlags(int var1) {
      this.mFlags |= var1;
   }

   void clearOldPosition() {
      this.mOldPosition = -1;
      this.mPreLayoutPosition = -1;
   }

   void clearPayload() {
      if(this.mPayloads != null) {
         this.mPayloads.clear();
      }

      this.mFlags &= -1025;
   }

   void clearReturnedFromScrapFlag() {
      this.mFlags &= -33;
   }

   void clearTmpDetachFlag() {
      this.mFlags &= -257;
   }

   void flagRemovedAndOffsetPosition(int var1, int var2, boolean var3) {
      this.addFlags(8);
      this.offsetPosition(var2, var3);
      this.mPosition = var1;
   }

   public final int getAdapterPosition() {
      return this.mOwnerRecyclerView == null?-1:RecyclerView.access$5700(this.mOwnerRecyclerView, this);
   }

   public final long getItemId() {
      return this.mItemId;
   }

   public final int getItemViewType() {
      return this.mItemViewType;
   }

   public final int getLayoutPosition() {
      return this.mPreLayoutPosition == -1?this.mPosition:this.mPreLayoutPosition;
   }

   public final int getOldPosition() {
      return this.mOldPosition;
   }

   @Deprecated
   public final int getPosition() {
      return this.mPreLayoutPosition == -1?this.mPosition:this.mPreLayoutPosition;
   }

   List<Object> getUnmodifiedPayloads() {
      return (this.mFlags & 1024) == 0?(this.mPayloads != null && this.mPayloads.size() != 0?this.mUnmodifiedPayloads:FULLUPDATE_PAYLOADS):FULLUPDATE_PAYLOADS;
   }

   boolean hasAnyOfTheFlags(int var1) {
      return (this.mFlags & var1) != 0;
   }

   boolean isAdapterPositionUnknown() {
      return (this.mFlags & 512) != 0 || this.isInvalid();
   }

   boolean isBound() {
      return (this.mFlags & 1) != 0;
   }

   boolean isInvalid() {
      return (this.mFlags & 4) != 0;
   }

   public final boolean isRecyclable() {
      return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
   }

   boolean isRemoved() {
      return (this.mFlags & 8) != 0;
   }

   boolean isScrap() {
      return this.mScrapContainer != null;
   }

   boolean isTmpDetached() {
      return (this.mFlags & 256) != 0;
   }

   boolean isUpdated() {
      return (this.mFlags & 2) != 0;
   }

   boolean needsUpdate() {
      return (this.mFlags & 2) != 0;
   }

   void offsetPosition(int var1, boolean var2) {
      if(this.mOldPosition == -1) {
         this.mOldPosition = this.mPosition;
      }

      if(this.mPreLayoutPosition == -1) {
         this.mPreLayoutPosition = this.mPosition;
      }

      if(var2) {
         this.mPreLayoutPosition += var1;
      }

      this.mPosition += var1;
      if(this.itemView.getLayoutParams() != null) {
         ((RecyclerView$LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true;
      }

   }

   void resetInternal() {
      this.mFlags = 0;
      this.mPosition = -1;
      this.mOldPosition = -1;
      this.mItemId = -1L;
      this.mPreLayoutPosition = -1;
      this.mIsRecyclableCount = 0;
      this.mShadowedHolder = null;
      this.mShadowingHolder = null;
      this.clearPayload();
      this.mWasImportantForAccessibilityBeforeHidden = 0;
   }

   void saveOldPosition() {
      if(this.mOldPosition == -1) {
         this.mOldPosition = this.mPosition;
      }

   }

   void setFlags(int var1, int var2) {
      this.mFlags = this.mFlags & ~var2 | var1 & var2;
   }

   public final void setIsRecyclable(boolean var1) {
      int var2;
      if(var1) {
         var2 = this.mIsRecyclableCount - 1;
      } else {
         var2 = this.mIsRecyclableCount + 1;
      }

      this.mIsRecyclableCount = var2;
      if(this.mIsRecyclableCount < 0) {
         this.mIsRecyclableCount = 0;
         Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
      } else {
         if(!var1 && this.mIsRecyclableCount == 1) {
            this.mFlags |= 16;
            return;
         }

         if(var1 && this.mIsRecyclableCount == 0) {
            this.mFlags &= -17;
            return;
         }
      }

   }

   void setScrapContainer(RecyclerView$Recycler var1, boolean var2) {
      this.mScrapContainer = var1;
      this.mInChangeScrap = var2;
   }

   boolean shouldIgnore() {
      return (this.mFlags & 128) != 0;
   }

   void stopIgnoring() {
      this.mFlags &= -129;
   }

   public String toString() {
      StringBuilder var2 = new StringBuilder("ViewHolder{" + Integer.toHexString(this.hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
      if(this.isScrap()) {
         StringBuilder var3 = var2.append(" scrap ");
         String var1;
         if(this.mInChangeScrap) {
            var1 = "[changeScrap]";
         } else {
            var1 = "[attachedScrap]";
         }

         var3.append(var1);
      }

      if(this.isInvalid()) {
         var2.append(" invalid");
      }

      if(!this.isBound()) {
         var2.append(" unbound");
      }

      if(this.needsUpdate()) {
         var2.append(" update");
      }

      if(this.isRemoved()) {
         var2.append(" removed");
      }

      if(this.shouldIgnore()) {
         var2.append(" ignored");
      }

      if(this.isTmpDetached()) {
         var2.append(" tmpDetached");
      }

      if(!this.isRecyclable()) {
         var2.append(" not recyclable(" + this.mIsRecyclableCount + ")");
      }

      if(this.isAdapterPositionUnknown()) {
         var2.append(" undefined adapter position");
      }

      if(this.itemView.getParent() == null) {
         var2.append(" no parent");
      }

      var2.append("}");
      return var2.toString();
   }

   void unScrap() {
      this.mScrapContainer.unscrapView(this);
   }

   boolean wasReturnedFromScrap() {
      return (this.mFlags & 32) != 0;
   }
}
