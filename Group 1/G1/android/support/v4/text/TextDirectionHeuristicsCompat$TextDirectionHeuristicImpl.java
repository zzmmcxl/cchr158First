package android.support.v4.text;

import java.nio.CharBuffer;

private abstract static class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat
{
    private final TextDirectionAlgorithm mAlgorithm;
    
    public TextDirectionHeuristicImpl(final TextDirectionAlgorithm mAlgorithm) {
        super();
        this.mAlgorithm = mAlgorithm;
    }
    
    private boolean doCheck(final CharSequence charSequence, final int n, final int n2) {
        switch (mAlgorithm.checkRtl(charSequence, n, n2)) {
            default:
                return this.defaultIsRtl();
            case 0:
                return true;
            case 1:
                return false;
        }
    }
    
    protected abstract boolean defaultIsRtl();
    
    @Override
    public boolean isRtl(final CharSequence charSequence, final int n, final int n2) {
        if (charSequence == null || n < 0 || n2 < 0 || charSequence.length() - n2 < n) {
            throw new IllegalArgumentException();
        }
        if (mAlgorithm == null) {
            return this.defaultIsRtl();
        }
        return this.doCheck(charSequence, n, n2);
    }
    
    @Override
    public boolean isRtl(final char[] array, final int n, final int n2) {
        return this.isRtl(CharBuffer.wrap(array), n, n2);
    }
}
