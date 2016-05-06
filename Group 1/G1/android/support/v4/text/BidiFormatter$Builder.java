package android.support.v4.text;

import java.util.Locale;

public static final class Builder
{
    private int mFlags;
    private boolean mIsRtlContext;
    private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
    
    public Builder() {
        super();
        this.initialize(BidiFormatter.access$000(Locale.getDefault()));
    }
    
    public Builder(final Locale locale) {
        super();
        this.initialize(BidiFormatter.access$000(locale));
    }
    
    public Builder(final boolean b) {
        super();
        this.initialize(b);
    }
    
    private static BidiFormatter getDefaultInstanceFromContext(final boolean b) {
        if (b) {
            return BidiFormatter.access$200();
        }
        return BidiFormatter.access$300();
    }
    
    private void initialize(final boolean mIsRtlContext) {
        this.mIsRtlContext = mIsRtlContext;
        mTextDirectionHeuristicCompat = BidiFormatter.access$100();
        mFlags = 2;
    }
    
    public BidiFormatter build() {
        if (mFlags == 2 && mTextDirectionHeuristicCompat == BidiFormatter.access$100()) {
            return getDefaultInstanceFromContext(mIsRtlContext);
        }
        return new BidiFormatter(mIsRtlContext, mFlags, mTextDirectionHeuristicCompat, null);
    }
    
    public Builder setTextDirectionHeuristic(final TextDirectionHeuristicCompat mTextDirectionHeuristicCompat) {
        this.mTextDirectionHeuristicCompat = mTextDirectionHeuristicCompat;
        return this;
    }
    
    public Builder stereoReset(final boolean b) {
        if (b) {
            mFlags |= 0x2;
            return this;
        }
        mFlags &= 0xFFFFFFFD;
        return this;
    }
}
