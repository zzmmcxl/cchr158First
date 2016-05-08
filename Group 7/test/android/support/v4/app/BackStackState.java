package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.BackStackRecord;
import android.support.v4.app.BackStackRecord$Op;
import android.support.v4.app.BackStackState$1;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerImpl;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
   public static final Creator<BackStackState> CREATOR = new BackStackState$1();
   final int mBreadCrumbShortTitleRes;
   final CharSequence mBreadCrumbShortTitleText;
   final int mBreadCrumbTitleRes;
   final CharSequence mBreadCrumbTitleText;
   final int mIndex;
   final String mName;
   final int[] mOps;
   final ArrayList<String> mSharedElementSourceNames;
   final ArrayList<String> mSharedElementTargetNames;
   final int mTransition;
   final int mTransitionStyle;

   public BackStackState(Parcel var1) {
      this.mOps = var1.createIntArray();
      this.mTransition = var1.readInt();
      this.mTransitionStyle = var1.readInt();
      this.mName = var1.readString();
      this.mIndex = var1.readInt();
      this.mBreadCrumbTitleRes = var1.readInt();
      this.mBreadCrumbTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mBreadCrumbShortTitleRes = var1.readInt();
      this.mBreadCrumbShortTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mSharedElementSourceNames = var1.createStringArrayList();
      this.mSharedElementTargetNames = var1.createStringArrayList();
   }

   public BackStackState(BackStackRecord var1) {
      int var2 = 0;

      int var3;
      BackStackRecord$Op var6;
      for(var6 = var1.mHead; var6 != null; var2 = var3) {
         var3 = var2;
         if(var6.removed != null) {
            var3 = var2 + var6.removed.size();
         }

         var6 = var6.next;
      }

      this.mOps = new int[var1.mNumOp * 7 + var2];
      if(!var1.mAddToBackStack) {
         throw new IllegalStateException("Not on back stack");
      } else {
         var6 = var1.mHead;

         for(var2 = 0; var6 != null; var6 = var6.next) {
            int[] var7 = this.mOps;
            var3 = var2 + 1;
            var7[var2] = var6.cmd;
            var7 = this.mOps;
            int var4 = var3 + 1;
            if(var6.fragment != null) {
               var2 = var6.fragment.mIndex;
            } else {
               var2 = -1;
            }

            var7[var3] = var2;
            var7 = this.mOps;
            var2 = var4 + 1;
            var7[var4] = var6.enterAnim;
            var7 = this.mOps;
            var3 = var2 + 1;
            var7[var2] = var6.exitAnim;
            var7 = this.mOps;
            var2 = var3 + 1;
            var7[var3] = var6.popEnterAnim;
            var7 = this.mOps;
            int var5 = var2 + 1;
            var7[var2] = var6.popExitAnim;
            if(var6.removed != null) {
               var4 = var6.removed.size();
               this.mOps[var5] = var4;
               var3 = 0;

               for(var2 = var5 + 1; var3 < var4; ++var2) {
                  this.mOps[var2] = ((Fragment)var6.removed.get(var3)).mIndex;
                  ++var3;
               }
            } else {
               var7 = this.mOps;
               var2 = var5 + 1;
               var7[var5] = 0;
            }
         }

         this.mTransition = var1.mTransition;
         this.mTransitionStyle = var1.mTransitionStyle;
         this.mName = var1.mName;
         this.mIndex = var1.mIndex;
         this.mBreadCrumbTitleRes = var1.mBreadCrumbTitleRes;
         this.mBreadCrumbTitleText = var1.mBreadCrumbTitleText;
         this.mBreadCrumbShortTitleRes = var1.mBreadCrumbShortTitleRes;
         this.mBreadCrumbShortTitleText = var1.mBreadCrumbShortTitleText;
         this.mSharedElementSourceNames = var1.mSharedElementSourceNames;
         this.mSharedElementTargetNames = var1.mSharedElementTargetNames;
      }
   }

   public int describeContents() {
      return 0;
   }

   public BackStackRecord instantiate(FragmentManagerImpl var1) {
      BackStackRecord var7 = new BackStackRecord(var1);
      int var2 = 0;

      for(int var4 = 0; var2 < this.mOps.length; ++var4) {
         BackStackRecord$Op var8 = new BackStackRecord$Op();
         int[] var9 = this.mOps;
         int var3 = var2 + 1;
         var8.cmd = var9[var2];
         if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Instantiate " + var7 + " op #" + var4 + " base fragment #" + this.mOps[var3]);
         }

         var9 = this.mOps;
         var2 = var3 + 1;
         var3 = var9[var3];
         if(var3 >= 0) {
            var8.fragment = (Fragment)var1.mActive.get(var3);
         } else {
            var8.fragment = null;
         }

         var9 = this.mOps;
         var3 = var2 + 1;
         var8.enterAnim = var9[var2];
         var9 = this.mOps;
         var2 = var3 + 1;
         var8.exitAnim = var9[var3];
         var9 = this.mOps;
         var3 = var2 + 1;
         var8.popEnterAnim = var9[var2];
         var9 = this.mOps;
         int var5 = var3 + 1;
         var8.popExitAnim = var9[var3];
         var9 = this.mOps;
         var2 = var5 + 1;
         int var6 = var9[var5];
         var3 = var2;
         if(var6 > 0) {
            var8.removed = new ArrayList(var6);
            var5 = 0;

            while(true) {
               var3 = var2;
               if(var5 >= var6) {
                  break;
               }

               if(FragmentManagerImpl.DEBUG) {
                  Log.v("FragmentManager", "Instantiate " + var7 + " set remove fragment #" + this.mOps[var2]);
               }

               Fragment var10 = (Fragment)var1.mActive.get(this.mOps[var2]);
               var8.removed.add(var10);
               ++var5;
               ++var2;
            }
         }

         var2 = var3;
         var7.addOp(var8);
      }

      var7.mTransition = this.mTransition;
      var7.mTransitionStyle = this.mTransitionStyle;
      var7.mName = this.mName;
      var7.mIndex = this.mIndex;
      var7.mAddToBackStack = true;
      var7.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
      var7.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
      var7.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
      var7.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
      var7.mSharedElementSourceNames = this.mSharedElementSourceNames;
      var7.mSharedElementTargetNames = this.mSharedElementTargetNames;
      var7.bumpBackStackNesting(1);
      return var7;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeIntArray(this.mOps);
      var1.writeInt(this.mTransition);
      var1.writeInt(this.mTransitionStyle);
      var1.writeString(this.mName);
      var1.writeInt(this.mIndex);
      var1.writeInt(this.mBreadCrumbTitleRes);
      TextUtils.writeToParcel(this.mBreadCrumbTitleText, var1, 0);
      var1.writeInt(this.mBreadCrumbShortTitleRes);
      TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, var1, 0);
      var1.writeStringList(this.mSharedElementSourceNames);
      var1.writeStringList(this.mSharedElementTargetNames);
   }
}
