package android.support.v4.app;

import java.util.ArrayList;

public static class InboxStyle extends Style
{
    ArrayList<CharSequence> mTexts;
    
    public InboxStyle() {
        super();
        this.mTexts = new ArrayList<CharSequence>();
    }
    
    public InboxStyle(final NotificationCompat.Builder builder) {
        super();
        this.mTexts = new ArrayList<CharSequence>();
        ((Style)this).setBuilder(builder);
    }
    
    public InboxStyle addLine(final CharSequence charSequence) {
        mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(charSequence));
        return this;
    }
    
    public InboxStyle setBigContentTitle(final CharSequence charSequence) {
        this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }
    
    public InboxStyle setSummaryText(final CharSequence charSequence) {
        this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}
