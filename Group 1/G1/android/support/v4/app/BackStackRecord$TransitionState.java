package android.support.v4.app;

import android.support.v4.util.ArrayMap;
import android.view.View;
import java.util.ArrayList;

public class TransitionState
{
    public FragmentTransitionCompat21.EpicenterView enteringEpicenterView;
    public ArrayList<View> hiddenFragmentViews;
    public ArrayMap<String, String> nameOverrides;
    public View nonExistentView;
    final /* synthetic */ BackStackRecord this$0;
    
    public TransitionState(final BackStackRecord this$0) {
        this$0 = this$0;
        super();
        nameOverrides = new ArrayMap<String, String>();
        hiddenFragmentViews = new ArrayList<View>();
        enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();
    }
}
