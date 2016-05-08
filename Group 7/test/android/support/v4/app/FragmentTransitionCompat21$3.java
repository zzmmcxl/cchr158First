package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.app.FragmentTransitionCompat21;
import android.support.v4.app.FragmentTransitionCompat21$EpicenterView;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class FragmentTransitionCompat21$3 extends EpicenterCallback {
   private Rect mEpicenter;

   FragmentTransitionCompat21$3(FragmentTransitionCompat21$EpicenterView var1) {
      this.val$epicenterView = var1;
   }

   public Rect onGetEpicenter(Transition var1) {
      if(this.mEpicenter == null && this.val$epicenterView.epicenter != null) {
         this.mEpicenter = FragmentTransitionCompat21.access$100(this.val$epicenterView.epicenter);
      }

      return this.mEpicenter;
   }
}
