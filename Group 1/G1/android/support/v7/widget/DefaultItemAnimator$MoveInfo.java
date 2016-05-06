package android.support.v7.widget;

private static class MoveInfo
{
    public int fromX;
    public int fromY;
    public ViewHolder holder;
    public int toX;
    public int toY;
    
    private MoveInfo(final ViewHolder holder, final int fromX, final int fromY, final int toX, final int toY) {
        super();
        this.holder = holder;
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }
    
    MoveInfo(final ViewHolder viewHolder, final int n, final int n2, final int n3, final int n4, final DefaultItemAnimator$1 runnable) {
        this(viewHolder, n, n2, n3, n4);
    }
}
