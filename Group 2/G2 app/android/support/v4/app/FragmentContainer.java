package android.support.v4.app;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

interface FragmentContainer {
   @Nullable
   View findViewById(@IdRes int var1);

   boolean hasView();
}
