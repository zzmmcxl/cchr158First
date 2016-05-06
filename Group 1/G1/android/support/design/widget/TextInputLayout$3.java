package android.support.design.widget;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class TextInputLayout$3 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ TextInputLayout this$0;
    final /* synthetic */ CharSequence val$error;
    
    TextInputLayout$3(final TextInputLayout this$0, final CharSequence val$error) {
        this$0 = this$0;
        val$error = val$error;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        TextInputLayout.access$400(this$0).setText(val$error);
        view.setVisibility(4);
    }
}