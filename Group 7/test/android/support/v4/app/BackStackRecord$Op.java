package android.support.v4.app;

import android.support.v4.app.Fragment;
import java.util.ArrayList;

final class BackStackRecord$Op {
   int cmd;
   int enterAnim;
   int exitAnim;
   Fragment fragment;
   BackStackRecord$Op next;
   int popEnterAnim;
   int popExitAnim;
   BackStackRecord$Op prev;
   ArrayList<Fragment> removed;
}
