package android.support.v4.net;

private static class SocketTags
{
    public int statsTag;
    
    private SocketTags() {
        super();
        this.statsTag = -1;
    }
    
    SocketTags(final TrafficStatsCompat$1 object) {
        this();
    }
}
