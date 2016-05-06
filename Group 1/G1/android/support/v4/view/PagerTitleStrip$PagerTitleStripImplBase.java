package android.support.v4.view;

import android.widget.TextView;

static class PagerTitleStripImplBase implements PagerTitleStripImpl
{
    PagerTitleStripImplBase() {
        super();
    }
    
    @Override
    public void setSingleLineAllCaps(final TextView textView) {
        textView.setSingleLine();
    }
}
