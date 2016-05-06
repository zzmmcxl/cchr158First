package android.support.v4.app;

import java.util.ArrayList;
import java.util.List;
import android.app.PendingIntent;

public static class UnreadConversation extends NotificationCompatBase.UnreadConversation
{
    static final Factory FACTORY;
    private final long mLatestTimestamp;
    private final String[] mMessages;
    private final String[] mParticipants;
    private final PendingIntent mReadPendingIntent;
    private final RemoteInput mRemoteInput;
    private final PendingIntent mReplyPendingIntent;
    
    static {
        FACTORY = new Factory() {
            NotificationCompat$CarExtender$UnreadConversation$1() {
                super();
            }
            
            public CarExtender.UnreadConversation build(final String[] array, final RemoteInputCompatBase.RemoteInput remoteInput, final PendingIntent pendingIntent, final PendingIntent pendingIntent2, final String[] array2, final long n) {
                return new CarExtender.UnreadConversation(array, (RemoteInput)remoteInput, pendingIntent, pendingIntent2, array2, n);
            }
            
            @Override
            public /* bridge */ NotificationCompatBase.UnreadConversation build(final String[] array, final RemoteInputCompatBase.RemoteInput remoteInput, final PendingIntent pendingIntent, final PendingIntent pendingIntent2, final String[] array2, final long n) {
                return this.build(array, remoteInput, pendingIntent, pendingIntent2, array2, n);
            }
        };
    }
    
    UnreadConversation(final String[] mMessages, final RemoteInput mRemoteInput, final PendingIntent mReplyPendingIntent, final PendingIntent mReadPendingIntent, final String[] mParticipants, final long mLatestTimestamp) {
        super();
        this.mMessages = mMessages;
        this.mRemoteInput = mRemoteInput;
        this.mReadPendingIntent = mReadPendingIntent;
        this.mReplyPendingIntent = mReplyPendingIntent;
        this.mParticipants = mParticipants;
        this.mLatestTimestamp = mLatestTimestamp;
    }
    
    public long getLatestTimestamp() {
        return mLatestTimestamp;
    }
    
    public String[] getMessages() {
        return mMessages;
    }
    
    public String getParticipant() {
        if (mParticipants.length > 0) {
            return mParticipants[0];
        }
        return null;
    }
    
    public String[] getParticipants() {
        return mParticipants;
    }
    
    public PendingIntent getReadPendingIntent() {
        return mReadPendingIntent;
    }
    
    public RemoteInput getRemoteInput() {
        return mRemoteInput;
    }
    
    public /* bridge */ RemoteInputCompatBase.RemoteInput getRemoteInput() {
        return this.getRemoteInput();
    }
    
    public PendingIntent getReplyPendingIntent() {
        return mReplyPendingIntent;
    }
}
