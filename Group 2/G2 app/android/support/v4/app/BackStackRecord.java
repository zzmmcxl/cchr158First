package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransitionCompat21;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
   static final int OP_ADD = 1;
   static final int OP_ATTACH = 7;
   static final int OP_DETACH = 6;
   static final int OP_HIDE = 4;
   static final int OP_NULL = 0;
   static final int OP_REMOVE = 3;
   static final int OP_REPLACE = 2;
   static final int OP_SHOW = 5;
   static final boolean SUPPORTS_TRANSITIONS;
   static final String TAG = "FragmentManager";
   boolean mAddToBackStack;
   boolean mAllowAddToBackStack = true;
   int mBreadCrumbShortTitleRes;
   CharSequence mBreadCrumbShortTitleText;
   int mBreadCrumbTitleRes;
   CharSequence mBreadCrumbTitleText;
   boolean mCommitted;
   int mEnterAnim;
   int mExitAnim;
   BackStackRecord.Op mHead;
   int mIndex = -1;
   final FragmentManagerImpl mManager;
   String mName;
   int mNumOp;
   int mPopEnterAnim;
   int mPopExitAnim;
   ArrayList mSharedElementSourceNames;
   ArrayList mSharedElementTargetNames;
   BackStackRecord.Op mTail;
   int mTransition;
   int mTransitionStyle;

   static {
      boolean var0;
      if(VERSION.SDK_INT >= 21) {
         var0 = true;
      } else {
         var0 = false;
      }

      SUPPORTS_TRANSITIONS = var0;
   }

   public BackStackRecord(FragmentManagerImpl var1) {
      this.mManager = var1;
   }

   private BackStackRecord.TransitionState beginTransition(SparseArray var1, SparseArray var2, boolean var3) {
      BackStackRecord.TransitionState var8 = new BackStackRecord.TransitionState();
      var8.nonExistentView = new View(this.mManager.mActivity);
      boolean var4 = false;

      int var5;
      for(var5 = 0; var5 < var1.size(); ++var5) {
         if(this.configureTransitions(var1.keyAt(var5), var8, var3, var1, var2)) {
            var4 = true;
         }
      }

      boolean var6;
      for(var5 = 0; var5 < var2.size(); var4 = var6) {
         int var7 = var2.keyAt(var5);
         var6 = var4;
         if(var1.get(var7) == null) {
            var6 = var4;
            if(this.configureTransitions(var7, var8, var3, var1, var2)) {
               var6 = true;
            }
         }

         ++var5;
      }

      BackStackRecord.TransitionState var9 = var8;
      if(!var4) {
         var9 = null;
      }

      return var9;
   }

   private void calculateFragments(SparseArray var1, SparseArray var2) {
      if(this.mManager.mContainer.hasView()) {
         for(BackStackRecord.Op var5 = this.mHead; var5 != null; var5 = var5.next) {
            switch(var5.cmd) {
            case 1:
               this.setLastIn(var2, var5.fragment);
               break;
            case 2:
               Fragment var4 = var5.fragment;
               Fragment var6 = var4;
               if(this.mManager.mAdded != null) {
                  int var3 = 0;

                  while(true) {
                     var6 = var4;
                     if(var3 >= this.mManager.mAdded.size()) {
                        break;
                     }

                     label41: {
                        Fragment var7 = (Fragment)this.mManager.mAdded.get(var3);
                        if(var4 != null) {
                           var6 = var4;
                           if(var7.mContainerId != var4.mContainerId) {
                              break label41;
                           }
                        }

                        if(var7 == var4) {
                           var6 = null;
                        } else {
                           setFirstOut(var1, var7);
                           var6 = var4;
                        }
                     }

                     ++var3;
                     var4 = var6;
                  }
               }

               this.setLastIn(var2, var6);
               break;
            case 3:
               setFirstOut(var1, var5.fragment);
               break;
            case 4:
               setFirstOut(var1, var5.fragment);
               break;
            case 5:
               this.setLastIn(var2, var5.fragment);
               break;
            case 6:
               setFirstOut(var1, var5.fragment);
               break;
            case 7:
               this.setLastIn(var2, var5.fragment);
            }
         }
      }

   }

   private void callSharedElementEnd(BackStackRecord.TransitionState var1, Fragment var2, Fragment var3, boolean var4, ArrayMap var5) {
      SharedElementCallback var6;
      if(var4) {
         var6 = var3.mEnterTransitionCallback;
      } else {
         var6 = var2.mEnterTransitionCallback;
      }

      if(var6 != null) {
         var6.onSharedElementEnd(new ArrayList(var5.keySet()), new ArrayList(var5.values()), (List)null);
      }

   }

   private static Object captureExitingViews(Object var0, Fragment var1, ArrayList var2, ArrayMap var3, View var4) {
      Object var5 = var0;
      if(var0 != null) {
         var5 = FragmentTransitionCompat21.captureExitingViews(var0, var1.getView(), var2, var3, var4);
      }

      return var5;
   }

   private boolean configureTransitions(int var1, BackStackRecord.TransitionState var2, boolean var3, SparseArray var4, SparseArray var5) {
      ViewGroup var7 = (ViewGroup)this.mManager.mContainer.findViewById(var1);
      if(var7 == null) {
         return false;
      } else {
         final Fragment var8 = (Fragment)var5.get(var1);
         Fragment var12 = (Fragment)var4.get(var1);
         Object var9 = getEnterTransition(var8, var3);
         Object var10 = getSharedElementTransition(var8, var12, var3);
         Object var13 = getExitTransition(var12, var3);
         if(var9 == null && var10 == null && var13 == null) {
            return false;
         } else {
            ArrayMap var14 = null;
            ArrayList var11 = new ArrayList();
            if(var10 != null) {
               ArrayMap var6 = this.remapSharedElements(var2, var12, var3);
               var11.add(var2.nonExistentView);
               var11.addAll(var6.values());
               SharedElementCallback var15;
               if(var3) {
                  var15 = var12.mEnterTransitionCallback;
               } else {
                  var15 = var8.mEnterTransitionCallback;
               }

               var14 = var6;
               if(var15 != null) {
                  var15.onSharedElementStart(new ArrayList(var6.keySet()), new ArrayList(var6.values()), (List)null);
                  var14 = var6;
               }
            }

            ArrayList var18 = new ArrayList();
            Object var19 = captureExitingViews(var13, var12, var18, var14, var2.nonExistentView);
            if(this.mSharedElementTargetNames != null && var14 != null) {
               View var16 = (View)var14.get(this.mSharedElementTargetNames.get(0));
               if(var16 != null) {
                  if(var19 != null) {
                     FragmentTransitionCompat21.setEpicenter(var19, var16);
                  }

                  if(var10 != null) {
                     FragmentTransitionCompat21.setEpicenter(var10, var16);
                  }
               }
            }

            FragmentTransitionCompat21.ViewRetriever var17 = new FragmentTransitionCompat21.ViewRetriever() {
               public View getView() {
                  return var8.getView();
               }
            };
            if(var10 != null) {
               this.prepareSharedElementTransition(var2, var7, var10, var8, var12, var3, var11);
            }

            ArrayList var21 = new ArrayList();
            ArrayMap var22 = new ArrayMap();
            if(var3) {
               var3 = var8.getAllowReturnTransitionOverlap();
            } else {
               var3 = var8.getAllowEnterTransitionOverlap();
            }

            Object var20 = FragmentTransitionCompat21.mergeTransitions(var9, var19, var10, var3);
            if(var20 != null) {
               FragmentTransitionCompat21.addTransitionTargets(var9, var10, var7, var17, var2.nonExistentView, var2.enteringEpicenterView, var2.nameOverrides, var21, var22, var11);
               this.excludeHiddenFragmentsAfterEnter(var7, var2, var1, var20);
               FragmentTransitionCompat21.excludeTarget(var20, var2.nonExistentView, true);
               this.excludeHiddenFragments(var2, var1, var20);
               FragmentTransitionCompat21.beginDelayedTransition(var7, var20);
               FragmentTransitionCompat21.cleanupTransitions(var7, var2.nonExistentView, var9, var21, var19, var18, var10, var11, var20, var2.hiddenFragmentViews, var22);
            }

            return var20 != null;
         }
      }
   }

   private void doAddOp(int var1, Fragment var2, String var3, int var4) {
      var2.mFragmentManager = this.mManager;
      if(var3 != null) {
         if(var2.mTag != null && !var3.equals(var2.mTag)) {
            throw new IllegalStateException("Can\'t change tag of fragment " + var2 + ": was " + var2.mTag + " now " + var3);
         }

         var2.mTag = var3;
      }

      if(var1 != 0) {
         if(var2.mFragmentId != 0 && var2.mFragmentId != var1) {
            throw new IllegalStateException("Can\'t change container ID of fragment " + var2 + ": was " + var2.mFragmentId + " now " + var1);
         }

         var2.mFragmentId = var1;
         var2.mContainerId = var1;
      }

      BackStackRecord.Op var5 = new BackStackRecord.Op();
      var5.cmd = var4;
      var5.fragment = var2;
      this.addOp(var5);
   }

   private void excludeHiddenFragments(BackStackRecord.TransitionState var1, int var2, Object var3) {
      if(this.mManager.mAdded != null) {
         for(int var4 = 0; var4 < this.mManager.mAdded.size(); ++var4) {
            Fragment var5 = (Fragment)this.mManager.mAdded.get(var4);
            if(var5.mView != null && var5.mContainer != null && var5.mContainerId == var2) {
               if(var5.mHidden) {
                  if(!var1.hiddenFragmentViews.contains(var5.mView)) {
                     FragmentTransitionCompat21.excludeTarget(var3, var5.mView, true);
                     var1.hiddenFragmentViews.add(var5.mView);
                  }
               } else {
                  FragmentTransitionCompat21.excludeTarget(var3, var5.mView, false);
                  var1.hiddenFragmentViews.remove(var5.mView);
               }
            }
         }
      }

   }

   private void excludeHiddenFragmentsAfterEnter(final View var1, final BackStackRecord.TransitionState var2, final int var3, final Object var4) {
      var1.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
         public boolean onPreDraw() {
            var1.getViewTreeObserver().removeOnPreDrawListener(this);
            BackStackRecord.this.excludeHiddenFragments(var2, var3, var4);
            return true;
         }
      });
   }

   private static Object getEnterTransition(Fragment var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         Object var2;
         if(var1) {
            var2 = var0.getReenterTransition();
         } else {
            var2 = var0.getEnterTransition();
         }

         return FragmentTransitionCompat21.cloneTransition(var2);
      }
   }

   private static Object getExitTransition(Fragment var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         Object var2;
         if(var1) {
            var2 = var0.getReturnTransition();
         } else {
            var2 = var0.getExitTransition();
         }

         return FragmentTransitionCompat21.cloneTransition(var2);
      }
   }

   private static Object getSharedElementTransition(Fragment var0, Fragment var1, boolean var2) {
      if(var0 != null && var1 != null) {
         Object var3;
         if(var2) {
            var3 = var1.getSharedElementReturnTransition();
         } else {
            var3 = var0.getSharedElementEnterTransition();
         }

         return FragmentTransitionCompat21.cloneTransition(var3);
      } else {
         return null;
      }
   }

   private ArrayMap mapEnteringSharedElements(BackStackRecord.TransitionState var1, Fragment var2, boolean var3) {
      ArrayMap var4 = new ArrayMap();
      View var6 = var2.getView();
      ArrayMap var5 = var4;
      if(var6 != null) {
         var5 = var4;
         if(this.mSharedElementSourceNames != null) {
            FragmentTransitionCompat21.findNamedViews(var4, var6);
            if(!var3) {
               var4.retainAll(this.mSharedElementTargetNames);
               return var4;
            }

            var5 = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, var4);
         }
      }

      return var5;
   }

   private ArrayMap mapSharedElementsIn(BackStackRecord.TransitionState var1, boolean var2, Fragment var3) {
      ArrayMap var4 = this.mapEnteringSharedElements(var1, var3, var2);
      if(var2) {
         if(var3.mExitTransitionCallback != null) {
            var3.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, var4);
         }

         this.setBackNameOverrides(var1, var4, true);
         return var4;
      } else {
         if(var3.mEnterTransitionCallback != null) {
            var3.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, var4);
         }

         this.setNameOverrides(var1, var4, true);
         return var4;
      }
   }

   private void prepareSharedElementTransition(final BackStackRecord.TransitionState var1, final View var2, final Object var3, final Fragment var4, final Fragment var5, final boolean var6, final ArrayList var7) {
      var2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
         public boolean onPreDraw() {
            var2.getViewTreeObserver().removeOnPreDrawListener(this);
            if(var3 != null) {
               FragmentTransitionCompat21.removeTargets(var3, var7);
               var7.clear();
               ArrayMap var1x = BackStackRecord.this.mapSharedElementsIn(var1, var6, var4);
               var7.add(var1.nonExistentView);
               var7.addAll(var1x.values());
               FragmentTransitionCompat21.addTargets(var3, var7);
               BackStackRecord.this.setEpicenterIn(var1x, var1);
               BackStackRecord.this.callSharedElementEnd(var1, var4, var5, var6, var1x);
            }

            return true;
         }
      });
   }

   private static ArrayMap remapNames(ArrayList var0, ArrayList var1, ArrayMap var2) {
      if(var2.isEmpty()) {
         return var2;
      } else {
         ArrayMap var5 = new ArrayMap();
         int var4 = var0.size();

         for(int var3 = 0; var3 < var4; ++var3) {
            View var6 = (View)var2.get(var0.get(var3));
            if(var6 != null) {
               var5.put(var1.get(var3), var6);
            }
         }

         return var5;
      }
   }

   private ArrayMap remapSharedElements(BackStackRecord.TransitionState var1, Fragment var2, boolean var3) {
      ArrayMap var5 = new ArrayMap();
      ArrayMap var4 = var5;
      if(this.mSharedElementSourceNames != null) {
         FragmentTransitionCompat21.findNamedViews(var5, var2.getView());
         if(var3) {
            var5.retainAll(this.mSharedElementTargetNames);
            var4 = var5;
         } else {
            var4 = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, var5);
         }
      }

      if(var3) {
         if(var2.mEnterTransitionCallback != null) {
            var2.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, var4);
         }

         this.setBackNameOverrides(var1, var4, false);
         return var4;
      } else {
         if(var2.mExitTransitionCallback != null) {
            var2.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, var4);
         }

         this.setNameOverrides(var1, var4, false);
         return var4;
      }
   }

   private void setBackNameOverrides(BackStackRecord.TransitionState var1, ArrayMap var2, boolean var3) {
      int var4;
      if(this.mSharedElementTargetNames == null) {
         var4 = 0;
      } else {
         var4 = this.mSharedElementTargetNames.size();
      }

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = (String)this.mSharedElementSourceNames.get(var5);
         View var7 = (View)var2.get((String)this.mSharedElementTargetNames.get(var5));
         if(var7 != null) {
            String var8 = FragmentTransitionCompat21.getTransitionName(var7);
            if(var3) {
               setNameOverride(var1.nameOverrides, var6, var8);
            } else {
               setNameOverride(var1.nameOverrides, var8, var6);
            }
         }
      }

   }

   private void setEpicenterIn(ArrayMap var1, BackStackRecord.TransitionState var2) {
      if(this.mSharedElementTargetNames != null && !var1.isEmpty()) {
         View var3 = (View)var1.get(this.mSharedElementTargetNames.get(0));
         if(var3 != null) {
            var2.enteringEpicenterView.epicenter = var3;
         }
      }

   }

   private static void setFirstOut(SparseArray var0, Fragment var1) {
      if(var1 != null) {
         int var2 = var1.mContainerId;
         if(var2 != 0 && !var1.isHidden() && var1.isAdded() && var1.getView() != null && var0.get(var2) == null) {
            var0.put(var2, var1);
         }
      }

   }

   private void setLastIn(SparseArray var1, Fragment var2) {
      if(var2 != null) {
         int var3 = var2.mContainerId;
         if(var3 != 0) {
            var1.put(var3, var2);
         }
      }

   }

   private static void setNameOverride(ArrayMap var0, String var1, String var2) {
      if(var1 != null && var2 != null && !var1.equals(var2)) {
         int var3 = 0;

         while(true) {
            if(var3 >= var0.size()) {
               var0.put(var1, var2);
               return;
            }

            if(var1.equals(var0.valueAt(var3))) {
               var0.setValueAt(var3, var2);
               break;
            }

            ++var3;
         }
      }

   }

   private void setNameOverrides(BackStackRecord.TransitionState var1, ArrayMap var2, boolean var3) {
      int var5 = var2.size();

      for(int var4 = 0; var4 < var5; ++var4) {
         String var6 = (String)var2.keyAt(var4);
         String var7 = FragmentTransitionCompat21.getTransitionName((View)var2.valueAt(var4));
         if(var3) {
            setNameOverride(var1.nameOverrides, var6, var7);
         } else {
            setNameOverride(var1.nameOverrides, var7, var6);
         }
      }

   }

   private static void setNameOverrides(BackStackRecord.TransitionState var0, ArrayList var1, ArrayList var2) {
      if(var1 != null) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            String var4 = (String)var1.get(var3);
            String var5 = (String)var2.get(var3);
            setNameOverride(var0.nameOverrides, var4, var5);
         }
      }

   }

   public FragmentTransaction add(int var1, Fragment var2) {
      this.doAddOp(var1, var2, (String)null, 1);
      return this;
   }

   public FragmentTransaction add(int var1, Fragment var2, String var3) {
      this.doAddOp(var1, var2, var3, 1);
      return this;
   }

   public FragmentTransaction add(Fragment var1, String var2) {
      this.doAddOp(0, var1, var2, 1);
      return this;
   }

   void addOp(BackStackRecord.Op var1) {
      if(this.mHead == null) {
         this.mTail = var1;
         this.mHead = var1;
      } else {
         var1.prev = this.mTail;
         this.mTail.next = var1;
         this.mTail = var1;
      }

      var1.enterAnim = this.mEnterAnim;
      var1.exitAnim = this.mExitAnim;
      var1.popEnterAnim = this.mPopEnterAnim;
      var1.popExitAnim = this.mPopExitAnim;
      ++this.mNumOp;
   }

   public FragmentTransaction addSharedElement(View var1, String var2) {
      if(SUPPORTS_TRANSITIONS) {
         String var3 = FragmentTransitionCompat21.getTransitionName(var1);
         if(var3 == null) {
            throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
         }

         if(this.mSharedElementSourceNames == null) {
            this.mSharedElementSourceNames = new ArrayList();
            this.mSharedElementTargetNames = new ArrayList();
         }

         this.mSharedElementSourceNames.add(var3);
         this.mSharedElementTargetNames.add(var2);
      }

      return this;
   }

   public FragmentTransaction addToBackStack(String var1) {
      if(!this.mAllowAddToBackStack) {
         throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
      } else {
         this.mAddToBackStack = true;
         this.mName = var1;
         return this;
      }
   }

   public FragmentTransaction attach(Fragment var1) {
      BackStackRecord.Op var2 = new BackStackRecord.Op();
      var2.cmd = 7;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   void bumpBackStackNesting(int var1) {
      if(this.mAddToBackStack) {
         if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + var1);
         }

         for(BackStackRecord.Op var3 = this.mHead; var3 != null; var3 = var3.next) {
            Fragment var4;
            if(var3.fragment != null) {
               var4 = var3.fragment;
               var4.mBackStackNesting += var1;
               if(FragmentManagerImpl.DEBUG) {
                  Log.v("FragmentManager", "Bump nesting of " + var3.fragment + " to " + var3.fragment.mBackStackNesting);
               }
            }

            if(var3.removed != null) {
               for(int var2 = var3.removed.size() - 1; var2 >= 0; --var2) {
                  var4 = (Fragment)var3.removed.get(var2);
                  var4.mBackStackNesting += var1;
                  if(FragmentManagerImpl.DEBUG) {
                     Log.v("FragmentManager", "Bump nesting of " + var4 + " to " + var4.mBackStackNesting);
                  }
               }
            }
         }
      }

   }

   public void calculateBackFragments(SparseArray var1, SparseArray var2) {
      if(this.mManager.mContainer.hasView()) {
         for(BackStackRecord.Op var4 = this.mHead; var4 != null; var4 = var4.next) {
            switch(var4.cmd) {
            case 1:
               setFirstOut(var1, var4.fragment);
               break;
            case 2:
               if(var4.removed != null) {
                  for(int var3 = var4.removed.size() - 1; var3 >= 0; --var3) {
                     this.setLastIn(var2, (Fragment)var4.removed.get(var3));
                  }
               }

               setFirstOut(var1, var4.fragment);
               break;
            case 3:
               this.setLastIn(var2, var4.fragment);
               break;
            case 4:
               this.setLastIn(var2, var4.fragment);
               break;
            case 5:
               setFirstOut(var1, var4.fragment);
               break;
            case 6:
               this.setLastIn(var2, var4.fragment);
               break;
            case 7:
               setFirstOut(var1, var4.fragment);
            }
         }
      }

   }

   public int commit() {
      return this.commitInternal(false);
   }

   public int commitAllowingStateLoss() {
      return this.commitInternal(true);
   }

   int commitInternal(boolean var1) {
      if(this.mCommitted) {
         throw new IllegalStateException("commit already called");
      } else {
         if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Commit: " + this);
            this.dump("  ", (FileDescriptor)null, new PrintWriter(new LogWriter("FragmentManager")), (String[])null);
         }

         this.mCommitted = true;
         if(this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
         } else {
            this.mIndex = -1;
         }

         this.mManager.enqueueAction(this, var1);
         return this.mIndex;
      }
   }

   public FragmentTransaction detach(Fragment var1) {
      BackStackRecord.Op var2 = new BackStackRecord.Op();
      var2.cmd = 6;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   public FragmentTransaction disallowAddToBackStack() {
      if(this.mAddToBackStack) {
         throw new IllegalStateException("This transaction is already being added to the back stack");
      } else {
         this.mAllowAddToBackStack = false;
         return this;
      }
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      this.dump(var1, var3, true);
   }

   public void dump(String var1, PrintWriter var2, boolean var3) {
      if(var3) {
         var2.print(var1);
         var2.print("mName=");
         var2.print(this.mName);
         var2.print(" mIndex=");
         var2.print(this.mIndex);
         var2.print(" mCommitted=");
         var2.println(this.mCommitted);
         if(this.mTransition != 0) {
            var2.print(var1);
            var2.print("mTransition=#");
            var2.print(Integer.toHexString(this.mTransition));
            var2.print(" mTransitionStyle=#");
            var2.println(Integer.toHexString(this.mTransitionStyle));
         }

         if(this.mEnterAnim != 0 || this.mExitAnim != 0) {
            var2.print(var1);
            var2.print("mEnterAnim=#");
            var2.print(Integer.toHexString(this.mEnterAnim));
            var2.print(" mExitAnim=#");
            var2.println(Integer.toHexString(this.mExitAnim));
         }

         if(this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
            var2.print(var1);
            var2.print("mPopEnterAnim=#");
            var2.print(Integer.toHexString(this.mPopEnterAnim));
            var2.print(" mPopExitAnim=#");
            var2.println(Integer.toHexString(this.mPopExitAnim));
         }

         if(this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
            var2.print(var1);
            var2.print("mBreadCrumbTitleRes=#");
            var2.print(Integer.toHexString(this.mBreadCrumbTitleRes));
            var2.print(" mBreadCrumbTitleText=");
            var2.println(this.mBreadCrumbTitleText);
         }

         if(this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
            var2.print(var1);
            var2.print("mBreadCrumbShortTitleRes=#");
            var2.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
            var2.print(" mBreadCrumbShortTitleText=");
            var2.println(this.mBreadCrumbShortTitleText);
         }
      }

      if(this.mHead != null) {
         var2.print(var1);
         var2.println("Operations:");
         String var8 = var1 + "    ";
         BackStackRecord.Op var7 = this.mHead;

         for(int var4 = 0; var7 != null; ++var4) {
            String var6;
            switch(var7.cmd) {
            case 0:
               var6 = "NULL";
               break;
            case 1:
               var6 = "ADD";
               break;
            case 2:
               var6 = "REPLACE";
               break;
            case 3:
               var6 = "REMOVE";
               break;
            case 4:
               var6 = "HIDE";
               break;
            case 5:
               var6 = "SHOW";
               break;
            case 6:
               var6 = "DETACH";
               break;
            case 7:
               var6 = "ATTACH";
               break;
            default:
               var6 = "cmd=" + var7.cmd;
            }

            var2.print(var1);
            var2.print("  Op #");
            var2.print(var4);
            var2.print(": ");
            var2.print(var6);
            var2.print(" ");
            var2.println(var7.fragment);
            if(var3) {
               if(var7.enterAnim != 0 || var7.exitAnim != 0) {
                  var2.print(var1);
                  var2.print("enterAnim=#");
                  var2.print(Integer.toHexString(var7.enterAnim));
                  var2.print(" exitAnim=#");
                  var2.println(Integer.toHexString(var7.exitAnim));
               }

               if(var7.popEnterAnim != 0 || var7.popExitAnim != 0) {
                  var2.print(var1);
                  var2.print("popEnterAnim=#");
                  var2.print(Integer.toHexString(var7.popEnterAnim));
                  var2.print(" popExitAnim=#");
                  var2.println(Integer.toHexString(var7.popExitAnim));
               }
            }

            if(var7.removed != null && var7.removed.size() > 0) {
               for(int var5 = 0; var5 < var7.removed.size(); ++var5) {
                  var2.print(var8);
                  if(var7.removed.size() == 1) {
                     var2.print("Removed: ");
                  } else {
                     if(var5 == 0) {
                        var2.println("Removed:");
                     }

                     var2.print(var8);
                     var2.print("  #");
                     var2.print(var5);
                     var2.print(": ");
                  }

                  var2.println(var7.removed.get(var5));
               }
            }

            var7 = var7.next;
         }
      }

   }

   public CharSequence getBreadCrumbShortTitle() {
      return this.mBreadCrumbShortTitleRes != 0?this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes):this.mBreadCrumbShortTitleText;
   }

   public int getBreadCrumbShortTitleRes() {
      return this.mBreadCrumbShortTitleRes;
   }

   public CharSequence getBreadCrumbTitle() {
      return this.mBreadCrumbTitleRes != 0?this.mManager.mActivity.getText(this.mBreadCrumbTitleRes):this.mBreadCrumbTitleText;
   }

   public int getBreadCrumbTitleRes() {
      return this.mBreadCrumbTitleRes;
   }

   public int getId() {
      return this.mIndex;
   }

   public String getName() {
      return this.mName;
   }

   public int getTransition() {
      return this.mTransition;
   }

   public int getTransitionStyle() {
      return this.mTransitionStyle;
   }

   public FragmentTransaction hide(Fragment var1) {
      BackStackRecord.Op var2 = new BackStackRecord.Op();
      var2.cmd = 4;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   public boolean isAddToBackStackAllowed() {
      return this.mAllowAddToBackStack;
   }

   public boolean isEmpty() {
      return this.mNumOp == 0;
   }

   public BackStackRecord.TransitionState popFromBackStack(boolean var1, BackStackRecord.TransitionState var2, SparseArray var3, SparseArray var4) {
      if(FragmentManagerImpl.DEBUG) {
         Log.v("FragmentManager", "popFromBackStack: " + this);
         this.dump("  ", (FileDescriptor)null, new PrintWriter(new LogWriter("FragmentManager")), (String[])null);
      }

      BackStackRecord.TransitionState var9 = var2;
      if(SUPPORTS_TRANSITIONS) {
         if(var2 == null) {
            label82: {
               if(var3.size() == 0) {
                  var9 = var2;
                  if(var4.size() == 0) {
                     break label82;
                  }
               }

               var9 = this.beginTransition(var3, var4, true);
            }
         } else {
            var9 = var2;
            if(!var1) {
               setNameOverrides(var2, this.mSharedElementTargetNames, this.mSharedElementSourceNames);
               var9 = var2;
            }
         }
      }

      this.bumpBackStackNesting(-1);
      int var5;
      if(var9 != null) {
         var5 = 0;
      } else {
         var5 = this.mTransitionStyle;
      }

      int var6;
      if(var9 != null) {
         var6 = 0;
      } else {
         var6 = this.mTransition;
      }

      for(BackStackRecord.Op var10 = this.mTail; var10 != null; var10 = var10.prev) {
         int var7;
         if(var9 != null) {
            var7 = 0;
         } else {
            var7 = var10.popEnterAnim;
         }

         int var8;
         if(var9 != null) {
            var8 = 0;
         } else {
            var8 = var10.popExitAnim;
         }

         Fragment var11;
         switch(var10.cmd) {
         case 1:
            var11 = var10.fragment;
            var11.mNextAnim = var8;
            this.mManager.removeFragment(var11, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         case 2:
            var11 = var10.fragment;
            if(var11 != null) {
               var11.mNextAnim = var8;
               this.mManager.removeFragment(var11, FragmentManagerImpl.reverseTransit(var6), var5);
            }

            if(var10.removed != null) {
               for(var8 = 0; var8 < var10.removed.size(); ++var8) {
                  var11 = (Fragment)var10.removed.get(var8);
                  var11.mNextAnim = var7;
                  this.mManager.addFragment(var11, false);
               }
            }
            break;
         case 3:
            var11 = var10.fragment;
            var11.mNextAnim = var7;
            this.mManager.addFragment(var11, false);
            break;
         case 4:
            var11 = var10.fragment;
            var11.mNextAnim = var7;
            this.mManager.showFragment(var11, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         case 5:
            var11 = var10.fragment;
            var11.mNextAnim = var8;
            this.mManager.hideFragment(var11, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         case 6:
            var11 = var10.fragment;
            var11.mNextAnim = var7;
            this.mManager.attachFragment(var11, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         case 7:
            var11 = var10.fragment;
            var11.mNextAnim = var7;
            this.mManager.detachFragment(var11, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         default:
            throw new IllegalArgumentException("Unknown cmd: " + var10.cmd);
         }
      }

      if(var1) {
         this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(var6), var5, true);
         var9 = null;
      }

      if(this.mIndex >= 0) {
         this.mManager.freeBackStackIndex(this.mIndex);
         this.mIndex = -1;
      }

      return var9;
   }

   public FragmentTransaction remove(Fragment var1) {
      BackStackRecord.Op var2 = new BackStackRecord.Op();
      var2.cmd = 3;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   public FragmentTransaction replace(int var1, Fragment var2) {
      return this.replace(var1, var2, (String)null);
   }

   public FragmentTransaction replace(int var1, Fragment var2, String var3) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Must use non-zero containerViewId");
      } else {
         this.doAddOp(var1, var2, var3, 2);
         return this;
      }
   }

   public void run() {
      if(FragmentManagerImpl.DEBUG) {
         Log.v("FragmentManager", "Run: " + this);
      }

      if(this.mAddToBackStack && this.mIndex < 0) {
         throw new IllegalStateException("addToBackStack() called after commit()");
      } else {
         this.bumpBackStackNesting(1);
         BackStackRecord.TransitionState var7 = null;
         if(SUPPORTS_TRANSITIONS) {
            SparseArray var6 = new SparseArray();
            SparseArray var12 = new SparseArray();
            this.calculateFragments(var6, var12);
            var7 = this.beginTransition(var6, var12, false);
         }

         int var1;
         if(var7 != null) {
            var1 = 0;
         } else {
            var1 = this.mTransitionStyle;
         }

         int var2;
         if(var7 != null) {
            var2 = 0;
         } else {
            var2 = this.mTransition;
         }

         for(BackStackRecord.Op var8 = this.mHead; var8 != null; var8 = var8.next) {
            int var3;
            if(var7 != null) {
               var3 = 0;
            } else {
               var3 = var8.enterAnim;
            }

            int var4;
            if(var7 != null) {
               var4 = 0;
            } else {
               var4 = var8.exitAnim;
            }

            Fragment var11;
            switch(var8.cmd) {
            case 1:
               var11 = var8.fragment;
               var11.mNextAnim = var3;
               this.mManager.addFragment(var11, false);
               break;
            case 2:
               var11 = var8.fragment;
               Fragment var9 = var11;
               if(this.mManager.mAdded != null) {
                  int var5 = 0;

                  while(true) {
                     var9 = var11;
                     if(var5 >= this.mManager.mAdded.size()) {
                        break;
                     }

                     Fragment var10 = (Fragment)this.mManager.mAdded.get(var5);
                     if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "OP_REPLACE: adding=" + var11 + " old=" + var10);
                     }

                     label90: {
                        if(var11 != null) {
                           var9 = var11;
                           if(var10.mContainerId != var11.mContainerId) {
                              break label90;
                           }
                        }

                        if(var10 == var11) {
                           var9 = null;
                           var8.fragment = null;
                        } else {
                           if(var8.removed == null) {
                              var8.removed = new ArrayList();
                           }

                           var8.removed.add(var10);
                           var10.mNextAnim = var4;
                           if(this.mAddToBackStack) {
                              ++var10.mBackStackNesting;
                              if(FragmentManagerImpl.DEBUG) {
                                 Log.v("FragmentManager", "Bump nesting of " + var10 + " to " + var10.mBackStackNesting);
                              }
                           }

                           this.mManager.removeFragment(var10, var2, var1);
                           var9 = var11;
                        }
                     }

                     ++var5;
                     var11 = var9;
                  }
               }

               if(var9 != null) {
                  var9.mNextAnim = var3;
                  this.mManager.addFragment(var9, false);
               }
               break;
            case 3:
               var11 = var8.fragment;
               var11.mNextAnim = var4;
               this.mManager.removeFragment(var11, var2, var1);
               break;
            case 4:
               var11 = var8.fragment;
               var11.mNextAnim = var4;
               this.mManager.hideFragment(var11, var2, var1);
               break;
            case 5:
               var11 = var8.fragment;
               var11.mNextAnim = var3;
               this.mManager.showFragment(var11, var2, var1);
               break;
            case 6:
               var11 = var8.fragment;
               var11.mNextAnim = var4;
               this.mManager.detachFragment(var11, var2, var1);
               break;
            case 7:
               var11 = var8.fragment;
               var11.mNextAnim = var3;
               this.mManager.attachFragment(var11, var2, var1);
               break;
            default:
               throw new IllegalArgumentException("Unknown cmd: " + var8.cmd);
            }
         }

         this.mManager.moveToState(this.mManager.mCurState, var2, var1, true);
         if(this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
         }

      }
   }

   public FragmentTransaction setBreadCrumbShortTitle(int var1) {
      this.mBreadCrumbShortTitleRes = var1;
      this.mBreadCrumbShortTitleText = null;
      return this;
   }

   public FragmentTransaction setBreadCrumbShortTitle(CharSequence var1) {
      this.mBreadCrumbShortTitleRes = 0;
      this.mBreadCrumbShortTitleText = var1;
      return this;
   }

   public FragmentTransaction setBreadCrumbTitle(int var1) {
      this.mBreadCrumbTitleRes = var1;
      this.mBreadCrumbTitleText = null;
      return this;
   }

   public FragmentTransaction setBreadCrumbTitle(CharSequence var1) {
      this.mBreadCrumbTitleRes = 0;
      this.mBreadCrumbTitleText = var1;
      return this;
   }

   public FragmentTransaction setCustomAnimations(int var1, int var2) {
      return this.setCustomAnimations(var1, var2, 0, 0);
   }

   public FragmentTransaction setCustomAnimations(int var1, int var2, int var3, int var4) {
      this.mEnterAnim = var1;
      this.mExitAnim = var2;
      this.mPopEnterAnim = var3;
      this.mPopExitAnim = var4;
      return this;
   }

   public FragmentTransaction setTransition(int var1) {
      this.mTransition = var1;
      return this;
   }

   public FragmentTransaction setTransitionStyle(int var1) {
      this.mTransitionStyle = var1;
      return this;
   }

   public FragmentTransaction show(Fragment var1) {
      BackStackRecord.Op var2 = new BackStackRecord.Op();
      var2.cmd = 5;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("BackStackEntry{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      if(this.mIndex >= 0) {
         var1.append(" #");
         var1.append(this.mIndex);
      }

      if(this.mName != null) {
         var1.append(" ");
         var1.append(this.mName);
      }

      var1.append("}");
      return var1.toString();
   }

   static final class Op {
      int cmd;
      int enterAnim;
      int exitAnim;
      Fragment fragment;
      BackStackRecord.Op next;
      int popEnterAnim;
      int popExitAnim;
      BackStackRecord.Op prev;
      ArrayList removed;
   }

   public class TransitionState {
      public FragmentTransitionCompat21.EpicenterView enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();
      public ArrayList hiddenFragmentViews = new ArrayList();
      public ArrayMap nameOverrides = new ArrayMap();
      public View nonExistentView;
   }
}
