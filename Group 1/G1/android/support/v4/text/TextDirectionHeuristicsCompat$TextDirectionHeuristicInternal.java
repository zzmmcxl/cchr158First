package android.support.v4.text;

private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl
{
    private final boolean mDefaultIsRtl;
    
    private TextDirectionHeuristicInternal(final TextDirectionAlgorithm textDirectionAlgorithm, final boolean mDefaultIsRtl) {
        super(textDirectionAlgorithm);
        this.mDefaultIsRtl = mDefaultIsRtl;
    }
    
    TextDirectionHeuristicInternal(final TextDirectionAlgorithm textDirectionAlgorithm, final boolean b, final TextDirectionHeuristicsCompat$1 object) {
        this(textDirectionAlgorithm, b);
    }
    
    @Override
    protected boolean defaultIsRtl() {
        return mDefaultIsRtl;
    }
}
