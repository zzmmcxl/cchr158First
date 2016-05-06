package android.support.v4.app;

public static class BigTextStyle extends Style
{
    CharSequence mBigText;
    
    public BigTextStyle() {
        super();
    }
    
    public BigTextStyle(final NotificationCompat.Builder builder) {
        super();
        ((Style)this).setBuilder(builder);
    }
    
    public BigTextStyle bigText(final CharSequence charSequence) {
        mBigText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }
    
    public BigTextStyle setBigContentTitle(final CharSequence charSequence) {
        this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }
    
    public BigTextStyle setSummaryText(final CharSequence charSequence) {
        this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}
