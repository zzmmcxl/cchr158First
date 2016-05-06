package android.support.v4.view;

import android.widget.TextView;

static class PagerTitleStripImplIcs implements PagerTitleStripImpl
{
    PagerTitleStripImplIcs() {
        super();
    }
    
    @Override
    public void setSingleLineAllCaps(final TextView singleLineAllCaps) {
        PagerTitleStripIcs.setSingleLineAllCaps(singleLineAllCaps);
    }
}
