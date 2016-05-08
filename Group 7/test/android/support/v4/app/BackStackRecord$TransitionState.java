package android.support.v4.app;

import android.support.v4.app.BackStackRecord;
import android.support.v4.app.FragmentTransitionCompat21$EpicenterView;
import android.support.v4.util.ArrayMap;
import android.view.View;
import java.util.ArrayList;

public class BackStackRecord$TransitionState {
   public FragmentTransitionCompat21$EpicenterView enteringEpicenterView;
   public ArrayList<View> hiddenFragmentViews;
   public ArrayMap<String, String> nameOverrides;
   public View nonExistentView;

   public BackStackRecord$TransitionState(BackStackRecord var1) {
      this.this$0 = var1;
      this.nameOverrides = new ArrayMap();
      this.hiddenFragmentViews = new ArrayList();
      this.enteringEpicenterView = new FragmentTransitionCompat21$EpicenterView();
   }
}
