package android.support.v4.content;

import android.content.Intent;

static class IntentCompatImplIcsMr1 extends IntentCompatImplHC
{
    IntentCompatImplIcsMr1() {
        super();
    }
    
    @Override
    public Intent makeMainSelectorActivity(final String s, final String s2) {
        return IntentCompatIcsMr1.makeMainSelectorActivity(s, s2);
    }
}
