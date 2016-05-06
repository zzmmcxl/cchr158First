package android.support.v4.text;

private static class AnyStrong implements TextDirectionAlgorithm
{
    public static final AnyStrong INSTANCE_LTR;
    public static final AnyStrong INSTANCE_RTL;
    private final boolean mLookForRtl;
    
    static {
        INSTANCE_RTL = new AnyStrong(true);
        INSTANCE_LTR = new AnyStrong(false);
    }
    
    private AnyStrong(final boolean mLookForRtl) {
        super();
        this.mLookForRtl = mLookForRtl;
    }
    
    @Override
    public int checkRtl(final CharSequence charSequence, final int n, final int n2) {
        boolean b = true;
        boolean b2 = false;
        for (int i = n; i < n + n2; ++i) {
            switch (TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(charSequence.charAt(i)))) {
                case 0:
                    if (mLookForRtl) {
                        b = false;
                        return b ? 1 : 0;
                    }
                    b2 = true;
                    break;
                case 1:
                    if (mLookForRtl) {
                        b2 = true;
                        break;
                    }
                    return b ? 1 : 0;
            }
        }
        if (!b2) {
            return 2;
        }
        if (!mLookForRtl) {
            return 0;
        }
        return b ? 1 : 0;
    }
}
