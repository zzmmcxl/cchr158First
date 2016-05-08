package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.app.FragmentTransitionCompat21$1;
import android.support.v4.app.FragmentTransitionCompat21$2;
import android.support.v4.app.FragmentTransitionCompat21$3;
import android.support.v4.app.FragmentTransitionCompat21$4;
import android.support.v4.app.FragmentTransitionCompat21$EpicenterView;
import android.support.v4.app.FragmentTransitionCompat21$ViewRetriever;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class FragmentTransitionCompat21 {
   public static void addTargets(Object var0, ArrayList<View> var1) {
      Transition var4 = (Transition)var0;
      int var2;
      int var3;
      if(var4 instanceof TransitionSet) {
         TransitionSet var5 = (TransitionSet)var4;
         var3 = var5.getTransitionCount();

         for(var2 = 0; var2 < var3; ++var2) {
            addTargets(var5.getTransitionAt(var2), var1);
         }
      } else if(!hasSimpleTarget(var4) && isNullOrEmpty(var4.getTargets())) {
         var3 = var1.size();

         for(var2 = 0; var2 < var3; ++var2) {
            var4.addTarget((View)var1.get(var2));
         }
      }

   }

   public static void addTransitionTargets(Object var0, Object var1, View var2, FragmentTransitionCompat21$ViewRetriever var3, View var4, FragmentTransitionCompat21$EpicenterView var5, Map<String, String> var6, ArrayList<View> var7, Map<String, View> var8, Map<String, View> var9, ArrayList<View> var10) {
      if(var0 != null || var1 != null) {
         Transition var11 = (Transition)var0;
         if(var11 != null) {
            var11.addTarget(var4);
         }

         if(var1 != null) {
            setSharedElementTargets(var1, var4, var8, var10);
         }

         if(var3 != null) {
            var2.getViewTreeObserver().addOnPreDrawListener(new FragmentTransitionCompat21$2(var2, var11, var4, var3, var6, var9, var7));
         }

         setSharedElementEpicenter(var11, var5);
      }

   }

   public static void beginDelayedTransition(ViewGroup var0, Object var1) {
      TransitionManager.beginDelayedTransition(var0, (Transition)var1);
   }

   private static void bfsAddViewChildren(List<View> var0, View var1) {
      int var4 = var0.size();
      if(!containedBeforeIndex(var0, var1, var4)) {
         var0.add(var1);

         for(int var2 = var4; var2 < var0.size(); ++var2) {
            var1 = (View)var0.get(var2);
            if(var1 instanceof ViewGroup) {
               ViewGroup var7 = (ViewGroup)var1;
               int var5 = var7.getChildCount();

               for(int var3 = 0; var3 < var5; ++var3) {
                  View var6 = var7.getChildAt(var3);
                  if(!containedBeforeIndex(var0, var6, var4)) {
                     var0.add(var6);
                  }
               }
            }
         }
      }

   }

   public static Object captureExitingViews(Object var0, View var1, ArrayList<View> var2, Map<String, View> var3, View var4) {
      Object var5 = var0;
      if(var0 != null) {
         captureTransitioningViews(var2, var1);
         if(var3 != null) {
            var2.removeAll(var3.values());
         }

         if(!var2.isEmpty()) {
            var2.add(var4);
            addTargets((Transition)var0, var2);
            return var0;
         }

         var5 = null;
      }

      return var5;
   }

   private static void captureTransitioningViews(ArrayList<View> var0, View var1) {
      if(var1.getVisibility() == 0) {
         if(!(var1 instanceof ViewGroup)) {
            var0.add(var1);
            return;
         }

         ViewGroup var4 = (ViewGroup)var1;
         if(var4.isTransitionGroup()) {
            var0.add(var4);
         } else {
            int var3 = var4.getChildCount();

            for(int var2 = 0; var2 < var3; ++var2) {
               captureTransitioningViews(var0, var4.getChildAt(var2));
            }
         }
      }

   }

   public static void cleanupTransitions(View var0, View var1, Object var2, ArrayList<View> var3, Object var4, ArrayList<View> var5, Object var6, ArrayList<View> var7, Object var8, ArrayList<View> var9, Map<String, View> var10) {
      Transition var11 = (Transition)var2;
      Transition var12 = (Transition)var4;
      Transition var13 = (Transition)var6;
      Transition var14 = (Transition)var8;
      if(var14 != null) {
         var0.getViewTreeObserver().addOnPreDrawListener(new FragmentTransitionCompat21$4(var0, var11, var3, var12, var5, var13, var7, var10, var9, var14, var1));
      }

   }

   public static Object cloneTransition(Object var0) {
      Object var1 = var0;
      if(var0 != null) {
         var1 = ((Transition)var0).clone();
      }

      return var1;
   }

   private static boolean containedBeforeIndex(List<View> var0, View var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         if(var0.get(var3) == var1) {
            return true;
         }
      }

      return false;
   }

   public static void excludeTarget(Object var0, View var1, boolean var2) {
      ((Transition)var0).excludeTarget(var1, var2);
   }

   public static void findNamedViews(Map<String, View> var0, View var1) {
      if(var1.getVisibility() == 0) {
         String var4 = var1.getTransitionName();
         if(var4 != null) {
            var0.put(var4, var1);
         }

         if(var1 instanceof ViewGroup) {
            ViewGroup var5 = (ViewGroup)var1;
            int var3 = var5.getChildCount();

            for(int var2 = 0; var2 < var3; ++var2) {
               findNamedViews(var0, var5.getChildAt(var2));
            }
         }
      }

   }

   private static Rect getBoundsOnScreen(View var0) {
      Rect var1 = new Rect();
      int[] var2 = new int[2];
      var0.getLocationOnScreen(var2);
      var1.set(var2[0], var2[1], var2[0] + var0.getWidth(), var2[1] + var0.getHeight());
      return var1;
   }

   public static String getTransitionName(View var0) {
      return var0.getTransitionName();
   }

   private static boolean hasSimpleTarget(Transition var0) {
      return !isNullOrEmpty(var0.getTargetIds()) || !isNullOrEmpty(var0.getTargetNames()) || !isNullOrEmpty(var0.getTargetTypes());
   }

   private static boolean isNullOrEmpty(List var0) {
      return var0 == null || var0.isEmpty();
   }

   public static Object mergeTransitions(Object var0, Object var1, Object var2, boolean var3) {
      boolean var5 = true;
      Transition var6 = (Transition)var0;
      var0 = (Transition)var1;
      Transition var8 = (Transition)var2;
      boolean var4 = var5;
      if(var6 != null) {
         var4 = var5;
         if(var0 != null) {
            var4 = var3;
         }
      }

      TransitionSet var7;
      if(var4) {
         var7 = new TransitionSet();
         if(var6 != null) {
            var7.addTransition(var6);
         }

         if(var0 != null) {
            var7.addTransition((Transition)var0);
         }

         if(var8 != null) {
            var7.addTransition(var8);
         }

         return var7;
      } else {
         var1 = null;
         if(var0 != null && var6 != null) {
            var0 = (new TransitionSet()).addTransition((Transition)var0).addTransition(var6).setOrdering(1);
         } else if(var0 == null) {
            var0 = var1;
            if(var6 != null) {
               var0 = var6;
            }
         }

         if(var8 != null) {
            var7 = new TransitionSet();
            if(var0 != null) {
               var7.addTransition((Transition)var0);
            }

            var7.addTransition(var8);
            return var7;
         } else {
            return var0;
         }
      }
   }

   public static void removeTargets(Object var0, ArrayList<View> var1) {
      Transition var5 = (Transition)var0;
      int var2;
      if(var5 instanceof TransitionSet) {
         TransitionSet var6 = (TransitionSet)var5;
         int var3 = var6.getTransitionCount();

         for(var2 = 0; var2 < var3; ++var2) {
            removeTargets(var6.getTransitionAt(var2), var1);
         }
      } else if(!hasSimpleTarget(var5)) {
         List var4 = var5.getTargets();
         if(var4 != null && var4.size() == var1.size() && var4.containsAll(var1)) {
            for(var2 = var1.size() - 1; var2 >= 0; --var2) {
               var5.removeTarget((View)var1.get(var2));
            }
         }
      }

   }

   public static void setEpicenter(Object var0, View var1) {
      ((Transition)var0).setEpicenterCallback(new FragmentTransitionCompat21$1(getBoundsOnScreen(var1)));
   }

   private static void setSharedElementEpicenter(Transition var0, FragmentTransitionCompat21$EpicenterView var1) {
      if(var0 != null) {
         var0.setEpicenterCallback(new FragmentTransitionCompat21$3(var1));
      }

   }

   public static void setSharedElementTargets(Object var0, View var1, Map<String, View> var2, ArrayList<View> var3) {
      TransitionSet var6 = (TransitionSet)var0;
      var3.clear();
      var3.addAll(var2.values());
      List var7 = var6.getTargets();
      var7.clear();
      int var5 = var3.size();

      for(int var4 = 0; var4 < var5; ++var4) {
         bfsAddViewChildren(var7, (View)var3.get(var4));
      }

      var3.add(var1);
      addTargets(var6, var3);
   }

   public static Object wrapSharedElementTransition(Object var0) {
      if(var0 != null) {
         Transition var2 = (Transition)var0;
         if(var2 != null) {
            TransitionSet var1 = new TransitionSet();
            var1.addTransition(var2);
            return var1;
         }
      }

      return null;
   }
}
