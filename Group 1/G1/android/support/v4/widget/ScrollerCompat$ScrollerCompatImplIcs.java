package android.support.v4.widget;

static class ScrollerCompatImplIcs extends ScrollerCompatImplGingerbread
{
    ScrollerCompatImplIcs() {
        super();
    }
    
    @Override
    public float getCurrVelocity(final Object o) {
        return ScrollerCompatIcs.getCurrVelocity(o);
    }
}
