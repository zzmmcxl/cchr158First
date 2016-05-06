package android.support.v4.app;

import java.util.ArrayList;
import android.app.PendingIntent;
import java.util.List;

public static class Builder
{
    private long mLatestTimestamp;
    private final List<String> mMessages;
    private final String mParticipant;
    private PendingIntent mReadPendingIntent;
    private RemoteInput mRemoteInput;
    private PendingIntent mReplyPendingIntent;
    
    public Builder(final String mParticipant) {
        super();
        this.mMessages = new ArrayList<String>();
        this.mParticipant = mParticipant;
    }
    
    public Builder addMessage(final String s) {
        mMessages.add(s);
        return this;
    }
    
    public UnreadConversation build() {
        return new UnreadConversation(mMessages.<String>toArray(new String[mMessages.size()]), mRemoteInput, mReplyPendingIntent, mReadPendingIntent, new String[] { mParticipant }, mLatestTimestamp);
    }
    
    public Builder setLatestTimestamp(final long mLatestTimestamp) {
        this.mLatestTimestamp = mLatestTimestamp;
        return this;
    }
    
    public Builder setReadPendingIntent(final PendingIntent mReadPendingIntent) {
        this.mReadPendingIntent = mReadPendingIntent;
        return this;
    }
    
    public Builder setReplyAction(final PendingIntent mReplyPendingIntent, final RemoteInput mRemoteInput) {
        this.mRemoteInput = mRemoteInput;
        this.mReplyPendingIntent = mReplyPendingIntent;
        return this;
    }
}
