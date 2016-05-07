/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.app.av;
import android.support.v4.app.aw;
import android.support.v4.app.ax;
import android.support.v4.app.ay;
import android.support.v4.app.az;
import android.support.v4.app.ba;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class au {
    public static Object a(Object object) {
        if (object == null) return object;
        return ((Transition)object).clone();
    }

    public static Object a(Object object, View view, ArrayList arrayList, Map map, View view2) {
        if (object == null) return object;
        au.b(arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        au.b((Object)((Transition)object), arrayList);
        return object;
    }

    public static Object a(Object object, Object object2, Object object3, boolean bl2) {
        Transition transition;
        Transition transition2 = (Transition)object;
        Transition transition3 = (Transition)object2;
        Transition transition4 = (Transition)object3;
        if (transition2 == null || transition3 == null) {
            bl2 = true;
        }
        if (bl2) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
            }
            if (transition4 == null) return transitionSet;
            transitionSet.addTransition(transition4);
            return transitionSet;
        }
        if (transition3 != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition3).addTransition(transition2).setOrdering(1);
        } else if (transition3 != null) {
            transition = transition3;
        } else {
            transition = null;
            if (transition2 != null) {
                transition = transition2;
            }
        }
        if (transition4 == null) return transition;
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition4);
        return transitionSet;
    }

    public static String a(View view) {
        return view.getTransitionName();
    }

    private static void a(Transition transition, az az2) {
        if (transition == null) return;
        transition.setEpicenterCallback((Transition.EpicenterCallback)new ax(az2));
    }

    public static void a(View view, View view2, Object object, ArrayList arrayList, Object object2, ArrayList arrayList2, Object object3, ArrayList arrayList3, Object object4, ArrayList arrayList4, Map map) {
        Transition transition = (Transition)object;
        Transition transition2 = (Transition)object2;
        Transition transition3 = (Transition)object3;
        Transition transition4 = (Transition)object4;
        if (transition4 == null) return;
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new ay(view, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view2));
    }

    public static void a(ViewGroup viewGroup, Object object) {
        TransitionManager.beginDelayedTransition((ViewGroup)viewGroup, (Transition)((Transition)object));
    }

    public static void a(Object object, View view) {
        ((Transition)object).setEpicenterCallback((Transition.EpicenterCallback)new av(au.c(view)));
    }

    public static void a(Object object, View view, Map map, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet)object;
        arrayList.clear();
        arrayList.addAll(map.values());
        List list = transitionSet.getTargets();
        list.clear();
        int n2 = arrayList.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                arrayList.add(view);
                au.b((Object)transitionSet, arrayList);
                return;
            }
            au.a(list, (View)arrayList.get(n3));
            ++n3;
        } while (true);
    }

    public static void a(Object object, View view, boolean bl2) {
        ((Transition)object).excludeTarget(view, bl2);
    }

    public static void a(Object object, Object object2, View view, ba ba2, View view2, az az2, Map map, ArrayList arrayList, Map map2, Map map3, ArrayList arrayList2) {
        Transition transition;
        if (object == null) {
            if (object2 == null) return;
        }
        if ((transition = (Transition)object) != null) {
            transition.addTarget(view2);
        }
        if (object2 != null) {
            au.a(object2, view2, map2, arrayList2);
        }
        if (ba2 != null) {
            view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new aw(view, transition, view2, ba2, map, map3, arrayList));
        }
        au.a(transition, az2);
    }

    public static void a(Object object, ArrayList arrayList) {
        Transition transition = (Transition)object;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet)transition;
            int n2 = transitionSet.getTransitionCount();
            int n3 = 0;
            while (n3 < n2) {
                au.a((Object)transitionSet.getTransitionAt(n3), arrayList);
                ++n3;
            }
            return;
        }
        if (au.a(transition)) return;
        List list = transition.getTargets();
        if (list == null) return;
        if (list.size() != arrayList.size()) return;
        if (!list.containsAll(arrayList)) return;
        int n4 = -1 + arrayList.size();
        while (n4 >= 0) {
            transition.removeTarget((View)arrayList.get(n4));
            --n4;
        }
    }

    static /* synthetic */ void a(ArrayList arrayList, View view) {
        au.b(arrayList, view);
    }

    private static void a(List list, View view) {
        int n2 = list.size();
        if (au.a(list, view, n2)) {
            return;
        }
        list.add(view);
        int n3 = n2;
        while (n3 < list.size()) {
            View view2 = (View)list.get(n3);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup)view2;
                int n4 = viewGroup.getChildCount();
                for (int i2 = 0; i2 < n4; ++i2) {
                    View view3 = viewGroup.getChildAt(i2);
                    if (au.a(list, view3, n2)) continue;
                    list.add(view3);
                }
            }
            ++n3;
        }
    }

    public static void a(Map map, View view) {
        if (view.getVisibility() != 0) return;
        String string = view.getTransitionName();
        if (string != null) {
            map.put(string, view);
        }
        if (!(view instanceof ViewGroup)) return;
        ViewGroup viewGroup = (ViewGroup)view;
        int n2 = viewGroup.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            au.a(map, viewGroup.getChildAt(n3));
            ++n3;
        }
    }

    private static boolean a(Transition transition) {
        if (!au.a(transition.getTargetIds())) return true;
        if (!au.a(transition.getTargetNames())) return true;
        if (au.a(transition.getTargetTypes())) return false;
        return true;
    }

    private static boolean a(List list) {
        if (list == null) return true;
        if (!list.isEmpty()) return false;
        return true;
    }

    private static boolean a(List list, View view, int n2) {
        int n3 = 0;
        do {
            boolean bl2 = false;
            if (n3 >= n2) return bl2;
            if (list.get(n3) == view) {
                return true;
            }
            ++n3;
        } while (true);
    }

    static /* synthetic */ Rect b(View view) {
        return au.c(view);
    }

    public static Object b(Object object) {
        if (object == null) {
            return null;
        }
        Transition transition = (Transition)object;
        if (transition == null) return null;
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }

    public static void b(Object object, ArrayList arrayList) {
        int n2 = 0;
        Transition transition = (Transition)object;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet)transition;
            int n3 = transitionSet.getTransitionCount();
            while (n2 < n3) {
                au.b((Object)transitionSet.getTransitionAt(n2), arrayList);
                ++n2;
            }
            return;
        }
        if (au.a(transition)) return;
        if (!au.a(transition.getTargets())) return;
        int n4 = arrayList.size();
        int n5 = 0;
        while (n5 < n4) {
            transition.addTarget((View)arrayList.get(n5));
            ++n5;
        }
    }

    private static void b(ArrayList arrayList, View view) {
        if (view.getVisibility() != 0) return;
        if (!(view instanceof ViewGroup)) {
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup)view;
        if (viewGroup.isTransitionGroup()) {
            arrayList.add(viewGroup);
            return;
        }
        int n2 = viewGroup.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            au.b(arrayList, viewGroup.getChildAt(n3));
            ++n3;
        }
    }

    private static Rect c(View view) {
        Rect rect = new Rect();
        int[] arrn = new int[2];
        view.getLocationOnScreen(arrn);
        rect.set(arrn[0], arrn[1], arrn[0] + view.getWidth(), arrn[1] + view.getHeight());
        return rect;
    }
}

