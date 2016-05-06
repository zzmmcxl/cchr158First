package android.support.v4.app;

import android.app.PendingIntent;

public abstract static class UnreadConversation
{
    public UnreadConversation() {
        super();
    }
    
    abstract long getLatestTimestamp();
    
    abstract String[] getMessages();
    
    abstract String getParticipant();
    
    abstract String[] getParticipants();
    
    abstract PendingIntent getReadPendingIntent();
    
    abstract RemoteInputCompatBase.RemoteInput getRemoteInput();
    
    abstract PendingIntent getReplyPendingIntent();
}
