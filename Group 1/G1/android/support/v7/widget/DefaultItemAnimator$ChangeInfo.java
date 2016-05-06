package android.support.v7.widget;

private static class ChangeInfo
{
    public int fromX;
    public int fromY;
    public ViewHolder newHolder;
    public ViewHolder oldHolder;
    public int toX;
    public int toY;
    
    private ChangeInfo(final ViewHolder oldHolder, final ViewHolder newHolder) {
        super();
        this.oldHolder = oldHolder;
        this.newHolder = newHolder;
    }
    
    private ChangeInfo(final ViewHolder viewHolder, final ViewHolder viewHolder2, final int fromX, final int fromY, final int toX, final int toY) {
        this(viewHolder, viewHolder2);
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }
    
    ChangeInfo(final ViewHolder viewHolder, final ViewHolder viewHolder2, final int n, final int n2, final int n3, final int n4, final DefaultItemAnimator$1 runnable) {
        this(viewHolder, viewHolder2, n, n2, n3, n4);
    }
    
    @Override
    public String toString() {
        return "ChangeInfo{oldHolder=" + oldHolder + ", newHolder=" + newHolder + ", fromX=" + fromX + ", fromY=" + fromY + ", toX=" + toX + ", toY=" + toY + '}';
    }
}
