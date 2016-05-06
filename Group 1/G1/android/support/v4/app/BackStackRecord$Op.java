package android.support.v4.app;

import java.util.ArrayList;

static final class Op
{
    int cmd;
    int enterAnim;
    int exitAnim;
    Fragment fragment;
    Op next;
    int popEnterAnim;
    int popExitAnim;
    Op prev;
    ArrayList<Fragment> removed;
    
    Op() {
        super();
    }
}
