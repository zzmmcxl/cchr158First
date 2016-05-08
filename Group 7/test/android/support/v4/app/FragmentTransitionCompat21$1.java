package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class FragmentTransitionCompat21$1 extends EpicenterCallback {
   FragmentTransitionCompat21$1(Rect var1) {
      this.val$epicenter = var1;
   }

   public Rect onGetEpicenter(Transition var1) {
      return this.val$epicenter;
   }
}
